package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SplineSet$PathRotate extends SplineSet {
    public void setPathRotate(View view, float f, double d, double d2) {
        view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
    }

    @Override // androidx.constraintlayout.motion.widget.SplineSet
    public void setProperty(View view, float f) {
    }
}
