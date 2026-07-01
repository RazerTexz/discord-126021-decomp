package com.discord.widgets.changelog;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnCompletionListener;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$configureMedia$1 implements MediaPlayer$OnCompletionListener {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog$configureMedia$1(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // android.media.MediaPlayer$OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        WidgetChangeLog.access$showVideoOverlay(this.this$0);
    }
}
