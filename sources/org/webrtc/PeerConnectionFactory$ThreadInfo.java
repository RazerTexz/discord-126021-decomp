package org.webrtc;

import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnectionFactory$ThreadInfo {
    public final Thread thread;
    public final int tid;

    private PeerConnectionFactory$ThreadInfo(Thread thread, int i) {
        this.thread = thread;
        this.tid = i;
    }

    public static PeerConnectionFactory$ThreadInfo getCurrent() {
        return new PeerConnectionFactory$ThreadInfo(Thread.currentThread(), Process.myTid());
    }
}
