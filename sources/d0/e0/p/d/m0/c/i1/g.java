package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ClassConstructorDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends q implements d0.e0.p.d.m0.c.d {
    public static final d0.e0.p.d.m0.g.e M = d0.e0.p.d.m0.g.e.special("<init>");
    public final boolean N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.l lVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, b$a b_a, u0 u0Var) {
        super(eVar, lVar, gVar, M, b_a, u0Var);
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
        this.N = z2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a  */
    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    public static /* synthetic */ void a(int i) {
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

    public static g create(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, u0 u0Var) {
        if (eVar == null) {
            a(4);
            throw null;
        }
        if (gVar == null) {
            a(5);
            throw null;
        }
        if (u0Var != null) {
            return new g(eVar, null, gVar, z2, b$a.DECLARATION, u0Var);
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitConstructorDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public /* bridge */ /* synthetic */ q b(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        return e(mVar, xVar, b_a, eVar, gVar, u0Var);
    }

    public q0 calculateDispatchReceiverParameter() {
        d0.e0.p.d.m0.c.e containingDeclaration = getContainingDeclaration();
        if (!containingDeclaration.isInner()) {
            return null;
        }
        d0.e0.p.d.m0.c.m containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if (containingDeclaration2 instanceof d0.e0.p.d.m0.c.e) {
            return ((d0.e0.p.d.m0.c.e) containingDeclaration2).getThisAsReceiverParameter();
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    public g e(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        if (mVar == null) {
            a(21);
            throw null;
        }
        if (b_a == null) {
            a(22);
            throw null;
        }
        if (gVar == null) {
            a(23);
            throw null;
        }
        if (u0Var == null) {
            a(24);
            throw null;
        }
        b$a b_a2 = b$a.DECLARATION;
        if (b_a == b_a2 || b_a == b$a.SYNTHESIZED) {
            return new g((d0.e0.p.d.m0.c.e) mVar, this, gVar, this.N, b_a2, u0Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + b_a);
    }

    @Override // d0.e0.p.d.m0.c.l
    public d0.e0.p.d.m0.c.e getConstructedClass() {
        d0.e0.p.d.m0.c.e containingDeclaration = getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.i getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a
    public Collection<? extends d0.e0.p.d.m0.c.x> getOverriddenDescriptors() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(19);
        throw null;
    }

    public g initialize(List<c1> list, d0.e0.p.d.m0.c.u uVar, List<z0> list2) {
        if (list == null) {
            a(10);
            throw null;
        }
        if (uVar == null) {
            a(11);
            throw null;
        }
        if (list2 != null) {
            initialize(null, calculateDispatchReceiverParameter(), list2, list, null, d0.e0.p.d.m0.c.z.FINAL, uVar);
            return this;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.l
    public boolean isPrimary() {
        return this.N;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public void setOverriddenDescriptors(Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        if (collection != null) {
            return;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.l substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public d0.e0.p.d.m0.c.d copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        d0.e0.p.d.m0.c.d dVar = (d0.e0.p.d.m0.c.d) super.copy(mVar, zVar, uVar, b_a, z2);
        if (dVar != null) {
            return dVar;
        }
        a(25);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.e getContainingDeclaration() {
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) super.getContainingDeclaration();
        if (eVar != null) {
            return eVar;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    public g initialize(List<c1> list, d0.e0.p.d.m0.c.u uVar) {
        if (list == null) {
            a(13);
            throw null;
        }
        if (uVar != null) {
            initialize(list, uVar, getContainingDeclaration().getDeclaredTypeParameters());
            return this;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public d0.e0.p.d.m0.c.d substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        if (c1Var != null) {
            return (d0.e0.p.d.m0.c.d) super.substitute(c1Var);
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.d getOriginal() {
        d0.e0.p.d.m0.c.d dVar = (d0.e0.p.d.m0.c.d) super.getOriginal();
        if (dVar != null) {
            return dVar;
        }
        a(17);
        throw null;
    }
}
