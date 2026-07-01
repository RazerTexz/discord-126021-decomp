package androidx.transition;

import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils$1 extends Property<View, Float> {
    public ViewUtils$1(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(View view) {
        return get2(view);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(View view, Float f) {
        set2(view, f);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(View view) {
        return Float.valueOf(ViewUtils.getTransitionAlpha(view));
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(View view, Float f) {
        ViewUtils.setTransitionAlpha(view, f.floatValue());
    }
}
