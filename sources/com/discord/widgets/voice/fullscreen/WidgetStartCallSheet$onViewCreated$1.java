package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetStartCallSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStartCallSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ long $voiceChannelId;
    public final /* synthetic */ WidgetStartCallSheet this$0;

    public WidgetStartCallSheet$onViewCreated$1(WidgetStartCallSheet widgetStartCallSheet, long j) {
        this.this$0 = widgetStartCallSheet;
        this.$voiceChannelId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetStartCallSheet.access$getPrivateCallLauncher$p(this.this$0).launchVoiceCall(this.$voiceChannelId);
        this.this$0.dismiss();
    }
}
