package name.lhm_mod.entity.client;

import name.lhm_mod.LhmMod;
import name.lhm_mod.entity.custom.LhmEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class LhmModel<T extends LhmEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer LHM = new EntityModelLayer(Identifier.of(LhmMod.MOD_ID, "lhm"), "main");
    private final ModelPart lhm;
    private final ModelPart body;
    private final ModelPart head;

    public LhmModel(ModelPart root) {
        this.lhm = root.getChild("lhm");
        this.body = this.lhm.getChild("body");
        this.head = lhm.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData lhm = modelPartData.addChild("lhm", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F,0,0,0));

        ModelPartData body = lhm.addChild("body", ModelPartBuilder.create().uv(243, 0).cuboid(-50.0F, -100.0F, -50.0F, 100.0F, 100.0F, 100.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = lhm.addChild("head", ModelPartBuilder.create().uv(83, 202).cuboid(-90.0F, -320.0F, -90.0F, 180.0F, 180.0F, 180.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 1024, 1024);
    }




    @Override
    public void setAngles(LhmEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netheadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netheadYaw,headPitch);

        this.animateMovement(LhmAnimations.MOVE,limbSwing,limbSwingAmount,2f,2.5f);
        this.updateAnimation(entity.idleAnimationState,LhmAnimations.IDLE,ageInTicks,1f);
    }

    public void setHeadAngles(float headYaw,float headPitch){
        headYaw= MathHelper.clamp(headYaw,-30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch,-25.0F,45.0F);

        this.head.yaw=headYaw*0.017453292F;
        this.head.pitch=headPitch*0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay,float red,float green,float blue,float alpha) {
        lhm.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
    }
    public ModelPart getPart(){
        return this.lhm;
    }
}
