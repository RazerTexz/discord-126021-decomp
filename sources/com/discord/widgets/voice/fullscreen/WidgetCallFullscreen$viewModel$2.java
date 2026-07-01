package com.discord.widgets.voice.fullscreen;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$viewModel$2 extends Lambda implements Function0<WidgetCallFullscreenViewModel> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$viewModel$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(0);
        this.this$0 = widgetCallFullscreen;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetCallFullscreenViewModel invoke() {
        return new WidgetCallFullscreenViewModel(this.this$0.getChannelId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this.this$0.getMostRecentIntent().getStringExtra("com.discord.intent.extra.EXTRA_STREAM_KEY"), 134217726, null);
    }
}
