package d0.e0.p.d.m0.f.a0.b;

import d0.d0._Ranges;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.IndexedValue;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.g, reason: use source file name */
/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmNameResolver implements NameResolver {
    public static final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3389b;
    public static final List<String> c;
    public final JvmProtoBuf.e d;
    public final String[] e;
    public final Set<Integer> f;
    public final List<JvmProtoBuf.e.c> g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.g$a */
    /* JADX INFO: compiled from: JvmNameResolver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<String> getPREDEFINED_STRINGS() {
            return JvmNameResolver.c;
        }
    }

    static {
        a aVar = new a(null);
        a = aVar;
        String strJoinToString$default = _Collections.joinToString$default(Collections2.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f3389b = strJoinToString$default;
        c = Collections2.listOf((Object[]) new String[]{Intrinsics3.stringPlus(strJoinToString$default, "/Any"), Intrinsics3.stringPlus(strJoinToString$default, "/Nothing"), Intrinsics3.stringPlus(strJoinToString$default, "/Unit"), Intrinsics3.stringPlus(strJoinToString$default, "/Throwable"), Intrinsics3.stringPlus(strJoinToString$default, "/Number"), Intrinsics3.stringPlus(strJoinToString$default, "/Byte"), Intrinsics3.stringPlus(strJoinToString$default, "/Double"), Intrinsics3.stringPlus(strJoinToString$default, "/Float"), Intrinsics3.stringPlus(strJoinToString$default, "/Int"), Intrinsics3.stringPlus(strJoinToString$default, "/Long"), Intrinsics3.stringPlus(strJoinToString$default, "/Short"), Intrinsics3.stringPlus(strJoinToString$default, "/Boolean"), Intrinsics3.stringPlus(strJoinToString$default, "/Char"), Intrinsics3.stringPlus(strJoinToString$default, "/CharSequence"), Intrinsics3.stringPlus(strJoinToString$default, "/String"), Intrinsics3.stringPlus(strJoinToString$default, "/Comparable"), Intrinsics3.stringPlus(strJoinToString$default, "/Enum"), Intrinsics3.stringPlus(strJoinToString$default, "/Array"), Intrinsics3.stringPlus(strJoinToString$default, "/ByteArray"), Intrinsics3.stringPlus(strJoinToString$default, "/DoubleArray"), Intrinsics3.stringPlus(strJoinToString$default, "/FloatArray"), Intrinsics3.stringPlus(strJoinToString$default, "/IntArray"), Intrinsics3.stringPlus(strJoinToString$default, "/LongArray"), Intrinsics3.stringPlus(strJoinToString$default, "/ShortArray"), Intrinsics3.stringPlus(strJoinToString$default, "/BooleanArray"), Intrinsics3.stringPlus(strJoinToString$default, "/CharArray"), Intrinsics3.stringPlus(strJoinToString$default, "/Cloneable"), Intrinsics3.stringPlus(strJoinToString$default, "/Annotation"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/Iterable"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableIterable"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/Collection"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableCollection"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/List"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableList"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/Set"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableSet"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/Map"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableMap"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/Map.Entry"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableMap.MutableEntry"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/Iterator"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableIterator"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/ListIterator"), Intrinsics3.stringPlus(strJoinToString$default, "/collections/MutableListIterator")});
        Iterable<IndexedValue> iterableWithIndex = _Collections.withIndex(aVar.getPREDEFINED_STRINGS());
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
        for (IndexedValue indexedValue : iterableWithIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
    }

    public JvmNameResolver(JvmProtoBuf.e eVar, String[] strArr) {
        Set<Integer> set;
        Intrinsics3.checkNotNullParameter(eVar, "types");
        Intrinsics3.checkNotNullParameter(strArr, "strings");
        this.d = eVar;
        this.e = strArr;
        List<Integer> localNameList = eVar.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = Sets5.emptySet();
        } else {
            Intrinsics3.checkNotNullExpressionValue(localNameList, "");
            set = _Collections.toSet(localNameList);
        }
        this.f = set;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.e.c> recordList = getTypes().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.e.c cVar : recordList) {
            int range = cVar.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        this.g = arrayList;
    }

    @Override // d0.e0.p.d.m0.f.z.NameResolver
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    @Override // d0.e0.p.d.m0.f.z.NameResolver
    public String getString(int i) {
        String strSubstring;
        JvmProtoBuf.e.c cVar = this.g.get(i);
        if (cVar.hasString()) {
            strSubstring = cVar.getString();
        } else if (cVar.hasPredefinedIndex()) {
            a aVar = a;
            int size = aVar.getPREDEFINED_STRINGS().size() - 1;
            int predefinedIndex = cVar.getPredefinedIndex();
            if (predefinedIndex >= 0 && predefinedIndex <= size) {
                strSubstring = aVar.getPREDEFINED_STRINGS().get(cVar.getPredefinedIndex());
            } else {
                strSubstring = this.e[i];
            }
        } else {
            strSubstring = this.e[i];
        }
        if (cVar.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = cVar.getSubstringIndexList();
            Intrinsics3.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics3.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int iIntValue = num.intValue();
                Intrinsics3.checkNotNullExpressionValue(num2, "end");
                if (iIntValue <= num2.intValue() && num2.intValue() <= strSubstring.length()) {
                    Intrinsics3.checkNotNullExpressionValue(strSubstring, "string");
                    strSubstring = strSubstring.substring(num.intValue(), num2.intValue());
                    Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String strReplace$default = strSubstring;
        if (cVar.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = cVar.getReplaceCharList();
            Intrinsics3.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            Intrinsics3.checkNotNullExpressionValue(strReplace$default, "string");
            strReplace$default = StringsJVM.replace$default(strReplace$default, (char) num3.intValue(), (char) num4.intValue(), false, 4, (Object) null);
        }
        String strReplace$default2 = strReplace$default;
        JvmProtoBuf.e.c.EnumC0392c operation = cVar.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.e.c.EnumC0392c.NONE;
        }
        int iOrdinal = operation.ordinal();
        if (iOrdinal == 1) {
            Intrinsics3.checkNotNullExpressionValue(strReplace$default2, "string");
            strReplace$default2 = StringsJVM.replace$default(strReplace$default2, '$', '.', false, 4, (Object) null);
        } else if (iOrdinal == 2) {
            if (strReplace$default2.length() >= 2) {
                Intrinsics3.checkNotNullExpressionValue(strReplace$default2, "string");
                strReplace$default2 = strReplace$default2.substring(1, strReplace$default2.length() - 1);
                Intrinsics3.checkNotNullExpressionValue(strReplace$default2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str = strReplace$default2;
            Intrinsics3.checkNotNullExpressionValue(str, "string");
            strReplace$default2 = StringsJVM.replace$default(str, '$', '.', false, 4, (Object) null);
        }
        Intrinsics3.checkNotNullExpressionValue(strReplace$default2, "string");
        return strReplace$default2;
    }

    public final JvmProtoBuf.e getTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.f.z.NameResolver
    public boolean isLocalClassName(int i) {
        return this.f.contains(Integer.valueOf(i));
    }
}
