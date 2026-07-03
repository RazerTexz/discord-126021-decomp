package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet$viewModel$2 extends AbstractC12240o implements Function0<StageAudienceBlockedBottomSheetViewModel> {
    public final /* synthetic */ WidgetStageAudienceBlockedBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageAudienceBlockedBottomSheet$viewModel$2(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        super(0);
        this.this$0 = widgetStageAudienceBlockedBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StageAudienceBlockedBottomSheetViewModel invoke() {
        return new StageAudienceBlockedBottomSheetViewModel(this.this$0.getChannelId(), null, 2, null);
    }
}
