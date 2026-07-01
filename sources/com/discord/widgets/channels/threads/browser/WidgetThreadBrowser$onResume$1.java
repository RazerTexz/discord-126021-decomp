package com.discord.widgets.channels.threads.browser;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser$onResume$1 extends o implements Function1<WidgetThreadBrowserViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetThreadBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowser$onResume$1(WidgetThreadBrowser widgetThreadBrowser) {
        super(1);
        this.this$0 = widgetThreadBrowser;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserViewModel$ViewState widgetThreadBrowserViewModel$ViewState) {
        invoke2(widgetThreadBrowserViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadBrowserViewModel$ViewState widgetThreadBrowserViewModel$ViewState) {
        m.checkNotNullParameter(widgetThreadBrowserViewModel$ViewState, "viewState");
        WidgetThreadBrowser.access$updateView(this.this$0, widgetThreadBrowserViewModel$ViewState);
    }
}
