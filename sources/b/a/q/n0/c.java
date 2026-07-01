package b.a.q.n0;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o implements Function0<Unit> {
    public final /* synthetic */ Integer $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ boolean $wasFatal;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, boolean z2, Integer num, String str) {
        super(0);
        this.this$0 = aVar;
        this.$wasFatal = z2;
        this.$code = num;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        a aVar = this.this$0;
        boolean z2 = this.$wasFatal;
        Integer num = this.$code;
        String str = this.$reason;
        int i = a.j;
        aVar.l(z2, num, str);
        return Unit.a;
    }
}
