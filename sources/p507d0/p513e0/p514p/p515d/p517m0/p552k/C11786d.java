package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collections;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11368d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11370e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11372f0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11373g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11384l0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.C11778b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.d */
/* JADX INFO: compiled from: DescriptorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11786d {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.d$a */
    /* JADX INFO: compiled from: DescriptorFactory.java */
    public static class a extends C11373g {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC11330e interfaceC11330e, InterfaceC11467u0 interfaceC11467u0, boolean z2) {
            super(interfaceC11330e, null, InterfaceC11344g.f22735f.getEMPTY(), true, InterfaceC11321b.a.DECLARATION, interfaceC11467u0);
            if (interfaceC11330e == null) {
                m9922a(0);
                throw null;
            }
            if (interfaceC11467u0 == null) {
                m9922a(1);
                throw null;
            }
            initialize(Collections.emptyList(), C11787e.getDefaultConstructorVisibility(interfaceC11330e, z2));
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9922a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9920a(int i) {
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

    /* JADX INFO: renamed from: b */
    public static boolean m9921b(InterfaceC11472x interfaceC11472x) {
        return interfaceC11472x.getKind() == InterfaceC11321b.a.SYNTHESIZED && C11787e.isEnumClass(interfaceC11472x.getContainingDeclaration());
    }

    public static C11368d0 createDefaultGetter(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g) {
        if (interfaceC11453n0 == null) {
            m9920a(13);
            throw null;
        }
        if (interfaceC11344g != null) {
            return createGetter(interfaceC11453n0, interfaceC11344g, true, false, false);
        }
        m9920a(14);
        throw null;
    }

    public static C11370e0 createDefaultSetter(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, InterfaceC11344g interfaceC11344g2) {
        if (interfaceC11453n0 == null) {
            m9920a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9920a(1);
            throw null;
        }
        if (interfaceC11344g2 != null) {
            return createSetter(interfaceC11453n0, interfaceC11344g, interfaceC11344g2, true, false, false, interfaceC11453n0.getSource());
        }
        m9920a(2);
        throw null;
    }

    public static InterfaceC11465t0 createEnumValueOfMethod(InterfaceC11330e interfaceC11330e) {
        if (interfaceC11330e == null) {
            m9920a(24);
            throw null;
        }
        InterfaceC11344g.a aVar = InterfaceC11344g.f22735f;
        C11374g0 c11374g0Create = C11374g0.create(interfaceC11330e, aVar.getEMPTY(), C11291k.f22490c, InterfaceC11321b.a.SYNTHESIZED, interfaceC11330e.getSource());
        C11374g0 c11374g0Initialize = c11374g0Create.initialize((InterfaceC11459q0) null, (InterfaceC11459q0) null, Collections.emptyList(), Collections.singletonList(new C11384l0(c11374g0Create, null, 0, aVar.getEMPTY(), C11716e.identifier("value"), C11836a.getBuiltIns(interfaceC11330e).getStringType(), false, false, false, null, interfaceC11330e.getSource())), (AbstractC11913c0) interfaceC11330e.getDefaultType(), EnumC11476z.FINAL, C11464t.f23087e);
        if (c11374g0Initialize != null) {
            return c11374g0Initialize;
        }
        m9920a(25);
        throw null;
    }

    public static InterfaceC11465t0 createEnumValuesMethod(InterfaceC11330e interfaceC11330e) {
        if (interfaceC11330e == null) {
            m9920a(22);
            throw null;
        }
        C11374g0 c11374g0Initialize = C11374g0.create(interfaceC11330e, InterfaceC11344g.f22735f.getEMPTY(), C11291k.f22489b, InterfaceC11321b.a.SYNTHESIZED, interfaceC11330e.getSource()).initialize((InterfaceC11459q0) null, (InterfaceC11459q0) null, Collections.emptyList(), Collections.emptyList(), (AbstractC11913c0) C11836a.getBuiltIns(interfaceC11330e).getArrayType(EnumC11935j1.INVARIANT, interfaceC11330e.getDefaultType()), EnumC11476z.FINAL, C11464t.f23087e);
        if (c11374g0Initialize != null) {
            return c11374g0Initialize;
        }
        m9920a(23);
        throw null;
    }

    public static InterfaceC11459q0 createExtensionReceiverParameterForCallable(InterfaceC11318a interfaceC11318a, AbstractC11913c0 abstractC11913c0, InterfaceC11344g interfaceC11344g) {
        if (interfaceC11318a == null) {
            m9920a(29);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9920a(30);
            throw null;
        }
        if (abstractC11913c0 == null) {
            return null;
        }
        return new C11372f0(interfaceC11318a, new C11778b(interfaceC11318a, abstractC11913c0, null), interfaceC11344g);
    }

    public static C11368d0 createGetter(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, boolean z2, boolean z3, boolean z4) {
        if (interfaceC11453n0 == null) {
            m9920a(15);
            throw null;
        }
        if (interfaceC11344g != null) {
            return createGetter(interfaceC11453n0, interfaceC11344g, z2, z3, z4, interfaceC11453n0.getSource());
        }
        m9920a(16);
        throw null;
    }

    public static C11373g createPrimaryConstructorForObject(InterfaceC11330e interfaceC11330e, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11330e == null) {
            m9920a(20);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return new a(interfaceC11330e, interfaceC11467u0, false);
        }
        m9920a(21);
        throw null;
    }

    public static C11370e0 createSetter(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, InterfaceC11344g interfaceC11344g2, boolean z2, boolean z3, boolean z4, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11453n0 == null) {
            m9920a(3);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9920a(4);
            throw null;
        }
        if (interfaceC11344g2 == null) {
            m9920a(5);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return createSetter(interfaceC11453n0, interfaceC11344g, interfaceC11344g2, z2, z3, z4, interfaceC11453n0.getVisibility(), interfaceC11467u0);
        }
        m9920a(6);
        throw null;
    }

    public static boolean isEnumValueOfMethod(InterfaceC11472x interfaceC11472x) {
        if (interfaceC11472x != null) {
            return interfaceC11472x.getName().equals(C11291k.f22490c) && m9921b(interfaceC11472x);
        }
        m9920a(27);
        throw null;
    }

    public static boolean isEnumValuesMethod(InterfaceC11472x interfaceC11472x) {
        if (interfaceC11472x != null) {
            return interfaceC11472x.getName().equals(C11291k.f22489b) && m9921b(interfaceC11472x);
        }
        m9920a(26);
        throw null;
    }

    public static C11368d0 createGetter(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, boolean z2, boolean z3, boolean z4, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11453n0 == null) {
            m9920a(17);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9920a(18);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return new C11368d0(interfaceC11453n0, interfaceC11344g, interfaceC11453n0.getModality(), interfaceC11453n0.getVisibility(), z2, z3, z4, InterfaceC11321b.a.DECLARATION, null, interfaceC11467u0);
        }
        m9920a(19);
        throw null;
    }

    public static C11370e0 createSetter(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, InterfaceC11344g interfaceC11344g2, boolean z2, boolean z3, boolean z4, AbstractC11466u abstractC11466u, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11453n0 == null) {
            m9920a(7);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9920a(8);
            throw null;
        }
        if (interfaceC11344g2 == null) {
            m9920a(9);
            throw null;
        }
        if (abstractC11466u == null) {
            m9920a(10);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            C11370e0 c11370e0 = new C11370e0(interfaceC11453n0, interfaceC11344g, interfaceC11453n0.getModality(), abstractC11466u, z2, z3, z4, InterfaceC11321b.a.DECLARATION, null, interfaceC11467u0);
            c11370e0.initialize(C11370e0.createSetterParameter(c11370e0, interfaceC11453n0.getType(), interfaceC11344g2));
            return c11370e0;
        }
        m9920a(11);
        throw null;
    }
}
