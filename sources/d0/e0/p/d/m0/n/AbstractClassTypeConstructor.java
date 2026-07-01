package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.p.SmartList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractClassTypeConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor implements TypeConstructor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3519b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClassTypeConstructor(StorageManager storageManager) {
        super(storageManager);
        if (storageManager == null) {
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

    public static boolean h(ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor != null) {
            return (ErrorUtils.isError(classifierDescriptor) || DescriptorUtils.isLocal(classifierDescriptor)) ? false : true;
        }
        g(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
    public KotlinType b() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
    public Collection<KotlinType> c(boolean z2) {
        DeclarationDescriptor containingDeclaration = getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            g(3);
            throw null;
        }
        SmartList smartList = new SmartList();
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        smartList.add(classDescriptor.getDefaultType());
        ClassDescriptor companionObjectDescriptor = classDescriptor.getCompanionObjectDescriptor();
        if (z2 && companionObjectDescriptor != null) {
            smartList.add(companionObjectDescriptor.getDefaultType());
        }
        return smartList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        if (typeConstructor.getParameters().size() != getParameters().size()) {
            return false;
        }
        ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
        if (!h(declarationDescriptor) || ((declarationDescriptor2 != null && !h(declarationDescriptor2)) || !(declarationDescriptor2 instanceof ClassDescriptor))) {
            return false;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor2;
        if (declarationDescriptor.getName().equals(classDescriptor.getName())) {
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            for (DeclarationDescriptor containingDeclaration2 = classDescriptor.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
                if (containingDeclaration instanceof ModuleDescriptor2) {
                    return containingDeclaration2 instanceof ModuleDescriptor2;
                }
                if (!(containingDeclaration2 instanceof ModuleDescriptor2)) {
                    if (containingDeclaration instanceof PackageFragmentDescriptor) {
                        if ((containingDeclaration2 instanceof PackageFragmentDescriptor) && ((PackageFragmentDescriptor) containingDeclaration).getFqName().equals(((PackageFragmentDescriptor) containingDeclaration2).getFqName())) {
                            return true;
                        }
                    } else if (!(containingDeclaration2 instanceof PackageFragmentDescriptor) && containingDeclaration.getName().equals(containingDeclaration2.getName())) {
                        containingDeclaration = containingDeclaration.getContainingDeclaration();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = DescriptorUtils2.getBuiltIns(getDeclarationDescriptor());
        if (builtIns != null) {
            return builtIns;
        }
        g(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor, d0.e0.p.d.m0.n.TypeConstructor
    public abstract ClassDescriptor getDeclarationDescriptor();

    public final int hashCode() {
        int i = this.f3519b;
        if (i != 0) {
            return i;
        }
        ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
        int iHashCode = h(declarationDescriptor) ? DescriptorUtils.getFqName(declarationDescriptor).hashCode() : System.identityHashCode(this);
        this.f3519b = iHashCode;
        return iHashCode;
    }
}
