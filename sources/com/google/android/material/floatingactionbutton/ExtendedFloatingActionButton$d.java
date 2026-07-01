package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$d extends Property<View, Float> {
    public ExtendedFloatingActionButton$d(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    @NonNull
    public Float get(@NonNull View view) {
        return Float.valueOf(view.getLayoutParams().width);
    }

    @Override // android.util.Property
    public void set(@NonNull View view, @NonNull Float f) {
        View view2 = view;
        view2.getLayoutParams().width = f.intValue();
        view2.requestLayout();
    }
}
