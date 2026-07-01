package com.discord.widgets.contact_sync;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$1 extends o implements Function1<WidgetContactSyncViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetContactSyncViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSyncViewModel$1(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        super(1);
        this.this$0 = widgetContactSyncViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel$StoreState widgetContactSyncViewModel$StoreState) {
        invoke2(widgetContactSyncViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetContactSyncViewModel$StoreState widgetContactSyncViewModel$StoreState) {
        m.checkNotNullParameter(widgetContactSyncViewModel$StoreState, "storeState");
        WidgetContactSyncViewModel.access$handleStoreState(this.this$0, widgetContactSyncViewModel$StoreState);
    }
}
