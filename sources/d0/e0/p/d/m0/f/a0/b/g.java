package d0.e0.p.d.m0.f.a0.b;

import d0.e0.p.d.m0.f.a0.a$e;
import d0.e0.p.d.m0.f.a0.a$e$c;
import d0.e0.p.d.m0.f.a0.a$e$c$c;
import d0.g0.t;
import d0.t.g0;
import d0.t.n;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.t.z;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements d0.e0.p.d.m0.f.z.c {
    public static final g$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3389b;
    public static final List<String> c;
    public final a$e d;
    public final String[] e;
    public final Set<Integer> f;
    public final List<a$e$c> g;

    static {
        g$a g_a = new g$a(null);
        a = g_a;
        String strJoinToString$default = u.joinToString$default(n.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f3389b = strJoinToString$default;
        c = n.listOf((Object[]) new String[]{m.stringPlus(strJoinToString$default, "/Any"), m.stringPlus(strJoinToString$default, "/Nothing"), m.stringPlus(strJoinToString$default, "/Unit"), m.stringPlus(strJoinToString$default, "/Throwable"), m.stringPlus(strJoinToString$default, "/Number"), m.stringPlus(strJoinToString$default, "/Byte"), m.stringPlus(strJoinToString$default, "/Double"), m.stringPlus(strJoinToString$default, "/Float"), m.stringPlus(strJoinToString$default, "/Int"), m.stringPlus(strJoinToString$default, "/Long"), m.stringPlus(strJoinToString$default, "/Short"), m.stringPlus(strJoinToString$default, "/Boolean"), m.stringPlus(strJoinToString$default, "/Char"), m.stringPlus(strJoinToString$default, "/CharSequence"), m.stringPlus(strJoinToString$default, "/String"), m.stringPlus(strJoinToString$default, "/Comparable"), m.stringPlus(strJoinToString$default, "/Enum"), m.stringPlus(strJoinToString$default, "/Array"), m.stringPlus(strJoinToString$default, "/ByteArray"), m.stringPlus(strJoinToString$default, "/DoubleArray"), m.stringPlus(strJoinToString$default, "/FloatArray"), m.stringPlus(strJoinToString$default, "/IntArray"), m.stringPlus(strJoinToString$default, "/LongArray"), m.stringPlus(strJoinToString$default, "/ShortArray"), m.stringPlus(strJoinToString$default, "/BooleanArray"), m.stringPlus(strJoinToString$default, "/CharArray"), m.stringPlus(strJoinToString$default, "/Cloneable"), m.stringPlus(strJoinToString$default, "/Annotation"), m.stringPlus(strJoinToString$default, "/collections/Iterable"), m.stringPlus(strJoinToString$default, "/collections/MutableIterable"), m.stringPlus(strJoinToString$default, "/collections/Collection"), m.stringPlus(strJoinToString$default, "/collections/MutableCollection"), m.stringPlus(strJoinToString$default, "/collections/List"), m.stringPlus(strJoinToString$default, "/collections/MutableList"), m.stringPlus(strJoinToString$default, "/collections/Set"), m.stringPlus(strJoinToString$default, "/collections/MutableSet"), m.stringPlus(strJoinToString$default, "/collections/Map"), m.stringPlus(strJoinToString$default, "/collections/MutableMap"), m.stringPlus(strJoinToString$default, "/collections/Map.Entry"), m.stringPlus(strJoinToString$default, "/collections/MutableMap.MutableEntry"), m.stringPlus(strJoinToString$default, "/collections/Iterator"), m.stringPlus(strJoinToString$default, "/collections/MutableIterator"), m.stringPlus(strJoinToString$default, "/collections/ListIterator"), m.stringPlus(strJoinToString$default, "/collections/MutableListIterator")});
        Iterable<z> iterableWithIndex = u.withIndex(g_a.getPREDEFINED_STRINGS());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
        for (z zVar : iterableWithIndex) {
            linkedHashMap.put((String) zVar.getValue(), Integer.valueOf(zVar.getIndex()));
        }
    }

    public g(a$e a_e, String[] strArr) {
        Set<Integer> set;
        m.checkNotNullParameter(a_e, "types");
        m.checkNotNullParameter(strArr, "strings");
        this.d = a_e;
        this.e = strArr;
        List<Integer> localNameList = a_e.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = n0.emptySet();
        } else {
            m.checkNotNullExpressionValue(localNameList, "");
            set = u.toSet(localNameList);
        }
        this.f = set;
        ArrayList arrayList = new ArrayList();
        List<a$e$c> recordList = getTypes().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (a$e$c a_e_c : recordList) {
            int range = a_e_c.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(a_e_c);
            }
        }
        arrayList.trimToSize();
        this.g = arrayList;
    }

    public static final /* synthetic */ List access$getPREDEFINED_STRINGS$cp() {
        return c;
    }

    @Override // d0.e0.p.d.m0.f.z.c
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    @Override // d0.e0.p.d.m0.f.z.c
    public String getString(int i) {
        String strSubstring;
        a$e$c a_e_c = this.g.get(i);
        if (a_e_c.hasString()) {
            strSubstring = a_e_c.getString();
        } else if (a_e_c.hasPredefinedIndex()) {
            g$a g_a = a;
            int size = g_a.getPREDEFINED_STRINGS().size() - 1;
            int predefinedIndex = a_e_c.getPredefinedIndex();
            if (predefinedIndex >= 0 && predefinedIndex <= size) {
                strSubstring = g_a.getPREDEFINED_STRINGS().get(a_e_c.getPredefinedIndex());
            } else {
                strSubstring = this.e[i];
            }
        } else {
            strSubstring = this.e[i];
        }
        if (a_e_c.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = a_e_c.getSubstringIndexList();
            m.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            m.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int iIntValue = num.intValue();
                m.checkNotNullExpressionValue(num2, "end");
                if (iIntValue <= num2.intValue() && num2.intValue() <= strSubstring.length()) {
                    m.checkNotNullExpressionValue(strSubstring, "string");
                    strSubstring = strSubstring.substring(num.intValue(), num2.intValue());
                    m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String strReplace$default = strSubstring;
        if (a_e_c.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = a_e_c.getReplaceCharList();
            m.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            m.checkNotNullExpressionValue(strReplace$default, "string");
            strReplace$default = t.replace$default(strReplace$default, (char) num3.intValue(), (char) num4.intValue(), false, 4, (Object) null);
        }
        String strReplace$default2 = strReplace$default;
        a$e$c$c operation = a_e_c.getOperation();
        if (operation == null) {
            operation = a$e$c$c.NONE;
        }
        int iOrdinal = operation.ordinal();
        if (iOrdinal == 1) {
            m.checkNotNullExpressionValue(strReplace$default2, "string");
            strReplace$default2 = t.replace$default(strReplace$default2, '$', '.', false, 4, (Object) null);
        } else if (iOrdinal == 2) {
            if (strReplace$default2.length() >= 2) {
                m.checkNotNullExpressionValue(strReplace$default2, "string");
                strReplace$default2 = strReplace$default2.substring(1, strReplace$default2.length() - 1);
                m.checkNotNullExpressionValue(strReplace$default2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str = strReplace$default2;
            m.checkNotNullExpressionValue(str, "string");
            strReplace$default2 = t.replace$default(str, '$', '.', false, 4, (Object) null);
        }
        m.checkNotNullExpressionValue(strReplace$default2, "string");
        return strReplace$default2;
    }

    public final a$e getTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.f.z.c
    public boolean isLocalClassName(int i) {
        return this.f.contains(Integer.valueOf(i));
    }
}
