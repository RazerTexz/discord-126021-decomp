package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandAutocompleteChoice.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandAutocompleteChoice {
    private final String name;
    private final String value;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandAutocompleteChoice)) {
            return false;
        }
        ApplicationCommandAutocompleteChoice applicationCommandAutocompleteChoice = (ApplicationCommandAutocompleteChoice) other;
        return C12238m.areEqual(this.name, applicationCommandAutocompleteChoice.name) && C12238m.areEqual(this.value, applicationCommandAutocompleteChoice.value);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandAutocompleteChoice(name=");
        sbM833U.append(this.name);
        sbM833U.append(", value=");
        return C1643a.m822J(sbM833U, this.value, ")");
    }
}
