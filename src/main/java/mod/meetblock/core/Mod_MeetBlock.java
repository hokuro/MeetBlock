package mod.meetblock.core;

import java.util.ArrayList;
import java.util.List;

import mod.meetblock.block.BlockCore;
import mod.meetblock.item.ItemCore;
import mod.meetblock.network.MessageHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(ModCommon.MOD_ID)
public class Mod_MeetBlock {
	// タブ
	//public static final CreativeTabMeetBlock tabMeet = new CreativeTabMeetBlock("MeetBlock");
	// マテリアル
	public static Material materialMeet;


	public static List<Enchantment> encList = new ArrayList<Enchantment>();

    public Mod_MeetBlock() {


    	// イベント登録
        MinecraftForge.EVENT_BUS.register(this);
        materialMeet=(new Material.Builder(MaterialColor.WOOL)).build();
        MessageHandler.register();

    }


    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
        	BlockCore.registerBlock(blockRegistryEvent);
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            BlockCore.registerItemBlock(itemRegistryEvent);
            ItemCore.register(itemRegistryEvent);
        }
    }

}
