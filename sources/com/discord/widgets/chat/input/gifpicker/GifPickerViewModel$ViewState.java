package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GifPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifPickerViewModel$ViewState {
    private final List<GifCategoryItem> gifCategoryItems;
    private final boolean isLoaded;

    /* JADX WARN: Multi-variable type inference failed */
    public GifPickerViewModel$ViewState(List<? extends GifCategoryItem> list) {
        m.checkNotNullParameter(list, "gifCategoryItems");
        this.gifCategoryItems = list;
        this.isLoaded = !list.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifPickerViewModel$ViewState copy$default(GifPickerViewModel$ViewState gifPickerViewModel$ViewState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gifPickerViewModel$ViewState.gifCategoryItems;
        }
        return gifPickerViewModel$ViewState.copy(list);
    }

    public final List<GifCategoryItem> component1() {
        return this.gifCategoryItems;
    }

    public final GifPickerViewModel$ViewState copy(List<? extends GifCategoryItem> gifCategoryItems) {
        m.checkNotNullParameter(gifCategoryItems, "gifCategoryItems");
        return new GifPickerViewModel$ViewState(gifCategoryItems);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GifPickerViewModel$ViewState) && m.areEqual(this.gifCategoryItems, ((GifPickerViewModel$ViewState) other).gifCategoryItems);
        }
        return true;
    }

    public final List<GifCategoryItem> getGifCategoryItems() {
        return this.gifCategoryItems;
    }

    public int hashCode() {
        List<GifCategoryItem> list = this.gifCategoryItems;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: isLoaded, reason: from getter */
    public final boolean getIsLoaded() {
        return this.isLoaded;
    }

    public String toString() {
        return a.L(a.U("ViewState(gifCategoryItems="), this.gifCategoryItems, ")");
    }
}
