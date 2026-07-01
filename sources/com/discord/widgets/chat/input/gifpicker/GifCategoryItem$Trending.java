package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GifCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifCategoryItem$Trending extends GifCategoryItem {
    private final String gifPreviewUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryItem$Trending(String str) {
        super(null);
        m.checkNotNullParameter(str, "gifPreviewUrl");
        this.gifPreviewUrl = str;
    }

    public static /* synthetic */ GifCategoryItem$Trending copy$default(GifCategoryItem$Trending gifCategoryItem$Trending, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gifCategoryItem$Trending.gifPreviewUrl;
        }
        return gifCategoryItem$Trending.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGifPreviewUrl() {
        return this.gifPreviewUrl;
    }

    public final GifCategoryItem$Trending copy(String gifPreviewUrl) {
        m.checkNotNullParameter(gifPreviewUrl, "gifPreviewUrl");
        return new GifCategoryItem$Trending(gifPreviewUrl);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GifCategoryItem$Trending) && m.areEqual(this.gifPreviewUrl, ((GifCategoryItem$Trending) other).gifPreviewUrl);
        }
        return true;
    }

    public final String getGifPreviewUrl() {
        return this.gifPreviewUrl;
    }

    public int hashCode() {
        String str = this.gifPreviewUrl;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("Trending(gifPreviewUrl="), this.gifPreviewUrl, ")");
    }
}
