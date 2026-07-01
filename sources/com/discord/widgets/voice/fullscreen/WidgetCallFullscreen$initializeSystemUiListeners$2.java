package com.discord.widgets.voice.fullscreen;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$initializeSystemUiListeners$2 implements OnApplyWindowInsetsListener {
    public static final WidgetCallFullscreen$initializeSystemUiListeners$2 INSTANCE = new WidgetCallFullscreen$initializeSystemUiListeners$2();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullExpressionValue(view, "view");
        m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
        view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
        return windowInsetsCompat;
    }
}
