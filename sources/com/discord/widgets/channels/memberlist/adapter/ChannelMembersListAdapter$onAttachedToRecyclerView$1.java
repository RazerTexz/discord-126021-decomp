package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$onAttachedToRecyclerView$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ RecyclerView $recyclerView;
    public final /* synthetic */ ChannelMembersListAdapter this$0;

    public ChannelMembersListAdapter$onAttachedToRecyclerView$1(ChannelMembersListAdapter channelMembersListAdapter, RecyclerView recyclerView) {
        this.this$0 = channelMembersListAdapter;
        this.$recyclerView = recyclerView;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ChannelMembersListAdapter.access$getStickyHeadersManager$p(this.this$0).layoutViews(this.$recyclerView);
    }
}
