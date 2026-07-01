package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.g.FqName;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g, reason: use source file name */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Annotations4 extends Iterable<AnnotationDescriptor>, KMarkers {
    public static final a f = a.a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$a */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Annotations4 f3251b = new C0379a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Annotations.kt */
        public static final class C0379a implements Annotations4 {
            @Override // d0.e0.p.d.m0.c.g1.Annotations4
            public /* bridge */ /* synthetic */ AnnotationDescriptor findAnnotation(FqName fqName) {
                return (AnnotationDescriptor) m84findAnnotation(fqName);
            }

            /* JADX INFO: renamed from: findAnnotation, reason: collision with other method in class */
            public Void m84findAnnotation(FqName fqName) {
                Intrinsics3.checkNotNullParameter(fqName, "fqName");
                return null;
            }

            @Override // d0.e0.p.d.m0.c.g1.Annotations4
            public boolean hasAnnotation(FqName fqName) {
                return b.hasAnnotation(this, fqName);
            }

            @Override // d0.e0.p.d.m0.c.g1.Annotations4
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<AnnotationDescriptor> iterator() {
                return Collections2.emptyList().iterator();
            }

            public String toString() {
                return "EMPTY";
            }
        }

        public final Annotations4 create(List<? extends AnnotationDescriptor> list) {
            Intrinsics3.checkNotNullParameter(list, "annotations");
            return list.isEmpty() ? f3251b : new AnnotationsImpl(list);
        }

        public final Annotations4 getEMPTY() {
            return f3251b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$b */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class b {
        public static AnnotationDescriptor findAnnotation(Annotations4 annotations4, FqName fqName) {
            AnnotationDescriptor next;
            Intrinsics3.checkNotNullParameter(annotations4, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Iterator<AnnotationDescriptor> it = annotations4.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics3.areEqual(next.getFqName(), fqName)) {
                    return next;
                }
            }
            next = null;
            return next;
        }

        public static boolean hasAnnotation(Annotations4 annotations4, FqName fqName) {
            Intrinsics3.checkNotNullParameter(annotations4, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            return annotations4.findAnnotation(fqName) != null;
        }
    }

    AnnotationDescriptor findAnnotation(FqName fqName);

    boolean hasAnnotation(FqName fqName);

    boolean isEmpty();
}
