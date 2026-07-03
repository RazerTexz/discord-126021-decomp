package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.j */
/* JADX INFO: compiled from: SignaturePropagator.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11507j {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC11507j f23249a = new a();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.j$a */
    /* JADX INFO: compiled from: SignaturePropagator.java */
    public static class a implements InterfaceC11507j {
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9454a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i == 5 || i == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public void reportSignatureErrors(InterfaceC11321b interfaceC11321b, List<String> list) {
            if (interfaceC11321b == null) {
                m9454a(5);
                throw null;
            }
            if (list != null) {
                throw new UnsupportedOperationException("Should not be called");
            }
            m9454a(6);
            throw null;
        }

        public b resolvePropagatedSignature(InterfaceC11585r interfaceC11585r, InterfaceC11330e interfaceC11330e, AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, List<InterfaceC11326c1> list, List<InterfaceC11477z0> list2) {
            if (interfaceC11585r == null) {
                m9454a(0);
                throw null;
            }
            if (interfaceC11330e == null) {
                m9454a(1);
                throw null;
            }
            if (abstractC11913c0 == null) {
                m9454a(2);
                throw null;
            }
            if (list == null) {
                m9454a(3);
                throw null;
            }
            if (list2 != null) {
                return new b(abstractC11913c0, abstractC11913c1, list, list2, Collections.emptyList(), false);
            }
            m9454a(4);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.j$b */
    /* JADX INFO: compiled from: SignaturePropagator.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public final AbstractC11913c0 f23250a;

        /* JADX INFO: renamed from: b */
        public final AbstractC11913c0 f23251b;

        /* JADX INFO: renamed from: c */
        public final List<InterfaceC11326c1> f23252c;

        /* JADX INFO: renamed from: d */
        public final List<InterfaceC11477z0> f23253d;

        /* JADX INFO: renamed from: e */
        public final List<String> f23254e;

        /* JADX INFO: renamed from: f */
        public final boolean f23255f;

        public b(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, List<InterfaceC11326c1> list, List<InterfaceC11477z0> list2, List<String> list3, boolean z2) {
            if (abstractC11913c0 == null) {
                m9455a(0);
                throw null;
            }
            if (list == null) {
                m9455a(1);
                throw null;
            }
            if (list2 == null) {
                m9455a(2);
                throw null;
            }
            if (list3 == null) {
                m9455a(3);
                throw null;
            }
            this.f23250a = abstractC11913c0;
            this.f23251b = abstractC11913c1;
            this.f23252c = list;
            this.f23253d = list2;
            this.f23254e = list3;
            this.f23255f = z2;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9455a(int i) {
            String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
            switch (i) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i == 4) {
                objArr[1] = "getReturnType";
            } else if (i == 5) {
                objArr[1] = "getValueParameters";
            } else if (i == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i != 4 && i != 5 && i != 6 && i != 7) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 4 && i != 5 && i != 6 && i != 7) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public List<String> getErrors() {
            List<String> list = this.f23254e;
            if (list != null) {
                return list;
            }
            m9455a(7);
            throw null;
        }

        public AbstractC11913c0 getReceiverType() {
            return this.f23251b;
        }

        public AbstractC11913c0 getReturnType() {
            AbstractC11913c0 abstractC11913c0 = this.f23250a;
            if (abstractC11913c0 != null) {
                return abstractC11913c0;
            }
            m9455a(4);
            throw null;
        }

        public List<InterfaceC11477z0> getTypeParameters() {
            List<InterfaceC11477z0> list = this.f23253d;
            if (list != null) {
                return list;
            }
            m9455a(6);
            throw null;
        }

        public List<InterfaceC11326c1> getValueParameters() {
            List<InterfaceC11326c1> list = this.f23252c;
            if (list != null) {
                return list;
            }
            m9455a(5);
            throw null;
        }

        public boolean hasStableParameterNames() {
            return this.f23255f;
        }
    }
}
