package com.discord.widgets.voice.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetVoiceSettingsBottomSheetViewModel> {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheet$viewModel$2(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceSettingsBottomSheetViewModel invoke() {
        return new WidgetVoiceSettingsBottomSheetViewModel(this.this$0.getChannelId(), null, null, null, 14, null);
    }
}
