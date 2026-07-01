package com.discord.widgets.channels.memberlist.adapter;

import androidx.annotation.StringRes;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$Item$AddMember extends ChannelMembersListAdapter$Item {
    private final String rowId;
    private final int title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$Item$AddMember(String str, @StringRes int i) {
        super(ChannelMembersListAdapter$ViewType.ADD_MEMBER, str, null);
        m.checkNotNullParameter(str, "rowId");
        this.rowId = str;
        this.title = i;
    }

    public static /* synthetic */ ChannelMembersListAdapter$Item$AddMember copy$default(ChannelMembersListAdapter$Item$AddMember channelMembersListAdapter$Item$AddMember, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelMembersListAdapter$Item$AddMember.getRowId();
        }
        if ((i2 & 2) != 0) {
            i = channelMembersListAdapter$Item$AddMember.title;
        }
        return channelMembersListAdapter$Item$AddMember.copy(str, i);
    }

    public final String component1() {
        return getRowId();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    public final ChannelMembersListAdapter$Item$AddMember copy(String rowId, @StringRes int title) {
        m.checkNotNullParameter(rowId, "rowId");
        return new ChannelMembersListAdapter$Item$AddMember(rowId, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMembersListAdapter$Item$AddMember)) {
            return false;
        }
        ChannelMembersListAdapter$Item$AddMember channelMembersListAdapter$Item$AddMember = (ChannelMembersListAdapter$Item$AddMember) other;
        return m.areEqual(getRowId(), channelMembersListAdapter$Item$AddMember.getRowId()) && this.title == channelMembersListAdapter$Item$AddMember.title;
    }

    @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item
    public /* bridge */ /* synthetic */ Object getRowId() {
        return getRowId();
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        String rowId = getRowId();
        return ((rowId != null ? rowId.hashCode() : 0) * 31) + this.title;
    }

    public String toString() {
        StringBuilder sbU = a.U("AddMember(rowId=");
        sbU.append(getRowId());
        sbU.append(", title=");
        return a.B(sbU, this.title, ")");
    }

    @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item
    public String getRowId() {
        return this.rowId;
    }
}
