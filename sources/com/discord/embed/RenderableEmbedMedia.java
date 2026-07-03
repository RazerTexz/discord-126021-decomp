package com.discord.embed;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RenderableEmbedMedia.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RenderableEmbedMedia {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Integer width;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Integer height;

    public RenderableEmbedMedia(String str, Integer num, Integer num2) {
        this.url = str;
        this.width = num;
        this.height = num2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenderableEmbedMedia)) {
            return false;
        }
        RenderableEmbedMedia renderableEmbedMedia = (RenderableEmbedMedia) other;
        return C12238m.areEqual(this.url, renderableEmbedMedia.url) && C12238m.areEqual(this.width, renderableEmbedMedia.width) && C12238m.areEqual(this.height, renderableEmbedMedia.height);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.width;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RenderableEmbedMedia(url=");
        sbM833U.append(this.url);
        sbM833U.append(", width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        return C1643a.m818F(sbM833U, this.height, ")");
    }
}
