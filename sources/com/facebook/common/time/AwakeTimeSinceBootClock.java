package com.facebook.common.time;

import android.os.SystemClock;
import b.f.d.d.c;
import b.f.d.k.b;

/* JADX INFO: loaded from: classes.dex */
@c
public class AwakeTimeSinceBootClock implements b {

    @c
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @c
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // b.f.d.k.b
    @c
    public long now() {
        return SystemClock.uptimeMillis();
    }

    @c
    public long nowNanos() {
        return System.nanoTime();
    }
}
