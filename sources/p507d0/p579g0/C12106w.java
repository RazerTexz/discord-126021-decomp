package p507d0.p579g0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p512d0.C11226f;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.w */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12106w extends C12103t {

    /* JADX INFO: renamed from: d0.g0.w$a */
    /* JADX INFO: compiled from: Strings.kt */
    public static final class a extends AbstractC12240o implements Function1<IntRange, String> {
        public final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(IntRange intRange) {
            C12238m.checkNotNullParameter(intRange, "it");
            return C12106w.substring(this.$this_splitToSequence, intRange);
        }
    }

    public static final Pair access$findAnyOf(CharSequence charSequence, Collection collection, int i, boolean z2, boolean z3) {
        Object next;
        String str;
        Object next2;
        String str2;
        if (!z2 && collection.size() == 1) {
            String str3 = (String) C12163u.single(collection);
            int iIndexOf$default = !z3 ? indexOf$default(charSequence, str3, i, false, 4, (Object) null) : lastIndexOf$default(charSequence, str3, i, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            return C12116o.m10073to(Integer.valueOf(iIndexOf$default), str3);
        }
        IntProgression intRange = !z3 ? new IntRange(C11226f.coerceAtLeast(i, 0), charSequence.length()) : C11226f.downTo(C11226f.coerceAtMost(i, getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if (step >= 0) {
                if (first > last) {
                    return null;
                }
            } else if (first < last) {
                return null;
            }
            while (true) {
                Iterator it = collection.iterator();
                do {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    str2 = (String) next2;
                } while (!C12103t.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z2));
                String str4 = (String) next2;
                if (str4 != null) {
                    return C12116o.m10073to(Integer.valueOf(first), str4);
                }
                if (first == last) {
                    return null;
                }
                first += step;
            }
        } else {
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if (step2 >= 0) {
                if (first2 > last2) {
                    return null;
                }
            } else if (first2 < last2) {
                return null;
            }
            while (true) {
                Iterator it2 = collection.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    str = (String) next;
                } while (!regionMatchesImpl(str, 0, charSequence, first2, str.length(), z2));
                String str5 = (String) next;
                if (str5 != null) {
                    return C12116o.m10073to(Integer.valueOf(first2), str5);
                }
                if (first2 == last2) {
                    return null;
                }
                first2 += step2;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static final int m10069b(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z2, boolean z3) {
        IntProgression intRange = !z3 ? new IntRange(C11226f.coerceAtLeast(i, 0), C11226f.coerceAtMost(i2, charSequence.length())) : C11226f.downTo(C11226f.coerceAtMost(i, getLastIndex(charSequence)), C11226f.coerceAtLeast(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if (step >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!C12103t.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z2)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = intRange.getFirst();
        int last2 = intRange.getLast();
        int step2 = intRange.getStep();
        if (step2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z2)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ int m10070c(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z2, boolean z3, int i3) {
        return m10069b(charSequence, charSequence2, i, i2, z2, (i3 & 16) != 0 ? false : z3);
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$contains");
        C12238m.checkNotNullParameter(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z2, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (m10070c(charSequence, charSequence2, 0, charSequence.length(), z2, false, 16) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return contains(charSequence, charSequence2, z2);
    }

    /* JADX INFO: renamed from: d */
    public static Sequence m10071d(CharSequence charSequence, String[] strArr, int i, boolean z2, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        requireNonNegativeLimit(i2);
        return new C12087d(charSequence, i, i2, new C12105v(C12139j.asList(strArr), z2));
    }

    /* JADX INFO: renamed from: e */
    public static final List<String> m10072e(CharSequence charSequence, String str, boolean z2, int i) {
        requireNonNegativeLimit(i);
        int length = 0;
        int iIndexOf = indexOf(charSequence, str, 0, z2);
        if (iIndexOf == -1 || i == 1) {
            return C12145m.listOf(charSequence.toString());
        }
        boolean z3 = i > 0;
        ArrayList arrayList = new ArrayList(z3 ? C11226f.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z3 && arrayList.size() == i - 1) {
                break;
            }
            iIndexOf = indexOf(charSequence, str, length, z2);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$endsWith");
        return charSequence.length() > 0 && C12085b.equals(charSequence.charAt(getLastIndex(charSequence)), c, z2);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return endsWith(charSequence, c, z2);
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$indices");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, char c, int i, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$indexOf");
        return (z2 || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c}, i, z2) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return indexOf(charSequence, c, i, z2);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z2) {
        boolean z3;
        C12238m.checkNotNullParameter(charSequence, "$this$indexOfAny");
        C12238m.checkNotNullParameter(cArr, "chars");
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(C12141k.single(cArr), i);
        }
        int iCoerceAtLeast = C11226f.coerceAtLeast(i, 0);
        int lastIndex = getLastIndex(charSequence);
        if (iCoerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iCoerceAtLeast);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z3 = false;
                    break;
                }
                if (C12085b.equals(cArr[i2], cCharAt, z2)) {
                    z3 = true;
                    break;
                }
                i2++;
            }
            if (z3) {
                return iCoerceAtLeast;
            }
            if (iCoerceAtLeast == lastIndex) {
                return -1;
            }
            iCoerceAtLeast++;
        }
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        return (z2 || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c}, i, z2) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return lastIndexOf(charSequence, c, i, z2);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$lastIndexOfAny");
        C12238m.checkNotNullParameter(cArr, "chars");
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(C12141k.single(cArr), i);
        }
        for (int iCoerceAtMost = C11226f.coerceAtMost(i, getLastIndex(charSequence)); iCoerceAtMost >= 0; iCoerceAtMost--) {
            char cCharAt = charSequence.charAt(iCoerceAtMost);
            boolean z3 = false;
            for (char c : cArr) {
                if (C12085b.equals(c, cCharAt, z2)) {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                return iCoerceAtMost;
            }
        }
        return -1;
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$lineSequence");
        return splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$lines");
        return C12078q.toList(lineSequence(charSequence));
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$regionMatchesImpl");
        C12238m.checkNotNullParameter(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C12085b.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z2)) {
                return false;
            }
        }
        return true;
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        C12238m.checkNotNullParameter(str, "$this$removePrefix");
        C12238m.checkNotNullParameter(charSequence, "prefix");
        if (!startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        C12238m.checkNotNullParameter(str, "$this$removeSuffix");
        C12238m.checkNotNullParameter(charSequence, "suffix");
        if (!endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        C12238m.checkNotNullParameter(str, "$this$removeSurrounding");
        C12238m.checkNotNullParameter(charSequence, "prefix");
        C12238m.checkNotNullParameter(charSequence2, "suffix");
        if (str.length() < charSequence2.length() + charSequence.length() || !startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) || !endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String replaceAfterLast(String str, char c, String str2, String str3) {
        C1643a.m872q0(str, "$this$replaceAfterLast", str2, "replacement", str3, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str3 : replaceRange(str, iLastIndexOf$default + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c, str2, str3);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        C12238m.checkNotNullParameter(charSequence, "$this$replaceRange");
        C12238m.checkNotNullParameter(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            C12238m.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            C12238m.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void requireNonNegativeLimit(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m871q("Limit must be non-negative, but was ", i).toString());
        }
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z2, int i) {
        C12238m.checkNotNullParameter(charSequence, "$this$split");
        C12238m.checkNotNullParameter(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return m10072e(charSequence, str, z2, i);
            }
        }
        Iterable iterableAsIterable = C12078q.asIterable(m10071d(charSequence, strArr, 0, z2, i, 2));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z2, i);
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, String[] strArr, boolean z2, int i) {
        C12238m.checkNotNullParameter(charSequence, "$this$splitToSequence");
        C12238m.checkNotNullParameter(strArr, "delimiters");
        return C12078q.map(m10071d(charSequence, strArr, 0, z2, i, 2), new a(charSequence));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z2, i);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$startsWith");
        return charSequence.length() > 0 && C12085b.equals(charSequence.charAt(0), c, z2);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return startsWith(charSequence, c, z2);
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        C12238m.checkNotNullParameter(charSequence, "$this$substring");
        C12238m.checkNotNullParameter(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substringAfter(String str, char c, String str2) {
        C12238m.checkNotNullParameter(str, "$this$substringAfter");
        C12238m.checkNotNullParameter(str2, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iIndexOf$default + 1, str.length());
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    public static final String substringAfterLast(String str, char c, String str2) {
        C12238m.checkNotNullParameter(str, "$this$substringAfterLast");
        C12238m.checkNotNullParameter(str2, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1, str.length());
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c, str2);
    }

    public static final String substringBefore(String str, char c, String str2) {
        C12238m.checkNotNullParameter(str, "$this$substringBefore");
        C12238m.checkNotNullParameter(str2, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    public static final String substringBeforeLast(String str, char c, String str2) {
        C12238m.checkNotNullParameter(str, "$this$substringBeforeLast");
        C12238m.checkNotNullParameter(str2, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    public static final CharSequence trim(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean zIsWhitespace = C12084a.isWhitespace(charSequence.charAt(!z2 ? i : length));
            if (z2) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z2 = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String trimStart(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        C12238m.checkNotNullParameter(str, "$this$trimStart");
        C12238m.checkNotNullParameter(cArr, "chars");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!C12141k.contains(cArr, str.charAt(i))) {
                charSequenceSubSequence = str.subSequence(i, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return contains(charSequence, c, z2);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$endsWith");
        C12238m.checkNotNullParameter(charSequence2, "suffix");
        return (!z2 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? C12103t.endsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z2);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return endsWith(charSequence, charSequence2, z2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return indexOf(charSequence, str, i, z2);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return lastIndexOf(charSequence, str, i, z2);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z2, i);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$startsWith");
        C12238m.checkNotNullParameter(charSequence2, "prefix");
        return (!z2 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? C12103t.startsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z2);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return startsWith(charSequence, charSequence2, z2);
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        C12238m.checkNotNullParameter(str, "$this$removeSurrounding");
        C12238m.checkNotNullParameter(charSequence, "delimiter");
        return removeSurrounding(str, charSequence, charSequence);
    }

    public static final String substringAfter(String str, String str2, String str3) {
        C1643a.m872q0(str, "$this$substringAfter", str2, "delimiter", str3, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iIndexOf$default, str.length());
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String substringBefore(String str, String str2, String str3) {
        C1643a.m872q0(str, "$this$substringBefore", str2, "delimiter", str3, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String substringBeforeLast(String str, String str2, String str3) {
        C1643a.m872q0(str, "$this$substringBeforeLast", str2, "delimiter", str3, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$contains");
        return indexOf$default(charSequence, c, 0, z2, 2, (Object) null) >= 0;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$indexOf");
        C12238m.checkNotNullParameter(str, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return m10070c(charSequence, str, i, charSequence.length(), z2, false, 16);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        C12238m.checkNotNullParameter(str, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return m10069b(charSequence, str, i, 0, z2, true);
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z2, int i) {
        C12238m.checkNotNullParameter(charSequence, "$this$split");
        C12238m.checkNotNullParameter(cArr, "delimiters");
        if (cArr.length == 1) {
            return m10072e(charSequence, String.valueOf(cArr[0]), z2, i);
        }
        requireNonNegativeLimit(i);
        Iterable iterableAsIterable = C12078q.asIterable(new C12087d(charSequence, 0, i, new C12104u(cArr, z2)));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }
}
