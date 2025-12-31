package fr.estecka.untamedoffsprings.mixin;

import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.WolfEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class TameableEntityMixin
{
	@Mixin(WolfEntity.class)
	static public class Wolf {
		@Redirect(
			method = "createChild",
			at = @At(value="INVOKE", target="net/minecraft/entity/passive/WolfEntity.isTamed()Z")
		)
		private boolean IgnoreTamed(WolfEntity me) {
			return false;
		}
	}

	@Mixin(CatEntity.class)
	static public class Cat {
		@Redirect(
			method = "createChild",
			at = @At(value="INVOKE", target="net/minecraft/entity/passive/CatEntity.isTamed()Z")
		)
		private boolean IgnoreTamed(CatEntity me) {
			return false;
		}
	}

}
