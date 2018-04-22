package mod.meetblock.block.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemBlockMeet extends ItemBlock {

	public ItemBlockMeet(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
        	items.add(new ItemStack(this.block,1,0));
        	items.add(new ItemStack(this.block,1,1));
        }
    }
}
