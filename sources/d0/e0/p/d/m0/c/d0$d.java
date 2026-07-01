package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.b, e0> {
    public final /* synthetic */ d0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0$d(d0 d0Var) {
        super(1);
        this.this$0 = d0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e0 invoke(d0.e0.p.d.m0.g.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e0 invoke2(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return new d0.e0.p.d.m0.c.i1.n(d0.access$getModule$p(this.this$0), bVar);
    }
}
