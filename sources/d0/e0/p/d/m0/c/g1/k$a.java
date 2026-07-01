package d0.e0.p.d.m0.c.g1;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a extends o implements Function1<g, c> {
    public final /* synthetic */ d0.e0.p.d.m0.g.b $fqName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$a(d0.e0.p.d.m0.g.b bVar) {
        super(1);
        this.$fqName = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c invoke(g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c invoke2(g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "it");
        return gVar.findAnnotation(this.$fqName);
    }
}
