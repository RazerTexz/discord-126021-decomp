package d0.g0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes3.dex */
public class m extends l {
    public static final Function1<String, String> a(String str) {
        return str.length() == 0 ? m$a.j : new m$b(str);
    }

    public static final String replaceIndent(String str, String str2) {
        int length;
        String strInvoke;
        d0.z.d.m.checkNotNullParameter(str, "$this$replaceIndent");
        d0.z.d.m.checkNotNullParameter(str2, "newIndent");
        List<String> listLines = w.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!t.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            int length2 = str3.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!a.isWhitespace(str3.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str3.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Integer num = (Integer) d0.t.u.minOrNull(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int size = (listLines.size() * str2.length()) + str.length();
        Function1<String, String> function1A = a(str2);
        int lastIndex = d0.t.n.getLastIndex(listLines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listLines) {
            int i = length + 1;
            if (length < 0) {
                d0.t.n.throwIndexOverflow();
            }
            String str4 = (String) obj2;
            if ((length == 0 || length == lastIndex) && t.isBlank(str4)) {
                str4 = null;
            } else {
                String strDrop = y.drop(str4, iIntValue);
                if (strDrop != null && (strInvoke = function1A.invoke(strDrop)) != null) {
                    str4 = strInvoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            length = i;
        }
        String string = ((StringBuilder) d0.t.u.joinTo$default(arrayList3, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String replaceIndentByMargin(String str, String str2, String str3) {
        int i;
        String strInvoke;
        d0.z.d.m.checkNotNullParameter(str, "$this$replaceIndentByMargin");
        d0.z.d.m.checkNotNullParameter(str2, "newIndent");
        d0.z.d.m.checkNotNullParameter(str3, "marginPrefix");
        if (!(!t.isBlank(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listLines = w.lines(str);
        int size = (listLines.size() * str2.length()) + str.length();
        Function1<String, String> function1A = a(str2);
        int lastIndex = d0.t.n.getLastIndex(listLines);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listLines) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                d0.t.n.throwIndexOverflow();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i2 != 0 && i2 != lastIndex) || !t.isBlank(str4)) {
                int length = str4.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        i = -1;
                        break;
                    }
                    if (!a.isWhitespace(str4.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (t.startsWith$default(str4, str3, i, false, 4, null)) {
                        int length2 = str3.length() + i5;
                        Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str4.substring(length2);
                        d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strInvoke = function1A.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
                strSubstring = str4;
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) d0.t.u.joinTo$default(arrayList, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String trimIndent(String str) {
        d0.z.d.m.checkNotNullParameter(str, "$this$trimIndent");
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$trimMargin");
        d0.z.d.m.checkNotNullParameter(str2, "marginPrefix");
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
