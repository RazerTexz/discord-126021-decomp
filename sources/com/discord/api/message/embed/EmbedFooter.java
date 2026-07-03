package com.discord.api.message.embed;

import androidx.core.app.NotificationCompat;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmbedFooter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbedFooter {
    private final String iconUrl;
    private final String proxyIconUrl;
    private final String text;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getProxyIconUrl() {
        return this.proxyIconUrl;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedFooter)) {
            return false;
        }
        EmbedFooter embedFooter = (EmbedFooter) other;
        return C12238m.areEqual(this.text, embedFooter.text) && C12238m.areEqual(this.iconUrl, embedFooter.iconUrl) && C12238m.areEqual(this.proxyIconUrl, embedFooter.proxyIconUrl);
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.iconUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.proxyIconUrl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmbedFooter(text=");
        sbM833U.append(this.text);
        sbM833U.append(", iconUrl=");
        sbM833U.append(this.iconUrl);
        sbM833U.append(", proxyIconUrl=");
        return C1643a.m822J(sbM833U, this.proxyIconUrl, ")");
    }
}
