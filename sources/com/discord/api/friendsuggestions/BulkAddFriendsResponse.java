package com.discord.api.friendsuggestions;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BulkAddFriendsResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BulkAddFriendsResponse {
    private final List<String> failedRequests;
    private final List<String> successfulRequests;

    /* JADX INFO: renamed from: a */
    public final List<String> m7826a() {
        return this.failedRequests;
    }

    /* JADX INFO: renamed from: b */
    public final List<String> m7827b() {
        return this.successfulRequests;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BulkAddFriendsResponse)) {
            return false;
        }
        BulkAddFriendsResponse bulkAddFriendsResponse = (BulkAddFriendsResponse) other;
        return C12238m.areEqual(this.successfulRequests, bulkAddFriendsResponse.successfulRequests) && C12238m.areEqual(this.failedRequests, bulkAddFriendsResponse.failedRequests);
    }

    public int hashCode() {
        List<String> list = this.successfulRequests;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.failedRequests;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BulkAddFriendsResponse(successfulRequests=");
        sbM833U.append(this.successfulRequests);
        sbM833U.append(", failedRequests=");
        return C1643a.m824L(sbM833U, this.failedRequests, ")");
    }
}
