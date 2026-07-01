package com.discord.widgets.chat.input.sticker;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerPickerViewModel$ViewState {
    private final String searchQuery;

    private StickerPickerViewModel$ViewState(String str) {
        this.searchQuery = str;
    }

    public String getSearchQuery() {
        return this.searchQuery;
    }

    public /* synthetic */ StickerPickerViewModel$ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
