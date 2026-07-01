package com.discord.api.handoff;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: HandoffToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class HandoffToken {
    private final String handoffToken;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getHandoffToken() {
        return this.handoffToken;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HandoffToken) && m.areEqual(this.handoffToken, ((HandoffToken) other).handoffToken);
        }
        return true;
    }

    public int hashCode() {
        String str = this.handoffToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("HandoffToken(handoffToken="), this.handoffToken, ")");
    }
}
