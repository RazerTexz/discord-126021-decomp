package com.discord.app;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: AppScrollingViewBehavior.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScrollingViewBehavior$a implements OnApplyWindowInsetsListener {
    public Rect a;

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullParameter(view, "v");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        if (this.a == null) {
            this.a = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        Rect rect = this.a;
        if (rect == null) {
            rect = new Rect();
        }
        view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft() + rect.left, rect.top, windowInsetsCompat.getSystemWindowInsetRight() + rect.right, windowInsetsCompat.getSystemWindowInsetTop() + windowInsetsCompat.getSystemWindowInsetBottom() + rect.bottom);
        return windowInsetsCompat;
    }
}
