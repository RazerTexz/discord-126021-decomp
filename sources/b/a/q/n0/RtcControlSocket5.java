package b.a.q.n0;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.n0.e, reason: use source file name */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcControlSocket5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RtcControlSocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RtcControlSocket5(RtcControlSocket rtcControlSocket) {
        super(0);
        this.this$0 = rtcControlSocket;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcControlSocket rtcControlSocket = this.this$0;
        int i = RtcControlSocket.j;
        rtcControlSocket.l(true, 4800, "Heartbeat timeout.");
        return Unit.a;
    }
}
