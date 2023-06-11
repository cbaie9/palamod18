
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.model.Modeldynamite_model;
import palamod.client.model.ModelGolem_gplacement;
import palamod.client.model.ModelBIG_dynamite2;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PalamodModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelBIG_dynamite2.LAYER_LOCATION, ModelBIG_dynamite2::createBodyLayer);
		event.registerLayerDefinition(Modeldynamite_model.LAYER_LOCATION, Modeldynamite_model::createBodyLayer);
		event.registerLayerDefinition(ModelGolem_gplacement.LAYER_LOCATION, ModelGolem_gplacement::createBodyLayer);
	}
}
