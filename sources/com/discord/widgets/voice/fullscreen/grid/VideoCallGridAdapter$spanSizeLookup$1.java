package com.discord.widgets.voice.fullscreen.grid;

import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;

/* JADX INFO: compiled from: VideoCallGridAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridAdapter$spanSizeLookup$1 extends GridLayoutManager$SpanSizeLookup {
    public final /* synthetic */ VideoCallGridAdapter this$0;

    public VideoCallGridAdapter$spanSizeLookup$1(VideoCallGridAdapter videoCallGridAdapter) {
        this.this$0 = videoCallGridAdapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup
    public int getSpanSize(int position) {
        if (this.this$0.getItemCount() == 2) {
            return 2;
        }
        return (this.this$0.getItemCount() % 2 == 1 && position == n.getLastIndex(VideoCallGridAdapter.access$getData$p(this.this$0))) ? 2 : 1;
    }
}
