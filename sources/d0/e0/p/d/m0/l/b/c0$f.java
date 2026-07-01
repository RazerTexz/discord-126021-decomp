package d0.e0.p.d.m0.l.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$f extends d0.z.d.o implements Function1<d0.e0.p.d.m0.f.q, Integer> {
    public static final c0$f j = new c0$f();

    public c0$f() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(d0.e0.p.d.m0.f.q qVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "it");
        return qVar.getArgumentCount();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(d0.e0.p.d.m0.f.q qVar) {
        return Integer.valueOf(invoke2(qVar));
    }
}
