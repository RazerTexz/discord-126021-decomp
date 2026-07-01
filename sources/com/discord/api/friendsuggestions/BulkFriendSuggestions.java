package com.discord.api.friendsuggestions;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: BulkFriendSuggestions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BulkFriendSuggestions {
    private final String bulkAddToken;
    private final List<FriendSuggestion> friendSuggestions;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getBulkAddToken() {
        return this.bulkAddToken;
    }

    public final List<FriendSuggestion> b() {
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
        return Intrinsics3.areEqual(this.bulkAddToken, bulkFriendSuggestions.bulkAddToken) && Intrinsics3.areEqual(this.friendSuggestions, bulkFriendSuggestions.friendSuggestions);
    }

    public int hashCode() {
        String str = this.bulkAddToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FriendSuggestion> list = this.friendSuggestions;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("BulkFriendSuggestions(bulkAddToken=");
        sbU.append(this.bulkAddToken);
        sbU.append(", friendSuggestions=");
        return outline.L(sbU, this.friendSuggestions, ")");
    }
}
