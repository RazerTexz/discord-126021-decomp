package d0.e0.p.d.m0.e.a;

import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import d0.t.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Pair;

/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e0 {
    public static final e0$a a = new e0$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<e0$a$a> f3311b;
    public static final List<String> c;
    public static final Map<e0$a$a, e0$c> d;
    public static final Map<String, e0$c> e;
    public static final Set<d0.e0.p.d.m0.g.e> f;
    public static final Set<String> g;
    public static final e0$a$a h;
    public static final Map<e0$a$a, d0.e0.p.d.m0.g.e> i;
    public static final Map<String, d0.e0.p.d.m0.g.e> j;
    public static final List<d0.e0.p.d.m0.g.e> k;
    public static final Map<d0.e0.p.d.m0.g.e, List<d0.e0.p.d.m0.g.e>> l;

    static {
        Set<String> of = n0.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            e0$a e0_a = a;
            String desc = d0.e0.p.d.m0.k.y.d.BOOLEAN.getDesc();
            d0.z.d.m.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(e0$a.access$method(e0_a, "java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f3311b = arrayList;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((e0$a$a) it.next()).getSignature());
        }
        c = arrayList2;
        List<e0$a$a> list = f3311b;
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((e0$a$a) it2.next()).getName().asString());
        }
        d0.e0.p.d.m0.e.b.w wVar = d0.e0.p.d.m0.e.b.w.a;
        e0$a e0_a2 = a;
        String strJavaUtil = wVar.javaUtil("Collection");
        d0.e0.p.d.m0.k.y.d dVar = d0.e0.p.d.m0.k.y.d.BOOLEAN;
        String desc2 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        e0$a$a e0_a_aAccess$method = e0$a.access$method(e0_a2, strJavaUtil, "contains", "Ljava/lang/Object;", desc2);
        e0$c e0_c = e0$c.l;
        String strJavaUtil2 = wVar.javaUtil("Collection");
        String desc3 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String strJavaUtil3 = wVar.javaUtil("Map");
        String desc4 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String strJavaUtil4 = wVar.javaUtil("Map");
        String desc5 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String strJavaUtil5 = wVar.javaUtil("Map");
        String desc6 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        e0$a$a e0_a_aAccess$method2 = e0$a.access$method(e0_a2, wVar.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        e0$c e0_c2 = e0$c.j;
        String strJavaUtil6 = wVar.javaUtil("List");
        d0.e0.p.d.m0.k.y.d dVar2 = d0.e0.p.d.m0.k.y.d.INT;
        String desc7 = dVar2.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc7, "INT.desc");
        e0$a$a e0_a_aAccess$method3 = e0$a.access$method(e0_a2, strJavaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        e0$c e0_c3 = e0$c.k;
        String strJavaUtil7 = wVar.javaUtil("List");
        String desc8 = dVar2.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<e0$a$a, e0$c> mapMapOf = h0.mapOf(d0.o.to(e0_a_aAccess$method, e0_c), d0.o.to(e0$a.access$method(e0_a2, strJavaUtil2, "remove", "Ljava/lang/Object;", desc3), e0_c), d0.o.to(e0$a.access$method(e0_a2, strJavaUtil3, "containsKey", "Ljava/lang/Object;", desc4), e0_c), d0.o.to(e0$a.access$method(e0_a2, strJavaUtil4, "containsValue", "Ljava/lang/Object;", desc5), e0_c), d0.o.to(e0$a.access$method(e0_a2, strJavaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), e0_c), d0.o.to(e0$a.access$method(e0_a2, wVar.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), e0$c.m), d0.o.to(e0_a_aAccess$method2, e0_c2), d0.o.to(e0$a.access$method(e0_a2, wVar.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), e0_c2), d0.o.to(e0_a_aAccess$method3, e0_c3), d0.o.to(e0$a.access$method(e0_a2, strJavaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), e0_c3));
        d = mapMapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(mapMapOf.size()));
        Iterator<T> it3 = mapMapOf.entrySet().iterator();
        while (it3.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it3.next();
            linkedHashMap.put(((e0$a$a) map$Entry.getKey()).getSignature(), map$Entry.getValue());
        }
        e = linkedHashMap;
        Set setPlus = o0.plus((Set) d.keySet(), (Iterable) f3311b);
        ArrayList arrayList4 = new ArrayList(d0.t.o.collectionSizeOrDefault(setPlus, 10));
        Iterator it4 = setPlus.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((e0$a$a) it4.next()).getName());
        }
        f = d0.t.u.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(d0.t.o.collectionSizeOrDefault(setPlus, 10));
        Iterator it5 = setPlus.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((e0$a$a) it5.next()).getSignature());
        }
        g = d0.t.u.toSet(arrayList5);
        e0$a e0_a3 = a;
        d0.e0.p.d.m0.k.y.d dVar3 = d0.e0.p.d.m0.k.y.d.INT;
        String desc9 = dVar3.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc9, "INT.desc");
        h = e0$a.access$method(e0_a3, "java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        d0.e0.p.d.m0.e.b.w wVar2 = d0.e0.p.d.m0.e.b.w.a;
        String strJavaLang = wVar2.javaLang("Number");
        String desc10 = d0.e0.p.d.m0.k.y.d.BYTE.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String strJavaLang2 = wVar2.javaLang("Number");
        String desc11 = d0.e0.p.d.m0.k.y.d.SHORT.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String strJavaLang3 = wVar2.javaLang("Number");
        String desc12 = dVar3.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc12, "INT.desc");
        String strJavaLang4 = wVar2.javaLang("Number");
        String desc13 = d0.e0.p.d.m0.k.y.d.LONG.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc13, "LONG.desc");
        String strJavaLang5 = wVar2.javaLang("Number");
        String desc14 = d0.e0.p.d.m0.k.y.d.FLOAT.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String strJavaLang6 = wVar2.javaLang("Number");
        String desc15 = d0.e0.p.d.m0.k.y.d.DOUBLE.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String strJavaLang7 = wVar2.javaLang("CharSequence");
        String desc16 = dVar3.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = d0.e0.p.d.m0.k.y.d.CHAR.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<e0$a$a, d0.e0.p.d.m0.g.e> mapMapOf2 = h0.mapOf(d0.o.to(e0$a.access$method(e0_a3, strJavaLang, "toByte", "", desc10), d0.e0.p.d.m0.g.e.identifier("byteValue")), d0.o.to(e0$a.access$method(e0_a3, strJavaLang2, "toShort", "", desc11), d0.e0.p.d.m0.g.e.identifier("shortValue")), d0.o.to(e0$a.access$method(e0_a3, strJavaLang3, "toInt", "", desc12), d0.e0.p.d.m0.g.e.identifier("intValue")), d0.o.to(e0$a.access$method(e0_a3, strJavaLang4, "toLong", "", desc13), d0.e0.p.d.m0.g.e.identifier("longValue")), d0.o.to(e0$a.access$method(e0_a3, strJavaLang5, "toFloat", "", desc14), d0.e0.p.d.m0.g.e.identifier("floatValue")), d0.o.to(e0$a.access$method(e0_a3, strJavaLang6, "toDouble", "", desc15), d0.e0.p.d.m0.g.e.identifier("doubleValue")), d0.o.to(e0_a3.getREMOVE_AT_NAME_AND_SIGNATURE(), d0.e0.p.d.m0.g.e.identifier("remove")), d0.o.to(e0$a.access$method(e0_a3, strJavaLang7, "get", desc16, desc17), d0.e0.p.d.m0.g.e.identifier("charAt")));
        i = mapMapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(mapMapOf2.size()));
        Iterator<T> it6 = mapMapOf2.entrySet().iterator();
        while (it6.hasNext()) {
            Map$Entry map$Entry2 = (Map$Entry) it6.next();
            linkedHashMap2.put(((e0$a$a) map$Entry2.getKey()).getSignature(), map$Entry2.getValue());
        }
        j = linkedHashMap2;
        Set<e0$a$a> setKeySet = i.keySet();
        ArrayList arrayList6 = new ArrayList(d0.t.o.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            arrayList6.add(((e0$a$a) it7.next()).getName());
        }
        k = arrayList6;
        Set<Map$Entry<e0$a$a, d0.e0.p.d.m0.g.e>> setEntrySet = i.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(d0.t.o.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map$Entry map$Entry3 = (Map$Entry) it8.next();
            arrayList7.add(new Pair(((e0$a$a) map$Entry3.getKey()).getName(), map$Entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            d0.e0.p.d.m0.g.e eVar = (d0.e0.p.d.m0.g.e) pair.getSecond();
            Object arrayList8 = linkedHashMap3.get(eVar);
            if (arrayList8 == null) {
                arrayList8 = new ArrayList();
                linkedHashMap3.put(eVar, arrayList8);
            }
            ((List) arrayList8).add((d0.e0.p.d.m0.g.e) pair.getFirst());
        }
        l = linkedHashMap3;
    }

    public static final /* synthetic */ List access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp() {
        return c;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp() {
        return f;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp() {
        return g;
    }

    public static final /* synthetic */ Map access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp() {
        return l;
    }

    public static final /* synthetic */ List access$getORIGINAL_SHORT_NAMES$cp() {
        return k;
    }

    public static final /* synthetic */ e0$a$a access$getREMOVE_AT_NAME_AND_SIGNATURE$cp() {
        return h;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp() {
        return e;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp() {
        return j;
    }
}
