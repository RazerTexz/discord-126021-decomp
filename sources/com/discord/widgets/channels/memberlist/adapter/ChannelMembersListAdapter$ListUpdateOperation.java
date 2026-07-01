package com.discord.widgets.channels.memberlist.adapter;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChannelMembersListAdapter$ListUpdateOperation {
    private final ChannelMembersListAdapter$ListUpdateRequest request;

    private ChannelMembersListAdapter$ListUpdateOperation(ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest) {
        this.request = channelMembersListAdapter$ListUpdateRequest;
    }

    public final ChannelMembersListAdapter$ListUpdateRequest getRequest() {
        return this.request;
    }

    public /* synthetic */ ChannelMembersListAdapter$ListUpdateOperation(ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest, DefaultConstructorMarker defaultConstructorMarker) {
        this(channelMembersListAdapter$ListUpdateRequest);
    }
}
