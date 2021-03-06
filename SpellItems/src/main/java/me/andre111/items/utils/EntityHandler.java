package me.andre111.items.utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityHandler {
	public static boolean hasHigherPotionEffect(LivingEntity target, PotionEffectType type, int level) {
		if(target.hasPotionEffect(type)) {
			PotionEffect[] effects = (PotionEffect[]) target.getActivePotionEffects().toArray(new PotionEffect[target.getActivePotionEffects().size()]);
			for(int i=0; i<effects.length; i++) {
				if(effects[i].getType()==type) {
					if(effects[i].getAmplifier()>level) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static Player getPlayerFromUUID(String uuid) {
		try {
			return getPlayerFromUUID(UUID.fromString(uuid));
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	public static Player getPlayerFromUUID(UUID uuid) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(player.getUniqueId().equals(uuid)) {
				return player;
			}
		}

		return null;
	}

	public static Entity getEntityFromUUID(String uuid) {
		try {
			return getEntityFromUUID(UUID.fromString(uuid));
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	public static Entity getEntityFromUUID(UUID uuid) {
		for(World w : Bukkit.getWorlds()) {
			for(Entity e : w.getEntities()) {
				if(e.getUniqueId().equals(uuid)) {
					return e;
				}
			}
		}

		return null;
	}
}
