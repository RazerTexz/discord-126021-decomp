package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.g */
/* JADX INFO: compiled from: ClassConstructorDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11373g extends AbstractC11391q implements InterfaceC11327d {

    /* JADX INFO: renamed from: M */
    public static final C11716e f22873M = C11716e.special("<init>");

    /* JADX INFO: renamed from: N */
    public final boolean f22874N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11373g(InterfaceC11330e interfaceC11330e, InterfaceC11448l interfaceC11448l, InterfaceC11344g interfaceC11344g, boolean z2, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11330e, interfaceC11448l, interfaceC11344g, f22873M, aVar, interfaceC11467u0);
        if (interfaceC11330e == null) {
            m9407a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9407a(1);
            throw null;
        }
        if (aVar == null) {
            m9407a(2);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9407a(3);
            throw null;
        }
        this.f22874N = z2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a  */
    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9407a(int i) {
        String str;
        int i2;
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 23:
                objArr[0] = "annotations";
                break;
            case 2:
            case 22:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 24:
                objArr[0] = "source";
                break;
            case 4:
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 18:
                objArr[0] = "originalSubstitutor";
                break;
            case 20:
                objArr[0] = "overriddenDescriptors";
                break;
            case 21:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 19) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 25) {
            switch (i) {
                case 15:
                    objArr[1] = "getContainingDeclaration";
                    break;
                case 16:
                    objArr[1] = "getConstructedClass";
                    break;
                case 17:
                    objArr[1] = "getOriginal";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            case 20:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static C11373g create(InterfaceC11330e interfaceC11330e, InterfaceC11344g interfaceC11344g, boolean z2, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11330e == null) {
            m9407a(4);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9407a(5);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return new C11373g(interfaceC11330e, null, interfaceC11344g, z2, InterfaceC11321b.a.DECLARATION, interfaceC11467u0);
        }
        m9407a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return interfaceC11454o.visitConstructorDescriptor(this, d);
    }

    public InterfaceC11459q0 calculateDispatchReceiverParameter() {
        InterfaceC11330e containingDeclaration = getContainingDeclaration();
        if (!containingDeclaration.isInner()) {
            return null;
        }
        InterfaceC11450m containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if (containingDeclaration2 instanceof InterfaceC11330e) {
            return ((InterfaceC11330e) containingDeclaration2).getThisAsReceiverParameter();
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public C11373g mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11450m == null) {
            m9407a(21);
            throw null;
        }
        if (aVar == null) {
            m9407a(22);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9407a(23);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9407a(24);
            throw null;
        }
        InterfaceC11321b.a aVar2 = InterfaceC11321b.a.DECLARATION;
        if (aVar == aVar2 || aVar == InterfaceC11321b.a.SYNTHESIZED) {
            return new C11373g((InterfaceC11330e) interfaceC11450m, this, interfaceC11344g, this.f22874N, aVar2, interfaceC11467u0);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + interfaceC11450m + "\nkind: " + aVar);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l
    public InterfaceC11330e getConstructedClass() {
        InterfaceC11330e containingDeclaration = getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        m9407a(16);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public Collection<? extends InterfaceC11472x> getOverriddenDescriptors() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        m9407a(19);
        throw null;
    }

    public C11373g initialize(List<InterfaceC11326c1> list, AbstractC11466u abstractC11466u, List<InterfaceC11477z0> list2) {
        if (list == null) {
            m9407a(10);
            throw null;
        }
        if (abstractC11466u == null) {
            m9407a(11);
            throw null;
        }
        if (list2 != null) {
            initialize(null, calculateDispatchReceiverParameter(), list2, list, null, EnumC11476z.FINAL, abstractC11466u);
            return this;
        }
        m9407a(12);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l
    public boolean isPrimary() {
        return this.f22874N;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public void setOverriddenDescriptors(Collection<? extends InterfaceC11321b> collection) {
        if (collection != null) {
            return;
        }
        m9407a(20);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public InterfaceC11327d copy(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11321b.a aVar, boolean z2) {
        InterfaceC11327d interfaceC11327d = (InterfaceC11327d) super.copy(interfaceC11450m, enumC11476z, abstractC11466u, aVar, z2);
        if (interfaceC11327d != null) {
            return interfaceC11327d;
        }
        m9407a(25);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11330e getContainingDeclaration() {
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) super.getContainingDeclaration();
        if (interfaceC11330e != null) {
            return interfaceC11330e;
        }
        m9407a(15);
        throw null;
    }

    public C11373g initialize(List<InterfaceC11326c1> list, AbstractC11466u abstractC11466u) {
        if (list == null) {
            m9407a(13);
            throw null;
        }
        if (abstractC11466u != null) {
            initialize(list, abstractC11466u, getContainingDeclaration().getDeclaredTypeParameters());
            return this;
        }
        m9407a(14);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11327d substitute(C11914c1 c11914c1) {
        if (c11914c1 != null) {
            return (InterfaceC11327d) super.substitute(c11914c1);
        }
        m9407a(18);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11327d getOriginal() {
        InterfaceC11327d interfaceC11327d = (InterfaceC11327d) super.getOriginal();
        if (interfaceC11327d != null) {
            return interfaceC11327d;
        }
        m9407a(17);
        throw null;
    }
}
