package de.lxca1909.ffaplugin.kits.telekinese.utils;

import com.google.common.util.concurrent.AtomicDouble;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import de.lxca1909.ffaplugin.Main;
import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class UseListener implements Listener {
    private ItemStack almightyHandItem = ItemDb.getItem();

    private Map<String, TelekinesisProcess> telekinesisProcessMap = new HashMap<>();

    @EventHandler
    public void onItemUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().getType() == Material.FEATHER || player.getInventory().getItemInOffHand().getType() == Material.FEATHER) {
            if (!Kits.TelekineseKit.contains(event.getPlayer().getName())) return;
            if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK && player.getInventory().getItemInMainHand().getType() != Material.AIR)return;
            if (checkAlmightyHandEvent(event)) return;
            String requiredPermission = Permissions.forAlmightyHandUse();
            if (endTelekinesis(player, "&7Telekinese wurde beendet&7."))
                return;
            LivingEntity target = LocationUtil.getEntityInLineOfSight((LivingEntity) player, 12.0D);
            if (target == null)
                return;
            player.setVelocity(new Vector(0, 0.75, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 40 ,0));
            startTelekinesisThroughAlmightyHand(player, target);
            event.setCancelled(true);
        }
    }

    private boolean checkAlmightyHandEvent(PlayerInteractEvent event) {
        switch (event.getAction()) {
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                break;
            default:
                return false;
        }
        if (event.getHand() != EquipmentSlot.HAND)
            return false;
        Player player = event.getPlayer();
        return player.getInventory().getItemInMainHand().isSimilar(this.almightyHandItem);
    }

    private boolean endTelekinesis(Player player, String endingMsgWithRawColor) {
        String playerName = player.getName();
        TelekinesisProcess process = this.telekinesisProcessMap.get(playerName);
        if (process == null)
            return false;
        TaskHolder taskHolder = process.taskHolder;
        taskHolder.bukkitTask.cancel();
        this.telekinesisProcessMap.remove(playerName);
        if (player.isValid())
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', endingMsgWithRawColor));
        if (!process.targetWasFlying) {
            LivingEntity target = process.target;
            setPossibleTargetFlying(target, false);
        }
        return true;
    }

    public void setPossibleTargetFlying(LivingEntity livingEntity, boolean enabled) {
        if (!(livingEntity instanceof Player))
            return;
        Player player = (Player)livingEntity;
        if (!player.isValid()) {
            player = Bukkit.getPlayerExact(player.getName());
            if (player == null)
                return;
        }
        if (enabled) {
            player.setAllowFlight(true);
            player.setFlying(true);
        } else {
            player.setFlying(false);
            player.setAllowFlight(false);
        }
    }

    private void startTelekinesisThroughAlmightyHand(Player player, LivingEntity target) {
        String targetName = target.getName();
        String msg = "&7Du kontrollierst nun " + targetName +  ".";
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        double initialDistanceBetweenPlayers = player.getLocation().distance(target.getLocation());
        TaskHolder taskHolder = new TaskHolder();
        MovementInfo movementInfo = new MovementInfo(initialDistanceBetweenPlayers);
        BukkitTask task = Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)Main.getMain(), () -> performTargetMovementAction(player, target, movementInfo), 1L, 1L);
        taskHolder.setBukkitTask(task);
        boolean isTargetFlying = (target instanceof Player && ((Player)target).isFlying());
        TelekinesisProcess process = new TelekinesisProcess(taskHolder, target, isTargetFlying);
        this.telekinesisProcessMap.put(player.getName(), process);
        setPossibleTargetFlying(target, true);
    }

    private void performTargetMovementAction(Player player, LivingEntity target, MovementInfo movementInfo) {
        if (!player.isValid() || !target.isValid()) {
            endTelekinesis(player, "&7Deine Kraft verschwand..");
            setPossibleTargetFlying(target, false);
            return;
        }
        Location playerEyeLocation = player.getEyeLocation();
        Location targetLocation = target.getLocation().add(0.0D, target.getHeight() / 2.0D, 0.0D);
        if (playerEyeLocation.getWorld() != targetLocation.getWorld()) {
            endTelekinesis(player, "&7Deine Kraft verschwand..");
            return;
        }
        double currentDistanceBetweenPlayers = player.getLocation().distance(target.getLocation());
        if (currentDistanceBetweenPlayers > 35.0D) {
            endTelekinesis(player, "&7Der Gegner is zu weit entfernt");
            return;
        }
        double theta = LocationUtil.getRadiansFromYaw(playerEyeLocation.getYaw());
        double phi = LocationUtil.getRadiansFromPitch(playerEyeLocation.getPitch());
        Vector targetDestOffsetFromUser = LocationUtil.getVectorFromSphericalCoordinates(
                getRadius(player, movementInfo), theta, phi);
        Location targetDestLocation = playerEyeLocation.add(targetDestOffsetFromUser);
        if (target instanceof Player && isGoodLocation(targetDestLocation)) {
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getMain(), () -> {
                emitParticle(targetDestLocation, Color.BLACK, 2);
                targetDestLocation.subtract(0.0D, target.getHeight() / 1.9D, 0.0D);
                target.teleport(targetDestLocation);
            });
            return;
        }
        Vector targetDestOffset = targetDestLocation.toVector().subtract(targetLocation.toVector());
        double targetDestOffsetLength = targetDestOffset.length();
        if (targetDestOffsetLength > 8.0D) {
            double multiplier = (target instanceof Player) ? 0.1D : 7.0D;
            targetDestOffset.multiply(multiplier / targetDestOffsetLength);
        }
        if (target.isValid())
            target.setVelocity(targetDestOffset);
        emitParticle(targetDestLocation, Color.BLACK, 5);
    }

    private double getRadius(Player player, MovementInfo movementInfo) {
        int currentInventorySlot = player.getInventory().getHeldItemSlot();
        int lastInventorySlot = movementInfo.lastInventorySlot.getAndSet(currentInventorySlot);
        double deltaRadius = 0.0D;
        if (currentInventorySlot == lastInventorySlot) {
            deltaRadius = 0.0D;
        } else if (currentInventorySlot <= 2 && lastInventorySlot >= 8) {
            deltaRadius = -1.0D;
        } else if (currentInventorySlot >= 8 && lastInventorySlot <= 2) {
            deltaRadius = 1.0D;
        } else if (currentInventorySlot - lastInventorySlot > 0) {
            deltaRadius = -1.0D;
        } else if (currentInventorySlot - lastInventorySlot < 0) {
            deltaRadius = 1.0D;
        }
        double newRadius = movementInfo.currentRadius.addAndGet(deltaRadius);
        if (newRadius < 0.5D) {
            movementInfo.currentRadius.set(0.5D);
            newRadius = 0.5D;
        }
        return newRadius;
    }

    public static boolean isGoodLocation(Location location) {
        Block feet = location.getBlock();
        if (feet.getType() != Material.AIR)
            return false;
        BlockFace[] blockFaceChecks = { BlockFace.UP, BlockFace.DOWN, BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };
        for (BlockFace blockFace : blockFaceChecks) {
            Block checkedBlock = feet.getRelative(blockFace);
            if (checkedBlock.getType() != Material.AIR)
                return false;
        }
        return true;
    }

    public static void emitParticle(Location location, Color color, int thickness) {
        location.getWorld().spawnParticle(Particle.REDSTONE, location, thickness, new Particle.DustOptions(color, 1.0F));
    }

    private static class TelekinesisProcess {
        private UseListener.TaskHolder taskHolder;

        private LivingEntity target;
        private boolean targetWasFlying;

        public TelekinesisProcess(UseListener.TaskHolder taskHolder, LivingEntity target, boolean targetWasFlying) {
            this.taskHolder = taskHolder;
            this.target = target;
            this.targetWasFlying = targetWasFlying;
        }
    }

    private static class TaskHolder {
        private BukkitTask bukkitTask;

        private TaskHolder() {}

        private void setBukkitTask(BukkitTask bukkitTask) {
            this.bukkitTask = bukkitTask;
        }

        private BukkitTask getBukkitTask() {
            return this.bukkitTask;
        }
    }

    private static class MovementInfo {
        private AtomicDouble currentRadius;

        private AtomicInteger lastInventorySlot = new AtomicInteger(-1);

        public MovementInfo(double initialRadius) {
            this.currentRadius = new AtomicDouble(initialRadius);
        }
    }
}
