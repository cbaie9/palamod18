package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.client.gui.screens.Screen;

public class HangboostProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.HANGGLIDER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.HANGGLIDER.get()) {
			if (itemstack.getOrCreateTag().getBoolean("hang_glider_setup")) {
				itemstack.getOrCreateTag().putBoolean("hang_glider_setup", (true));
				itemstack.getOrCreateTag().putBoolean("hang_state", (false));
			}
			if (itemstack.getOrCreateTag().getBoolean("hang_state")) {
				if (Screen.hasShiftDown()) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 4, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 99999, 1, (false), (false)));
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 99999, 1, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 99999, 2, (false), (false)));
				}
				itemstack.getOrCreateTag().putBoolean("hang_state", (false));
			} else {
				itemstack.getOrCreateTag().putBoolean("hang_state", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SLOW_FALLING);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			}
		}
	}
}
