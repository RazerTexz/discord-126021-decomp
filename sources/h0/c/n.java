package h0.c;

import org.webrtc.HardwareVideoEncoder;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ HardwareVideoEncoder j;
    public final /* synthetic */ int k;

    public /* synthetic */ n(HardwareVideoEncoder hardwareVideoEncoder, int i) {
        this.j = hardwareVideoEncoder;
        this.k = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.k);
    }
}
