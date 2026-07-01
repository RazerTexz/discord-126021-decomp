package b.a.q.n0;

import d0.z.d.Lambda;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.n0.b, reason: use source file name */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcControlSocket2 extends TimerTask {
    public final /* synthetic */ RtcControlSocket j;

    /* JADX INFO: renamed from: b.a.q.n0.b$a */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            RtcControlSocket rtcControlSocket = RtcControlSocket2.this.j;
            int i = RtcControlSocket.j;
            rtcControlSocket.k();
            return Unit.a;
        }
    }

    public RtcControlSocket2(RtcControlSocket rtcControlSocket) {
        this.j = rtcControlSocket;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.j.m(new a());
    }
}
