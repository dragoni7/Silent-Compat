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

public class JoltChainParticle extends TextureSheetParticle {
	protected JoltChainParticle(ClientLevel level, double x, double y, double z) {
		super(level, x, y, z, 0.0D, 0.0D, 0.0D);
		float d = Mth.randomBetween(random, -0.0001f, 0.0001f);
		this.xd *= (double) d;
		this.zd *= (double) d;
		this.lifetime = 4;
		this.hasPhysics = false;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public Provider(SpriteSet set) {
			this.sprite = set;
		}

		public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
				double motionX, double motionY, double motionZ) {
			JoltChainParticle particle = new JoltChainParticle(level, x, y, z);
			particle.pickSprite(this.sprite);
			return particle;
		}
	}

}
