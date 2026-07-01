package com.discord.embed;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: RenderableEmbedMedia.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RenderableEmbedMedia {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
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
        return Intrinsics3.areEqual(this.url, renderableEmbedMedia.url) && Intrinsics3.areEqual(this.width, renderableEmbedMedia.width) && Intrinsics3.areEqual(this.height, renderableEmbedMedia.height);
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
        StringBuilder sbU = outline.U("RenderableEmbedMedia(url=");
        sbU.append(this.url);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return outline.F(sbU, this.height, ")");
    }
}
