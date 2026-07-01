package b.a.a.a;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$f extends o implements Function0<f> {
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$f(b bVar) {
        super(0);
        this.this$0 = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public f invoke() {
        return new f(((Number) this.this$0.slotId.getValue()).longValue(), null, null, null, null, 30);
    }
}
