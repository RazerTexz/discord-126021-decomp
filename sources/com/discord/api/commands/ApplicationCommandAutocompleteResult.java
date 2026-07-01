package com.discord.api.commands;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ApplicationCommandAutocompleteResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandAutocompleteResult {
    private final List<ApplicationCommandAutocompleteChoice> choices;
    private final String nonce;

    public final List<ApplicationCommandAutocompleteChoice> a() {
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
        return m.areEqual(this.nonce, applicationCommandAutocompleteResult.nonce) && m.areEqual(this.choices, applicationCommandAutocompleteResult.choices);
    }

    public int hashCode() {
        String str = this.nonce;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ApplicationCommandAutocompleteChoice> list = this.choices;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationCommandAutocompleteResult(nonce=");
        sbU.append(this.nonce);
        sbU.append(", choices=");
        return a.L(sbU, this.choices, ")");
    }
}
