package com.discord.widgets.channels.threads.browser;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived$onResume$1 extends o implements Function1<WidgetThreadBrowserArchivedViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetThreadBrowserArchived this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchived$onResume$1(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        super(1);
        this.this$0 = widgetThreadBrowserArchived;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState) {
        invoke2(widgetThreadBrowserArchivedViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState) {
        m.checkNotNullParameter(widgetThreadBrowserArchivedViewModel$ViewState, "viewState");
        WidgetThreadBrowserArchived.access$updateView(this.this$0, widgetThreadBrowserArchivedViewModel$ViewState);
    }
}
