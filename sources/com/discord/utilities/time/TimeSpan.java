package com.discord.utilities.time;

import java.util.concurrent.TimeUnit;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TimeSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class TimeSpan {
    private final long amount;
    private final TimeUnit unit;

    public TimeSpan(long j, TimeUnit timeUnit) {
        C12238m.checkNotNullParameter(timeUnit, "unit");
        this.amount = j;
        this.unit = timeUnit;
    }

    public static /* synthetic */ TimeSpan copy$default(TimeSpan timeSpan, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timeSpan.amount;
        }
        if ((i & 2) != 0) {
            timeUnit = timeSpan.unit;
        }
        return timeSpan.copy(j, timeUnit);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TimeUnit getUnit() {
        return this.unit;
    }

    public final TimeSpan copy(long amount, TimeUnit unit) {
        C12238m.checkNotNullParameter(unit, "unit");
        return new TimeSpan(amount, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeSpan)) {
            return false;
        }
        TimeSpan timeSpan = (TimeSpan) other;
        return this.amount == timeSpan.amount && C12238m.areEqual(this.unit, timeSpan.unit);
    }

    public final long getAmount() {
        return this.amount;
    }

    public final TimeUnit getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int iM3a = C0002b.m3a(this.amount) * 31;
        TimeUnit timeUnit = this.unit;
        return iM3a + (timeUnit != null ? timeUnit.hashCode() : 0);
    }

    public final TimeSpan minus(TimeSpan b2) {
        C12238m.checkNotNullParameter(b2, "b");
        return new TimeSpan(toNanos() - b2.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final TimeSpan plus(TimeSpan b2) {
        C12238m.checkNotNullParameter(b2, "b");
        return new TimeSpan(b2.toNanos() + toNanos(), TimeUnit.NANOSECONDS);
    }

    public final long toDays() {
        return this.unit.toDays(this.amount);
    }

    public final long toHours() {
        return this.unit.toHours(this.amount);
    }

    public final long toMicros() {
        return this.unit.toMicros(this.amount);
    }

    public final long toMillis() {
        return this.unit.toMillis(this.amount);
    }

    public final long toMinutes() {
        return this.unit.toMinutes(this.amount);
    }

    public final long toNanos() {
        return this.unit.toNanos(this.amount);
    }

    public final long toSeconds() {
        return this.unit.toSeconds(this.amount);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TimeSpan(amount=");
        sbM833U.append(this.amount);
        sbM833U.append(", unit=");
        sbM833U.append(this.unit);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
