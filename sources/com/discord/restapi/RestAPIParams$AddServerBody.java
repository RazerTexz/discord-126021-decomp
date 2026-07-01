package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$AddServerBody {
    private final String description;
    private final int primaryCategoryId;

    public RestAPIParams$AddServerBody(String str, int i) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.description = str;
        this.primaryCategoryId = i;
    }

    public static /* synthetic */ RestAPIParams$AddServerBody copy$default(RestAPIParams$AddServerBody restAPIParams$AddServerBody, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = restAPIParams$AddServerBody.description;
        }
        if ((i2 & 2) != 0) {
            i = restAPIParams$AddServerBody.primaryCategoryId;
        }
        return restAPIParams$AddServerBody.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public final RestAPIParams$AddServerBody copy(String description, int primaryCategoryId) {
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return new RestAPIParams$AddServerBody(description, primaryCategoryId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$AddServerBody)) {
            return false;
        }
        RestAPIParams$AddServerBody restAPIParams$AddServerBody = (RestAPIParams$AddServerBody) other;
        return m.areEqual(this.description, restAPIParams$AddServerBody.description) && this.primaryCategoryId == restAPIParams$AddServerBody.primaryCategoryId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public int hashCode() {
        String str = this.description;
        return ((str != null ? str.hashCode() : 0) * 31) + this.primaryCategoryId;
    }

    public String toString() {
        StringBuilder sbU = a.U("AddServerBody(description=");
        sbU.append(this.description);
        sbU.append(", primaryCategoryId=");
        return a.B(sbU, this.primaryCategoryId, ")");
    }
}
