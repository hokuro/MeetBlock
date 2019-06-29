package mod.meetblock.item;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;

public class ItemCore {
	public static final String NAME_COOKED_ROTTEN_FLESH = "cooked_rotten_flesh";
	public static final String NAME_COOKED_CLOWN = "cooked_clown";
	public static final String NAME_COOKED_PUFFER ="cooked_puffer";


	public static final String[] NAME_LIST = new String[]{
			NAME_COOKED_ROTTEN_FLESH,
			NAME_COOKED_CLOWN,
			NAME_COOKED_PUFFER,
	};

	public final static Item cooked_rotten_flesh = new ItemFood(4, 0.1F, true,(new Item.Properties()).group(ItemGroup.FOOD)).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 2), 1.0F)
			.setRegistryName(NAME_COOKED_ROTTEN_FLESH);;
	public final static Item cooked_clown = new ItemFood(4, 0.1F, true,(new Item.Properties()).group(ItemGroup.FOOD))
			.setRegistryName(NAME_COOKED_CLOWN);
	public final static Item cooked_puffer =  new ItemFood(4, 0.1F, true,(new Item.Properties()).group(ItemGroup.FOOD)).setPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3),1.0F)
			.setRegistryName(NAME_COOKED_PUFFER);


	private static Map<String,Item> itemMap;
	public static void init(){
		if (itemMap != null){return;}
//		cooked_rotten_flesh
//		cooked_clown =
//		cooked_puffer

		itemMap = new HashMap<String,Item>(){
			{put(NAME_COOKED_ROTTEN_FLESH,cooked_rotten_flesh);}
			{put(NAME_COOKED_CLOWN,cooked_clown);}
			{put(NAME_COOKED_PUFFER,cooked_puffer);}
		};
	}

	public static void register(final RegistryEvent.Register<Item> itemRegistryEvent){
		init();
		for (String name : NAME_LIST){
			itemRegistryEvent.getRegistry().register(itemMap.get(name));
		}

	}
}
