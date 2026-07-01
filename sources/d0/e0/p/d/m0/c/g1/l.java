package d0.e0.p.d.m0.c.g1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements g {
    public final g j;
    public final boolean k;
    public final Function1<d0.e0.p.d.m0.g.b, Boolean> l;

    /* JADX WARN: Multi-variable type inference failed */
    public l(g gVar, boolean z2, Function1<? super d0.e0.p.d.m0.g.b, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(gVar, "delegate");
        d0.z.d.m.checkNotNullParameter(function1, "fqNameFilter");
        this.j = gVar;
        this.k = z2;
        this.l = function1;
    }

    public final boolean c(c cVar) {
        d0.e0.p.d.m0.g.b fqName = cVar.getFqName();
        return fqName != null && this.l.invoke(fqName).booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        if (this.l.invoke(bVar).booleanValue()) {
            return this.j.findAnnotation(bVar);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        if (this.l.invoke(bVar).booleanValue()) {
            return this.j.hasAnnotation(bVar);
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        boolean z2;
        g gVar = this.j;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (c(it.next())) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (this.k) {
            return !z2;
        }
        return z2;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        g gVar = this.j;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (c(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(g gVar, Function1<? super d0.e0.p.d.m0.g.b, Boolean> function1) {
        this(gVar, false, function1);
        d0.z.d.m.checkNotNullParameter(gVar, "delegate");
        d0.z.d.m.checkNotNullParameter(function1, "fqNameFilter");
    }
}
