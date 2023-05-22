package palamod.procedures;

import palamod.init.PalamodModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.SimpleParticleType;

public class FseffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9000, 3, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 9000, 3, false, false));
		if (entity instanceof Player _player) {
			_player.getAbilities().mayfly = true;
			_player.onUpdateAbilities();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (PalamodModParticleTypes.FLYPARTICLE.get()), x, y, z, 5, 3, 3, 3, 1);
		if (!net.minecraftforge.fml.ModList.get().isLoaded("oxygene")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("[ Paladium ] Le fly est activ\u00E9"), false);
		}
	}
}
