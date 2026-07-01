package d0.e0.p.d.m0.c.i1;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y$b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.c.j0> {
    public final /* synthetic */ y this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y$b(y yVar) {
        super(1);
        this.this$0 = yVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.j0 invoke(d0.e0.p.d.m0.g.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.j0 invoke2(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        y yVar = this.this$0;
        return new s(yVar, bVar, y.access$getStorageManager$p(yVar));
    }
}
