package com.discord.widgets.channels;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnInfoListener;
import android.widget.ImageView;
import android.widget.VideoView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding$configureMedia$4 implements MediaPlayer$OnInfoListener {
    public final /* synthetic */ WidgetTextInVoiceOnboarding this$0;

    public WidgetTextInVoiceOnboarding$configureMedia$4(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        this.this$0 = widgetTextInVoiceOnboarding;
    }

    @Override // android.media.MediaPlayer$OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        ImageView imageView = WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(imageView, "binding.textInVoiceOnboardingVideoPlaceholder");
        imageView.setVisibility(4);
        VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
        videoView.getLayoutParams().height = -2;
        WidgetTextInVoiceOnboarding.access$getBinding$p(this.this$0).d.requestLayout();
        return false;
    }
}
