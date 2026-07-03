package com.discord.models.gifpicker.dto;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrendingGifPreviewDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrendingGifPreviewDto {
    private final String src;

    public TrendingGifPreviewDto(String str) {
        C12238m.checkNotNullParameter(str, "src");
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
        C12238m.checkNotNullParameter(src, "src");
        return new TrendingGifPreviewDto(src);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrendingGifPreviewDto) && C12238m.areEqual(this.src, ((TrendingGifPreviewDto) other).src);
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
        return C1643a.m822J(C1643a.m833U("TrendingGifPreviewDto(src="), this.src, ")");
    }
}
