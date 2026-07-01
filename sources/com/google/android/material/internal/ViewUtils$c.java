package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ViewUtils$c implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ViewUtils$OnApplyWindowInsetsListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewUtils$RelativePadding f3049b;

    public ViewUtils$c(ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener, ViewUtils$RelativePadding viewUtils$RelativePadding) {
        this.a = viewUtils$OnApplyWindowInsetsListener;
        this.f3049b = viewUtils$RelativePadding;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.a.onApplyWindowInsets(view, windowInsetsCompat, new ViewUtils$RelativePadding(this.f3049b));
    }
}
