package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteViewState$LoadingItems extends AutocompleteViewState {
    private final int numberLoadingItems;

    public AutocompleteViewState$LoadingItems(int i) {
        super(null);
        this.numberLoadingItems = i;
    }

    public static /* synthetic */ AutocompleteViewState$LoadingItems copy$default(AutocompleteViewState$LoadingItems autocompleteViewState$LoadingItems, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = autocompleteViewState$LoadingItems.numberLoadingItems;
        }
        return autocompleteViewState$LoadingItems.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumberLoadingItems() {
        return this.numberLoadingItems;
    }

    public final AutocompleteViewState$LoadingItems copy(int numberLoadingItems) {
        return new AutocompleteViewState$LoadingItems(numberLoadingItems);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AutocompleteViewState$LoadingItems) && this.numberLoadingItems == ((AutocompleteViewState$LoadingItems) other).numberLoadingItems;
        }
        return true;
    }

    public final int getNumberLoadingItems() {
        return this.numberLoadingItems;
    }

    public int hashCode() {
        return this.numberLoadingItems;
    }

    public String toString() {
        return a.B(a.U("LoadingItems(numberLoadingItems="), this.numberLoadingItems, ")");
    }
}
