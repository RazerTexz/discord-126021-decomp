package com.discord.widgets.channels.memberlist;

import b.d.b.a.outline;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItems, reason: use source file name */
/* JADX INFO: compiled from: PrivateChannelMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PrivateChannelMemberListItemGenerator4 implements WidgetChannelMembersListViewModel.MemberList {
    private final String listId;
    private final List<ChannelMembersListAdapter.Item> listItems;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivateChannelMemberListItemGenerator4(String str, List<? extends ChannelMembersListAdapter.Item> list) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        Intrinsics3.checkNotNullParameter(list, "listItems");
        this.listId = str;
        this.listItems = list;
    }

    private final List<ChannelMembersListAdapter.Item> component2() {
        return this.listItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrivateChannelMemberListItemGenerator4 copy$default(PrivateChannelMemberListItemGenerator4 privateChannelMemberListItemGenerator4, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = privateChannelMemberListItemGenerator4.getListId();
        }
        if ((i & 2) != 0) {
            list = privateChannelMemberListItemGenerator4.listItems;
        }
        return privateChannelMemberListItemGenerator4.copy(str, list);
    }

    public final String component1() {
        return getListId();
    }

    public final PrivateChannelMemberListItemGenerator4 copy(String listId, List<? extends ChannelMembersListAdapter.Item> listItems) {
        Intrinsics3.checkNotNullParameter(listId, "listId");
        Intrinsics3.checkNotNullParameter(listItems, "listItems");
        return new PrivateChannelMemberListItemGenerator4(listId, listItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivateChannelMemberListItemGenerator4)) {
            return false;
        }
        PrivateChannelMemberListItemGenerator4 privateChannelMemberListItemGenerator4 = (PrivateChannelMemberListItemGenerator4) other;
        return Intrinsics3.areEqual(getListId(), privateChannelMemberListItemGenerator4.getListId()) && Intrinsics3.areEqual(this.listItems, privateChannelMemberListItemGenerator4.listItems);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public ChannelMembersListAdapter.Item get(int index) {
        return this.listItems.get(index);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public Integer getHeaderPositionForItem(int itemPosition) {
        return 0;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public int getSize() {
        return this.listItems.size();
    }

    public int hashCode() {
        String listId = getListId();
        int iHashCode = (listId != null ? listId.hashCode() : 0) * 31;
        List<ChannelMembersListAdapter.Item> list = this.listItems;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PrivateChannelMemberListItems(listId=");
        sbU.append(getListId());
        sbU.append(", listItems=");
        return outline.L(sbU, this.listItems, ")");
    }
}
