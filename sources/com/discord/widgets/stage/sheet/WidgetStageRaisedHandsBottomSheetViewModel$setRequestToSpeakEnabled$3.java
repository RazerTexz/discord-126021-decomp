package com.discord.widgets.stage.sheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$3 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ boolean $isEnabled;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$3(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, boolean z2) {
        super(1);
        this.this$0 = widgetStageRaisedHandsBottomSheetViewModel;
        this.$isEnabled = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r10) {
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(this.this$0);
        if (!(widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p instanceof WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded)) {
            widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p = null;
        }
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded = (WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) widgetStageRaisedHandsBottomSheetViewModel$ViewStateAccess$getViewState$p;
        if (widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded != null) {
            WidgetStageRaisedHandsBottomSheetViewModel.access$updateViewState(this.this$0, WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.copy$default(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded, null, null, this.$isEnabled, false, false, false, 43, null));
        }
    }
}
