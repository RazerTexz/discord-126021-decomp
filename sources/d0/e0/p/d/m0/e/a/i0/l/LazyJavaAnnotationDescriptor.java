package d0.e0.p.d.m0.e.a.i0.l;

import d0.Tuples;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMapper;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.e.a.g0.DescriptorResolverUtils;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.e0.p.d.m0.e.a.h0.PossiblyExternalAnnotationDescriptor;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver5;
import d0.e0.p.d.m0.e.a.j0.JavaSourceElementFactory;
import d0.e0.p.d.m0.e.a.k0.annotationArguments;
import d0.e0.p.d.m0.e.a.k0.annotationArguments2;
import d0.e0.p.d.m0.e.a.k0.annotationArguments3;
import d0.e0.p.d.m0.e.a.k0.annotationArguments4;
import d0.e0.p.d.m0.e.a.k0.annotationArguments5;
import d0.e0.p.d.m0.e.a.k0.annotationArguments6;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.k.v.ConstantValueFactory;
import d0.e0.p.d.m0.k.v.t;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage6;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.Variance;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.e, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty<Object>[] a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final context4 f3327b;
    public final d0.e0.p.d.m0.e.a.k0.a c;
    public final storage6 d;
    public final storage5 e;
    public final JavaSourceElementFactory f;
    public final storage5 g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.e$a */
    /* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
    public static final class a extends Lambda implements Function0<Map<Name, ? extends d0.e0.p.d.m0.k.v.g<?>>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Name, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke() {
            Collection<annotationArguments> arguments = LazyJavaAnnotationDescriptor.this.c.getArguments();
            LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = LazyJavaAnnotationDescriptor.this;
            ArrayList arrayList = new ArrayList();
            for (annotationArguments annotationarguments : arguments) {
                Name name = annotationarguments.getName();
                if (name == null) {
                    name = JvmAnnotationNames.f3305b;
                }
                d0.e0.p.d.m0.k.v.g gVarA = lazyJavaAnnotationDescriptor.a(annotationarguments);
                Tuples2 tuples2 = gVarA == null ? null : Tuples.to(name, gVarA);
                if (tuples2 != null) {
                    arrayList.add(tuples2);
                }
            }
            return Maps6.toMap(arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.e$b */
    /* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
    public static final class b extends Lambda implements Function0<FqName> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FqName invoke() {
            ClassId classId = LazyJavaAnnotationDescriptor.this.c.getClassId();
            if (classId == null) {
                return null;
            }
            return classId.asSingleFqName();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.e$c */
    /* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
    public static final class c extends Lambda implements Function0<KotlinType4> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            FqName fqName = LazyJavaAnnotationDescriptor.this.getFqName();
            if (fqName == null) {
                return ErrorUtils.createErrorType(Intrinsics3.stringPlus("No fqName: ", LazyJavaAnnotationDescriptor.this.c));
            }
            ClassDescriptor classDescriptorMapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(JavaToKotlinClassMapper.a, fqName, LazyJavaAnnotationDescriptor.this.f3327b.getModule().getBuiltIns(), null, 4, null);
            if (classDescriptorMapJavaToKotlin$default == null) {
                d0.e0.p.d.m0.e.a.k0.g gVarResolve = LazyJavaAnnotationDescriptor.this.c.resolve();
                classDescriptorMapJavaToKotlin$default = gVarResolve == null ? null : LazyJavaAnnotationDescriptor.this.f3327b.getComponents().getModuleClassResolver().resolveClass(gVarResolve);
                if (classDescriptorMapJavaToKotlin$default == null) {
                    classDescriptorMapJavaToKotlin$default = LazyJavaAnnotationDescriptor.access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor.this, fqName);
                }
            }
            return classDescriptorMapJavaToKotlin$default.getDefaultType();
        }
    }

    public LazyJavaAnnotationDescriptor(context4 context4Var, d0.e0.p.d.m0.e.a.k0.a aVar, boolean z2) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(aVar, "javaAnnotation");
        this.f3327b = context4Var;
        this.c = aVar;
        this.d = context4Var.getStorageManager().createNullableLazyValue(new b());
        this.e = context4Var.getStorageManager().createLazyValue(new c());
        this.f = context4Var.getComponents().getSourceElementFactory().source(aVar);
        this.g = context4Var.getStorageManager().createLazyValue(new a());
        this.h = aVar.isIdeExternalAnnotation();
        this.i = aVar.isFreshlySupportedTypeUseAnnotation() || z2;
    }

    public static final ClassDescriptor access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor, FqName fqName) {
        ModuleDescriptor2 module = lazyJavaAnnotationDescriptor.f3327b.getModule();
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(fqName)");
        return findClassInModule.findNonGenericClassAcrossDependencies(module, classId, lazyJavaAnnotationDescriptor.f3327b.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    public final d0.e0.p.d.m0.k.v.g<?> a(annotationArguments annotationarguments) {
        d0.e0.p.d.m0.k.v.g<?> aVar;
        if (annotationarguments instanceof annotationArguments6) {
            return ConstantValueFactory.a.createConstantValue(((annotationArguments6) annotationarguments).getValue());
        }
        if (annotationarguments instanceof annotationArguments5) {
            annotationArguments5 annotationarguments5 = (annotationArguments5) annotationarguments;
            ClassId enumClassId = annotationarguments5.getEnumClassId();
            Name entryName = annotationarguments5.getEntryName();
            if (enumClassId == null || entryName == null) {
                return null;
            }
            return new d0.e0.p.d.m0.k.v.j(enumClassId, entryName);
        }
        if (annotationarguments instanceof annotationArguments3) {
            Name name = annotationarguments.getName();
            if (name == null) {
                name = JvmAnnotationNames.f3305b;
            }
            Intrinsics3.checkNotNullExpressionValue(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            List<annotationArguments> elements = ((annotationArguments3) annotationarguments).getElements();
            KotlinType4 type = getType();
            Intrinsics3.checkNotNullExpressionValue(type, "type");
            if (KotlinType2.isError(type)) {
                return null;
            }
            ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(this);
            Intrinsics3.checkNotNull(annotationClass);
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, annotationClass);
            KotlinType type2 = annotationParameterByName != null ? annotationParameterByName.getType() : null;
            if (type2 == null) {
                type2 = this.f3327b.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType("Unknown array element type"));
            }
            Intrinsics3.checkNotNullExpressionValue(type2, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                d0.e0.p.d.m0.k.v.g<?> gVarA = a((annotationArguments) it.next());
                if (gVarA == null) {
                    gVarA = new t();
                }
                arrayList.add(gVarA);
            }
            aVar = ConstantValueFactory.a.createArrayValue(arrayList, type2);
        } else {
            if (!(annotationarguments instanceof annotationArguments2)) {
                if (annotationarguments instanceof annotationArguments4) {
                    return d0.e0.p.d.m0.k.v.r.f3476b.create(this.f3327b.getTypeResolver().transformJavaType(((annotationArguments4) annotationarguments).getReferencedType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)));
                }
                return null;
            }
            aVar = new d0.e0.p.d.m0.k.v.a(new LazyJavaAnnotationDescriptor(this.f3327b, ((annotationArguments2) annotationarguments).getAnnotation(), false, 4, null));
        }
        return aVar;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public Map<Name, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return (Map) storage7.getValue(this.g, this, (KProperty<?>) a[2]);
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public FqName getFqName() {
        return (FqName) storage7.getValue(this.d, this, (KProperty<?>) a[0]);
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.i;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.h;
    }

    public String toString() {
        return DescriptorRenderer2.renderAnnotation$default(DescriptorRenderer2.f3439b, this, null, 2, null);
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public JavaSourceElementFactory getSource() {
        return this.f;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public KotlinType4 getType() {
        return (KotlinType4) storage7.getValue(this.e, this, (KProperty<?>) a[1]);
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(context4 context4Var, d0.e0.p.d.m0.e.a.k0.a aVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, aVar, (i & 4) != 0 ? false : z2);
    }
}
