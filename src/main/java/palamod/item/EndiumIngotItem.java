
package palamod.item;

import palamod.init.PalamodModTabs;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EndiumIngotItem extends Item {
	public EndiumIngotItem() {
		super(new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD).stacksTo(64).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}
