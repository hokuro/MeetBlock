package mod.meetblock.block.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;

public class ItemBlockMeet extends ItemBlock {

	public ItemBlockMeet(Block block) {
		super(block, (new Item.Properties()).group(ItemGroup.FOOD) );
	}
}
