package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11579l;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.g */
/* JADX INFO: compiled from: JavaResolverCache.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11504g {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC11504g f23244a = new a();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.g$a */
    /* JADX INFO: compiled from: JavaResolverCache.java */
    public static class a implements InterfaceC11504g {
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9453a(int i) {
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

        public InterfaceC11330e getClassResolvedFromSource(C11713b c11713b) {
            if (c11713b != null) {
                return null;
            }
            m9453a(0);
            throw null;
        }

        public void recordClass(InterfaceC11574g interfaceC11574g, InterfaceC11330e interfaceC11330e) {
            if (interfaceC11574g == null) {
                m9453a(7);
                throw null;
            }
            if (interfaceC11330e != null) {
                return;
            }
            m9453a(8);
            throw null;
        }

        public void recordConstructor(InterfaceC11579l interfaceC11579l, InterfaceC11448l interfaceC11448l) {
            if (interfaceC11579l == null) {
                m9453a(3);
                throw null;
            }
            if (interfaceC11448l != null) {
                return;
            }
            m9453a(4);
            throw null;
        }

        public void recordField(InterfaceC11581n interfaceC11581n, InterfaceC11453n0 interfaceC11453n0) {
            if (interfaceC11581n == null) {
                m9453a(5);
                throw null;
            }
            if (interfaceC11453n0 != null) {
                return;
            }
            m9453a(6);
            throw null;
        }

        public void recordMethod(InterfaceC11584q interfaceC11584q, InterfaceC11465t0 interfaceC11465t0) {
            if (interfaceC11584q == null) {
                m9453a(1);
                throw null;
            }
            if (interfaceC11465t0 != null) {
                return;
            }
            m9453a(2);
            throw null;
        }
    }
}
