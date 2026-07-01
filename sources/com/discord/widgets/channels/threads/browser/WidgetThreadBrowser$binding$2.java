package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetThreadBrowserBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowser$binding$2 extends k implements Function1<View, WidgetThreadBrowserBinding> {
    public static final WidgetThreadBrowser$binding$2 INSTANCE = new WidgetThreadBrowser$binding$2();

    public WidgetThreadBrowser$binding$2() {
        super(1, WidgetThreadBrowserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.action_bar_tabs;
        TabLayout tabLayout = (TabLayout) view.findViewById(R$id.action_bar_tabs);
        if (tabLayout != null) {
            i = R$id.thread_browser_toolbar;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R$id.thread_browser_toolbar);
            if (appBarLayout != null) {
                i = R$id.thread_browser_view_pager;
                SimplePager simplePager = (SimplePager) view.findViewById(R$id.thread_browser_view_pager);
                if (simplePager != null) {
                    return new WidgetThreadBrowserBinding((ConstraintLayout) view, tabLayout, appBarLayout, simplePager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
