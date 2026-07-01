package com.discord.widgets.chat.input.emoji;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EmojiPickerViewModel$ViewState {
    private final String searchQuery;

    private EmojiPickerViewModel$ViewState(String str) {
        this.searchQuery = str;
    }

    public String getSearchQuery() {
        return this.searchQuery;
    }

    public /* synthetic */ EmojiPickerViewModel$ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
