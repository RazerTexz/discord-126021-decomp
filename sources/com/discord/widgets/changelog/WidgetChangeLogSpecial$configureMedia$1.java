package com.discord.widgets.changelog;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnCompletionListener;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$configureMedia$1 implements MediaPlayer$OnCompletionListener {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    public WidgetChangeLogSpecial$configureMedia$1(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        this.this$0 = widgetChangeLogSpecial;
    }

    @Override // android.media.MediaPlayer$OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        WidgetChangeLogSpecial.access$showVideoOverlay(this.this$0);
    }
}
