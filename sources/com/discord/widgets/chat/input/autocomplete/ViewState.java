package com.discord.widgets.chat.input.autocomplete;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ViewState {
    private final AutocompleteViewState autocompleteViewState;
    private final SelectedCommandViewState selectedCommandViewState;

    public ViewState(AutocompleteViewState autocompleteViewState, SelectedCommandViewState selectedCommandViewState) {
        C12238m.checkNotNullParameter(autocompleteViewState, "autocompleteViewState");
        C12238m.checkNotNullParameter(selectedCommandViewState, "selectedCommandViewState");
        this.autocompleteViewState = autocompleteViewState;
        this.selectedCommandViewState = selectedCommandViewState;
    }

    public static /* synthetic */ ViewState copy$default(ViewState viewState, AutocompleteViewState autocompleteViewState, SelectedCommandViewState selectedCommandViewState, int i, Object obj) {
        if ((i & 1) != 0) {
            autocompleteViewState = viewState.autocompleteViewState;
        }
        if ((i & 2) != 0) {
            selectedCommandViewState = viewState.selectedCommandViewState;
        }
        return viewState.copy(autocompleteViewState, selectedCommandViewState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AutocompleteViewState getAutocompleteViewState() {
        return this.autocompleteViewState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SelectedCommandViewState getSelectedCommandViewState() {
        return this.selectedCommandViewState;
    }

    public final ViewState copy(AutocompleteViewState autocompleteViewState, SelectedCommandViewState selectedCommandViewState) {
        C12238m.checkNotNullParameter(autocompleteViewState, "autocompleteViewState");
        C12238m.checkNotNullParameter(selectedCommandViewState, "selectedCommandViewState");
        return new ViewState(autocompleteViewState, selectedCommandViewState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewState)) {
            return false;
        }
        ViewState viewState = (ViewState) other;
        return C12238m.areEqual(this.autocompleteViewState, viewState.autocompleteViewState) && C12238m.areEqual(this.selectedCommandViewState, viewState.selectedCommandViewState);
    }

    public final AutocompleteViewState getAutocompleteViewState() {
        return this.autocompleteViewState;
    }

    public final SelectedCommandViewState getSelectedCommandViewState() {
        return this.selectedCommandViewState;
    }

    public int hashCode() {
        AutocompleteViewState autocompleteViewState = this.autocompleteViewState;
        int iHashCode = (autocompleteViewState != null ? autocompleteViewState.hashCode() : 0) * 31;
        SelectedCommandViewState selectedCommandViewState = this.selectedCommandViewState;
        return iHashCode + (selectedCommandViewState != null ? selectedCommandViewState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ViewState(autocompleteViewState=");
        sbM833U.append(this.autocompleteViewState);
        sbM833U.append(", selectedCommandViewState=");
        sbM833U.append(this.selectedCommandViewState);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
