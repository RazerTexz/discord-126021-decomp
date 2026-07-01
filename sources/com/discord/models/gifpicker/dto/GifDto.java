package com.discord.models.gifpicker.dto;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GifDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GifDto {
    private final int height;
    private final String src;
    private final String url;
    private final int width;

    public GifDto(String str, String str2, int i, int i2) {
        m.checkNotNullParameter(str, "src");
        m.checkNotNullParameter(str2, "url");
        this.src = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ GifDto copy$default(GifDto gifDto, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gifDto.src;
        }
        if ((i3 & 2) != 0) {
            str2 = gifDto.url;
        }
        if ((i3 & 4) != 0) {
            i = gifDto.width;
        }
        if ((i3 & 8) != 0) {
            i2 = gifDto.height;
        }
        return gifDto.copy(str, str2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final GifDto copy(String src, String url, int width, int height) {
        m.checkNotNullParameter(src, "src");
        m.checkNotNullParameter(url, "url");
        return new GifDto(src, url, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifDto)) {
            return false;
        }
        GifDto gifDto = (GifDto) other;
        return m.areEqual(this.src, gifDto.src) && m.areEqual(this.url, gifDto.url) && this.width == gifDto.width && this.height == gifDto.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.src;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder sbU = a.U("GifDto(src=");
        sbU.append(this.src);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return a.B(sbU, this.height, ")");
    }
}
