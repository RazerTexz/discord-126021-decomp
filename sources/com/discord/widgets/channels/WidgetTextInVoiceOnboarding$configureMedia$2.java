package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.VideoView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding$configureMedia$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetTextInVoiceOnboarding this$0;

    public WidgetTextInVoiceOnboarding$configureMedia$2(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        this.this$0 = widgetTextInVoiceOnboarding;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
        if (videoView.isPlaying()) {
            WidgetTextInVoiceOnboarding.access$showVideoOverlay(this.this$0);
            WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).d.pause();
        } else {
            WidgetTextInVoiceOnboarding.access$hideVideoOverlay(this.this$0);
            WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).d.start();
        }
    }
}
