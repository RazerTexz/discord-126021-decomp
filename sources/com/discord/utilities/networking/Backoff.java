package com.discord.utilities.networking;

import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Backoff {
    private long current;
    private int fails;
    private final int failureThreshold;
    private boolean isPending;
    private final boolean jitter;
    private final long maxBackoffMs;
    private final long minBackoffMs;
    private final Backoff$Scheduler scheduler;

    public Backoff() {
        this(0L, 0L, 0, false, null, 31, null);
    }

    public Backoff(long j, long j2, int i, boolean z2, Backoff$Scheduler backoff$Scheduler) {
        m.checkNotNullParameter(backoff$Scheduler, "scheduler");
        this.minBackoffMs = j;
        this.maxBackoffMs = j2;
        this.failureThreshold = i;
        this.jitter = z2;
        this.scheduler = backoff$Scheduler;
        this.current = j;
    }

    public static final /* synthetic */ void access$executeFailureCallback(Backoff backoff, Function0 function0) {
        backoff.executeFailureCallback(function0);
    }

    private final synchronized void executeFailureCallback(Function0<Unit> callback) {
        this.isPending = false;
        callback.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ long fail$default(Backoff backoff, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return backoff.fail(function0);
    }

    public final synchronized void cancel() {
        this.scheduler.cancel();
        this.isPending = false;
    }

    public final synchronized long fail(Function0<Unit> callback) {
        this.fails++;
        double dRandom = this.jitter ? Math.random() : 1.0d;
        long j = this.current;
        this.current = Math.min(j + ((long) (((long) 2) * j * dRandom)), this.maxBackoffMs);
        if (callback != null && !this.isPending) {
            this.isPending = true;
            this.scheduler.schedule(new Backoff$fail$1(this, callback), this.current);
        }
        return this.current;
    }

    public final boolean hasReachedFailureThreshold() {
        return this.fails > this.failureThreshold;
    }

    /* JADX INFO: renamed from: isPending, reason: from getter */
    public final boolean getIsPending() {
        return this.isPending;
    }

    public final synchronized void succeed() {
        cancel();
        this.fails = 0;
        this.current = this.minBackoffMs;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Backoff(long j, long j2, int i, boolean z2, Backoff$Scheduler backoff$Scheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        long j3 = (i2 & 1) != 0 ? 500L : j;
        this(j3, (i2 & 2) != 0 ? ((long) 10) * j3 : j2, (i2 & 4) != 0 ? Integer.MAX_VALUE : i, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? new Backoff$TimerScheduler(null, null, 3, null) : backoff$Scheduler);
    }
}
