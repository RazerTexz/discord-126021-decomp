package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$a implements OnApplyWindowInsetsListener {
    public final /* synthetic */ AppBarLayout a;

    public AppBarLayout$a(AppBarLayout appBarLayout) {
        this.a = appBarLayout;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.a.onWindowInsetChanged(windowInsetsCompat);
    }
}
