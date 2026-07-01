package com.discord.widgets.channels.memberlist.adapter;

import androidx.recyclerview.widget.DiffUtil$DiffResult;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$ListUpdateOperation$DiffUpdate extends ChannelMembersListAdapter$ListUpdateOperation {
    private final DiffUtil$DiffResult diffResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$ListUpdateOperation$DiffUpdate(DiffUtil$DiffResult diffUtil$DiffResult, ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest) {
        super(channelMembersListAdapter$ListUpdateRequest, null);
        m.checkNotNullParameter(diffUtil$DiffResult, "diffResult");
        m.checkNotNullParameter(channelMembersListAdapter$ListUpdateRequest, "listUpdateRequest");
        this.diffResult = diffUtil$DiffResult;
    }

    public final DiffUtil$DiffResult getDiffResult() {
        return this.diffResult;
    }
}
