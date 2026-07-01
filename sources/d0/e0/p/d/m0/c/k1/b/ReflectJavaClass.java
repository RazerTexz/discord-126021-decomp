package d0.e0.p.d.m0.c.k1.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.Visibility2;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationOwner;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaModifierListOwner;
import d0.e0.p.d.m0.e.a.k0.c0;
import d0.e0.p.d.m0.e.a.k0.javaTypes3;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import d0.z.d.SpreadBuilder;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, d0.e0.p.d.m0.e.a.k0.g {
    public final Class<?> a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$a */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class a extends FunctionReference implements Function1<Member, Boolean> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(Member.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            Intrinsics3.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$b */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class b extends FunctionReference implements Function1<Constructor<?>, ReflectJavaConstructor> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ReflectJavaConstructor.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public final ReflectJavaConstructor invoke(Constructor<?> constructor) {
            Intrinsics3.checkNotNullParameter(constructor, "p0");
            return new ReflectJavaConstructor(constructor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$c */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class c extends FunctionReference implements Function1<Member, Boolean> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(Member.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            Intrinsics3.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$d */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class d extends FunctionReference implements Function1<Field, ReflectJavaField> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ReflectJavaField.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public final ReflectJavaField invoke(Field field) {
            Intrinsics3.checkNotNullParameter(field, "p0");
            return new ReflectJavaField(field);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$e */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class e extends Lambda implements Function1<Class<?>, Boolean> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Class<?> cls) {
            return Boolean.valueOf(invoke2(cls));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "it.simpleName");
            return simpleName.length() == 0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$f */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class f extends Lambda implements Function1<Class<?>, Name> {
        public static final f j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Name invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!Name.isValidIdentifier(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return Name.identifier(simpleName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$g */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class g extends Lambda implements Function1<Method, Boolean> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
            return Boolean.valueOf(invoke2(method));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Method method) {
            if (!method.isSynthetic()) {
                if (!ReflectJavaClass.this.isEnum()) {
                    return true;
                }
                ReflectJavaClass reflectJavaClass = ReflectJavaClass.this;
                Intrinsics3.checkNotNullExpressionValue(method, "method");
                if (!ReflectJavaClass.access$isEnumValuesOrValueOf(reflectJavaClass, method)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$h */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class h extends FunctionReference implements Function1<Method, ReflectJavaMethod> {
        public static final h j = new h();

        public h() {
            super(1);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ReflectJavaMethod.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public final ReflectJavaMethod invoke(Method method) {
            Intrinsics3.checkNotNullParameter(method, "p0");
            return new ReflectJavaMethod(method);
        }
    }

    public ReflectJavaClass(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "klass");
        this.a = cls;
    }

    public static final boolean access$isEnumValuesOrValueOf(ReflectJavaClass reflectJavaClass, Method method) {
        Objects.requireNonNull(reflectJavaClass);
        String name = method.getName();
        if (Intrinsics3.areEqual(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (Intrinsics3.areEqual(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaClass) && Intrinsics3.areEqual(this.a, ((ReflectJavaClass) obj).a);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.a.findAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public FqName getFqName() {
        FqName fqNameAsSingleFqName = reflectClassUtil.getClassId(this.a).asSingleFqName();
        Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "klass.classId.asSingleFqName()");
        return fqNameAsSingleFqName;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public c0 getLightClassOriginKind() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.t
    public Name getName() {
        Name nameIdentifier = Name.identifier(this.a.getSimpleName());
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(klass.simpleName)");
        return nameIdentifier;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<javaTypes3> getPermittedTypes() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<d0.e0.p.d.m0.e.a.k0.w> getRecordComponents() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<javaTypes3> getSupertypes() {
        if (Intrinsics3.areEqual(this.a, Object.class)) {
            return Collections2.emptyList();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        Type genericSuperclass = this.a.getGenericSuperclass();
        spreadBuilder.add(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        Intrinsics3.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        spreadBuilder.addSpread(genericInterfaces);
        List listListOf = Collections2.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new ReflectJavaClassifierType((Type) it.next()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.z
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public Visibility2 getVisibility() {
        return ReflectJavaModifierListOwner.a.getVisibility(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.a.isAbstract(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isAnnotationType() {
        return this.a.isAnnotation();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.isDeprecatedInJavaDoc(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isEnum() {
        return this.a.isEnum();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.a.isFinal(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isInterface() {
        return this.a.isInterface();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isRecord() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isSealed() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.a.isStatic(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.k0(ReflectJavaClass.class, sb, ": ");
        sb.append(this.a);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.getAnnotations(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<ReflectJavaConstructor> getConstructors() {
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        Intrinsics3.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return _Sequences2.toList(_Sequences2.map(_Sequences2.filterNot(_Arrays.asSequence(declaredConstructors), a.j), b.j));
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationOwner
    public Class<?> getElement() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<ReflectJavaField> getFields() {
        Field[] declaredFields = this.a.getDeclaredFields();
        Intrinsics3.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return _Sequences2.toList(_Sequences2.map(_Sequences2.filterNot(_Arrays.asSequence(declaredFields), c.j), d.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<Name> getInnerClassNames() {
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        Intrinsics3.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return _Sequences2.toList(_Sequences2.mapNotNull(_Sequences2.filterNot(_Arrays.asSequence(declaredClasses), e.j), f.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<ReflectJavaMethod> getMethods() {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        Intrinsics3.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return _Sequences2.toList(_Sequences2.map(_Sequences2.filter(_Arrays.asSequence(declaredMethods), new g()), h.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public ReflectJavaClass getOuterClass() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new ReflectJavaClass(declaringClass);
    }
}
