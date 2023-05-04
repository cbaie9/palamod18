
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

public class BigholeEnchantment extends Enchantment {
	public BigholeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.VANISHABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(PalamodModItems.PICKAXEOFTHEGODSLV_18.get(), PalamodModItems.PICKAXEOFTHEGODSLV_19.get(), PalamodModItems.PICKAXEOFTHEGODSLV_20.get(), PalamodModItems.PICKAXEOFTHEGODSLV_17.get(), PalamodModItems.CREATIVEPOTG.get())
				.contains(item);
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
