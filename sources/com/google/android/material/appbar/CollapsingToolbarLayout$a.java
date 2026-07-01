package com.google.android.material.appbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingToolbarLayout$a implements OnApplyWindowInsetsListener {
    public final /* synthetic */ CollapsingToolbarLayout a;

    public CollapsingToolbarLayout$a(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.a = collapsingToolbarLayout;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        return this.a.onWindowInsetChanged(windowInsetsCompat);
    }
}
