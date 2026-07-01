package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.ViewState, reason: use source file name */
/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteViewModel7 {
    private final AutocompleteViewModel4 autocompleteViewState;
    private final AutocompleteViewModel6 selectedCommandViewState;

    public AutocompleteViewModel7(AutocompleteViewModel4 autocompleteViewModel4, AutocompleteViewModel6 autocompleteViewModel6) {
        Intrinsics3.checkNotNullParameter(autocompleteViewModel4, "autocompleteViewState");
        Intrinsics3.checkNotNullParameter(autocompleteViewModel6, "selectedCommandViewState");
        this.autocompleteViewState = autocompleteViewModel4;
        this.selectedCommandViewState = autocompleteViewModel6;
    }

    public static /* synthetic */ AutocompleteViewModel7 copy$default(AutocompleteViewModel7 autocompleteViewModel7, AutocompleteViewModel4 autocompleteViewModel4, AutocompleteViewModel6 autocompleteViewModel6, int i, Object obj) {
        if ((i & 1) != 0) {
            autocompleteViewModel4 = autocompleteViewModel7.autocompleteViewState;
        }
        if ((i & 2) != 0) {
            autocompleteViewModel6 = autocompleteViewModel7.selectedCommandViewState;
        }
        return autocompleteViewModel7.copy(autocompleteViewModel4, autocompleteViewModel6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AutocompleteViewModel4 getAutocompleteViewState() {
        return this.autocompleteViewState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AutocompleteViewModel6 getSelectedCommandViewState() {
        return this.selectedCommandViewState;
    }

    public final AutocompleteViewModel7 copy(AutocompleteViewModel4 autocompleteViewState, AutocompleteViewModel6 selectedCommandViewState) {
        Intrinsics3.checkNotNullParameter(autocompleteViewState, "autocompleteViewState");
        Intrinsics3.checkNotNullParameter(selectedCommandViewState, "selectedCommandViewState");
        return new AutocompleteViewModel7(autocompleteViewState, selectedCommandViewState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteViewModel7)) {
            return false;
        }
        AutocompleteViewModel7 autocompleteViewModel7 = (AutocompleteViewModel7) other;
        return Intrinsics3.areEqual(this.autocompleteViewState, autocompleteViewModel7.autocompleteViewState) && Intrinsics3.areEqual(this.selectedCommandViewState, autocompleteViewModel7.selectedCommandViewState);
    }

    public final AutocompleteViewModel4 getAutocompleteViewState() {
        return this.autocompleteViewState;
    }

    public final AutocompleteViewModel6 getSelectedCommandViewState() {
        return this.selectedCommandViewState;
    }

    public int hashCode() {
        AutocompleteViewModel4 autocompleteViewModel4 = this.autocompleteViewState;
        int iHashCode = (autocompleteViewModel4 != null ? autocompleteViewModel4.hashCode() : 0) * 31;
        AutocompleteViewModel6 autocompleteViewModel6 = this.selectedCommandViewState;
        return iHashCode + (autocompleteViewModel6 != null ? autocompleteViewModel6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ViewState(autocompleteViewState=");
        sbU.append(this.autocompleteViewState);
        sbU.append(", selectedCommandViewState=");
        sbU.append(this.selectedCommandViewState);
        sbU.append(")");
        return sbU.toString();
    }
}
