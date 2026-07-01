package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelMembersListViewModel$ViewState$Loaded extends WidgetChannelMembersListViewModel$ViewState {
    private final Channel channel;
    private final boolean isOpen;
    private final boolean isThreadJoined;
    private final WidgetChannelMembersListViewModel$MemberList listItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel$ViewState$Loaded(WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList, boolean z2, Channel channel, boolean z3) {
        super(widgetChannelMembersListViewModel$MemberList.getListId(), null);
        m.checkNotNullParameter(widgetChannelMembersListViewModel$MemberList, "listItems");
        this.listItems = widgetChannelMembersListViewModel$MemberList;
        this.isOpen = z2;
        this.channel = channel;
        this.isThreadJoined = z3;
    }

    public static /* synthetic */ WidgetChannelMembersListViewModel$ViewState$Loaded copy$default(WidgetChannelMembersListViewModel$ViewState$Loaded widgetChannelMembersListViewModel$ViewState$Loaded, WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList, boolean z2, Channel channel, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetChannelMembersListViewModel$MemberList = widgetChannelMembersListViewModel$ViewState$Loaded.listItems;
        }
        if ((i & 2) != 0) {
            z2 = widgetChannelMembersListViewModel$ViewState$Loaded.isOpen;
        }
        if ((i & 4) != 0) {
            channel = widgetChannelMembersListViewModel$ViewState$Loaded.channel;
        }
        if ((i & 8) != 0) {
            z3 = widgetChannelMembersListViewModel$ViewState$Loaded.isThreadJoined;
        }
        return widgetChannelMembersListViewModel$ViewState$Loaded.copy(widgetChannelMembersListViewModel$MemberList, z2, channel, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetChannelMembersListViewModel$MemberList getListItems() {
        return this.listItems;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsOpen() {
        return this.isOpen;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsThreadJoined() {
        return this.isThreadJoined;
    }

    public final WidgetChannelMembersListViewModel$ViewState$Loaded copy(WidgetChannelMembersListViewModel$MemberList listItems, boolean isOpen, Channel channel, boolean isThreadJoined) {
        m.checkNotNullParameter(listItems, "listItems");
        return new WidgetChannelMembersListViewModel$ViewState$Loaded(listItems, isOpen, channel, isThreadJoined);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelMembersListViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetChannelMembersListViewModel$ViewState$Loaded widgetChannelMembersListViewModel$ViewState$Loaded = (WidgetChannelMembersListViewModel$ViewState$Loaded) other;
        return m.areEqual(this.listItems, widgetChannelMembersListViewModel$ViewState$Loaded.listItems) && this.isOpen == widgetChannelMembersListViewModel$ViewState$Loaded.isOpen && m.areEqual(this.channel, widgetChannelMembersListViewModel$ViewState$Loaded.channel) && this.isThreadJoined == widgetChannelMembersListViewModel$ViewState$Loaded.isThreadJoined;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final WidgetChannelMembersListViewModel$MemberList getListItems() {
        return this.listItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList = this.listItems;
        int iHashCode = (widgetChannelMembersListViewModel$MemberList != null ? widgetChannelMembersListViewModel$MemberList.hashCode() : 0) * 31;
        boolean z2 = this.isOpen;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (i + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z3 = this.isThreadJoined;
        return iHashCode2 + (z3 ? 1 : z3);
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final boolean isThreadJoined() {
        return this.isThreadJoined;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(listItems=");
        sbU.append(this.listItems);
        sbU.append(", isOpen=");
        sbU.append(this.isOpen);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isThreadJoined=");
        return a.O(sbU, this.isThreadJoined, ")");
    }
}
