package com.google.android.material.tooltip;

import android.view.View;
import android.view.View$OnLayoutChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public class TooltipDrawable$a implements View$OnLayoutChangeListener {
    public final /* synthetic */ TooltipDrawable j;

    public TooltipDrawable$a(TooltipDrawable tooltipDrawable) {
        this.j = tooltipDrawable;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        TooltipDrawable.access$000(this.j, view);
    }
}
