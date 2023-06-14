package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

public class MoucepotgProcedure {
	public static void execute(ItemStack itemstack) {
		if (Screen.hasShiftDown()) {
			if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 2000000) {
				itemstack.setHoverName(Component.literal("Fully upgraded - Level 20"));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 1000000) {
				itemstack.setHoverName(Component.literal(((2000000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 19")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 800000) {
				itemstack.setHoverName(Component.literal(((1000000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 18")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 700000) {
				itemstack.setHoverName(Component.literal(((800000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 17")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 600000) {
				itemstack.setHoverName(Component.literal(((700000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 16")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 500000) {
				itemstack.setHoverName(Component.literal(((600000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 15")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 400000) {
				itemstack.setHoverName(Component.literal(((500000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 14")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 250000) {
				itemstack.setHoverName(Component.literal(((400000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 13")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 150000) {
				itemstack.setHoverName(Component.literal(((250000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 12")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 100000) {
				itemstack.setHoverName(Component.literal(((150000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 11")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 50000) {
				itemstack.setHoverName(Component.literal(((100000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 10")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 25000) {
				itemstack.setHoverName(Component.literal(((50000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 9")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 10000) {
				itemstack.setHoverName(Component.literal(((25000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 8")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 5000) {
				itemstack.setHoverName(Component.literal(((10000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 7")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 2000) {
				itemstack.setHoverName(Component.literal(((5000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 6")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 1000) {
				itemstack.setHoverName(Component.literal(((2000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 5")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 500) {
				itemstack.setHoverName(Component.literal(((1000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 4")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 250) {
				itemstack.setHoverName(Component.literal(((500 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 3")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 100) {
				itemstack.setHoverName(Component.literal(((250 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 2")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 1) {
				itemstack.setHoverName(Component.literal(((100 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + "Left - Level 1")));
			}
			if (itemstack.getOrCreateTag().getDouble("Cooldown_name") > 0) {
				itemstack.getOrCreateTag().putDouble("Cooldown_name", (itemstack.getOrCreateTag().getDouble("Cooldown_name") - 1));
			}
		} else {
			itemstack.setHoverName(Component.literal("Pickaxe of the Gods "));
		}
	}
}
