package b.a.q.n0;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$g$a extends o implements Function0<Unit> {
    public final /* synthetic */ a$g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$g$a(a$g a_g) {
        super(0);
        this.this$0 = a_g;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        a.a(this.this$0.j, true, null, "The connection timed out. Did not receive OP_HELLO in time.");
        return Unit.a;
    }
}
