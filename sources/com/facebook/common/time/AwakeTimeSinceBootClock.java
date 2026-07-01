package com.facebook.common.time;

import android.os.SystemClock;
import b.f.d.d.DoNotStrip;
import b.f.d.k.MonotonicClock;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class AwakeTimeSinceBootClock implements MonotonicClock {

    @DoNotStrip
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @DoNotStrip
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // b.f.d.k.MonotonicClock
    @DoNotStrip
    public long now() {
        return SystemClock.uptimeMillis();
    }

    @DoNotStrip
    public long nowNanos() {
        return System.nanoTime();
    }
}
