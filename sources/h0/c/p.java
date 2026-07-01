package h0.c;

import org.webrtc.JniCommon;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ long j;

    public /* synthetic */ p(long j) {
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeReleaseRef(this.j);
    }
}
