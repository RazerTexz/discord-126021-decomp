package com.discord.api.thread;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
            return (other instanceof MuteConfig) && Intrinsics3.areEqual(this.endTime, ((MuteConfig) other).endTime);
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
        return outline.J(outline.U("MuteConfig(endTime="), this.endTime, ")");
    }
}
