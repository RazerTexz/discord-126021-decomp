package com.discord.api.friendsuggestions;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BulkFriendSuggestions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BulkFriendSuggestions {
    private final String bulkAddToken;
    private final List<FriendSuggestion> friendSuggestions;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getBulkAddToken() {
        return this.bulkAddToken;
    }

    /* JADX INFO: renamed from: b */
    public final List<FriendSuggestion> m7829b() {
        return this.friendSuggestions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BulkFriendSuggestions)) {
            return false;
        }
        BulkFriendSuggestions bulkFriendSuggestions = (BulkFriendSuggestions) other;
        return C12238m.areEqual(this.bulkAddToken, bulkFriendSuggestions.bulkAddToken) && C12238m.areEqual(this.friendSuggestions, bulkFriendSuggestions.friendSuggestions);
    }

    public int hashCode() {
        String str = this.bulkAddToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FriendSuggestion> list = this.friendSuggestions;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BulkFriendSuggestions(bulkAddToken=");
        sbM833U.append(this.bulkAddToken);
        sbM833U.append(", friendSuggestions=");
        return C1643a.m824L(sbM833U, this.friendSuggestions, ")");
    }
}
