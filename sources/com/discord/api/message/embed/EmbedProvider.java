package com.discord.api.message.embed;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.name, embedProvider.name) && Intrinsics3.areEqual(this.url, embedProvider.url);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbedProvider(name=");
        sbU.append(this.name);
        sbU.append(", url=");
        return outline.J(sbU, this.url, ")");
    }
}
