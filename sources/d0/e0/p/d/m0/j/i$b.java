package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.n.c0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b extends d0.z.d.o implements Function1<c0, c0> {
    public static final i$b j = new i$b();

    public i$b() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c0 invoke2(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "it");
        return c0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c0 invoke(c0 c0Var) {
        return invoke2(c0Var);
    }
}
