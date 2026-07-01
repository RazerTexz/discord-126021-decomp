package d0.e0.p.d;

import d0.e0.p.d.m0.c.o0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$c$b extends d0.z.d.o implements Function0<o0> {
    public final /* synthetic */ s$c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s$c$b(s$c s_c) {
        super(0);
        this.this$0 = s_c;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ o0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final o0 invoke() {
        o0 getter = this.this$0.getProperty().getDescriptor().getGetter();
        return getter != null ? getter : d0.e0.p.d.m0.k.d.createDefaultGetter(this.this$0.getProperty().getDescriptor(), d0.e0.p.d.m0.c.g1.g.f.getEMPTY());
    }
}
