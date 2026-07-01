package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.e.a.k0.l;
import d0.e0.p.d.m0.e.a.k0.n;
import d0.e0.p.d.m0.e.a.k0.q;
import d0.e0.p.d.m0.g.FqName;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.g, reason: use source file name */
/* JADX INFO: compiled from: JavaResolverCache.java */
/* JADX INFO: loaded from: classes3.dex */
public interface JavaResolverCache {
    public static final JavaResolverCache a = new a();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.g$a */
    /* JADX INFO: compiled from: JavaResolverCache.java */
    public static class a implements JavaResolverCache {
        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public ClassDescriptor getClassResolvedFromSource(FqName fqName) {
            if (fqName != null) {
                return null;
            }
            a(0);
            throw null;
        }

        public void recordClass(d0.e0.p.d.m0.e.a.k0.g gVar, ClassDescriptor classDescriptor) {
            if (gVar == null) {
                a(7);
                throw null;
            }
            if (classDescriptor != null) {
                return;
            }
            a(8);
            throw null;
        }

        public void recordConstructor(l lVar, ConstructorDescriptor constructorDescriptor) {
            if (lVar == null) {
                a(3);
                throw null;
            }
            if (constructorDescriptor != null) {
                return;
            }
            a(4);
            throw null;
        }

        public void recordField(n nVar, PropertyDescriptor propertyDescriptor) {
            if (nVar == null) {
                a(5);
                throw null;
            }
            if (propertyDescriptor != null) {
                return;
            }
            a(6);
            throw null;
        }

        public void recordMethod(q qVar, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            if (qVar == null) {
                a(1);
                throw null;
            }
            if (simpleFunctionDescriptor != null) {
                return;
            }
            a(2);
            throw null;
        }
    }
}
