package d0.e0.p.d.m0.b;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.StarProjectionImpl2;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.j, reason: use source file name */
/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectionTypes {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3214b;
    public final NotFoundClasses c;
    public final Lazy d;
    public final a e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.j$a */
    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public final ClassDescriptor getValue(ReflectionTypes reflectionTypes, KProperty<?> kProperty) {
            Intrinsics3.checkNotNullParameter(reflectionTypes, "types");
            Intrinsics3.checkNotNullParameter(kProperty, "property");
            return ReflectionTypes.access$find(reflectionTypes, StringsJVM.capitalize(kProperty.getName()), this.a);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.j$b */
    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinType createKPropertyStarType(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, StandardNames.a.Z);
            if (classDescriptorFindClassAcrossModuleDependencies == null) {
                return null;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            Annotations4 empty = Annotations4.f.getEMPTY();
            List<TypeParameterDescriptor> parameters = classDescriptorFindClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objSingle = _Collections.single((List<? extends Object>) parameters);
            Intrinsics3.checkNotNullExpressionValue(objSingle, "kPropertyClass.typeConstructor.parameters.single()");
            return KotlinTypeFactory.simpleNotNullType(empty, classDescriptorFindClassAcrossModuleDependencies, CollectionsJVM.listOf(new StarProjectionImpl2((TypeParameterDescriptor) objSingle)));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.j$c */
    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class c extends Lambda implements Function0<MemberScope3> {
        public final /* synthetic */ ModuleDescriptor2 $module;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ModuleDescriptor2 moduleDescriptor2) {
            super(0);
            this.$module = moduleDescriptor2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberScope3 invoke() {
            return this.$module.getPackage(StandardNames.i).getMemberScope();
        }
    }

    static {
        KProperty<Object>[] kPropertyArr = new KProperty[9];
        kPropertyArr[1] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[2] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[3] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[4] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[5] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[6] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[7] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[8] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        f3214b = kPropertyArr;
    }

    public ReflectionTypes(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.c = notFoundClasses;
        this.d = LazyJVM.lazy(Lazy5.PUBLICATION, new c(moduleDescriptor2));
        this.e = new a(1);
        new a(1);
        new a(1);
        new a(2);
        new a(3);
        new a(1);
        new a(2);
        new a(3);
    }

    public static final ClassDescriptor access$find(ReflectionTypes reflectionTypes, String str, int i) {
        Objects.requireNonNull(reflectionTypes);
        Name nameIdentifier = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(className)");
        ClassifierDescriptor contributedClassifier = ((MemberScope3) reflectionTypes.d.getValue()).getContributedClassifier(nameIdentifier, LookupLocation3.FROM_REFLECTION);
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        return classDescriptor == null ? reflectionTypes.c.getClass(new ClassId(StandardNames.i, nameIdentifier), CollectionsJVM.listOf(Integer.valueOf(i))) : classDescriptor;
    }

    public final ClassDescriptor getKClass() {
        return this.e.getValue(this, f3214b[1]);
    }
}
