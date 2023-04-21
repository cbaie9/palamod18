
package palamod.client.renderer;

import palamod.entity.ElephantlittleEntity;

import palamod.client.model.ModelBIG_dynamite2;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class ElephantlittleRenderer extends MobRenderer<ElephantlittleEntity, ModelBIG_dynamite2<ElephantlittleEntity>> {
	public ElephantlittleRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBIG_dynamite2(context.bakeLayer(ModelBIG_dynamite2.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<ElephantlittleEntity, ModelBIG_dynamite2<ElephantlittleEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("palamod:textures/entities/endium_dyna_t4.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ElephantlittleEntity entity) {
		return new ResourceLocation("palamod:textures/entities/pala_dyna.png");
	}
}
