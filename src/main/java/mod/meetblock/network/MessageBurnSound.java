package mod.meetblock.network;

import io.netty.buffer.ByteBuf;
import mod.meetblock.block.BlockMeet;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageBurnSound implements IMessage, IMessageHandler<MessageBurnSound, IMessage> {

	private int posx;
	private int posy;
	private int posz;
	public MessageBurnSound(){}

	public MessageBurnSound(int x, int y, int z){
		posx = x;
		posy = y;
		posz = z;
	}


	@Override
	public void fromBytes(ByteBuf buf) {
		posx = buf.readInt();
		posy = buf.readInt();
		posz = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(posx);
		buf.writeInt(posy);
		buf.writeInt(posz);
	}

	@Override
	public IMessage onMessage(MessageBurnSound message, MessageContext ctx){
		BlockMeet.DisplayParticle(Minecraft.getMinecraft().world, new BlockPos(message.posx,message.posy,message.posz));
		return null;
	}
}