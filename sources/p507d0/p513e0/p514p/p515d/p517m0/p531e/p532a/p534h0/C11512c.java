package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import java.util.List;
import kotlin.Pair;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11373g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.c */
/* JADX INFO: compiled from: JavaClassConstructorDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11512c extends C11373g implements InterfaceC11511b {

    /* JADX INFO: renamed from: O */
    public Boolean f23260O;

    /* JADX INFO: renamed from: P */
    public Boolean f23261P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11512c(InterfaceC11330e interfaceC11330e, C11512c c11512c, InterfaceC11344g interfaceC11344g, boolean z2, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11330e, c11512c, interfaceC11344g, z2, aVar, interfaceC11467u0);
        if (interfaceC11330e == null) {
            m9456a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9456a(1);
            throw null;
        }
        if (aVar == null) {
            m9456a(2);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9456a(3);
            throw null;
        }
        this.f23260O = null;
        this.f23261P = null;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9456a(int i) {
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

    public static C11512c createJavaConstructor(InterfaceC11330e interfaceC11330e, InterfaceC11344g interfaceC11344g, boolean z2, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11330e == null) {
            m9456a(4);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9456a(5);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return new C11512c(interfaceC11330e, null, interfaceC11344g, z2, InterfaceC11321b.a.DECLARATION, interfaceC11467u0);
        }
        m9456a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11511b
    public /* bridge */ /* synthetic */ InterfaceC11511b enhance(AbstractC11913c0 abstractC11913c0, List list, AbstractC11913c0 abstractC11913c1, Pair pair) {
        return enhance(abstractC11913c0, (List<C11521l>) list, abstractC11913c1, (Pair<InterfaceC11318a.a<?>, ?>) pair);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11373g
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public C11512c mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11450m == null) {
            m9456a(7);
            throw null;
        }
        if (aVar == null) {
            m9456a(8);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9456a(9);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9456a(10);
            throw null;
        }
        if (aVar != InterfaceC11321b.a.DECLARATION && aVar != InterfaceC11321b.a.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + interfaceC11450m + "\nkind: " + aVar);
        }
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) interfaceC11450m;
        C11512c c11512c = (C11512c) interfaceC11472x;
        if (interfaceC11330e == null) {
            m9456a(12);
            throw null;
        }
        if (aVar == null) {
            m9456a(13);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9456a(14);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9456a(15);
            throw null;
        }
        C11512c c11512c2 = new C11512c(interfaceC11330e, c11512c, interfaceC11344g, this.f22874N, aVar, interfaceC11467u0);
        c11512c2.setHasStableParameterNames(hasStableParameterNames());
        c11512c2.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
        return c11512c2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    public boolean hasStableParameterNames() {
        return this.f23260O.booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public boolean hasSynthesizedParameterNames() {
        return this.f23261P.booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    public void setHasStableParameterNames(boolean z2) {
        this.f23260O = Boolean.valueOf(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    public void setHasSynthesizedParameterNames(boolean z2) {
        this.f23261P = Boolean.valueOf(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11511b
    public C11512c enhance(AbstractC11913c0 abstractC11913c0, List<C11521l> list, AbstractC11913c0 abstractC11913c1, Pair<InterfaceC11318a.a<?>, ?> pair) {
        if (list == null) {
            m9456a(16);
            throw null;
        }
        if (abstractC11913c1 == null) {
            m9456a(17);
            throw null;
        }
        C11512c c11512cMo9373b = mo9373b(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        c11512cMo9373b.initialize(abstractC11913c0 != null ? C11786d.createExtensionReceiverParameterForCallable(c11512cMo9373b, abstractC11913c0, InterfaceC11344g.f22735f.getEMPTY()) : null, getDispatchReceiverParameter(), getTypeParameters(), C11520k.copyValueParameters(list, getValueParameters(), c11512cMo9373b), abstractC11913c1, getModality(), getVisibility());
        if (pair != null) {
            c11512cMo9373b.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        return c11512cMo9373b;
    }
}
