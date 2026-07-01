package com.discord.api.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.match, activitySecrets.match) && Intrinsics3.areEqual(this.join, activitySecrets.join);
    }

    public int hashCode() {
        String str = this.match;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.join;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActivitySecrets(match=");
        sbU.append(this.match);
        sbU.append(", join=");
        return outline.J(sbU, this.join, ")");
    }
}
