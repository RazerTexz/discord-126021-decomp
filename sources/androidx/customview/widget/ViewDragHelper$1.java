package androidx.customview.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper$1 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
