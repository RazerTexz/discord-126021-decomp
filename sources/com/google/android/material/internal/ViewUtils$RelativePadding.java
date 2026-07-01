package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ViewUtils$RelativePadding {
    public int bottom;
    public int end;
    public int start;
    public int top;

    public ViewUtils$RelativePadding(int i, int i2, int i3, int i4) {
        this.start = i;
        this.top = i2;
        this.end = i3;
        this.bottom = i4;
    }

    public void applyToView(View view) {
        ViewCompat.setPaddingRelative(view, this.start, this.top, this.end, this.bottom);
    }

    public ViewUtils$RelativePadding(@NonNull ViewUtils$RelativePadding viewUtils$RelativePadding) {
        this.start = viewUtils$RelativePadding.start;
        this.top = viewUtils$RelativePadding.top;
        this.end = viewUtils$RelativePadding.end;
        this.bottom = viewUtils$RelativePadding.bottom;
    }
}
