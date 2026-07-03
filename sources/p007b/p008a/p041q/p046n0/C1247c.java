package p007b.p008a.p041q.p046n0;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.n0.c */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1247c extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Integer $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ boolean $wasFatal;
    public final /* synthetic */ C1245a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1247c(C1245a c1245a, boolean z2, Integer num, String str) {
        super(0);
        this.this$0 = c1245a;
        this.$wasFatal = z2;
        this.$code = num;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        C1245a c1245a = this.this$0;
        boolean z2 = this.$wasFatal;
        Integer num = this.$code;
        String str = this.$reason;
        int i = C1245a.f1763j;
        c1245a.m348l(z2, num, str);
        return Unit.f27425a;
    }
}
