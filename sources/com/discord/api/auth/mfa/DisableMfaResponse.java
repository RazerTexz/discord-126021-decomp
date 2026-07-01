package com.discord.api.auth.mfa;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
            return (other instanceof DisableMfaResponse) && Intrinsics3.areEqual(this.token, ((DisableMfaResponse) other).token);
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
        return outline.J(outline.U("DisableMfaResponse(token="), this.token, ")");
    }
}
