package f0;

import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.badge.BadgeDrawable;
import d0.d0._Ranges;
import d0.g0.Charsets2;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import g0.Buffer3;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Progressions2;
import kotlin.text.Regex;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: f0.w, reason: use source file name */
/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpUrl {
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final List<String> i;
    public final List<String> j;
    public final String k;
    public final String l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3681b = new b(null);
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: f0.w$a */
    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class a {
        public static final C0423a a = new C0423a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3682b;
        public String e;
        public final List<String> g;
        public List<String> h;
        public String i;
        public String c = "";
        public String d = "";
        public int f = -1;

        /* JADX INFO: renamed from: f0.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUrl.kt */
        public static final class C0423a {
            public C0423a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.g = arrayList;
            arrayList.add("");
        }

        public final a a(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, "encodedName");
            if (this.h == null) {
                this.h = new ArrayList();
            }
            List<String> list = this.h;
            if (list == null) {
                Intrinsics3.throwNpe();
            }
            b bVar = HttpUrl.f3681b;
            list.add(b.a(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
            List<String> list2 = this.h;
            if (list2 == null) {
                Intrinsics3.throwNpe();
            }
            list2.add(str2 != null ? b.a(bVar, str2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211) : null);
            return this;
        }

        public final HttpUrl b() {
            ArrayList arrayList;
            String str = this.f3682b;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = HttpUrl.f3681b;
            String strD = b.d(bVar, this.c, 0, 0, false, 7);
            String strD2 = b.d(bVar, this.d, 0, 0, false, 7);
            String str2 = this.e;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iC = c();
            List<String> list = this.g;
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.d(HttpUrl.f3681b, (String) it.next(), 0, 0, false, 7));
            }
            List<String> list2 = this.h;
            if (list2 != null) {
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? b.d(HttpUrl.f3681b, str3, 0, 0, true, 3) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.i;
            return new HttpUrl(str, strD, strD2, str2, iC, arrayList2, arrayList, str4 != null ? b.d(HttpUrl.f3681b, str4, 0, 0, false, 7) : null, toString());
        }

        public final int c() {
            int i = this.f;
            if (i != -1) {
                return i;
            }
            String str = this.f3682b;
            if (str == null) {
                Intrinsics3.throwNpe();
            }
            Intrinsics3.checkParameterIsNotNull(str, "scheme");
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
        public final a d(String str) {
            List<String> listE;
            if (str != null) {
                b bVar = HttpUrl.f3681b;
                String strA = b.a(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211);
                if (strA != null) {
                    listE = bVar.e(strA);
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
        public final a e(HttpUrl httpUrl, String str) {
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
            a aVar;
            a aVar2;
            String str4;
            int i11;
            String str5;
            int i12;
            a aVar3;
            int i13;
            String str6;
            char cCharAt;
            String str7 = str;
            Intrinsics3.checkParameterIsNotNull(str7, "input");
            byte[] bArr = Util7.a;
            int iO = Util7.o(str7, 0, str.length());
            int iP = Util7.p(str7, iO, str.length());
            int i14 = iP - iO;
            char c3 = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
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
                if (StringsJVM.startsWith(str7, "https:", iO, true)) {
                    this.f3682b = Constants.SCHEME;
                    iO += 6;
                } else {
                    if (!StringsJVM.startsWith(str7, "http:", iO, true)) {
                        StringBuilder sbU = outline.U("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str7.substring(0, i);
                        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sbU.append(strSubstring);
                        sbU.append("'");
                        throw new IllegalArgumentException(sbU.toString());
                    }
                    this.f3682b = "http";
                    iO += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f3682b = httpUrl.d;
            }
            int i15 = 0;
            int i16 = iO;
            while (true) {
                c = MentionUtils.SLASH_CHAR;
                c2 = '\\';
                if (i16 >= iP || !((cCharAt = str7.charAt(i16)) == '\\' || cCharAt == '/')) {
                    break;
                }
                i15++;
                i16++;
            }
            char c7 = '?';
            if (i15 >= 2 || httpUrl == null || (!Intrinsics3.areEqual(httpUrl.d, this.f3682b))) {
                int i17 = iO + i15;
                char c8 = MentionUtils.CHANNELS_CHAR;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    iG = Util7.g(str7, "@/\\?#", i17, iP);
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
                            this.d += "%40" + b.a(HttpUrl.f3681b, str, i17, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                            z2 = z5;
                        } else {
                            int iF = Util7.f(str7, c3, i17, iG);
                            b bVar = HttpUrl.f3681b;
                            boolean z6 = z3;
                            i8 = iG;
                            String strA = b.a(bVar, str, i17, iF, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                            if (z4) {
                                strA = outline.K(new StringBuilder(), this.c, "%40", strA);
                            }
                            this.c = strA;
                            if (iF != i8) {
                                this.d = b.a(bVar, str, iF + 1, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                                z2 = true;
                            } else {
                                z2 = z6;
                            }
                            z4 = true;
                        }
                        i17 = i8 + 1;
                        z3 = z2;
                    }
                    c8 = MentionUtils.CHANNELS_CHAR;
                    c7 = '?';
                    c2 = '\\';
                    c = MentionUtils.SLASH_CHAR;
                    c4 = 65535;
                    c3 = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
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
                    b bVar2 = HttpUrl.f3681b;
                    this.e = b.i.a.f.e.o.f.r1(b.d(bVar2, str, i17, i3, false, 4));
                    i4 = i17;
                    try {
                        i7 = Integer.parseInt(b.a(bVar2, str, i19, iG, "", false, false, false, false, null, 248));
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
                        StringBuilder sbU2 = outline.U("Invalid URL port: \"");
                        String strSubstring2 = str7.substring(i19, iG);
                        Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sbU2.append(strSubstring2);
                        sbU2.append('\"');
                        throw new IllegalArgumentException(sbU2.toString().toString());
                    }
                    c9 = '\"';
                    i5 = i6;
                } else {
                    i4 = i17;
                    b bVar3 = HttpUrl.f3681b;
                    this.e = b.i.a.f.e.o.f.r1(b.d(bVar3, str, i4, i3, false, 4));
                    String str8 = this.f3682b;
                    if (str8 == null) {
                        Intrinsics3.throwNpe();
                    }
                    this.f = bVar3.b(str8);
                    i5 = 1;
                }
                if (!(this.e != null)) {
                    StringBuilder sbU3 = outline.U("Invalid URL host: \"");
                    String strSubstring3 = str7.substring(i4, i3);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sbU3.append(strSubstring3);
                    sbU3.append(c9);
                    throw new IllegalArgumentException(sbU3.toString().toString());
                }
                iO = iG;
            } else {
                this.c = httpUrl.e();
                this.d = httpUrl.a();
                this.e = httpUrl.g;
                this.f = httpUrl.h;
                this.g.clear();
                this.g.addAll(httpUrl.c());
                if (iO == iP || str7.charAt(iO) == '#') {
                    d(httpUrl.d());
                }
                i5 = 1;
                i2 = iP;
            }
            int i20 = i2;
            int iG2 = Util7.g(str7, "?#", iO, i20);
            if (iO == iG2) {
                aVar3 = this;
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
                    aVar = this;
                    aVar2 = this;
                    str4 = str7;
                    i11 = i20;
                    str5 = str7;
                    i12 = iG2;
                } else {
                    List<String> list = this.g;
                    list.set(list.size() - i5, "");
                    aVar2 = this;
                    aVar = aVar2;
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
                    int iG3 = Util7.g(str4, "/\\", i9, i12);
                    boolean z7 = iG3 < i12;
                    String str9 = str4;
                    a aVar4 = aVar2;
                    String str10 = str3;
                    int i22 = i12;
                    String strA2 = b.a(HttpUrl.f3681b, str4, i9, iG3, " \"<>^`{}|/\\?#", true, false, false, false, null, 240);
                    if (Intrinsics3.areEqual(strA2, ".") || StringsJVM.equals(strA2, "%2e", r14)) {
                        aVar2 = aVar4;
                        str6 = str10;
                    } else {
                        if (Intrinsics3.areEqual(strA2, "..") || StringsJVM.equals(strA2, "%2e.", r14) || StringsJVM.equals(strA2, ".%2e", r14) || StringsJVM.equals(strA2, "%2e%2e", r14)) {
                            aVar2 = aVar4;
                            List<String> list2 = aVar2.g;
                            if (list2.remove(list2.size() - (r14 == true ? 1 : 0)).length() == 0) {
                                if (((aVar2.g.isEmpty() ? 1 : 0) ^ (r14 == true ? 1 : 0)) != 0) {
                                    List<String> list3 = aVar2.g;
                                    str6 = str10;
                                    list3.set(list3.size() - (r14 == true ? 1 : 0), str6);
                                } else {
                                    str6 = str10;
                                    aVar2.g.add(str6);
                                }
                            } else {
                                str6 = str10;
                                aVar2.g.add(str6);
                            }
                        } else {
                            aVar2 = aVar4;
                            str6 = str10;
                            List<String> list4 = aVar2.g;
                            if (list4.get(list4.size() - (r14 == true ? 1 : 0)).length() == 0) {
                                List<String> list5 = aVar2.g;
                                list5.set(list5.size() - (r14 == true ? 1 : 0), strA2);
                            } else {
                                aVar2.g.add(strA2);
                            }
                            if (z7) {
                                aVar2.g.add(str6);
                            }
                        }
                    }
                    if (z7) {
                        String str11 = str6;
                        String str12 = str5;
                        ?? r3 = r14 == true ? 1 : 0;
                        int i23 = i10;
                        a aVar5 = aVar;
                        int i24 = i11;
                        i9 = iG3 + (r3 == true ? 1 : 0);
                        r14 = r3 == true ? 1 : 0;
                        i10 = i23;
                        str3 = str11;
                        aVar = aVar5;
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
                aVar3 = aVar;
                i13 = i11;
            }
            if (iG2 < i13 && str5.charAt(iG2) == '?') {
                int iF2 = Util7.f(str5, MentionUtils.CHANNELS_CHAR, iG2, i13);
                b bVar4 = HttpUrl.f3681b;
                aVar3.h = bVar4.e(b.a(bVar4, str7, iG2 + 1, iF2, " \"'<>#", true, false, true, false, null, 208));
                iG2 = iF2;
            }
            if (iG2 < i13 && str5.charAt(iG2) == '#') {
                aVar3.i = b.a(HttpUrl.f3681b, str7, iG2 + 1, i13, "", true, false, false, true, null, Opcodes.ARETURN);
            }
            return aVar3;
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
                    sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(this.d);
                }
                sb.append(MentionUtils.MENTIONS_CHAR);
            } else if (this.d.length() > 0) {
                sb.append(this.c);
                if (this.d.length() > 0) {
                    sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(this.d);
                }
                sb.append(MentionUtils.MENTIONS_CHAR);
            }
            String str2 = this.e;
            if (str2 != null) {
                if (str2 == null) {
                    Intrinsics3.throwNpe();
                }
                if (Strings4.contains$default((CharSequence) str2, MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
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
                    sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(iC);
                } else {
                    if (str3 == null) {
                        Intrinsics3.throwNpe();
                    }
                    Intrinsics3.checkParameterIsNotNull(str3, "scheme");
                    int iHashCode = str3.hashCode();
                    if (iHashCode != 3213448) {
                        if (iHashCode == 99617003 && str3.equals(Constants.SCHEME)) {
                            i = 443;
                        }
                    } else if (str3.equals("http")) {
                        i = 80;
                    }
                    if (iC != i) {
                        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                        sb.append(iC);
                    }
                }
            }
            List<String> list = this.g;
            Intrinsics3.checkParameterIsNotNull(list, "$this$toPathString");
            Intrinsics3.checkParameterIsNotNull(sb, "out");
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(MentionUtils.SLASH_CHAR);
                sb.append(list.get(i2));
            }
            if (this.h != null) {
                sb.append('?');
                List<String> list2 = this.h;
                if (list2 == null) {
                    Intrinsics3.throwNpe();
                }
                Intrinsics3.checkParameterIsNotNull(list2, "$this$toQueryString");
                Intrinsics3.checkParameterIsNotNull(sb, "out");
                Progressions2 progressions2Step = _Ranges.step(_Ranges.until(0, list2.size()), 2);
                int first = progressions2Step.getFirst();
                int last = progressions2Step.getLast();
                int step = progressions2Step.getStep();
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
                sb.append(MentionUtils.CHANNELS_CHAR);
                sb.append(this.i);
            }
            String string = sb.toString();
            Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    /* JADX INFO: renamed from: f0.w$b */
    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static String a(b bVar, String str, int i, int i2, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i3) {
            int i4;
            String str3;
            boolean z6;
            String str4;
            int i5 = (i3 & 1) != 0 ? 0 : i;
            int length = (i3 & 2) != 0 ? str.length() : i2;
            boolean z7 = (i3 & 8) != 0 ? false : z2;
            boolean z8 = (i3 & 16) != 0 ? false : z3;
            boolean z9 = (i3 & 32) != 0 ? false : z4;
            boolean z10 = (i3 & 64) != 0 ? false : z5;
            Charset charset2 = (i3 & 128) != 0 ? null : charset;
            Intrinsics3.checkParameterIsNotNull(str, "$this$canonicalize");
            Intrinsics3.checkParameterIsNotNull(str2, "encodeSet");
            int iCharCount = i5;
            while (true) {
                if (iCharCount >= length) {
                    String strSubstring = str.substring(i5, length);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return strSubstring;
                }
                int iCodePointAt = str.codePointAt(iCharCount);
                i4 = 2;
                if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && !z10)) {
                    str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                    break;
                }
                str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                if (Strings4.contains$default((CharSequence) str2, (char) iCodePointAt, false, 2, (Object) null) || ((iCodePointAt == 37 && (!z7 || (z8 && !bVar.c(str, iCharCount, length)))) || (iCodePointAt == 43 && z9))) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            Buffer3 buffer3 = new Buffer3();
            buffer3.c0(str, i5, iCharCount);
            Buffer3 buffer4 = null;
            while (iCharCount < length) {
                int iCodePointAt2 = str.codePointAt(iCharCount);
                if (z7 && (iCodePointAt2 == 9 || iCodePointAt2 == 10 || iCodePointAt2 == 12 || iCodePointAt2 == 13)) {
                    z6 = z9;
                    str4 = str3;
                } else if (iCodePointAt2 == 43 && z9) {
                    buffer3.b0(z7 ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                    z6 = z9;
                    str4 = str3;
                } else {
                    if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || (iCodePointAt2 >= 128 && !z10)) {
                        z6 = z9;
                    } else {
                        z6 = z9;
                        if (!Strings4.contains$default((CharSequence) str2, (char) iCodePointAt2, false, i4, (Object) null) && (iCodePointAt2 != 37 || (z7 && (!z8 || bVar.c(str, iCharCount, length))))) {
                            buffer3.d0(iCodePointAt2);
                            str4 = str3;
                        }
                    }
                    if (buffer4 == null) {
                        buffer4 = new Buffer3();
                    }
                    if (charset2 == null || Intrinsics3.areEqual(charset2, StandardCharsets.UTF_8)) {
                        str4 = str3;
                        buffer4.d0(iCodePointAt2);
                    } else {
                        int iCharCount2 = Character.charCount(iCodePointAt2) + iCharCount;
                        Intrinsics3.checkParameterIsNotNull(str, "string");
                        Intrinsics3.checkParameterIsNotNull(charset2, "charset");
                        if (!(iCharCount >= 0)) {
                            throw new IllegalArgumentException(outline.q("beginIndex < 0: ", iCharCount).toString());
                        }
                        if (!(iCharCount2 >= iCharCount)) {
                            throw new IllegalArgumentException(outline.s("endIndex < beginIndex: ", iCharCount2, " < ", iCharCount).toString());
                        }
                        if (!(iCharCount2 <= str.length())) {
                            StringBuilder sbV = outline.V("endIndex > string.length: ", iCharCount2, " > ");
                            sbV.append(str.length());
                            throw new IllegalArgumentException(sbV.toString().toString());
                        }
                        if (Intrinsics3.areEqual(charset2, Charsets2.a)) {
                            buffer4.c0(str, iCharCount, iCharCount2);
                            str4 = str3;
                        } else {
                            String strSubstring2 = str.substring(iCharCount, iCharCount2);
                            str4 = str3;
                            Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, str4);
                            if (strSubstring2 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            byte[] bytes = strSubstring2.getBytes(charset2);
                            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                            buffer4.S(bytes, 0, bytes.length);
                        }
                    }
                    while (!buffer4.w()) {
                        int i6 = buffer4.readByte() & 255;
                        buffer3.T(37);
                        char[] cArr = HttpUrl.a;
                        buffer3.T(cArr[(i6 >> 4) & 15]);
                        buffer3.T(cArr[i6 & 15]);
                    }
                }
                iCharCount += Character.charCount(iCodePointAt2);
                i4 = 2;
                z9 = z6;
                str3 = str4;
            }
            return buffer3.D();
        }

        public static String d(b bVar, String str, int i, int i2, boolean z2, int i3) {
            int i4;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            Intrinsics3.checkParameterIsNotNull(str, "$this$percentDecode");
            int iCharCount = i;
            while (iCharCount < i2) {
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                    Buffer3 buffer3 = new Buffer3();
                    buffer3.c0(str, i, iCharCount);
                    while (iCharCount < i2) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                            int iR = Util7.r(str.charAt(iCharCount + 1));
                            int iR2 = Util7.r(str.charAt(i4));
                            if (iR == -1 || iR2 == -1) {
                                buffer3.d0(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                buffer3.T((iR << 4) + iR2);
                                iCharCount = Character.charCount(iCodePointAt) + i4;
                            }
                        } else if (iCodePointAt == 43 && z2) {
                            buffer3.T(32);
                            iCharCount++;
                        } else {
                            buffer3.d0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return buffer3.D();
                }
                iCharCount++;
            }
            String strSubstring = str.substring(i, i2);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final int b(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "scheme");
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

        public final boolean c(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util7.r(str.charAt(i + 1)) != -1 && Util7.r(str.charAt(i3)) != -1;
        }

        public final List<String> e(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = Strings4.indexOf$default((CharSequence) str, '&', i, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int i2 = iIndexOf$default;
                int iIndexOf$default2 = Strings4.indexOf$default((CharSequence) str, '=', i, false, 4, (Object) null);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > i2) {
                    String strSubstring = str.substring(i, i2);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iIndexOf$default2);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iIndexOf$default2 + 1, i2);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = i2 + 1;
            }
            return arrayList;
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        Intrinsics3.checkParameterIsNotNull(str, "scheme");
        Intrinsics3.checkParameterIsNotNull(str2, "username");
        Intrinsics3.checkParameterIsNotNull(str3, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        Intrinsics3.checkParameterIsNotNull(str4, "host");
        Intrinsics3.checkParameterIsNotNull(list, "pathSegments");
        Intrinsics3.checkParameterIsNotNull(str6, "url");
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = i;
        this.i = list;
        this.j = list2;
        this.k = str5;
        this.l = str6;
        this.c = Intrinsics3.areEqual(str, Constants.SCHEME);
    }

    public final String a() {
        if (this.f.length() == 0) {
            return "";
        }
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.l, MentionUtils.EMOJIS_AND_STICKERS_CHAR, this.d.length() + 3, false, 4, (Object) null) + 1;
        int iIndexOf$default2 = Strings4.indexOf$default((CharSequence) this.l, MentionUtils.MENTIONS_CHAR, 0, false, 6, (Object) null);
        String str = this.l;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iIndexOf$default, iIndexOf$default2);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.l, MentionUtils.SLASH_CHAR, this.d.length() + 3, false, 4, (Object) null);
        String str = this.l;
        int iG = Util7.g(str, "?#", iIndexOf$default, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iG);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> c() {
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.l, MentionUtils.SLASH_CHAR, this.d.length() + 3, false, 4, (Object) null);
        String str = this.l;
        int iG = Util7.g(str, "?#", iIndexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iG) {
            int i = iIndexOf$default + 1;
            int iF = Util7.f(this.l, MentionUtils.SLASH_CHAR, i, iG);
            String str2 = this.l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i, iF);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.j == null) {
            return null;
        }
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.l, '?', 0, false, 6, (Object) null) + 1;
        String str = this.l;
        int iF = Util7.f(str, MentionUtils.CHANNELS_CHAR, iIndexOf$default, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iF);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.e.length() == 0) {
            return "";
        }
        int length = this.d.length() + 3;
        String str = this.l;
        int iG = Util7.g(str, ":@", length, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iG);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics3.areEqual(((HttpUrl) obj).l, this.l);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    public final a f() {
        int i;
        String strSubstring;
        a aVar = new a();
        aVar.f3682b = this.d;
        String strE = e();
        Intrinsics3.checkParameterIsNotNull(strE, "<set-?>");
        aVar.c = strE;
        String strA = a();
        Intrinsics3.checkParameterIsNotNull(strA, "<set-?>");
        aVar.d = strA;
        aVar.e = this.g;
        int i2 = this.h;
        String str = this.d;
        Intrinsics3.checkParameterIsNotNull(str, "scheme");
        int iHashCode = str.hashCode();
        if (iHashCode != 3213448) {
            if (iHashCode == 99617003 && str.equals(Constants.SCHEME)) {
                i = 443;
            } else {
                i = -1;
            }
        } else if (str.equals("http")) {
            i = 80;
        } else {
            i = -1;
        }
        aVar.f = i2 != i ? this.h : -1;
        aVar.g.clear();
        aVar.g.addAll(c());
        aVar.d(d());
        if (this.k == null) {
            strSubstring = null;
        } else {
            int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.l, MentionUtils.CHANNELS_CHAR, 0, false, 6, (Object) null) + 1;
            String str2 = this.l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str2.substring(iIndexOf$default);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        aVar.i = strSubstring;
        return aVar;
    }

    public final a g(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "link");
        try {
            a aVar = new a();
            aVar.e(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String h() {
        a aVarG = g("/...");
        if (aVarG == null) {
            Intrinsics3.throwNpe();
        }
        Objects.requireNonNull(aVarG);
        Intrinsics3.checkParameterIsNotNull("", "username");
        b bVar = f3681b;
        aVarG.c = b.a(bVar, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        Intrinsics3.checkParameterIsNotNull("", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        aVarG.d = b.a(bVar, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        return aVarG.b().l;
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    public final URI i() {
        a aVarF = f();
        String str = aVarF.e;
        aVarF.e = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
        int size = aVarF.g.size();
        for (int i = 0; i < size; i++) {
            List<String> list = aVarF.g;
            list.set(i, b.a(f3681b, list.get(i), 0, 0, "[]", true, true, false, false, null, 227));
        }
        List<String> list2 = aVarF.h;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = list2.get(i2);
                list2.set(i2, str2 != null ? b.a(f3681b, str2, 0, 0, "\\^`{|}", true, true, true, false, null, Opcodes.MONITOREXIT) : null);
            }
        }
        String str3 = aVarF.i;
        aVarF.i = str3 != null ? b.a(f3681b, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, Opcodes.IF_ICMPGT) : null;
        String string = aVarF.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics3.checkExpressionValueIsNotNull(uriCreate, "URI.create(stripped)");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.l;
    }
}
