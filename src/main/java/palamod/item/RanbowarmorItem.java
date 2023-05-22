
package palamod.item;

import palamod.init.PalamodModTabs;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public abstract class RanbowarmorItem extends ArmorItem {
	public RanbowarmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}

			@Override
			public String getName() {
				return "rainbowarmor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends RanbowarmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/ranbow_armor__layer_1.png";
		}
	}

	public static class Chestplate extends RanbowarmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/ranbow_armor__layer_1.png";
		}
	}

	public static class Leggings extends RanbowarmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/ranbow_armor__layer_2.png";
		}
	}

	public static class Boots extends RanbowarmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/ranbow_armor__layer_1.png";
		}
	}
}
