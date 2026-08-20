package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.EnumC11569c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11577j;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11590w;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12220c0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j */
/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11431j extends AbstractC11435n implements InterfaceC11427f, InterfaceC11441t, InterfaceC11574g {

    /* JADX INFO: renamed from: a */
    public final Class<?> f23046a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$a */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class a extends C12235j implements Function1<Member, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f23047j = new a();

        public a() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(Member.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            C12238m.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$b */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class b extends C12235j implements Function1<Constructor<?>, C11434m> {

        /* JADX INFO: renamed from: j */
        public static final b f23048j = new b();

        public b() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(C11434m.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public final C11434m invoke(Constructor<?> constructor) {
            C12238m.checkNotNullParameter(constructor, "p0");
            return new C11434m(constructor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$c */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class c extends C12235j implements Function1<Member, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final c f23049j = new c();

        public c() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(Member.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            C12238m.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$d */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class d extends C12235j implements Function1<Field, C11437p> {

        /* JADX INFO: renamed from: j */
        public static final d f23050j = new d();

        public d() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(C11437p.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public final C11437p invoke(Field field) {
            C12238m.checkNotNullParameter(field, "p0");
            return new C11437p(field);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$e */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class e extends AbstractC12240o implements Function1<Class<?>, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final e f23051j = new e();

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
            C12238m.checkNotNullExpressionValue(simpleName, "it.simpleName");
            return simpleName.length() == 0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$f */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class f extends AbstractC12240o implements Function1<Class<?>, C11716e> {

        /* JADX INFO: renamed from: j */
        public static final f f23052j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final C11716e invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!C11716e.isValidIdentifier(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return C11716e.identifier(simpleName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$g */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class g extends AbstractC12240o implements Function1<Method, Boolean> {
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
                if (!C11431j.this.isEnum()) {
                    return true;
                }
                C11431j c11431j = C11431j.this;
                C12238m.checkNotNullExpressionValue(method, "method");
                if (!C11431j.access$isEnumValuesOrValueOf(c11431j, method)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.j$h */
    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class h extends C12235j implements Function1<Method, C11440s> {

        /* JADX INFO: renamed from: j */
        public static final h f23053j = new h();

        public h() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(C11440s.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public final C11440s invoke(Method method) {
            C12238m.checkNotNullParameter(method, "p0");
            return new C11440s(method);
        }
    }

    public C11431j(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "klass");
        this.f23046a = cls;
    }

    public static final boolean access$isEnumValuesOrValueOf(C11431j c11431j, Method method) {
        Objects.requireNonNull(c11431j);
        String name = method.getName();
        if (C12238m.areEqual(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            C12238m.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (C12238m.areEqual(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11431j) && C12238m.areEqual(this.f23046a, ((C11431j) obj).f23046a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public C11424c findAnnotation(C11713b c11713b) {
        return InterfaceC11427f.a.findAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public C11713b getFqName() {
        C11713b c11713bAsSingleFqName = C11423b.getClassId(this.f23046a).asSingleFqName();
        C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName, "klass.classId.asSingleFqName()");
        return c11713bAsSingleFqName;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public EnumC11569c0 getLightClassOriginKind() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.InterfaceC11441t
    public int getModifiers() {
        return this.f23046a.getModifiers();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t
    public C11716e getName() {
        C11716e c11716eIdentifier = C11716e.identifier(this.f23046a.getSimpleName());
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(klass.simpleName)");
        return c11716eIdentifier;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public Collection<InterfaceC11577j> getPermittedTypes() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public Collection<InterfaceC11590w> getRecordComponents() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public Collection<InterfaceC11577j> getSupertypes() {
        if (C12238m.areEqual(this.f23046a, Object.class)) {
            return C12147n.emptyList();
        }
        C12220c0 c12220c0 = new C12220c0(2);
        Type genericSuperclass = this.f23046a.getGenericSuperclass();
        c12220c0.add(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.f23046a.getGenericInterfaces();
        C12238m.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        c12220c0.addSpread(genericInterfaces);
        List listListOf = C12147n.listOf(c12220c0.toArray(new Type[c12220c0.size()]));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new C11433l((Type) it.next()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z
    public List<C11445x> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.f23046a.getTypeParameters();
        C12238m.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new C11445x(typeVariable));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public AbstractC11335f1 getVisibility() {
        return InterfaceC11441t.a.getVisibility(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.f23046a.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isAbstract() {
        return InterfaceC11441t.a.isAbstract(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isAnnotationType() {
        return this.f23046a.isAnnotation();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return InterfaceC11427f.a.isDeprecatedInJavaDoc(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isEnum() {
        return this.f23046a.isEnum();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isFinal() {
        return InterfaceC11441t.a.isFinal(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isInterface() {
        return this.f23046a.isInterface();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isRecord() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isSealed() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isStatic() {
        return InterfaceC11441t.a.isStatic(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        C1643a.m860k0(C11431j.class, sb, ": ");
        sb.append(this.f23046a);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<C11424c> getAnnotations() {
        return InterfaceC11427f.a.getAnnotations(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<C11434m> getConstructors() {
        Constructor<?>[] declaredConstructors = this.f23046a.getDeclaredConstructors();
        C12238m.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return C12078q.toList(C12078q.map(C12078q.filterNot(C12141k.asSequence(declaredConstructors), a.f23047j), b.f23048j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.InterfaceC11427f
    public Class<?> getElement() {
        return this.f23046a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<C11437p> getFields() {
        Field[] declaredFields = this.f23046a.getDeclaredFields();
        C12238m.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return C12078q.toList(C12078q.map(C12078q.filterNot(C12141k.asSequence(declaredFields), c.f23049j), d.f23050j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<C11716e> getInnerClassNames() {
        Class<?>[] declaredClasses = this.f23046a.getDeclaredClasses();
        C12238m.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return C12078q.toList(C12078q.mapNotNull(C12078q.filterNot(C12141k.asSequence(declaredClasses), e.f23051j), f.f23052j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<C11440s> getMethods() {
        Method[] declaredMethods = this.f23046a.getDeclaredMethods();
        C12238m.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return C12078q.toList(C12078q.map(C12078q.filter(C12141k.asSequence(declaredMethods), new g()), h.f23053j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public C11431j getOuterClass() {
        Class<?> declaringClass = this.f23046a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new C11431j(declaringClass);
    }
}
