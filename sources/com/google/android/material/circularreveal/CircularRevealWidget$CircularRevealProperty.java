package com.google.android.material.circularreveal;

import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class CircularRevealWidget$CircularRevealProperty extends Property<CircularRevealWidget, CircularRevealWidget$RevealInfo> {
    public static final Property<CircularRevealWidget, CircularRevealWidget$RevealInfo> CIRCULAR_REVEAL = new CircularRevealWidget$CircularRevealProperty("circularReveal");

    private CircularRevealWidget$CircularRevealProperty(String str) {
        super(CircularRevealWidget$RevealInfo.class, str);
    }

    @Override // android.util.Property
    @Nullable
    public /* bridge */ /* synthetic */ CircularRevealWidget$RevealInfo get(@NonNull CircularRevealWidget circularRevealWidget) {
        return get2(circularRevealWidget);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget circularRevealWidget, @Nullable CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        set2(circularRevealWidget, circularRevealWidget$RevealInfo);
    }

    @Nullable
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public CircularRevealWidget$RevealInfo get2(@NonNull CircularRevealWidget circularRevealWidget) {
        return circularRevealWidget.getRevealInfo();
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull CircularRevealWidget circularRevealWidget, @Nullable CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        circularRevealWidget.setRevealInfo(circularRevealWidget$RevealInfo);
    }
}
