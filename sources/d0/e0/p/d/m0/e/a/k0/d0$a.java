package d0.e0.p.d.m0.e.a.k0;

import java.util.Iterator;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$a {
    public static a findAnnotation(d0 d0Var, d0.e0.p.d.m0.g.b bVar) {
        Object obj;
        Object next;
        d0.e0.p.d.m0.g.a classId;
        d0.z.d.m.checkNotNullParameter(d0Var, "this");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        Iterator<T> it = d0Var.getAnnotations().iterator();
        do {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
                classId = ((a) next).getClassId();
            }
            return (a) obj;
        } while (!d0.z.d.m.areEqual(classId != null ? classId.asSingleFqName() : null, bVar));
        obj = next;
        return (a) obj;
    }
}
