package com.discord.api.commands;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandAutocompleteResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandAutocompleteResult {
    private final List<ApplicationCommandAutocompleteChoice> choices;
    private final String nonce;

    /* JADX INFO: renamed from: a */
    public final List<ApplicationCommandAutocompleteChoice> m7722a() {
        return this.choices;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandAutocompleteResult)) {
            return false;
        }
        ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult = (ApplicationCommandAutocompleteResult) other;
        return C12238m.areEqual(this.nonce, applicationCommandAutocompleteResult.nonce) && C12238m.areEqual(this.choices, applicationCommandAutocompleteResult.choices);
    }

    public int hashCode() {
        String str = this.nonce;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ApplicationCommandAutocompleteChoice> list = this.choices;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandAutocompleteResult(nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", choices=");
        return C1643a.m824L(sbM833U, this.choices, ")");
    }
}
