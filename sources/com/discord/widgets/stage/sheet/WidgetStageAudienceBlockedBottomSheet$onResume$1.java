package com.discord.widgets.stage.sheet;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageAudienceBlockedBottomSheet$onResume$1 extends k implements Function1<StageAudienceBlockedBottomSheetViewModel$ViewState, Unit> {
    public WidgetStageAudienceBlockedBottomSheet$onResume$1(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        super(1, widgetStageAudienceBlockedBottomSheet, WidgetStageAudienceBlockedBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StageAudienceBlockedBottomSheetViewModel$ViewState stageAudienceBlockedBottomSheetViewModel$ViewState) {
        invoke2(stageAudienceBlockedBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StageAudienceBlockedBottomSheetViewModel$ViewState stageAudienceBlockedBottomSheetViewModel$ViewState) {
        m.checkNotNullParameter(stageAudienceBlockedBottomSheetViewModel$ViewState, "p1");
        WidgetStageAudienceBlockedBottomSheet.access$configureUI((WidgetStageAudienceBlockedBottomSheet) this.receiver, stageAudienceBlockedBottomSheetViewModel$ViewState);
    }
}
