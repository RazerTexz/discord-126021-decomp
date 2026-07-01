package com.discord.api.friendsuggestions;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
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
        return Intrinsics3.areEqual(this.successfulRequests, bulkAddFriendsResponse.successfulRequests) && Intrinsics3.areEqual(this.failedRequests, bulkAddFriendsResponse.failedRequests);
    }

    public int hashCode() {
        List<String> list = this.successfulRequests;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.failedRequests;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("BulkAddFriendsResponse(successfulRequests=");
        sbU.append(this.successfulRequests);
        sbU.append(", failedRequests=");
        return outline.L(sbU, this.failedRequests, ")");
    }
}
