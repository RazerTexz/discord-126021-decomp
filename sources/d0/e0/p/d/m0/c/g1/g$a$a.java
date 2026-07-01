package d0.e0.p.d.m0.c.g1;

import java.util.Iterator;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a$a implements g {
    @Override // d0.e0.p.d.m0.c.g1.g
    public /* bridge */ /* synthetic */ c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return (c) m84findAnnotation(bVar);
    }

    /* JADX INFO: renamed from: findAnnotation, reason: collision with other method in class */
    public Void m84findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return null;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return g$b.hasAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return d0.t.n.emptyList().iterator();
    }

    public String toString() {
        return "EMPTY";
    }
}
