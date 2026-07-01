package f0.e0.h;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import f0.Challenge;
import f0.Cookie;
import f0.CookieJar2;
import f0.HttpUrl;
import f0.e0.Util7;
import g0.Buffer3;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;

/* JADX INFO: renamed from: f0.e0.h.e, reason: use source file name */
/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpHeaders {
    public static final ByteString a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f3627b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        a = companion.c("\"\\");
        f3627b = companion.c("\t ,=");
    }

    public static final boolean a(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "$this$promisesBody");
        if (Intrinsics3.areEqual(response.request.method, "HEAD")) {
            return false;
        }
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && Util7.l(response) == -1 && !StringsJVM.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0091  */
    /* JADX WARN: Code duplicated, block: B:40:0x00af  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:54:0x00df  */
    /* JADX WARN: Code duplicated, block: B:57:0x00eb A[LOOP:3: B:48:0x00c1->B:57:0x00eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x0101  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0086 A[EDGE_INSN: B:82:0x0086->B:28:0x0086 BREAK  A[LOOP:2: B:22:0x0072->B:70:0x011d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0091, please report this as an issue */
    public static final void b(Buffer3 buffer3, List<Challenge> list) throws EOFException {
        byte b2;
        boolean z2;
        String strC;
        Buffer3 buffer4;
        long jE;
        while (true) {
            String strC2 = null;
            while (true) {
                if (strC2 == null) {
                    e(buffer3);
                    strC2 = c(buffer3);
                    if (strC2 == null) {
                        return;
                    }
                }
                boolean zE = e(buffer3);
                String strC3 = c(buffer3);
                if (strC3 == null) {
                    if (buffer3.w()) {
                        list.add(new Challenge(strC2, Maps6.emptyMap()));
                        return;
                    }
                    return;
                }
                byte b3 = (byte) 61;
                int iU = Util7.u(buffer3, b3);
                boolean zE2 = e(buffer3);
                if (zE || !(zE2 || buffer3.w())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iU2 = Util7.u(buffer3, b3) + iU;
                    while (true) {
                        if (strC3 != null) {
                            if (iU2 == 0) {
                                break;
                                break;
                            }
                            if (iU2 <= 1) {
                                return;
                            }
                            b2 = (byte) 34;
                            if (buffer3.w()) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (buffer3.readByte() == b2) {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                                buffer4 = new Buffer3();
                                while (true) {
                                    jE = buffer3.E(a);
                                    if (jE != -1) {
                                        if (buffer3.q(jE) == b2) {
                                            buffer4.write(buffer3, jE);
                                            buffer3.readByte();
                                            strC = buffer4.D();
                                            break;
                                        } else if (buffer3.k == jE + 1) {
                                            buffer4.write(buffer3, jE);
                                            buffer3.readByte();
                                            buffer4.write(buffer3, 1L);
                                        }
                                    }
                                    strC = null;
                                    break;
                                }
                            } else {
                                strC = c(buffer3);
                            }
                            if (strC != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        strC3 = c(buffer3);
                        if (e(buffer3)) {
                            break;
                        }
                        iU2 = Util7.u(buffer3, b3);
                        if (iU2 == 0) {
                            break;
                        }
                        if (iU2 <= 1 || e(buffer3)) {
                            return;
                        }
                        b2 = (byte) 34;
                        if (buffer3.w() || buffer3.q(0L) != b2) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            if (buffer3.readByte() == b2) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            buffer4 = new Buffer3();
                            while (true) {
                                jE = buffer3.E(a);
                                if (jE != -1) {
                                    if (buffer3.q(jE) == b2) {
                                        buffer4.write(buffer3, jE);
                                        buffer3.readByte();
                                        strC = buffer4.D();
                                        break;
                                    } else if (buffer3.k == jE + 1) {
                                        buffer4.write(buffer3, jE);
                                        buffer3.readByte();
                                        buffer4.write(buffer3, 1L);
                                    }
                                }
                                strC = null;
                                break;
                            }
                        } else {
                            strC = c(buffer3);
                        }
                        if (strC != null || ((String) linkedHashMap.put(strC3, strC)) != null) {
                            return;
                        }
                        if (!e(buffer3) && !buffer3.w()) {
                            return;
                        } else {
                            strC3 = null;
                        }
                    }
                    list.add(new Challenge(strC2, linkedHashMap));
                    strC2 = strC3;
                } else {
                    StringBuilder sbU = outline.U(strC3);
                    sbU.append(StringsJVM.repeat("=", iU));
                    Map mapSingletonMap = Collections.singletonMap(null, sbU.toString());
                    Intrinsics3.checkExpressionValueIsNotNull(mapSingletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                    list.add(new Challenge(strC2, mapSingletonMap));
                }
            }
        }
    }

    public static final String c(Buffer3 buffer3) {
        long jE = buffer3.E(f3627b);
        if (jE == -1) {
            jE = buffer3.k;
        }
        if (jE != 0) {
            return buffer3.H(jE);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0093  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c4  */
    public static final void d(CookieJar2 cookieJar2, HttpUrl httpUrl, Headers headers) {
        int i;
        List listEmptyList;
        List<Cookie> listEmptyList2;
        String str;
        List list;
        int i2;
        String str2;
        Cookie cookie;
        int i3;
        Intrinsics3.checkParameterIsNotNull(cookieJar2, "$this$receiveHeaders");
        String str3 = "url";
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        if (cookieJar2 == CookieJar2.a) {
            return;
        }
        Cookie.a aVar = Cookie.e;
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        Objects.requireNonNull(headers);
        Intrinsics3.checkParameterIsNotNull("Set-Cookie", ModelAuditLogEntry.CHANGE_KEY_NAME);
        int size = headers.size();
        int i4 = 0;
        int i5 = 0;
        ArrayList arrayList = null;
        while (true) {
            i = 2;
            if (i5 >= size) {
                break;
            }
            if (StringsJVM.equals("Set-Cookie", headers.d(i5), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.g(i5));
            }
            i5++;
        }
        if (arrayList != null) {
            listEmptyList = Collections.unmodifiableList(arrayList);
            Intrinsics3.checkExpressionValueIsNotNull(listEmptyList, "Collections.unmodifiableList(result)");
        } else {
            listEmptyList = Collections2.emptyList();
        }
        List list2 = listEmptyList;
        int size2 = list2.size();
        int i6 = 0;
        ArrayList arrayList2 = null;
        while (i6 < size2) {
            String str4 = (String) list2.get(i6);
            Intrinsics3.checkParameterIsNotNull(httpUrl, str3);
            Intrinsics3.checkParameterIsNotNull(str4, "setCookie");
            long jCurrentTimeMillis = System.currentTimeMillis();
            Intrinsics3.checkParameterIsNotNull(httpUrl, str3);
            Intrinsics3.checkParameterIsNotNull(str4, "setCookie");
            int iH = Util7.h(str4, ';', i4, i4, 6);
            char c = '=';
            int iH2 = Util7.h(str4, '=', i4, iH, i);
            if (iH2 == iH) {
                str = str3;
                list = list2;
                i2 = size2;
                cookie = null;
            } else {
                String strC = Util7.C(str4, i4, iH2);
                if (strC.length() == 0) {
                    str = str3;
                    list = list2;
                    i2 = size2;
                } else if (Util7.n(strC) != -1) {
                    str = str3;
                    list = list2;
                    i2 = size2;
                } else {
                    String strC2 = Util7.C(str4, iH2 + 1, iH);
                    if (Util7.n(strC2) != -1) {
                        str = str3;
                        list = list2;
                        i2 = size2;
                    } else {
                        int i7 = iH + 1;
                        int length = str4.length();
                        long j = 253402300799999L;
                        long jC = 253402300799999L;
                        long j2 = -1;
                        String str5 = null;
                        String str6 = null;
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = false;
                        boolean z5 = true;
                        while (true) {
                            long j3 = RecyclerView.FOREVER_NS;
                            if (i7 < length) {
                                String str7 = str3;
                                List list3 = list2;
                                int iF = Util7.f(str4, ';', i7, length);
                                int iF2 = Util7.f(str4, c, i7, iF);
                                String strC3 = Util7.C(str4, i7, iF2);
                                String strC4 = iF2 < iF ? Util7.C(str4, iF2 + 1, iF) : "";
                                int i8 = size2;
                                if (StringsJVM.equals(strC3, "expires", true)) {
                                    try {
                                        jC = aVar.c(strC4, 0, strC4.length());
                                        i3 = length;
                                        z4 = true;
                                    } catch (NumberFormatException | IllegalArgumentException unused) {
                                        i3 = length;
                                    }
                                } else if (StringsJVM.equals(strC3, "max-age", true)) {
                                    try {
                                        long j4 = Long.parseLong(strC4);
                                        i3 = length;
                                        j2 = j4 > 0 ? j4 : Long.MIN_VALUE;
                                    } catch (NumberFormatException e) {
                                        if (!new Regex("-?\\d+").matches(strC4)) {
                                            i3 = length;
                                            throw e;
                                        }
                                        i3 = length;
                                        try {
                                            if (StringsJVM.startsWith$default(strC4, "-", false, 2, null)) {
                                                j3 = Long.MIN_VALUE;
                                            }
                                            j2 = j3;
                                        } catch (NumberFormatException | IllegalArgumentException unused2) {
                                        }
                                        i7 = iF + 1;
                                        list2 = list3;
                                        str3 = str7;
                                        size2 = i8;
                                        length = i3;
                                        c = '=';
                                    }
                                    z4 = true;
                                } else {
                                    i3 = length;
                                    if (StringsJVM.equals(strC3, "domain", true)) {
                                        if (!(!StringsJVM.endsWith$default(strC4, ".", false, 2, null))) {
                                            throw new IllegalArgumentException("Failed requirement.".toString());
                                        }
                                        String strR1 = b.i.a.f.e.o.f.r1(Strings4.removePrefix(strC4, "."));
                                        if (strR1 == null) {
                                            throw new IllegalArgumentException();
                                        }
                                        str5 = strR1;
                                        z5 = false;
                                    } else if (StringsJVM.equals(strC3, "path", true)) {
                                        str6 = strC4;
                                    } else if (StringsJVM.equals(strC3, "secure", true)) {
                                        z2 = true;
                                    } else if (StringsJVM.equals(strC3, "httponly", true)) {
                                        z3 = true;
                                    }
                                }
                                i7 = iF + 1;
                                list2 = list3;
                                str3 = str7;
                                size2 = i8;
                                length = i3;
                                c = '=';
                            } else {
                                str = str3;
                                list = list2;
                                i2 = size2;
                                if (j2 == Long.MIN_VALUE) {
                                    j = Long.MIN_VALUE;
                                } else if (j2 != -1) {
                                    if (j2 <= 9223372036854775L) {
                                        j3 = j2 * ((long) 1000);
                                    }
                                    long j5 = jCurrentTimeMillis + j3;
                                    if (j5 >= jCurrentTimeMillis && j5 <= 253402300799999L) {
                                        j = j5;
                                    }
                                } else {
                                    j = jC;
                                }
                                String str8 = httpUrl.g;
                                if (str5 == null) {
                                    str5 = str8;
                                } else if (aVar.b(str8, str5)) {
                                }
                                if (str8.length() != str5.length()) {
                                    PublicSuffixDatabase.a aVar2 = PublicSuffixDatabase.d;
                                    if (PublicSuffixDatabase.c.a(str5) == null) {
                                    }
                                }
                                String strSubstring = AutocompleteViewModel.COMMAND_DISCOVER_TOKEN;
                                if (str6 == null || !StringsJVM.startsWith$default(str6, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null)) {
                                    String strB = httpUrl.b();
                                    int iLastIndexOf$default = Strings4.lastIndexOf$default((CharSequence) strB, MentionUtils.SLASH_CHAR, 0, false, 6, (Object) null);
                                    if (iLastIndexOf$default != 0) {
                                        if (strB == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        strSubstring = strB.substring(0, iLastIndexOf$default);
                                        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                    str2 = strSubstring;
                                } else {
                                    str2 = str6;
                                }
                                cookie = new Cookie(strC, strC2, j, str5, str2, z2, z3, z4, z5, null);
                            }
                        }
                    }
                }
                cookie = null;
            }
            if (cookie != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(cookie);
            }
            i6++;
            list2 = list;
            str3 = str;
            size2 = i2;
            i4 = 0;
            i = 2;
        }
        if (arrayList2 != null) {
            listEmptyList2 = Collections.unmodifiableList(arrayList2);
            Intrinsics3.checkExpressionValueIsNotNull(listEmptyList2, "Collections.unmodifiableList(cookies)");
        } else {
            listEmptyList2 = Collections2.emptyList();
        }
        if (listEmptyList2.isEmpty()) {
            return;
        }
        cookieJar2.a(httpUrl, listEmptyList2);
    }

    public static final boolean e(Buffer3 buffer3) throws EOFException {
        boolean z2 = false;
        while (!buffer3.w()) {
            byte bQ = buffer3.q(0L);
            if (bQ == 9 || bQ == 32) {
                buffer3.readByte();
            } else {
                if (bQ != 44) {
                    break;
                }
                buffer3.readByte();
                z2 = true;
            }
        }
        return z2;
    }
}
