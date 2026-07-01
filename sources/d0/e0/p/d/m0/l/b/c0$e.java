package d0.e0.p.d.m0.l.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$e extends d0.z.d.o implements Function1<d0.e0.p.d.m0.f.q, d0.e0.p.d.m0.f.q> {
    public final /* synthetic */ c0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0$e(c0 c0Var) {
        super(1);
        this.this$0 = c0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.f.q invoke(d0.e0.p.d.m0.f.q qVar) {
        return invoke2(qVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.f.q invoke2(d0.e0.p.d.m0.f.q qVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "it");
        return d0.e0.p.d.m0.f.z.f.outerType(qVar, c0.access$getC$p(this.this$0).getTypeTable());
    }
}
