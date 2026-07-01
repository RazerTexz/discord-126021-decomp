package b.a.q.n0;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.WebSocket;

/* JADX INFO: renamed from: b.a.q.n0.d, reason: use source file name */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcControlSocket4 extends Lambda implements Function1<WebSocket, Unit> {
    public static final RtcControlSocket4 j = new RtcControlSocket4();

    public RtcControlSocket4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(WebSocket webSocket) {
        WebSocket webSocket2 = webSocket;
        Intrinsics3.checkNotNullParameter(webSocket2, "it");
        webSocket2.e(4800, "Heartbeat timeout.");
        return Unit.a;
    }
}
