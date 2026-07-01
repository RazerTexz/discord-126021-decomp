package com.discord.widgets.voice.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet5 extends Lambda implements Function0<WidgetVoiceSettingsBottomSheetViewModel> {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheet5(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceSettingsBottomSheetViewModel invoke() {
        return new WidgetVoiceSettingsBottomSheetViewModel(this.this$0.getChannelId(), null, null, null, 14, null);
    }
}
