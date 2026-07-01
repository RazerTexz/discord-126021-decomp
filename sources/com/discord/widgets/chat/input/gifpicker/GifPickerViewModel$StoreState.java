package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GifPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifPickerViewModel$StoreState {
    private final List<ModelGifCategory> gifCategories;
    private final String trendingGifCategoryPreviewUrl;

    public GifPickerViewModel$StoreState(List<ModelGifCategory> list, String str) {
        m.checkNotNullParameter(list, "gifCategories");
        m.checkNotNullParameter(str, "trendingGifCategoryPreviewUrl");
        this.gifCategories = list;
        this.trendingGifCategoryPreviewUrl = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifPickerViewModel$StoreState copy$default(GifPickerViewModel$StoreState gifPickerViewModel$StoreState, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gifPickerViewModel$StoreState.gifCategories;
        }
        if ((i & 2) != 0) {
            str = gifPickerViewModel$StoreState.trendingGifCategoryPreviewUrl;
        }
        return gifPickerViewModel$StoreState.copy(list, str);
    }

    public final List<ModelGifCategory> component1() {
        return this.gifCategories;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTrendingGifCategoryPreviewUrl() {
        return this.trendingGifCategoryPreviewUrl;
    }

    public final GifPickerViewModel$StoreState copy(List<ModelGifCategory> gifCategories, String trendingGifCategoryPreviewUrl) {
        m.checkNotNullParameter(gifCategories, "gifCategories");
        m.checkNotNullParameter(trendingGifCategoryPreviewUrl, "trendingGifCategoryPreviewUrl");
        return new GifPickerViewModel$StoreState(gifCategories, trendingGifCategoryPreviewUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifPickerViewModel$StoreState)) {
            return false;
        }
        GifPickerViewModel$StoreState gifPickerViewModel$StoreState = (GifPickerViewModel$StoreState) other;
        return m.areEqual(this.gifCategories, gifPickerViewModel$StoreState.gifCategories) && m.areEqual(this.trendingGifCategoryPreviewUrl, gifPickerViewModel$StoreState.trendingGifCategoryPreviewUrl);
    }

    public final List<ModelGifCategory> getGifCategories() {
        return this.gifCategories;
    }

    public final String getTrendingGifCategoryPreviewUrl() {
        return this.trendingGifCategoryPreviewUrl;
    }

    public int hashCode() {
        List<ModelGifCategory> list = this.gifCategories;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.trendingGifCategoryPreviewUrl;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(gifCategories=");
        sbU.append(this.gifCategories);
        sbU.append(", trendingGifCategoryPreviewUrl=");
        return a.J(sbU, this.trendingGifCategoryPreviewUrl, ")");
    }
}
