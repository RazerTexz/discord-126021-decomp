package d0.e0.p.d.m0.b.q;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.CompanionObjectMapping;
import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.b.p.FunctionClassKind;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.FqNamesUtil;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.g.SpecialNames;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.c, reason: use source file name */
/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaToKotlinClassMap {
    public static final JavaToKotlinClassMap a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3236b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final ClassId f;
    public static final FqName g;
    public static final ClassId h;
    public static final HashMap<FqNameUnsafe, ClassId> i;
    public static final HashMap<FqNameUnsafe, ClassId> j;
    public static final HashMap<FqNameUnsafe, FqName> k;
    public static final HashMap<FqNameUnsafe, FqName> l;
    public static final List<a> m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.c$a */
    /* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
    public static final class a {
        public final ClassId a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ClassId f3237b;
        public final ClassId c;

        public a(ClassId classId, ClassId classId2, ClassId classId3) {
            Intrinsics3.checkNotNullParameter(classId, "javaClass");
            Intrinsics3.checkNotNullParameter(classId2, "kotlinReadOnly");
            Intrinsics3.checkNotNullParameter(classId3, "kotlinMutable");
            this.a = classId;
            this.f3237b = classId2;
            this.c = classId3;
        }

        public final ClassId component1() {
            return this.a;
        }

        public final ClassId component2() {
            return this.f3237b;
        }

        public final ClassId component3() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && Intrinsics3.areEqual(this.f3237b, aVar.f3237b) && Intrinsics3.areEqual(this.c, aVar.c);
        }

        public final ClassId getJavaClass() {
            return this.a;
        }

        public int hashCode() {
            return this.c.hashCode() + ((this.f3237b.hashCode() + (this.a.hashCode() * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("PlatformMutabilityMapping(javaClass=");
            sbU.append(this.a);
            sbU.append(", kotlinReadOnly=");
            sbU.append(this.f3237b);
            sbU.append(", kotlinMutable=");
            sbU.append(this.c);
            sbU.append(')');
            return sbU.toString();
        }
    }

    static {
        JavaToKotlinClassMap javaToKotlinClassMap = new JavaToKotlinClassMap();
        a = javaToKotlinClassMap;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.k;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append('.');
        sb.append(functionClassKind.getClassNamePrefix());
        f3236b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.m;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.getClassNamePrefix());
        c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.l;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.getClassNamePrefix());
        d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.n;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.getClassNamePrefix());
        e = sb4.toString();
        ClassId classId = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f = classId;
        FqName fqNameAsSingleFqName = classId.asSingleFqName();
        Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        g = fqNameAsSingleFqName;
        ClassId classId2 = ClassId.topLevel(new FqName("kotlin.reflect.KFunction"));
        Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        h = classId2;
        Intrinsics3.checkNotNullExpressionValue(ClassId.topLevel(new FqName("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        javaToKotlinClassMap.e(Class.class);
        i = new HashMap<>();
        j = new HashMap<>();
        k = new HashMap<>();
        l = new HashMap<>();
        ClassId classId3 = ClassId.topLevel(StandardNames.a.I);
        Intrinsics3.checkNotNullExpressionValue(classId3, "topLevel(FqNames.iterable)");
        FqName fqName = StandardNames.a.Q;
        FqName packageFqName = classId3.getPackageFqName();
        FqName packageFqName2 = classId3.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName2, "kotlinReadOnly.packageFqName");
        FqName fqNameTail = FqNamesUtil.tail(fqName, packageFqName2);
        int i2 = 0;
        ClassId classId4 = new ClassId(packageFqName, fqNameTail, false);
        ClassId classId5 = ClassId.topLevel(StandardNames.a.H);
        Intrinsics3.checkNotNullExpressionValue(classId5, "topLevel(FqNames.iterator)");
        FqName fqName2 = StandardNames.a.P;
        FqName packageFqName3 = classId5.getPackageFqName();
        FqName packageFqName4 = classId5.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName4, "kotlinReadOnly.packageFqName");
        ClassId classId6 = new ClassId(packageFqName3, FqNamesUtil.tail(fqName2, packageFqName4), false);
        ClassId classId7 = ClassId.topLevel(StandardNames.a.J);
        Intrinsics3.checkNotNullExpressionValue(classId7, "topLevel(FqNames.collection)");
        FqName fqName3 = StandardNames.a.R;
        FqName packageFqName5 = classId7.getPackageFqName();
        FqName packageFqName6 = classId7.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName6, "kotlinReadOnly.packageFqName");
        ClassId classId8 = new ClassId(packageFqName5, FqNamesUtil.tail(fqName3, packageFqName6), false);
        ClassId classId9 = ClassId.topLevel(StandardNames.a.K);
        Intrinsics3.checkNotNullExpressionValue(classId9, "topLevel(FqNames.list)");
        FqName fqName4 = StandardNames.a.S;
        FqName packageFqName7 = classId9.getPackageFqName();
        FqName packageFqName8 = classId9.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName8, "kotlinReadOnly.packageFqName");
        ClassId classId10 = new ClassId(packageFqName7, FqNamesUtil.tail(fqName4, packageFqName8), false);
        ClassId classId11 = ClassId.topLevel(StandardNames.a.M);
        Intrinsics3.checkNotNullExpressionValue(classId11, "topLevel(FqNames.set)");
        FqName fqName5 = StandardNames.a.U;
        FqName packageFqName9 = classId11.getPackageFqName();
        FqName packageFqName10 = classId11.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName10, "kotlinReadOnly.packageFqName");
        ClassId classId12 = new ClassId(packageFqName9, FqNamesUtil.tail(fqName5, packageFqName10), false);
        ClassId classId13 = ClassId.topLevel(StandardNames.a.L);
        Intrinsics3.checkNotNullExpressionValue(classId13, "topLevel(FqNames.listIterator)");
        FqName fqName6 = StandardNames.a.T;
        FqName packageFqName11 = classId13.getPackageFqName();
        FqName packageFqName12 = classId13.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName12, "kotlinReadOnly.packageFqName");
        ClassId classId14 = new ClassId(packageFqName11, FqNamesUtil.tail(fqName6, packageFqName12), false);
        FqName fqName7 = StandardNames.a.N;
        ClassId classId15 = ClassId.topLevel(fqName7);
        Intrinsics3.checkNotNullExpressionValue(classId15, "topLevel(FqNames.map)");
        FqName fqName8 = StandardNames.a.V;
        FqName packageFqName13 = classId15.getPackageFqName();
        FqName packageFqName14 = classId15.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName14, "kotlinReadOnly.packageFqName");
        ClassId classId16 = new ClassId(packageFqName13, FqNamesUtil.tail(fqName8, packageFqName14), false);
        ClassId classIdCreateNestedClassId = ClassId.topLevel(fqName7).createNestedClassId(StandardNames.a.O.shortName());
        Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        FqName fqName9 = StandardNames.a.W;
        FqName packageFqName15 = classIdCreateNestedClassId.getPackageFqName();
        FqName packageFqName16 = classIdCreateNestedClassId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName16, "kotlinReadOnly.packageFqName");
        List<a> listListOf = Collections2.listOf((Object[]) new a[]{new a(javaToKotlinClassMap.e(Iterable.class), classId3, classId4), new a(javaToKotlinClassMap.e(Iterator.class), classId5, classId6), new a(javaToKotlinClassMap.e(Collection.class), classId7, classId8), new a(javaToKotlinClassMap.e(List.class), classId9, classId10), new a(javaToKotlinClassMap.e(Set.class), classId11, classId12), new a(javaToKotlinClassMap.e(ListIterator.class), classId13, classId14), new a(javaToKotlinClassMap.e(Map.class), classId15, classId16), new a(javaToKotlinClassMap.e(Map.Entry.class), classIdCreateNestedClassId, new ClassId(packageFqName15, FqNamesUtil.tail(fqName9, packageFqName16), false))});
        m = listListOf;
        javaToKotlinClassMap.d(Object.class, StandardNames.a.f3217b);
        javaToKotlinClassMap.d(String.class, StandardNames.a.g);
        javaToKotlinClassMap.d(CharSequence.class, StandardNames.a.f);
        javaToKotlinClassMap.c(Throwable.class, StandardNames.a.f3227s);
        javaToKotlinClassMap.d(Cloneable.class, StandardNames.a.d);
        javaToKotlinClassMap.d(Number.class, StandardNames.a.q);
        javaToKotlinClassMap.c(Comparable.class, StandardNames.a.t);
        javaToKotlinClassMap.d(Enum.class, StandardNames.a.r);
        javaToKotlinClassMap.c(Annotation.class, StandardNames.a.f3230z);
        for (a aVar : listListOf) {
            JavaToKotlinClassMap javaToKotlinClassMap2 = a;
            Objects.requireNonNull(javaToKotlinClassMap2);
            ClassId classIdComponent1 = aVar.component1();
            ClassId classIdComponent2 = aVar.component2();
            ClassId classIdComponent3 = aVar.component3();
            javaToKotlinClassMap2.a(classIdComponent1, classIdComponent2);
            FqName fqNameAsSingleFqName2 = classIdComponent3.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName2, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> map = j;
            FqNameUnsafe unsafe = fqNameAsSingleFqName2.toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
            map.put(unsafe, classIdComponent1);
            FqName fqNameAsSingleFqName3 = classIdComponent2.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName3, "readOnlyClassId.asSingleFqName()");
            FqName fqNameAsSingleFqName4 = classIdComponent3.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName4, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, FqName> map2 = k;
            FqNameUnsafe unsafe2 = classIdComponent3.asSingleFqName().toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe2, "mutableClassId.asSingleFqName().toUnsafe()");
            map2.put(unsafe2, fqNameAsSingleFqName3);
            HashMap<FqNameUnsafe, FqName> map3 = l;
            FqNameUnsafe unsafe3 = fqNameAsSingleFqName3.toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe3, "readOnlyFqName.toUnsafe()");
            map3.put(unsafe3, fqNameAsSingleFqName4);
        }
        JvmPrimitiveType[] jvmPrimitiveTypeArrValues = JvmPrimitiveType.values();
        int i3 = 0;
        while (i3 < 8) {
            JvmPrimitiveType jvmPrimitiveType = jvmPrimitiveTypeArrValues[i3];
            i3++;
            JavaToKotlinClassMap javaToKotlinClassMap3 = a;
            ClassId classId17 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            Intrinsics3.checkNotNullExpressionValue(classId17, "topLevel(jvmType.wrapperFqName)");
            StandardNames standardNames = StandardNames.a;
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            Intrinsics3.checkNotNullExpressionValue(primitiveType, "jvmType.primitiveType");
            ClassId classId18 = ClassId.topLevel(StandardNames.getPrimitiveFqName(primitiveType));
            Intrinsics3.checkNotNullExpressionValue(classId18, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            javaToKotlinClassMap3.a(classId17, classId18);
        }
        for (ClassId classId19 : CompanionObjectMapping.a.allClassesWithIntrinsicCompanions()) {
            JavaToKotlinClassMap javaToKotlinClassMap4 = a;
            StringBuilder sbU = outline.U("kotlin.jvm.internal.");
            sbU.append(classId19.getShortClassName().asString());
            sbU.append("CompanionObject");
            ClassId classId20 = ClassId.topLevel(new FqName(sbU.toString()));
            Intrinsics3.checkNotNullExpressionValue(classId20, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            ClassId classIdCreateNestedClassId2 = classId19.createNestedClassId(SpecialNames.f3425b);
            Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            javaToKotlinClassMap4.a(classId20, classIdCreateNestedClassId2);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            JavaToKotlinClassMap javaToKotlinClassMap5 = a;
            ClassId classId21 = ClassId.topLevel(new FqName(Intrinsics3.stringPlus("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            Intrinsics3.checkNotNullExpressionValue(classId21, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            StandardNames standardNames2 = StandardNames.a;
            javaToKotlinClassMap5.a(classId21, StandardNames.getFunctionClassId(i4));
            javaToKotlinClassMap5.b(new FqName(Intrinsics3.stringPlus(c, Integer.valueOf(i4))), h);
            if (i5 >= 23) {
                break;
            } else {
                i4 = i5;
            }
        }
        while (true) {
            int i6 = i2 + 1;
            FunctionClassKind functionClassKind5 = FunctionClassKind.n;
            String str = functionClassKind5.getPackageFqName().toString() + '.' + functionClassKind5.getClassNamePrefix();
            JavaToKotlinClassMap javaToKotlinClassMap6 = a;
            javaToKotlinClassMap6.b(new FqName(Intrinsics3.stringPlus(str, Integer.valueOf(i2))), h);
            if (i6 >= 22) {
                FqName safe = StandardNames.a.c.toSafe();
                Intrinsics3.checkNotNullExpressionValue(safe, "nothing.toSafe()");
                javaToKotlinClassMap6.b(safe, javaToKotlinClassMap6.e(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    public final void a(ClassId classId, ClassId classId2) {
        HashMap<FqNameUnsafe, ClassId> map = i;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(unsafe, classId2);
        FqName fqNameAsSingleFqName = classId2.asSingleFqName();
        Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "kotlinClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, ClassId> map2 = j;
        FqNameUnsafe unsafe2 = fqNameAsSingleFqName.toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe2, "kotlinFqNameUnsafe.toUnsafe()");
        map2.put(unsafe2, classId);
    }

    public final void b(FqName fqName, ClassId classId) {
        HashMap<FqNameUnsafe, ClassId> map = j;
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(unsafe, classId);
    }

    public final void c(Class<?> cls, FqName fqName) {
        ClassId classIdE = e(cls);
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(kotlinFqName)");
        a(classIdE, classId);
    }

    public final void d(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe, "kotlinFqName.toSafe()");
        c(cls, safe);
    }

    public final ClassId e(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
            Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(clazz.canonicalName))");
            return classId;
        }
        ClassId classIdCreateNestedClassId = e(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
        Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return classIdCreateNestedClassId;
    }

    public final boolean f(FqNameUnsafe fqNameUnsafe, String str) {
        Integer intOrNull;
        String strAsString = fqNameUnsafe.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "kotlinFqName.asString()");
        String strSubstringAfter = Strings4.substringAfter(strAsString, str, "");
        return (strSubstringAfter.length() > 0) && !Strings4.startsWith$default((CharSequence) strSubstringAfter, '0', false, 2, (Object) null) && (intOrNull = StringNumberConversions.toIntOrNull(strSubstringAfter)) != null && intOrNull.intValue() >= 23;
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return g;
    }

    public final List<a> getMutabilityMappings() {
        return m;
    }

    public final boolean isMutable(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> map = k;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> map = l;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(fqNameUnsafe);
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return i.get(fqName.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "kotlinFqName");
        if (!f(fqNameUnsafe, f3236b) && !f(fqNameUnsafe, d)) {
            if (!f(fqNameUnsafe, c) && !f(fqNameUnsafe, e)) {
                return j.get(fqNameUnsafe);
            }
            return h;
        }
        return f;
    }

    public final FqName mutableToReadOnly(FqNameUnsafe fqNameUnsafe) {
        return k.get(fqNameUnsafe);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe fqNameUnsafe) {
        return l.get(fqNameUnsafe);
    }
}
