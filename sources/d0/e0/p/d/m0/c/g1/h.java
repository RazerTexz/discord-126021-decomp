package d0.e0.p.d.m0.c.g1;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AnnotationsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements g {
    public final List<c> j;

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends c> list) {
        d0.z.d.m.checkNotNullParameter(list, "annotations");
        this.j = list;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return g$b.findAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return g$b.hasAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return this.j.iterator();
    }

    public String toString() {
        return this.j.toString();
    }
}
