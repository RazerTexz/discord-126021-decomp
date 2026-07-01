package com.discord.widgets.stage.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel$1 extends o implements Function1<WidgetStageStartEventBottomSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetStageStartEventBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel$1(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel) {
        super(1);
        this.this$0 = widgetStageStartEventBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetStageStartEventBottomSheetViewModel$StoreState widgetStageStartEventBottomSheetViewModel$StoreState) {
        invoke2(widgetStageStartEventBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetStageStartEventBottomSheetViewModel$StoreState widgetStageStartEventBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetStageStartEventBottomSheetViewModel$StoreState, "storeState");
        WidgetStageStartEventBottomSheetViewModel.access$handleStoreState(this.this$0, widgetStageStartEventBottomSheetViewModel$StoreState);
    }
}
