package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.SpecialTypes5;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0, reason: use source file name */
/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeAliasConstructorDescriptor2 extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    public static final a M = new a(null);
    public static final /* synthetic */ KProperty<Object>[] N = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(TypeAliasConstructorDescriptor2.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    public final StorageManager O;
    public final TypeAliasDescriptor P;
    public ClassConstructorDescriptor Q;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0$a */
    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final TypeSubstitutor2 access$getTypeSubstitutorForUnderlyingClass(a aVar, TypeAliasDescriptor typeAliasDescriptor) {
            Objects.requireNonNull(aVar);
            if (typeAliasDescriptor.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor2.create(typeAliasDescriptor.getExpandedType());
        }

        public final TypeAliasConstructorDescriptor createIfAvailable(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor) {
            ClassConstructorDescriptor classConstructorDescriptorSubstitute;
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics3.checkNotNullParameter(classConstructorDescriptor, "constructor");
            TypeSubstitutor2 typeSubstitutor2Create = typeAliasDescriptor.getClassDescriptor() == null ? null : TypeSubstitutor2.create(typeAliasDescriptor.getExpandedType());
            if (typeSubstitutor2Create == null || (classConstructorDescriptorSubstitute = classConstructorDescriptor.substitute(typeSubstitutor2Create)) == null) {
                return null;
            }
            Annotations4 annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.a kind = classConstructorDescriptor.getKind();
            Intrinsics3.checkNotNullExpressionValue(kind, "constructor.kind");
            SourceElement source = typeAliasDescriptor.getSource();
            Intrinsics3.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor2 = new TypeAliasConstructorDescriptor2(storageManager, typeAliasDescriptor, classConstructorDescriptorSubstitute, null, annotations, kind, source, null);
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructorDescriptor2, classConstructorDescriptor.getValueParameters(), typeSubstitutor2Create);
            if (substitutedValueParameters == null) {
                return null;
            }
            KotlinType4 kotlinType4LowerIfFlexible = flexibleTypes2.lowerIfFlexible(classConstructorDescriptorSubstitute.getReturnType().unwrap());
            KotlinType4 defaultType = typeAliasDescriptor.getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "typeAliasDescriptor.defaultType");
            KotlinType4 kotlinType4WithAbbreviation = SpecialTypes5.withAbbreviation(kotlinType4LowerIfFlexible, defaultType);
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
            typeAliasConstructorDescriptor2.initialize(dispatchReceiverParameter != null ? DescriptorFactory.createExtensionReceiverParameterForCallable(typeAliasConstructorDescriptor2, typeSubstitutor2Create.safeSubstitute(dispatchReceiverParameter.getType(), Variance.INVARIANT), Annotations4.f.getEMPTY()) : null, null, typeAliasDescriptor.getDeclaredTypeParameters(), substitutedValueParameters, kotlinType4WithAbbreviation, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructorDescriptor2;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0$b */
    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class b extends Lambda implements Function0<TypeAliasConstructorDescriptor2> {
        public final /* synthetic */ ClassConstructorDescriptor $underlyingConstructorDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ClassConstructorDescriptor classConstructorDescriptor) {
            super(0);
            this.$underlyingConstructorDescriptor = classConstructorDescriptor;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TypeAliasConstructorDescriptor2 invoke() {
            StorageManager storageManager = TypeAliasConstructorDescriptor2.this.getStorageManager();
            TypeAliasDescriptor typeAliasDescriptor = TypeAliasConstructorDescriptor2.this.getTypeAliasDescriptor();
            ClassConstructorDescriptor classConstructorDescriptor = this.$underlyingConstructorDescriptor;
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor2 = TypeAliasConstructorDescriptor2.this;
            Annotations4 annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.a kind = this.$underlyingConstructorDescriptor.getKind();
            Intrinsics3.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
            SourceElement source = TypeAliasConstructorDescriptor2.this.getTypeAliasDescriptor().getSource();
            Intrinsics3.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor3 = new TypeAliasConstructorDescriptor2(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor2, annotations, kind, source, null);
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor4 = TypeAliasConstructorDescriptor2.this;
            ClassConstructorDescriptor classConstructorDescriptor2 = this.$underlyingConstructorDescriptor;
            TypeSubstitutor2 typeSubstitutor2Access$getTypeSubstitutorForUnderlyingClass = a.access$getTypeSubstitutorForUnderlyingClass(TypeAliasConstructorDescriptor2.M, typeAliasConstructorDescriptor4.getTypeAliasDescriptor());
            if (typeSubstitutor2Access$getTypeSubstitutorForUnderlyingClass == null) {
                return null;
            }
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor2.getDispatchReceiverParameter();
            typeAliasConstructorDescriptor3.initialize(null, dispatchReceiverParameter == null ? null : dispatchReceiverParameter.substitute(typeSubstitutor2Access$getTypeSubstitutorForUnderlyingClass), typeAliasConstructorDescriptor4.getTypeAliasDescriptor().getDeclaredTypeParameters(), typeAliasConstructorDescriptor4.getValueParameters(), typeAliasConstructorDescriptor4.getReturnType(), Modality.FINAL, typeAliasConstructorDescriptor4.getTypeAliasDescriptor().getVisibility());
            return typeAliasConstructorDescriptor3;
        }
    }

    public TypeAliasConstructorDescriptor2(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations4 annotations4, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(typeAliasDescriptor, typeAliasConstructorDescriptor, annotations4, Name.special("<init>"), aVar, sourceElement);
        this.O = storageManager;
        this.P = typeAliasDescriptor;
        setActual(getTypeAliasDescriptor().isActual());
        storageManager.createNullableLazyValue(new b(classConstructorDescriptor));
        this.Q = classConstructorDescriptor;
    }

    public /* synthetic */ TypeAliasConstructorDescriptor2(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations4 annotations4, CallableMemberDescriptor.a aVar, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations4, aVar, sourceElement);
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public FunctionDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        return new TypeAliasConstructorDescriptor2(this.O, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, annotations4, CallableMemberDescriptor.a.DECLARATION, sourceElement);
    }

    @Override // d0.e0.p.d.m0.c.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics3.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType returnType = super.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        return returnType;
    }

    public final StorageManager getStorageManager() {
        return this.O;
    }

    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.P;
    }

    @Override // d0.e0.p.d.m0.c.i1.TypeAliasConstructorDescriptor
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.Q;
    }

    @Override // d0.e0.p.d.m0.c.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.CallableMemberDescriptor
    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(modality, "modality");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        FunctionDescriptor functionDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility2).setKind(aVar).setCopyOverrides(z2).build();
        Objects.requireNonNull(functionDescriptorBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) functionDescriptorBuild;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.Substitutable
    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "substitutor");
        FunctionDescriptor functionDescriptorSubstitute = super.substitute(typeSubstitutor2);
        Objects.requireNonNull(functionDescriptorSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor2 = (TypeAliasConstructorDescriptor2) functionDescriptorSubstitute;
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(typeAliasConstructorDescriptor2.getReturnType());
        Intrinsics3.checkNotNullExpressionValue(typeSubstitutor2Create, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor classConstructorDescriptorSubstitute = getUnderlyingConstructorDescriptor().getOriginal().substitute(typeSubstitutor2Create);
        if (classConstructorDescriptorSubstitute == null) {
            return null;
        }
        typeAliasConstructorDescriptor2.Q = classConstructorDescriptorSubstitute;
        return typeAliasConstructorDescriptor2;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public TypeAliasConstructorDescriptor getOriginal() {
        return (TypeAliasConstructorDescriptor) super.getOriginal();
    }
}
