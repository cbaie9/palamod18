
package palamod.item;

import palamod.init.PalamodModTabs;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class GreenpaladiumfastswordItem extends SwordItem {
	public GreenpaladiumfastswordItem() {
		super(new Tier() {
			public int getUses() {
				return 1000;
			}

			public float getSpeed() {
				return 16f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.PALADIUM_GREENINGOT.get()));
			}
		}, 3, 16f, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
	}
}
