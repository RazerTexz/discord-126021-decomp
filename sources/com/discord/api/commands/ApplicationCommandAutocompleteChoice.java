package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.name, applicationCommandAutocompleteChoice.name) && Intrinsics3.areEqual(this.value, applicationCommandAutocompleteChoice.value);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandAutocompleteChoice(name=");
        sbU.append(this.name);
        sbU.append(", value=");
        return outline.J(sbU, this.value, ")");
    }
}
