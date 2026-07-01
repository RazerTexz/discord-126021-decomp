package androidx.dynamicanimation.animation;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DynamicAnimation$12 extends DynamicAnimation$ViewProperty {
    public DynamicAnimation$12(String str) {
        super(str, null);
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public /* bridge */ /* synthetic */ float getValue(View view) {
        return getValue2(view);
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public /* bridge */ /* synthetic */ void setValue(View view, float f) {
        setValue2(view, f);
    }

    /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
    public float getValue2(View view) {
        return view.getAlpha();
    }

    /* JADX INFO: renamed from: setValue, reason: avoid collision after fix types in other method */
    public void setValue2(View view, float f) {
        view.setAlpha(f);
    }
}
