package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class FloatPropertyCompat$1<T> extends FloatPropertyCompat<T> {
    public final /* synthetic */ FloatProperty val$property;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatPropertyCompat$1(String str, FloatProperty floatProperty) {
        super(str);
        this.val$property = floatProperty;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public float getValue(T t) {
        return ((Float) this.val$property.get(t)).floatValue();
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public void setValue(T t, float f) {
        this.val$property.setValue(t, f);
    }
}
