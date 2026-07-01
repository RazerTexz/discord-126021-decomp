package com.discord.widgets.channels.threads.browser;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel$1 extends o implements Function1<WidgetThreadBrowserActiveViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetThreadBrowserActiveViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActiveViewModel$1(WidgetThreadBrowserActiveViewModel widgetThreadBrowserActiveViewModel) {
        super(1);
        this.this$0 = widgetThreadBrowserActiveViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserActiveViewModel$StoreState widgetThreadBrowserActiveViewModel$StoreState) {
        invoke2(widgetThreadBrowserActiveViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadBrowserActiveViewModel$StoreState widgetThreadBrowserActiveViewModel$StoreState) {
        m.checkNotNullParameter(widgetThreadBrowserActiveViewModel$StoreState, "storeState");
        WidgetThreadBrowserActiveViewModel.access$handleStoreState(this.this$0, widgetThreadBrowserActiveViewModel$StoreState);
    }
}
