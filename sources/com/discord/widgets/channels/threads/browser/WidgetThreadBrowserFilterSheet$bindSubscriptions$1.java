package com.discord.widgets.channels.threads.browser;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet$bindSubscriptions$1 extends o implements Function1<WidgetThreadBrowserArchivedViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetThreadBrowserFilterSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserFilterSheet$bindSubscriptions$1(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        super(1);
        this.this$0 = widgetThreadBrowserFilterSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState) {
        invoke2(widgetThreadBrowserArchivedViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState) {
        m.checkNotNullParameter(widgetThreadBrowserArchivedViewModel$ViewState, "viewState");
        WidgetThreadBrowserFilterSheet.access$configureUI(this.this$0, widgetThreadBrowserArchivedViewModel$ViewState);
    }
}
