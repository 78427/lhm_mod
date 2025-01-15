package name.lhm_mod.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent LHMBOYFRIEND = new FoodComponent.Builder().meat().statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS,200),1.0f).build();
}
