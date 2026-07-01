package com.discord.widgets.voice.fullscreen;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$viewModel$2 extends o implements Function0<WidgetCallPreviewFullscreenViewModel> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$viewModel$2(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(0);
        this.this$0 = widgetCallPreviewFullscreen;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetCallPreviewFullscreenViewModel invoke() {
        return new WidgetCallPreviewFullscreenViewModel(WidgetCallPreviewFullscreen.access$getVoiceChannelId(this.this$0), null, null, null, null, null, null, null, null, null, null, null, 4094, null);
    }
}
