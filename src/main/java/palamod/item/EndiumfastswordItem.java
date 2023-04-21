
package palamod.item;

import palamod.init.PalamodModTabs;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EndiumfastswordItem extends SwordItem {
	public EndiumfastswordItem() {
		super(new Tier() {
			public int getUses() {
				return 2000;
			}

			public float getSpeed() {
				return 16f;
			}

			public float getAttackDamageBonus() {
				return 5.5f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.ENDIUMNUGGET.get()));
			}
		}, 3, 26f, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD).fireResistant());
	}
}
