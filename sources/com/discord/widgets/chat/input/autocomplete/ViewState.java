package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ViewState {
    private final AutocompleteViewState autocompleteViewState;
    private final SelectedCommandViewState selectedCommandViewState;

    public ViewState(AutocompleteViewState autocompleteViewState, SelectedCommandViewState selectedCommandViewState) {
        m.checkNotNullParameter(autocompleteViewState, "autocompleteViewState");
        m.checkNotNullParameter(selectedCommandViewState, "selectedCommandViewState");
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
        m.checkNotNullParameter(autocompleteViewState, "autocompleteViewState");
        m.checkNotNullParameter(selectedCommandViewState, "selectedCommandViewState");
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
        return m.areEqual(this.autocompleteViewState, viewState.autocompleteViewState) && m.areEqual(this.selectedCommandViewState, viewState.selectedCommandViewState);
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
        StringBuilder sbU = a.U("ViewState(autocompleteViewState=");
        sbU.append(this.autocompleteViewState);
        sbU.append(", selectedCommandViewState=");
        sbU.append(this.selectedCommandViewState);
        sbU.append(")");
        return sbU.toString();
    }
}
