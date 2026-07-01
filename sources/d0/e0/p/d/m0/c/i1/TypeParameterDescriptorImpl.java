package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.Variance;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.k0, reason: use source file name */
/* JADX INFO: compiled from: TypeParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {
    public final Function1<KotlinType, Void> t;
    public final List<KotlinType> u;
    public boolean v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, SourceElement sourceElement, Function1<KotlinType, Void> function1, SupertypeLoopChecker supertypeLoopChecker, StorageManager storageManager) {
        super(storageManager, declarationDescriptor, annotations4, name, variance, z2, i, sourceElement, supertypeLoopChecker);
        if (declarationDescriptor == null) {
            a(19);
            throw null;
        }
        if (annotations4 == null) {
            a(20);
            throw null;
        }
        if (variance == null) {
            a(21);
            throw null;
        }
        if (name == null) {
            a(22);
            throw null;
        }
        if (sourceElement == null) {
            a(23);
            throw null;
        }
        if (supertypeLoopChecker == null) {
            a(24);
            throw null;
        }
        if (storageManager == null) {
            a(25);
            throw null;
        }
        this.u = new ArrayList(1);
        this.v = false;
        this.t = function1;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, SourceElement sourceElement, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(6);
            throw null;
        }
        if (annotations4 == null) {
            a(7);
            throw null;
        }
        if (variance == null) {
            a(8);
            throw null;
        }
        if (name == null) {
            a(9);
            throw null;
        }
        if (sourceElement == null) {
            a(10);
            throw null;
        }
        if (storageManager != null) {
            return createForFurtherModification(declarationDescriptor, annotations4, z2, variance, name, i, sourceElement, null, SupertypeLoopChecker.a.a, storageManager);
        }
        a(11);
        throw null;
    }

    public static TypeParameterDescriptor createWithDefaultBound(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations4 == null) {
            a(1);
            throw null;
        }
        if (variance == null) {
            a(2);
            throw null;
        }
        if (name == null) {
            a(3);
            throw null;
        }
        if (storageManager == null) {
            a(4);
            throw null;
        }
        TypeParameterDescriptorImpl typeParameterDescriptorImplCreateForFurtherModification = createForFurtherModification(declarationDescriptor, annotations4, z2, variance, name, i, SourceElement.a, storageManager);
        typeParameterDescriptorImplCreateForFurtherModification.addUpperBound(DescriptorUtils2.getBuiltIns(declarationDescriptor).getDefaultBound());
        typeParameterDescriptorImplCreateForFurtherModification.setInitialized();
        return typeParameterDescriptorImplCreateForFurtherModification;
    }

    public void addUpperBound(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(26);
            throw null;
        }
        e();
        if (KotlinType2.isError(kotlinType)) {
            return;
        }
        this.u.add(kotlinType);
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractTypeParameterDescriptor
    public void c(KotlinType kotlinType) {
        if (kotlinType == null) {
            a(27);
            throw null;
        }
        Function1<KotlinType, Void> function1 = this.t;
        if (function1 == null) {
            return;
        }
        function1.invoke(kotlinType);
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractTypeParameterDescriptor
    public List<KotlinType> d() {
        if (!this.v) {
            StringBuilder sbU = outline.U("Type parameter descriptor is not initialized: ");
            sbU.append(f());
            throw new IllegalStateException(sbU.toString());
        }
        List<KotlinType> list = this.u;
        if (list != null) {
            return list;
        }
        a(28);
        throw null;
    }

    public final void e() {
        if (this.v) {
            StringBuilder sbU = outline.U("Type parameter descriptor is already initialized: ");
            sbU.append(f());
            throw new IllegalStateException(sbU.toString());
        }
    }

    public final String f() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    public void setInitialized() {
        e();
        this.v = true;
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, SourceElement sourceElement, Function1<KotlinType, Void> function1, SupertypeLoopChecker supertypeLoopChecker, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(12);
            throw null;
        }
        if (annotations4 == null) {
            a(13);
            throw null;
        }
        if (variance == null) {
            a(14);
            throw null;
        }
        if (name == null) {
            a(15);
            throw null;
        }
        if (sourceElement == null) {
            a(16);
            throw null;
        }
        if (supertypeLoopChecker == null) {
            a(17);
            throw null;
        }
        if (storageManager != null) {
            return new TypeParameterDescriptorImpl(declarationDescriptor, annotations4, z2, variance, name, i, sourceElement, function1, supertypeLoopChecker, storageManager);
        }
        a(18);
        throw null;
    }
}
