
package palamod.item;

import palamod.init.PalamodModTabs;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EndiumshovelItem extends ShovelItem {
	public EndiumshovelItem() {
		super(new Tier() {
			public int getUses() {
				return 4999;
			}

			public float getSpeed() {
				return 36f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 6;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.ENDIUMNUGGET.get()));
			}
		}, 1, -3.5f, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD).fireResistant());
	}
}
