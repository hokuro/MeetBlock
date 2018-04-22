package mod.meetblock.core;

import java.util.ArrayList;
import java.util.List;

import mod.meetblock.block.material.MaterialMeet;
import mod.meetblock.config.ConfigValue;
import mod.meetblock.creative.CreativeTabMeetBlock;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = ModCommon.MOD_ID,
name = ModCommon.MOD_NAME,
version = ModCommon.MOD_VERSION,
acceptedMinecraftVersions = ModCommon.MOD_ACCEPTED_MC_VERSIONS)
public class Mod_MeetBlock {
	@Mod.Instance(ModCommon.MOD_ID)
	public static Mod_MeetBlock instance;
	@SidedProxy(clientSide = ModCommon.MOD_PACKAGE + ModCommon.MOD_CLIENT_SIDE, serverSide = ModCommon.MOD_PACKAGE + ModCommon.MOD_SERVER_SIDE)
	public static CommonProxy proxy;
	public static final SimpleNetworkWrapper Net_Instance = NetworkRegistry.INSTANCE.newSimpleChannel(ModCommon.MOD_CHANEL);
	public static final ModGui guiInstance = new ModGui();
	// タブ
	public static final CreativeTabMeetBlock tabMeet = new CreativeTabMeetBlock("MeetBlock");
	// マテリアル
	public static final Material materialMeet = new MaterialMeet(MapColor.CLOTH);


	public static List<Enchantment> encList = new ArrayList<Enchantment>();
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// コンフィグ読み込み
		ConfigValue.init(event);

		// アイテム登録
		ModRegister.RegisterItem(event);

		// ブロック登録
		ModRegister.RegisterBlock(event);


		// エンティティ設定
		ModRegister.RegisterEntity(proxy);
		// レンダー設定
		ModRegister.RegisterRender(proxy);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// メッセージ登録
		ModRegister.RegisterMessage();
		// レシピ追加
		//ModRegister.RegisterRecipe();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGui());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		// コンフィグ初期設定
		ConfigValue.setting();
	}
}
