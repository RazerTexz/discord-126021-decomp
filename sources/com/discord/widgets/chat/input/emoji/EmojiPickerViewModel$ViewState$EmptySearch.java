package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiPickerViewModel$ViewState$EmptySearch extends EmojiPickerViewModel$ViewState {
    private final String searchQuery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$ViewState$EmptySearch(String str) {
        super(str, null);
        m.checkNotNullParameter(str, "searchQuery");
        this.searchQuery = str;
    }

    public static /* synthetic */ EmojiPickerViewModel$ViewState$EmptySearch copy$default(EmojiPickerViewModel$ViewState$EmptySearch emojiPickerViewModel$ViewState$EmptySearch, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiPickerViewModel$ViewState$EmptySearch.getSearchQuery();
        }
        return emojiPickerViewModel$ViewState$EmptySearch.copy(str);
    }

    public final String component1() {
        return getSearchQuery();
    }

    public final EmojiPickerViewModel$ViewState$EmptySearch copy(String searchQuery) {
        m.checkNotNullParameter(searchQuery, "searchQuery");
        return new EmojiPickerViewModel$ViewState$EmptySearch(searchQuery);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof EmojiPickerViewModel$ViewState$EmptySearch) && m.areEqual(getSearchQuery(), ((EmojiPickerViewModel$ViewState$EmptySearch) other).getSearchQuery());
        }
        return true;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$ViewState
    public String getSearchQuery() {
        return this.searchQuery;
    }

    public int hashCode() {
        String searchQuery = getSearchQuery();
        if (searchQuery != null) {
            return searchQuery.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmptySearch(searchQuery=");
        sbU.append(getSearchQuery());
        sbU.append(")");
        return sbU.toString();
    }
}
