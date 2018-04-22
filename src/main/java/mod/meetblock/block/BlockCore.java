package mod.meetblock.block;

import java.util.HashMap;
import java.util.Map;

import mod.meetblock.block.item.ItemBlockMeet;
import mod.meetblock.core.ModCommon;
import mod.meetblock.item.ItemCore;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood.FishType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

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
	};

	private static Map<String,Block> blockMap;
	private static Map<String,Item> itemMap;
	private static Map<String,ResourceLocation[]> resourceMap;

	private static void init(){
		block_cow = new BlockMeet(Items.BEEF, Items.COOKED_BEEF)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_COW))
				.setUnlocalizedName(NAME_MEET_COW);

		block_pig = new BlockMeet(Items.PORKCHOP, Items.COOKED_PORKCHOP)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_PIG))
				.setUnlocalizedName(NAME_MEET_PIG);

		block_chikin = new BlockMeet(Items.CHICKEN, Items.COOKED_CHICKEN)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_CHIKIN))
				.setUnlocalizedName(NAME_MEET_CHIKIN);

		block_mutton = new BlockMeet(Items.MUTTON, Items.COOKED_MUTTON)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_MUTTON))
				.setUnlocalizedName(NAME_MEET_MUTTON);

		block_rabitt = new BlockMeet(Items.RABBIT, Items.COOKED_RABBIT)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_RABITT))
				.setUnlocalizedName(NAME_MEET_RABITT);

		block_zombie = new BlockMeet(Items.ROTTEN_FLESH, ItemCore.cooked_rotten_flesh)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_MEET_ZOMBIE))
				.setUnlocalizedName(NAME_MEET_ZOMBIE);// ItemCore.item_cooked_rotten_flesh);

		block_fish = new BlockMeet(Items.FISH,FishType.COD.getMetadata(),Items.COOKED_FISH,0)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_FISH))
				.setUnlocalizedName(NAME_FISH_FISH);

		block_salmon = new BlockMeet(Items.FISH,FishType.SALMON.getMetadata(), Items.COOKED_FISH,1)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_SALMON))
				.setUnlocalizedName(NAME_FISH_SALMON);

		block_clown = new BlockMeet(Items.FISH,FishType.CLOWNFISH.getMetadata(), ItemCore.cooked_clown,0)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_CLOWN))
				.setUnlocalizedName(NAME_FISH_CLOWN);

		block_puffer = new BlockMeet(Items.FISH,FishType.PUFFERFISH.getMetadata(), ItemCore.cooked_puffer,0)
				.setRegistryName(new ResourceLocation(ModCommon.MOD_ID+":"+NAME_FISH_PUFFER))
				.setUnlocalizedName(NAME_FISH_PUFFER);


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
			};


		resourceMap = new HashMap<String,ResourceLocation[]>(){
			{put(NAME_MEET_COW,new ResourceLocation[]{
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_COW),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_COW +"_cooked")});}
			{put(NAME_MEET_PIG,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_PIG),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_PIG +"_cooked")});}
			{put(NAME_MEET_CHIKIN,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_CHIKIN),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_CHIKIN +"_cooked")});}
			{put(NAME_MEET_MUTTON,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_MUTTON),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_MUTTON +"_cooked")});}
			{put(NAME_MEET_RABITT,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_RABITT),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_RABITT +"_cooked")});}
			{put(NAME_MEET_ZOMBIE,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_ZOMBIE),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_MEET_ZOMBIE +"_cooked")});}
			{put(NAME_FISH_FISH,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_FISH),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_FISH +"_cooked")});}
			{put(NAME_FISH_SALMON,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_SALMON),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_SALMON +"_cooked")});}
			{put(NAME_FISH_CLOWN,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_CLOWN),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_CLOWN +"_cooked")});}
			{put(NAME_FISH_PUFFER,new ResourceLocation[]{new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_PUFFER),
					new ResourceLocation(ModCommon.MOD_ID + ":" + NAME_FISH_PUFFER +"_cooked")});}
		};
	}


	public static void register(FMLPreInitializationEvent event){
		init();
		for (String key: NAME_LIST){
			ForgeRegistries.BLOCKS.register(blockMap.get(key));
			ForgeRegistries.ITEMS.register(itemMap.get(key));
		}

		if (event.getSide().isClient()){
			for (String key : NAME_LIST){
				Item witem = itemMap.get(key);
				ResourceLocation[] wresource = resourceMap.get(key);
				if (wresource.length > 1){
					ModelLoader.registerItemVariants(witem, wresource);
				}
				for (int i = 0; i < wresource.length; i++){
					ModelLoader.setCustomModelResourceLocation(witem, i,
							new ModelResourceLocation(wresource[i], "inventory"));
				}
			}
		}
	}
}