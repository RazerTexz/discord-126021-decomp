package b.a.q.n0;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$h extends o implements Function0<Unit> {
    public final /* synthetic */ int $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ WebSocket $webSocket;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$h(a aVar, WebSocket webSocket, int i, String str) {
        super(0);
        this.this$0 = aVar;
        this.$webSocket = webSocket;
        this.$code = i;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (!(!m.areEqual(this.$webSocket, this.this$0.f275s))) {
            a.a(this.this$0, true, Integer.valueOf(this.$code), this.$reason);
        }
        return Unit.a;
    }
}
