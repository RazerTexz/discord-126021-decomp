package com.discord.api.message.embed;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.name, embedAuthor.name) && Intrinsics3.areEqual(this.url, embedAuthor.url) && Intrinsics3.areEqual(this.iconUrl, embedAuthor.iconUrl) && Intrinsics3.areEqual(this.proxyIconUrl, embedAuthor.proxyIconUrl);
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
        StringBuilder sbU = outline.U("EmbedAuthor(name=");
        sbU.append(this.name);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", iconUrl=");
        sbU.append(this.iconUrl);
        sbU.append(", proxyIconUrl=");
        return outline.J(sbU, this.proxyIconUrl, ")");
    }
}
