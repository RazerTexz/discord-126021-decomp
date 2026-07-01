package com.google.android.material.floatingactionbutton;

import android.view.ViewGroup$LayoutParams;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$a implements ExtendedFloatingActionButton$k {
    public final /* synthetic */ ExtendedFloatingActionButton a;

    public ExtendedFloatingActionButton$a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        this.a = extendedFloatingActionButton;
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public ViewGroup$LayoutParams a() {
        return new ViewGroup$LayoutParams(-2, -2);
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getHeight() {
        return this.a.getMeasuredHeight();
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getPaddingEnd() {
        return ExtendedFloatingActionButton.access$100(this.a);
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getPaddingStart() {
        return ExtendedFloatingActionButton.access$000(this.a);
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
    public int getWidth() {
        return ExtendedFloatingActionButton.access$100(this.a) + ExtendedFloatingActionButton.access$000(this.a) + (this.a.getMeasuredWidth() - (this.a.getCollapsedPadding() * 2));
    }
}
