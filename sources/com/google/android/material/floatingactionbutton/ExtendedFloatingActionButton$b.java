package com.google.android.material.floatingactionbutton;

import android.view.ViewGroup$LayoutParams;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$b implements ExtendedFloatingActionButton$k {
    public final /* synthetic */ ExtendedFloatingActionButton a;

    public ExtendedFloatingActionButton$b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        this.a = extendedFloatingActionButton;
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public ViewGroup$LayoutParams a() {
        return new ViewGroup$LayoutParams(this.a.getCollapsedSize(), this.a.getCollapsedSize());
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getHeight() {
        return this.a.getCollapsedSize();
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getPaddingEnd() {
        return this.a.getCollapsedPadding();
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getPaddingStart() {
        return this.a.getCollapsedPadding();
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getWidth() {
        return this.a.getCollapsedSize();
    }
}
