package mod.meetblock.network;

import java.util.function.Supplier;

import mod.meetblock.block.BlockMeet;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageBurnSound {

	private int posx;
	private int posy;
	private int posz;

	public MessageBurnSound(int x, int y, int z){
		posx = x;
		posy = y;
		posz = z;
	}


	public static void encode(MessageBurnSound pkt, PacketBuffer buf)
	{
		buf.writeInt(pkt.posx);
		buf.writeInt(pkt.posy);
		buf.writeInt(pkt.posz);
	}

	public static MessageBurnSound decode(PacketBuffer buf)
	{
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		return new MessageBurnSound(x,y,z);
	}

	public static class Handler
	{
		public static void handle(final MessageBurnSound pkt, Supplier<NetworkEvent.Context> ctx)
		{
			ctx.get().enqueueWork(() -> {
				BlockMeet.DisplayParticle(Minecraft.getInstance().world, new BlockPos(pkt.posx,pkt.posy,pkt.posz));
			});
			ctx.get().setPacketHandled(true);
		}
	}

}