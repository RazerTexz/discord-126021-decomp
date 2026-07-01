package com.discord.models.gifpicker.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrendingGifCategoriesResponseDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrendingGifCategoriesResponseDto {
    private final List<GifCategoryDto> categories;
    private final List<TrendingGifPreviewDto> gifs;

    public TrendingGifCategoriesResponseDto(List<GifCategoryDto> list, List<TrendingGifPreviewDto> list2) {
        Intrinsics3.checkNotNullParameter(list, "categories");
        Intrinsics3.checkNotNullParameter(list2, "gifs");
        this.categories = list;
        this.gifs = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrendingGifCategoriesResponseDto copy$default(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = trendingGifCategoriesResponseDto.categories;
        }
        if ((i & 2) != 0) {
            list2 = trendingGifCategoriesResponseDto.gifs;
        }
        return trendingGifCategoriesResponseDto.copy(list, list2);
    }

    public final List<GifCategoryDto> component1() {
        return this.categories;
    }

    public final List<TrendingGifPreviewDto> component2() {
        return this.gifs;
    }

    public final TrendingGifCategoriesResponseDto copy(List<GifCategoryDto> categories, List<TrendingGifPreviewDto> gifs) {
        Intrinsics3.checkNotNullParameter(categories, "categories");
        Intrinsics3.checkNotNullParameter(gifs, "gifs");
        return new TrendingGifCategoriesResponseDto(categories, gifs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrendingGifCategoriesResponseDto)) {
            return false;
        }
        TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto = (TrendingGifCategoriesResponseDto) other;
        return Intrinsics3.areEqual(this.categories, trendingGifCategoriesResponseDto.categories) && Intrinsics3.areEqual(this.gifs, trendingGifCategoriesResponseDto.gifs);
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
        StringBuilder sbU = outline.U("TrendingGifCategoriesResponseDto(categories=");
        sbU.append(this.categories);
        sbU.append(", gifs=");
        return outline.L(sbU, this.gifs, ")");
    }
}
