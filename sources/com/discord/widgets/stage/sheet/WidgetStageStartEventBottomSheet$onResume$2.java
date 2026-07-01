package com.discord.widgets.stage.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet$onResume$2 extends o implements Function1<WidgetStageStartEventBottomSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetStageStartEventBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheet$onResume$2(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        super(1);
        this.this$0 = widgetStageStartEventBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetStageStartEventBottomSheetViewModel$ViewState widgetStageStartEventBottomSheetViewModel$ViewState) {
        invoke2(widgetStageStartEventBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetStageStartEventBottomSheetViewModel$ViewState widgetStageStartEventBottomSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetStageStartEventBottomSheetViewModel$ViewState, "viewState");
        WidgetStageStartEventBottomSheet.access$configureUI(this.this$0, widgetStageStartEventBottomSheetViewModel$ViewState);
    }
}
