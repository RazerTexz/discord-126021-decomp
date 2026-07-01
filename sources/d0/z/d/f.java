package d0.z.d;

import com.adjust.sdk.Constants;
import d0.t.g0;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Pair;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;

/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements d0.e0.c<Object>, e {
    public static final Map<Class<? extends d0.c<?>>, Integer> j;
    public static final HashMap<String, String> k;
    public static final HashMap<String, String> l;
    public static final HashMap<String, String> m;
    public static final Map<String, String> n;
    public static final f$a o = new f$a(null);
    public final Class<?> p;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List listListOf = d0.t.n.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, d0.z.c.a.class, d0.z.c.b.class, d0.z.c.c.class, d0.z.c.d.class, Function22.class});
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            arrayList.add(d0.o.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        j = h0.toMap(arrayList);
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
        m.checkNotNullExpressionValue(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            m.checkNotNullExpressionValue(str, "kotlinName");
            sb.append(d0.g0.w.substringAfterLast$default(str, '.', null, 2, null));
            sb.append("CompanionObject");
            Pair pair = d0.o.to(sb.toString(), str + ".Companion");
            map3.put(pair.getFirst(), pair.getSecond());
        }
        for (Map$Entry<Class<? extends d0.c<?>>, Integer> map$Entry : j.entrySet()) {
            map3.put(map$Entry.getKey().getName(), "kotlin.Function" + map$Entry.getValue().intValue());
        }
        m = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map3.size()));
        for (Map$Entry map$Entry2 : map3.entrySet()) {
            linkedHashMap.put(map$Entry2.getKey(), d0.g0.w.substringAfterLast$default((String) map$Entry2.getValue(), '.', null, 2, null));
        }
        n = linkedHashMap;
    }

    public f(Class<?> cls) {
        m.checkNotNullParameter(cls, "jClass");
        this.p = cls;
    }

    public static final /* synthetic */ HashMap access$getClassFqNames$cp() {
        return m;
    }

    public static final /* synthetic */ Map access$getSimpleNames$cp() {
        return n;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && m.areEqual(d0.z.a.getJavaObjectType(this), d0.z.a.getJavaObjectType((d0.e0.c) obj));
    }

    @Override // d0.z.d.e
    public Class<?> getJClass() {
        return this.p;
    }

    @Override // d0.e0.c
    public Object getObjectInstance() {
        throw new d0.z.b();
    }

    @Override // d0.e0.c
    public String getQualifiedName() {
        return o.getClassQualifiedName(getJClass());
    }

    @Override // d0.e0.c
    public List<d0.e0.c<? extends Object>> getSealedSubclasses() {
        throw new d0.z.b();
    }

    @Override // d0.e0.c
    public String getSimpleName() {
        return o.getClassSimpleName(getJClass());
    }

    public int hashCode() {
        return d0.z.a.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
