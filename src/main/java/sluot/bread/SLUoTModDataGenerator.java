package sluot.bread;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import sluot.bread.datagen.ModBlockTagProvider;
import sluot.bread.datagen.ModItemTagProvider;
import sluot.bread.datagen.ModModelsProvider;
import sluot.bread.datagen.ModRecipesProvider;

public class SLUoTModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
	}
}
