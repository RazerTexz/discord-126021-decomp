package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$e extends d0.z.d.o implements Function1<n0, CharSequence> {
    public static final i$e j = new i$e();

    public i$e() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(n0 n0Var) {
        return invoke2(n0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(n0 n0Var) {
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        return d0.e0.p.d.m0.j.c.c.render(n0Var) + " | " + f0.f3198b.mapPropertySignature(n0Var).asString();
    }
}
