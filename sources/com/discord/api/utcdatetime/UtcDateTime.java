package com.discord.api.utcdatetime;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UtcDateTime.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UtcDateTime implements Comparable<UtcDateTime> {
    private final long dateTimeMillis;

    public UtcDateTime(long j) {
        this.dateTimeMillis = j;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UtcDateTime) && this.dateTimeMillis == ((UtcDateTime) other).dateTimeMillis;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(UtcDateTime other) {
        C12238m.checkNotNullParameter(other, "other");
        return (this.dateTimeMillis > other.dateTimeMillis ? 1 : (this.dateTimeMillis == other.dateTimeMillis ? 0 : -1));
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getDateTimeMillis() {
        return this.dateTimeMillis;
    }

    public int hashCode() {
        long j = this.dateTimeMillis;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return C1643a.m815C(C1643a.m833U("UtcDateTime(dateTimeMillis="), this.dateTimeMillis, ")");
    }
}
