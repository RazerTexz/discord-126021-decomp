package com.google.android.material.progressindicator;

import androidx.dynamicanimation.animation.FloatPropertyCompat;

/* JADX INFO: loaded from: classes3.dex */
public class DeterminateDrawable$a extends FloatPropertyCompat<DeterminateDrawable> {
    public DeterminateDrawable$a(String str) {
        super(str);
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public float getValue(DeterminateDrawable determinateDrawable) {
        return DeterminateDrawable.access$000(determinateDrawable) * 10000.0f;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public void setValue(DeterminateDrawable determinateDrawable, float f) {
        DeterminateDrawable.access$100(determinateDrawable, f / 10000.0f);
    }
}
