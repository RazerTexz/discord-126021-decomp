package com.discord.widgets.channels.threads.browser;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$1 extends o implements Function1<WidgetThreadBrowserArchivedViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchivedViewModel$1(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        super(1);
        this.this$0 = widgetThreadBrowserArchivedViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserArchivedViewModel$StoreState widgetThreadBrowserArchivedViewModel$StoreState) {
        invoke2(widgetThreadBrowserArchivedViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadBrowserArchivedViewModel$StoreState widgetThreadBrowserArchivedViewModel$StoreState) {
        m.checkNotNullParameter(widgetThreadBrowserArchivedViewModel$StoreState, "storeState");
        WidgetThreadBrowserArchivedViewModel.access$handleStoreState(this.this$0, widgetThreadBrowserArchivedViewModel$StoreState);
    }
}
