package com.discord.widgets.channels.memberlist.adapter;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$Item$Header extends ChannelMembersListAdapter$Item {
    private final ChannelMembersListAdapter$Item$Header$Type headerType;
    private final int memberCount;
    private final String rowId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$Item$Header(String str, ChannelMembersListAdapter$Item$Header$Type channelMembersListAdapter$Item$Header$Type, int i) {
        super(ChannelMembersListAdapter$ViewType.HEADER, str, null);
        m.checkNotNullParameter(str, "rowId");
        m.checkNotNullParameter(channelMembersListAdapter$Item$Header$Type, "headerType");
        this.rowId = str;
        this.headerType = channelMembersListAdapter$Item$Header$Type;
        this.memberCount = i;
    }

    public static /* synthetic */ ChannelMembersListAdapter$Item$Header copy$default(ChannelMembersListAdapter$Item$Header channelMembersListAdapter$Item$Header, String str, ChannelMembersListAdapter$Item$Header$Type channelMembersListAdapter$Item$Header$Type, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelMembersListAdapter$Item$Header.getRowId();
        }
        if ((i2 & 2) != 0) {
            channelMembersListAdapter$Item$Header$Type = channelMembersListAdapter$Item$Header.headerType;
        }
        if ((i2 & 4) != 0) {
            i = channelMembersListAdapter$Item$Header.memberCount;
        }
        return channelMembersListAdapter$Item$Header.copy(str, channelMembersListAdapter$Item$Header$Type, i);
    }

    public final String component1() {
        return getRowId();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ChannelMembersListAdapter$Item$Header$Type getHeaderType() {
        return this.headerType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    public final ChannelMembersListAdapter$Item$Header copy(String rowId, ChannelMembersListAdapter$Item$Header$Type headerType, int memberCount) {
        m.checkNotNullParameter(rowId, "rowId");
        m.checkNotNullParameter(headerType, "headerType");
        return new ChannelMembersListAdapter$Item$Header(rowId, headerType, memberCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMembersListAdapter$Item$Header)) {
            return false;
        }
        ChannelMembersListAdapter$Item$Header channelMembersListAdapter$Item$Header = (ChannelMembersListAdapter$Item$Header) other;
        return m.areEqual(getRowId(), channelMembersListAdapter$Item$Header.getRowId()) && m.areEqual(this.headerType, channelMembersListAdapter$Item$Header.headerType) && this.memberCount == channelMembersListAdapter$Item$Header.memberCount;
    }

    public final ChannelMembersListAdapter$Item$Header$Type getHeaderType() {
        return this.headerType;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item
    public /* bridge */ /* synthetic */ Object getRowId() {
        return getRowId();
    }

    public int hashCode() {
        String rowId = getRowId();
        int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
        ChannelMembersListAdapter$Item$Header$Type channelMembersListAdapter$Item$Header$Type = this.headerType;
        return ((iHashCode + (channelMembersListAdapter$Item$Header$Type != null ? channelMembersListAdapter$Item$Header$Type.hashCode() : 0)) * 31) + this.memberCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("Header(rowId=");
        sbU.append(getRowId());
        sbU.append(", headerType=");
        sbU.append(this.headerType);
        sbU.append(", memberCount=");
        return a.B(sbU, this.memberCount, ")");
    }

    @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item
    public String getRowId() {
        return this.rowId;
    }
}
