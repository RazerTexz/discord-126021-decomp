package com.discord.utilities.time;

import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TimeElapsed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeElapsed {

    /* JADX INFO: renamed from: milliseconds$delegate, reason: from kotlin metadata */
    private final Lazy milliseconds;

    /* JADX INFO: renamed from: seconds$delegate, reason: from kotlin metadata */
    private final Lazy seconds;
    private final long startTime;

    public TimeElapsed(Clock clock, long j) {
        m.checkNotNullParameter(clock, "clock");
        this.startTime = j;
        this.milliseconds = g.lazy(new TimeElapsed$milliseconds$2(this, clock));
        this.seconds = g.lazy(new TimeElapsed$seconds$2(this));
    }

    public static final /* synthetic */ long access$getStartTime$p(TimeElapsed timeElapsed) {
        return timeElapsed.startTime;
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
