package net.pantheon.oddcore.mixin;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(NoiseBasedChunkGenerator.class)
public class NoiseBasedChunkGeneratorMixin {

    @Inject(
            method = "createFluidPicker",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private static void createFluidPicker(NoiseGeneratorSettings settings, CallbackInfoReturnable<Aquifer.FluidPicker> cir) {
        Aquifer.FluidStatus air = new Aquifer.FluidStatus(-50, Blocks.AIR.defaultBlockState());
        int seaLevel = settings.seaLevel();
        Aquifer.FluidStatus water = new Aquifer.FluidStatus(seaLevel, settings.defaultFluid());
        cir.setReturnValue((var1, var2, var3) -> 
            var2 < Math.min(-50, seaLevel) ? air : water);
    }
}
