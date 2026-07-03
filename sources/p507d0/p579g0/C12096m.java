package p507d0.p579g0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.m */
/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12096m extends C12095l {

    /* JADX INFO: renamed from: d0.g0.m$a */
    /* JADX INFO: compiled from: Indent.kt */
    public static final class a extends AbstractC12240o implements Function1<String, String> {

        /* JADX INFO: renamed from: j */
        public static final a f25163j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String str) {
            C12238m.checkNotNullParameter(str, "line");
            return str;
        }
    }

    /* JADX INFO: renamed from: d0.g0.m$b */
    /* JADX INFO: compiled from: Indent.kt */
    public static final class b extends AbstractC12240o implements Function1<String, String> {
        public final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String str) {
            C12238m.checkNotNullParameter(str, "line");
            return C1643a.m822J(new StringBuilder(), this.$indent, str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final Function1<String, String> m10068a(String str) {
        return str.length() == 0 ? a.f25163j : new b(str);
    }

    public static final String replaceIndent(String str, String str2) {
        int length;
        String strInvoke;
        C12238m.checkNotNullParameter(str, "$this$replaceIndent");
        C12238m.checkNotNullParameter(str2, "newIndent");
        List<String> listLines = C12106w.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!C12103t.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
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
                if (!C12084a.isWhitespace(str3.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str3.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Integer num = (Integer) C12163u.minOrNull(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int size = (listLines.size() * str2.length()) + str.length();
        Function1<String, String> function1M10068a = m10068a(str2);
        int lastIndex = C12147n.getLastIndex(listLines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listLines) {
            int i = length + 1;
            if (length < 0) {
                C12147n.throwIndexOverflow();
            }
            String str4 = (String) obj2;
            if ((length == 0 || length == lastIndex) && C12103t.isBlank(str4)) {
                str4 = null;
            } else {
                String strDrop = C12108y.drop(str4, iIntValue);
                if (strDrop != null && (strInvoke = function1M10068a.invoke(strDrop)) != null) {
                    str4 = strInvoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            length = i;
        }
        String string = ((StringBuilder) C12163u.joinTo(arrayList3, new StringBuilder(size), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        C12238m.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String replaceIndentByMargin(String str, String str2, String str3) {
        int i;
        String strInvoke;
        C12238m.checkNotNullParameter(str, "$this$replaceIndentByMargin");
        C12238m.checkNotNullParameter(str2, "newIndent");
        C12238m.checkNotNullParameter(str3, "marginPrefix");
        if (!(!C12103t.isBlank(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listLines = C12106w.lines(str);
        int size = (listLines.size() * str2.length()) + str.length();
        Function1<String, String> function1M10068a = m10068a(str2);
        int lastIndex = C12147n.getLastIndex(listLines);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listLines) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C12147n.throwIndexOverflow();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i2 != 0 && i2 != lastIndex) || !C12103t.isBlank(str4)) {
                int length = str4.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        i = -1;
                        break;
                    }
                    if (!C12084a.isWhitespace(str4.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (C12103t.startsWith$default(str4, str3, i, false, 4, null)) {
                        int length2 = str3.length() + i5;
                        Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str4.substring(length2);
                        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strInvoke = function1M10068a.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
                strSubstring = str4;
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) C12163u.joinTo(arrayList, new StringBuilder(size), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        C12238m.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String trimIndent(String str) {
        C12238m.checkNotNullParameter(str, "$this$trimIndent");
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String str2) {
        C12238m.checkNotNullParameter(str, "$this$trimMargin");
        C12238m.checkNotNullParameter(str2, "marginPrefix");
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
