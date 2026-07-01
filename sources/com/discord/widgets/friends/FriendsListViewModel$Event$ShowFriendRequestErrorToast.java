package com.discord.widgets.friends;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Event$ShowFriendRequestErrorToast extends FriendsListViewModel$Event {
    private final int abortCode;
    private final String username;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$Event$ShowFriendRequestErrorToast(int i, String str) {
        super(null);
        m.checkNotNullParameter(str, "username");
        this.abortCode = i;
        this.username = str;
    }

    public static /* synthetic */ FriendsListViewModel$Event$ShowFriendRequestErrorToast copy$default(FriendsListViewModel$Event$ShowFriendRequestErrorToast friendsListViewModel$Event$ShowFriendRequestErrorToast, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = friendsListViewModel$Event$ShowFriendRequestErrorToast.abortCode;
        }
        if ((i2 & 2) != 0) {
            str = friendsListViewModel$Event$ShowFriendRequestErrorToast.username;
        }
        return friendsListViewModel$Event$ShowFriendRequestErrorToast.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAbortCode() {
        return this.abortCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final FriendsListViewModel$Event$ShowFriendRequestErrorToast copy(int abortCode, String username) {
        m.checkNotNullParameter(username, "username");
        return new FriendsListViewModel$Event$ShowFriendRequestErrorToast(abortCode, username);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$Event$ShowFriendRequestErrorToast)) {
            return false;
        }
        FriendsListViewModel$Event$ShowFriendRequestErrorToast friendsListViewModel$Event$ShowFriendRequestErrorToast = (FriendsListViewModel$Event$ShowFriendRequestErrorToast) other;
        return this.abortCode == friendsListViewModel$Event$ShowFriendRequestErrorToast.abortCode && m.areEqual(this.username, friendsListViewModel$Event$ShowFriendRequestErrorToast.username);
    }

    public final int getAbortCode() {
        return this.abortCode;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int i = this.abortCode * 31;
        String str = this.username;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowFriendRequestErrorToast(abortCode=");
        sbU.append(this.abortCode);
        sbU.append(", username=");
        return a.J(sbU, this.username, ")");
    }
}
