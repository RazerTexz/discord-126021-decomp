package com.discord.widgets.friends;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$ListSections {
    private final FriendsListViewModel$Item$ContactSyncUpsell contactSyncUpsell;
    private final List<FriendsListViewModel$Item> friendsItemsWithHeaders;
    private final FriendsListViewModel$Item$PendingHeader pendingHeaderItem;
    private final List<FriendsListViewModel$Item> pendingItems;
    private final List<FriendsListViewModel$Item$SuggestedFriend> suggestedFriendItems;
    private final FriendsListViewModel$Item$SuggestedFriendsHeader suggestionsHeaderItem;

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsListViewModel$ListSections(FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeader, List<FriendsListViewModel$Item$SuggestedFriend> list, FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader, List<? extends FriendsListViewModel$Item> list2, List<? extends FriendsListViewModel$Item> list3, FriendsListViewModel$Item$ContactSyncUpsell friendsListViewModel$Item$ContactSyncUpsell) {
        m.checkNotNullParameter(list, "suggestedFriendItems");
        m.checkNotNullParameter(list2, "pendingItems");
        m.checkNotNullParameter(list3, "friendsItemsWithHeaders");
        this.suggestionsHeaderItem = friendsListViewModel$Item$SuggestedFriendsHeader;
        this.suggestedFriendItems = list;
        this.pendingHeaderItem = friendsListViewModel$Item$PendingHeader;
        this.pendingItems = list2;
        this.friendsItemsWithHeaders = list3;
        this.contactSyncUpsell = friendsListViewModel$Item$ContactSyncUpsell;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FriendsListViewModel$ListSections copy$default(FriendsListViewModel$ListSections friendsListViewModel$ListSections, FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeader, List list, FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader, List list2, List list3, FriendsListViewModel$Item$ContactSyncUpsell friendsListViewModel$Item$ContactSyncUpsell, int i, Object obj) {
        if ((i & 1) != 0) {
            friendsListViewModel$Item$SuggestedFriendsHeader = friendsListViewModel$ListSections.suggestionsHeaderItem;
        }
        if ((i & 2) != 0) {
            list = friendsListViewModel$ListSections.suggestedFriendItems;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            friendsListViewModel$Item$PendingHeader = friendsListViewModel$ListSections.pendingHeaderItem;
        }
        FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader2 = friendsListViewModel$Item$PendingHeader;
        if ((i & 8) != 0) {
            list2 = friendsListViewModel$ListSections.pendingItems;
        }
        List list5 = list2;
        if ((i & 16) != 0) {
            list3 = friendsListViewModel$ListSections.friendsItemsWithHeaders;
        }
        List list6 = list3;
        if ((i & 32) != 0) {
            friendsListViewModel$Item$ContactSyncUpsell = friendsListViewModel$ListSections.contactSyncUpsell;
        }
        return friendsListViewModel$ListSections.copy(friendsListViewModel$Item$SuggestedFriendsHeader, list4, friendsListViewModel$Item$PendingHeader2, list5, list6, friendsListViewModel$Item$ContactSyncUpsell);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FriendsListViewModel$Item$SuggestedFriendsHeader getSuggestionsHeaderItem() {
        return this.suggestionsHeaderItem;
    }

    public final List<FriendsListViewModel$Item$SuggestedFriend> component2() {
        return this.suggestedFriendItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FriendsListViewModel$Item$PendingHeader getPendingHeaderItem() {
        return this.pendingHeaderItem;
    }

    public final List<FriendsListViewModel$Item> component4() {
        return this.pendingItems;
    }

    public final List<FriendsListViewModel$Item> component5() {
        return this.friendsItemsWithHeaders;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final FriendsListViewModel$Item$ContactSyncUpsell getContactSyncUpsell() {
        return this.contactSyncUpsell;
    }

    public final FriendsListViewModel$ListSections copy(FriendsListViewModel$Item$SuggestedFriendsHeader suggestionsHeaderItem, List<FriendsListViewModel$Item$SuggestedFriend> suggestedFriendItems, FriendsListViewModel$Item$PendingHeader pendingHeaderItem, List<? extends FriendsListViewModel$Item> pendingItems, List<? extends FriendsListViewModel$Item> friendsItemsWithHeaders, FriendsListViewModel$Item$ContactSyncUpsell contactSyncUpsell) {
        m.checkNotNullParameter(suggestedFriendItems, "suggestedFriendItems");
        m.checkNotNullParameter(pendingItems, "pendingItems");
        m.checkNotNullParameter(friendsItemsWithHeaders, "friendsItemsWithHeaders");
        return new FriendsListViewModel$ListSections(suggestionsHeaderItem, suggestedFriendItems, pendingHeaderItem, pendingItems, friendsItemsWithHeaders, contactSyncUpsell);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$ListSections)) {
            return false;
        }
        FriendsListViewModel$ListSections friendsListViewModel$ListSections = (FriendsListViewModel$ListSections) other;
        return m.areEqual(this.suggestionsHeaderItem, friendsListViewModel$ListSections.suggestionsHeaderItem) && m.areEqual(this.suggestedFriendItems, friendsListViewModel$ListSections.suggestedFriendItems) && m.areEqual(this.pendingHeaderItem, friendsListViewModel$ListSections.pendingHeaderItem) && m.areEqual(this.pendingItems, friendsListViewModel$ListSections.pendingItems) && m.areEqual(this.friendsItemsWithHeaders, friendsListViewModel$ListSections.friendsItemsWithHeaders) && m.areEqual(this.contactSyncUpsell, friendsListViewModel$ListSections.contactSyncUpsell);
    }

    public final FriendsListViewModel$Item$ContactSyncUpsell getContactSyncUpsell() {
        return this.contactSyncUpsell;
    }

    public final List<FriendsListViewModel$Item> getFriendsItemsWithHeaders() {
        return this.friendsItemsWithHeaders;
    }

    public final FriendsListViewModel$Item$PendingHeader getPendingHeaderItem() {
        return this.pendingHeaderItem;
    }

    public final List<FriendsListViewModel$Item> getPendingItems() {
        return this.pendingItems;
    }

    public final List<FriendsListViewModel$Item$SuggestedFriend> getSuggestedFriendItems() {
        return this.suggestedFriendItems;
    }

    public final FriendsListViewModel$Item$SuggestedFriendsHeader getSuggestionsHeaderItem() {
        return this.suggestionsHeaderItem;
    }

    public int hashCode() {
        FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeader = this.suggestionsHeaderItem;
        int iHashCode = (friendsListViewModel$Item$SuggestedFriendsHeader != null ? friendsListViewModel$Item$SuggestedFriendsHeader.hashCode() : 0) * 31;
        List<FriendsListViewModel$Item$SuggestedFriend> list = this.suggestedFriendItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader = this.pendingHeaderItem;
        int iHashCode3 = (iHashCode2 + (friendsListViewModel$Item$PendingHeader != null ? friendsListViewModel$Item$PendingHeader.hashCode() : 0)) * 31;
        List<FriendsListViewModel$Item> list2 = this.pendingItems;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<FriendsListViewModel$Item> list3 = this.friendsItemsWithHeaders;
        int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        FriendsListViewModel$Item$ContactSyncUpsell friendsListViewModel$Item$ContactSyncUpsell = this.contactSyncUpsell;
        return iHashCode5 + (friendsListViewModel$Item$ContactSyncUpsell != null ? friendsListViewModel$Item$ContactSyncUpsell.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ListSections(suggestionsHeaderItem=");
        sbU.append(this.suggestionsHeaderItem);
        sbU.append(", suggestedFriendItems=");
        sbU.append(this.suggestedFriendItems);
        sbU.append(", pendingHeaderItem=");
        sbU.append(this.pendingHeaderItem);
        sbU.append(", pendingItems=");
        sbU.append(this.pendingItems);
        sbU.append(", friendsItemsWithHeaders=");
        sbU.append(this.friendsItemsWithHeaders);
        sbU.append(", contactSyncUpsell=");
        sbU.append(this.contactSyncUpsell);
        sbU.append(")");
        return sbU.toString();
    }
}
