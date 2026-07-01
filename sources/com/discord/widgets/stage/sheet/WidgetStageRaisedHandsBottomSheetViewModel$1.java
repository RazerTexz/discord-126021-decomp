package com.discord.widgets.stage.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$1 extends o implements Function1<WidgetStageRaisedHandsBottomSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel$1(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        super(1);
        this.this$0 = widgetStageRaisedHandsBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel$StoreState widgetStageRaisedHandsBottomSheetViewModel$StoreState) {
        invoke2(widgetStageRaisedHandsBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel$StoreState widgetStageRaisedHandsBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetStageRaisedHandsBottomSheetViewModel$StoreState, "storeState");
        WidgetStageRaisedHandsBottomSheetViewModel.access$handleStoreState(this.this$0, widgetStageRaisedHandsBottomSheetViewModel$StoreState);
    }
}
