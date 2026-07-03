package com.facebook.common.time;

import android.os.SystemClock;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p115d.p126k.InterfaceC1714b;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC1680c
public class AwakeTimeSinceBootClock implements InterfaceC1714b {

    @InterfaceC1680c
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @InterfaceC1680c
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // p007b.p109f.p115d.p126k.InterfaceC1714b
    @InterfaceC1680c
    public long now() {
        return SystemClock.uptimeMillis();
    }

    @InterfaceC1680c
    public long nowNanos() {
        return System.nanoTime();
    }
}
