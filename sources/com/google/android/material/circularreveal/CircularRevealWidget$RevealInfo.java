package com.google.android.material.circularreveal;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class CircularRevealWidget$RevealInfo {
    public static final float INVALID_RADIUS = Float.MAX_VALUE;
    public float centerX;
    public float centerY;
    public float radius;

    public /* synthetic */ CircularRevealWidget$RevealInfo(CircularRevealWidget$a circularRevealWidget$a) {
        this();
    }

    public boolean isInvalid() {
        return this.radius == Float.MAX_VALUE;
    }

    public void set(float f, float f2, float f3) {
        this.centerX = f;
        this.centerY = f2;
        this.radius = f3;
    }

    private CircularRevealWidget$RevealInfo() {
    }

    public CircularRevealWidget$RevealInfo(float f, float f2, float f3) {
        this.centerX = f;
        this.centerY = f2;
        this.radius = f3;
    }

    public void set(@NonNull CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        set(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo.centerY, circularRevealWidget$RevealInfo.radius);
    }

    public CircularRevealWidget$RevealInfo(@NonNull CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        this(circularRevealWidget$RevealInfo.centerX, circularRevealWidget$RevealInfo.centerY, circularRevealWidget$RevealInfo.radius);
    }
}
