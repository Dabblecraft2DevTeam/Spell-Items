package me.andre111.items.item;

import me.andre111.items.SpellItems;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ItemSpell {
	
	public void setCastVar(int id, double var) {
	}
	public void setCastVar(int id, String var) {
	}
	
	public boolean cast(Player player, boolean[] states) {
		//required other attacks to succed
		if(require!=-1) {
			if(!states[require]) return false;
		}
		
		return cast(player);
	}
	public boolean cast(Player player, Block block, boolean[] states) {
		//required other attacks to succed
		if(require!=-1) {
			if(!states[require]) return false;
		}

		return cast(player, block);
	}
	public boolean cast(Player player, Player target, boolean[] states) {
		//required other attacks to succed
		if(require!=-1) {
			if(!states[require]) return false;
		}

		return cast(player, target);
	}
	
	public boolean cast(Player player) {
		return false;
	}
	public boolean cast(Player player, Block block) {
		return false;
	}
	public boolean cast(Player player, Player target) {
		return false;
	}
	//casted by another spell on that location
	public boolean cast(Player player, Location loc) {
		return false;
	}
	
	//Type of Attack:
	//0: Simple Cast
	//1: Needs Target Block
	//2: Needs Target Player
	/*public int getType() {
		return 0;
	}*/
	
	
	private String itemName = "";
	private int action = 0;
	private int require = -1;
	
	public void setItemName(String name) {
		itemName = name;
	}
	public String getItemName() {
		return itemName;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public void setRequire(int r) {
		require = r;
	}
	public int getRequire() {
		return require;
	}
	
	public CustomItem getItem() {
		return SpellItems.itemManager.getItemByName(getItemName());
	}
	public void resetCoolDown(Player player) {
		getItem().resetCoolDown(getAction(), player);
	}
}