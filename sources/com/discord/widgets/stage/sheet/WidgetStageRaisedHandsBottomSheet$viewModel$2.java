package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetStageRaisedHandsBottomSheetViewModel> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheet$viewModel$2(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        super(0);
        this.this$0 = widgetStageRaisedHandsBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageRaisedHandsBottomSheetViewModel invoke() {
        return new WidgetStageRaisedHandsBottomSheetViewModel(this.this$0.getChannelId(), null, null, null, null, null, null, null, 254, null);
    }
}
