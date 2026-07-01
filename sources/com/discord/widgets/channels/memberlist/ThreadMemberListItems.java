package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ThreadMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ThreadMemberListItems implements WidgetChannelMembersListViewModel$MemberList {
    private final String listId;
    private final List<ChannelMembersListAdapter$Item> listItems;

    public ThreadMemberListItems(String str, List<ChannelMembersListAdapter$Item> list) {
        m.checkNotNullParameter(str, "listId");
        m.checkNotNullParameter(list, "listItems");
        this.listId = str;
        this.listItems = list;
    }

    private final List<ChannelMembersListAdapter$Item> component2() {
        return this.listItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThreadMemberListItems copy$default(ThreadMemberListItems threadMemberListItems, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = threadMemberListItems.getListId();
        }
        if ((i & 2) != 0) {
            list = threadMemberListItems.listItems;
        }
        return threadMemberListItems.copy(str, list);
    }

    public final String component1() {
        return getListId();
    }

    public final ThreadMemberListItems copy(String listId, List<ChannelMembersListAdapter$Item> listItems) {
        m.checkNotNullParameter(listId, "listId");
        m.checkNotNullParameter(listItems, "listItems");
        return new ThreadMemberListItems(listId, listItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMemberListItems)) {
            return false;
        }
        ThreadMemberListItems threadMemberListItems = (ThreadMemberListItems) other;
        return m.areEqual(getListId(), threadMemberListItems.getListId()) && m.areEqual(this.listItems, threadMemberListItems.listItems);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList
    public ChannelMembersListAdapter$Item get(int index) {
        return this.listItems.get(index);
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
        return this.listItems.size();
    }

    public int hashCode() {
        String listId = getListId();
        int iHashCode = (listId != null ? listId.hashCode() : 0) * 31;
        List<ChannelMembersListAdapter$Item> list = this.listItems;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadMemberListItems(listId=");
        sbU.append(getListId());
        sbU.append(", listItems=");
        return a.L(sbU, this.listItems, ")");
    }
}
