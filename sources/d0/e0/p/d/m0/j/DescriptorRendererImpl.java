package d0.e0.p.d.m0.j;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.LazyJVM;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.b.functionTypes;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DeclarationDescriptorWithSource;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FieldDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.MemberDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageViewDescriptor;
import d0.e0.p.d.m0.c.PropertyAccessorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertyGetterDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.VariableDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationUseSiteTarget;
import d0.e0.p.d.m0.c.g1.Annotations3;
import d0.e0.p.d.m0.c.typeParameterUtils;
import d0.e0.p.d.m0.c.typeParameterUtils3;
import d0.e0.p.d.m0.c.v0;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.g.SpecialNames;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.v.r;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.ErrorType;
import d0.e0.p.d.m0.n.ErrorType2;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinType5;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.SpecialTypes;
import d0.e0.p.d.m0.n.SpecialTypes5;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.Variance;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.g0._Strings;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.d, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer2 implements DescriptorRenderer4 {
    public final DescriptorRendererOptionsImpl d;
    public final Lazy e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$a */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public final class a implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        public final /* synthetic */ DescriptorRendererImpl a;

        public a(DescriptorRendererImpl descriptorRendererImpl) {
            Intrinsics3.checkNotNullParameter(descriptorRendererImpl, "this$0");
            this.a = descriptorRendererImpl;
        }

        public final void a(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) throws IOException {
            int iOrdinal = this.a.getPropertyAccessorRenderingPolicy().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                visitFunctionDescriptor2((FunctionDescriptor) propertyAccessorDescriptor, sb);
            } else {
                this.a.p(propertyAccessorDescriptor, sb);
                sb.append(Intrinsics3.stringPlus(str, " for "));
                DescriptorRendererImpl descriptorRendererImpl = this.a;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics3.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                DescriptorRendererImpl.access$renderProperty(descriptorRendererImpl, correspondingProperty, sb);
            }
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) throws IOException {
            visitClassDescriptor2(classDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) throws IOException {
            visitConstructorDescriptor2(constructorDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) throws IOException {
            visitFunctionDescriptor2(functionDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor2 moduleDescriptor2, StringBuilder sb) {
            visitModuleDeclaration2(moduleDescriptor2, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            visitPackageFragmentDescriptor2(packageFragmentDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            visitPackageViewDescriptor2(packageViewDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) throws IOException {
            visitPropertyDescriptor2(propertyDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) throws IOException {
            visitPropertyGetterDescriptor2(propertyGetterDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) throws IOException {
            visitPropertySetterDescriptor2(propertySetterDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            visitReceiverParameterDescriptor2(receiverParameterDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            visitTypeAliasDescriptor2(typeAliasDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            visitTypeParameterDescriptor2(typeParameterDescriptor, sb);
            return Unit.a;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            visitValueParameterDescriptor2(valueParameterDescriptor, sb);
            return Unit.a;
        }

        /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor classDescriptor, StringBuilder sb) throws IOException {
            Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderClass(this.a, classDescriptor, sb);
        }

        /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor constructorDescriptor, StringBuilder sb) throws IOException {
            Intrinsics3.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderConstructor(this.a, constructorDescriptor, sb);
        }

        /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor functionDescriptor, StringBuilder sb) throws IOException {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderFunction(this.a, functionDescriptor, sb);
        }

        /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor2 moduleDescriptor2, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            this.a.t(moduleDescriptor2, sb, true);
        }

        /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderPackageFragment(this.a, packageFragmentDescriptor, sb);
        }

        /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(packageViewDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderPackageView(this.a, packageViewDescriptor, sb);
        }

        /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor propertyDescriptor, StringBuilder sb) throws IOException {
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderProperty(this.a, propertyDescriptor, sb);
        }

        /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) throws IOException {
            Intrinsics3.checkNotNullParameter(propertyGetterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            a(propertyGetterDescriptor, sb, "getter");
        }

        /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) throws IOException {
            Intrinsics3.checkNotNullParameter(propertySetterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            a(propertySetterDescriptor, sb, "setter");
        }

        /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(receiverParameterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            sb.append(receiverParameterDescriptor.getName());
        }

        /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderTypeAlias(this.a, typeAliasDescriptor, sb);
        }

        /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            this.a.C(typeParameterDescriptor, sb, true);
        }

        /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            this.a.G(valueParameterDescriptor, true, sb, true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$b */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public static final class b extends Lambda implements Function1<TypeProjection, CharSequence> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(TypeProjection typeProjection) {
            Intrinsics3.checkNotNullParameter(typeProjection, "it");
            if (typeProjection.isStarProjection()) {
                return "*";
            }
            DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
            KotlinType type = typeProjection.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            String strRenderType = descriptorRendererImpl.renderType(type);
            if (typeProjection.getProjectionKind() == Variance.INVARIANT) {
                return strRenderType;
            }
            return typeProjection.getProjectionKind() + ' ' + strRenderType;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$c */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public static final class c extends Lambda implements Function0<DescriptorRendererImpl> {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$c$a */
        /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
        public static final class a extends Lambda implements Function1<DescriptorRenderer4, Unit> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
                invoke2(descriptorRenderer4);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
                Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
                descriptorRenderer4.setExcludedTypeAnnotationClasses(_Sets.plus((Set) descriptorRenderer4.getExcludedTypeAnnotationClasses(), (Iterable) CollectionsJVM.listOf(StandardNames.a.f3228x)));
                descriptorRenderer4.setAnnotationArgumentsRenderingPolicy(DescriptorRenderer.ALWAYS_PARENTHESIZED);
            }
        }

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DescriptorRendererImpl invoke() {
            return (DescriptorRendererImpl) DescriptorRendererImpl.this.withOptions(a.j);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.d$d */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public static final class d extends Lambda implements Function1<d0.e0.p.d.m0.k.v.g<?>, CharSequence> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(d0.e0.p.d.m0.k.v.g<?> gVar) {
            Intrinsics3.checkNotNullParameter(gVar, "it");
            return DescriptorRendererImpl.this.k(gVar);
        }
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics3.checkNotNullParameter(descriptorRendererOptionsImpl, "options");
        this.d = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.isLocked();
        this.e = LazyJVM.lazy(new c());
    }

    public static final void access$renderClass(DescriptorRendererImpl descriptorRendererImpl, ClassDescriptor classDescriptor, StringBuilder sb) throws IOException {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        Objects.requireNonNull(descriptorRendererImpl);
        boolean z2 = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
        if (!descriptorRendererImpl.getStartFromName()) {
            descriptorRendererImpl.h(sb, classDescriptor, null);
            if (!z2) {
                DescriptorVisibility2 visibility = classDescriptor.getVisibility();
                Intrinsics3.checkNotNullExpressionValue(visibility, "klass.visibility");
                descriptorRendererImpl.I(visibility, sb);
            }
            if ((classDescriptor.getKind() != ClassKind.INTERFACE || classDescriptor.getModality() != Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                Intrinsics3.checkNotNullExpressionValue(modality, "klass.modality");
                descriptorRendererImpl.q(modality, sb, descriptorRendererImpl.e(classDescriptor));
            }
            descriptorRendererImpl.p(classDescriptor, sb);
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.INNER) && classDescriptor.isInner(), "inner");
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.DATA) && classDescriptor.isData(), "data");
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.INLINE) && classDescriptor.isInline(), "inline");
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.VALUE) && classDescriptor.isValue(), "value");
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.FUN) && classDescriptor.isFun(), "fun");
            sb.append(descriptorRendererImpl.n(DescriptorRenderer2.a.getClassifierKindPrefix(classDescriptor)));
        }
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            if (descriptorRendererImpl.getRenderCompanionObjectName()) {
                if (descriptorRendererImpl.getStartFromName()) {
                    sb.append("companion object");
                }
                descriptorRendererImpl.B(sb);
                DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                if (containingDeclaration != null) {
                    sb.append("of ");
                    Name name = containingDeclaration.getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "containingDeclaration.name");
                    sb.append(descriptorRendererImpl.renderName(name, false));
                }
            }
            if (descriptorRendererImpl.getVerbose() || !Intrinsics3.areEqual(classDescriptor.getName(), SpecialNames.f3425b)) {
                if (!descriptorRendererImpl.getStartFromName()) {
                    descriptorRendererImpl.B(sb);
                }
                Name name2 = classDescriptor.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "descriptor.name");
                sb.append(descriptorRendererImpl.renderName(name2, true));
            }
        } else {
            if (!descriptorRendererImpl.getStartFromName()) {
                descriptorRendererImpl.B(sb);
            }
            descriptorRendererImpl.t(classDescriptor, sb, true);
        }
        if (z2) {
            return;
        }
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
        descriptorRendererImpl.E(declaredTypeParameters, sb, false);
        descriptorRendererImpl.j(classDescriptor, sb);
        if (!classDescriptor.getKind().isSingleton() && descriptorRendererImpl.getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
            sb.append(" ");
            descriptorRendererImpl.h(sb, unsubstitutedPrimaryConstructor, null);
            DescriptorVisibility2 visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
            Intrinsics3.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
            descriptorRendererImpl.I(visibility2, sb);
            sb.append(descriptorRendererImpl.n("constructor"));
            List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
            descriptorRendererImpl.H(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
        }
        if (!descriptorRendererImpl.getWithoutSuperTypes() && !KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics3.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
            if (!supertypes.isEmpty() && (supertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next()))) {
                descriptorRendererImpl.B(sb);
                sb.append(": ");
                _Collections.joinTo(supertypes, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new DescriptorRendererImpl3(descriptorRendererImpl));
            }
        }
        descriptorRendererImpl.J(declaredTypeParameters, sb);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0031  */
    public static final void access$renderConstructor(DescriptorRendererImpl descriptorRendererImpl, ConstructorDescriptor constructorDescriptor, StringBuilder sb) throws IOException {
        boolean z2;
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        descriptorRendererImpl.h(sb, constructorDescriptor, null);
        if (descriptorRendererImpl.d.getRenderDefaultVisibility() || constructorDescriptor.getConstructedClass().getModality() != Modality.SEALED) {
            DescriptorVisibility2 visibility = constructorDescriptor.getVisibility();
            Intrinsics3.checkNotNullExpressionValue(visibility, "constructor.visibility");
            if (descriptorRendererImpl.I(visibility, sb)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        descriptorRendererImpl.o(constructorDescriptor, sb);
        boolean z3 = descriptorRendererImpl.getRenderConstructorKeyword() || !constructorDescriptor.isPrimary() || z2;
        if (z3) {
            sb.append(descriptorRendererImpl.n("constructor"));
        }
        ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "constructor.containingDeclaration");
        if (descriptorRendererImpl.getSecondaryConstructorsAsPrimary()) {
            if (z3) {
                sb.append(" ");
            }
            descriptorRendererImpl.t(containingDeclaration, sb, true);
            List<TypeParameterDescriptor> typeParameters = constructorDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "constructor.typeParameters");
            descriptorRendererImpl.E(typeParameters, sb, false);
        }
        List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
        descriptorRendererImpl.H(valueParameters, constructorDescriptor.hasSynthesizedParameterNames(), sb);
        if (descriptorRendererImpl.getRenderConstructorDelegation() && !constructorDescriptor.isPrimary() && (containingDeclaration instanceof ClassDescriptor) && (unsubstitutedPrimaryConstructor = ((ClassDescriptor) containingDeclaration).getUnsubstitutedPrimaryConstructor()) != null) {
            List<ValueParameterDescriptor> valueParameters2 = unsubstitutedPrimaryConstructor.getValueParameters();
            ArrayList arrayListA0 = outline.a0(valueParameters2, "primaryConstructor.valueParameters");
            for (Object obj : valueParameters2) {
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
                if (!valueParameterDescriptor.declaresDefaultValue() && valueParameterDescriptor.getVarargElementType() == null) {
                    arrayListA0.add(obj);
                }
            }
            if (!arrayListA0.isEmpty()) {
                sb.append(" : ");
                sb.append(descriptorRendererImpl.n("this"));
                sb.append(_Collections.joinToString$default(arrayListA0, ", ", "(", ")", 0, null, DescriptorRendererImpl2.j, 24, null));
            }
        }
        if (descriptorRendererImpl.getSecondaryConstructorsAsPrimary()) {
            List<TypeParameterDescriptor> typeParameters2 = constructorDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters2, "constructor.typeParameters");
            descriptorRendererImpl.J(typeParameters2, sb);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    public static final void access$renderFunction(DescriptorRendererImpl descriptorRendererImpl, FunctionDescriptor functionDescriptor, StringBuilder sb) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        if (!descriptorRendererImpl.getStartFromName()) {
            if (!descriptorRendererImpl.getStartFromDeclarationKeyword()) {
                descriptorRendererImpl.h(sb, functionDescriptor, null);
                DescriptorVisibility2 visibility = functionDescriptor.getVisibility();
                Intrinsics3.checkNotNullExpressionValue(visibility, "function.visibility");
                descriptorRendererImpl.I(visibility, sb);
                descriptorRendererImpl.r(functionDescriptor, sb);
                if (descriptorRendererImpl.getIncludeAdditionalModifiers()) {
                    descriptorRendererImpl.p(functionDescriptor, sb);
                }
                descriptorRendererImpl.w(functionDescriptor, sb);
                if (descriptorRendererImpl.getIncludeAdditionalModifiers()) {
                    boolean z5 = false;
                    if (functionDescriptor.isOperator()) {
                        Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
                        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "functionDescriptor.overriddenDescriptors");
                        if (!overriddenDescriptors.isEmpty()) {
                            Iterator<T> it = overriddenDescriptors.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z4 = true;
                                    break;
                                } else if (((FunctionDescriptor) it.next()).isOperator()) {
                                    z4 = false;
                                    break;
                                }
                            }
                        } else {
                            z4 = true;
                            break;
                        }
                        if (z4 || descriptorRendererImpl.getAlwaysRenderModifiers()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (functionDescriptor.isInfix()) {
                        Collection<? extends FunctionDescriptor> overriddenDescriptors2 = functionDescriptor.getOverriddenDescriptors();
                        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors2, "functionDescriptor.overriddenDescriptors");
                        if (!overriddenDescriptors2.isEmpty()) {
                            Iterator<T> it2 = overriddenDescriptors2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z3 = true;
                                    break;
                                } else if (((FunctionDescriptor) it2.next()).isInfix()) {
                                    z3 = false;
                                    break;
                                }
                            }
                        } else {
                            z3 = true;
                            break;
                        }
                        if (z3 || descriptorRendererImpl.getAlwaysRenderModifiers()) {
                            z5 = true;
                        }
                    }
                    descriptorRendererImpl.s(sb, functionDescriptor.isTailrec(), "tailrec");
                    descriptorRendererImpl.s(sb, functionDescriptor.isSuspend(), "suspend");
                    descriptorRendererImpl.s(sb, functionDescriptor.isInline(), "inline");
                    descriptorRendererImpl.s(sb, z5, "infix");
                    descriptorRendererImpl.s(sb, z2, "operator");
                } else {
                    descriptorRendererImpl.s(sb, functionDescriptor.isSuspend(), "suspend");
                }
                descriptorRendererImpl.o(functionDescriptor, sb);
                if (descriptorRendererImpl.getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(descriptorRendererImpl.n("fun"));
            sb.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "function.typeParameters");
            descriptorRendererImpl.E(typeParameters, sb, true);
            descriptorRendererImpl.z(functionDescriptor, sb);
        }
        descriptorRendererImpl.t(functionDescriptor, sb, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "function.valueParameters");
        descriptorRendererImpl.H(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb);
        descriptorRendererImpl.A(functionDescriptor, sb);
        KotlinType returnType = functionDescriptor.getReturnType();
        if (!descriptorRendererImpl.getWithoutReturnType() && (descriptorRendererImpl.getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : descriptorRendererImpl.renderType(returnType));
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters2, "function.typeParameters");
        descriptorRendererImpl.J(typeParameters2, sb);
    }

    public static final void access$renderPackageFragment(DescriptorRendererImpl descriptorRendererImpl, PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        Objects.requireNonNull(descriptorRendererImpl);
        descriptorRendererImpl.x(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (descriptorRendererImpl.getDebugMode()) {
            sb.append(" in ");
            descriptorRendererImpl.t(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    public static final void access$renderPackageView(DescriptorRendererImpl descriptorRendererImpl, PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        Objects.requireNonNull(descriptorRendererImpl);
        descriptorRendererImpl.x(packageViewDescriptor.getFqName(), "package", sb);
        if (descriptorRendererImpl.getDebugMode()) {
            sb.append(" in context of ");
            descriptorRendererImpl.t(packageViewDescriptor.getModule(), sb, false);
        }
    }

    public static final void access$renderProperty(DescriptorRendererImpl descriptorRendererImpl, PropertyDescriptor propertyDescriptor, StringBuilder sb) throws IOException {
        if (!descriptorRendererImpl.getStartFromName()) {
            if (!descriptorRendererImpl.getStartFromDeclarationKeyword()) {
                if (descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.ANNOTATIONS)) {
                    descriptorRendererImpl.h(sb, propertyDescriptor, null);
                    FieldDescriptor backingField = propertyDescriptor.getBackingField();
                    if (backingField != null) {
                        descriptorRendererImpl.h(sb, backingField, AnnotationUseSiteTarget.FIELD);
                    }
                    FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
                    if (delegateField != null) {
                        descriptorRendererImpl.h(sb, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
                    }
                    if (descriptorRendererImpl.getPropertyAccessorRenderingPolicy() == DescriptorRenderer8.NONE) {
                        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                        if (getter != null) {
                            descriptorRendererImpl.h(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                        }
                        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                        if (setter != null) {
                            descriptorRendererImpl.h(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                            List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                            Intrinsics3.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.single((List) valueParameters);
                            Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                            descriptorRendererImpl.h(sb, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                        }
                    }
                }
                DescriptorVisibility2 visibility = propertyDescriptor.getVisibility();
                Intrinsics3.checkNotNullExpressionValue(visibility, "property.visibility");
                descriptorRendererImpl.I(visibility, sb);
                descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.CONST) && propertyDescriptor.isConst(), "const");
                descriptorRendererImpl.p(propertyDescriptor, sb);
                descriptorRendererImpl.r(propertyDescriptor, sb);
                descriptorRendererImpl.w(propertyDescriptor, sb);
                descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.LATEINIT) && propertyDescriptor.isLateInit(), "lateinit");
                descriptorRendererImpl.o(propertyDescriptor, sb);
            }
            descriptorRendererImpl.F(propertyDescriptor, sb, false);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            descriptorRendererImpl.E(typeParameters, sb, true);
            descriptorRendererImpl.z(propertyDescriptor, sb);
        }
        descriptorRendererImpl.t(propertyDescriptor, sb, true);
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "property.type");
        sb.append(descriptorRendererImpl.renderType(type));
        descriptorRendererImpl.A(propertyDescriptor, sb);
        descriptorRendererImpl.m(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        descriptorRendererImpl.J(typeParameters2, sb);
    }

    public static final void access$renderTypeAlias(DescriptorRendererImpl descriptorRendererImpl, TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        descriptorRendererImpl.h(sb, typeAliasDescriptor, null);
        DescriptorVisibility2 visibility = typeAliasDescriptor.getVisibility();
        Intrinsics3.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        descriptorRendererImpl.I(visibility, sb);
        descriptorRendererImpl.p(typeAliasDescriptor, sb);
        sb.append(descriptorRendererImpl.n("typealias"));
        sb.append(" ");
        descriptorRendererImpl.t(typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        descriptorRendererImpl.E(declaredTypeParameters, sb, false);
        descriptorRendererImpl.j(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(descriptorRendererImpl.renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    public static /* synthetic */ void i(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotations3 annotations3, AnnotationUseSiteTarget annotationUseSiteTarget, int i) {
        int i2 = i & 2;
        descriptorRendererImpl.h(sb, annotations3, null);
    }

    public final void A(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
        }
    }

    public final void B(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    public final void C(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z2) {
        if (z2) {
            sb.append(f());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        s(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z3 = true;
        s(sb, label.length() > 0, label);
        h(sb, typeParameterDescriptor, null);
        t(typeParameterDescriptor, sb, z2);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z2) || size == 1) {
            KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(next)) {
                sb.append(" : ");
                Intrinsics3.checkNotNullExpressionValue(next, "upperBound");
                sb.append(renderType(next));
            }
        } else if (z2) {
            for (KotlinType kotlinType : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(kotlinType)) {
                    if (z3) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    Intrinsics3.checkNotNullExpressionValue(kotlinType, "upperBound");
                    sb.append(renderType(kotlinType));
                    z3 = false;
                }
            }
        }
        if (z2) {
            sb.append(d());
        }
    }

    public final void D(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            C(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    public final void E(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z2) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(f());
            D(sb, list);
            sb.append(d());
            if (z2) {
                sb.append(" ");
            }
        }
    }

    public final void F(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z2) {
        if (z2 || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(n(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4  */
    public final void G(ValueParameterDescriptor valueParameterDescriptor, boolean z2, StringBuilder sb, boolean z3) {
        boolean z4;
        boolean z5;
        if (z3) {
            sb.append(n("value-parameter"));
            sb.append(" ");
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(valueParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        h(sb, valueParameterDescriptor, null);
        s(sb, valueParameterDescriptor.isCrossinline(), "crossinline");
        s(sb, valueParameterDescriptor.isNoinline(), "noinline");
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            CallableDescriptor containingDeclaration = valueParameterDescriptor.getContainingDeclaration();
            ClassConstructorDescriptor classConstructorDescriptor = containingDeclaration instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) containingDeclaration : null;
            if (Intrinsics3.areEqual(classConstructorDescriptor == null ? null : Boolean.valueOf(classConstructorDescriptor.isPrimary()), Boolean.TRUE)) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        if (z4) {
            s(sb, getActualPropertiesInPrimaryConstructor(), "actual");
        }
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "variable.type");
        KotlinType varargElementType = valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null;
        KotlinType kotlinType = varargElementType == null ? type : varargElementType;
        s(sb, varargElementType != null, "vararg");
        if (z4 || (z3 && !getStartFromName())) {
            F(valueParameterDescriptor, sb, z4);
        }
        if (z2) {
            t(valueParameterDescriptor, sb, z3);
            sb.append(": ");
        }
        sb.append(renderType(kotlinType));
        m(valueParameterDescriptor, sb);
        if (getVerbose() && varargElementType != null) {
            sb.append(" /*");
            sb.append(renderType(type));
            sb.append("*/");
        }
        if (getDefaultParameterValueRenderer() != null) {
            z5 = getDebugMode() ? valueParameterDescriptor.declaresDefaultValue() : DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        if (z5) {
            Function1<ValueParameterDescriptor, String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
            Intrinsics3.checkNotNull(defaultParameterValueRenderer);
            sb.append(Intrinsics3.stringPlus(" = ", defaultParameterValueRenderer.invoke(valueParameterDescriptor)));
        }
    }

    public final void H(Collection<? extends ValueParameterDescriptor> collection, boolean z2, StringBuilder sb) {
        int iOrdinal = getParameterNameRenderingPolicy().ordinal();
        boolean z3 = true;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z2) {
            }
            z3 = false;
        }
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            G(valueParameterDescriptor, z3, sb, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    public final boolean I(DescriptorVisibility2 descriptorVisibility2, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRenderer3.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility2 = descriptorVisibility2.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.k)) {
            return false;
        }
        sb.append(n(descriptorVisibility2.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    public final void J(List<? extends TypeParameterDescriptor> list, StringBuilder sb) throws IOException {
        if (getWithoutTypeParameters()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
            for (KotlinType kotlinType : _Collections.drop(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                Name name = typeParameterDescriptor.getName();
                Intrinsics3.checkNotNullExpressionValue(name, "typeParameter.name");
                sb2.append(renderName(name, false));
                sb2.append(" : ");
                Intrinsics3.checkNotNullExpressionValue(kotlinType, "it");
                sb2.append(renderType(kotlinType));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(n("where"));
            sb.append(" ");
            _Collections.joinTo(arrayList, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
    }

    public final String K(String str, String str2, String str3, String str4, String str5) {
        if (StringsJVM.startsWith$default(str, str2, false, 2, null) && StringsJVM.startsWith$default(str3, str4, false, 2, null)) {
            int length = str2.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = str.substring(length);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            int length2 = str4.length();
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String strSubstring2 = str3.substring(length2);
            Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            String strStringPlus = Intrinsics3.stringPlus(str5, strSubstring);
            if (Intrinsics3.areEqual(strSubstring, strSubstring2)) {
                return strStringPlus;
            }
            if (b(strSubstring, strSubstring2)) {
                return Intrinsics3.stringPlus(strStringPlus, "!");
            }
        }
        return null;
    }

    public final boolean L(KotlinType kotlinType) {
        boolean z2;
        if (!functionTypes.isBuiltinFunctionalType(kotlinType)) {
            return false;
        }
        List<TypeProjection> arguments = kotlinType.getArguments();
        if ((arguments instanceof Collection) && arguments.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                if (((TypeProjection) it.next()).isStarProjection()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public final void a(StringBuilder sb, List<? extends TypeProjection> list) throws IOException {
        _Collections.joinTo(list, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new b());
    }

    public final boolean b(String str, String str2) {
        if (!Intrinsics3.areEqual(str, StringsJVM.replace$default(str2, "?", "", false, 4, (Object) null)) && (!StringsJVM.endsWith$default(str2, "?", false, 2, null) || !Intrinsics3.areEqual(Intrinsics3.stringPlus(str, "?"), str2))) {
            if (!Intrinsics3.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    public final String c(String str) {
        return getTextFormat().escape(str);
    }

    public final String d() {
        return getTextFormat().escape(">");
    }

    public final Modality e(MemberDescriptor memberDescriptor) {
        ClassKind classKind = ClassKind.INTERFACE;
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == classKind ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null && (memberDescriptor instanceof CallableMemberDescriptor)) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
            if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
                return Modality.OPEN;
            }
            if (classDescriptor.getKind() != classKind || Intrinsics3.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.a)) {
                return Modality.FINAL;
            }
            Modality modality = callableMemberDescriptor.getModality();
            Modality modality2 = Modality.ABSTRACT;
            return modality == modality2 ? modality2 : Modality.OPEN;
        }
        return Modality.FINAL;
    }

    public final String f() {
        return getTextFormat().escape("<");
    }

    public final void g(StringBuilder sb, SpecialTypes specialTypes) {
        DescriptorRenderer9 textFormat = getTextFormat();
        DescriptorRenderer9 descriptorRenderer9 = DescriptorRenderer9.HTML;
        if (textFormat == descriptorRenderer9) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        v(sb, specialTypes.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == descriptorRenderer9) {
            sb.append("</i></font>");
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.d.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.d.getAlwaysRenderModifiers();
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public DescriptorRenderer getAnnotationArgumentsRenderingPolicy() {
        return this.d.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.d.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.d.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.d.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.d.getClassifierNamePolicy();
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public boolean getDebugMode() {
        return this.d.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.d.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.d.getEachAnnotationOnNewLine();
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public boolean getEnhancedTypes() {
        return this.d.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.d.getExcludedAnnotationClasses();
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.d.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.d.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.d.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.d.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.d.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.d.getInformativeErrorType();
    }

    public Set<DescriptorRenderer3> getModifiers() {
        return this.d.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.d.getNormalizedVisibilities();
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.d;
    }

    public DescriptorRenderer6 getOverrideRenderingPolicy() {
        return this.d.getOverrideRenderingPolicy();
    }

    public DescriptorRenderer7 getParameterNameRenderingPolicy() {
        return this.d.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.d.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.d.getPresentableUnresolvedTypes();
    }

    public DescriptorRenderer8 getPropertyAccessorRenderingPolicy() {
        return this.d.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.d.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.d.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.d.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.d.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.d.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.d.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.d.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.d.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.d.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.d.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.d.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.d.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.d.getStartFromName();
    }

    public DescriptorRenderer9 getTextFormat() {
        return this.d.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.d.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.d.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.d.getUnitReturnType();
    }

    public DescriptorRenderer2.l getValueParametersHandler() {
        return this.d.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.d.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.d.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.d.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.d.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.d.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.d.getWithoutTypeParameters();
    }

    public final void h(StringBuilder sb, Annotations3 annotations3, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (getModifiers().contains(DescriptorRenderer3.ANNOTATIONS)) {
            Set<FqName> excludedTypeAnnotationClasses = annotations3 instanceof KotlinType ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
            for (AnnotationDescriptor annotationDescriptor : annotations3.getAnnotations()) {
                if (!_Collections.contains(excludedTypeAnnotationClasses, annotationDescriptor.getFqName()) && !Intrinsics3.areEqual(annotationDescriptor.getFqName(), StandardNames.a.f3229y) && (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue())) {
                    sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                    if (getEachAnnotationOnNewLine()) {
                        sb.append('\n');
                        Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    public final void j(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            D(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    public final String k(d0.e0.p.d.m0.k.v.g<?> gVar) {
        if (gVar instanceof d0.e0.p.d.m0.k.v.b) {
            return _Collections.joinToString$default(((d0.e0.p.d.m0.k.v.b) gVar).getValue(), ", ", "{", "}", 0, null, new d(), 24, null);
        }
        if (gVar instanceof d0.e0.p.d.m0.k.v.a) {
            return Strings4.removePrefix(DescriptorRenderer2.renderAnnotation$default(this, ((d0.e0.p.d.m0.k.v.a) gVar).getValue(), null, 2, null), "@");
        }
        if (!(gVar instanceof r)) {
            return gVar.toString();
        }
        r.b value = ((r) gVar).getValue();
        if (value instanceof r.b.a) {
            return ((r.b.a) value).getType() + "::class";
        }
        if (!(value instanceof r.b.C0405b)) {
            throw new NoWhenBranchMatchedException();
        }
        r.b.C0405b c0405b = (r.b.C0405b) value;
        String strAsString = c0405b.getClassId().asSingleFqName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classValue.classId.asSingleFqName().asString()");
        for (int i = 0; i < c0405b.getArrayDimensions(); i++) {
            strAsString = "kotlin.Array<" + strAsString + '>';
        }
        return Intrinsics3.stringPlus(strAsString, "::class");
    }

    public final void l(StringBuilder sb, KotlinType kotlinType) {
        h(sb, kotlinType, null);
        if (KotlinType2.isError(kotlinType)) {
            if ((kotlinType instanceof ErrorType) && getPresentableUnresolvedTypes()) {
                sb.append(((ErrorType) kotlinType).getPresentableName());
            } else if (!(kotlinType instanceof ErrorType2) || getInformativeErrorType()) {
                sb.append(kotlinType.getConstructor().toString());
            } else {
                sb.append(((ErrorType2) kotlinType).getPresentableName());
            }
            sb.append(renderTypeArguments(kotlinType.getArguments()));
        } else {
            TypeConstructor constructor = kotlinType.getConstructor();
            typeParameterUtils3 typeparameterutils3BuildPossiblyInnerType = typeParameterUtils.buildPossiblyInnerType(kotlinType);
            if (typeparameterutils3BuildPossiblyInnerType == null) {
                sb.append(renderTypeConstructor(constructor));
                sb.append(renderTypeArguments(kotlinType.getArguments()));
            } else {
                y(sb, typeparameterutils3BuildPossiblyInnerType);
            }
        }
        if (kotlinType.isMarkedNullable()) {
            sb.append("?");
        }
        if (SpecialTypes5.isDefinitelyNotNullType(kotlinType)) {
            sb.append("!!");
        }
    }

    public final void m(VariableDescriptor variableDescriptor, StringBuilder sb) {
        d0.e0.p.d.m0.k.v.g<?> compileTimeInitializer;
        if (!getIncludePropertyConstant() || (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(c(k(compileTimeInitializer)));
    }

    public final String n(String str) {
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return getBoldOnlyForNamesInHtml() ? str : outline.y("<b>", str, "</b>");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void o(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRenderer3.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.a.DECLARATION) {
            sb.append("/*");
            String strName = callableMemberDescriptor.getKind().name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append("*/ ");
        }
    }

    public final void p(MemberDescriptor memberDescriptor, StringBuilder sb) {
        s(sb, memberDescriptor.isExternal(), "external");
        boolean z2 = false;
        s(sb, getModifiers().contains(DescriptorRenderer3.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (getModifiers().contains(DescriptorRenderer3.ACTUAL) && memberDescriptor.isActual()) {
            z2 = true;
        }
        s(sb, z2, "actual");
    }

    public final void q(Modality modality, StringBuilder sb, Modality modality2) {
        if (getRenderDefaultModality() || modality != modality2) {
            boolean zContains = getModifiers().contains(DescriptorRenderer3.MODALITY);
            String strName = modality.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            s(sb, zContains, lowerCase);
        }
    }

    public final void r(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() == DescriptorRenderer6.RENDER_OVERRIDE && callableMemberDescriptor.getModality() == Modality.OPEN && (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty())) {
            return;
        }
        Modality modality = callableMemberDescriptor.getModality();
        Intrinsics3.checkNotNullExpressionValue(modality, "callable.modality");
        q(modality, sb, e(callableMemberDescriptor));
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer2
    public String render(DeclarationDescriptor declarationDescriptor) {
        String name;
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new a(this), sb);
        if (getWithDefinedIn() && !(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor)) {
            if (declarationDescriptor instanceof ModuleDescriptor2) {
                sb.append(" is a module");
            } else {
                DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
                if (containingDeclaration != null && !(containingDeclaration instanceof ModuleDescriptor2)) {
                    sb.append(" ");
                    sb.append(renderMessage("defined in"));
                    sb.append(" ");
                    FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
                    Intrinsics3.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
                    sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
                    if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((v0.a) ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile()).getName()) != null) {
                        sb.append(" ");
                        sb.append(renderMessage("in file"));
                        sb.append(" ");
                        sb.append(name);
                    }
                }
            }
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer2
    public String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget) throws IOException {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.MENTIONS_CHAR);
        if (annotationUseSiteTarget != null) {
            sb.append(Intrinsics3.stringPlus(annotationUseSiteTarget.getRenderName(), ":"));
        }
        KotlinType type = annotationDescriptor.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            Map<Name, d0.e0.p.d.m0.k.v.g<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
            List listEmptyList = null;
            ClassDescriptor annotationClass = getRenderDefaultAnnotationArguments() ? DescriptorUtils2.getAnnotationClass(annotationDescriptor) : null;
            List<ValueParameterDescriptor> valueParameters = (annotationClass == null || (unsubstitutedPrimaryConstructor = annotationClass.getUnsubstitutedPrimaryConstructor()) == null) ? null : unsubstitutedPrimaryConstructor.getValueParameters();
            if (valueParameters != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : valueParameters) {
                    if (((ValueParameterDescriptor) obj).declaresDefaultValue()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ValueParameterDescriptor) it.next()).getName());
                }
                listEmptyList = arrayList2;
            }
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listEmptyList) {
                Name name = (Name) obj2;
                Intrinsics3.checkNotNullExpressionValue(name, "it");
                if (!allValueArguments.containsKey(name)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(Intrinsics3.stringPlus(((Name) it2.next()).asString(), " = ..."));
            }
            Set<Map.Entry<Name, d0.e0.p.d.m0.k.v.g<?>>> setEntrySet = allValueArguments.entrySet();
            ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(setEntrySet, 10));
            Iterator<T> it3 = setEntrySet.iterator();
            while (it3.hasNext()) {
                Map.Entry entry = (Map.Entry) it3.next();
                Name name2 = (Name) entry.getKey();
                d0.e0.p.d.m0.k.v.g<?> gVar = (d0.e0.p.d.m0.k.v.g) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(name2.asString());
                sb2.append(" = ");
                sb2.append(!listEmptyList.contains(name2) ? k(gVar) : "...");
                arrayList5.add(sb2.toString());
            }
            List listSorted = _Collections.sorted(_Collections.plus((Collection) arrayList4, (Iterable) arrayList5));
            if (getIncludeEmptyAnnotationArguments() || (!listSorted.isEmpty())) {
                _Collections.joinTo(listSorted, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
            }
        }
        if (getVerbose() && (KotlinType2.isError(type) || (type.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.b))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderClassifierName(ClassifierDescriptor classifierDescriptor) {
        Intrinsics3.checkNotNullParameter(classifierDescriptor, "klass");
        return ErrorUtils.isError(classifierDescriptor) ? classifierDescriptor.getTypeConstructor().toString() : getClassifierNamePolicy().renderClassifier(classifierDescriptor, this);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer2
    public String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics3.checkNotNullParameter(str, "lowerRendered");
        Intrinsics3.checkNotNullParameter(str2, "upperRendered");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (b(str, str2)) {
            if (!StringsJVM.startsWith$default(str2, "(", false, 2, null)) {
                return Intrinsics3.stringPlus(str, "!");
            }
            return '(' + str + ")!";
        }
        ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
        ClassDescriptor collection = kotlinBuiltIns.getCollection();
        Intrinsics3.checkNotNullExpressionValue(collection, "builtIns.collection");
        String strSubstringBefore$default = Strings4.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
        String strK = K(str, Intrinsics3.stringPlus(strSubstringBefore$default, "Mutable"), str2, strSubstringBefore$default, strSubstringBefore$default + "(Mutable)");
        if (strK != null) {
            return strK;
        }
        String strK2 = K(str, Intrinsics3.stringPlus(strSubstringBefore$default, "MutableMap.MutableEntry"), str2, Intrinsics3.stringPlus(strSubstringBefore$default, "Map.Entry"), Intrinsics3.stringPlus(strSubstringBefore$default, "(Mutable)Map.(Mutable)Entry"));
        if (strK2 != null) {
            return strK2;
        }
        ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
        ClassDescriptor array = kotlinBuiltIns.getArray();
        Intrinsics3.checkNotNullExpressionValue(array, "builtIns.array");
        String strSubstringBefore$default2 = Strings4.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), "Array", (String) null, 2, (Object) null);
        String strK3 = K(str, Intrinsics3.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<")), str2, Intrinsics3.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<out ")), Intrinsics3.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<(out) ")));
        if (strK3 != null) {
            return strK3;
        }
        return '(' + str + ".." + str2 + ')';
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer2
    public String renderFqName(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "fqName");
        List<Name> listPathSegments = fqNameUnsafe.pathSegments();
        Intrinsics3.checkNotNullExpressionValue(listPathSegments, "fqName.pathSegments()");
        return c(RenderingUtils.renderFqName(listPathSegments));
    }

    public String renderMessage(String str) {
        Intrinsics3.checkNotNullParameter(str, "message");
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return outline.y("<i>", str, "</i>");
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer2
    public String renderName(Name name, boolean z2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strC = c(RenderingUtils.render(name));
        return (getBoldOnlyForNamesInHtml() && getTextFormat() == DescriptorRenderer9.HTML && z2) ? outline.y("<b>", strC, "</b>") : strC;
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer2
    public String renderType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        StringBuilder sb = new StringBuilder();
        u(sb, getTypeNormalizer().invoke(kotlinType));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeArguments(List<? extends TypeProjection> list) throws IOException {
        Intrinsics3.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        a(sb, list);
        sb.append(d());
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeConstructor(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor ? true : declarationDescriptor instanceof TypeAliasDescriptor) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor == null) {
            return typeConstructor.toString();
        }
        throw new IllegalStateException(Intrinsics3.stringPlus("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer2
    public String renderTypeProjection(TypeProjection typeProjection) throws IOException {
        Intrinsics3.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        a(sb, CollectionsJVM.listOf(typeProjection));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void s(StringBuilder sb, boolean z2, String str) {
        if (z2) {
            sb.append(n(str));
            sb.append(" ");
        }
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setAnnotationArgumentsRenderingPolicy(DescriptorRenderer descriptorRenderer) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer, "<set-?>");
        this.d.setAnnotationArgumentsRenderingPolicy(descriptorRenderer);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics3.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.d.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setDebugMode(boolean z2) {
        this.d.setDebugMode(z2);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.d.setExcludedTypeAnnotationClasses(set);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setModifiers(Set<? extends DescriptorRenderer3> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.d.setModifiers(set);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setParameterNameRenderingPolicy(DescriptorRenderer7 descriptorRenderer7) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer7, "<set-?>");
        this.d.setParameterNameRenderingPolicy(descriptorRenderer7);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setReceiverAfterName(boolean z2) {
        this.d.setReceiverAfterName(z2);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setRenderCompanionObjectName(boolean z2) {
        this.d.setRenderCompanionObjectName(z2);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setStartFromName(boolean z2) {
        this.d.setStartFromName(z2);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setTextFormat(DescriptorRenderer9 descriptorRenderer9) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer9, "<set-?>");
        this.d.setTextFormat(descriptorRenderer9);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setWithDefinedIn(boolean z2) {
        this.d.setWithDefinedIn(z2);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setWithoutSuperTypes(boolean z2) {
        this.d.setWithoutSuperTypes(z2);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setWithoutTypeParameters(boolean z2) {
        this.d.setWithoutTypeParameters(z2);
    }

    public final void t(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z2) {
        Name name = declarationDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(renderName(name, z2));
    }

    public final void u(StringBuilder sb, KotlinType kotlinType) {
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        SpecialTypes specialTypes = kotlinType3Unwrap instanceof SpecialTypes ? (SpecialTypes) kotlinType3Unwrap : null;
        if (specialTypes == null) {
            v(sb, kotlinType);
            return;
        }
        if (getRenderTypeExpansions()) {
            v(sb, specialTypes.getExpandedType());
            return;
        }
        v(sb, specialTypes.getAbbreviation());
        if (getRenderUnabbreviatedType()) {
            g(sb, specialTypes);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0124  */
    public final void v(StringBuilder sb, KotlinType kotlinType) {
        String strEscape;
        Name nameExtractParameterNameFromFunctionTypeArgument;
        boolean z2;
        if ((kotlinType instanceof KotlinType5) && getDebugMode() && !((KotlinType5) kotlinType).isComputed()) {
            sb.append("<Not computed yet>");
            return;
        }
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            sb.append(((KotlinType6) kotlinType3Unwrap).render(this, this));
            return;
        }
        if (kotlinType3Unwrap instanceof KotlinType4) {
            KotlinType4 kotlinType4 = (KotlinType4) kotlinType3Unwrap;
            if (Intrinsics3.areEqual(kotlinType4, TypeUtils.f3522b) || TypeUtils.isDontCarePlaceholder(kotlinType4)) {
                sb.append("???");
                return;
            }
            if (ErrorUtils.isUninferredParameter(kotlinType4)) {
                if (!getUninferredTypeParameterAsName()) {
                    sb.append("???");
                    return;
                }
                String string = ((ErrorUtils.f) kotlinType4.getConstructor()).getTypeParameterDescriptor().getName().toString();
                Intrinsics3.checkNotNullExpressionValue(string, "type.constructor as UninferredParameterTypeConstructor).typeParameterDescriptor.name.toString()");
                int iOrdinal = getTextFormat().ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    string = outline.y("<font color=red><b>", string, "</b></font>");
                }
                sb.append(string);
                return;
            }
            if (KotlinType2.isError(kotlinType4)) {
                l(sb, kotlinType4);
                return;
            }
            if (!L(kotlinType4)) {
                l(sb, kotlinType4);
                return;
            }
            int length = sb.length();
            i((DescriptorRendererImpl) this.e.getValue(), sb, kotlinType4, null, 2);
            boolean z3 = sb.length() != length;
            boolean zIsSuspendFunctionType = functionTypes.isSuspendFunctionType(kotlinType4);
            boolean zIsMarkedNullable = kotlinType4.isMarkedNullable();
            KotlinType receiverTypeFromFunctionType = functionTypes.getReceiverTypeFromFunctionType(kotlinType4);
            boolean z4 = zIsMarkedNullable || (z3 && receiverTypeFromFunctionType != null);
            if (z4) {
                if (zIsSuspendFunctionType) {
                    sb.insert(length, '(');
                } else {
                    if (z3) {
                        _Strings.last(sb);
                        if (sb.charAt(Strings4.getLastIndex(sb) - 1) != ')') {
                            sb.insert(Strings4.getLastIndex(sb), "()");
                        }
                    }
                    sb.append("(");
                }
            }
            s(sb, zIsSuspendFunctionType, "suspend");
            if (receiverTypeFromFunctionType != null) {
                if (L(receiverTypeFromFunctionType) && !receiverTypeFromFunctionType.isMarkedNullable()) {
                    z2 = true;
                } else if (functionTypes.isSuspendFunctionType(receiverTypeFromFunctionType) || !receiverTypeFromFunctionType.getAnnotations().isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    sb.append("(");
                }
                u(sb, receiverTypeFromFunctionType);
                if (z2) {
                    sb.append(")");
                }
                sb.append(".");
            }
            sb.append("(");
            int i = 0;
            for (TypeProjection typeProjection : functionTypes.getValueParameterTypesFromFunctionType(kotlinType4)) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "typeProjection.type");
                    nameExtractParameterNameFromFunctionTypeArgument = functionTypes.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    nameExtractParameterNameFromFunctionTypeArgument = null;
                }
                if (nameExtractParameterNameFromFunctionTypeArgument != null) {
                    sb.append(renderName(nameExtractParameterNameFromFunctionTypeArgument, false));
                    sb.append(": ");
                }
                sb.append(renderTypeProjection(typeProjection));
                i = i2;
            }
            sb.append(") ");
            int iOrdinal2 = getTextFormat().ordinal();
            if (iOrdinal2 == 0) {
                strEscape = getTextFormat().escape("->");
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                strEscape = "&rarr;";
            }
            sb.append(strEscape);
            sb.append(" ");
            u(sb, functionTypes.getReturnTypeFromFunctionType(kotlinType4));
            if (z4) {
                sb.append(")");
            }
            if (zIsMarkedNullable) {
                sb.append("?");
            }
        }
    }

    public final void w(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRenderer3.OVERRIDE) && (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) && getOverrideRenderingPolicy() != DescriptorRenderer6.RENDER_OPEN) {
            s(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    public final void x(FqName fqName, String str, StringBuilder sb) {
        sb.append(n(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String strRenderFqName = renderFqName(unsafe);
        if (strRenderFqName.length() > 0) {
            sb.append(" ");
            sb.append(strRenderFqName);
        }
    }

    public final void y(StringBuilder sb, typeParameterUtils3 typeparameterutils3) {
        StringBuilder sb2;
        typeParameterUtils3 outerType = typeparameterutils3.getOuterType();
        if (outerType == null) {
            sb2 = null;
        } else {
            y(sb, outerType);
            sb.append('.');
            Name name = typeparameterutils3.getClassifierDescriptor().getName();
            Intrinsics3.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            TypeConstructor typeConstructor = typeparameterutils3.getClassifierDescriptor().getTypeConstructor();
            Intrinsics3.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(renderTypeConstructor(typeConstructor));
        }
        sb.append(renderTypeArguments(typeparameterutils3.getArguments()));
    }

    public final void z(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            h(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
            String strRenderType = renderType(type);
            if (L(type) && !TypeUtils.isNullableType(type)) {
                strRenderType = '(' + strRenderType + ')';
            }
            sb.append(strRenderType);
            sb.append(".");
        }
    }
}
