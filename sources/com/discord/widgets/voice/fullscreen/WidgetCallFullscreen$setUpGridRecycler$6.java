package com.discord.widgets.voice.fullscreen;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridLayoutManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$6 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ VideoCallGridLayoutManager $layoutManager;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$setUpGridRecycler$6(WidgetCallFullscreen widgetCallFullscreen, VideoCallGridLayoutManager videoCallGridLayoutManager) {
        this.this$0 = widgetCallFullscreen;
        this.$layoutManager = videoCallGridLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0) {
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).updateOffScreenParticipantsFromScroll(WidgetCallFullscreen.access$getVisibleParticipants(this.this$0, this.$layoutManager));
        }
    }
}
