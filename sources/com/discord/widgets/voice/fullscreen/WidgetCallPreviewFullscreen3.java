package com.discord.widgets.voice.fullscreen;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen3 extends Lambda implements Function0<WidgetCallPreviewFullscreenViewModel> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(0);
        this.this$0 = widgetCallPreviewFullscreen;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetCallPreviewFullscreenViewModel invoke() {
        return new WidgetCallPreviewFullscreenViewModel(this.this$0.getVoiceChannelId(), null, null, null, null, null, null, null, null, null, null, null, 4094, null);
    }
}
