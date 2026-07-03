package com.discord.api.message.embed;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmbedProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbedProvider {
    private final String name;
    private final String url;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedProvider)) {
            return false;
        }
        EmbedProvider embedProvider = (EmbedProvider) other;
        return C12238m.areEqual(this.name, embedProvider.name) && C12238m.areEqual(this.url, embedProvider.url);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmbedProvider(name=");
        sbM833U.append(this.name);
        sbM833U.append(", url=");
        return C1643a.m822J(sbM833U, this.url, ")");
    }
}
