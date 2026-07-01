package com.discord.widgets.home;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentContainerView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$setPanelWindowInsetsListeners$3 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetHome this$0;

    public WidgetHome$setPanelWindowInsetsListeners$3(WidgetHome widgetHome) {
        this.this$0 = widgetHome;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        FragmentContainerView fragmentContainerView = WidgetHome.access$getBinding$p(this.this$0).f.c;
        m.checkNotNullExpressionValue(fragmentContainerView, "binding.panelRight.widgetConnectedList");
        fragmentContainerView.setPadding(fragmentContainerView.getPaddingLeft(), fragmentContainerView.getPaddingTop(), fragmentContainerView.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
