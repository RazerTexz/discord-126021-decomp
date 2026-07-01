package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPickerViewModel$ViewState$EmptySearchResults extends StickerPickerViewModel$ViewState {
    private final List<StickerCategoryItem> categoryItems;
    private final String searchQuery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerPickerViewModel$ViewState$EmptySearchResults(String str, List<? extends StickerCategoryItem> list) {
        super(str, null);
        m.checkNotNullParameter(str, "searchQuery");
        m.checkNotNullParameter(list, "categoryItems");
        this.searchQuery = str;
        this.categoryItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerPickerViewModel$ViewState$EmptySearchResults copy$default(StickerPickerViewModel$ViewState$EmptySearchResults stickerPickerViewModel$ViewState$EmptySearchResults, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stickerPickerViewModel$ViewState$EmptySearchResults.getSearchQuery();
        }
        if ((i & 2) != 0) {
            list = stickerPickerViewModel$ViewState$EmptySearchResults.categoryItems;
        }
        return stickerPickerViewModel$ViewState$EmptySearchResults.copy(str, list);
    }

    public final String component1() {
        return getSearchQuery();
    }

    public final List<StickerCategoryItem> component2() {
        return this.categoryItems;
    }

    public final StickerPickerViewModel$ViewState$EmptySearchResults copy(String searchQuery, List<? extends StickerCategoryItem> categoryItems) {
        m.checkNotNullParameter(searchQuery, "searchQuery");
        m.checkNotNullParameter(categoryItems, "categoryItems");
        return new StickerPickerViewModel$ViewState$EmptySearchResults(searchQuery, categoryItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPickerViewModel$ViewState$EmptySearchResults)) {
            return false;
        }
        StickerPickerViewModel$ViewState$EmptySearchResults stickerPickerViewModel$ViewState$EmptySearchResults = (StickerPickerViewModel$ViewState$EmptySearchResults) other;
        return m.areEqual(getSearchQuery(), stickerPickerViewModel$ViewState$EmptySearchResults.getSearchQuery()) && m.areEqual(this.categoryItems, stickerPickerViewModel$ViewState$EmptySearchResults.categoryItems);
    }

    public final List<StickerCategoryItem> getCategoryItems() {
        return this.categoryItems;
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerViewModel$ViewState
    public String getSearchQuery() {
        return this.searchQuery;
    }

    public int hashCode() {
        String searchQuery = getSearchQuery();
        int iHashCode = (searchQuery != null ? searchQuery.hashCode() : 0) * 31;
        List<StickerCategoryItem> list = this.categoryItems;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("EmptySearchResults(searchQuery=");
        sbU.append(getSearchQuery());
        sbU.append(", categoryItems=");
        return a.L(sbU, this.categoryItems, ")");
    }
}
