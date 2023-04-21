
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class PalamodModTabs {
	public static CreativeModeTab TAB_PALAMOD;
	public static CreativeModeTab TAB_PICKAXEOFGODSTAB;
	public static CreativeModeTab TAB_GRINDERCREATIVETAB;
	public static CreativeModeTab TAB_DECORATIONCREATIVETAB;
	public static CreativeModeTab TAB_PVPCREATIVETAB;
	public static CreativeModeTab TAB_LUCKYBLOCKCREATIVETAB;

	public static void load() {
		TAB_PALAMOD = new CreativeModeTab("tabpalamod") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_PICKAXEOFGODSTAB = new CreativeModeTab("tabpickaxeofgodstab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_1.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_GRINDERCREATIVETAB = new CreativeModeTab("tabgrindercreativetab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PalamodModBlocks.TCV_2.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_DECORATIONCREATIVETAB = new CreativeModeTab("tabdecorationcreativetab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PalamodModBlocks.OSTRYA_WOOD_PLANKS.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_PVPCREATIVETAB = new CreativeModeTab("tabpvpcreativetab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PalamodModItems.STICKOFGODS.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_LUCKYBLOCKCREATIVETAB = new CreativeModeTab("tabluckyblockcreativetab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PalamodModBlocks.LUCKYBLOCK.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
