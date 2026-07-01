package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.g1.g$a;
import d0.e0.p.d.m0.c.i1.d0;
import d0.e0.p.d.m0.c.i1.e0;
import d0.e0.p.d.m0.c.i1.f0;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j1;
import java.util.Collections;

/* JADX INFO: compiled from: DescriptorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 23 || i == 25) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 23 && i != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(x xVar) {
        return xVar.getKind() == d0.e0.p.d.m0.c.b$a.SYNTHESIZED && e.isEnumClass(xVar.getContainingDeclaration());
    }

    public static d0 createDefaultGetter(n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        if (n0Var == null) {
            a(13);
            throw null;
        }
        if (gVar != null) {
            return createGetter(n0Var, gVar, true, false, false);
        }
        a(14);
        throw null;
    }

    public static e0 createDefaultSetter(n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.g1.g gVar2) {
        if (n0Var == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (gVar2 != null) {
            return createSetter(n0Var, gVar, gVar2, true, false, false, n0Var.getSource());
        }
        a(2);
        throw null;
    }

    public static t0 createEnumValueOfMethod(d0.e0.p.d.m0.c.e eVar) {
        if (eVar == null) {
            a(24);
            throw null;
        }
        g$a g_a = d0.e0.p.d.m0.c.g1.g.f;
        g0 g0VarCreate = g0.create(eVar, g_a.getEMPTY(), d0.e0.p.d.m0.b.k.c, d0.e0.p.d.m0.c.b$a.SYNTHESIZED, eVar.getSource());
        g0 g0VarInitialize = g0VarCreate.initialize((q0) null, (q0) null, Collections.emptyList(), Collections.singletonList(new l0(g0VarCreate, null, 0, g_a.getEMPTY(), d0.e0.p.d.m0.g.e.identifier("value"), d0.e0.p.d.m0.k.x.a.getBuiltIns(eVar).getStringType(), false, false, false, null, eVar.getSource())), (c0) eVar.getDefaultType(), z.FINAL, d0.e0.p.d.m0.c.t.e);
        if (g0VarInitialize != null) {
            return g0VarInitialize;
        }
        a(25);
        throw null;
    }

    public static t0 createEnumValuesMethod(d0.e0.p.d.m0.c.e eVar) {
        if (eVar == null) {
            a(22);
            throw null;
        }
        g0 g0VarInitialize = g0.create(eVar, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), d0.e0.p.d.m0.b.k.f3215b, d0.e0.p.d.m0.c.b$a.SYNTHESIZED, eVar.getSource()).initialize((q0) null, (q0) null, Collections.emptyList(), Collections.emptyList(), (c0) d0.e0.p.d.m0.k.x.a.getBuiltIns(eVar).getArrayType(j1.INVARIANT, eVar.getDefaultType()), z.FINAL, d0.e0.p.d.m0.c.t.e);
        if (g0VarInitialize != null) {
            return g0VarInitialize;
        }
        a(23);
        throw null;
    }

    public static q0 createExtensionReceiverParameterForCallable(d0.e0.p.d.m0.c.a aVar, c0 c0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        if (aVar == null) {
            a(29);
            throw null;
        }
        if (gVar == null) {
            a(30);
            throw null;
        }
        if (c0Var == null) {
            return null;
        }
        return new f0(aVar, new d0.e0.p.d.m0.k.a0.p.b(aVar, c0Var, null), gVar);
    }

    public static d0 createGetter(n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, boolean z3, boolean z4) {
        if (n0Var == null) {
            a(15);
            throw null;
        }
        if (gVar != null) {
            return createGetter(n0Var, gVar, z2, z3, z4, n0Var.getSource());
        }
        a(16);
        throw null;
    }

    public static d0.e0.p.d.m0.c.i1.g createPrimaryConstructorForObject(d0.e0.p.d.m0.c.e eVar, u0 u0Var) {
        if (eVar == null) {
            a(20);
            throw null;
        }
        if (u0Var != null) {
            return new d$a(eVar, u0Var, false);
        }
        a(21);
        throw null;
    }

    public static e0 createSetter(n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.g1.g gVar2, boolean z2, boolean z3, boolean z4, u0 u0Var) {
        if (n0Var == null) {
            a(3);
            throw null;
        }
        if (gVar == null) {
            a(4);
            throw null;
        }
        if (gVar2 == null) {
            a(5);
            throw null;
        }
        if (u0Var != null) {
            return createSetter(n0Var, gVar, gVar2, z2, z3, z4, n0Var.getVisibility(), u0Var);
        }
        a(6);
        throw null;
    }

    public static boolean isEnumValueOfMethod(x xVar) {
        if (xVar != null) {
            return xVar.getName().equals(d0.e0.p.d.m0.b.k.c) && b(xVar);
        }
        a(27);
        throw null;
    }

    public static boolean isEnumValuesMethod(x xVar) {
        if (xVar != null) {
            return xVar.getName().equals(d0.e0.p.d.m0.b.k.f3215b) && b(xVar);
        }
        a(26);
        throw null;
    }

    public static d0 createGetter(n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, boolean z3, boolean z4, u0 u0Var) {
        if (n0Var == null) {
            a(17);
            throw null;
        }
        if (gVar == null) {
            a(18);
            throw null;
        }
        if (u0Var != null) {
            return new d0(n0Var, gVar, n0Var.getModality(), n0Var.getVisibility(), z2, z3, z4, d0.e0.p.d.m0.c.b$a.DECLARATION, null, u0Var);
        }
        a(19);
        throw null;
    }

    public static e0 createSetter(n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.g1.g gVar2, boolean z2, boolean z3, boolean z4, u uVar, u0 u0Var) {
        if (n0Var == null) {
            a(7);
            throw null;
        }
        if (gVar == null) {
            a(8);
            throw null;
        }
        if (gVar2 == null) {
            a(9);
            throw null;
        }
        if (uVar == null) {
            a(10);
            throw null;
        }
        if (u0Var != null) {
            e0 e0Var = new e0(n0Var, gVar, n0Var.getModality(), uVar, z2, z3, z4, d0.e0.p.d.m0.c.b$a.DECLARATION, null, u0Var);
            e0Var.initialize(e0.createSetterParameter(e0Var, n0Var.getType(), gVar2));
            return e0Var;
        }
        a(11);
        throw null;
    }
}
