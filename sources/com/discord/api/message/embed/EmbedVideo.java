package com.discord.api.message.embed;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: EmbedVideo.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbedVideo {
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
        if (!(other instanceof EmbedVideo)) {
            return false;
        }
        EmbedVideo embedVideo = (EmbedVideo) other;
        return m.areEqual(this.url, embedVideo.url) && m.areEqual(this.proxyUrl, embedVideo.proxyUrl) && m.areEqual(this.height, embedVideo.height) && m.areEqual(this.width, embedVideo.width);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.proxyUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.height;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.width;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("EmbedVideo(url=");
        sbU.append(this.url);
        sbU.append(", proxyUrl=");
        sbU.append(this.proxyUrl);
        sbU.append(", height=");
        sbU.append(this.height);
        sbU.append(", width=");
        return a.F(sbU, this.width, ")");
    }
}
