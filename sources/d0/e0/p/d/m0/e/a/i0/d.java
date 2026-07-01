package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.g1.g$b;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: LazyJavaAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements d0.e0.p.d.m0.c.g1.g {
    public final g j;
    public final d0.e0.p.d.m0.e.a.k0.d k;
    public final boolean l;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.e.a.k0.a, d0.e0.p.d.m0.c.g1.c> m;

    public d(g gVar, d0.e0.p.d.m0.e.a.k0.d dVar, boolean z2) {
        m.checkNotNullParameter(gVar, "c");
        m.checkNotNullParameter(dVar, "annotationOwner");
        this.j = gVar;
        this.k = dVar;
        this.l = z2;
        this.m = gVar.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new d$a(this));
    }

    public static final /* synthetic */ boolean access$getAreAnnotationsFreshlySupported$p(d dVar) {
        return dVar.l;
    }

    public static final /* synthetic */ g access$getC$p(d dVar) {
        return dVar.j;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public d0.e0.p.d.m0.c.g1.c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        m.checkNotNullParameter(bVar, "fqName");
        d0.e0.p.d.m0.e.a.k0.a aVarFindAnnotation = this.k.findAnnotation(bVar);
        d0.e0.p.d.m0.c.g1.c cVarInvoke = aVarFindAnnotation == null ? null : this.m.invoke(aVarFindAnnotation);
        return cVarInvoke == null ? d0.e0.p.d.m0.e.a.g0.c.a.findMappedJavaAnnotation(bVar, this.k, this.j) : cVarInvoke;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return g$b.hasAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        return this.k.getAnnotations().isEmpty() && !this.k.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    public Iterator<d0.e0.p.d.m0.c.g1.c> iterator() {
        return q.filterNotNull(q.plus((Sequence<? extends d0.e0.p.d.m0.c.g1.c>) q.map(u.asSequence(this.k.getAnnotations()), this.m), d0.e0.p.d.m0.e.a.g0.c.a.findMappedJavaAnnotation(d0.e0.p.d.m0.b.k$a.u, this.k, this.j))).iterator();
    }

    public /* synthetic */ d(g gVar, d0.e0.p.d.m0.e.a.k0.d dVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, dVar, (i & 4) != 0 ? false : z2);
    }
}
