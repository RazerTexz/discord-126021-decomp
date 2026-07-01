package com.google.android.material.snackbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$m implements OnApplyWindowInsetsListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$m(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        BaseTransientBottomBar.access$902(this.a, windowInsetsCompat.getSystemWindowInsetBottom());
        BaseTransientBottomBar.access$1002(this.a, windowInsetsCompat.getSystemWindowInsetLeft());
        BaseTransientBottomBar.access$1102(this.a, windowInsetsCompat.getSystemWindowInsetRight());
        BaseTransientBottomBar.access$300(this.a);
        return windowInsetsCompat;
    }
}
