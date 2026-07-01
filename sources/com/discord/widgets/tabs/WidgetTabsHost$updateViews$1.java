package com.discord.widgets.tabs;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTabsHost$updateViews$1 extends k implements Function1<NavigationTab, Unit> {
    public WidgetTabsHost$updateViews$1(TabsHostViewModel tabsHostViewModel) {
        super(1, tabsHostViewModel, TabsHostViewModel.class, "selectTab", "selectTab(Lcom/discord/widgets/tabs/NavigationTab;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NavigationTab navigationTab) {
        invoke2(navigationTab);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NavigationTab navigationTab) {
        m.checkNotNullParameter(navigationTab, "p1");
        ((TabsHostViewModel) this.receiver).selectTab(navigationTab);
    }
}
