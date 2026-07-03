package p007b.p008a.p041q.p046n0;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.n0.e */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1249e extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ C1245a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1249e(C1245a c1245a) {
        super(0);
        this.this$0 = c1245a;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        C1245a c1245a = this.this$0;
        int i = C1245a.f1763j;
        c1245a.m348l(true, 4800, "Heartbeat timeout.");
        return Unit.f27425a;
    }
}
