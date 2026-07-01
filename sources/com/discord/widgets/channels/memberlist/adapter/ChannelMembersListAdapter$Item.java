package com.discord.widgets.channels.memberlist.adapter;

import com.discord.utilities.analytics.Traits$Location$Section;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChannelMembersListAdapter$Item {
    private final Object rowId;
    private final ChannelMembersListAdapter$ViewType type;

    private ChannelMembersListAdapter$Item(ChannelMembersListAdapter$ViewType channelMembersListAdapter$ViewType, Object obj) {
        this.type = channelMembersListAdapter$ViewType;
        this.rowId = obj;
    }

    public Object getRowId() {
        return this.rowId;
    }

    public final ChannelMembersListAdapter$ViewType getType() {
        return this.type;
    }

    public /* synthetic */ ChannelMembersListAdapter$Item(ChannelMembersListAdapter$ViewType channelMembersListAdapter$ViewType, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(channelMembersListAdapter$ViewType, obj);
    }
}
