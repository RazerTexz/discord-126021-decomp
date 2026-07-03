package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.HashMap;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11382k0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.o */
/* JADX INFO: compiled from: DescriptorSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11990o {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10022a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static C11914c1 substituteTypeParameters(List<InterfaceC11477z0> list, AbstractC12018z0 abstractC12018z0, InterfaceC11450m interfaceC11450m, List<InterfaceC11477z0> list2) {
        if (list == null) {
            m10022a(0);
            throw null;
        }
        if (abstractC12018z0 == null) {
            m10022a(1);
            throw null;
        }
        if (interfaceC11450m == null) {
            m10022a(2);
            throw null;
        }
        if (list2 == null) {
            m10022a(3);
            throw null;
        }
        C11914c1 c11914c1SubstituteTypeParameters = substituteTypeParameters(list, abstractC12018z0, interfaceC11450m, list2, null);
        if (c11914c1SubstituteTypeParameters != null) {
            return c11914c1SubstituteTypeParameters;
        }
        throw new AssertionError("Substitution failed");
    }

    public static C11914c1 substituteTypeParameters(List<InterfaceC11477z0> list, AbstractC12018z0 abstractC12018z0, InterfaceC11450m interfaceC11450m, List<InterfaceC11477z0> list2, boolean[] zArr) {
        if (list == null) {
            m10022a(5);
            throw null;
        }
        if (abstractC12018z0 == null) {
            m10022a(6);
            throw null;
        }
        if (interfaceC11450m == null) {
            m10022a(7);
            throw null;
        }
        if (list2 != null) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            int i = 0;
            for (InterfaceC11477z0 interfaceC11477z0 : list) {
                C11382k0 c11382k0CreateForFurtherModification = C11382k0.createForFurtherModification(interfaceC11450m, interfaceC11477z0.getAnnotations(), interfaceC11477z0.isReified(), interfaceC11477z0.getVariance(), interfaceC11477z0.getName(), i, InterfaceC11467u0.f23099a, interfaceC11477z0.getStorageManager());
                map.put(interfaceC11477z0.getTypeConstructor(), new C12016y0(c11382k0CreateForFurtherModification.getDefaultType()));
                map2.put(interfaceC11477z0, c11382k0CreateForFurtherModification);
                list2.add(c11382k0CreateForFurtherModification);
                i++;
            }
            C11914c1 c11914c1CreateChainedSubstitutor = C11914c1.createChainedSubstitutor(abstractC12018z0, AbstractC12010v0.createByConstructorsMap(map));
            for (InterfaceC11477z0 interfaceC11477z1 : list) {
                C11382k0 c11382k0 = (C11382k0) map2.get(interfaceC11477z1);
                for (AbstractC11913c0 abstractC11913c0 : interfaceC11477z1.getUpperBounds()) {
                    AbstractC11913c0 abstractC11913c0Substitute = c11914c1CreateChainedSubstitutor.substitute(abstractC11913c0, EnumC11935j1.IN_VARIANCE);
                    if (abstractC11913c0Substitute == null) {
                        return null;
                    }
                    if (abstractC11913c0Substitute != abstractC11913c0 && zArr != null) {
                        zArr[0] = true;
                    }
                    c11382k0.addUpperBound(abstractC11913c0Substitute);
                }
                c11382k0.setInitialized();
            }
            return c11914c1CreateChainedSubstitutor;
        }
        m10022a(8);
        throw null;
    }
}
