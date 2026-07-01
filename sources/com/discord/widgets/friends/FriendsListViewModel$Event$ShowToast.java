package com.discord.widgets.friends;

import b.d.b.a.a;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Event$ShowToast extends FriendsListViewModel$Event {
    private final int stringRes;

    public FriendsListViewModel$Event$ShowToast(int i) {
        super(null);
        this.stringRes = i;
    }

    public static /* synthetic */ FriendsListViewModel$Event$ShowToast copy$default(FriendsListViewModel$Event$ShowToast friendsListViewModel$Event$ShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = friendsListViewModel$Event$ShowToast.stringRes;
        }
        return friendsListViewModel$Event$ShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }

    public final FriendsListViewModel$Event$ShowToast copy(int stringRes) {
        return new FriendsListViewModel$Event$ShowToast(stringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendsListViewModel$Event$ShowToast) && this.stringRes == ((FriendsListViewModel$Event$ShowToast) other).stringRes;
        }
        return true;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    public int hashCode() {
        return this.stringRes;
    }

    public String toString() {
        return a.B(a.U("ShowToast(stringRes="), this.stringRes, ")");
    }
}
