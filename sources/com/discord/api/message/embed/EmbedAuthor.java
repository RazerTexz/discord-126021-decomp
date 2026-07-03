package com.discord.api.message.embed;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmbedAuthor.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbedAuthor {
    private final String iconUrl;
    private final String name;
    private final String proxyIconUrl;
    private final String url;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getProxyIconUrl() {
        return this.proxyIconUrl;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedAuthor)) {
            return false;
        }
        EmbedAuthor embedAuthor = (EmbedAuthor) other;
        return C12238m.areEqual(this.name, embedAuthor.name) && C12238m.areEqual(this.url, embedAuthor.url) && C12238m.areEqual(this.iconUrl, embedAuthor.iconUrl) && C12238m.areEqual(this.proxyIconUrl, embedAuthor.proxyIconUrl);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.iconUrl;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.proxyIconUrl;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmbedAuthor(name=");
        sbM833U.append(this.name);
        sbM833U.append(", url=");
        sbM833U.append(this.url);
        sbM833U.append(", iconUrl=");
        sbM833U.append(this.iconUrl);
        sbM833U.append(", proxyIconUrl=");
        return C1643a.m822J(sbM833U, this.proxyIconUrl, ")");
    }
}
