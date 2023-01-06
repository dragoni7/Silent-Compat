package com.github.dragoni7.silentcompat.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ImmuneParticle extends TextureSheetParticle {

	ImmuneParticle(ClientLevel level, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(level, x, y, z, 0.0D, 0.0D, 0.0D);
		this.friction = 0.9F;
		this.gravity = 0.5F;
		this.xd *= (double) 0.1F;
		this.yd *= (double) 0.1F;
		this.zd *= (double) 0.1F;
		this.xd += motionX * 0.2D;
		this.yd += motionY * 0.2D;
		this.zd += motionZ * 0.2D;
		this.quadSize *= 1.4F;
		this.lifetime = 20;
		this.hasPhysics = false;
	}

	public float getQuadSize(float p_105938_) {
		return this.quadSize * Mth.clamp(((float) this.age + p_105938_) / (float) this.lifetime * 32.0F, 0.0F, 1.0F);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class ImmuneParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public ImmuneParticleProvider(SpriteSet sprite) {
			this.sprite = sprite;
		}

		public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x,
				double y, double z, double motionX, double motionY, double motionZ) {
			ImmuneParticle immuneParticle = new ImmuneParticle(level, x, y, z, motionX, motionY + 1.0D, motionZ);
			immuneParticle.pickSprite(this.sprite);
			return immuneParticle;
		}
	}

}
