package com.discord.widgets.changelog;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnPreparedListener;
import android.widget.VideoView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$configureMedia$3 implements MediaPlayer$OnPreparedListener {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog$configureMedia$3(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        m.checkNotNullParameter(mediaPlayer, "mp");
        mediaPlayer.start();
        mediaPlayer.pause();
        VideoView videoView = WidgetChangeLog.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.getLayoutParams().height = -2;
        WidgetChangeLog.access$getBinding$p(this.this$0).h.requestLayout();
    }
}
