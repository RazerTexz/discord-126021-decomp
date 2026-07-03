package com.discord.api.message.embed;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmbedImage.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbedImage {
    private final Integer height;
    private final String proxyUrl;
    private final String url;
    private final Integer width;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getProxyUrl() {
        return this.proxyUrl;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedImage)) {
            return false;
        }
        EmbedImage embedImage = (EmbedImage) other;
        return C12238m.areEqual(this.url, embedImage.url) && C12238m.areEqual(this.proxyUrl, embedImage.proxyUrl) && C12238m.areEqual(this.width, embedImage.width) && C12238m.areEqual(this.height, embedImage.height);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.proxyUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.width;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmbedImage(url=");
        sbM833U.append(this.url);
        sbM833U.append(", proxyUrl=");
        sbM833U.append(this.proxyUrl);
        sbM833U.append(", width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        return C1643a.m818F(sbM833U, this.height, ")");
    }
}
