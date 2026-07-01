package com.discord.api.message.embed;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

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
        return m.areEqual(this.text, embedFooter.text) && m.areEqual(this.iconUrl, embedFooter.iconUrl) && m.areEqual(this.proxyIconUrl, embedFooter.proxyIconUrl);
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
        StringBuilder sbU = a.U("EmbedFooter(text=");
        sbU.append(this.text);
        sbU.append(", iconUrl=");
        sbU.append(this.iconUrl);
        sbU.append(", proxyIconUrl=");
        return a.J(sbU, this.proxyIconUrl, ")");
    }
}
