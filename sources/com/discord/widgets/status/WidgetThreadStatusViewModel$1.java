package com.discord.widgets.status;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel$1 extends o implements Function1<WidgetThreadStatusViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetThreadStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadStatusViewModel$1(WidgetThreadStatusViewModel widgetThreadStatusViewModel) {
        super(1);
        this.this$0 = widgetThreadStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadStatusViewModel$StoreState widgetThreadStatusViewModel$StoreState) {
        invoke2(widgetThreadStatusViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadStatusViewModel$StoreState widgetThreadStatusViewModel$StoreState) {
        m.checkNotNullParameter(widgetThreadStatusViewModel$StoreState, "storeState");
        WidgetThreadStatusViewModel.access$handleStoreState(this.this$0, widgetThreadStatusViewModel$StoreState);
    }
}
