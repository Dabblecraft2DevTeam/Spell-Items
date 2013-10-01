package me.andre111.items.item.spell;

import me.andre111.items.ItemHandler;
import me.andre111.items.item.ItemSpell;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemArmorSet extends ItemSpell {
	private boolean self = false;
	
	private String helmet = "";
	private String chest = "";
	private String leggins = "";
	private String boots = "";
	
	@Override
	public void setCastVar(int id, double var) {
		if(id==0) self = (var==1);
	}
	
	@Override
	public void setCastVar(int id, String var) {
		if(id==1) helmet = var;
		else if(id==2) chest = var;
		else if(id==3) leggins = var;
		else if(id==4) boots = var;
	}
	
	@Override
	public boolean cast(Player player, Location loc, Player target, Block block) {
		Player pTarget = null;
		if(self) {
			pTarget = player;
		} else if(target!=null) {
			pTarget = target;
		}
		
		if(pTarget!=null) {
			setArmor(pTarget);
			return true;
		}
		
		return false;
	}
	
	private void setArmor(Player player) {
		ItemStack helmetIt = ItemHandler.decodeItem(helmet);
		if(helmetIt!=null) player.getInventory().setHelmet(helmetIt);
		
		ItemStack chestIt = ItemHandler.decodeItem(chest);
		if(chestIt!=null) player.getInventory().setChestplate(chestIt);
		
		ItemStack legginsIt = ItemHandler.decodeItem(leggins);
		if(legginsIt!=null) player.getInventory().setLeggings(legginsIt);
		
		ItemStack bootsIt = ItemHandler.decodeItem(boots);
		if(bootsIt!=null) player.getInventory().setBoots(bootsIt);
	}
}
