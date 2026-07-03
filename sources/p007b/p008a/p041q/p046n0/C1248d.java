package p007b.p008a.p041q.p046n0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.WebSocket;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.n0.d */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1248d extends AbstractC12240o implements Function1<WebSocket, Unit> {

    /* JADX INFO: renamed from: j */
    public static final C1248d f1803j = new C1248d();

    public C1248d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(WebSocket webSocket) {
        WebSocket webSocket2 = webSocket;
        C12238m.checkNotNullParameter(webSocket2, "it");
        webSocket2.mo10349e(4800, "Heartbeat timeout.");
        return Unit.f27425a;
    }
}
