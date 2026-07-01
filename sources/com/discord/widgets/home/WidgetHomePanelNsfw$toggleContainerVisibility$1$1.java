package com.discord.widgets.home;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelNsfw$toggleContainerVisibility$1$1 implements OnApplyWindowInsetsListener {
    public static final WidgetHomePanelNsfw$toggleContainerVisibility$1$1 INSTANCE = new WidgetHomePanelNsfw$toggleContainerVisibility$1$1();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
