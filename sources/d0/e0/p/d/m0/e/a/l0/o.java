package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, c0> {
    public static final o j = new o();

    public o() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c0 invoke(d0.e0.p.d.m0.c.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c0 invoke2(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "it");
        c0 returnType = bVar.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        return returnType;
    }
}
