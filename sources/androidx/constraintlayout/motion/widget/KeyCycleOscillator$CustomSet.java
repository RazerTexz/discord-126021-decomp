package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycleOscillator$CustomSet extends KeyCycleOscillator {
    public float[] value = new float[1];

    @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
    public void setProperty(View view, float f) {
        this.value[0] = get(f);
        this.mCustom.setInterpolatedValue(view, this.value);
    }
}
