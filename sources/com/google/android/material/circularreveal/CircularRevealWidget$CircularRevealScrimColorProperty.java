package com.google.android.material.circularreveal;

import android.util.Property;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class CircularRevealWidget$CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
    public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealWidget$CircularRevealScrimColorProperty("circularRevealScrimColor");

    private CircularRevealWidget$CircularRevealScrimColorProperty(String str) {
        super(Integer.class, str);
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Integer get(@NonNull CircularRevealWidget circularRevealWidget) {
        return get2(circularRevealWidget);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget circularRevealWidget, @NonNull Integer num) {
        set2(circularRevealWidget, num);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(@NonNull CircularRevealWidget circularRevealWidget) {
        return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull CircularRevealWidget circularRevealWidget, @NonNull Integer num) {
        circularRevealWidget.setCircularRevealScrimColor(num.intValue());
    }
}
