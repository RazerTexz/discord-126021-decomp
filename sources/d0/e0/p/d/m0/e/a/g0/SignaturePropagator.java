package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.e.a.k0.r;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.j, reason: use source file name */
/* JADX INFO: compiled from: SignaturePropagator.java */
/* JADX INFO: loaded from: classes3.dex */
public interface SignaturePropagator {
    public static final SignaturePropagator a = new a();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.j$a */
    /* JADX INFO: compiled from: SignaturePropagator.java */
    public static class a implements SignaturePropagator {
        public static /* synthetic */ void a(int i) {
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

        public void reportSignatureErrors(CallableMemberDescriptor callableMemberDescriptor, List<String> list) {
            if (callableMemberDescriptor == null) {
                a(5);
                throw null;
            }
            if (list != null) {
                throw new UnsupportedOperationException("Should not be called");
            }
            a(6);
            throw null;
        }

        public b resolvePropagatedSignature(r rVar, ClassDescriptor classDescriptor, KotlinType kotlinType, KotlinType kotlinType2, List<ValueParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
            if (rVar == null) {
                a(0);
                throw null;
            }
            if (classDescriptor == null) {
                a(1);
                throw null;
            }
            if (kotlinType == null) {
                a(2);
                throw null;
            }
            if (list == null) {
                a(3);
                throw null;
            }
            if (list2 != null) {
                return new b(kotlinType, kotlinType2, list, list2, Collections.emptyList(), false);
            }
            a(4);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.j$b */
    /* JADX INFO: compiled from: SignaturePropagator.java */
    public static class b {
        public final KotlinType a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final KotlinType f3317b;
        public final List<ValueParameterDescriptor> c;
        public final List<TypeParameterDescriptor> d;
        public final List<String> e;
        public final boolean f;

        public b(KotlinType kotlinType, KotlinType kotlinType2, List<ValueParameterDescriptor> list, List<TypeParameterDescriptor> list2, List<String> list3, boolean z2) {
            if (kotlinType == null) {
                a(0);
                throw null;
            }
            if (list == null) {
                a(1);
                throw null;
            }
            if (list2 == null) {
                a(2);
                throw null;
            }
            if (list3 == null) {
                a(3);
                throw null;
            }
            this.a = kotlinType;
            this.f3317b = kotlinType2;
            this.c = list;
            this.d = list2;
            this.e = list3;
            this.f = z2;
        }

        public static /* synthetic */ void a(int i) {
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
            List<String> list = this.e;
            if (list != null) {
                return list;
            }
            a(7);
            throw null;
        }

        public KotlinType getReceiverType() {
            return this.f3317b;
        }

        public KotlinType getReturnType() {
            KotlinType kotlinType = this.a;
            if (kotlinType != null) {
                return kotlinType;
            }
            a(4);
            throw null;
        }

        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> list = this.d;
            if (list != null) {
                return list;
            }
            a(6);
            throw null;
        }

        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> list = this.c;
            if (list != null) {
                return list;
            }
            a(5);
            throw null;
        }

        public boolean hasStableParameterNames() {
            return this.f;
        }
    }
}
