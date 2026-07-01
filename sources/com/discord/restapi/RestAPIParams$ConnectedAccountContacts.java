package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ConnectedAccountContacts {
    private final boolean friend_sync;
    private final String name;

    public RestAPIParams$ConnectedAccountContacts(String str, boolean z2) {
        this.name = str;
        this.friend_sync = z2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final boolean getFriend_sync() {
        return this.friend_sync;
    }

    public static /* synthetic */ RestAPIParams$ConnectedAccountContacts copy$default(RestAPIParams$ConnectedAccountContacts restAPIParams$ConnectedAccountContacts, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$ConnectedAccountContacts.name;
        }
        if ((i & 2) != 0) {
            z2 = restAPIParams$ConnectedAccountContacts.friend_sync;
        }
        return restAPIParams$ConnectedAccountContacts.copy(str, z2);
    }

    public final RestAPIParams$ConnectedAccountContacts copy(String name, boolean friend_sync) {
        return new RestAPIParams$ConnectedAccountContacts(name, friend_sync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ConnectedAccountContacts)) {
            return false;
        }
        RestAPIParams$ConnectedAccountContacts restAPIParams$ConnectedAccountContacts = (RestAPIParams$ConnectedAccountContacts) other;
        return m.areEqual(this.name, restAPIParams$ConnectedAccountContacts.name) && this.friend_sync == restAPIParams$ConnectedAccountContacts.friend_sync;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.friend_sync;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectedAccountContacts(name=");
        sbU.append(this.name);
        sbU.append(", friend_sync=");
        return a.O(sbU, this.friend_sync, ")");
    }
}
