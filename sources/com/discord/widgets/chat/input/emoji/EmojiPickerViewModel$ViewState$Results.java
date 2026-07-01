package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.g;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiPickerViewModel$ViewState$Results extends EmojiPickerViewModel$ViewState {
    private final List<EmojiCategoryItem> categoryItems;

    /* JADX INFO: renamed from: firstUnicodeEmojiCategoryItem$delegate, reason: from kotlin metadata */
    private final Lazy firstUnicodeEmojiCategoryItem;
    private final List<MGRecyclerDataPayload> resultItems;
    private final String searchQuery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiPickerViewModel$ViewState$Results(String str, List<? extends MGRecyclerDataPayload> list, List<? extends EmojiCategoryItem> list2) {
        super(str, null);
        m.checkNotNullParameter(str, "searchQuery");
        m.checkNotNullParameter(list, "resultItems");
        m.checkNotNullParameter(list2, "categoryItems");
        this.searchQuery = str;
        this.resultItems = list;
        this.categoryItems = list2;
        this.firstUnicodeEmojiCategoryItem = g.lazy(new EmojiPickerViewModel$ViewState$Results$firstUnicodeEmojiCategoryItem$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiPickerViewModel$ViewState$Results copy$default(EmojiPickerViewModel$ViewState$Results emojiPickerViewModel$ViewState$Results, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiPickerViewModel$ViewState$Results.getSearchQuery();
        }
        if ((i & 2) != 0) {
            list = emojiPickerViewModel$ViewState$Results.resultItems;
        }
        if ((i & 4) != 0) {
            list2 = emojiPickerViewModel$ViewState$Results.categoryItems;
        }
        return emojiPickerViewModel$ViewState$Results.copy(str, list, list2);
    }

    public final String component1() {
        return getSearchQuery();
    }

    public final List<MGRecyclerDataPayload> component2() {
        return this.resultItems;
    }

    public final List<EmojiCategoryItem> component3() {
        return this.categoryItems;
    }

    public final EmojiPickerViewModel$ViewState$Results copy(String searchQuery, List<? extends MGRecyclerDataPayload> resultItems, List<? extends EmojiCategoryItem> categoryItems) {
        m.checkNotNullParameter(searchQuery, "searchQuery");
        m.checkNotNullParameter(resultItems, "resultItems");
        m.checkNotNullParameter(categoryItems, "categoryItems");
        return new EmojiPickerViewModel$ViewState$Results(searchQuery, resultItems, categoryItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiPickerViewModel$ViewState$Results)) {
            return false;
        }
        EmojiPickerViewModel$ViewState$Results emojiPickerViewModel$ViewState$Results = (EmojiPickerViewModel$ViewState$Results) other;
        return m.areEqual(getSearchQuery(), emojiPickerViewModel$ViewState$Results.getSearchQuery()) && m.areEqual(this.resultItems, emojiPickerViewModel$ViewState$Results.resultItems) && m.areEqual(this.categoryItems, emojiPickerViewModel$ViewState$Results.categoryItems);
    }

    public final List<EmojiCategoryItem> getCategoryItems() {
        return this.categoryItems;
    }

    public final EmojiCategoryItem$StandardItem getFirstUnicodeEmojiCategoryItem() {
        return (EmojiCategoryItem$StandardItem) this.firstUnicodeEmojiCategoryItem.getValue();
    }

    public final List<MGRecyclerDataPayload> getResultItems() {
        return this.resultItems;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$ViewState
    public String getSearchQuery() {
        return this.searchQuery;
    }

    public final boolean getShowBottomBar() {
        return getSearchQuery().length() == 0;
    }

    public int hashCode() {
        String searchQuery = getSearchQuery();
        int iHashCode = (searchQuery != null ? searchQuery.hashCode() : 0) * 31;
        List<MGRecyclerDataPayload> list = this.resultItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<EmojiCategoryItem> list2 = this.categoryItems;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Results(searchQuery=");
        sbU.append(getSearchQuery());
        sbU.append(", resultItems=");
        sbU.append(this.resultItems);
        sbU.append(", categoryItems=");
        return a.L(sbU, this.categoryItems, ")");
    }
}
