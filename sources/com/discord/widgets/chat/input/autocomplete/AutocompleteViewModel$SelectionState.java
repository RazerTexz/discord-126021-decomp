package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteViewModel$SelectionState {
    private final String input;
    private final IntRange selection;

    public AutocompleteViewModel$SelectionState(String str, IntRange intRange) {
        m.checkNotNullParameter(str, "input");
        m.checkNotNullParameter(intRange, "selection");
        this.input = str;
        this.selection = intRange;
    }

    public static /* synthetic */ AutocompleteViewModel$SelectionState copy$default(AutocompleteViewModel$SelectionState autocompleteViewModel$SelectionState, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autocompleteViewModel$SelectionState.input;
        }
        if ((i & 2) != 0) {
            intRange = autocompleteViewModel$SelectionState.selection;
        }
        return autocompleteViewModel$SelectionState.copy(str, intRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInput() {
        return this.input;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IntRange getSelection() {
        return this.selection;
    }

    public final AutocompleteViewModel$SelectionState copy(String input, IntRange selection) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(selection, "selection");
        return new AutocompleteViewModel$SelectionState(input, selection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteViewModel$SelectionState)) {
            return false;
        }
        AutocompleteViewModel$SelectionState autocompleteViewModel$SelectionState = (AutocompleteViewModel$SelectionState) other;
        return m.areEqual(this.input, autocompleteViewModel$SelectionState.input) && m.areEqual(this.selection, autocompleteViewModel$SelectionState.selection);
    }

    public final String getInput() {
        return this.input;
    }

    public final IntRange getSelection() {
        return this.selection;
    }

    public int hashCode() {
        String str = this.input;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        IntRange intRange = this.selection;
        return iHashCode + (intRange != null ? intRange.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectionState(input=");
        sbU.append(this.input);
        sbU.append(", selection=");
        sbU.append(this.selection);
        sbU.append(")");
        return sbU.toString();
    }
}
