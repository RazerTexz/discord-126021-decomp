package com.discord.widgets.stage.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet4 extends Lambda implements Function0<WidgetStageStartEventBottomSheetViewModel> {
    public final /* synthetic */ WidgetStageStartEventBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheet4(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        super(0);
        this.this$0 = widgetStageStartEventBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageStartEventBottomSheetViewModel invoke() {
        return new WidgetStageStartEventBottomSheetViewModel(this.this$0.getChannelId(), null, null, null, 14, null);
    }
}
