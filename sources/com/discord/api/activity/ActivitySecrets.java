package com.discord.api.activity;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivitySecrets.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivitySecrets {
    private final String join;
    private final String match;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivitySecrets)) {
            return false;
        }
        ActivitySecrets activitySecrets = (ActivitySecrets) other;
        return C12238m.areEqual(this.match, activitySecrets.match) && C12238m.areEqual(this.join, activitySecrets.join);
    }

    public int hashCode() {
        String str = this.match;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.join;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ActivitySecrets(match=");
        sbM833U.append(this.match);
        sbM833U.append(", join=");
        return C1643a.m822J(sbM833U, this.join, ")");
    }
}
