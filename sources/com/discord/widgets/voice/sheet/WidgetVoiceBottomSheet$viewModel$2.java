package com.discord.widgets.voice.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetVoiceBottomSheetViewModel> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$viewModel$2(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceBottomSheetViewModel invoke() {
        return new WidgetVoiceBottomSheetViewModel(this.this$0.getChannelId(), this.this$0.getForwardToFullscreenIfVideoActivated(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262140, null);
    }
}
