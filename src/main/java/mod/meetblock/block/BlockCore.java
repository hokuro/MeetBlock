package mod.meetblock.block;

import java.util.HashMap;
import java.util.Map;

import mod.meetblock.block.item.ItemBlockMeet;
import mod.meetblock.core.ModCommon;
import mod.meetblock.item.ItemCore;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class BlockCore{

	public static final String NAME_MEET_COW = "meetcow";
	public static final String NAME_MEET_PIG = "meetpig";
	public static final String NAME_MEET_CHIKIN = "meetchikin";
	public static final String NAME_MEET_MUTTON = "meetmutton";
	public static final String NAME_MEET_RABITT = "meetrabitt";
	public static final String NAME_MEET_ZOMBIE = "meetzombie";
	public static final String NAME_FISH_FISH = "fishfish";
	public static final String NAME_FISH_SALMON = "fishsalmon";
	public static final String NAME_FISH_CLOWN = "fishclown";
	public static final String NAME_FISH_PUFFER = "fishfuffer";
	public static final String NAME_MEET_COW_COOKED = "meetcow_cooked";
	public static final String NAME_MEET_PIG_COOKED = "meetpig_cooked";
	public static final String NAME_MEET_CHIKIN_COOKED = "meetchikin_cooked";
	public static final String NAME_MEET_MUTTON_COOKED = "meetmutton_cooked";
	public static final String NAME_MEET_RABITT_COOKED = "meetrabitt_cooked";
	public static final String NAME_MEET_ZOMBIE_COOKED = "meetzombie_cooked";
	public static final String NAME_FISH_FISH_COOKED = "fishfish_cooked";
	public static final String NAME_FISH_SALMON_COOKED = "fishsalmon_cooked";
	public static final String NAME_FISH_CLOWN_COOKED = "fishclown_cooked";
	public static final String NAME_FISH_PUFFER_COOKED = "fishfuffer_cooked";

	public static Block block_cow;
	public static Block block_pig;
	public static Block block_chikin;
	public static Block block_mutton;
	public static Block block_rabitt;
	public static Block block_zombie;
	public static Block block_fish;
	public static Block block_salmon;
	public static Block block_clown;
	public static Block block_puffer;

	public static Block block_cow_cooked;
	public static Block block_pig_cooked;
	public static Block block_chikin_cooked;
	public static Block block_mutton_cooked;
	public static Block block_rabitt_cooked;
	public static Block block_zombie_cooked;
	public static Block block_fish_cooked;
	public static Block block_salmon_cooked;
	public static Block block_clown_cooked;
	public static Block block_puffer_cooked;


	private static final String[] NAME_LIST = new String[]{
			NAME_MEET_COW,
			NAME_MEET_PIG,
			NAME_MEET_CHIKIN,
			NAME_MEET_MUTTON,
			NAME_MEET_RABITT,
			NAME_MEET_ZOMBIE,
			NAME_FISH_FISH,
			NAME_FISH_SALMON,
			NAME_FISH_CLOWN,
			NAME_FISH_PUFFER,
			NAME_MEET_COW_COOKED,
			NAME_MEET_PIG_COOKED,
			NAME_MEET_CHIKIN_COOKED,
			NAME_MEET_MUTTON_COOKED,
			NAME_MEET_RABITT_COOKED,
			NAME_MEET_ZOMBIE_COOKED,
			NAME_FISH_FISH_COOKED,
			NAME_FISH_SALMON_COOKED,
			NAME_FISH_CLOWN_COOKED,
			NAME_FISH_PUFFER_COOKED,
	};

	private static Map<String,Block> blockMap;
	private static Map<String,Item> itemMap;

	public static void init(){
		if (blockMap != null){return;}
		block_cow_cooked = new BlockMeet(Items.COOKED_BEEF,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_MEET_COW_COOKED));
		block_pig_cooked = new BlockMeet(Items.COOKED_PORKCHOP,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_MEET_PIG_COOKED));;
		block_chikin_cooked = new BlockMeet(Items.COOKED_CHICKEN,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_MEET_CHIKIN_COOKED));;
		block_mutton_cooked = new BlockMeet(Items.COOKED_MUTTON,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_MEET_MUTTON_COOKED));;
		block_rabitt_cooked = new BlockMeet(Items.COOKED_RABBIT,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_MEET_RABITT_COOKED));;
		block_zombie_cooked = new BlockMeet(ItemCore.cooked_rotten_flesh,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_MEET_ZOMBIE_COOKED));;
		block_fish_cooked = new BlockMeet(Items.COOKED_COD,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_FISH_FISH_COOKED));;
		block_salmon_cooked = new BlockMeet(Items.COOKED_SALMON,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_FISH_SALMON_COOKED));;
		block_clown_cooked = new BlockMeet(ItemCore.cooked_clown,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_FISH_CLOWN_COOKED));;
		block_puffer_cooked = new BlockMeet(ItemCore.cooked_puffer,true)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+ NAME_FISH_PUFFER_COOKED));;


		block_cow = new BlockMeet(Items.BEEF, false, block_cow_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_COW));

		block_pig = new BlockMeet(Items.PORKCHOP,false,block_pig_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_PIG));

		block_chikin = new BlockMeet(Items.CHICKEN, false,block_chikin_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_CHIKIN));

		block_mutton = new BlockMeet(Items.MUTTON, false,block_mutton_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_MUTTON));

		block_rabitt = new BlockMeet(Items.RABBIT, false,block_rabitt_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_RABITT));

		block_zombie = new BlockMeet(Items.ROTTEN_FLESH, false,block_zombie_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_ZOMBIE));

		block_fish = new BlockMeet(Items.COD,false,block_fish_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_FISH));

		block_salmon = new BlockMeet(Items.SALMON, false,block_salmon_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_SALMON));

		block_clown = new BlockMeet(Items.TROPICAL_FISH,false,block_clown_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_CLOWN));

		block_puffer = new BlockMeet(Items.PUFFERFISH,false,block_puffer_cooked)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_PUFFER));


		blockMap = new HashMap<String,Block>(){
			{put(NAME_MEET_COW,block_cow);}
			{put(NAME_MEET_PIG,block_pig);}
			{put(NAME_MEET_CHIKIN,block_chikin);}
			{put(NAME_MEET_MUTTON,block_mutton);}
			{put(NAME_MEET_RABITT,block_rabitt);}
			{put(NAME_MEET_ZOMBIE,block_zombie);}
			{put(NAME_FISH_FISH,block_fish);}
			{put(NAME_FISH_SALMON,block_salmon);}
			{put(NAME_FISH_CLOWN,block_clown);}
			{put(NAME_FISH_PUFFER,block_puffer);}


			{put(NAME_MEET_COW_COOKED,block_cow_cooked);}
			{put(NAME_MEET_PIG_COOKED,block_pig_cooked);}
			{put(NAME_MEET_CHIKIN_COOKED,block_chikin_cooked);}
			{put(NAME_MEET_MUTTON_COOKED,block_mutton_cooked);}
			{put(NAME_MEET_RABITT_COOKED,block_rabitt_cooked);}
			{put(NAME_MEET_ZOMBIE_COOKED,block_zombie_cooked);}
			{put(NAME_FISH_FISH_COOKED,block_fish_cooked);}
			{put(NAME_FISH_SALMON_COOKED,block_salmon_cooked);}
			{put(NAME_FISH_CLOWN_COOKED,block_clown_cooked);}
			{put(NAME_FISH_PUFFER_COOKED,block_puffer_cooked);}
		};


		itemMap = new HashMap<String,Item>(){
			{put(NAME_MEET_COW,new ItemBlockMeet(block_cow).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_COW));}
			{put(NAME_MEET_PIG,new ItemBlockMeet(block_pig).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_PIG));}
			{put(NAME_MEET_CHIKIN,new ItemBlockMeet(block_chikin).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_CHIKIN));}
			{put(NAME_MEET_MUTTON,new ItemBlockMeet(block_mutton).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_MUTTON));}
			{put(NAME_MEET_RABITT,new ItemBlockMeet(block_rabitt).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_RABITT));}
			{put(NAME_MEET_ZOMBIE,new ItemBlockMeet(block_zombie).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_ZOMBIE));}
			{put(NAME_FISH_FISH,new ItemBlockMeet(block_fish).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_FISH));}
			{put(NAME_FISH_SALMON,new ItemBlockMeet(block_salmon).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_SALMON));}
			{put(NAME_FISH_CLOWN,new ItemBlockMeet(block_clown).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_CLOWN));}
			{put(NAME_FISH_PUFFER,new ItemBlockMeet(block_puffer).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_PUFFER));}

			{put(NAME_MEET_COW_COOKED,new ItemBlockMeet(block_cow_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_COW_COOKED));}
			{put(NAME_MEET_PIG_COOKED,new ItemBlockMeet(block_pig_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_PIG_COOKED));}
			{put(NAME_MEET_CHIKIN_COOKED,new ItemBlockMeet(block_chikin_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_CHIKIN_COOKED));}
			{put(NAME_MEET_MUTTON_COOKED,new ItemBlockMeet(block_mutton_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_MUTTON_COOKED));}
			{put(NAME_MEET_RABITT_COOKED,new ItemBlockMeet(block_rabitt_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_RABITT_COOKED));}
			{put(NAME_MEET_ZOMBIE_COOKED,new ItemBlockMeet(block_zombie_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_MEET_ZOMBIE_COOKED));}
			{put(NAME_FISH_FISH_COOKED,new ItemBlockMeet(block_fish_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_FISH_COOKED));}
			{put(NAME_FISH_SALMON_COOKED,new ItemBlockMeet(block_salmon_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_SALMON_COOKED));}
			{put(NAME_FISH_CLOWN_COOKED,new ItemBlockMeet(block_clown_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_CLOWN_COOKED));}
			{put(NAME_FISH_PUFFER_COOKED,new ItemBlockMeet(block_puffer_cooked).setRegistryName(ModCommon.MOD_ID + ":" + NAME_FISH_PUFFER_COOKED));}
			};
	}

	public static void registerBlock(final RegistryEvent.Register<Block> event){
		init();
		for (String name : NAME_LIST){
			event.getRegistry().register(blockMap.get(name));
		}
	}

	public static void registerItemBlock(final RegistryEvent.Register<Item> event){
		init();
		for (String name : NAME_LIST){
			event.getRegistry().register(itemMap.get(name));
		}
	}
}