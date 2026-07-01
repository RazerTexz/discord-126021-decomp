package com.discord.widgets.stage.sheet;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StageAudienceBlockedBottomSheetViewModel$1 extends k implements Function1<StageAudienceBlockedBottomSheetViewModel$StoreState, Unit> {
    public StageAudienceBlockedBottomSheetViewModel$1(StageAudienceBlockedBottomSheetViewModel stageAudienceBlockedBottomSheetViewModel) {
        super(1, stageAudienceBlockedBottomSheetViewModel, StageAudienceBlockedBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StageAudienceBlockedBottomSheetViewModel$StoreState stageAudienceBlockedBottomSheetViewModel$StoreState) {
        invoke2(stageAudienceBlockedBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StageAudienceBlockedBottomSheetViewModel$StoreState stageAudienceBlockedBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(stageAudienceBlockedBottomSheetViewModel$StoreState, "p1");
        StageAudienceBlockedBottomSheetViewModel.access$handleStoreState((StageAudienceBlockedBottomSheetViewModel) this.receiver, stageAudienceBlockedBottomSheetViewModel$StoreState);
    }
}
