package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$f implements u0 {
    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                break;
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "descriptor";
                break;
        }
        if (i == 1) {
            objArr[1] = "getTypeParameterDescriptor";
        } else if (i == 2) {
            objArr[1] = "getParameters";
        } else if (i == 3) {
            objArr[1] = "getSupertypes";
        } else if (i == 4) {
            objArr[1] = "getBuiltIns";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
        } else {
            objArr[1] = "refine";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
                break;
            case 5:
                objArr[2] = "refine";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        d0.e0.p.d.m0.b.h builtIns = d0.e0.p.d.m0.k.x.a.getBuiltIns(null);
        if (builtIns != null) {
            return builtIns;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<d0.e0.p.d.m0.c.z0> getParameters() {
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<c0> getSupertypes() {
        throw null;
    }

    public d0.e0.p.d.m0.c.z0 getTypeParameterDescriptor() {
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar != null) {
            return this;
        }
        a(5);
        throw null;
    }
}
