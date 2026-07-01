package com.discord.widgets.botuikit.views.select;

import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SelectComponentBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheetViewModel$ViewState {
    private final boolean emojiAnimationsEnabled;
    private final boolean isMultiSelect;
    private final boolean isValidSelection;
    private final List<SelectComponentBottomSheetItem> items;
    private final int maxSelections;
    private final int minSelections;
    private final boolean showSelectButton;
    private final String title;

    public SelectComponentBottomSheetViewModel$ViewState(String str, List<SelectComponentBottomSheetItem> list, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5) {
        m.checkNotNullParameter(list, "items");
        this.title = str;
        this.items = list;
        this.showSelectButton = z2;
        this.isMultiSelect = z3;
        this.minSelections = i;
        this.maxSelections = i2;
        this.isValidSelection = z4;
        this.emojiAnimationsEnabled = z5;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    public final List<SelectComponentBottomSheetItem> getItems() {
        return this.items;
    }

    public final int getMaxSelections() {
        return this.maxSelections;
    }

    public final int getMinSelections() {
        return this.minSelections;
    }

    public final boolean getShowSelectButton() {
        return this.showSelectButton;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isMultiSelect, reason: from getter */
    public final boolean getIsMultiSelect() {
        return this.isMultiSelect;
    }

    /* JADX INFO: renamed from: isValidSelection, reason: from getter */
    public final boolean getIsValidSelection() {
        return this.isValidSelection;
    }
}
