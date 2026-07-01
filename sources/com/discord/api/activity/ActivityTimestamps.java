package com.discord.api.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ActivityTimestamps.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivityTimestamps {
    private final String end;
    private final String start;

    public ActivityTimestamps(String str, String str2) {
        this.start = str;
        this.end = str2;
    }

    public final long a(String number) {
        if (number == null || number.length() == 0) {
            return 0L;
        }
        try {
            long j = Long.parseLong(number);
            if (number.length() < 13) {
                j *= (long) 1000;
            }
            return j;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long b() {
        return a(this.end);
    }

    public final long c() {
        return a(this.start);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityTimestamps)) {
            return false;
        }
        ActivityTimestamps activityTimestamps = (ActivityTimestamps) other;
        return Intrinsics3.areEqual(this.start, activityTimestamps.start) && Intrinsics3.areEqual(this.end, activityTimestamps.end);
    }

    public int hashCode() {
        String str = this.start;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.end;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActivityTimestamps(start=");
        sbU.append(this.start);
        sbU.append(", end=");
        return outline.J(sbU, this.end, ")");
    }
}
