package slut.bread;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import slut.bread.datagen.SLUTModBlockTagProvider;
import slut.bread.datagen.SLUTModItemTagProvider;
import slut.bread.datagen.SLUTModModelsProvider;

public class SLUTModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(SLUTModBlockTagProvider::new);
		pack.addProvider(SLUTModItemTagProvider::new);
		pack.addProvider(SLUTModModelsProvider::new);
	}
}
