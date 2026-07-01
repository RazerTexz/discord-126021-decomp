package d0.e0.p.d.m0.c.g1;

import java.util.Iterator;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b {
    public static c findAnnotation(g gVar, d0.e0.p.d.m0.g.b bVar) {
        c next;
        d0.z.d.m.checkNotNullParameter(gVar, "this");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        Iterator<c> it = gVar.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (d0.z.d.m.areEqual(next.getFqName(), bVar)) {
                return next;
            }
        }
        next = null;
        return next;
    }

    public static boolean hasAnnotation(g gVar, d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "this");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return gVar.findAnnotation(bVar) != null;
    }
}
