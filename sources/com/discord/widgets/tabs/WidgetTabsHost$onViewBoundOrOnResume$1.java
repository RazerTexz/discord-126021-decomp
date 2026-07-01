package com.discord.widgets.tabs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost$onViewBoundOrOnResume$1 extends o implements Function1<TabsHostViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetTabsHost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTabsHost$onViewBoundOrOnResume$1(WidgetTabsHost widgetTabsHost) {
        super(1);
        this.this$0 = widgetTabsHost;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel$ViewState tabsHostViewModel$ViewState) {
        invoke2(tabsHostViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TabsHostViewModel$ViewState tabsHostViewModel$ViewState) {
        WidgetTabsHost widgetTabsHost = this.this$0;
        m.checkNotNullExpressionValue(tabsHostViewModel$ViewState, "viewState");
        WidgetTabsHost.access$updateViews(widgetTabsHost, tabsHostViewModel$ViewState);
    }
}
