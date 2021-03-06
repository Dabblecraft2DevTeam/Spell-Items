package me.andre111.items.lua;

import java.util.UUID;

import me.andre111.items.utils.EntityHandler;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

public class GetSpawn extends VarArgFunction {
	@Override
	public Varargs invoke(Varargs args) {
		if(args.narg()>=1) {
			LuaValue value = LUAHelper.getInternalValue(args.arg(1));
			
			if(value.isstring()) {
				World world = Bukkit.getWorld(value.tojstring());
				
				if(world!=null) {
					LuaValue[] returnValue = new LuaValue[2];
					returnValue[0] = LuaValue.TRUE;
					returnValue[1] = LUAHelper.createLocationObject(world.getSpawnLocation());
					
					return LuaValue.varargsOf(returnValue);
				}
			} else if(value.isuserdata(UUID.class)) {
				Entity entity = EntityHandler.getEntityFromUUID((UUID) value.touserdata(UUID.class));
				
				if(entity!=null && entity instanceof Player) {
					Location sloc = ((Player) entity).getBedSpawnLocation();
					if(sloc==null) entity.getWorld().getSpawnLocation();
					
					LuaValue[] returnValue = new LuaValue[2];
					returnValue[0] = LuaValue.TRUE;
					returnValue[1] = LUAHelper.createLocationObject(sloc);
					
					return LuaValue.varargsOf(returnValue);
				}
			}
		}
		
		return LuaValue.FALSE;
	}
}
