package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycleOscillator$AlphaSet extends KeyCycleOscillator {
    @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
    public void setProperty(View view, float f) {
        view.setAlpha(get(f));
    }
}
