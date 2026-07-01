package b.a.q.n0;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends o implements Function1<WebSocket, Unit> {
    public static final d j = new d();

    public d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(WebSocket webSocket) {
        WebSocket webSocket2 = webSocket;
        m.checkNotNullParameter(webSocket2, "it");
        webSocket2.e(4800, "Heartbeat timeout.");
        return Unit.a;
    }
}
