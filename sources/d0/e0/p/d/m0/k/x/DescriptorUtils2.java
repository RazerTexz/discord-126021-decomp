package d0.e0.p.d.m0.k.x;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PropertyAccessorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.v.g;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner2;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner3;
import d0.e0.p.d.m0.p.DFS;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a, reason: use source file name */
/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorUtils2 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$a */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class a implements DFS.c<ValueParameterDescriptor> {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.p.DFS.c
        public final Iterable<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
            Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
            Iterator<T> it = overriddenDescriptors.iterator();
            while (it.hasNext()) {
                arrayList.add(((ValueParameterDescriptor) it.next()).getOriginal());
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$b */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public /* synthetic */ class b extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ValueParameterDescriptor.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor valueParameterDescriptor) {
            return Boolean.valueOf(invoke2(valueParameterDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ValueParameterDescriptor valueParameterDescriptor) {
            Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "p0");
            return valueParameterDescriptor.declaresDefaultValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$c */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class c implements DFS.c<CallableMemberDescriptor> {
        public final /* synthetic */ boolean a;

        public c(boolean z2) {
            this.a = z2;
        }

        @Override // d0.e0.p.d.m0.p.DFS.c
        public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
            if (this.a) {
                callableMemberDescriptor = callableMemberDescriptor == null ? null : callableMemberDescriptor.getOriginal();
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor != null ? callableMemberDescriptor.getOverriddenDescriptors() : null;
            return overriddenDescriptors == null ? Collections2.emptyList() : overriddenDescriptors;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$d */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class d extends DFS.b<CallableMemberDescriptor, CallableMemberDescriptor> {
        public final /* synthetic */ Ref$ObjectRef<CallableMemberDescriptor> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> f3477b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Ref$ObjectRef<CallableMemberDescriptor> ref$ObjectRef, Function1<? super CallableMemberDescriptor, Boolean> function1) {
            this.a = ref$ObjectRef;
            this.f3477b = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.e0.p.d.m0.p.DFS.b, d0.e0.p.d.m0.p.DFS.d
        public void afterChildren(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "current");
            if (this.a.element == null && this.f3477b.invoke(callableMemberDescriptor).booleanValue()) {
                this.a.element = callableMemberDescriptor;
            }
        }

        @Override // d0.e0.p.d.m0.p.DFS.d
        public boolean beforeChildren(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "current");
            return this.a.element == null;
        }

        @Override // d0.e0.p.d.m0.p.DFS.d
        public CallableMemberDescriptor result() {
            return this.a.element;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$e */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class e extends Lambda implements Function1<DeclarationDescriptor, DeclarationDescriptor> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DeclarationDescriptor invoke(DeclarationDescriptor declarationDescriptor) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "it");
            return declarationDescriptor.getContainingDeclaration();
        }
    }

    static {
        Intrinsics3.checkNotNullExpressionValue(Name.identifier("value"), "identifier(\"value\")");
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "<this>");
        Boolean boolIfAny = DFS.ifAny(CollectionsJVM.listOf(valueParameterDescriptor), a.a, b.j);
        Intrinsics3.checkNotNullExpressionValue(boolIfAny, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return boolIfAny.booleanValue();
    }

    public static final g<?> firstArgument(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "<this>");
        return (g) _Collections.firstOrNull(annotationDescriptor.getAllValueArguments().values());
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor callableMemberDescriptor, boolean z2, Function1<? super CallableMemberDescriptor, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return (CallableMemberDescriptor) DFS.dfs(CollectionsJVM.listOf(callableMemberDescriptor), new c(z2), new d(new Ref$ObjectRef(), function1));
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return firstOverridden(callableMemberDescriptor, z2, function1);
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe == null) {
            return null;
        }
        return fqNameUnsafe.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassifierDescriptor declarationDescriptor = annotationDescriptor.getType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        return getModule(declarationDescriptor).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        ClassId classId;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new ClassId(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(classifierDescriptor.getName());
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe(declarationDescriptor);
        Intrinsics3.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqName = DescriptorUtils.getFqName(declarationDescriptor);
        Intrinsics3.checkNotNullExpressionValue(fqName, "getFqName(this)");
        return fqName;
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        KotlinTypeRefiner3 kotlinTypeRefiner3 = (KotlinTypeRefiner3) moduleDescriptor2.getCapability(KotlinTypeRefiner2.getREFINER_CAPABILITY());
        KotlinTypeRefiner kotlinTypeRefiner = kotlinTypeRefiner3 == null ? null : (KotlinTypeRefiner) kotlinTypeRefiner3.getValue();
        return kotlinTypeRefiner == null ? KotlinTypeRefiner.a.a : kotlinTypeRefiner;
    }

    public static final ModuleDescriptor2 getModule(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        ModuleDescriptor2 containingModule = DescriptorUtils.getContainingModule(declarationDescriptor);
        Intrinsics3.checkNotNullExpressionValue(containingModule, "getContainingModule(this)");
        return containingModule;
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        return _Sequences2.drop(getParentsWithSelf(declarationDescriptor), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        return n.generateSequence(declarationDescriptor, e.j);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        Intrinsics3.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        for (KotlinType kotlinType : classDescriptor.getDefaultType().getConstructor().getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(kotlinType)) {
                ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        KotlinTypeRefiner3 kotlinTypeRefiner3 = (KotlinTypeRefiner3) moduleDescriptor2.getCapability(KotlinTypeRefiner2.getREFINER_CAPABILITY());
        return (kotlinTypeRefiner3 == null ? null : (KotlinTypeRefiner) kotlinTypeRefiner3.getValue()) != null;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor2 moduleDescriptor2, FqName fqName, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        Intrinsics3.checkNotNullParameter(fqName, "topLevelClassFqName");
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        fqName.isRoot();
        FqName fqNameParent = fqName.parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "topLevelClassFqName.parent()");
        MemberScope3 memberScope = moduleDescriptor2.getPackage(fqNameParent).getMemberScope();
        Name nameShortName = fqName.shortName();
        Intrinsics3.checkNotNullExpressionValue(nameShortName, "topLevelClassFqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(nameShortName, lookupLocation2);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }
}
