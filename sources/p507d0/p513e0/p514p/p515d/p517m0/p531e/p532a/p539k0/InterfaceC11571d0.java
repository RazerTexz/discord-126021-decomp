package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.d0 */
/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11571d0 extends InterfaceC11570d {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.d0$a */
    /* JADX INFO: compiled from: javaElements.kt */
    public static final class a {
        public static InterfaceC11564a findAnnotation(InterfaceC11571d0 interfaceC11571d0, C11713b c11713b) {
            Object obj;
            Object next;
            C11712a classId;
            C12238m.checkNotNullParameter(interfaceC11571d0, "this");
            C12238m.checkNotNullParameter(c11713b, "fqName");
            Iterator<T> it = interfaceC11571d0.getAnnotations().iterator();
            do {
                obj = null;
                if (it.hasNext()) {
                    next = it.next();
                    classId = ((InterfaceC11564a) next).getClassId();
                }
                return (InterfaceC11564a) obj;
            } while (!C12238m.areEqual(classId != null ? classId.asSingleFqName() : null, c11713b));
            obj = next;
            return (InterfaceC11564a) obj;
        }
    }
}
