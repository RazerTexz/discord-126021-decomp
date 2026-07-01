package com.discord.widgets.channels.memberlist;

import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$MemberList$Companion$EMPTY$1 implements WidgetChannelMembersListViewModel$MemberList {
    private final String listId = "";
    private final int size;

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList
    public ChannelMembersListAdapter$Item get(int index) {
        throw new IllegalStateException("");
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList
    public Integer getHeaderPositionForItem(int itemPosition) {
        return 0;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList
    public int getSize() {
        return this.size;
    }
}
