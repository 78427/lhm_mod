
package name.lhm_mod.entity.custom;

import name.lhm_mod.entity.ModEntities;
import name.lhm_mod.registry.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LhmEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public LhmEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0,new SwimGoal(this));
        this.goalSelector.add(1,new TemptGoal(this,10D, Ingredient.ofItems(ModItems.LHMBOYFRIEND),false));
        this.goalSelector.add(2,new AnimalMateGoal(this,1.15D));
        this.goalSelector.add(3,new FollowParentGoal(this,1.1D));
        this.goalSelector.add(3,new WanderAroundFarGoal(this,1.0D));
        this.goalSelector.add(4,new LookAtEntityGoal(this, PlayerEntity.class,10.0F));
        this.goalSelector.add(5,new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,1)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.4)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,20);
    }

    public boolean isBreedingItem(ItemStack stack){
        return stack.isOf(ModItems.LHMBOYFRIEND);
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout<=0){
            this.idleAnimationTimeout=40;
            this.idleAnimationState.start(this.age);
        }
        else{
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick(){
        super.tick();

        if(this.getWorld().isClient()){
            this.setupAnimationStates();
        }
    }
    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.Lhm.create(world);
    }
}

