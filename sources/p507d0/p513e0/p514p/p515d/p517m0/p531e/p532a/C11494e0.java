package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11662w;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0 */
/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11494e0 {

    /* JADX INFO: renamed from: a */
    public static final a f23195a = new a(null);

    /* JADX INFO: renamed from: b */
    public static final List<a.C13309a> f23196b;

    /* JADX INFO: renamed from: c */
    public static final List<String> f23197c;

    /* JADX INFO: renamed from: d */
    public static final Map<a.C13309a, c> f23198d;

    /* JADX INFO: renamed from: e */
    public static final Map<String, c> f23199e;

    /* JADX INFO: renamed from: f */
    public static final Set<C11716e> f23200f;

    /* JADX INFO: renamed from: g */
    public static final Set<String> f23201g;

    /* JADX INFO: renamed from: h */
    public static final a.C13309a f23202h;

    /* JADX INFO: renamed from: i */
    public static final Map<a.C13309a, C11716e> f23203i;

    /* JADX INFO: renamed from: j */
    public static final Map<String, C11716e> f23204j;

    /* JADX INFO: renamed from: k */
    public static final List<C11716e> f23205k;

    /* JADX INFO: renamed from: l */
    public static final Map<C11716e, List<C11716e>> f23206l;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0$a */
    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        public static final class C13309a {

            /* JADX INFO: renamed from: a */
            public final C11716e f23207a;

            /* JADX INFO: renamed from: b */
            public final String f23208b;

            public C13309a(C11716e c11716e, String str) {
                C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkNotNullParameter(str, "signature");
                this.f23207a = c11716e;
                this.f23208b = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C13309a)) {
                    return false;
                }
                C13309a c13309a = (C13309a) obj;
                return C12238m.areEqual(this.f23207a, c13309a.f23207a) && C12238m.areEqual(this.f23208b, c13309a.f23208b);
            }

            public final C11716e getName() {
                return this.f23207a;
            }

            public final String getSignature() {
                return this.f23208b;
            }

            public int hashCode() {
                return this.f23208b.hashCode() + (this.f23207a.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("NameAndSignature(name=");
                sbM833U.append(this.f23207a);
                sbM833U.append(", signature=");
                return C1643a.m820H(sbM833U, this.f23208b, ')');
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final C13309a access$method(a aVar, String str, String str2, String str3, String str4) {
            Objects.requireNonNull(aVar);
            C11716e c11716eIdentifier = C11716e.identifier(str2);
            C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(name)");
            return new C13309a(c11716eIdentifier, C11662w.f23636a.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return C11494e0.f23197c;
        }

        public final Set<C11716e> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return C11494e0.f23200f;
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return C11494e0.f23201g;
        }

        public final Map<C11716e, List<C11716e>> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return C11494e0.f23206l;
        }

        public final List<C11716e> getORIGINAL_SHORT_NAMES() {
            return C11494e0.f23205k;
        }

        public final C13309a getREMOVE_AT_NAME_AND_SIGNATURE() {
            return C11494e0.f23202h;
        }

        public final Map<String, c> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return C11494e0.f23199e;
        }

        public final Map<String, C11716e> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return C11494e0.f23204j;
        }

        public final b getSpecialSignatureInfo(String str) {
            C12238m.checkNotNullParameter(str, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str)) {
                return b.ONE_COLLECTION_PARAMETER;
            }
            return ((c) C12136h0.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == c.f23213j ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0$b */
    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        b(String str, boolean z2) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z2;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            b[] bVarArr = new b[bVarArrValuesCustom.length];
            System.arraycopy(bVarArrValuesCustom, 0, bVarArr, 0, bVarArrValuesCustom.length);
            return bVarArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0$c */
    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class c {

        /* JADX INFO: renamed from: j */
        public static final c f23213j;

        /* JADX INFO: renamed from: k */
        public static final c f23214k;

        /* JADX INFO: renamed from: l */
        public static final c f23215l;

        /* JADX INFO: renamed from: m */
        public static final c f23216m;

        /* JADX INFO: renamed from: n */
        public static final /* synthetic */ c[] f23217n;
        private final Object defaultValue;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0$c$a */
        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        public static final class a extends c {
            public a(String str, int i) {
                super(str, i, null, null);
            }
        }

        static {
            c cVar = new c("NULL", 0, null);
            f23213j = cVar;
            c cVar2 = new c("INDEX", 1, -1);
            f23214k = cVar2;
            c cVar3 = new c("FALSE", 2, Boolean.FALSE);
            f23215l = cVar3;
            a aVar = new a("MAP_GET_OR_DEFAULT", 3);
            f23216m = aVar;
            f23217n = new c[]{cVar, cVar2, cVar3, aVar};
        }

        public c(String str, int i, Object obj) {
            super(str, i);
            this.defaultValue = obj;
        }

        public static c valueOf(String str) {
            C12238m.checkNotNullParameter(str, "value");
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            c[] cVarArr = f23217n;
            c[] cVarArr2 = new c[cVarArr.length];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
            return cVarArr2;
        }

        public c(String str, int i, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            super(str, i);
            this.defaultValue = obj;
        }
    }

    static {
        Set<String> of = C12148n0.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            a aVar = f23195a;
            String desc = EnumC11840d.BOOLEAN.getDesc();
            C12238m.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(a.access$method(aVar, "java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f23196b = arrayList;
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C13309a) it.next()).getSignature());
        }
        f23197c = arrayList2;
        List<a.C13309a> list = f23196b;
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.C13309a) it2.next()).getName().asString());
        }
        C11662w c11662w = C11662w.f23636a;
        a aVar2 = f23195a;
        String strJavaUtil = c11662w.javaUtil("Collection");
        EnumC11840d enumC11840d = EnumC11840d.BOOLEAN;
        String desc2 = enumC11840d.getDesc();
        C12238m.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        a.C13309a c13309aAccess$method = a.access$method(aVar2, strJavaUtil, "contains", "Ljava/lang/Object;", desc2);
        c cVar = c.f23215l;
        String strJavaUtil2 = c11662w.javaUtil("Collection");
        String desc3 = enumC11840d.getDesc();
        C12238m.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String strJavaUtil3 = c11662w.javaUtil("Map");
        String desc4 = enumC11840d.getDesc();
        C12238m.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String strJavaUtil4 = c11662w.javaUtil("Map");
        String desc5 = enumC11840d.getDesc();
        C12238m.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String strJavaUtil5 = c11662w.javaUtil("Map");
        String desc6 = enumC11840d.getDesc();
        C12238m.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        a.C13309a c13309aAccess$method2 = a.access$method(aVar2, c11662w.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.f23213j;
        String strJavaUtil6 = c11662w.javaUtil("List");
        EnumC11840d enumC11840d2 = EnumC11840d.INT;
        String desc7 = enumC11840d2.getDesc();
        C12238m.checkNotNullExpressionValue(desc7, "INT.desc");
        a.C13309a c13309aAccess$method3 = a.access$method(aVar2, strJavaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        c cVar3 = c.f23214k;
        String strJavaUtil7 = c11662w.javaUtil("List");
        String desc8 = enumC11840d2.getDesc();
        C12238m.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<a.C13309a, c> mapMapOf = C12136h0.mapOf(C12116o.m10073to(c13309aAccess$method, cVar), C12116o.m10073to(a.access$method(aVar2, strJavaUtil2, "remove", "Ljava/lang/Object;", desc3), cVar), C12116o.m10073to(a.access$method(aVar2, strJavaUtil3, "containsKey", "Ljava/lang/Object;", desc4), cVar), C12116o.m10073to(a.access$method(aVar2, strJavaUtil4, "containsValue", "Ljava/lang/Object;", desc5), cVar), C12116o.m10073to(a.access$method(aVar2, strJavaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), cVar), C12116o.m10073to(a.access$method(aVar2, c11662w.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.f23216m), C12116o.m10073to(c13309aAccess$method2, cVar2), C12116o.m10073to(a.access$method(aVar2, c11662w.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2), C12116o.m10073to(c13309aAccess$method3, cVar3), C12116o.m10073to(a.access$method(aVar2, strJavaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), cVar3));
        f23198d = mapMapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(mapMapOf.size()));
        Iterator<T> it3 = mapMapOf.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C13309a) entry.getKey()).getSignature(), entry.getValue());
        }
        f23199e = linkedHashMap;
        Set setPlus = C12150o0.plus((Set) f23198d.keySet(), (Iterable) f23196b);
        ArrayList arrayList4 = new ArrayList(C12149o.collectionSizeOrDefault(setPlus, 10));
        Iterator it4 = setPlus.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((a.C13309a) it4.next()).getName());
        }
        f23200f = C12163u.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(C12149o.collectionSizeOrDefault(setPlus, 10));
        Iterator it5 = setPlus.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((a.C13309a) it5.next()).getSignature());
        }
        f23201g = C12163u.toSet(arrayList5);
        a aVar3 = f23195a;
        EnumC11840d enumC11840d3 = EnumC11840d.INT;
        String desc9 = enumC11840d3.getDesc();
        C12238m.checkNotNullExpressionValue(desc9, "INT.desc");
        f23202h = a.access$method(aVar3, "java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        C11662w c11662w2 = C11662w.f23636a;
        String strJavaLang = c11662w2.javaLang("Number");
        String desc10 = EnumC11840d.BYTE.getDesc();
        C12238m.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String strJavaLang2 = c11662w2.javaLang("Number");
        String desc11 = EnumC11840d.SHORT.getDesc();
        C12238m.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String strJavaLang3 = c11662w2.javaLang("Number");
        String desc12 = enumC11840d3.getDesc();
        C12238m.checkNotNullExpressionValue(desc12, "INT.desc");
        String strJavaLang4 = c11662w2.javaLang("Number");
        String desc13 = EnumC11840d.LONG.getDesc();
        C12238m.checkNotNullExpressionValue(desc13, "LONG.desc");
        String strJavaLang5 = c11662w2.javaLang("Number");
        String desc14 = EnumC11840d.FLOAT.getDesc();
        C12238m.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String strJavaLang6 = c11662w2.javaLang("Number");
        String desc15 = EnumC11840d.DOUBLE.getDesc();
        C12238m.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String strJavaLang7 = c11662w2.javaLang("CharSequence");
        String desc16 = enumC11840d3.getDesc();
        C12238m.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = EnumC11840d.CHAR.getDesc();
        C12238m.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<a.C13309a, C11716e> mapMapOf2 = C12136h0.mapOf(C12116o.m10073to(a.access$method(aVar3, strJavaLang, "toByte", "", desc10), C11716e.identifier("byteValue")), C12116o.m10073to(a.access$method(aVar3, strJavaLang2, "toShort", "", desc11), C11716e.identifier("shortValue")), C12116o.m10073to(a.access$method(aVar3, strJavaLang3, "toInt", "", desc12), C11716e.identifier("intValue")), C12116o.m10073to(a.access$method(aVar3, strJavaLang4, "toLong", "", desc13), C11716e.identifier("longValue")), C12116o.m10073to(a.access$method(aVar3, strJavaLang5, "toFloat", "", desc14), C11716e.identifier("floatValue")), C12116o.m10073to(a.access$method(aVar3, strJavaLang6, "toDouble", "", desc15), C11716e.identifier("doubleValue")), C12116o.m10073to(aVar3.getREMOVE_AT_NAME_AND_SIGNATURE(), C11716e.identifier("remove")), C12116o.m10073to(a.access$method(aVar3, strJavaLang7, "get", desc16, desc17), C11716e.identifier("charAt")));
        f23203i = mapMapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(mapMapOf2.size()));
        Iterator<T> it6 = mapMapOf2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C13309a) entry2.getKey()).getSignature(), entry2.getValue());
        }
        f23204j = linkedHashMap2;
        Set<a.C13309a> setKeySet = f23203i.keySet();
        ArrayList arrayList6 = new ArrayList(C12149o.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            arrayList6.add(((a.C13309a) it7.next()).getName());
        }
        f23205k = arrayList6;
        Set<Map.Entry<a.C13309a, C11716e>> setEntrySet = f23203i.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(C12149o.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList7.add(new Pair(((a.C13309a) entry3.getKey()).getName(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            C11716e c11716e = (C11716e) pair.getSecond();
            Object arrayList8 = linkedHashMap3.get(c11716e);
            if (arrayList8 == null) {
                arrayList8 = new ArrayList();
                linkedHashMap3.put(c11716e, arrayList8);
            }
            ((List) arrayList8).add((C11716e) pair.getFirst());
        }
        f23206l = linkedHashMap3;
    }
}
