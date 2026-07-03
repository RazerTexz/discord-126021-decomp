package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.b */
/* JADX INFO: compiled from: AbstractClassTypeConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11909b extends AbstractC11924g implements InterfaceC12008u0 {

    /* JADX INFO: renamed from: b */
    public int f24742b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11909b(InterfaceC11905o interfaceC11905o) {
        super(interfaceC11905o);
        if (interfaceC11905o == null) {
            m9994g(0);
            throw null;
        }
        this.f24742b = 0;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    /* JADX INFO: renamed from: g */
    public static /* synthetic */ void m9994g(int i) {
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

    /* JADX INFO: renamed from: h */
    public static boolean m9995h(InterfaceC11352h interfaceC11352h) {
        if (interfaceC11352h != null) {
            return (C12005t.isError(interfaceC11352h) || C11787e.isLocal(interfaceC11352h)) ? false : true;
        }
        m9994g(2);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
    /* JADX INFO: renamed from: b */
    public AbstractC11913c0 mo9403b() {
        if (AbstractC11288h.isSpecialClassWithNoSupertypes(getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
    /* JADX INFO: renamed from: c */
    public Collection<AbstractC11913c0> mo9996c(boolean z2) {
        InterfaceC11450m containingDeclaration = getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof InterfaceC11330e)) {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m9994g(3);
            throw null;
        }
        C12041i c12041i = new C12041i();
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) containingDeclaration;
        c12041i.add(interfaceC11330e.getDefaultType());
        InterfaceC11330e companionObjectDescriptor = interfaceC11330e.getCompanionObjectDescriptor();
        if (z2 && companionObjectDescriptor != null) {
            c12041i.add(companionObjectDescriptor.getDefaultType());
        }
        return c12041i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC12008u0) || obj.hashCode() != hashCode()) {
            return false;
        }
        InterfaceC12008u0 interfaceC12008u0 = (InterfaceC12008u0) obj;
        if (interfaceC12008u0.getParameters().size() != getParameters().size()) {
            return false;
        }
        InterfaceC11330e declarationDescriptor = getDeclarationDescriptor();
        InterfaceC11352h declarationDescriptor2 = interfaceC12008u0.getDeclarationDescriptor();
        if (!m9995h(declarationDescriptor) || ((declarationDescriptor2 != null && !m9995h(declarationDescriptor2)) || !(declarationDescriptor2 instanceof InterfaceC11330e))) {
            return false;
        }
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) declarationDescriptor2;
        if (declarationDescriptor.getName().equals(interfaceC11330e.getName())) {
            InterfaceC11450m containingDeclaration = declarationDescriptor.getContainingDeclaration();
            for (InterfaceC11450m containingDeclaration2 = interfaceC11330e.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
                if (containingDeclaration instanceof InterfaceC11325c0) {
                    return containingDeclaration2 instanceof InterfaceC11325c0;
                }
                if (!(containingDeclaration2 instanceof InterfaceC11325c0)) {
                    if (containingDeclaration instanceof InterfaceC11331e0) {
                        if ((containingDeclaration2 instanceof InterfaceC11331e0) && ((InterfaceC11331e0) containingDeclaration).getFqName().equals(((InterfaceC11331e0) containingDeclaration2).getFqName())) {
                            return true;
                        }
                    } else if (!(containingDeclaration2 instanceof InterfaceC11331e0) && containingDeclaration.getName().equals(containingDeclaration2.getName())) {
                        containingDeclaration = containingDeclaration.getContainingDeclaration();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public AbstractC11288h getBuiltIns() {
        AbstractC11288h builtIns = C11836a.getBuiltIns(getDeclarationDescriptor());
        if (builtIns != null) {
            return builtIns;
        }
        m9994g(1);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g, p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public abstract InterfaceC11330e getDeclarationDescriptor();

    public final int hashCode() {
        int i = this.f24742b;
        if (i != 0) {
            return i;
        }
        InterfaceC11330e declarationDescriptor = getDeclarationDescriptor();
        int iHashCode = m9995h(declarationDescriptor) ? C11787e.getFqName(declarationDescriptor).hashCode() : System.identityHashCode(this);
        this.f24742b = iHashCode;
        return iHashCode;
    }
}
