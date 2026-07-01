package b.a.q.n0;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends o implements Function0<Unit> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(0);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        a aVar = this.this$0;
        int i = a.j;
        aVar.l(true, 4800, "Heartbeat timeout.");
        return Unit.a;
    }
}
