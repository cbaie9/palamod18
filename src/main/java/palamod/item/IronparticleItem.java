
package palamod.item;

import palamod.init.PalamodModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IronparticleItem extends Item {
	public IronparticleItem() {
		super(new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD).stacksTo(64).rarity(Rarity.COMMON));
	}
}
