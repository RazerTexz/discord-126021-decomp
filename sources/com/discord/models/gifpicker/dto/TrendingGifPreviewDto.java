package com.discord.models.gifpicker.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrendingGifPreviewDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrendingGifPreviewDto {
    private final String src;

    public TrendingGifPreviewDto(String str) {
        Intrinsics3.checkNotNullParameter(str, "src");
        this.src = str;
    }

    public static /* synthetic */ TrendingGifPreviewDto copy$default(TrendingGifPreviewDto trendingGifPreviewDto, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trendingGifPreviewDto.src;
        }
        return trendingGifPreviewDto.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    public final TrendingGifPreviewDto copy(String src) {
        Intrinsics3.checkNotNullParameter(src, "src");
        return new TrendingGifPreviewDto(src);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrendingGifPreviewDto) && Intrinsics3.areEqual(this.src, ((TrendingGifPreviewDto) other).src);
        }
        return true;
    }

    public final String getSrc() {
        return this.src;
    }

    public int hashCode() {
        String str = this.src;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.J(outline.U("TrendingGifPreviewDto(src="), this.src, ")");
    }
}
