package com.discord.widgets.tabs;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost$setPanelWindowInsetsListeners$3 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ boolean $isCallStatusVisible;

    public WidgetTabsHost$setPanelWindowInsetsListeners$3(boolean z2) {
        this.$isCallStatusVisible = z2;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop;
        m.checkNotNullExpressionValue(view, "v");
        if (this.$isCallStatusVisible) {
            systemWindowInsetTop = 0;
        } else {
            m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        }
        view.setPadding(view.getPaddingLeft(), systemWindowInsetTop, view.getPaddingRight(), view.getPaddingBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
