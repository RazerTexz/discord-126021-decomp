package com.discord.widgets.changelog;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.VideoView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$configureMedia$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    public WidgetChangeLogSpecial$configureMedia$2(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        this.this$0 = widgetChangeLogSpecial;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        VideoView videoView = WidgetChangeLogSpecial.access$getBinding$p(this.this$0).i;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            WidgetChangeLogSpecial.access$showVideoOverlay(this.this$0);
            WidgetChangeLogSpecial.access$getBinding$p(this.this$0).i.pause();
        } else {
            WidgetChangeLogSpecial.access$hideVideoOverlay(this.this$0);
            WidgetChangeLogSpecial.access$getBinding$p(this.this$0).i.start();
        }
        WidgetChangeLogSpecial.track$default(this.this$0, "change_log_video_interacted", null, false, 2, null);
    }
}
