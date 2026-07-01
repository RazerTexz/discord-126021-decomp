package com.discord.widgets.voice.sheet;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$viewModel$2 extends o implements Function0<WidgetVoiceBottomSheetViewModel> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$viewModel$2(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetVoiceBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceBottomSheetViewModel invoke() {
        return new WidgetVoiceBottomSheetViewModel(WidgetVoiceBottomSheet.access$getChannelId$p(this.this$0), WidgetVoiceBottomSheet.access$getForwardToFullscreenIfVideoActivated$p(this.this$0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262140, null);
    }
}
