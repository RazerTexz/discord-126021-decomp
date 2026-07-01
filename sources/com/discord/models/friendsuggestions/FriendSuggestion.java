package com.discord.models.friendsuggestions;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: FriendSuggestion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class FriendSuggestion {
    private final String publicName;
    private final User user;

    public FriendSuggestion(User user, String str) {
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.publicName = str;
    }

    public static /* synthetic */ FriendSuggestion copy$default(FriendSuggestion friendSuggestion, User user, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            user = friendSuggestion.user;
        }
        if ((i & 2) != 0) {
            str = friendSuggestion.publicName;
        }
        return friendSuggestion.copy(user, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPublicName() {
        return this.publicName;
    }

    public final FriendSuggestion copy(User user, String publicName) {
        m.checkNotNullParameter(user, "user");
        return new FriendSuggestion(user, publicName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendSuggestion)) {
            return false;
        }
        FriendSuggestion friendSuggestion = (FriendSuggestion) other;
        return m.areEqual(this.user, friendSuggestion.user) && m.areEqual(this.publicName, friendSuggestion.publicName);
    }

    public final String getPublicName() {
        return this.publicName;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        String str = this.publicName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("FriendSuggestion(user=");
        sbU.append(this.user);
        sbU.append(", publicName=");
        return a.J(sbU, this.publicName, ")");
    }
}
