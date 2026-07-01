package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.m.StorageManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.i, reason: use source file name */
/* JADX INFO: compiled from: ClassTypeConstructorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassTypeConstructorImpl extends AbstractClassTypeConstructor implements TypeConstructor {
    public final ClassDescriptor c;
    public final List<TypeParameterDescriptor> d;
    public final Collection<KotlinType> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassTypeConstructorImpl(ClassDescriptor classDescriptor, List<? extends TypeParameterDescriptor> list, Collection<KotlinType> collection, StorageManager storageManager) {
        super(storageManager);
        if (classDescriptor == null) {
            g(0);
            throw null;
        }
        if (list == null) {
            g(1);
            throw null;
        }
        if (collection == null) {
            g(2);
            throw null;
        }
        if (storageManager == null) {
            g(3);
            throw null;
        }
        this.c = classDescriptor;
        this.d = Collections.unmodifiableList(new ArrayList(list));
        this.e = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void g(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
    public Collection<KotlinType> a() {
        Collection<KotlinType> collection = this.e;
        if (collection != null) {
            return collection;
        }
        g(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
    public SupertypeLoopChecker d() {
        return SupertypeLoopChecker.a.a;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = this.d;
        if (list != null) {
            return list;
        }
        g(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return DescriptorUtils.getFqName(this.c).asString();
    }

    @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor, d0.e0.p.d.m0.n.TypeConstructor
    public ClassDescriptor getDeclarationDescriptor() {
        ClassDescriptor classDescriptor = this.c;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        g(5);
        throw null;
    }
}
