package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.k$a;
import d0.g0.s;
import d0.g0.w;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3236b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final d0.e0.p.d.m0.g.a f;
    public static final d0.e0.p.d.m0.g.b g;
    public static final d0.e0.p.d.m0.g.a h;
    public static final HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.a> i;
    public static final HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.a> j;
    public static final HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.b> k;
    public static final HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.b> l;
    public static final List<c$a> m;

    static {
        c cVar = new c();
        a = cVar;
        StringBuilder sb = new StringBuilder();
        d0.e0.p.d.m0.b.p.c cVar2 = d0.e0.p.d.m0.b.p.c.k;
        sb.append(cVar2.getPackageFqName().toString());
        sb.append('.');
        sb.append(cVar2.getClassNamePrefix());
        f3236b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        d0.e0.p.d.m0.b.p.c cVar3 = d0.e0.p.d.m0.b.p.c.m;
        sb2.append(cVar3.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(cVar3.getClassNamePrefix());
        c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        d0.e0.p.d.m0.b.p.c cVar4 = d0.e0.p.d.m0.b.p.c.l;
        sb3.append(cVar4.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(cVar4.getClassNamePrefix());
        d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        d0.e0.p.d.m0.b.p.c cVar5 = d0.e0.p.d.m0.b.p.c.n;
        sb4.append(cVar5.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(cVar5.getClassNamePrefix());
        e = sb4.toString();
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.functions.FunctionN"));
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f = aVar;
        d0.e0.p.d.m0.g.b bVarAsSingleFqName = aVar.asSingleFqName();
        d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        g = bVarAsSingleFqName;
        d0.e0.p.d.m0.g.a aVar2 = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.reflect.KFunction"));
        d0.z.d.m.checkNotNullExpressionValue(aVar2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        h = aVar2;
        d0.z.d.m.checkNotNullExpressionValue(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        cVar.e(Class.class);
        i = new HashMap<>();
        j = new HashMap<>();
        k = new HashMap<>();
        l = new HashMap<>();
        d0.e0.p.d.m0.g.a aVar3 = d0.e0.p.d.m0.g.a.topLevel(k$a.I);
        d0.z.d.m.checkNotNullExpressionValue(aVar3, "topLevel(FqNames.iterable)");
        d0.e0.p.d.m0.g.b bVar = k$a.Q;
        d0.e0.p.d.m0.g.b packageFqName = aVar3.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName2 = aVar3.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName2, "kotlinReadOnly.packageFqName");
        d0.e0.p.d.m0.g.b bVarTail = d0.e0.p.d.m0.g.d.tail(bVar, packageFqName2);
        int i2 = 0;
        d0.e0.p.d.m0.g.a aVar4 = new d0.e0.p.d.m0.g.a(packageFqName, bVarTail, false);
        d0.e0.p.d.m0.g.a aVar5 = d0.e0.p.d.m0.g.a.topLevel(k$a.H);
        d0.z.d.m.checkNotNullExpressionValue(aVar5, "topLevel(FqNames.iterator)");
        d0.e0.p.d.m0.g.b bVar2 = k$a.P;
        d0.e0.p.d.m0.g.b packageFqName3 = aVar5.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName4 = aVar5.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName4, "kotlinReadOnly.packageFqName");
        d0.e0.p.d.m0.g.a aVar6 = new d0.e0.p.d.m0.g.a(packageFqName3, d0.e0.p.d.m0.g.d.tail(bVar2, packageFqName4), false);
        d0.e0.p.d.m0.g.a aVar7 = d0.e0.p.d.m0.g.a.topLevel(k$a.J);
        d0.z.d.m.checkNotNullExpressionValue(aVar7, "topLevel(FqNames.collection)");
        d0.e0.p.d.m0.g.b bVar3 = k$a.R;
        d0.e0.p.d.m0.g.b packageFqName5 = aVar7.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName6 = aVar7.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName6, "kotlinReadOnly.packageFqName");
        d0.e0.p.d.m0.g.a aVar8 = new d0.e0.p.d.m0.g.a(packageFqName5, d0.e0.p.d.m0.g.d.tail(bVar3, packageFqName6), false);
        d0.e0.p.d.m0.g.a aVar9 = d0.e0.p.d.m0.g.a.topLevel(k$a.K);
        d0.z.d.m.checkNotNullExpressionValue(aVar9, "topLevel(FqNames.list)");
        d0.e0.p.d.m0.g.b bVar4 = k$a.S;
        d0.e0.p.d.m0.g.b packageFqName7 = aVar9.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName8 = aVar9.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName8, "kotlinReadOnly.packageFqName");
        d0.e0.p.d.m0.g.a aVar10 = new d0.e0.p.d.m0.g.a(packageFqName7, d0.e0.p.d.m0.g.d.tail(bVar4, packageFqName8), false);
        d0.e0.p.d.m0.g.a aVar11 = d0.e0.p.d.m0.g.a.topLevel(k$a.M);
        d0.z.d.m.checkNotNullExpressionValue(aVar11, "topLevel(FqNames.set)");
        d0.e0.p.d.m0.g.b bVar5 = k$a.U;
        d0.e0.p.d.m0.g.b packageFqName9 = aVar11.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName10 = aVar11.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName10, "kotlinReadOnly.packageFqName");
        d0.e0.p.d.m0.g.a aVar12 = new d0.e0.p.d.m0.g.a(packageFqName9, d0.e0.p.d.m0.g.d.tail(bVar5, packageFqName10), false);
        d0.e0.p.d.m0.g.a aVar13 = d0.e0.p.d.m0.g.a.topLevel(k$a.L);
        d0.z.d.m.checkNotNullExpressionValue(aVar13, "topLevel(FqNames.listIterator)");
        d0.e0.p.d.m0.g.b bVar6 = k$a.T;
        d0.e0.p.d.m0.g.b packageFqName11 = aVar13.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName12 = aVar13.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName12, "kotlinReadOnly.packageFqName");
        d0.e0.p.d.m0.g.a aVar14 = new d0.e0.p.d.m0.g.a(packageFqName11, d0.e0.p.d.m0.g.d.tail(bVar6, packageFqName12), false);
        d0.e0.p.d.m0.g.b bVar7 = k$a.N;
        d0.e0.p.d.m0.g.a aVar15 = d0.e0.p.d.m0.g.a.topLevel(bVar7);
        d0.z.d.m.checkNotNullExpressionValue(aVar15, "topLevel(FqNames.map)");
        d0.e0.p.d.m0.g.b bVar8 = k$a.V;
        d0.e0.p.d.m0.g.b packageFqName13 = aVar15.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName14 = aVar15.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName14, "kotlinReadOnly.packageFqName");
        d0.e0.p.d.m0.g.a aVar16 = new d0.e0.p.d.m0.g.a(packageFqName13, d0.e0.p.d.m0.g.d.tail(bVar8, packageFqName14), false);
        d0.e0.p.d.m0.g.a aVarCreateNestedClassId = d0.e0.p.d.m0.g.a.topLevel(bVar7).createNestedClassId(k$a.O.shortName());
        d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        d0.e0.p.d.m0.g.b bVar9 = k$a.W;
        d0.e0.p.d.m0.g.b packageFqName15 = aVarCreateNestedClassId.getPackageFqName();
        d0.e0.p.d.m0.g.b packageFqName16 = aVarCreateNestedClassId.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName16, "kotlinReadOnly.packageFqName");
        List<c$a> listListOf = d0.t.n.listOf((Object[]) new c$a[]{new c$a(access$classId(cVar, Iterable.class), aVar3, aVar4), new c$a(access$classId(cVar, Iterator.class), aVar5, aVar6), new c$a(access$classId(cVar, Collection.class), aVar7, aVar8), new c$a(access$classId(cVar, List.class), aVar9, aVar10), new c$a(access$classId(cVar, Set.class), aVar11, aVar12), new c$a(access$classId(cVar, ListIterator.class), aVar13, aVar14), new c$a(access$classId(cVar, Map.class), aVar15, aVar16), new c$a(access$classId(cVar, Map$Entry.class), aVarCreateNestedClassId, new d0.e0.p.d.m0.g.a(packageFqName15, d0.e0.p.d.m0.g.d.tail(bVar9, packageFqName16), false))});
        m = listListOf;
        cVar.d(Object.class, k$a.f3217b);
        cVar.d(String.class, k$a.g);
        cVar.d(CharSequence.class, k$a.f);
        cVar.c(Throwable.class, k$a.f3227s);
        cVar.d(Cloneable.class, k$a.d);
        cVar.d(Number.class, k$a.q);
        cVar.c(Comparable.class, k$a.t);
        cVar.d(Enum.class, k$a.r);
        cVar.c(Annotation.class, k$a.f3230z);
        for (c$a c_a : listListOf) {
            c cVar6 = a;
            Objects.requireNonNull(cVar6);
            d0.e0.p.d.m0.g.a aVarComponent1 = c_a.component1();
            d0.e0.p.d.m0.g.a aVarComponent2 = c_a.component2();
            d0.e0.p.d.m0.g.a aVarComponent3 = c_a.component3();
            cVar6.a(aVarComponent1, aVarComponent2);
            d0.e0.p.d.m0.g.b bVarAsSingleFqName2 = aVarComponent3.asSingleFqName();
            d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName2, "mutableClassId.asSingleFqName()");
            HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.a> map = j;
            d0.e0.p.d.m0.g.c unsafe = bVarAsSingleFqName2.toUnsafe();
            d0.z.d.m.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
            map.put(unsafe, aVarComponent1);
            d0.e0.p.d.m0.g.b bVarAsSingleFqName3 = aVarComponent2.asSingleFqName();
            d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName3, "readOnlyClassId.asSingleFqName()");
            d0.e0.p.d.m0.g.b bVarAsSingleFqName4 = aVarComponent3.asSingleFqName();
            d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName4, "mutableClassId.asSingleFqName()");
            HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.b> map2 = k;
            d0.e0.p.d.m0.g.c unsafe2 = aVarComponent3.asSingleFqName().toUnsafe();
            d0.z.d.m.checkNotNullExpressionValue(unsafe2, "mutableClassId.asSingleFqName().toUnsafe()");
            map2.put(unsafe2, bVarAsSingleFqName3);
            HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.b> map3 = l;
            d0.e0.p.d.m0.g.c unsafe3 = bVarAsSingleFqName3.toUnsafe();
            d0.z.d.m.checkNotNullExpressionValue(unsafe3, "readOnlyFqName.toUnsafe()");
            map3.put(unsafe3, bVarAsSingleFqName4);
        }
        d0.e0.p.d.m0.k.y.d[] dVarArrValues = d0.e0.p.d.m0.k.y.d.values();
        int i3 = 0;
        while (i3 < 8) {
            d0.e0.p.d.m0.k.y.d dVar = dVarArrValues[i3];
            i3++;
            c cVar7 = a;
            d0.e0.p.d.m0.g.a aVar17 = d0.e0.p.d.m0.g.a.topLevel(dVar.getWrapperFqName());
            d0.z.d.m.checkNotNullExpressionValue(aVar17, "topLevel(jvmType.wrapperFqName)");
            d0.e0.p.d.m0.b.k kVar = d0.e0.p.d.m0.b.k.a;
            d0.e0.p.d.m0.b.i primitiveType = dVar.getPrimitiveType();
            d0.z.d.m.checkNotNullExpressionValue(primitiveType, "jvmType.primitiveType");
            d0.e0.p.d.m0.g.a aVar18 = d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.b.k.getPrimitiveFqName(primitiveType));
            d0.z.d.m.checkNotNullExpressionValue(aVar18, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            cVar7.a(aVar17, aVar18);
        }
        for (d0.e0.p.d.m0.g.a aVar19 : d0.e0.p.d.m0.b.c.a.allClassesWithIntrinsicCompanions()) {
            c cVar8 = a;
            StringBuilder sbU = b.d.b.a.a.U("kotlin.jvm.internal.");
            sbU.append(aVar19.getShortClassName().asString());
            sbU.append("CompanionObject");
            d0.e0.p.d.m0.g.a aVar20 = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b(sbU.toString()));
            d0.z.d.m.checkNotNullExpressionValue(aVar20, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            d0.e0.p.d.m0.g.a aVarCreateNestedClassId2 = aVar19.createNestedClassId(d0.e0.p.d.m0.g.g.f3425b);
            d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            cVar8.a(aVar20, aVarCreateNestedClassId2);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            c cVar9 = a;
            d0.e0.p.d.m0.g.a aVar21 = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b(d0.z.d.m.stringPlus("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            d0.z.d.m.checkNotNullExpressionValue(aVar21, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            d0.e0.p.d.m0.b.k kVar2 = d0.e0.p.d.m0.b.k.a;
            cVar9.a(aVar21, d0.e0.p.d.m0.b.k.getFunctionClassId(i4));
            cVar9.b(new d0.e0.p.d.m0.g.b(d0.z.d.m.stringPlus(c, Integer.valueOf(i4))), h);
            if (i5 >= 23) {
                break;
            } else {
                i4 = i5;
            }
        }
        while (true) {
            int i6 = i2 + 1;
            d0.e0.p.d.m0.b.p.c cVar10 = d0.e0.p.d.m0.b.p.c.n;
            String str = cVar10.getPackageFqName().toString() + '.' + cVar10.getClassNamePrefix();
            c cVar11 = a;
            cVar11.b(new d0.e0.p.d.m0.g.b(d0.z.d.m.stringPlus(str, Integer.valueOf(i2))), h);
            if (i6 >= 22) {
                d0.e0.p.d.m0.g.b safe = k$a.c.toSafe();
                d0.z.d.m.checkNotNullExpressionValue(safe, "nothing.toSafe()");
                cVar11.b(safe, cVar11.e(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.a access$classId(c cVar, Class cls) {
        return cVar.e(cls);
    }

    public final void a(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.a aVar2) {
        HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.a> map = i;
        d0.e0.p.d.m0.g.c unsafe = aVar.asSingleFqName().toUnsafe();
        d0.z.d.m.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(unsafe, aVar2);
        d0.e0.p.d.m0.g.b bVarAsSingleFqName = aVar2.asSingleFqName();
        d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "kotlinClassId.asSingleFqName()");
        HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.a> map2 = j;
        d0.e0.p.d.m0.g.c unsafe2 = bVarAsSingleFqName.toUnsafe();
        d0.z.d.m.checkNotNullExpressionValue(unsafe2, "kotlinFqNameUnsafe.toUnsafe()");
        map2.put(unsafe2, aVar);
    }

    public final void b(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.g.a aVar) {
        HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.a> map = j;
        d0.e0.p.d.m0.g.c unsafe = bVar.toUnsafe();
        d0.z.d.m.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(unsafe, aVar);
    }

    public final void c(Class<?> cls, d0.e0.p.d.m0.g.b bVar) {
        d0.e0.p.d.m0.g.a aVarE = e(cls);
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(bVar);
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(kotlinFqName)");
        a(aVarE, aVar);
    }

    public final void d(Class<?> cls, d0.e0.p.d.m0.g.c cVar) {
        d0.e0.p.d.m0.g.b safe = cVar.toSafe();
        d0.z.d.m.checkNotNullExpressionValue(safe, "kotlinFqName.toSafe()");
        c(cls, safe);
    }

    public final d0.e0.p.d.m0.g.a e(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b(cls.getCanonicalName()));
            d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(FqName(clazz.canonicalName))");
            return aVar;
        }
        d0.e0.p.d.m0.g.a aVarCreateNestedClassId = e(declaringClass).createNestedClassId(d0.e0.p.d.m0.g.e.identifier(cls.getSimpleName()));
        d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return aVarCreateNestedClassId;
    }

    public final boolean f(d0.e0.p.d.m0.g.c cVar, String str) {
        Integer intOrNull;
        String strAsString = cVar.asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "kotlinFqName.asString()");
        String strSubstringAfter = w.substringAfter(strAsString, str, "");
        return (strSubstringAfter.length() > 0) && !w.startsWith$default((CharSequence) strSubstringAfter, '0', false, 2, (Object) null) && (intOrNull = s.toIntOrNull(strSubstringAfter)) != null && intOrNull.intValue() >= 23;
    }

    public final d0.e0.p.d.m0.g.b getFUNCTION_N_FQ_NAME() {
        return g;
    }

    public final List<c$a> getMutabilityMappings() {
        return m;
    }

    public final boolean isMutable(d0.e0.p.d.m0.g.c cVar) {
        HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.b> map = k;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(cVar);
    }

    public final boolean isReadOnly(d0.e0.p.d.m0.g.c cVar) {
        HashMap<d0.e0.p.d.m0.g.c, d0.e0.p.d.m0.g.b> map = l;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(cVar);
    }

    public final d0.e0.p.d.m0.g.a mapJavaToKotlin(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return i.get(bVar.toUnsafe());
    }

    public final d0.e0.p.d.m0.g.a mapKotlinToJava(d0.e0.p.d.m0.g.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "kotlinFqName");
        if (!f(cVar, f3236b) && !f(cVar, d)) {
            if (!f(cVar, c) && !f(cVar, e)) {
                return j.get(cVar);
            }
            return h;
        }
        return f;
    }

    public final d0.e0.p.d.m0.g.b mutableToReadOnly(d0.e0.p.d.m0.g.c cVar) {
        return k.get(cVar);
    }

    public final d0.e0.p.d.m0.g.b readOnlyToMutable(d0.e0.p.d.m0.g.c cVar) {
        return l.get(cVar);
    }
}
