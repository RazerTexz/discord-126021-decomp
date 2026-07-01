package d0.e0.p.d.m0.e.a.k0;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.util.Iterator;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d0 extends d {

    /* JADX INFO: compiled from: javaElements.kt */
    public static final class a {
        public static d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0 d0Var, FqName fqName) {
            Object obj;
            Object next;
            ClassId classId;
            Intrinsics3.checkNotNullParameter(d0Var, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Iterator<T> it = d0Var.getAnnotations().iterator();
            do {
                obj = null;
                if (it.hasNext()) {
                    next = it.next();
                    classId = ((d0.e0.p.d.m0.e.a.k0.a) next).getClassId();
                }
                return (d0.e0.p.d.m0.e.a.k0.a) obj;
            } while (!Intrinsics3.areEqual(classId != null ? classId.asSingleFqName() : null, fqName));
            obj = next;
            return (d0.e0.p.d.m0.e.a.k0.a) obj;
        }
    }
}
