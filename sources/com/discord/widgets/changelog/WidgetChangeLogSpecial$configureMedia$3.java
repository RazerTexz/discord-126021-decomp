package com.discord.widgets.changelog;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnPreparedListener;
import android.widget.VideoView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$configureMedia$3 implements MediaPlayer$OnPreparedListener {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    public WidgetChangeLogSpecial$configureMedia$3(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        this.this$0 = widgetChangeLogSpecial;
    }

    @Override // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        m.checkNotNullParameter(mediaPlayer, "mp");
        mediaPlayer.start();
        mediaPlayer.pause();
        VideoView videoView = WidgetChangeLogSpecial.access$getBinding$p(this.this$0).i;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.getLayoutParams().height = -2;
        WidgetChangeLogSpecial.access$getBinding$p(this.this$0).i.requestLayout();
    }
}
