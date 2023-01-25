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

public class VoidParticles extends TextureSheetParticle {
	
	protected VoidParticles(ClientLevel level, double x, double y, double z) {
		super(level, x, y, z, 0.0D, 0.0D, 0.0D);
		float d = level.random.nextFloat() + 0.5f;
		this.yd *= (double) d;
		this.lifetime = 12;
		this.quadSize *= level.random.nextFloat();
		this.hasPhysics = true;
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
			VoidParticles particle = new VoidParticles(level, x, y, z);
			particle.pickSprite(this.sprite);
			return particle;
		}
	}
}
