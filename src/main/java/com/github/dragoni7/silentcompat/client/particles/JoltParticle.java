package com.github.dragoni7.silentcompat.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class JoltParticle extends TextureSheetParticle {

	protected JoltParticle(ClientLevel level, double x, double y, double z) {
		super(level, x, y, z, 0.0D, 0.0D, 0.0D);
		this.friction = 0.7F;
		float d = level.random.nextFloat() + 2.0f;
		this.xd *= (double) d;
		this.yd *= (double) d;
		this.zd *= (double) d;
		this.lifetime = 16;
		this.quadSize *= 1.1;
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
			JoltParticle particle = new JoltParticle(level, x, y, z);
			particle.pickSprite(this.sprite);
			return particle;
		}
	}

}
