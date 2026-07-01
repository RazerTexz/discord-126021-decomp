package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.c.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$c extends d0.e0.p.d.m0.n.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x0 f3265b;
    public final /* synthetic */ f c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c(f fVar, d0.e0.p.d.m0.m.o oVar, x0 x0Var) {
        super(oVar);
        if (oVar == null) {
            g(0);
            throw null;
        }
        this.c = fVar;
        this.f3265b = x0Var;
    }

    public static /* synthetic */ void g(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                break;
            case 6:
                objArr[0] = "type";
                break;
            case 7:
                objArr[0] = "supertypes";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 1) {
            objArr[1] = "computeSupertypes";
        } else if (i == 2) {
            objArr[1] = "getParameters";
        } else if (i == 3) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 4) {
            objArr[1] = "getBuiltIns";
        } else if (i == 5) {
            objArr[1] = "getSupertypeLoopChecker";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        } else {
            objArr[1] = "processSupertypesWithoutCycles";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                break;
            case 6:
                objArr[2] = "reportSupertypeLoopError";
                break;
            case 7:
                objArr[2] = "processSupertypesWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.n.g
    public Collection<d0.e0.p.d.m0.n.c0> a() {
        List<d0.e0.p.d.m0.n.c0> listD = this.c.d();
        if (listD != null) {
            return listD;
        }
        g(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.g
    public d0.e0.p.d.m0.n.c0 b() {
        return d0.e0.p.d.m0.n.t.createErrorType("Cyclic upper bounds");
    }

    @Override // d0.e0.p.d.m0.n.g
    public x0 d() {
        x0 x0Var = this.f3265b;
        if (x0Var != null) {
            return x0Var;
        }
        g(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.g
    public List<d0.e0.p.d.m0.n.c0> e(List<d0.e0.p.d.m0.n.c0> list) {
        if (list == null) {
            g(7);
            throw null;
        }
        List<d0.e0.p.d.m0.n.c0> listB = this.c.b(list);
        if (listB != null) {
            return listB;
        }
        g(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.g
    public void f(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var != null) {
            this.c.c(c0Var);
        } else {
            g(6);
            throw null;
        }
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        d0.e0.p.d.m0.b.h builtIns = d0.e0.p.d.m0.k.x.a.getBuiltIns(this.c);
        if (builtIns != null) {
            return builtIns;
        }
        g(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        f fVar = this.c;
        if (fVar != null) {
            return fVar;
        }
        g(3);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        List<z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        g(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return this.c.getName().toString();
    }
}
