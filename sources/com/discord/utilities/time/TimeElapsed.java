package com.discord.utilities.time;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TimeElapsed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeElapsed {

    /* JADX INFO: renamed from: milliseconds$delegate, reason: from kotlin metadata */
    private final Lazy milliseconds;

    /* JADX INFO: renamed from: seconds$delegate, reason: from kotlin metadata */
    private final Lazy seconds;
    private final long startTime;

    public TimeElapsed(Clock clock, long j) {
        C12238m.checkNotNullParameter(clock, "clock");
        this.startTime = j;
        this.milliseconds = C12083g.lazy(new TimeElapsed$milliseconds$2(this, clock));
        this.seconds = C12083g.lazy(new TimeElapsed$seconds$2(this));
    }

    public final long getMilliseconds() {
        return ((Number) this.milliseconds.getValue()).longValue();
    }

    public final float getSeconds() {
        return ((Number) this.seconds.getValue()).floatValue();
    }

    public /* synthetic */ TimeElapsed(Clock clock, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clock, (i & 2) != 0 ? clock.currentTimeMillis() : j);
    }
}
