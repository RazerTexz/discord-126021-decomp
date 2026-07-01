package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.v.IntegerLiteralTypeConstructor;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.TypeAliasExpansionReportStrategy;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeFactory {
    public static final KotlinTypeFactory a = new KotlinTypeFactory();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$a */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class a extends Lambda implements Function1 {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "$noName_0");
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$b */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class b {
        public final KotlinType4 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TypeConstructor f3521b;

        public b(KotlinType4 kotlinType4, TypeConstructor typeConstructor) {
            this.a = kotlinType4;
            this.f3521b = typeConstructor;
        }

        public final KotlinType4 getExpandedType() {
            return this.a;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.f3521b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$c */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class c extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
        public final /* synthetic */ Annotations4 $annotations;
        public final /* synthetic */ List<TypeProjection> $arguments;
        public final /* synthetic */ TypeConstructor $constructor;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations4 annotations4, boolean z2) {
            super(1);
            this.$constructor = typeConstructor;
            this.$arguments = list;
            this.$annotations = annotations4;
            this.$nullable = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "refiner");
            b bVarAccess$refineConstructor = KotlinTypeFactory.access$refineConstructor(KotlinTypeFactory.this, this.$constructor, kotlinTypeRefiner, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            KotlinType4 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            Annotations4 annotations4 = this.$annotations;
            TypeConstructor refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            Intrinsics3.checkNotNull(refinedConstructor);
            return KotlinTypeFactory.simpleType(annotations4, refinedConstructor, this.$arguments, this.$nullable, kotlinTypeRefiner);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$d */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class d extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
        public final /* synthetic */ Annotations4 $annotations;
        public final /* synthetic */ List<TypeProjection> $arguments;
        public final /* synthetic */ TypeConstructor $constructor;
        public final /* synthetic */ MemberScope3 $memberScope;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations4 annotations4, boolean z2, MemberScope3 memberScope3) {
            super(1);
            this.$constructor = typeConstructor;
            this.$arguments = list;
            this.$annotations = annotations4;
            this.$nullable = z2;
            this.$memberScope = memberScope3;
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            b bVarAccess$refineConstructor = KotlinTypeFactory.access$refineConstructor(KotlinTypeFactory.this, this.$constructor, kotlinTypeRefiner, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            KotlinType4 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            Annotations4 annotations4 = this.$annotations;
            TypeConstructor refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            Intrinsics3.checkNotNull(refinedConstructor);
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations4, refinedConstructor, this.$arguments, this.$nullable, this.$memberScope);
        }
    }

    static {
        a aVar = a.j;
    }

    public static final b access$refineConstructor(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List list) {
        b bVar;
        Objects.requireNonNull(kotlinTypeFactory);
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        ClassifierDescriptor classifierDescriptorRefineDescriptor = declarationDescriptor == null ? null : kotlinTypeRefiner.refineDescriptor(declarationDescriptor);
        if (classifierDescriptorRefineDescriptor == null) {
            return null;
        }
        if (classifierDescriptorRefineDescriptor instanceof TypeAliasDescriptor) {
            bVar = new b(computeExpandedType((TypeAliasDescriptor) classifierDescriptorRefineDescriptor, list), null);
        } else {
            TypeConstructor typeConstructorRefine = classifierDescriptorRefineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
            Intrinsics3.checkNotNullExpressionValue(typeConstructorRefine, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
            bVar = new b(null, typeConstructorRefine);
        }
        return bVar;
    }

    public static final KotlinType4 computeExpandedType(TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
        Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.a.a, false).expand(TypeAliasExpansion.a.create(null, typeAliasDescriptor, list), Annotations4.f.getEMPTY());
    }

    public static final KotlinType3 flexibleType(KotlinType4 kotlinType4, KotlinType4 kotlinType5) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType5, "upperBound");
        return Intrinsics3.areEqual(kotlinType4, kotlinType5) ? kotlinType4 : new flexibleTypes(kotlinType4, kotlinType5);
    }

    public static final KotlinType4 integerLiteralType(Annotations4 annotations4, IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z2) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(integerLiteralTypeConstructor, "constructor");
        List listEmptyList = Collections2.emptyList();
        MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope("Scope for integer literal type", true);
        Intrinsics3.checkNotNullExpressionValue(memberScope3CreateErrorScope, "createErrorScope(\"Scope for integer literal type\", true)");
        return simpleTypeWithNonTrivialMemberScope(annotations4, integerLiteralTypeConstructor, listEmptyList, z2, memberScope3CreateErrorScope);
    }

    public static final KotlinType4 simpleNotNullType(Annotations4 annotations4, ClassDescriptor classDescriptor, List<? extends TypeProjection> list) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(annotations4, typeConstructor, list, false, null, 16, null);
    }

    public static final KotlinType4 simpleType(Annotations4 annotations4, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, KotlinTypeRefiner kotlinTypeRefiner) {
        MemberScope3 memberScope3CreateScopeForKotlinType;
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        if (annotations4.isEmpty() && list.isEmpty() && !z2 && typeConstructor.getDeclarationDescriptor() != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            Intrinsics3.checkNotNull(declarationDescriptor);
            KotlinType4 defaultType = declarationDescriptor.getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        KotlinTypeFactory kotlinTypeFactory = a;
        ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor2 instanceof TypeParameterDescriptor) {
            memberScope3CreateScopeForKotlinType = declarationDescriptor2.getDefaultType().getMemberScope();
        } else if (declarationDescriptor2 instanceof ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils2.getModule(declarationDescriptor2));
            }
            memberScope3CreateScopeForKotlinType = list.isEmpty() ? ModuleAwareClassDescriptor2.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor2, kotlinTypeRefiner) : ModuleAwareClassDescriptor2.getRefinedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor2, TypeSubstitution3.f3542b.create(typeConstructor, list), kotlinTypeRefiner);
        } else if (declarationDescriptor2 instanceof TypeAliasDescriptor) {
            memberScope3CreateScopeForKotlinType = ErrorUtils.createErrorScope(Intrinsics3.stringPlus("Scope for abbreviation: ", ((TypeAliasDescriptor) declarationDescriptor2).getName()), true);
            Intrinsics3.checkNotNullExpressionValue(memberScope3CreateScopeForKotlinType, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
        } else {
            if (!(typeConstructor instanceof IntersectionTypeConstructor)) {
                throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor2 + " for constructor: " + typeConstructor);
            }
            memberScope3CreateScopeForKotlinType = ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        }
        return simpleTypeWithNonTrivialMemberScope(annotations4, typeConstructor, list, z2, memberScope3CreateScopeForKotlinType, kotlinTypeFactory.new c(typeConstructor, list, annotations4, z2));
    }

    public static /* synthetic */ KotlinType4 simpleType$default(Annotations4 annotations4, TypeConstructor typeConstructor, List list, boolean z2, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        if ((i & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(annotations4, typeConstructor, list, z2, kotlinTypeRefiner);
    }

    public static final KotlinType4 simpleTypeWithNonTrivialMemberScope(Annotations4 annotations4, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, MemberScope3 memberScope3) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        KotlinTypeFactory5 kotlinTypeFactory5 = new KotlinTypeFactory5(typeConstructor, list, z2, memberScope3, a.new d(typeConstructor, list, annotations4, z2, memberScope3));
        return annotations4.isEmpty() ? kotlinTypeFactory5 : new KotlinTypeFactory3(kotlinTypeFactory5, annotations4);
    }

    public static final KotlinType4 simpleTypeWithNonTrivialMemberScope(Annotations4 annotations4, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, MemberScope3 memberScope3, Function1<? super KotlinTypeRefiner, ? extends KotlinType4> function1) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(function1, "refinedTypeFactory");
        KotlinTypeFactory5 kotlinTypeFactory5 = new KotlinTypeFactory5(typeConstructor, list, z2, memberScope3, function1);
        return annotations4.isEmpty() ? kotlinTypeFactory5 : new KotlinTypeFactory3(kotlinTypeFactory5, annotations4);
    }
}
