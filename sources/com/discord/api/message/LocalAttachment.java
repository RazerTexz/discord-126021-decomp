package com.discord.api.message;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LocalAttachment.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class LocalAttachment {
    private final String displayName;
    private final long id;
    private final String uriString;

    public LocalAttachment(long j, String str, String str2) {
        C12238m.checkNotNullParameter(str, "uriString");
        C12238m.checkNotNullParameter(str2, "displayName");
        this.id = j;
        this.uriString = str;
        this.displayName = str2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getUriString() {
        return this.uriString;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalAttachment)) {
            return false;
        }
        LocalAttachment localAttachment = (LocalAttachment) other;
        return this.id == localAttachment.id && C12238m.areEqual(this.uriString, localAttachment.uriString) && C12238m.areEqual(this.displayName, localAttachment.displayName);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.uriString;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.displayName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("LocalAttachment(id=");
        sbM833U.append(this.id);
        sbM833U.append(", uriString=");
        sbM833U.append(this.uriString);
        sbM833U.append(", displayName=");
        return C1643a.m822J(sbM833U, this.displayName, ")");
    }
}
