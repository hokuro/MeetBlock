package mod.meetblock.network;

import mod.meetblock.core.ModCommon;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class MessageHandler {
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation(ModCommon.MOD_ID, ModCommon.MOD_CHANEL))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
			.simpleChannel();

	public static void register()
	{
		int disc = 0;

		HANDLER.registerMessage(disc++, MessageBurnSound.class, MessageBurnSound::encode, MessageBurnSound::decode, MessageBurnSound.Handler::handle);

	}


	public static void SendBurnSound(int x, int y, int z, EntityPlayerMP pl){
		HANDLER.sendTo(new MessageBurnSound(x,y,z),pl.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
	}
}
