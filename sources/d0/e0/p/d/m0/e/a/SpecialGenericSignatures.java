package d0.e0.p.d.m0.e.a;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.e0.p.d.m0.e.b.SignatureBuildingComponents;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0, reason: use source file name */
/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SpecialGenericSignatures {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a.C0382a> f3311b;
    public static final List<String> c;
    public static final Map<a.C0382a, c> d;
    public static final Map<String, c> e;
    public static final Set<Name> f;
    public static final Set<String> g;
    public static final a.C0382a h;
    public static final Map<a.C0382a, Name> i;
    public static final Map<String, Name> j;
    public static final List<Name> k;
    public static final Map<Name, List<Name>> l;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0$a */
    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        public static final class C0382a {
            public final Name a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f3312b;

            public C0382a(Name name, String str) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(str, "signature");
                this.a = name;
                this.f3312b = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0382a)) {
                    return false;
                }
                C0382a c0382a = (C0382a) obj;
                return Intrinsics3.areEqual(this.a, c0382a.a) && Intrinsics3.areEqual(this.f3312b, c0382a.f3312b);
            }

            public final Name getName() {
                return this.a;
            }

            public final String getSignature() {
                return this.f3312b;
            }

            public int hashCode() {
                return this.f3312b.hashCode() + (this.a.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("NameAndSignature(name=");
                sbU.append(this.a);
                sbU.append(", signature=");
                return outline.H(sbU, this.f3312b, ')');
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final C0382a access$method(a aVar, String str, String str2, String str3, String str4) {
            Objects.requireNonNull(aVar);
            Name nameIdentifier = Name.identifier(str2);
            Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(name)");
            return new C0382a(nameIdentifier, SignatureBuildingComponents.a.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.c;
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.f;
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.g;
        }

        public final Map<Name, List<Name>> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.l;
        }

        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.k;
        }

        public final C0382a getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.h;
        }

        public final Map<String, c> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.e;
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.j;
        }

        public final b getSpecialSignatureInfo(String str) {
            Intrinsics3.checkNotNullParameter(str, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str)) {
                return b.ONE_COLLECTION_PARAMETER;
            }
            return ((c) Maps6.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == c.j ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
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
        public static final c j;
        public static final c k;
        public static final c l;
        public static final c m;
        public static final /* synthetic */ c[] n;
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
            j = cVar;
            c cVar2 = new c("INDEX", 1, -1);
            k = cVar2;
            c cVar3 = new c("FALSE", 2, Boolean.FALSE);
            l = cVar3;
            a aVar = new a("MAP_GET_OR_DEFAULT", 3);
            m = aVar;
            n = new c[]{cVar, cVar2, cVar3, aVar};
        }

        public c(String str, int i, Object obj) {
            super(str, i);
            this.defaultValue = obj;
        }

        public static c valueOf(String str) {
            Intrinsics3.checkNotNullParameter(str, "value");
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            c[] cVarArr = n;
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
        Set<String> of = Sets5.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            a aVar = a;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics3.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(a.access$method(aVar, "java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f3311b = arrayList;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C0382a) it.next()).getSignature());
        }
        c = arrayList2;
        List<a.C0382a> list = f3311b;
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.C0382a) it2.next()).getName().asString());
        }
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        a aVar2 = a;
        String strJavaUtil = signatureBuildingComponents.javaUtil("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        a.C0382a c0382aAccess$method = a.access$method(aVar2, strJavaUtil, "contains", "Ljava/lang/Object;", desc2);
        c cVar = c.l;
        String strJavaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String strJavaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String strJavaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String strJavaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        a.C0382a c0382aAccess$method2 = a.access$method(aVar2, signatureBuildingComponents.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.j;
        String strJavaUtil6 = signatureBuildingComponents.javaUtil("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc7, "INT.desc");
        a.C0382a c0382aAccess$method3 = a.access$method(aVar2, strJavaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        c cVar3 = c.k;
        String strJavaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<a.C0382a, c> mapMapOf = Maps6.mapOf(Tuples.to(c0382aAccess$method, cVar), Tuples.to(a.access$method(aVar2, strJavaUtil2, "remove", "Ljava/lang/Object;", desc3), cVar), Tuples.to(a.access$method(aVar2, strJavaUtil3, "containsKey", "Ljava/lang/Object;", desc4), cVar), Tuples.to(a.access$method(aVar2, strJavaUtil4, "containsValue", "Ljava/lang/Object;", desc5), cVar), Tuples.to(a.access$method(aVar2, strJavaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), cVar), Tuples.to(a.access$method(aVar2, signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.m), Tuples.to(c0382aAccess$method2, cVar2), Tuples.to(a.access$method(aVar2, signatureBuildingComponents.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2), Tuples.to(c0382aAccess$method3, cVar3), Tuples.to(a.access$method(aVar2, strJavaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), cVar3));
        d = mapMapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(mapMapOf.size()));
        Iterator<T> it3 = mapMapOf.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0382a) entry.getKey()).getSignature(), entry.getValue());
        }
        e = linkedHashMap;
        Set setPlus = _Sets.plus((Set) d.keySet(), (Iterable) f3311b);
        ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(setPlus, 10));
        Iterator it4 = setPlus.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((a.C0382a) it4.next()).getName());
        }
        f = _Collections.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(setPlus, 10));
        Iterator it5 = setPlus.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((a.C0382a) it5.next()).getSignature());
        }
        g = _Collections.toSet(arrayList5);
        a aVar3 = a;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc9, "INT.desc");
        h = a.access$method(aVar3, "java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.a;
        String strJavaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String strJavaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String strJavaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc12, "INT.desc");
        String strJavaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc13, "LONG.desc");
        String strJavaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String strJavaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String strJavaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics3.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<a.C0382a, Name> mapMapOf2 = Maps6.mapOf(Tuples.to(a.access$method(aVar3, strJavaLang, "toByte", "", desc10), Name.identifier("byteValue")), Tuples.to(a.access$method(aVar3, strJavaLang2, "toShort", "", desc11), Name.identifier("shortValue")), Tuples.to(a.access$method(aVar3, strJavaLang3, "toInt", "", desc12), Name.identifier("intValue")), Tuples.to(a.access$method(aVar3, strJavaLang4, "toLong", "", desc13), Name.identifier("longValue")), Tuples.to(a.access$method(aVar3, strJavaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), Tuples.to(a.access$method(aVar3, strJavaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), Tuples.to(aVar3.getREMOVE_AT_NAME_AND_SIGNATURE(), Name.identifier("remove")), Tuples.to(a.access$method(aVar3, strJavaLang7, "get", desc16, desc17), Name.identifier("charAt")));
        i = mapMapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(mapMapOf2.size()));
        Iterator<T> it6 = mapMapOf2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0382a) entry2.getKey()).getSignature(), entry2.getValue());
        }
        j = linkedHashMap2;
        Set<a.C0382a> setKeySet = i.keySet();
        ArrayList arrayList6 = new ArrayList(Iterables2.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            arrayList6.add(((a.C0382a) it7.next()).getName());
        }
        k = arrayList6;
        Set<Map.Entry<a.C0382a, Name>> setEntrySet = i.entrySet();
        ArrayList<Tuples2> arrayList7 = new ArrayList(Iterables2.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList7.add(new Tuples2(((a.C0382a) entry3.getKey()).getName(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Tuples2 tuples2 : arrayList7) {
            Name name = (Name) tuples2.getSecond();
            Object arrayList8 = linkedHashMap3.get(name);
            if (arrayList8 == null) {
                arrayList8 = new ArrayList();
                linkedHashMap3.put(name, arrayList8);
            }
            ((List) arrayList8).add((Name) tuples2.getFirst());
        }
        l = linkedHashMap3;
    }
}
