package d0.e0.p.d;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.x, CharSequence> {
    public static final i$d j = new i$d();

    public i$d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(d0.e0.p.d.m0.c.x xVar) {
        return invoke2(xVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(d0.e0.p.d.m0.c.x xVar) {
        d0.z.d.m.checkNotNullParameter(xVar, "descriptor");
        return d0.e0.p.d.m0.j.c.c.render(xVar) + " | " + f0.f3198b.mapSignature(xVar).asString();
    }
}
