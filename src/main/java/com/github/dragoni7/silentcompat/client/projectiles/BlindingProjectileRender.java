package com.github.dragoni7.silentcompat.client.projectiles;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.projectiles.BlindingProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.model.ShulkerBulletModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BlindingProjectileRender extends EntityRenderer<BlindingProjectile> {
	
	private static final ResourceLocation BLINDING_PROJECTILE_LOCATION = new ResourceLocation(SilentCompat.MODID, "textures/entity/blinding_projectile.png");
	private static final RenderType RENDER_TYPE = RenderType.entityTranslucent(BLINDING_PROJECTILE_LOCATION);
	
	private final ShulkerBulletModel<BlindingProjectile> model;

	public BlindingProjectileRender(EntityRendererProvider.Context context) {
		super(context);
		this.model = new ShulkerBulletModel<>(context.getModelSet().bakeLayer(ModelLayers.SHULKER_BULLET));
	}

	protected int getBlockLightLevel(BlindingProjectile projectile, BlockPos pos) {
		return 15;
	}

	public void render(BlindingProjectile projectile, float p_115863_, float p_115375_, PoseStack poseStack, MultiBufferSource source, int p_115378_) {
		poseStack.pushPose();
		
		float f = Mth.rotlerp(projectile.yRotO, projectile.getYRot(), p_115375_);
		float f1 = Mth.lerp(p_115375_, projectile.xRotO, projectile.getXRot());
		float f2 = (float) projectile.tickCount + p_115375_;
		poseStack.translate(0.0D, (double) 0.15F, 0.0D);
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.sin(f2 * 0.1F) * 180.0F));
		poseStack.mulPose(Vector3f.XP.rotationDegrees(Mth.cos(f2 * 0.1F) * 180.0F));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.sin(f2 * 0.15F) * 360.0F));
		poseStack.scale(-0.5F, -0.5F, 0.5F);
		this.model.setupAnim(projectile, 0.0F, 0.0F, 0.0F, f, f1);
		
		VertexConsumer vertexconsumer = source.getBuffer(RENDER_TYPE);
		this.model.renderToBuffer(poseStack, vertexconsumer, p_115378_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.9F);
		poseStack.scale(1.5F, 1.5F, 1.5F);
		VertexConsumer vertexconsumer1 = source.getBuffer(RENDER_TYPE);
	    this.model.renderToBuffer(poseStack, vertexconsumer1, p_115378_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);
		poseStack.popPose();
		super.render(projectile, p_115863_, p_115375_, poseStack, source, p_115378_);
	}

	@Override
	public ResourceLocation getTextureLocation(BlindingProjectile projectile) {
		return BLINDING_PROJECTILE_LOCATION;
	}

}
