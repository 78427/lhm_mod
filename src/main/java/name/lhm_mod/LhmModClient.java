package name.lhm_mod;

import name.lhm_mod.entity.ModEntities;
import name.lhm_mod.entity.client.LhmModel;
import name.lhm_mod.entity.client.LhmRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class LhmModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    EntityModelLayerRegistry.registerModelLayer(LhmModel.LHM,LhmModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.Lhm, LhmRenderer::new);
    }
}
