package com.facebook.common.time;

import android.os.SystemClock;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p115d.p126k.InterfaceC1714b;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC1680c
public class RealtimeSinceBootClock implements InterfaceC1714b {

    /* JADX INFO: renamed from: a */
    public static final RealtimeSinceBootClock f19450a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @InterfaceC1680c
    public static RealtimeSinceBootClock get() {
        return f19450a;
    }

    @Override // p007b.p109f.p115d.p126k.InterfaceC1714b
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
