package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class TimeCycleSplineSet$ScaleXset extends TimeCycleSplineSet {
    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        view.setScaleX(get(f, j, view, keyCache));
        return this.mContinue;
    }
}
