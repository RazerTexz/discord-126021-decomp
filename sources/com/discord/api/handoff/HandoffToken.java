package com.discord.api.handoff;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            return (other instanceof HandoffToken) && C12238m.areEqual(this.handoffToken, ((HandoffToken) other).handoffToken);
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
        return C1643a.m822J(C1643a.m833U("HandoffToken(handoffToken="), this.handoffToken, ")");
    }
}
