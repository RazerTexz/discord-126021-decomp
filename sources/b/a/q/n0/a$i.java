package b.a.q.n0;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$i extends o implements Function0<Unit> {
    public final /* synthetic */ Throwable $t;
    public final /* synthetic */ WebSocket $webSocket;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$i(a aVar, WebSocket webSocket, Throwable th) {
        super(0);
        this.this$0 = aVar;
        this.$webSocket = webSocket;
        this.$t = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (!(!m.areEqual(this.$webSocket, this.this$0.f275s))) {
            a aVar = this.this$0;
            StringBuilder sbU = b.d.b.a.a.U("An error with the websocket occurred: ");
            sbU.append(this.$t.getMessage());
            a.a(aVar, true, null, sbU.toString());
        }
        return Unit.a;
    }
}
