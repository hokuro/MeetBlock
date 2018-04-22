package mod.meetblock.creative;

import mod.meetblock.block.BlockCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabMeetBlock  extends CreativeTabs {
	public CreativeTabMeetBlock(String label){
		super(label);
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "factory box";
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockCore.block_cow);
	}

	@SideOnly(Side.CLIENT)
	public int getIconItemDamage(){
		return 8;
	}
}