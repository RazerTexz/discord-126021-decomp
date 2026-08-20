package com.discord.widgets.channels.memberlist;

import com.discord.utilities.collections.SparseMutableList;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import java.util.Set;
import java.util.SortedMap;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildMemberListItems implements WidgetChannelMembersListViewModel.MemberList {
    private final SortedMap<Integer, String> groupIndices;
    private final String listId;
    private final SparseMutableList<ChannelMembersListAdapter.Item> listItems;
    private final int size;

    public GuildMemberListItems(String str, int i, SparseMutableList<ChannelMembersListAdapter.Item> sparseMutableList, SortedMap<Integer, String> sortedMap) {
        C12238m.checkNotNullParameter(str, "listId");
        C12238m.checkNotNullParameter(sparseMutableList, "listItems");
        C12238m.checkNotNullParameter(sortedMap, "groupIndices");
        this.listId = str;
        this.size = i;
        this.listItems = sparseMutableList;
        this.groupIndices = sortedMap;
    }

    private final SparseMutableList<ChannelMembersListAdapter.Item> component3() {
        return this.listItems;
    }

    private final SortedMap<Integer, String> component4() {
        return this.groupIndices;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildMemberListItems copy$default(GuildMemberListItems guildMemberListItems, String str, int i, SparseMutableList sparseMutableList, SortedMap sortedMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = guildMemberListItems.getListId();
        }
        if ((i2 & 2) != 0) {
            i = guildMemberListItems.getSize();
        }
        if ((i2 & 4) != 0) {
            sparseMutableList = guildMemberListItems.listItems;
        }
        if ((i2 & 8) != 0) {
            sortedMap = guildMemberListItems.groupIndices;
        }
        return guildMemberListItems.copy(str, i, sparseMutableList, sortedMap);
    }

    public final String component1() {
        return getListId();
    }

    public final int component2() {
        return getSize();
    }

    public final GuildMemberListItems copy(String listId, int size, SparseMutableList<ChannelMembersListAdapter.Item> listItems, SortedMap<Integer, String> groupIndices) {
        C12238m.checkNotNullParameter(listId, "listId");
        C12238m.checkNotNullParameter(listItems, "listItems");
        C12238m.checkNotNullParameter(groupIndices, "groupIndices");
        return new GuildMemberListItems(listId, size, listItems, groupIndices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberListItems)) {
            return false;
        }
        GuildMemberListItems guildMemberListItems = (GuildMemberListItems) other;
        return C12238m.areEqual(getListId(), guildMemberListItems.getListId()) && getSize() == guildMemberListItems.getSize() && C12238m.areEqual(this.listItems, guildMemberListItems.listItems) && C12238m.areEqual(this.groupIndices, guildMemberListItems.groupIndices);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public ChannelMembersListAdapter.Item get(int index) {
        ChannelMembersListAdapter.Item item = this.listItems.get(index);
        return item != null ? item : (ChannelMembersListAdapter.Item) GuildMemberListItemGeneratorKt.PLACEHOLDER_INSTANCES.get(index % GuildMemberListItemGeneratorKt.PLACEHOLDER_INSTANCES.size());
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public Integer getHeaderPositionForItem(int itemPosition) {
        Set<Integer> setKeySet = this.groupIndices.keySet();
        C12238m.checkNotNullExpressionValue(setKeySet, "groupIndices.keys");
        Object obj = null;
        for (Object obj2 : setKeySet) {
            if (((Integer) obj2).intValue() < itemPosition + 1) {
                obj = obj2;
            }
        }
        return (Integer) obj;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public int getSize() {
        return this.size;
    }

    public int hashCode() {
        String listId = getListId();
        int size = (getSize() + ((listId != null ? listId.hashCode() : 0) * 31)) * 31;
        SparseMutableList<ChannelMembersListAdapter.Item> sparseMutableList = this.listItems;
        int iHashCode = (size + (sparseMutableList != null ? sparseMutableList.hashCode() : 0)) * 31;
        SortedMap<Integer, String> sortedMap = this.groupIndices;
        return iHashCode + (sortedMap != null ? sortedMap.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildMemberListItems(listId=");
        sbM833U.append(getListId());
        sbM833U.append(", size=");
        sbM833U.append(getSize());
        sbM833U.append(", listItems=");
        sbM833U.append(this.listItems);
        sbM833U.append(", groupIndices=");
        sbM833U.append(this.groupIndices);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
