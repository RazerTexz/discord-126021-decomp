package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p580t.C12168z;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.g */
/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11674g implements InterfaceC11704c {

    /* JADX INFO: renamed from: a */
    public static final a f23713a;

    /* JADX INFO: renamed from: b */
    public static final String f23714b;

    /* JADX INFO: renamed from: c */
    public static final List<String> f23715c;

    /* JADX INFO: renamed from: d */
    public final C11667a.e f23716d;

    /* JADX INFO: renamed from: e */
    public final String[] f23717e;

    /* JADX INFO: renamed from: f */
    public final Set<Integer> f23718f;

    /* JADX INFO: renamed from: g */
    public final List<C11667a.e.c> f23719g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.g$a */
    /* JADX INFO: compiled from: JvmNameResolver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<String> getPREDEFINED_STRINGS() {
            return C11674g.f23715c;
        }
    }

    static {
        a aVar = new a(null);
        f23713a = aVar;
        String strJoinToString$default = C12163u.joinToString$default(C12147n.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f23714b = strJoinToString$default;
        f23715c = C12147n.listOf((Object[]) new String[]{C12238m.stringPlus(strJoinToString$default, "/Any"), C12238m.stringPlus(strJoinToString$default, "/Nothing"), C12238m.stringPlus(strJoinToString$default, "/Unit"), C12238m.stringPlus(strJoinToString$default, "/Throwable"), C12238m.stringPlus(strJoinToString$default, "/Number"), C12238m.stringPlus(strJoinToString$default, "/Byte"), C12238m.stringPlus(strJoinToString$default, "/Double"), C12238m.stringPlus(strJoinToString$default, "/Float"), C12238m.stringPlus(strJoinToString$default, "/Int"), C12238m.stringPlus(strJoinToString$default, "/Long"), C12238m.stringPlus(strJoinToString$default, "/Short"), C12238m.stringPlus(strJoinToString$default, "/Boolean"), C12238m.stringPlus(strJoinToString$default, "/Char"), C12238m.stringPlus(strJoinToString$default, "/CharSequence"), C12238m.stringPlus(strJoinToString$default, "/String"), C12238m.stringPlus(strJoinToString$default, "/Comparable"), C12238m.stringPlus(strJoinToString$default, "/Enum"), C12238m.stringPlus(strJoinToString$default, "/Array"), C12238m.stringPlus(strJoinToString$default, "/ByteArray"), C12238m.stringPlus(strJoinToString$default, "/DoubleArray"), C12238m.stringPlus(strJoinToString$default, "/FloatArray"), C12238m.stringPlus(strJoinToString$default, "/IntArray"), C12238m.stringPlus(strJoinToString$default, "/LongArray"), C12238m.stringPlus(strJoinToString$default, "/ShortArray"), C12238m.stringPlus(strJoinToString$default, "/BooleanArray"), C12238m.stringPlus(strJoinToString$default, "/CharArray"), C12238m.stringPlus(strJoinToString$default, "/Cloneable"), C12238m.stringPlus(strJoinToString$default, "/Annotation"), C12238m.stringPlus(strJoinToString$default, "/collections/Iterable"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableIterable"), C12238m.stringPlus(strJoinToString$default, "/collections/Collection"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableCollection"), C12238m.stringPlus(strJoinToString$default, "/collections/List"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableList"), C12238m.stringPlus(strJoinToString$default, "/collections/Set"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableSet"), C12238m.stringPlus(strJoinToString$default, "/collections/Map"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableMap"), C12238m.stringPlus(strJoinToString$default, "/collections/Map.Entry"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableMap.MutableEntry"), C12238m.stringPlus(strJoinToString$default, "/collections/Iterator"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableIterator"), C12238m.stringPlus(strJoinToString$default, "/collections/ListIterator"), C12238m.stringPlus(strJoinToString$default, "/collections/MutableListIterator")});
        Iterable<C12168z> iterableWithIndex = C12163u.withIndex(aVar.getPREDEFINED_STRINGS());
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
        for (C12168z c12168z : iterableWithIndex) {
            linkedHashMap.put((String) c12168z.getValue(), Integer.valueOf(c12168z.getIndex()));
        }
    }

    public C11674g(C11667a.e eVar, String[] strArr) {
        Set<Integer> set;
        C12238m.checkNotNullParameter(eVar, "types");
        C12238m.checkNotNullParameter(strArr, "strings");
        this.f23716d = eVar;
        this.f23717e = strArr;
        List<Integer> localNameList = eVar.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = C12148n0.emptySet();
        } else {
            C12238m.checkNotNullExpressionValue(localNameList, "");
            set = C12163u.toSet(localNameList);
        }
        this.f23718f = set;
        ArrayList arrayList = new ArrayList();
        List<C11667a.e.c> recordList = getTypes().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (C11667a.e.c cVar : recordList) {
            int range = cVar.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        this.f23719g = arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c
    public String getString(int i) {
        String strSubstring;
        C11667a.e.c cVar = this.f23719g.get(i);
        if (cVar.hasString()) {
            strSubstring = cVar.getString();
        } else if (cVar.hasPredefinedIndex()) {
            a aVar = f23713a;
            int size = aVar.getPREDEFINED_STRINGS().size() - 1;
            int predefinedIndex = cVar.getPredefinedIndex();
            if (predefinedIndex >= 0 && predefinedIndex <= size) {
                strSubstring = aVar.getPREDEFINED_STRINGS().get(cVar.getPredefinedIndex());
            } else {
                strSubstring = this.f23717e[i];
            }
        } else {
            strSubstring = this.f23717e[i];
        }
        if (cVar.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = cVar.getSubstringIndexList();
            C12238m.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            C12238m.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int iIntValue = num.intValue();
                C12238m.checkNotNullExpressionValue(num2, "end");
                if (iIntValue <= num2.intValue() && num2.intValue() <= strSubstring.length()) {
                    C12238m.checkNotNullExpressionValue(strSubstring, "string");
                    strSubstring = strSubstring.substring(num.intValue(), num2.intValue());
                    C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String strReplace$default = strSubstring;
        if (cVar.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = cVar.getReplaceCharList();
            C12238m.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            C12238m.checkNotNullExpressionValue(strReplace$default, "string");
            strReplace$default = C12103t.replace$default(strReplace$default, (char) num3.intValue(), (char) num4.intValue(), false, 4, (Object) null);
        }
        String strReplace$default2 = strReplace$default;
        C11667a.e.c.EnumC13318c operation = cVar.getOperation();
        if (operation == null) {
            operation = C11667a.e.c.EnumC13318c.NONE;
        }
        int iOrdinal = operation.ordinal();
        if (iOrdinal == 1) {
            C12238m.checkNotNullExpressionValue(strReplace$default2, "string");
            strReplace$default2 = C12103t.replace$default(strReplace$default2, '$', '.', false, 4, (Object) null);
        } else if (iOrdinal == 2) {
            if (strReplace$default2.length() >= 2) {
                C12238m.checkNotNullExpressionValue(strReplace$default2, "string");
                strReplace$default2 = strReplace$default2.substring(1, strReplace$default2.length() - 1);
                C12238m.checkNotNullExpressionValue(strReplace$default2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str = strReplace$default2;
            C12238m.checkNotNullExpressionValue(str, "string");
            strReplace$default2 = C12103t.replace$default(str, '$', '.', false, 4, (Object) null);
        }
        C12238m.checkNotNullExpressionValue(strReplace$default2, "string");
        return strReplace$default2;
    }

    public final C11667a.e getTypes() {
        return this.f23716d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c
    public boolean isLocalClassName(int i) {
        return this.f23718f.contains(Integer.valueOf(i));
    }
}
