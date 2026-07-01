package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class TimeCycleSplineSet$TranslationZset extends TimeCycleSplineSet {
    @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        view.setTranslationZ(get(f, j, view, keyCache));
        return this.mContinue;
    }
}
