package name.lhm_mod.entity.client;

import name.lhm_mod.LhmMod;
import name.lhm_mod.entity.custom.LhmEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LhmRenderer extends MobEntityRenderer<LhmEntity,LhmModel<LhmEntity>> {

    public LhmRenderer(EntityRendererFactory.Context context) {
        super(context, new LhmModel<>(context.getPart(LhmModel.LHM)), 0.75f);
    }

    @Override
    public Identifier getTexture(LhmEntity entity) {
        return Identifier.of(LhmMod.MOD_ID,"textures/entity/lhm/lhm.png");
    }

    public void render(LhmEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider,int i){
        if(livingEntity.isBaby()){
            matrixStack.scale(0.05f,0.05f,0.05f);
        }else{
            matrixStack.scale(0.1f,0.1f,0.1f);
        }
        super.render(livingEntity,f,g,matrixStack,vertexConsumerProvider,i);
    }
}
