package de.lxca1909.ffaplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Particle {

//    EnumParticle particletype;
//    boolean longdistance;
//    Location location;
//    float offsetx;
//    float offsety;
//    float offsetz;
//    float speed;
//    int amont;
//    int data;
//
//
//    public Particle(EnumParticle particletype, boolean longdistance, Location location, float offsetx, float offsety, float offsetz, float speed, int amont){
//        this.particletype = particletype;
//        this.longdistance = longdistance;
//        this.location = location;
//        this.offsetx = offsetx;
//        this.offsety = offsety;
//        this.offsetz = offsetz;
//        this.speed = speed;
//        this.amont = amont;
//        this.data = data;
//    }
//    public void sendAll(){
//        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(this.particletype, this.longdistance, (float)this.location.getX(), (float)this.location.getY(), (float)this.location.getZ(), this.offsetx, this.offsety, this.offsetz, this.speed, this.amont);
//        for(Player p : Bukkit.getOnlinePlayers()){
//            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
//        }
//    }
//    public void sendPlayer(Player player){
//        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(this.particletype, this.longdistance, (float)this.location.getX(), (float)this.location.getY(), (float)this.location.getZ(), this.offsetx, this.offsety, this.offsetz, this.speed, this.amont, this.data);
//            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
//    }
}
