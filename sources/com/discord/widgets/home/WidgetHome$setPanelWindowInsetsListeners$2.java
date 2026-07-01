package com.discord.widgets.home;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$setPanelWindowInsetsListeners$2 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetHome this$0;

    public WidgetHome$setPanelWindowInsetsListeners$2(WidgetHome widgetHome) {
        this.this$0 = widgetHome;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat$Builder().setSystemWindowInsets(Insets.of(0, 0, 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
        m.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
        ViewCompat.dispatchApplyWindowInsets(WidgetHome.access$getBinding$p(this.this$0).d.c.d, windowInsetsCompatBuild);
        ViewCompat.dispatchApplyWindowInsets(WidgetHome.access$getBinding$p(this.this$0).d.c.e, windowInsetsCompatBuild);
        ViewCompat.dispatchApplyWindowInsets(WidgetHome.access$getBinding$p(this.this$0).d.f136b, windowInsetsCompatBuild);
        WidgetHomePanelNsfw widgetHomePanelNsfwAccess$getPanelNsfw$p = WidgetHome.access$getPanelNsfw$p(this.this$0);
        if (widgetHomePanelNsfwAccess$getPanelNsfw$p != null) {
            widgetHomePanelNsfwAccess$getPanelNsfw$p.dispatchApplyWindowInsets(windowInsetsCompat);
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
