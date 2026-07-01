package d0.z.d;

import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Function3;
import d0.Tuples;
import d0.e0.KClass;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.JvmClassMapping;
import d0.z.KotlinReflectionNotSupportedError;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.z.d.f, reason: use source file name */
/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Map<Class<? extends Function3<?>>, Integer> j;
    public static final HashMap<String, String> k;
    public static final HashMap<String, String> l;
    public static final HashMap<String, String> m;
    public static final Map<String, String> n;
    public static final a o = new a(null);
    public final Class<?> p;

    /* JADX INFO: renamed from: d0.z.d.f$a */
    /* JADX INFO: compiled from: ClassReference.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String getClassQualifiedName(Class<?> cls) {
            String str;
            Intrinsics3.checkNotNullParameter(cls, "jClass");
            String strW = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str2 = (String) ClassReference.m.get(cls.getName());
                return str2 != null ? str2 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            Intrinsics3.checkNotNullExpressionValue(componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) ClassReference.m.get(componentType.getName())) != null) {
                strW = outline.w(str, "Array");
            }
            return strW != null ? strW : "kotlin.Array";
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0043  */
        /* JADX WARN: Code duplicated, block: B:14:0x0049  */
        /* JADX WARN: Code duplicated, block: B:15:0x0065  */
        /* JADX WARN: Instruction removed from duplicated block: B:14:0x0049, please report this as an issue */
        public final String getClassSimpleName(Class<?> cls) {
            String str;
            Constructor<?> enclosingConstructor;
            String strSubstringAfter$default;
            Intrinsics3.checkNotNullParameter(cls, "jClass");
            String strW = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        strSubstringAfter$default = Strings4.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default == null) {
                            enclosingConstructor = cls.getEnclosingConstructor();
                            if (enclosingConstructor != null) {
                                Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                                strSubstringAfter$default = Strings4.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                            } else {
                                strSubstringAfter$default = null;
                            }
                        }
                    } else {
                        enclosingConstructor = cls.getEnclosingConstructor();
                        if (enclosingConstructor != null) {
                            Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                            strSubstringAfter$default = Strings4.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                        } else {
                            strSubstringAfter$default = null;
                        }
                    }
                    if (strSubstringAfter$default != null) {
                        return strSubstringAfter$default;
                    }
                    Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    return Strings4.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
                }
                if (!cls.isArray()) {
                    String str2 = (String) ClassReference.n.get(cls.getName());
                    return str2 != null ? str2 : cls.getSimpleName();
                }
                Class<?> componentType = cls.getComponentType();
                Intrinsics3.checkNotNullExpressionValue(componentType, "componentType");
                if (componentType.isPrimitive() && (str = (String) ClassReference.n.get(componentType.getName())) != null) {
                    strW = outline.w(str, "Array");
                }
                if (strW == null) {
                    return "Array";
                }
            }
            return strW;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List listListOf = Collections2.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, kotlin.jvm.functions.Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, d0.z.c.a.class, d0.z.c.b.class, d0.z.c.c.class, d0.z.c.d.class, Function22.class});
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(Tuples.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        j = Maps6.toMap(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put(Constants.LONG, "kotlin.Long");
        map.put("double", "kotlin.Double");
        k = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        l = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics3.checkNotNullExpressionValue(str, "kotlinName");
            sb.append(Strings4.substringAfterLast$default(str, '.', null, 2, null));
            sb.append("CompanionObject");
            Tuples2 tuples2 = Tuples.to(sb.toString(), str + ".Companion");
            map3.put(tuples2.getFirst(), tuples2.getSecond());
        }
        for (Map.Entry<Class<? extends Function3<?>>, Integer> entry : j.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        m = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), Strings4.substringAfterLast$default((String) entry2.getValue(), '.', null, 2, null));
        }
        n = linkedHashMap;
    }

    public ClassReference(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        this.p = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Intrinsics3.areEqual(JvmClassMapping.getJavaObjectType(this), JvmClassMapping.getJavaObjectType((KClass) obj));
    }

    @Override // d0.z.d.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.p;
    }

    @Override // d0.e0.KClass
    public Object getObjectInstance() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // d0.e0.KClass
    public String getQualifiedName() {
        return o.getClassQualifiedName(getJClass());
    }

    @Override // d0.e0.KClass
    public List<KClass<? extends Object>> getSealedSubclasses() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // d0.e0.KClass
    public String getSimpleName() {
        return o.getClassSimpleName(getJClass());
    }

    public int hashCode() {
        return JvmClassMapping.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
