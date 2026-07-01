package b.a.a.a;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$f extends o implements Function0<k> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$f(a aVar) {
        super(0);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public k invoke() {
        return new k(((Number) this.this$0.slotId.getValue()).longValue(), null, null, null, null, 30);
    }
}
