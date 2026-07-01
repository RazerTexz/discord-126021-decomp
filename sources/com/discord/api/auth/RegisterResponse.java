package com.discord.api.auth;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RegisterResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RegisterResponse {
    private final String token;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RegisterResponse) && m.areEqual(this.token, ((RegisterResponse) other).token);
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
        return a.J(a.U("RegisterResponse(token="), this.token, ")");
    }
}
