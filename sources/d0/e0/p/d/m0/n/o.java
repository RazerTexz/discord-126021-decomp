package d0.e0.p.d.m0.n;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DescriptorSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {
    public static /* synthetic */ void a(int i) {
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

    public static c1 substituteTypeParameters(List<d0.e0.p.d.m0.c.z0> list, z0 z0Var, d0.e0.p.d.m0.c.m mVar, List<d0.e0.p.d.m0.c.z0> list2) {
        if (list == null) {
            a(0);
            throw null;
        }
        if (z0Var == null) {
            a(1);
            throw null;
        }
        if (mVar == null) {
            a(2);
            throw null;
        }
        if (list2 == null) {
            a(3);
            throw null;
        }
        c1 c1VarSubstituteTypeParameters = substituteTypeParameters(list, z0Var, mVar, list2, null);
        if (c1VarSubstituteTypeParameters != null) {
            return c1VarSubstituteTypeParameters;
        }
        throw new AssertionError("Substitution failed");
    }

    public static c1 substituteTypeParameters(List<d0.e0.p.d.m0.c.z0> list, z0 z0Var, d0.e0.p.d.m0.c.m mVar, List<d0.e0.p.d.m0.c.z0> list2, boolean[] zArr) {
        if (list == null) {
            a(5);
            throw null;
        }
        if (z0Var == null) {
            a(6);
            throw null;
        }
        if (mVar == null) {
            a(7);
            throw null;
        }
        if (list2 != null) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            int i = 0;
            for (d0.e0.p.d.m0.c.z0 z0Var2 : list) {
                d0.e0.p.d.m0.c.i1.k0 k0VarCreateForFurtherModification = d0.e0.p.d.m0.c.i1.k0.createForFurtherModification(mVar, z0Var2.getAnnotations(), z0Var2.isReified(), z0Var2.getVariance(), z0Var2.getName(), i, d0.e0.p.d.m0.c.u0.a, z0Var2.getStorageManager());
                map.put(z0Var2.getTypeConstructor(), new y0(k0VarCreateForFurtherModification.getDefaultType()));
                map2.put(z0Var2, k0VarCreateForFurtherModification);
                list2.add(k0VarCreateForFurtherModification);
                i++;
            }
            c1 c1VarCreateChainedSubstitutor = c1.createChainedSubstitutor(z0Var, v0.createByConstructorsMap(map));
            for (d0.e0.p.d.m0.c.z0 z0Var3 : list) {
                d0.e0.p.d.m0.c.i1.k0 k0Var = (d0.e0.p.d.m0.c.i1.k0) map2.get(z0Var3);
                for (c0 c0Var : z0Var3.getUpperBounds()) {
                    c0 c0VarSubstitute = c1VarCreateChainedSubstitutor.substitute(c0Var, j1.IN_VARIANCE);
                    if (c0VarSubstitute == null) {
                        return null;
                    }
                    if (c0VarSubstitute != c0Var && zArr != null) {
                        zArr[0] = true;
                    }
                    k0Var.addUpperBound(c0VarSubstitute);
                }
                k0Var.setInitialized();
            }
            return c1VarCreateChainedSubstitutor;
        }
        a(8);
        throw null;
    }
}
