package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetStageStartEventBottomSheetViewModel> {
    public final /* synthetic */ WidgetStageStartEventBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheet$viewModel$2(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        super(0);
        this.this$0 = widgetStageStartEventBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageStartEventBottomSheetViewModel invoke() {
        return new WidgetStageStartEventBottomSheetViewModel(this.this$0.getChannelId(), null, null, null, 14, null);
    }
}
