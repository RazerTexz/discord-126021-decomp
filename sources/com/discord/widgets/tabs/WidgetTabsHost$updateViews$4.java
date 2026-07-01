package com.discord.widgets.tabs;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTabsHost$updateViews$4 extends k implements Function0<Unit> {
    public WidgetTabsHost$updateViews$4(WidgetTabsHost widgetTabsHost) {
        super(0, widgetTabsHost, WidgetTabsHost.class, "onSearchClick", "onSearchClick()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetTabsHost.access$onSearchClick((WidgetTabsHost) this.receiver);
    }
}
