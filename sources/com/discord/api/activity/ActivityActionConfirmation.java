package com.discord.api.activity;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            return (other instanceof ActivityActionConfirmation) && C12238m.areEqual(this.secret, ((ActivityActionConfirmation) other).secret);
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
        return C1643a.m822J(C1643a.m833U("ActivityActionConfirmation(secret="), this.secret, ")");
    }
}
