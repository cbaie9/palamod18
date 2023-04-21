
package palamod.item;

import palamod.procedures.PaladiumArmorLeggingsTickEventProcedure;
import palamod.procedures.PaladiumArmorHelmetTickEventProcedure;
import palamod.procedures.PaladiumArmorBootsTickEventProcedure;
import palamod.procedures.PaladiumArmorBodyTickEventProcedure;

import palamod.init.PalamodModTabs;
import palamod.init.PalamodModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public abstract class InvisiblearmorItem extends ArmorItem {
	public InvisiblearmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 60;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{7, 8, 8, 7}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 55;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.PALADIUM_INGOT.get()));
			}

			@Override
			public String getName() {
				return "invisiblearmor";
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

	public static class Helmet extends InvisiblearmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/invisible_armor_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PaladiumArmorHelmetTickEventProcedure.execute(entity);
		}
	}

	public static class Chestplate extends InvisiblearmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/invisible_armor_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PaladiumArmorBodyTickEventProcedure.execute(entity);
		}
	}

	public static class Leggings extends InvisiblearmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/invisible_armor_layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PaladiumArmorLeggingsTickEventProcedure.execute(entity);
		}
	}

	public static class Boots extends InvisiblearmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(PalamodModTabs.TAB_PALAMOD));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/invisible_armor_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PaladiumArmorBootsTickEventProcedure.execute(entity);
		}
	}
}
