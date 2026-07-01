package com.discord.widgets.stage.sheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$2(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        super(0);
        this.this$0 = widgetStageRaisedHandsBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(this.this$0);
        if (!(widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p instanceof WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded)) {
            widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p = null;
        }
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded = (WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p;
        if (widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded != null) {
            WidgetStageRaisedHandsBottomSheetViewModel.access$updateViewState(this.this$0, WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.copy$default(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded, null, null, false, false, false, false, 31, null));
        }
    }
}
