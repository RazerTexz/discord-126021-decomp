package d0.e0.p.d.m0.e.a.h0;

import d0.e0.p.d.m0.c.a$a;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: JavaClassConstructorDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends d0.e0.p.d.m0.c.i1.g implements b {
    public Boolean O;
    public Boolean P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d0.e0.p.d.m0.c.e eVar, c cVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, b$a b_a, u0 u0Var) {
        super(eVar, cVar, gVar, z2, b_a, u0Var);
        if (eVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (b_a == null) {
            a(2);
            throw null;
        }
        if (u0Var == null) {
            a(3);
            throw null;
        }
        this.O = null;
        this.P = null;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static c createJavaConstructor(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, u0 u0Var) {
        if (eVar == null) {
            a(4);
            throw null;
        }
        if (gVar == null) {
            a(5);
            throw null;
        }
        if (u0Var != null) {
            return new c(eVar, null, gVar, z2, b$a.DECLARATION, u0Var);
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.g, d0.e0.p.d.m0.c.i1.q
    public /* bridge */ /* synthetic */ q b(m mVar, x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        return f(mVar, xVar, b_a, eVar, gVar, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.i1.g e(m mVar, x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        return f(mVar, xVar, b_a, eVar, gVar, u0Var);
    }

    @Override // d0.e0.p.d.m0.e.a.h0.b
    public /* bridge */ /* synthetic */ b enhance(c0 c0Var, List list, c0 c0Var2, Pair pair) {
        return enhance(c0Var, (List<l>) list, c0Var2, (Pair<a$a<?>, ?>) pair);
    }

    public c f(m mVar, x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        if (mVar == null) {
            a(7);
            throw null;
        }
        if (b_a == null) {
            a(8);
            throw null;
        }
        if (gVar == null) {
            a(9);
            throw null;
        }
        if (u0Var == null) {
            a(10);
            throw null;
        }
        if (b_a != b$a.DECLARATION && b_a != b$a.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + b_a);
        }
        d0.e0.p.d.m0.c.e eVar2 = (d0.e0.p.d.m0.c.e) mVar;
        c cVar = (c) xVar;
        if (eVar2 == null) {
            a(12);
            throw null;
        }
        if (b_a == null) {
            a(13);
            throw null;
        }
        if (u0Var == null) {
            a(14);
            throw null;
        }
        if (gVar == null) {
            a(15);
            throw null;
        }
        c cVar2 = new c(eVar2, cVar, gVar, this.N, b_a, u0Var);
        cVar2.setHasStableParameterNames(hasStableParameterNames());
        cVar2.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
        return cVar2;
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public boolean hasStableParameterNames() {
        return this.O.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.a
    public boolean hasSynthesizedParameterNames() {
        return this.P.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public void setHasStableParameterNames(boolean z2) {
        this.O = Boolean.valueOf(z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public void setHasSynthesizedParameterNames(boolean z2) {
        this.P = Boolean.valueOf(z2);
    }

    @Override // d0.e0.p.d.m0.e.a.h0.b
    public c enhance(c0 c0Var, List<l> list, c0 c0Var2, Pair<a$a<?>, ?> pair) {
        if (list == null) {
            a(16);
            throw null;
        }
        if (c0Var2 == null) {
            a(17);
            throw null;
        }
        c cVarF = f(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        cVarF.initialize(c0Var != null ? d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(cVarF, c0Var, d0.e0.p.d.m0.c.g1.g.f.getEMPTY()) : null, getDispatchReceiverParameter(), getTypeParameters(), k.copyValueParameters(list, getValueParameters(), cVarF), c0Var2, getModality(), getVisibility());
        if (pair != null) {
            cVarF.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        return cVarF;
    }
}
