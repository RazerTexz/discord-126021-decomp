package com.discord.widgets.changelog;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.VideoView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$configureMedia$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog$configureMedia$2(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        VideoView videoView = WidgetChangeLog.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            WidgetChangeLog.access$showVideoOverlay(this.this$0);
            WidgetChangeLog.access$getBinding$p(this.this$0).h.pause();
        } else {
            WidgetChangeLog.access$hideVideoOverlay(this.this$0);
            WidgetChangeLog.access$getBinding$p(this.this$0).h.start();
        }
        WidgetChangeLog.track$default(this.this$0, "change_log_video_interacted", null, false, 2, null);
    }
}
