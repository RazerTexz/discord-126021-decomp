package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11283c;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.EnumC11298c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11715d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11718g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.c */
/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11303c {

    /* JADX INFO: renamed from: a */
    public static final C11303c f22614a;

    /* JADX INFO: renamed from: b */
    public static final String f22615b;

    /* JADX INFO: renamed from: c */
    public static final String f22616c;

    /* JADX INFO: renamed from: d */
    public static final String f22617d;

    /* JADX INFO: renamed from: e */
    public static final String f22618e;

    /* JADX INFO: renamed from: f */
    public static final C11712a f22619f;

    /* JADX INFO: renamed from: g */
    public static final C11713b f22620g;

    /* JADX INFO: renamed from: h */
    public static final C11712a f22621h;

    /* JADX INFO: renamed from: i */
    public static final HashMap<C11714c, C11712a> f22622i;

    /* JADX INFO: renamed from: j */
    public static final HashMap<C11714c, C11712a> f22623j;

    /* JADX INFO: renamed from: k */
    public static final HashMap<C11714c, C11713b> f22624k;

    /* JADX INFO: renamed from: l */
    public static final HashMap<C11714c, C11713b> f22625l;

    /* JADX INFO: renamed from: m */
    public static final List<a> f22626m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.c$a */
    /* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C11712a f22627a;

        /* JADX INFO: renamed from: b */
        public final C11712a f22628b;

        /* JADX INFO: renamed from: c */
        public final C11712a f22629c;

        public a(C11712a c11712a, C11712a c11712a2, C11712a c11712a3) {
            C12238m.checkNotNullParameter(c11712a, "javaClass");
            C12238m.checkNotNullParameter(c11712a2, "kotlinReadOnly");
            C12238m.checkNotNullParameter(c11712a3, "kotlinMutable");
            this.f22627a = c11712a;
            this.f22628b = c11712a2;
            this.f22629c = c11712a3;
        }

        public final C11712a component1() {
            return this.f22627a;
        }

        public final C11712a component2() {
            return this.f22628b;
        }

        public final C11712a component3() {
            return this.f22629c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C12238m.areEqual(this.f22627a, aVar.f22627a) && C12238m.areEqual(this.f22628b, aVar.f22628b) && C12238m.areEqual(this.f22629c, aVar.f22629c);
        }

        public final C11712a getJavaClass() {
            return this.f22627a;
        }

        public int hashCode() {
            return this.f22629c.hashCode() + ((this.f22628b.hashCode() + (this.f22627a.hashCode() * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PlatformMutabilityMapping(javaClass=");
            sbM833U.append(this.f22627a);
            sbM833U.append(", kotlinReadOnly=");
            sbM833U.append(this.f22628b);
            sbM833U.append(", kotlinMutable=");
            sbM833U.append(this.f22629c);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    static {
        C11303c c11303c = new C11303c();
        f22614a = c11303c;
        StringBuilder sb = new StringBuilder();
        EnumC11298c enumC11298c = EnumC11298c.f22602k;
        sb.append(enumC11298c.getPackageFqName().toString());
        sb.append('.');
        sb.append(enumC11298c.getClassNamePrefix());
        f22615b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        EnumC11298c enumC11298c2 = EnumC11298c.f22604m;
        sb2.append(enumC11298c2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(enumC11298c2.getClassNamePrefix());
        f22616c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        EnumC11298c enumC11298c3 = EnumC11298c.f22603l;
        sb3.append(enumC11298c3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(enumC11298c3.getClassNamePrefix());
        f22617d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        EnumC11298c enumC11298c4 = EnumC11298c.f22605n;
        sb4.append(enumC11298c4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(enumC11298c4.getClassNamePrefix());
        f22618e = sb4.toString();
        C11712a c11712a = C11712a.topLevel(new C11713b("kotlin.jvm.functions.FunctionN"));
        C12238m.checkNotNullExpressionValue(c11712a, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f22619f = c11712a;
        C11713b c11713bAsSingleFqName = c11712a.asSingleFqName();
        C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f22620g = c11713bAsSingleFqName;
        C11712a c11712a2 = C11712a.topLevel(new C11713b("kotlin.reflect.KFunction"));
        C12238m.checkNotNullExpressionValue(c11712a2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        f22621h = c11712a2;
        C12238m.checkNotNullExpressionValue(C11712a.topLevel(new C11713b("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        c11303c.m9379e(Class.class);
        f22622i = new HashMap<>();
        f22623j = new HashMap<>();
        f22624k = new HashMap<>();
        f22625l = new HashMap<>();
        C11712a c11712a3 = C11712a.topLevel(C11291k.a.f22512I);
        C12238m.checkNotNullExpressionValue(c11712a3, "topLevel(FqNames.iterable)");
        C11713b c11713b = C11291k.a.f22520Q;
        C11713b packageFqName = c11712a3.getPackageFqName();
        C11713b packageFqName2 = c11712a3.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName2, "kotlinReadOnly.packageFqName");
        C11713b c11713bTail = C11715d.tail(c11713b, packageFqName2);
        int i = 0;
        C11712a c11712a4 = new C11712a(packageFqName, c11713bTail, false);
        C11712a c11712a5 = C11712a.topLevel(C11291k.a.f22511H);
        C12238m.checkNotNullExpressionValue(c11712a5, "topLevel(FqNames.iterator)");
        C11713b c11713b2 = C11291k.a.f22519P;
        C11713b packageFqName3 = c11712a5.getPackageFqName();
        C11713b packageFqName4 = c11712a5.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName4, "kotlinReadOnly.packageFqName");
        C11712a c11712a6 = new C11712a(packageFqName3, C11715d.tail(c11713b2, packageFqName4), false);
        C11712a c11712a7 = C11712a.topLevel(C11291k.a.f22513J);
        C12238m.checkNotNullExpressionValue(c11712a7, "topLevel(FqNames.collection)");
        C11713b c11713b3 = C11291k.a.f22521R;
        C11713b packageFqName5 = c11712a7.getPackageFqName();
        C11713b packageFqName6 = c11712a7.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName6, "kotlinReadOnly.packageFqName");
        C11712a c11712a8 = new C11712a(packageFqName5, C11715d.tail(c11713b3, packageFqName6), false);
        C11712a c11712a9 = C11712a.topLevel(C11291k.a.f22514K);
        C12238m.checkNotNullExpressionValue(c11712a9, "topLevel(FqNames.list)");
        C11713b c11713b4 = C11291k.a.f22522S;
        C11713b packageFqName7 = c11712a9.getPackageFqName();
        C11713b packageFqName8 = c11712a9.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName8, "kotlinReadOnly.packageFqName");
        C11712a c11712a10 = new C11712a(packageFqName7, C11715d.tail(c11713b4, packageFqName8), false);
        C11712a c11712a11 = C11712a.topLevel(C11291k.a.f22516M);
        C12238m.checkNotNullExpressionValue(c11712a11, "topLevel(FqNames.set)");
        C11713b c11713b5 = C11291k.a.f22524U;
        C11713b packageFqName9 = c11712a11.getPackageFqName();
        C11713b packageFqName10 = c11712a11.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName10, "kotlinReadOnly.packageFqName");
        C11712a c11712a12 = new C11712a(packageFqName9, C11715d.tail(c11713b5, packageFqName10), false);
        C11712a c11712a13 = C11712a.topLevel(C11291k.a.f22515L);
        C12238m.checkNotNullExpressionValue(c11712a13, "topLevel(FqNames.listIterator)");
        C11713b c11713b6 = C11291k.a.f22523T;
        C11713b packageFqName11 = c11712a13.getPackageFqName();
        C11713b packageFqName12 = c11712a13.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName12, "kotlinReadOnly.packageFqName");
        C11712a c11712a14 = new C11712a(packageFqName11, C11715d.tail(c11713b6, packageFqName12), false);
        C11713b c11713b7 = C11291k.a.f22517N;
        C11712a c11712a15 = C11712a.topLevel(c11713b7);
        C12238m.checkNotNullExpressionValue(c11712a15, "topLevel(FqNames.map)");
        C11713b c11713b8 = C11291k.a.f22525V;
        C11713b packageFqName13 = c11712a15.getPackageFqName();
        C11713b packageFqName14 = c11712a15.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName14, "kotlinReadOnly.packageFqName");
        C11712a c11712a16 = new C11712a(packageFqName13, C11715d.tail(c11713b8, packageFqName14), false);
        C11712a c11712aCreateNestedClassId = C11712a.topLevel(c11713b7).createNestedClassId(C11291k.a.f22518O.shortName());
        C12238m.checkNotNullExpressionValue(c11712aCreateNestedClassId, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        C11713b c11713b9 = C11291k.a.f22526W;
        C11713b packageFqName15 = c11712aCreateNestedClassId.getPackageFqName();
        C11713b packageFqName16 = c11712aCreateNestedClassId.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName16, "kotlinReadOnly.packageFqName");
        List<a> listListOf = C12147n.listOf((Object[]) new a[]{new a(c11303c.m9379e(Iterable.class), c11712a3, c11712a4), new a(c11303c.m9379e(Iterator.class), c11712a5, c11712a6), new a(c11303c.m9379e(Collection.class), c11712a7, c11712a8), new a(c11303c.m9379e(List.class), c11712a9, c11712a10), new a(c11303c.m9379e(Set.class), c11712a11, c11712a12), new a(c11303c.m9379e(ListIterator.class), c11712a13, c11712a14), new a(c11303c.m9379e(Map.class), c11712a15, c11712a16), new a(c11303c.m9379e(Map.Entry.class), c11712aCreateNestedClassId, new C11712a(packageFqName15, C11715d.tail(c11713b9, packageFqName16), false))});
        f22626m = listListOf;
        c11303c.m9378d(Object.class, C11291k.a.f22532b);
        c11303c.m9378d(String.class, C11291k.a.f22542g);
        c11303c.m9378d(CharSequence.class, C11291k.a.f22540f);
        c11303c.m9377c(Throwable.class, C11291k.a.f22564s);
        c11303c.m9378d(Cloneable.class, C11291k.a.f22536d);
        c11303c.m9378d(Number.class, C11291k.a.f22562q);
        c11303c.m9377c(Comparable.class, C11291k.a.f22565t);
        c11303c.m9378d(Enum.class, C11291k.a.f22563r);
        c11303c.m9377c(Annotation.class, C11291k.a.f22571z);
        for (a aVar : listListOf) {
            C11303c c11303c2 = f22614a;
            Objects.requireNonNull(c11303c2);
            C11712a c11712aComponent1 = aVar.component1();
            C11712a c11712aComponent2 = aVar.component2();
            C11712a c11712aComponent3 = aVar.component3();
            c11303c2.m9375a(c11712aComponent1, c11712aComponent2);
            C11713b c11713bAsSingleFqName2 = c11712aComponent3.asSingleFqName();
            C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName2, "mutableClassId.asSingleFqName()");
            HashMap<C11714c, C11712a> map = f22623j;
            C11714c unsafe = c11713bAsSingleFqName2.toUnsafe();
            C12238m.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
            map.put(unsafe, c11712aComponent1);
            C11713b c11713bAsSingleFqName3 = c11712aComponent2.asSingleFqName();
            C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName3, "readOnlyClassId.asSingleFqName()");
            C11713b c11713bAsSingleFqName4 = c11712aComponent3.asSingleFqName();
            C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName4, "mutableClassId.asSingleFqName()");
            HashMap<C11714c, C11713b> map2 = f22624k;
            C11714c unsafe2 = c11712aComponent3.asSingleFqName().toUnsafe();
            C12238m.checkNotNullExpressionValue(unsafe2, "mutableClassId.asSingleFqName().toUnsafe()");
            map2.put(unsafe2, c11713bAsSingleFqName3);
            HashMap<C11714c, C11713b> map3 = f22625l;
            C11714c unsafe3 = c11713bAsSingleFqName3.toUnsafe();
            C12238m.checkNotNullExpressionValue(unsafe3, "readOnlyFqName.toUnsafe()");
            map3.put(unsafe3, c11713bAsSingleFqName4);
        }
        EnumC11840d[] enumC11840dArrValues = EnumC11840d.values();
        int i2 = 0;
        while (i2 < 8) {
            EnumC11840d enumC11840d = enumC11840dArrValues[i2];
            i2++;
            C11303c c11303c3 = f22614a;
            C11712a c11712a17 = C11712a.topLevel(enumC11840d.getWrapperFqName());
            C12238m.checkNotNullExpressionValue(c11712a17, "topLevel(jvmType.wrapperFqName)");
            C11291k c11291k = C11291k.f22488a;
            EnumC11289i primitiveType = enumC11840d.getPrimitiveType();
            C12238m.checkNotNullExpressionValue(primitiveType, "jvmType.primitiveType");
            C11712a c11712a18 = C11712a.topLevel(C11291k.getPrimitiveFqName(primitiveType));
            C12238m.checkNotNullExpressionValue(c11712a18, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            c11303c3.m9375a(c11712a17, c11712a18);
        }
        for (C11712a c11712a19 : C11283c.f22455a.allClassesWithIntrinsicCompanions()) {
            C11303c c11303c4 = f22614a;
            StringBuilder sbM833U = C1643a.m833U("kotlin.jvm.internal.");
            sbM833U.append(c11712a19.getShortClassName().asString());
            sbM833U.append("CompanionObject");
            C11712a c11712a20 = C11712a.topLevel(new C11713b(sbM833U.toString()));
            C12238m.checkNotNullExpressionValue(c11712a20, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            C11712a c11712aCreateNestedClassId2 = c11712a19.createNestedClassId(C11718g.f24093b);
            C12238m.checkNotNullExpressionValue(c11712aCreateNestedClassId2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            c11303c4.m9375a(c11712a20, c11712aCreateNestedClassId2);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            C11303c c11303c5 = f22614a;
            C11712a c11712a21 = C11712a.topLevel(new C11713b(C12238m.stringPlus("kotlin.jvm.functions.Function", Integer.valueOf(i3))));
            C12238m.checkNotNullExpressionValue(c11712a21, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            C11291k c11291k2 = C11291k.f22488a;
            c11303c5.m9375a(c11712a21, C11291k.getFunctionClassId(i3));
            c11303c5.m9376b(new C11713b(C12238m.stringPlus(f22616c, Integer.valueOf(i3))), f22621h);
            if (i4 >= 23) {
                break;
            } else {
                i3 = i4;
            }
        }
        while (true) {
            int i5 = i + 1;
            EnumC11298c enumC11298c5 = EnumC11298c.f22605n;
            String str = enumC11298c5.getPackageFqName().toString() + '.' + enumC11298c5.getClassNamePrefix();
            C11303c c11303c6 = f22614a;
            c11303c6.m9376b(new C11713b(C12238m.stringPlus(str, Integer.valueOf(i))), f22621h);
            if (i5 >= 22) {
                C11713b safe = C11291k.a.f22534c.toSafe();
                C12238m.checkNotNullExpressionValue(safe, "nothing.toSafe()");
                c11303c6.m9376b(safe, c11303c6.m9379e(Void.class));
                return;
            }
            i = i5;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9375a(C11712a c11712a, C11712a c11712a2) {
        HashMap<C11714c, C11712a> map = f22622i;
        C11714c unsafe = c11712a.asSingleFqName().toUnsafe();
        C12238m.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(unsafe, c11712a2);
        C11713b c11713bAsSingleFqName = c11712a2.asSingleFqName();
        C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName, "kotlinClassId.asSingleFqName()");
        HashMap<C11714c, C11712a> map2 = f22623j;
        C11714c unsafe2 = c11713bAsSingleFqName.toUnsafe();
        C12238m.checkNotNullExpressionValue(unsafe2, "kotlinFqNameUnsafe.toUnsafe()");
        map2.put(unsafe2, c11712a);
    }

    /* JADX INFO: renamed from: b */
    public final void m9376b(C11713b c11713b, C11712a c11712a) {
        HashMap<C11714c, C11712a> map = f22623j;
        C11714c unsafe = c11713b.toUnsafe();
        C12238m.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(unsafe, c11712a);
    }

    /* JADX INFO: renamed from: c */
    public final void m9377c(Class<?> cls, C11713b c11713b) {
        C11712a c11712aM9379e = m9379e(cls);
        C11712a c11712a = C11712a.topLevel(c11713b);
        C12238m.checkNotNullExpressionValue(c11712a, "topLevel(kotlinFqName)");
        m9375a(c11712aM9379e, c11712a);
    }

    /* JADX INFO: renamed from: d */
    public final void m9378d(Class<?> cls, C11714c c11714c) {
        C11713b safe = c11714c.toSafe();
        C12238m.checkNotNullExpressionValue(safe, "kotlinFqName.toSafe()");
        m9377c(cls, safe);
    }

    /* JADX INFO: renamed from: e */
    public final C11712a m9379e(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            C11712a c11712a = C11712a.topLevel(new C11713b(cls.getCanonicalName()));
            C12238m.checkNotNullExpressionValue(c11712a, "topLevel(FqName(clazz.canonicalName))");
            return c11712a;
        }
        C11712a c11712aCreateNestedClassId = m9379e(declaringClass).createNestedClassId(C11716e.identifier(cls.getSimpleName()));
        C12238m.checkNotNullExpressionValue(c11712aCreateNestedClassId, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return c11712aCreateNestedClassId;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m9380f(C11714c c11714c, String str) {
        Integer intOrNull;
        String strAsString = c11714c.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "kotlinFqName.asString()");
        String strSubstringAfter = C12106w.substringAfter(strAsString, str, "");
        return (strSubstringAfter.length() > 0) && !C12106w.startsWith$default((CharSequence) strSubstringAfter, '0', false, 2, (Object) null) && (intOrNull = C12102s.toIntOrNull(strSubstringAfter)) != null && intOrNull.intValue() >= 23;
    }

    public final C11713b getFUNCTION_N_FQ_NAME() {
        return f22620g;
    }

    public final List<a> getMutabilityMappings() {
        return f22626m;
    }

    public final boolean isMutable(C11714c c11714c) {
        HashMap<C11714c, C11713b> map = f22624k;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(c11714c);
    }

    public final boolean isReadOnly(C11714c c11714c) {
        HashMap<C11714c, C11713b> map = f22625l;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(c11714c);
    }

    public final C11712a mapJavaToKotlin(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return f22622i.get(c11713b.toUnsafe());
    }

    public final C11712a mapKotlinToJava(C11714c c11714c) {
        C12238m.checkNotNullParameter(c11714c, "kotlinFqName");
        if (!m9380f(c11714c, f22615b) && !m9380f(c11714c, f22617d)) {
            if (!m9380f(c11714c, f22616c) && !m9380f(c11714c, f22618e)) {
                return f22623j.get(c11714c);
            }
            return f22621h;
        }
        return f22619f;
    }

    public final C11713b mutableToReadOnly(C11714c c11714c) {
        return f22624k.get(c11714c);
    }

    public final C11713b readOnlyToMutable(C11714c c11714c) {
        return f22625l.get(c11714c);
    }
}
