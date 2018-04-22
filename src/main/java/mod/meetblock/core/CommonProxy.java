package mod.meetblock.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy{
	public CommonProxy(){
	}

	public World getClientWorld(){
		return null;
	}

	public void registerTileEntity(){
	}

	public void registerRender(){

	}
	public EntityPlayer getEntityPlayerInstance() {return null;}
}