package com.discord.api.friendsuggestions;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: BulkAddFriendsResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BulkAddFriendsResponse {
    private final List<String> failedRequests;
    private final List<String> successfulRequests;

    public final List<String> a() {
        return this.failedRequests;
    }

    public final List<String> b() {
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
        return m.areEqual(this.successfulRequests, bulkAddFriendsResponse.successfulRequests) && m.areEqual(this.failedRequests, bulkAddFriendsResponse.failedRequests);
    }

    public int hashCode() {
        List<String> list = this.successfulRequests;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.failedRequests;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("BulkAddFriendsResponse(successfulRequests=");
        sbU.append(this.successfulRequests);
        sbU.append(", failedRequests=");
        return a.L(sbU, this.failedRequests, ")");
    }
}
