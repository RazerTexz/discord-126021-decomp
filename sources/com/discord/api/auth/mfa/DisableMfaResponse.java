package com.discord.api.auth.mfa;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DisableMfaResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DisableMfaResponse {
    private final String token;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DisableMfaResponse) && C12238m.areEqual(this.token, ((DisableMfaResponse) other).token);
        }
        return true;
    }

    public int hashCode() {
        String str = this.token;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("DisableMfaResponse(token="), this.token, ")");
    }
}
