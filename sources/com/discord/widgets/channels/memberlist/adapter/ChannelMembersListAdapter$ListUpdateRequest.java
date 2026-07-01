package com.discord.widgets.channels.memberlist.adapter;

import b.d.b.a.a;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$ListUpdateRequest {
    private final boolean forceOverwrite;
    private final String listId;
    private final WidgetChannelMembersListViewModel$MemberList rows;

    public ChannelMembersListAdapter$ListUpdateRequest(String str, WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList, boolean z2) {
        m.checkNotNullParameter(str, "listId");
        m.checkNotNullParameter(widgetChannelMembersListViewModel$MemberList, "rows");
        this.listId = str;
        this.rows = widgetChannelMembersListViewModel$MemberList;
        this.forceOverwrite = z2;
    }

    public static /* synthetic */ ChannelMembersListAdapter$ListUpdateRequest copy$default(ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest, String str, WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelMembersListAdapter$ListUpdateRequest.listId;
        }
        if ((i & 2) != 0) {
            widgetChannelMembersListViewModel$MemberList = channelMembersListAdapter$ListUpdateRequest.rows;
        }
        if ((i & 4) != 0) {
            z2 = channelMembersListAdapter$ListUpdateRequest.forceOverwrite;
        }
        return channelMembersListAdapter$ListUpdateRequest.copy(str, widgetChannelMembersListViewModel$MemberList, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetChannelMembersListViewModel$MemberList getRows() {
        return this.rows;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getForceOverwrite() {
        return this.forceOverwrite;
    }

    public final ChannelMembersListAdapter$ListUpdateRequest copy(String listId, WidgetChannelMembersListViewModel$MemberList rows, boolean forceOverwrite) {
        m.checkNotNullParameter(listId, "listId");
        m.checkNotNullParameter(rows, "rows");
        return new ChannelMembersListAdapter$ListUpdateRequest(listId, rows, forceOverwrite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMembersListAdapter$ListUpdateRequest)) {
            return false;
        }
        ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest = (ChannelMembersListAdapter$ListUpdateRequest) other;
        return m.areEqual(this.listId, channelMembersListAdapter$ListUpdateRequest.listId) && m.areEqual(this.rows, channelMembersListAdapter$ListUpdateRequest.rows) && this.forceOverwrite == channelMembersListAdapter$ListUpdateRequest.forceOverwrite;
    }

    public final boolean getForceOverwrite() {
        return this.forceOverwrite;
    }

    public final String getListId() {
        return this.listId;
    }

    public final WidgetChannelMembersListViewModel$MemberList getRows() {
        return this.rows;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.listId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList = this.rows;
        int iHashCode2 = (iHashCode + (widgetChannelMembersListViewModel$MemberList != null ? widgetChannelMembersListViewModel$MemberList.hashCode() : 0)) * 31;
        boolean z2 = this.forceOverwrite;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ListUpdateRequest(listId=");
        sbU.append(this.listId);
        sbU.append(", rows=");
        sbU.append(this.rows);
        sbU.append(", forceOverwrite=");
        return a.O(sbU, this.forceOverwrite, ")");
    }
}
