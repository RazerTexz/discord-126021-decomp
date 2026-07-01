package com.discord.widgets.voice.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet7 extends Lambda implements Function0<WidgetVoiceBottomSheetViewModel> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet7(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceBottomSheetViewModel invoke() {
        return new WidgetVoiceBottomSheetViewModel(this.this$0.getChannelId(), this.this$0.getForwardToFullscreenIfVideoActivated(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262140, null);
    }
}
