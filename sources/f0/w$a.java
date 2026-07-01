package f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ranges.IntProgression;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w$a {
    public static final w$a$a a = new w$a$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3682b;
    public String e;
    public final List<String> g;
    public List<String> h;
    public String i;
    public String c = "";
    public String d = "";
    public int f = -1;

    public w$a() {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add("");
    }

    public final w$a a(String str, String str2) {
        d0.z.d.m.checkParameterIsNotNull(str, "encodedName");
        if (this.h == null) {
            this.h = new ArrayList();
        }
        List<String> list = this.h;
        if (list == null) {
            d0.z.d.m.throwNpe();
        }
        w$b w_b = w.f3681b;
        list.add(w$b.a(w_b, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
        List<String> list2 = this.h;
        if (list2 == null) {
            d0.z.d.m.throwNpe();
        }
        list2.add(str2 != null ? w$b.a(w_b, str2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211) : null);
        return this;
    }

    public final w b() {
        ArrayList arrayList;
        String str = this.f3682b;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        w$b w_b = w.f3681b;
        String strD = w$b.d(w_b, this.c, 0, 0, false, 7);
        String strD2 = w$b.d(w_b, this.d, 0, 0, false, 7);
        String str2 = this.e;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iC = c();
        List<String> list = this.g;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(w$b.d(w.f3681b, (String) it.next(), 0, 0, false, 7));
        }
        List<String> list2 = this.h;
        if (list2 != null) {
            arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list2, 10));
            for (String str3 : list2) {
                arrayList.add(str3 != null ? w$b.d(w.f3681b, str3, 0, 0, true, 3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.i;
        return new w(str, strD, strD2, str2, iC, arrayList2, arrayList, str4 != null ? w$b.d(w.f3681b, str4, 0, 0, false, 7) : null, toString());
    }

    public final int c() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        String str = this.f3682b;
        if (str == null) {
            d0.z.d.m.throwNpe();
        }
        d0.z.d.m.checkParameterIsNotNull(str, "scheme");
        int iHashCode = str.hashCode();
        if (iHashCode != 3213448) {
            if (iHashCode == 99617003 && str.equals(Constants.SCHEME)) {
                return 443;
            }
        } else if (str.equals("http")) {
            return 80;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001c  */
    public final w$a d(String str) {
        List<String> listE;
        if (str != null) {
            w$b w_b = w.f3681b;
            String strA = w$b.a(w_b, str, 0, 0, " \"'<>#", true, false, true, false, null, 211);
            if (strA != null) {
                listE = w_b.e(strA);
            } else {
                listE = null;
            }
        } else {
            listE = null;
        }
        this.h = listE;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:188:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    public final w$a e(w wVar, String str) {
        int i;
        char c;
        char c2;
        int iG;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        String str2;
        int i9;
        ?? r14;
        int i10;
        String str3;
        w$a w_a;
        w$a w_a2;
        String str4;
        int i11;
        String str5;
        int i12;
        w$a w_a3;
        int i13;
        String str6;
        char cCharAt;
        String str7 = str;
        d0.z.d.m.checkParameterIsNotNull(str7, "input");
        byte[] bArr = f0.e0.c.a;
        int iO = f0.e0.c.o(str7, 0, str.length());
        int iP = f0.e0.c.p(str7, iO, str.length());
        int i14 = iP - iO;
        char c3 = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
        char c4 = 65535;
        if (i14 >= 2) {
            char cCharAt2 = str7.charAt(iO);
            char c5 = 'Z';
            char c6 = 'z';
            if ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || (cCharAt2 >= 'A' && cCharAt2 <= 'Z')) {
                i = iO;
                while (true) {
                    i++;
                    if (i < iP) {
                        char cCharAt3 = str7.charAt(i);
                        if (('a' > cCharAt3 || c6 < cCharAt3) && (('A' > cCharAt3 || c5 < cCharAt3) && (('0' > cCharAt3 || '9' < cCharAt3) && cCharAt3 != '+' && cCharAt3 != '-' && cCharAt3 != '.'))) {
                            if (cCharAt3 == ':') {
                                break;
                            }
                            break;
                        }
                        c5 = 'Z';
                        c6 = 'z';
                    }
                    i = -1;
                    break;
                }
            } else {
                i = -1;
                break;
            }
        } else {
            i = -1;
            break;
        }
        if (i != -1) {
            if (d0.g0.t.startsWith(str7, "https:", iO, true)) {
                this.f3682b = Constants.SCHEME;
                iO += 6;
            } else {
                if (!d0.g0.t.startsWith(str7, "http:", iO, true)) {
                    StringBuilder sbU = b.d.b.a.a.U("Expected URL scheme 'http' or 'https' but was '");
                    String strSubstring = str7.substring(0, i);
                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sbU.append(strSubstring);
                    sbU.append("'");
                    throw new IllegalArgumentException(sbU.toString());
                }
                this.f3682b = "http";
                iO += 5;
            }
        } else {
            if (wVar == null) {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            this.f3682b = wVar.d;
        }
        int i15 = 0;
        int i16 = iO;
        while (true) {
            c = MentionUtilsKt.SLASH_CHAR;
            c2 = '\\';
            if (i16 >= iP || !((cCharAt = str7.charAt(i16)) == '\\' || cCharAt == '/')) {
                break;
            }
            i15++;
            i16++;
        }
        char c7 = '?';
        if (i15 >= 2 || wVar == null || (!d0.z.d.m.areEqual(wVar.d, this.f3682b))) {
            int i17 = iO + i15;
            char c8 = MentionUtilsKt.CHANNELS_CHAR;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                iG = f0.e0.c.g(str7, "@/\\?#", i17, iP);
                char cCharAt4 = iG != iP ? str7.charAt(iG) : (char) 65535;
                if (cCharAt4 == c4 || cCharAt4 == c8 || cCharAt4 == c || cCharAt4 == c2 || cCharAt4 == c7) {
                    break;
                }
                if (cCharAt4 != '@') {
                    iP = iP;
                } else {
                    if (z3) {
                        boolean z5 = z3;
                        i8 = iG;
                        this.d += "%40" + w$b.a(w.f3681b, str, i17, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                        z2 = z5;
                    } else {
                        int iF = f0.e0.c.f(str7, c3, i17, iG);
                        w$b w_b = w.f3681b;
                        boolean z6 = z3;
                        i8 = iG;
                        String strA = w$b.a(w_b, str, i17, iF, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                        if (z4) {
                            strA = b.d.b.a.a.K(new StringBuilder(), this.c, "%40", strA);
                        }
                        this.c = strA;
                        if (iF != i8) {
                            this.d = w$b.a(w_b, str, iF + 1, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                            z2 = true;
                        } else {
                            z2 = z6;
                        }
                        z4 = true;
                    }
                    i17 = i8 + 1;
                    z3 = z2;
                }
                c8 = MentionUtilsKt.CHANNELS_CHAR;
                c7 = '?';
                c2 = '\\';
                c = MentionUtilsKt.SLASH_CHAR;
                c4 = 65535;
                c3 = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
                iP = iP;
            }
            i2 = iP;
            int i18 = i17;
            while (true) {
                if (i18 < iG) {
                    char cCharAt5 = str7.charAt(i18);
                    if (cCharAt5 == ':') {
                        i3 = i18;
                        break;
                    }
                    if (cCharAt5 == '[') {
                        do {
                            i18++;
                            if (i18 >= iG) {
                                break;
                            }
                        } while (str7.charAt(i18) != ']');
                    }
                    i18++;
                } else {
                    i3 = iG;
                    break;
                }
            }
            int i19 = i3 + 1;
            char c9 = '\"';
            if (i19 < iG) {
                w$b w_b2 = w.f3681b;
                this.e = b.i.a.f.e.o.f.r1(w$b.d(w_b2, str, i17, i3, false, 4));
                i4 = i17;
                try {
                    i7 = Integer.parseInt(w$b.a(w_b2, str, i19, iG, "", false, false, false, false, null, 248));
                    if (1 <= i7 && 65535 >= i7) {
                        i6 = 1;
                    } else {
                        i6 = 1;
                        i7 = -1;
                    }
                } catch (NumberFormatException unused) {
                }
                this.f = i7;
                if (!(i7 != -1)) {
                    StringBuilder sbU2 = b.d.b.a.a.U("Invalid URL port: \"");
                    String strSubstring2 = str7.substring(i19, iG);
                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sbU2.append(strSubstring2);
                    sbU2.append('\"');
                    throw new IllegalArgumentException(sbU2.toString().toString());
                }
                c9 = '\"';
                i5 = i6;
            } else {
                i4 = i17;
                w$b w_b3 = w.f3681b;
                this.e = b.i.a.f.e.o.f.r1(w$b.d(w_b3, str, i4, i3, false, 4));
                String str8 = this.f3682b;
                if (str8 == null) {
                    d0.z.d.m.throwNpe();
                }
                this.f = w_b3.b(str8);
                i5 = 1;
            }
            if (!(this.e != null)) {
                StringBuilder sbU3 = b.d.b.a.a.U("Invalid URL host: \"");
                String strSubstring3 = str7.substring(i4, i3);
                d0.z.d.m.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sbU3.append(strSubstring3);
                sbU3.append(c9);
                throw new IllegalArgumentException(sbU3.toString().toString());
            }
            iO = iG;
        } else {
            this.c = wVar.e();
            this.d = wVar.a();
            this.e = wVar.g;
            this.f = wVar.h;
            this.g.clear();
            this.g.addAll(wVar.c());
            if (iO == iP || str7.charAt(iO) == '#') {
                d(wVar.d());
            }
            i5 = 1;
            i2 = iP;
        }
        int i20 = i2;
        int iG2 = f0.e0.c.g(str7, "?#", iO, i20);
        if (iO == iG2) {
            w_a3 = this;
            i13 = i20;
            str5 = str7;
        } else {
            char cCharAt6 = str7.charAt(iO);
            if (cCharAt6 == '/' || cCharAt6 == '\\') {
                this.g.clear();
                this.g.add("");
                int i21 = i5;
                str2 = str7;
                i9 = iO + i21;
                r14 = i21;
                i10 = iG2;
                str3 = "";
                w_a = this;
                w_a2 = this;
                str4 = str7;
                i11 = i20;
                str5 = str7;
                i12 = iG2;
            } else {
                List<String> list = this.g;
                list.set(list.size() - i5, "");
                w_a2 = this;
                w_a = w_a2;
                r14 = i5;
                i10 = iG2;
                i11 = i20;
                str3 = "";
                str2 = str7;
                str4 = str2;
                str5 = str4;
                i9 = iO;
                i12 = i10;
            }
            while (i9 < i12) {
                int iG3 = f0.e0.c.g(str4, "/\\", i9, i12);
                boolean z7 = iG3 < i12;
                String str9 = str4;
                w$a w_a4 = w_a2;
                String str10 = str3;
                int i22 = i12;
                String strA2 = w$b.a(w.f3681b, str4, i9, iG3, " \"<>^`{}|/\\?#", true, false, false, false, null, 240);
                if (d0.z.d.m.areEqual(strA2, ".") || d0.g0.t.equals(strA2, "%2e", r14)) {
                    w_a2 = w_a4;
                    str6 = str10;
                } else {
                    if (d0.z.d.m.areEqual(strA2, "..") || d0.g0.t.equals(strA2, "%2e.", r14) || d0.g0.t.equals(strA2, ".%2e", r14) || d0.g0.t.equals(strA2, "%2e%2e", r14)) {
                        w_a2 = w_a4;
                        List<String> list2 = w_a2.g;
                        if (list2.remove(list2.size() - (r14 == true ? 1 : 0)).length() == 0) {
                            if (((w_a2.g.isEmpty() ? 1 : 0) ^ (r14 == true ? 1 : 0)) != 0) {
                                List<String> list3 = w_a2.g;
                                str6 = str10;
                                list3.set(list3.size() - (r14 == true ? 1 : 0), str6);
                            } else {
                                str6 = str10;
                                w_a2.g.add(str6);
                            }
                        } else {
                            str6 = str10;
                            w_a2.g.add(str6);
                        }
                    } else {
                        w_a2 = w_a4;
                        str6 = str10;
                        List<String> list4 = w_a2.g;
                        if (list4.get(list4.size() - (r14 == true ? 1 : 0)).length() == 0) {
                            List<String> list5 = w_a2.g;
                            list5.set(list5.size() - (r14 == true ? 1 : 0), strA2);
                        } else {
                            w_a2.g.add(strA2);
                        }
                        if (z7) {
                            w_a2.g.add(str6);
                        }
                    }
                }
                if (z7) {
                    String str11 = str6;
                    String str12 = str5;
                    ?? r3 = r14 == true ? 1 : 0;
                    int i23 = i10;
                    w$a w_a5 = w_a;
                    int i24 = i11;
                    i9 = iG3 + (r3 == true ? 1 : 0);
                    r14 = r3 == true ? 1 : 0;
                    i10 = i23;
                    str3 = str11;
                    w_a = w_a5;
                    str4 = str9;
                    i11 = i24;
                    str5 = str12;
                    i12 = i22;
                } else {
                    str3 = str6;
                    str4 = str9;
                    i12 = i22;
                    i9 = iG3;
                }
            }
            str7 = str2;
            iG2 = i10;
            w_a3 = w_a;
            i13 = i11;
        }
        if (iG2 < i13 && str5.charAt(iG2) == '?') {
            int iF2 = f0.e0.c.f(str5, MentionUtilsKt.CHANNELS_CHAR, iG2, i13);
            w$b w_b4 = w.f3681b;
            w_a3.h = w_b4.e(w$b.a(w_b4, str7, iG2 + 1, iF2, " \"'<>#", true, false, true, false, null, 208));
            iG2 = iF2;
        }
        if (iG2 < i13 && str5.charAt(iG2) == '#') {
            w_a3.i = w$b.a(w.f3681b, str7, iG2 + 1, i13, "", true, false, false, true, null, Opcodes.ARETURN);
        }
        return w_a3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x0043  */
    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ba  */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f3682b;
        if (str != null) {
            sb.append(str);
            sb.append("://");
        } else {
            sb.append("//");
        }
        if (this.c.length() > 0) {
            sb.append(this.c);
            if (this.d.length() > 0) {
                sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                sb.append(this.d);
            }
            sb.append(MentionUtilsKt.MENTIONS_CHAR);
        } else if (this.d.length() > 0) {
            sb.append(this.c);
            if (this.d.length() > 0) {
                sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                sb.append(this.d);
            }
            sb.append(MentionUtilsKt.MENTIONS_CHAR);
        }
        String str2 = this.e;
        if (str2 != null) {
            if (str2 == null) {
                d0.z.d.m.throwNpe();
            }
            if (d0.g0.w.contains$default((CharSequence) str2, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
                sb.append('[');
                sb.append(this.e);
                sb.append(']');
            } else {
                sb.append(this.e);
            }
        }
        int i = -1;
        if (this.f != -1 || this.f3682b != null) {
            int iC = c();
            String str3 = this.f3682b;
            if (str3 == null) {
                sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                sb.append(iC);
            } else {
                if (str3 == null) {
                    d0.z.d.m.throwNpe();
                }
                d0.z.d.m.checkParameterIsNotNull(str3, "scheme");
                int iHashCode = str3.hashCode();
                if (iHashCode != 3213448) {
                    if (iHashCode == 99617003 && str3.equals(Constants.SCHEME)) {
                        i = 443;
                    }
                } else if (str3.equals("http")) {
                    i = 80;
                }
                if (iC != i) {
                    sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(iC);
                }
            }
        }
        List<String> list = this.g;
        d0.z.d.m.checkParameterIsNotNull(list, "$this$toPathString");
        d0.z.d.m.checkParameterIsNotNull(sb, "out");
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(MentionUtilsKt.SLASH_CHAR);
            sb.append(list.get(i2));
        }
        if (this.h != null) {
            sb.append('?');
            List<String> list2 = this.h;
            if (list2 == null) {
                d0.z.d.m.throwNpe();
            }
            d0.z.d.m.checkParameterIsNotNull(list2, "$this$toQueryString");
            d0.z.d.m.checkParameterIsNotNull(sb, "out");
            IntProgression intProgressionStep = d0.d0.f.step(d0.d0.f.until(0, list2.size()), 2);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    String str4 = list2.get(first);
                    String str5 = list2.get(first + 1);
                    if (first > 0) {
                        sb.append('&');
                    }
                    sb.append(str4);
                    if (str5 != null) {
                        sb.append('=');
                        sb.append(str5);
                    }
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        if (this.i != null) {
            sb.append(MentionUtilsKt.CHANNELS_CHAR);
            sb.append(this.i);
        }
        String string = sb.toString();
        d0.z.d.m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
