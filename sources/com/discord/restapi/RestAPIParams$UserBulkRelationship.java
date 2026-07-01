package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$UserBulkRelationship {
    private final String token;
    private final List<Long> user_ids;

    public RestAPIParams$UserBulkRelationship(List<Long> list, String str) {
        m.checkNotNullParameter(list, "user_ids");
        m.checkNotNullParameter(str, "token");
        this.user_ids = list;
        this.token = str;
    }

    private final List<Long> component1() {
        return this.user_ids;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getToken() {
        return this.token;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$UserBulkRelationship copy$default(RestAPIParams$UserBulkRelationship restAPIParams$UserBulkRelationship, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = restAPIParams$UserBulkRelationship.user_ids;
        }
        if ((i & 2) != 0) {
            str = restAPIParams$UserBulkRelationship.token;
        }
        return restAPIParams$UserBulkRelationship.copy(list, str);
    }

    public final RestAPIParams$UserBulkRelationship copy(List<Long> user_ids, String token) {
        m.checkNotNullParameter(user_ids, "user_ids");
        m.checkNotNullParameter(token, "token");
        return new RestAPIParams$UserBulkRelationship(user_ids, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$UserBulkRelationship)) {
            return false;
        }
        RestAPIParams$UserBulkRelationship restAPIParams$UserBulkRelationship = (RestAPIParams$UserBulkRelationship) other;
        return m.areEqual(this.user_ids, restAPIParams$UserBulkRelationship.user_ids) && m.areEqual(this.token, restAPIParams$UserBulkRelationship.token);
    }

    public int hashCode() {
        List<Long> list = this.user_ids;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.token;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserBulkRelationship(user_ids=");
        sbU.append(this.user_ids);
        sbU.append(", token=");
        return a.J(sbU, this.token, ")");
    }
}
