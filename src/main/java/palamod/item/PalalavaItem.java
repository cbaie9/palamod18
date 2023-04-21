
package palamod.item;

import palamod.init.PalamodModTabs;
import palamod.init.PalamodModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class PalalavaItem extends BucketItem {
	public PalalavaItem() {
		super(PalamodModFluids.PALALAVA, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(PalamodModTabs.TAB_PALAMOD));
	}
}
