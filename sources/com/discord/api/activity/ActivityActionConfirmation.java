package com.discord.api.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
            return (other instanceof ActivityActionConfirmation) && Intrinsics3.areEqual(this.secret, ((ActivityActionConfirmation) other).secret);
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
        return outline.J(outline.U("ActivityActionConfirmation(secret="), this.secret, ")");
    }
}
