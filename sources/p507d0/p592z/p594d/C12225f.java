package p507d0.p592z.p594d;

import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.InterfaceC11213c;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.C12209a;
import p507d0.p592z.C12210b;
import p507d0.p592z.p593c.InterfaceC12211a;
import p507d0.p592z.p593c.InterfaceC12212b;
import p507d0.p592z.p593c.InterfaceC12213c;
import p507d0.p592z.p593c.InterfaceC12214d;

/* JADX INFO: renamed from: d0.z.d.f */
/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12225f implements InterfaceC11230c<Object>, InterfaceC12223e {

    /* JADX INFO: renamed from: j */
    public static final Map<Class<? extends InterfaceC11213c<?>>, Integer> f25282j;

    /* JADX INFO: renamed from: k */
    public static final HashMap<String, String> f25283k;

    /* JADX INFO: renamed from: l */
    public static final HashMap<String, String> f25284l;

    /* JADX INFO: renamed from: m */
    public static final HashMap<String, String> f25285m;

    /* JADX INFO: renamed from: n */
    public static final Map<String, String> f25286n;

    /* JADX INFO: renamed from: o */
    public static final a f25287o = new a(null);

    /* JADX INFO: renamed from: p */
    public final Class<?> f25288p;

    /* JADX INFO: renamed from: d0.z.d.f$a */
    /* JADX INFO: compiled from: ClassReference.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String getClassQualifiedName(Class<?> cls) {
            String str;
            C12238m.checkNotNullParameter(cls, "jClass");
            String strM883w = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str2 = (String) C12225f.f25285m.get(cls.getName());
                return str2 != null ? str2 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            C12238m.checkNotNullExpressionValue(componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) C12225f.f25285m.get(componentType.getName())) != null) {
                strM883w = C1643a.m883w(str, "Array");
            }
            return strM883w != null ? strM883w : "kotlin.Array";
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0043  */
        /* JADX WARN: Code duplicated, block: B:14:0x0049  */
        /* JADX WARN: Code duplicated, block: B:15:0x0065  */
        /* JADX WARN: Instruction removed from duplicated block: B:14:0x0049, please report this as an issue */
        public final String getClassSimpleName(Class<?> cls) {
            String str;
            Constructor<?> enclosingConstructor;
            String strSubstringAfter$default;
            C12238m.checkNotNullParameter(cls, "jClass");
            String strM883w = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        C12238m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        strSubstringAfter$default = C12106w.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default == null) {
                            enclosingConstructor = cls.getEnclosingConstructor();
                            if (enclosingConstructor != null) {
                                C12238m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                                strSubstringAfter$default = C12106w.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                            } else {
                                strSubstringAfter$default = null;
                            }
                        }
                    } else {
                        enclosingConstructor = cls.getEnclosingConstructor();
                        if (enclosingConstructor != null) {
                            C12238m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                            strSubstringAfter$default = C12106w.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                        } else {
                            strSubstringAfter$default = null;
                        }
                    }
                    if (strSubstringAfter$default != null) {
                        return strSubstringAfter$default;
                    }
                    C12238m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    return C12106w.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
                }
                if (!cls.isArray()) {
                    String str2 = (String) C12225f.f25286n.get(cls.getName());
                    return str2 != null ? str2 : cls.getSimpleName();
                }
                Class<?> componentType = cls.getComponentType();
                C12238m.checkNotNullExpressionValue(componentType, "componentType");
                if (componentType.isPrimitive() && (str = (String) C12225f.f25286n.get(componentType.getName())) != null) {
                    strM883w = C1643a.m883w(str, "Array");
                }
                if (strM883w == null) {
                    return "Array";
                }
            }
            return strM883w;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List listListOf = C12147n.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, InterfaceC12211a.class, InterfaceC12212b.class, InterfaceC12213c.class, InterfaceC12214d.class, Function22.class});
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            arrayList.add(C12116o.m10073to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        f25282j = C12136h0.toMap(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put(Constants.LONG, "kotlin.Long");
        map.put("double", "kotlin.Double");
        f25283k = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f25284l = map2;
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
        C12238m.checkNotNullExpressionValue(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            C12238m.checkNotNullExpressionValue(str, "kotlinName");
            sb.append(C12106w.substringAfterLast$default(str, '.', null, 2, null));
            sb.append("CompanionObject");
            Pair pairM10073to = C12116o.m10073to(sb.toString(), str + ".Companion");
            map3.put(pairM10073to.getFirst(), pairM10073to.getSecond());
        }
        for (Map.Entry<Class<? extends InterfaceC11213c<?>>, Integer> entry : f25282j.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f25285m = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), C12106w.substringAfterLast$default((String) entry2.getValue(), '.', null, 2, null));
        }
        f25286n = linkedHashMap;
    }

    public C12225f(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "jClass");
        this.f25288p = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C12225f) && C12238m.areEqual(C12209a.getJavaObjectType(this), C12209a.getJavaObjectType((InterfaceC11230c) obj));
    }

    @Override // p507d0.p592z.p594d.InterfaceC12223e
    public Class<?> getJClass() {
        return this.f25288p;
    }

    @Override // p507d0.p513e0.InterfaceC11230c
    public Object getObjectInstance() {
        throw new C12210b();
    }

    @Override // p507d0.p513e0.InterfaceC11230c
    public String getQualifiedName() {
        return f25287o.getClassQualifiedName(getJClass());
    }

    @Override // p507d0.p513e0.InterfaceC11230c
    public List<InterfaceC11230c<? extends Object>> getSealedSubclasses() {
        throw new C12210b();
    }

    @Override // p507d0.p513e0.InterfaceC11230c
    public String getSimpleName() {
        return f25287o.getClassSimpleName(getJClass());
    }

    public int hashCode() {
        return C12209a.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
