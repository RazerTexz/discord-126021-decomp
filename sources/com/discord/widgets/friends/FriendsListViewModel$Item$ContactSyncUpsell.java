package com.discord.widgets.friends;

import b.d.b.a.a;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Item$ContactSyncUpsell extends FriendsListViewModel$Item {
    private final boolean dismissed;
    private final String key;

    public FriendsListViewModel$Item$ContactSyncUpsell(boolean z2) {
        super(6, null);
        this.dismissed = z2;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ FriendsListViewModel$Item$ContactSyncUpsell copy$default(FriendsListViewModel$Item$ContactSyncUpsell friendsListViewModel$Item$ContactSyncUpsell, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = friendsListViewModel$Item$ContactSyncUpsell.dismissed;
        }
        return friendsListViewModel$Item$ContactSyncUpsell.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getDismissed() {
        return this.dismissed;
    }

    public final FriendsListViewModel$Item$ContactSyncUpsell copy(boolean dismissed) {
        return new FriendsListViewModel$Item$ContactSyncUpsell(dismissed);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendsListViewModel$Item$ContactSyncUpsell) && this.dismissed == ((FriendsListViewModel$Item$ContactSyncUpsell) other).dismissed;
        }
        return true;
    }

    public final boolean getDismissed() {
        return this.dismissed;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        boolean z2 = this.dismissed;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return a.O(a.U("ContactSyncUpsell(dismissed="), this.dismissed, ")");
    }
}
