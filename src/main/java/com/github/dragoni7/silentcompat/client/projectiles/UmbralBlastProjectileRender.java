package com.github.dragoni7.silentcompat.client.projectiles;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.projectiles.UmbralBlastProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class UmbralBlastProjectileRender extends EntityRenderer<UmbralBlastProjectile>{
	
	private static final ResourceLocation UMBRAL_BLAST_PROJECTILE_LOCATION = new ResourceLocation(SilentCompat.MODID, "textures/entity/umbral_blast_projectile.png");
	private static final RenderType RENDER_TYPE = RenderType.entityTranslucent(UMBRAL_BLAST_PROJECTILE_LOCATION);
	
	private final UmbralBlastProjectileModel<UmbralBlastProjectile> model;

	public UmbralBlastProjectileRender(EntityRendererProvider.Context context) {
		super(context);
		this.model = new UmbralBlastProjectileModel<>(context.getModelSet().bakeLayer(UmbralBlastProjectileModel.LAYER_LOCATION));
	}
	
	public void render(UmbralBlastProjectile projectile, float p_115374_, float p_115375_, PoseStack poseStack, MultiBufferSource source, int p_115378_) {
		poseStack.pushPose();
		
		float f1 = Mth.lerp(p_115375_, projectile.xRotO, projectile.getXRot());
		float f2 = (float) projectile.tickCount + p_115375_;
		poseStack.translate(0.0D, (double) 0.15F, 0.0D);
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.sin(f2 * 0.1F) * 360.0F));
		poseStack.scale(1.5F, 1.5F, 1.5F);
		this.model.setupAnim(projectile, 0.0F, 0.0F, 0.0F, 0.0F, f1);
		
		VertexConsumer vertexconsumer = source.getBuffer(RENDER_TYPE);
		this.model.renderToBuffer(poseStack, vertexconsumer, p_115378_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.8F);
		poseStack.scale(2.5F, 2.0F, 2.5F);
		VertexConsumer vertexconsumer1 = source.getBuffer(RENDER_TYPE);
	    this.model.renderToBuffer(poseStack, vertexconsumer1, p_115378_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);
		poseStack.popPose();
		super.render(projectile, p_115374_, p_115375_, poseStack, source, p_115378_);
	}

	@Override
	public ResourceLocation getTextureLocation(UmbralBlastProjectile projectile) {
		return UMBRAL_BLAST_PROJECTILE_LOCATION;
	}


}
