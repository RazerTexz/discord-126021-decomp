package b.a.q.m0;

import co.discord.media_engine.NativeCapturerObserver;
import d0.z.d.m;
import org.webrtc.TimestampAligner;

/* JADX INFO: compiled from: ScreenCapturer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$b implements Runnable {
    public final /* synthetic */ b j;

    public b$b(b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = this.j;
        if (bVar.p > 0) {
            Long l = bVar.r;
            if (l != null) {
                long rtcTimeNanos = TimestampAligner.getRtcTimeNanos() - l.longValue();
                b bVar2 = this.j;
                if (rtcTimeNanos > bVar2.q) {
                    NativeCapturerObserver nativeCapturerObserver = bVar2.l;
                    if (nativeCapturerObserver == null) {
                        m.throwUninitializedPropertyAccessException("nativeObserver");
                    }
                    nativeCapturerObserver.repeatLastFrame();
                }
            }
            this.j.c();
        }
    }
}
