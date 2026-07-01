package com.discord.widgets.tabs;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost$setPanelWindowInsetsListeners$4 implements OnApplyWindowInsetsListener {
    public static final WidgetTabsHost$setPanelWindowInsetsListeners$4 INSTANCE = new WidgetTabsHost$setPanelWindowInsetsListeners$4();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullExpressionValue(view, "v");
        m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
