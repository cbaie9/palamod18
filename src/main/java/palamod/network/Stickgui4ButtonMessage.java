
package palamod.network;

import palamod.world.inventory.Stickgui4Menu;

import palamod.procedures.ConnectstickjumpProcedure;
import palamod.procedures.Connectstickgui5Procedure;
import palamod.procedures.ConnectitemmenuProcedure;
import palamod.procedures.BackpalahelpProcedure;

import palamod.PalamodMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Stickgui4ButtonMessage {
	private final int buttonID, x, y, z;

	public Stickgui4ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public Stickgui4ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(Stickgui4ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(Stickgui4ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = Stickgui4Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectstickjumpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Connectstickgui5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectitemmenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(Stickgui4ButtonMessage.class, Stickgui4ButtonMessage::buffer, Stickgui4ButtonMessage::new, Stickgui4ButtonMessage::handler);
	}
}
