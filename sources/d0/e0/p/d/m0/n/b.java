package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AbstractClassTypeConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends g implements u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3519b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d0.e0.p.d.m0.m.o oVar) {
        super(oVar);
        if (oVar == null) {
            g(0);
            throw null;
        }
        this.f3519b = 0;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public static /* synthetic */ void g(int i) {
        String str = (i == 1 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else if (i == 2) {
            objArr[0] = "descriptor";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 1) {
            objArr[1] = "getBuiltIns";
        } else if (i == 3 || i == 4) {
            objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        }
        if (i != 1) {
            if (i == 2) {
                objArr[2] = "hasMeaningfulFqName";
            } else if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean h(d0.e0.p.d.m0.c.h hVar) {
        if (hVar != null) {
            return (t.isError(hVar) || d0.e0.p.d.m0.k.e.isLocal(hVar)) ? false : true;
        }
        g(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.g
    public c0 b() {
        if (d0.e0.p.d.m0.b.h.isSpecialClassWithNoSupertypes(getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }

    @Override // d0.e0.p.d.m0.n.g
    public Collection<c0> c(boolean z2) {
        d0.e0.p.d.m0.c.m containingDeclaration = getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof d0.e0.p.d.m0.c.e)) {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            g(3);
            throw null;
        }
        d0.e0.p.d.m0.p.i iVar = new d0.e0.p.d.m0.p.i();
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) containingDeclaration;
        iVar.add(eVar.getDefaultType());
        d0.e0.p.d.m0.c.e companionObjectDescriptor = eVar.getCompanionObjectDescriptor();
        if (z2 && companionObjectDescriptor != null) {
            iVar.add(companionObjectDescriptor.getDefaultType());
        }
        return iVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0) || obj.hashCode() != hashCode()) {
            return false;
        }
        u0 u0Var = (u0) obj;
        if (u0Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        d0.e0.p.d.m0.c.e declarationDescriptor = getDeclarationDescriptor();
        d0.e0.p.d.m0.c.h declarationDescriptor2 = u0Var.getDeclarationDescriptor();
        if (!h(declarationDescriptor) || ((declarationDescriptor2 != null && !h(declarationDescriptor2)) || !(declarationDescriptor2 instanceof d0.e0.p.d.m0.c.e))) {
            return false;
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) declarationDescriptor2;
        if (declarationDescriptor.getName().equals(eVar.getName())) {
            d0.e0.p.d.m0.c.m containingDeclaration = declarationDescriptor.getContainingDeclaration();
            for (d0.e0.p.d.m0.c.m containingDeclaration2 = eVar.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
                if (containingDeclaration instanceof d0.e0.p.d.m0.c.c0) {
                    return containingDeclaration2 instanceof d0.e0.p.d.m0.c.c0;
                }
                if (!(containingDeclaration2 instanceof d0.e0.p.d.m0.c.c0)) {
                    if (containingDeclaration instanceof d0.e0.p.d.m0.c.e0) {
                        if ((containingDeclaration2 instanceof d0.e0.p.d.m0.c.e0) && ((d0.e0.p.d.m0.c.e0) containingDeclaration).getFqName().equals(((d0.e0.p.d.m0.c.e0) containingDeclaration2).getFqName())) {
                            return true;
                        }
                    } else if (!(containingDeclaration2 instanceof d0.e0.p.d.m0.c.e0) && containingDeclaration.getName().equals(containingDeclaration2.getName())) {
                        containingDeclaration = containingDeclaration.getContainingDeclaration();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        d0.e0.p.d.m0.b.h builtIns = d0.e0.p.d.m0.k.x.a.getBuiltIns(getDeclarationDescriptor());
        if (builtIns != null) {
            return builtIns;
        }
        g(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public abstract d0.e0.p.d.m0.c.e getDeclarationDescriptor();

    public final int hashCode() {
        int i = this.f3519b;
        if (i != 0) {
            return i;
        }
        d0.e0.p.d.m0.c.e declarationDescriptor = getDeclarationDescriptor();
        int iHashCode = h(declarationDescriptor) ? d0.e0.p.d.m0.k.e.getFqName(declarationDescriptor).hashCode() : System.identityHashCode(this);
        this.f3519b = iHashCode;
        return iHashCode;
    }
}
