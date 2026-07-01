package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class TimeCycleSplineSet$TranslationXset extends TimeCycleSplineSet {
    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        view.setTranslationX(get(f, j, view, keyCache));
        return this.mContinue;
    }
}
