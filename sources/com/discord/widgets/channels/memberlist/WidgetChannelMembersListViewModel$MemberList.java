package com.discord.widgets.channels.memberlist;

import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetChannelMembersListViewModel$MemberList {
    public static final WidgetChannelMembersListViewModel$MemberList$Companion Companion = WidgetChannelMembersListViewModel$MemberList$Companion.$$INSTANCE;

    ChannelMembersListAdapter$Item get(int index);

    Integer getHeaderPositionForItem(int itemPosition);

    String getListId();

    int getSize();
}
