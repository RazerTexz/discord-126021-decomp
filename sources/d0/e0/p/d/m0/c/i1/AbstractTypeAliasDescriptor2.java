package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.TypeAliasConstructorDescriptor2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor6;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTypeAliasDescriptor2 extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {
    public final DescriptorVisibility2 n;
    public List<? extends TypeParameterDescriptor> o;
    public final b p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e$a */
    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class a extends Lambda implements Function1<KotlinType3, Boolean> {
        public a() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x002d  */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(KotlinType3 kotlinType3) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(kotlinType3, "type");
            if (!KotlinType2.isError(kotlinType3)) {
                AbstractTypeAliasDescriptor2 abstractTypeAliasDescriptor2 = AbstractTypeAliasDescriptor2.this;
                ClassifierDescriptor declarationDescriptor = kotlinType3.getConstructor().getDeclarationDescriptor();
                z2 = (declarationDescriptor instanceof TypeParameterDescriptor) && !Intrinsics3.areEqual(((TypeParameterDescriptor) declarationDescriptor).getContainingDeclaration(), abstractTypeAliasDescriptor2);
            }
            return Boolean.valueOf(z2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e$b */
    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class b implements TypeConstructor {
        public b() {
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            return DescriptorUtils2.getBuiltIns(getDeclarationDescriptor());
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List list = ((DeserializedMemberDescriptor6) AbstractTypeAliasDescriptor2.this).f3498z;
            if (list != null) {
                return list;
            }
            Intrinsics3.throwUninitializedPropertyAccessException("typeConstructorParameters");
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public Collection<KotlinType> getSupertypes() {
            Collection<KotlinType> supertypes = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
            Intrinsics3.checkNotNullExpressionValue(supertypes, "declarationDescriptor.underlyingType.constructor.supertypes");
            return supertypes;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        public String toString() {
            StringBuilder sbU = outline.U("[typealias ");
            sbU.append(getDeclarationDescriptor().getName().asString());
            sbU.append(']');
            return sbU.toString();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public TypeAliasDescriptor getDeclarationDescriptor() {
            return AbstractTypeAliasDescriptor2.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor2(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, SourceElement sourceElement, DescriptorVisibility2 descriptorVisibility2) {
        super(declarationDescriptor, annotations4, name, sourceElement);
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(sourceElement, "sourceElement");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibilityImpl");
        this.n = descriptorVisibility2;
        this.p = new b();
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitTypeAliasDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List list = this.o;
        if (list != null) {
            return list;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        throw null;
    }

    public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        DeserializedMemberDescriptor6 deserializedMemberDescriptor6 = (DeserializedMemberDescriptor6) this;
        ClassDescriptor classDescriptor = deserializedMemberDescriptor6.getClassDescriptor();
        if (classDescriptor == null) {
            return Collections2.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        Intrinsics3.checkNotNullExpressionValue(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            TypeAliasConstructorDescriptor2.a aVar = TypeAliasConstructorDescriptor2.M;
            StorageManager storageManager = deserializedMemberDescriptor6.q;
            Intrinsics3.checkNotNullExpressionValue(classConstructorDescriptor, "it");
            TypeAliasConstructorDescriptor typeAliasConstructorDescriptorCreateIfAvailable = aVar.createIfAvailable(storageManager, this, classConstructorDescriptor);
            if (typeAliasConstructorDescriptorCreateIfAvailable != null) {
                arrayList.add(typeAliasConstructorDescriptorCreateIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        return this.n;
    }

    public final void initialize(List<? extends TypeParameterDescriptor> list) {
        Intrinsics3.checkNotNullParameter(list, "declaredTypeParameters");
        this.o = list;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return TypeUtils.contains(((DeserializedMemberDescriptor6) this).getUnderlyingType(), new a());
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl
    public String toString() {
        return Intrinsics3.stringPlus("typealias ", getName().asString());
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public TypeAliasDescriptor getOriginal() {
        return (TypeAliasDescriptor) super.getOriginal();
    }
}
