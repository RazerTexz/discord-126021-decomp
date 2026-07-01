package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SplineSet$ElevationSet extends SplineSet {
    @Override // androidx.constraintlayout.motion.widget.SplineSet
    public void setProperty(View view, float f) {
        view.setElevation(get(f));
    }
}
