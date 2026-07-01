package com.discord.widgets.chat.input.models;

import b.d.b.a.a;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AutocompleteInputModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteInputModel {
    private final AutocompleteApplicationCommands applicationCommands;
    private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
    private final CharSequence input;

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, AutocompleteApplicationCommands autocompleteApplicationCommands) {
        m.checkNotNullParameter(charSequence, "input");
        m.checkNotNullParameter(map, "autocompletables");
        m.checkNotNullParameter(autocompleteApplicationCommands, "applicationCommands");
        this.input = charSequence;
        this.autocompletables = map;
        this.applicationCommands = autocompleteApplicationCommands;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteInputModel copy$default(AutocompleteInputModel autocompleteInputModel, CharSequence charSequence, Map map, AutocompleteApplicationCommands autocompleteApplicationCommands, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = autocompleteInputModel.input;
        }
        if ((i & 2) != 0) {
            map = autocompleteInputModel.autocompletables;
        }
        if ((i & 4) != 0) {
            autocompleteApplicationCommands = autocompleteInputModel.applicationCommands;
        }
        return autocompleteInputModel.copy(charSequence, map, autocompleteApplicationCommands);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getInput() {
        return this.input;
    }

    public final Map<LeadingIdentifier, Set<Autocompletable>> component2() {
        return this.autocompletables;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AutocompleteApplicationCommands getApplicationCommands() {
        return this.applicationCommands;
    }

    public final AutocompleteInputModel copy(CharSequence input, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, AutocompleteApplicationCommands applicationCommands) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(autocompletables, "autocompletables");
        m.checkNotNullParameter(applicationCommands, "applicationCommands");
        return new AutocompleteInputModel(input, autocompletables, applicationCommands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteInputModel)) {
            return false;
        }
        AutocompleteInputModel autocompleteInputModel = (AutocompleteInputModel) other;
        return m.areEqual(this.input, autocompleteInputModel.input) && m.areEqual(this.autocompletables, autocompleteInputModel.autocompletables) && m.areEqual(this.applicationCommands, autocompleteInputModel.applicationCommands);
    }

    public final AutocompleteApplicationCommands getApplicationCommands() {
        return this.applicationCommands;
    }

    public final Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
        return this.autocompletables;
    }

    public final CharSequence getInput() {
        return this.input;
    }

    public int hashCode() {
        CharSequence charSequence = this.input;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Map<LeadingIdentifier, Set<Autocompletable>> map = this.autocompletables;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        AutocompleteApplicationCommands autocompleteApplicationCommands = this.applicationCommands;
        return iHashCode2 + (autocompleteApplicationCommands != null ? autocompleteApplicationCommands.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AutocompleteInputModel(input=");
        sbU.append(this.input);
        sbU.append(", autocompletables=");
        sbU.append(this.autocompletables);
        sbU.append(", applicationCommands=");
        sbU.append(this.applicationCommands);
        sbU.append(")");
        return sbU.toString();
    }
}
