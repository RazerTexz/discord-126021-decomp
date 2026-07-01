package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelMembersListViewModel$StoreState {
    private final Channel channel;
    private final boolean isPanelOpen;

    private WidgetChannelMembersListViewModel$StoreState(boolean z2, Channel channel) {
        this.isPanelOpen = z2;
        this.channel = channel;
    }

    public Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
    public boolean getIsPanelOpen() {
        return this.isPanelOpen;
    }

    public /* synthetic */ WidgetChannelMembersListViewModel$StoreState(boolean z2, Channel channel, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, channel);
    }
}
