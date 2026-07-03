package com.discord.api.thread;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MuteConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MuteConfig {
    private final String endTime;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MuteConfig) && C12238m.areEqual(this.endTime, ((MuteConfig) other).endTime);
        }
        return true;
    }

    public int hashCode() {
        String str = this.endTime;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("MuteConfig(endTime="), this.endTime, ")");
    }
}
