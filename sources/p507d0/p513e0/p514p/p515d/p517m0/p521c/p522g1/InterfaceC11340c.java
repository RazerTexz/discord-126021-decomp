package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.c */
/* JADX INFO: compiled from: AnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11340c {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.c$a */
    /* JADX INFO: compiled from: AnnotationDescriptor.kt */
    public static final class a {
        public static C11713b getFqName(InterfaceC11340c interfaceC11340c) {
            C12238m.checkNotNullParameter(interfaceC11340c, "this");
            InterfaceC11330e annotationClass = C11836a.getAnnotationClass(interfaceC11340c);
            if (annotationClass == null) {
                return null;
            }
            if (C12005t.isError(annotationClass)) {
                annotationClass = null;
            }
            if (annotationClass == null) {
                return null;
            }
            return C11836a.fqNameOrNull(annotationClass);
        }
    }

    Map<C11716e, AbstractC11815g<?>> getAllValueArguments();

    C11713b getFqName();

    InterfaceC11467u0 getSource();

    AbstractC11913c0 getType();
}
