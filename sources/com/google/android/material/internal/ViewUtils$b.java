package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ViewUtils$b implements ViewUtils$OnApplyWindowInsetsListener {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3048b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ViewUtils$OnApplyWindowInsetsListener d;

    public ViewUtils$b(boolean z2, boolean z3, boolean z4, ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener) {
        this.a = z2;
        this.f3048b = z3;
        this.c = z4;
        this.d = viewUtils$OnApplyWindowInsetsListener;
    }

    @Override // com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener
    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils$RelativePadding viewUtils$RelativePadding) {
        if (this.a) {
            viewUtils$RelativePadding.bottom = windowInsetsCompat.getSystemWindowInsetBottom() + viewUtils$RelativePadding.bottom;
        }
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view);
        if (this.f3048b) {
            if (zIsLayoutRtl) {
                viewUtils$RelativePadding.end = windowInsetsCompat.getSystemWindowInsetLeft() + viewUtils$RelativePadding.end;
            } else {
                viewUtils$RelativePadding.start = windowInsetsCompat.getSystemWindowInsetLeft() + viewUtils$RelativePadding.start;
            }
        }
        if (this.c) {
            if (zIsLayoutRtl) {
                viewUtils$RelativePadding.start = windowInsetsCompat.getSystemWindowInsetRight() + viewUtils$RelativePadding.start;
            } else {
                viewUtils$RelativePadding.end = windowInsetsCompat.getSystemWindowInsetRight() + viewUtils$RelativePadding.end;
            }
        }
        viewUtils$RelativePadding.applyToView(view);
        ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener = this.d;
        return viewUtils$OnApplyWindowInsetsListener != null ? viewUtils$OnApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat, viewUtils$RelativePadding) : windowInsetsCompat;
    }
}
