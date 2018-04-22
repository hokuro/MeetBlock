package mod.meetblock.item;

import java.util.HashMap;
import java.util.Map;

import mod.meetblock.core.ModCommon;
import mod.meetblock.core.Mod_MeetBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemCore {
	public static final String NAME_COOKED_ROTTEN_FLESH = "cooked_rotten_flesh";
	public static final String NAME_COOKED_CLOWN = "cooked_clown";
	public static final String NAME_COOKED_PUFFER ="cooked_puffer";


	public static final String[] NAME_LIST = new String[]{
			NAME_COOKED_ROTTEN_FLESH,
			NAME_COOKED_CLOWN,
			NAME_COOKED_PUFFER,
	};

	public static Item cooked_rotten_flesh;
	public static Item cooked_clown;
	public static Item cooked_puffer;


	private static Map<String,Item> itemMap;
	private static Map<String,ModelResourceLocation[]> resourceMap;

	private static void init(){
		cooked_rotten_flesh = new ItemFood(4, 0.1F, true).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 2), 1.0F)
				.setCreativeTab(Mod_MeetBlock.tabMeet)
				.setRegistryName(NAME_COOKED_ROTTEN_FLESH)
				.setUnlocalizedName(NAME_COOKED_ROTTEN_FLESH);
		cooked_clown =  new ItemFood(4, 0.1F, true)
				.setCreativeTab(Mod_MeetBlock.tabMeet)
				.setRegistryName(NAME_COOKED_CLOWN)
				.setUnlocalizedName(NAME_COOKED_CLOWN);
		cooked_puffer =  new ItemFood(4, 0.1F, true).setPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3),1.0F)
				.setCreativeTab(Mod_MeetBlock.tabMeet)
				.setRegistryName(NAME_COOKED_PUFFER)
				.setUnlocalizedName(NAME_COOKED_PUFFER);

		itemMap = new HashMap<String,Item>(){
			{put(NAME_COOKED_ROTTEN_FLESH,cooked_rotten_flesh);}
			{put(NAME_COOKED_CLOWN,cooked_clown);}
			{put(NAME_COOKED_PUFFER,cooked_puffer);}
		};

		resourceMap = new HashMap<String,ModelResourceLocation[]>(){
			{put(NAME_COOKED_ROTTEN_FLESH,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_COOKED_ROTTEN_FLESH, "inventory")});}
			{put(NAME_COOKED_CLOWN,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_COOKED_CLOWN, "inventory")});}
			{put(NAME_COOKED_PUFFER,new ModelResourceLocation[]{new ModelResourceLocation(ModCommon.MOD_ID + ":" + NAME_COOKED_PUFFER, "inventory")});}
		};
	}

	public static void register(FMLPreInitializationEvent event) {
		init();
		for (String key : NAME_LIST){
			ForgeRegistries.ITEMS.register(itemMap.get(key));
		}

        //テクスチャ・モデル指定JSONファイル名の登録。
        if (event.getSide().isClient()) {
        	for (String key : NAME_LIST){
        		//1IDで複数モデルを登録するなら、上のメソッドで登録した登録名を指定する。
        		int cnt = 0;
        		for (ModelResourceLocation rc : resourceMap.get(key)){
        			ModelLoader.setCustomModelResourceLocation(itemMap.get(key), cnt, rc);
        			cnt++;
        		}
        	}
        }
	}
}
