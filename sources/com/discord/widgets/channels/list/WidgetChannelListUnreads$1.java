package com.discord.widgets.channels.list;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.discord.utilities.accessibility.AccessibilityUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListUnreads$1 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ WidgetChannelListUnreads this$0;

    public WidgetChannelListUnreads$1(WidgetChannelListUnreads widgetChannelListUnreads) {
        this.this$0 = widgetChannelListUnreads;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0 || newState == 2) {
            WidgetChannelListUnreads.access$handleVisibleRangeUpdate(this.this$0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            WidgetChannelListUnreads.access$handleVisibleRangeUpdate(this.this$0);
        }
    }
}
