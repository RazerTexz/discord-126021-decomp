package p600f0.p601e0.p606h;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12365i;
import p600f0.C12370n;
import p600f0.C12379w;
import p600f0.InterfaceC12372p;
import p600f0.p601e0.C12272c;
import p615g0.C12388e;

/* JADX INFO: renamed from: f0.e0.h.e */
/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12299e {

    /* JADX INFO: renamed from: a */
    public static final ByteString f25529a;

    /* JADX INFO: renamed from: b */
    public static final ByteString f25530b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f25529a = companion.m11012c("\"\\");
        f25530b = companion.m11012c("\t ,=");
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m10221a(Response response) {
        C12238m.checkParameterIsNotNull(response, "$this$promisesBody");
        if (C12238m.areEqual(response.request.method, "HEAD")) {
            return false;
        }
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && C12272c.m10131l(response) == -1 && !C12103t.equals("chunked", Response.m10989a(response, "Transfer-Encoding", null, 2), true)) ? false : true;
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
    /* JADX INFO: renamed from: b */
    public static final void m10222b(C12388e c12388e, List<C12365i> list) throws EOFException {
        byte b2;
        boolean z2;
        String strM10223c;
        C12388e c12388e2;
        long jMo10430E;
        while (true) {
            String strM10223c2 = null;
            while (true) {
                if (strM10223c2 == null) {
                    m10225e(c12388e);
                    strM10223c2 = m10223c(c12388e);
                    if (strM10223c2 == null) {
                        return;
                    }
                }
                boolean zM10225e = m10225e(c12388e);
                String strM10223c3 = m10223c(c12388e);
                if (strM10223c3 == null) {
                    if (c12388e.mo10472w()) {
                        list.add(new C12365i(strM10223c2, C12136h0.emptyMap()));
                        return;
                    }
                    return;
                }
                byte b3 = (byte) 61;
                int iM10140u = C12272c.m10140u(c12388e, b3);
                boolean zM10225e2 = m10225e(c12388e);
                if (zM10225e || !(zM10225e2 || c12388e.mo10472w())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iM10140u2 = C12272c.m10140u(c12388e, b3) + iM10140u;
                    while (true) {
                        if (strM10223c3 != null) {
                            if (iM10140u2 == 0) {
                                break;
                                break;
                            }
                            if (iM10140u2 <= 1) {
                                return;
                            }
                            b2 = (byte) 34;
                            if (c12388e.mo10472w()) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (c12388e.readByte() == b2) {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                                c12388e2 = new C12388e();
                                while (true) {
                                    jMo10430E = c12388e.mo10430E(f25529a);
                                    if (jMo10430E != -1) {
                                        if (c12388e.m10464q(jMo10430E) == b2) {
                                            c12388e2.write(c12388e, jMo10430E);
                                            c12388e.readByte();
                                            strM10223c = c12388e2.m10429D();
                                            break;
                                        } else if (c12388e.f26080k == jMo10430E + 1) {
                                            c12388e2.write(c12388e, jMo10430E);
                                            c12388e.readByte();
                                            c12388e2.write(c12388e, 1L);
                                        }
                                    }
                                    strM10223c = null;
                                    break;
                                }
                            } else {
                                strM10223c = m10223c(c12388e);
                            }
                            if (strM10223c != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        strM10223c3 = m10223c(c12388e);
                        if (m10225e(c12388e)) {
                            break;
                        }
                        iM10140u2 = C12272c.m10140u(c12388e, b3);
                        if (iM10140u2 == 0) {
                            break;
                        }
                        if (iM10140u2 <= 1 || m10225e(c12388e)) {
                            return;
                        }
                        b2 = (byte) 34;
                        if (c12388e.mo10472w() || c12388e.m10464q(0L) != b2) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            if (c12388e.readByte() == b2) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            c12388e2 = new C12388e();
                            while (true) {
                                jMo10430E = c12388e.mo10430E(f25529a);
                                if (jMo10430E != -1) {
                                    if (c12388e.m10464q(jMo10430E) == b2) {
                                        c12388e2.write(c12388e, jMo10430E);
                                        c12388e.readByte();
                                        strM10223c = c12388e2.m10429D();
                                        break;
                                    } else if (c12388e.f26080k == jMo10430E + 1) {
                                        c12388e2.write(c12388e, jMo10430E);
                                        c12388e.readByte();
                                        c12388e2.write(c12388e, 1L);
                                    }
                                }
                                strM10223c = null;
                                break;
                            }
                        } else {
                            strM10223c = m10223c(c12388e);
                        }
                        if (strM10223c != null || ((String) linkedHashMap.put(strM10223c3, strM10223c)) != null) {
                            return;
                        }
                        if (!m10225e(c12388e) && !c12388e.mo10472w()) {
                            return;
                        } else {
                            strM10223c3 = null;
                        }
                    }
                    list.add(new C12365i(strM10223c2, linkedHashMap));
                    strM10223c2 = strM10223c3;
                } else {
                    StringBuilder sbM833U = C1643a.m833U(strM10223c3);
                    sbM833U.append(C12103t.repeat("=", iM10140u));
                    Map mapSingletonMap = Collections.singletonMap(null, sbM833U.toString());
                    C12238m.checkExpressionValueIsNotNull(mapSingletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                    list.add(new C12365i(strM10223c2, mapSingletonMap));
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static final String m10223c(C12388e c12388e) {
        long jMo10430E = c12388e.mo10430E(f25530b);
        if (jMo10430E == -1) {
            jMo10430E = c12388e.f26080k;
        }
        if (jMo10430E != 0) {
            return c12388e.m10433H(jMo10430E);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0093  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c4  */
    /* JADX INFO: renamed from: d */
    public static final void m10224d(InterfaceC12372p interfaceC12372p, C12379w c12379w, Headers headers) {
        int i;
        List listEmptyList;
        List<C12370n> listEmptyList2;
        String str;
        List list;
        int i2;
        String str2;
        C12370n c12370n;
        int i3;
        C12238m.checkParameterIsNotNull(interfaceC12372p, "$this$receiveHeaders");
        String str3 = "url";
        C12238m.checkParameterIsNotNull(c12379w, "url");
        C12238m.checkParameterIsNotNull(headers, "headers");
        if (interfaceC12372p == InterfaceC12372p.f25956a) {
            return;
        }
        C12370n.a aVar = C12370n.f25946e;
        C12238m.checkParameterIsNotNull(c12379w, "url");
        C12238m.checkParameterIsNotNull(headers, "headers");
        Objects.requireNonNull(headers);
        C12238m.checkParameterIsNotNull("Set-Cookie", ModelAuditLogEntry.CHANGE_KEY_NAME);
        int size = headers.size();
        int i4 = 0;
        int i5 = 0;
        ArrayList arrayList = null;
        while (true) {
            i = 2;
            if (i5 >= size) {
                break;
            }
            if (C12103t.equals("Set-Cookie", headers.m10955d(i5), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.m10957g(i5));
            }
            i5++;
        }
        if (arrayList != null) {
            listEmptyList = Collections.unmodifiableList(arrayList);
            C12238m.checkExpressionValueIsNotNull(listEmptyList, "Collections.unmodifiableList(result)");
        } else {
            listEmptyList = C12147n.emptyList();
        }
        List list2 = listEmptyList;
        int size2 = list2.size();
        int i6 = 0;
        ArrayList arrayList2 = null;
        while (i6 < size2) {
            String str4 = (String) list2.get(i6);
            C12238m.checkParameterIsNotNull(c12379w, str3);
            C12238m.checkParameterIsNotNull(str4, "setCookie");
            long jCurrentTimeMillis = System.currentTimeMillis();
            C12238m.checkParameterIsNotNull(c12379w, str3);
            C12238m.checkParameterIsNotNull(str4, "setCookie");
            int iM10127h = C12272c.m10127h(str4, ';', i4, i4, 6);
            char c = '=';
            int iM10127h2 = C12272c.m10127h(str4, '=', i4, iM10127h, i);
            if (iM10127h2 == iM10127h) {
                str = str3;
                list = list2;
                i2 = size2;
                c12370n = null;
            } else {
                String strM10118C = C12272c.m10118C(str4, i4, iM10127h2);
                if (strM10118C.length() == 0) {
                    str = str3;
                    list = list2;
                    i2 = size2;
                } else if (C12272c.m10133n(strM10118C) != -1) {
                    str = str3;
                    list = list2;
                    i2 = size2;
                } else {
                    String strM10118C2 = C12272c.m10118C(str4, iM10127h2 + 1, iM10127h);
                    if (C12272c.m10133n(strM10118C2) != -1) {
                        str = str3;
                        list = list2;
                        i2 = size2;
                    } else {
                        int i7 = iM10127h + 1;
                        int length = str4.length();
                        long j = 253402300799999L;
                        long jM10387c = 253402300799999L;
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
                                int iM10125f = C12272c.m10125f(str4, ';', i7, length);
                                int iM10125f2 = C12272c.m10125f(str4, c, i7, iM10125f);
                                String strM10118C3 = C12272c.m10118C(str4, i7, iM10125f2);
                                String strM10118C4 = iM10125f2 < iM10125f ? C12272c.m10118C(str4, iM10125f2 + 1, iM10125f) : "";
                                int i8 = size2;
                                if (C12103t.equals(strM10118C3, "expires", true)) {
                                    try {
                                        jM10387c = aVar.m10387c(strM10118C4, 0, strM10118C4.length());
                                        i3 = length;
                                        z4 = true;
                                    } catch (NumberFormatException | IllegalArgumentException unused) {
                                        i3 = length;
                                    }
                                } else if (C12103t.equals(strM10118C3, "max-age", true)) {
                                    try {
                                        long j4 = Long.parseLong(strM10118C4);
                                        i3 = length;
                                        j2 = j4 > 0 ? j4 : Long.MIN_VALUE;
                                    } catch (NumberFormatException e) {
                                        if (!new Regex("-?\\d+").matches(strM10118C4)) {
                                            i3 = length;
                                            throw e;
                                        }
                                        i3 = length;
                                        try {
                                            if (C12103t.startsWith$default(strM10118C4, "-", false, 2, null)) {
                                                j3 = Long.MIN_VALUE;
                                            }
                                            j2 = j3;
                                        } catch (NumberFormatException | IllegalArgumentException unused2) {
                                        }
                                        i7 = iM10125f + 1;
                                        list2 = list3;
                                        str3 = str7;
                                        size2 = i8;
                                        length = i3;
                                        c = '=';
                                    }
                                    z4 = true;
                                } else {
                                    i3 = length;
                                    if (C12103t.equals(strM10118C3, "domain", true)) {
                                        if (!(!C12103t.endsWith$default(strM10118C4, ".", false, 2, null))) {
                                            throw new IllegalArgumentException("Failed requirement.".toString());
                                        }
                                        String strM4337r1 = C3404f.m4337r1(C12106w.removePrefix(strM10118C4, "."));
                                        if (strM4337r1 == null) {
                                            throw new IllegalArgumentException();
                                        }
                                        str5 = strM4337r1;
                                        z5 = false;
                                    } else if (C12103t.equals(strM10118C3, "path", true)) {
                                        str6 = strM10118C4;
                                    } else if (C12103t.equals(strM10118C3, "secure", true)) {
                                        z2 = true;
                                    } else if (C12103t.equals(strM10118C3, "httponly", true)) {
                                        z3 = true;
                                    }
                                }
                                i7 = iM10125f + 1;
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
                                    j = jM10387c;
                                }
                                String str8 = c12379w.f25979g;
                                if (str5 == null) {
                                    str5 = str8;
                                } else if (aVar.m10386b(str8, str5)) {
                                }
                                if (str8.length() != str5.length()) {
                                    PublicSuffixDatabase.C12940a c12940a = PublicSuffixDatabase.f27587d;
                                    if (PublicSuffixDatabase.f27586c.m11002a(str5) == null) {
                                    }
                                }
                                String strSubstring = AutocompleteViewModel.COMMAND_DISCOVER_TOKEN;
                                if (str6 == null || !C12103t.startsWith$default(str6, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null)) {
                                    String strM10400b = c12379w.m10400b();
                                    int iLastIndexOf$default = C12106w.lastIndexOf$default((CharSequence) strM10400b, MentionUtilsKt.SLASH_CHAR, 0, false, 6, (Object) null);
                                    if (iLastIndexOf$default != 0) {
                                        if (strM10400b == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        strSubstring = strM10400b.substring(0, iLastIndexOf$default);
                                        C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                    str2 = strSubstring;
                                } else {
                                    str2 = str6;
                                }
                                c12370n = new C12370n(strM10118C, strM10118C2, j, str5, str2, z2, z3, z4, z5, null);
                            }
                        }
                    }
                }
                c12370n = null;
            }
            if (c12370n != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(c12370n);
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
            C12238m.checkExpressionValueIsNotNull(listEmptyList2, "Collections.unmodifiableList(cookies)");
        } else {
            listEmptyList2 = C12147n.emptyList();
        }
        if (listEmptyList2.isEmpty()) {
            return;
        }
        interfaceC12372p.mo8745a(c12379w, listEmptyList2);
    }

    /* JADX INFO: renamed from: e */
    public static final boolean m10225e(C12388e c12388e) throws EOFException {
        boolean z2 = false;
        while (!c12388e.mo10472w()) {
            byte bM10464q = c12388e.m10464q(0L);
            if (bM10464q == 9 || bM10464q == 32) {
                c12388e.readByte();
            } else {
                if (bM10464q != 44) {
                    break;
                }
                c12388e.readByte();
                z2 = true;
            }
        }
        return z2;
    }
}
