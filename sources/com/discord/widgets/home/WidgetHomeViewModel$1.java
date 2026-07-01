package com.discord.widgets.home;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel$1 extends o implements Function1<WidgetHomeViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetHomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHomeViewModel$1(WidgetHomeViewModel widgetHomeViewModel) {
        super(1);
        this.this$0 = widgetHomeViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel$StoreState widgetHomeViewModel$StoreState) {
        invoke2(widgetHomeViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetHomeViewModel$StoreState widgetHomeViewModel$StoreState) {
        WidgetHomeViewModel widgetHomeViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetHomeViewModel$StoreState, "storeState");
        WidgetHomeViewModel.access$handleStoreState(widgetHomeViewModel, widgetHomeViewModel$StoreState);
    }
}
