package de.lxca1909.ffaplugin.kits.telekinese.utils;

import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class LocationUtil {
    public static Vector getVectorFromSphericalCoordinates(double radius, double theta, double phi) {
        double deltaY = radius * Math.cos(phi);
        double xAndZMagnitude = radius * Math.sin(phi);
        theta += 1.5707963267948966D;
        double deltaX = xAndZMagnitude * Math.sin(theta);
        double deltaZ = xAndZMagnitude * Math.cos(theta);
        return new Vector(deltaX, deltaY, deltaZ);
    }

    public static double getRadiansFromYaw(float yaw) {
        double degrees = getDegreesFromYaw(yaw);
        return Math.toRadians(degrees);
    }

    public static double getDegreesFromYaw(float yaw) {
        double counterClockwiseYaw = 360.0D - yaw;
        double positiveOrNegativeDegrees = counterClockwiseYaw - 90.0D;
        return (positiveOrNegativeDegrees < 0.0D) ? (360.0D + positiveOrNegativeDegrees) : (positiveOrNegativeDegrees % 360.0D);
    }

    public static double getRadiansFromPitch(float pitch) {
        double degrees = getDegreesFromPitch(pitch);
        return Math.toRadians(degrees);
    }

    public static double getDegreesFromPitch(float pitch) {
        return pitch + 90.0D;
    }

    public static <T extends LivingEntity> T getEntityInLineOfSight(LivingEntity looker, double boxRadius) {
        List<Entity> nearbyEntities = looker.getNearbyEntities(boxRadius, boxRadius, boxRadius);
        Vector playerVector = looker.getEyeLocation().toVector();
        Vector playerDirection = looker.getEyeLocation().getDirection();
        Entity candidateEntity = null;
        double candidateDistance = boxRadius + 1.0D;
        for (Entity nearbyEntity : nearbyEntities) {
            if (!(nearbyEntity instanceof LivingEntity))
                continue;
            double heightIncrementor = nearbyEntity.getHeight() / 2.0D;
            Vector entityVector = nearbyEntity.getLocation().add(0.0D, heightIncrementor, 0.0D).toVector();
            Vector destVector = entityVector.subtract(playerVector);
            double angRad = destVector.angle(playerDirection);
            double distance = destVector.length();
            if (angRad > getAllowedDegrees(distance))
                continue;
            if (distance < candidateDistance) {
                candidateEntity = nearbyEntity;
                candidateDistance = distance;
            }
        }
        return (T)candidateEntity;
    }

    private static double getAllowedDegrees(double distance) {
        double oneDegreeInRads = 0.017453292519943295D;
        double maxRads = oneDegreeInRads * 80.0D;
        double minRads = oneDegreeInRads * 15.0D;
        return Math.max(maxRads - 35.0D * oneDegreeInRads * distance, minRads);
    }
}
