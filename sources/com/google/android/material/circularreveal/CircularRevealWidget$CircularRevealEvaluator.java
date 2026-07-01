package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CircularRevealWidget$CircularRevealEvaluator implements TypeEvaluator<CircularRevealWidget$RevealInfo> {
    public static final TypeEvaluator<CircularRevealWidget$RevealInfo> CIRCULAR_REVEAL = new CircularRevealWidget$CircularRevealEvaluator();
    private final CircularRevealWidget$RevealInfo revealInfo = new CircularRevealWidget$RevealInfo((CircularRevealWidget$a) null);

    @Override // android.animation.TypeEvaluator
    @NonNull
    public /* bridge */ /* synthetic */ CircularRevealWidget$RevealInfo evaluate(float f, @NonNull CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo, @NonNull CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2) {
        return evaluate2(f, circularRevealWidget$RevealInfo, circularRevealWidget$RevealInfo2);
    }

    @NonNull
    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public CircularRevealWidget$RevealInfo evaluate2(float f, @NonNull CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo, @NonNull CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2) {
        this.revealInfo.set(MathUtils.lerp(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo2.centerX, f), MathUtils.lerp(circularRevealWidget$RevealInfo.centerY, circularRevealWidget$RevealInfo2.centerY, f), MathUtils.lerp(circularRevealWidget$RevealInfo.radius, circularRevealWidget$RevealInfo2.radius, f));
        return this.revealInfo;
    }
}
