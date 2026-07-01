package com.discord.api.activity;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ActivityActionConfirmation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivityActionConfirmation {
    private final String secret;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getSecret() {
        return this.secret;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ActivityActionConfirmation) && m.areEqual(this.secret, ((ActivityActionConfirmation) other).secret);
        }
        return true;
    }

    public int hashCode() {
        String str = this.secret;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("ActivityActionConfirmation(secret="), this.secret, ")");
    }
}
