package com.discord.widgets.channels.threads.browser;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel$1 extends o implements Function1<WidgetThreadBrowserViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetThreadBrowserViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserViewModel$1(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel) {
        super(1);
        this.this$0 = widgetThreadBrowserViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserViewModel$StoreState widgetThreadBrowserViewModel$StoreState) {
        invoke2(widgetThreadBrowserViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadBrowserViewModel$StoreState widgetThreadBrowserViewModel$StoreState) {
        m.checkNotNullParameter(widgetThreadBrowserViewModel$StoreState, "storeState");
        WidgetThreadBrowserViewModel.access$handleStoreState(this.this$0, widgetThreadBrowserViewModel$StoreState);
    }
}
