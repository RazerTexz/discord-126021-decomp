package d0.e0.p.d;

import d0.e0.p.d.m0.c.g1.g$a;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.p0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$d$b extends d0.z.d.o implements Function0<p0> {
    public final /* synthetic */ s$d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s$d$b(s$d s_d) {
        super(0);
        this.this$0 = s_d;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ p0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final p0 invoke() {
        p0 setter = this.this$0.getProperty().getDescriptor().getSetter();
        if (setter != null) {
            return setter;
        }
        n0 descriptor = this.this$0.getProperty().getDescriptor();
        g$a g_a = d0.e0.p.d.m0.c.g1.g.f;
        return d0.e0.p.d.m0.k.d.createDefaultSetter(descriptor, g_a.getEMPTY(), g_a.getEMPTY());
    }
}
