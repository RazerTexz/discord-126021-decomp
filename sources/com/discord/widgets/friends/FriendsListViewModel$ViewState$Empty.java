package com.discord.widgets.friends;

import b.d.b.a.a;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$ViewState$Empty extends FriendsListViewModel$ViewState {
    private final boolean showContactSyncIcon;

    public FriendsListViewModel$ViewState$Empty(boolean z2) {
        super(null);
        this.showContactSyncIcon = z2;
    }

    public static /* synthetic */ FriendsListViewModel$ViewState$Empty copy$default(FriendsListViewModel$ViewState$Empty friendsListViewModel$ViewState$Empty, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = friendsListViewModel$ViewState$Empty.showContactSyncIcon;
        }
        return friendsListViewModel$ViewState$Empty.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowContactSyncIcon() {
        return this.showContactSyncIcon;
    }

    public final FriendsListViewModel$ViewState$Empty copy(boolean showContactSyncIcon) {
        return new FriendsListViewModel$ViewState$Empty(showContactSyncIcon);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendsListViewModel$ViewState$Empty) && this.showContactSyncIcon == ((FriendsListViewModel$ViewState$Empty) other).showContactSyncIcon;
        }
        return true;
    }

    public final boolean getShowContactSyncIcon() {
        return this.showContactSyncIcon;
    }

    public int hashCode() {
        boolean z2 = this.showContactSyncIcon;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return a.O(a.U("Empty(showContactSyncIcon="), this.showContactSyncIcon, ")");
    }
}
