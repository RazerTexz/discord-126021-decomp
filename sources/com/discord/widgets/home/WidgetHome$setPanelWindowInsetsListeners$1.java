package com.discord.widgets.home;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$setPanelWindowInsetsListeners$1 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetHome this$0;

    public WidgetHome$setPanelWindowInsetsListeners$1(WidgetHome widgetHome) {
        this.this$0 = widgetHome;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        ViewGroup$LayoutParams layoutParams = WidgetHome.access$getBinding$p(this.this$0).e.c.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup$MarginLayoutParams) layoutParams).leftMargin = windowInsetsCompat.getSystemWindowInsetLeft();
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
