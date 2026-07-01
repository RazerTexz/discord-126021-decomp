package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$g extends Property<View, Float> {
    public ExtendedFloatingActionButton$g(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    @NonNull
    public Float get(@NonNull View view) {
        return Float.valueOf(ViewCompat.getPaddingEnd(view));
    }

    @Override // android.util.Property
    public void set(@NonNull View view, @NonNull Float f) {
        View view2 = view;
        ViewCompat.setPaddingRelative(view2, ViewCompat.getPaddingStart(view2), view2.getPaddingTop(), f.intValue(), view2.getPaddingBottom());
    }
}
