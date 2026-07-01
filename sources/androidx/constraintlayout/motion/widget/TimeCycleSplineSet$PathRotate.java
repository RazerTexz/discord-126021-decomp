package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class TimeCycleSplineSet$PathRotate extends TimeCycleSplineSet {
    public boolean setPathRotate(View view, KeyCache keyCache, float f, long j, double d, double d2) {
        view.setRotation(get(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        return this.mContinue;
    }

    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        return this.mContinue;
    }
}
