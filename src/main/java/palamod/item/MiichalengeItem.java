
package palamod.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MiichalengeItem extends RecordItem {
	public MiichalengeItem() {
		super(7, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("palamod:miichallengemusic")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1100);
	}
}
