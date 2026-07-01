package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public class DynamicAnimation$15 extends FloatPropertyCompat {
    public final /* synthetic */ DynamicAnimation this$0;
    public final /* synthetic */ FloatValueHolder val$floatValueHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicAnimation$15(DynamicAnimation dynamicAnimation, String str, FloatValueHolder floatValueHolder) {
        super(str);
        this.this$0 = dynamicAnimation;
        this.val$floatValueHolder = floatValueHolder;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public float getValue(Object obj) {
        return this.val$floatValueHolder.getValue();
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public void setValue(Object obj, float f) {
        this.val$floatValueHolder.setValue(f);
    }
}
