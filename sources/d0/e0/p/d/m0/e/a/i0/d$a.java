package d0.e0.p.d.m0.e.a.i0;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends o implements Function1<d0.e0.p.d.m0.e.a.k0.a, d0.e0.p.d.m0.c.g1.c> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.g1.c invoke(d0.e0.p.d.m0.e.a.k0.a aVar) {
        return invoke2(aVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.g1.c invoke2(d0.e0.p.d.m0.e.a.k0.a aVar) {
        m.checkNotNullParameter(aVar, "annotation");
        return d0.e0.p.d.m0.e.a.g0.c.a.mapOrResolveJavaAnnotation(aVar, d.access$getC$p(this.this$0), d.access$getAreAnnotationsFreshlySupported$p(this.this$0));
    }
}
