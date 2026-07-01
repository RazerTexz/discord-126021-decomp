package com.discord.widgets.channels.memberlist.adapter;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$Item$JoinLeaveThread extends ChannelMembersListAdapter$Item {
    private final boolean isThreadJoined;
    private final String rowId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$Item$JoinLeaveThread(String str, boolean z2) {
        super(ChannelMembersListAdapter$ViewType.JOIN_LEAVE_THREAD, str, null);
        m.checkNotNullParameter(str, "rowId");
        this.rowId = str;
        this.isThreadJoined = z2;
    }

    public static /* synthetic */ ChannelMembersListAdapter$Item$JoinLeaveThread copy$default(ChannelMembersListAdapter$Item$JoinLeaveThread channelMembersListAdapter$Item$JoinLeaveThread, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelMembersListAdapter$Item$JoinLeaveThread.getRowId();
        }
        if ((i & 2) != 0) {
            z2 = channelMembersListAdapter$Item$JoinLeaveThread.isThreadJoined;
        }
        return channelMembersListAdapter$Item$JoinLeaveThread.copy(str, z2);
    }

    public final String component1() {
        return getRowId();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsThreadJoined() {
        return this.isThreadJoined;
    }

    public final ChannelMembersListAdapter$Item$JoinLeaveThread copy(String rowId, boolean isThreadJoined) {
        m.checkNotNullParameter(rowId, "rowId");
        return new ChannelMembersListAdapter$Item$JoinLeaveThread(rowId, isThreadJoined);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMembersListAdapter$Item$JoinLeaveThread)) {
            return false;
        }
        ChannelMembersListAdapter$Item$JoinLeaveThread channelMembersListAdapter$Item$JoinLeaveThread = (ChannelMembersListAdapter$Item$JoinLeaveThread) other;
        return m.areEqual(getRowId(), channelMembersListAdapter$Item$JoinLeaveThread.getRowId()) && this.isThreadJoined == channelMembersListAdapter$Item$JoinLeaveThread.isThreadJoined;
    }

    @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item
    public /* bridge */ /* synthetic */ Object getRowId() {
        return getRowId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String rowId = getRowId();
        int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
        boolean z2 = this.isThreadJoined;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isThreadJoined() {
        return this.isThreadJoined;
    }

    public String toString() {
        StringBuilder sbU = a.U("JoinLeaveThread(rowId=");
        sbU.append(getRowId());
        sbU.append(", isThreadJoined=");
        return a.O(sbU, this.isThreadJoined, ")");
    }

    @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item
    public String getRowId() {
        return this.rowId;
    }
}
