package mod.meetblock.core;

import mod.meetblock.block.BlockCore;
import mod.meetblock.item.ItemCore;
import mod.meetblock.network.MessageBurnSound;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFishFood.FishType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ModRegister {
	public static void RegisterBlock(FMLPreInitializationEvent event) {
		BlockCore.register(event);
	}

	public static void RegisterItem(FMLPreInitializationEvent event){
		ItemCore.register(event);
	}

	public static void RegisterEntity(CommonProxy proxy){
		// タイルエンティティはserverとclientで登録方法が違う為プロキシで分ける
		proxy.registerTileEntity();
	}

	public static void RegisterRender(CommonProxy proxy){
		// レンダーはクライアントの未登録
		proxy.registerRender();
	}

	public static void RegisterRecipe(){
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_COW+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_cow,1,0),
				"MM",
				"MM",
				'M',Items.BEEF);
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_COW+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_cow,1,1),
				"MM",
				"MM",
				'M',Items.COOKED_BEEF);

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_PIG+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_pig,1,0),
				"MM",
				"MM",
				'M',Items.PORKCHOP);
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_PIG+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_pig,1,1),
				"MM",
				"MM",
				'M',Items.COOKED_PORKCHOP);

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_MUTTON+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_mutton,1,0),
				"MM",
				"MM",
				'M',Items.MUTTON);
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_MUTTON+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_mutton,1,1),
				"MM",
				"MM",
				'M',Items.COOKED_MUTTON);

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_CHIKIN+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_chikin,1,0),
				"MM",
				"MM",
				'M',Items.CHICKEN);
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_CHIKIN+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_chikin,1,1),
				"MM",
				"MM",
				'M',Items.COOKED_CHICKEN);

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_RABITT+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_rabitt,1,0),
				"MM",
				"MM",
				'M',Items.RABBIT);
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_RABITT+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_rabitt,1,1),
				"MM",
				"MM",
				'M',Items.COOKED_RABBIT);

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_ZOMBIE+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_zombie,1,0),
				"MM",
				"MM",
				'M',Items.ROTTEN_FLESH);
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_MEET_ZOMBIE+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_zombie,1,1),
				"MM",
				"MM",
				'M',ItemCore.NAME_COOKED_ROTTEN_FLESH);

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_FISH+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_fish,1,0),
				"MM",
				"MM",
				'M',new ItemStack(Items.FISH,1,FishType.COD.getMetadata()));
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_FISH+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_fish,1,1),
				"MM",
				"MM",
				'M',new ItemStack(Items.COOKED_FISH,1,FishType.COD.getMetadata()));

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_SALMON+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_salmon,1,0),
				"MM",
				"MM",
				'M',new ItemStack(Items.FISH,1,FishType.SALMON.getMetadata()));
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_SALMON+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_salmon,1,1),
				"MM",
				"MM",
				'M',new ItemStack(Items.COOKED_FISH,1,FishType.SALMON.getMetadata()));

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_CLOWN+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_clown,1,0),
				"MM",
				"MM",
				'M',new ItemStack(Items.FISH,1,FishType.CLOWNFISH.getMetadata()));
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_CLOWN+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_clown,1,1),
				"MM",
				"MM",
				'M',ItemCore.NAME_COOKED_CLOWN);

		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_PUFFER+"_raw"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_puffer,1,0),
				"MM",
				"MM",
				'M',new ItemStack(Items.FISH,1,FishType.PUFFERFISH.getMetadata()));
		GameRegistry.addShapedRecipe(
				new ResourceLocation(ModCommon.MOD_ID+":"+BlockCore.NAME_FISH_PUFFER+"_cooked"),
				new ResourceLocation(ModCommon.MOD_ID),
				new ItemStack(BlockCore.block_puffer,1,1),
				"MM",
				"MM",
				'M',ItemCore.cooked_puffer);

		GameRegistry.addSmelting(new ItemStack(BlockCore.block_cow,1,0), new ItemStack(BlockCore.block_cow,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_pig,1,0), new ItemStack(BlockCore.block_pig,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_mutton,1,0), new ItemStack(BlockCore.block_mutton,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_chikin,1,0), new ItemStack(BlockCore.block_chikin,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_rabitt,1,0), new ItemStack(BlockCore.block_rabitt,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_zombie,1,0), new ItemStack(BlockCore.block_zombie,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_fish,1,0), new ItemStack(BlockCore.block_fish,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_salmon,1,0), new ItemStack(BlockCore.block_salmon,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_clown,1,0), new ItemStack(BlockCore.block_clown,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(BlockCore.block_puffer,1,0), new ItemStack(BlockCore.block_puffer,1,1), 1.5F);
		GameRegistry.addSmelting(new ItemStack(Items.FISH,1,FishType.CLOWNFISH.getMetadata()), new ItemStack(ItemCore.cooked_clown), 1.5F);
		GameRegistry.addSmelting(new ItemStack(Items.FISH,1,FishType.PUFFERFISH.getMetadata()), new ItemStack(ItemCore.cooked_puffer), 1.5F);
		GameRegistry.addSmelting(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(ItemCore.cooked_rotten_flesh), 1.5F);


	}

	public static void RegisterMessage(){
		Mod_MeetBlock.Net_Instance.registerMessage(MessageBurnSound.class, MessageBurnSound.class, ModCommon.MESID_BURNSOUND, Side.CLIENT);
	}


}
