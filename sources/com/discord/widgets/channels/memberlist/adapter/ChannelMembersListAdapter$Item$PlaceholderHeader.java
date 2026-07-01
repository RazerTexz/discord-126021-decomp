package com.discord.widgets.channels.memberlist.adapter;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$Item$PlaceholderHeader extends ChannelMembersListAdapter$Item {
    private final String listId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$Item$PlaceholderHeader(String str) {
        super(ChannelMembersListAdapter$ViewType.PLACEHOLDER_HEADER, a.w("placeholder:", str), null);
        m.checkNotNullParameter(str, "listId");
        this.listId = str;
    }

    public static /* synthetic */ ChannelMembersListAdapter$Item$PlaceholderHeader copy$default(ChannelMembersListAdapter$Item$PlaceholderHeader channelMembersListAdapter$Item$PlaceholderHeader, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelMembersListAdapter$Item$PlaceholderHeader.listId;
        }
        return channelMembersListAdapter$Item$PlaceholderHeader.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    public final ChannelMembersListAdapter$Item$PlaceholderHeader copy(String listId) {
        m.checkNotNullParameter(listId, "listId");
        return new ChannelMembersListAdapter$Item$PlaceholderHeader(listId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelMembersListAdapter$Item$PlaceholderHeader) && m.areEqual(this.listId, ((ChannelMembersListAdapter$Item$PlaceholderHeader) other).listId);
        }
        return true;
    }

    public final String getListId() {
        return this.listId;
    }

    public int hashCode() {
        String str = this.listId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("PlaceholderHeader(listId="), this.listId, ")");
    }
}
