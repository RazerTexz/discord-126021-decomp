package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel$1 extends o implements Function1<WidgetUserStatusSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetUserStatusSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserStatusSheetViewModel$1(WidgetUserStatusSheetViewModel widgetUserStatusSheetViewModel) {
        super(1);
        this.this$0 = widgetUserStatusSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserStatusSheetViewModel$StoreState widgetUserStatusSheetViewModel$StoreState) {
        invoke2(widgetUserStatusSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserStatusSheetViewModel$StoreState widgetUserStatusSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetUserStatusSheetViewModel$StoreState, "storeState");
        WidgetUserStatusSheetViewModel.access$handleStoreState(this.this$0, widgetUserStatusSheetViewModel$StoreState);
    }
}
