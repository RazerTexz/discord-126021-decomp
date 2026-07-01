package com.google.android.material.transition;

import androidx.annotation.FloatRange;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialContainerTransform$ProgressThresholds {

    @FloatRange(from = 0.0d, to = 1.0d)
    private final float end;

    @FloatRange(from = 0.0d, to = 1.0d)
    private final float start;

    public MaterialContainerTransform$ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.start = f;
        this.end = f2;
    }

    public static /* synthetic */ float access$1000(MaterialContainerTransform$ProgressThresholds materialContainerTransform$ProgressThresholds) {
        return materialContainerTransform$ProgressThresholds.start;
    }

    public static /* synthetic */ float access$1100(MaterialContainerTransform$ProgressThresholds materialContainerTransform$ProgressThresholds) {
        return materialContainerTransform$ProgressThresholds.end;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getEnd() {
        return this.end;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getStart() {
        return this.start;
    }
}
