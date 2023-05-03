
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

public class SpeedEnchantment extends Enchantment {
	public SpeedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(PalamodModItems.ENDIUM_HAMMER.get(), PalamodModItems.PALADIUM_HAMMER.get(), PalamodModItems.CREATIVE_HAMMER.get(), PalamodModItems.GREEN_PALADIUM_HAMMER.get()).contains(item);
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}
}
