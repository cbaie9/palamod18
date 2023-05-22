package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

import java.util.function.Supplier;
import java.util.Map;

public class PotgtransfertProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") > 0
				&& entity.getPersistentData().getDouble("Pickaxe_stone") > 0) {
			(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone",
					((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("Pickaxe_stone") + entity.getPersistentData().getDouble("Pickaxe_stone")));
			entity.getPersistentData().putDouble("Pickaxe_stone", 0);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Entity potg xp was transfert in the potg in your main hand"), false);
		}
	}
}
