package com.discord.widgets.channels;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnPreparedListener;
import android.widget.VideoView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding$configureMedia$3 implements MediaPlayer$OnPreparedListener {
    public final /* synthetic */ WidgetTextInVoiceOnboarding this$0;

    public WidgetTextInVoiceOnboarding$configureMedia$3(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        this.this$0 = widgetTextInVoiceOnboarding;
    }

    @Override // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        m.checkNotNullParameter(mediaPlayer, "mp");
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
        videoView.getLayoutParams().height = -2;
        WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).d.requestLayout();
    }
}
