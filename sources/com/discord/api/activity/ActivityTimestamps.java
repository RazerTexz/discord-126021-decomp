package com.discord.api.activity;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityTimestamps.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivityTimestamps {
    private final String end;
    private final String start;

    public ActivityTimestamps(String str, String str2) {
        this.start = str;
        this.end = str2;
    }

    /* JADX INFO: renamed from: a */
    public final long m7560a(String number) {
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

    /* JADX INFO: renamed from: b */
    public final long m7561b() {
        return m7560a(this.end);
    }

    /* JADX INFO: renamed from: c */
    public final long m7562c() {
        return m7560a(this.start);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityTimestamps)) {
            return false;
        }
        ActivityTimestamps activityTimestamps = (ActivityTimestamps) other;
        return C12238m.areEqual(this.start, activityTimestamps.start) && C12238m.areEqual(this.end, activityTimestamps.end);
    }

    public int hashCode() {
        String str = this.start;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.end;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ActivityTimestamps(start=");
        sbM833U.append(this.start);
        sbM833U.append(", end=");
        return C1643a.m822J(sbM833U, this.end, ")");
    }
}
