package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$f extends Property<View, Float> {
    public ExtendedFloatingActionButton$f(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    @NonNull
    public Float get(@NonNull View view) {
        return Float.valueOf(ViewCompat.getPaddingStart(view));
    }

    @Override // android.util.Property
    public void set(@NonNull View view, @NonNull Float f) {
        View view2 = view;
        ViewCompat.setPaddingRelative(view2, f.intValue(), view2.getPaddingTop(), ViewCompat.getPaddingEnd(view2), view2.getPaddingBottom());
    }
}
