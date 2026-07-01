package com.discord.models.gifpicker.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrendingGifsResponseDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrendingGifsResponseDto {
    private final List<GifCategoryDto> categories;
    private final List<TrendingGifPreviewDto> gifs;

    public TrendingGifsResponseDto(List<GifCategoryDto> list, List<TrendingGifPreviewDto> list2) {
        Intrinsics3.checkNotNullParameter(list, "categories");
        Intrinsics3.checkNotNullParameter(list2, "gifs");
        this.categories = list;
        this.gifs = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrendingGifsResponseDto copy$default(TrendingGifsResponseDto trendingGifsResponseDto, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = trendingGifsResponseDto.categories;
        }
        if ((i & 2) != 0) {
            list2 = trendingGifsResponseDto.gifs;
        }
        return trendingGifsResponseDto.copy(list, list2);
    }

    public final List<GifCategoryDto> component1() {
        return this.categories;
    }

    public final List<TrendingGifPreviewDto> component2() {
        return this.gifs;
    }

    public final TrendingGifsResponseDto copy(List<GifCategoryDto> categories, List<TrendingGifPreviewDto> gifs) {
        Intrinsics3.checkNotNullParameter(categories, "categories");
        Intrinsics3.checkNotNullParameter(gifs, "gifs");
        return new TrendingGifsResponseDto(categories, gifs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrendingGifsResponseDto)) {
            return false;
        }
        TrendingGifsResponseDto trendingGifsResponseDto = (TrendingGifsResponseDto) other;
        return Intrinsics3.areEqual(this.categories, trendingGifsResponseDto.categories) && Intrinsics3.areEqual(this.gifs, trendingGifsResponseDto.gifs);
    }

    public final List<GifCategoryDto> getCategories() {
        return this.categories;
    }

    public final List<TrendingGifPreviewDto> getGifs() {
        return this.gifs;
    }

    public int hashCode() {
        List<GifCategoryDto> list = this.categories;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<TrendingGifPreviewDto> list2 = this.gifs;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrendingGifsResponseDto(categories=");
        sbU.append(this.categories);
        sbU.append(", gifs=");
        return outline.L(sbU, this.gifs, ")");
    }
}
