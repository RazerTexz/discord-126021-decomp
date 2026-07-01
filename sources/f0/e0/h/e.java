package f0.e0.h;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.t;
import d0.t.h0;
import d0.z.d.m;
import f0.n;
import f0.n$a;
import f0.p;
import f0.w;
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
import okhttp3.internal.publicsuffix.PublicSuffixDatabase$a;
import okio.ByteString;
import okio.ByteString$a;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final ByteString a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f3627b;

    static {
        ByteString$a byteString$a = ByteString.k;
        a = byteString$a.c("\"\\");
        f3627b = byteString$a.c("\t ,=");
    }

    public static final boolean a(Response response) {
        m.checkParameterIsNotNull(response, "$this$promisesBody");
        if (m.areEqual(response.request.method, "HEAD")) {
            return false;
        }
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && f0.e0.c.l(response) == -1 && !t.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) ? false : true;
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
    public static final void b(g0.e eVar, List<f0.i> list) throws EOFException {
        byte b2;
        boolean z2;
        String strC;
        g0.e eVar2;
        long jE;
        while (true) {
            String strC2 = null;
            while (true) {
                if (strC2 == null) {
                    e(eVar);
                    strC2 = c(eVar);
                    if (strC2 == null) {
                        return;
                    }
                }
                boolean zE = e(eVar);
                String strC3 = c(eVar);
                if (strC3 == null) {
                    if (eVar.w()) {
                        list.add(new f0.i(strC2, h0.emptyMap()));
                        return;
                    }
                    return;
                }
                byte b3 = (byte) 61;
                int iU = f0.e0.c.u(eVar, b3);
                boolean zE2 = e(eVar);
                if (zE || !(zE2 || eVar.w())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iU2 = f0.e0.c.u(eVar, b3) + iU;
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
                            if (eVar.w()) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (eVar.readByte() == b2) {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                                eVar2 = new g0.e();
                                while (true) {
                                    jE = eVar.E(a);
                                    if (jE != -1) {
                                        if (eVar.q(jE) == b2) {
                                            eVar2.write(eVar, jE);
                                            eVar.readByte();
                                            strC = eVar2.D();
                                            break;
                                        } else if (eVar.k == jE + 1) {
                                            eVar2.write(eVar, jE);
                                            eVar.readByte();
                                            eVar2.write(eVar, 1L);
                                        }
                                    }
                                    strC = null;
                                    break;
                                }
                            } else {
                                strC = c(eVar);
                            }
                            if (strC != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        strC3 = c(eVar);
                        if (e(eVar)) {
                            break;
                        }
                        iU2 = f0.e0.c.u(eVar, b3);
                        if (iU2 == 0) {
                            break;
                        }
                        if (iU2 <= 1 || e(eVar)) {
                            return;
                        }
                        b2 = (byte) 34;
                        if (eVar.w() || eVar.q(0L) != b2) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            if (eVar.readByte() == b2) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            eVar2 = new g0.e();
                            while (true) {
                                jE = eVar.E(a);
                                if (jE != -1) {
                                    if (eVar.q(jE) == b2) {
                                        eVar2.write(eVar, jE);
                                        eVar.readByte();
                                        strC = eVar2.D();
                                        break;
                                    } else if (eVar.k == jE + 1) {
                                        eVar2.write(eVar, jE);
                                        eVar.readByte();
                                        eVar2.write(eVar, 1L);
                                    }
                                }
                                strC = null;
                                break;
                            }
                        } else {
                            strC = c(eVar);
                        }
                        if (strC != null || ((String) linkedHashMap.put(strC3, strC)) != null) {
                            return;
                        }
                        if (!e(eVar) && !eVar.w()) {
                            return;
                        } else {
                            strC3 = null;
                        }
                    }
                    list.add(new f0.i(strC2, linkedHashMap));
                    strC2 = strC3;
                } else {
                    StringBuilder sbU = b.d.b.a.a.U(strC3);
                    sbU.append(t.repeat("=", iU));
                    Map mapSingletonMap = Collections.singletonMap(null, sbU.toString());
                    m.checkExpressionValueIsNotNull(mapSingletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                    list.add(new f0.i(strC2, mapSingletonMap));
                }
            }
        }
    }

    public static final String c(g0.e eVar) {
        long jE = eVar.E(f3627b);
        if (jE == -1) {
            jE = eVar.k;
        }
        if (jE != 0) {
            return eVar.H(jE);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0093  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c4  */
    public static final void d(p pVar, w wVar, Headers headers) {
        int i;
        List listEmptyList;
        List<n> listEmptyList2;
        String str;
        List list;
        int i2;
        String str2;
        n nVar;
        int i3;
        m.checkParameterIsNotNull(pVar, "$this$receiveHeaders");
        String str3 = "url";
        m.checkParameterIsNotNull(wVar, "url");
        m.checkParameterIsNotNull(headers, "headers");
        if (pVar == p.a) {
            return;
        }
        n$a n_a = n.e;
        m.checkParameterIsNotNull(wVar, "url");
        m.checkParameterIsNotNull(headers, "headers");
        Objects.requireNonNull(headers);
        m.checkParameterIsNotNull("Set-Cookie", ModelAuditLogEntry.CHANGE_KEY_NAME);
        int size = headers.size();
        int i4 = 0;
        int i5 = 0;
        ArrayList arrayList = null;
        while (true) {
            i = 2;
            if (i5 >= size) {
                break;
            }
            if (t.equals("Set-Cookie", headers.d(i5), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.g(i5));
            }
            i5++;
        }
        if (arrayList != null) {
            listEmptyList = Collections.unmodifiableList(arrayList);
            m.checkExpressionValueIsNotNull(listEmptyList, "Collections.unmodifiableList(result)");
        } else {
            listEmptyList = d0.t.n.emptyList();
        }
        List list2 = listEmptyList;
        int size2 = list2.size();
        int i6 = 0;
        ArrayList arrayList2 = null;
        while (i6 < size2) {
            String str4 = (String) list2.get(i6);
            m.checkParameterIsNotNull(wVar, str3);
            m.checkParameterIsNotNull(str4, "setCookie");
            long jCurrentTimeMillis = System.currentTimeMillis();
            m.checkParameterIsNotNull(wVar, str3);
            m.checkParameterIsNotNull(str4, "setCookie");
            int iH = f0.e0.c.h(str4, ';', i4, i4, 6);
            char c = '=';
            int iH2 = f0.e0.c.h(str4, '=', i4, iH, i);
            if (iH2 == iH) {
                str = str3;
                list = list2;
                i2 = size2;
                nVar = null;
            } else {
                String strC = f0.e0.c.C(str4, i4, iH2);
                if (strC.length() == 0) {
                    str = str3;
                    list = list2;
                    i2 = size2;
                } else if (f0.e0.c.n(strC) != -1) {
                    str = str3;
                    list = list2;
                    i2 = size2;
                } else {
                    String strC2 = f0.e0.c.C(str4, iH2 + 1, iH);
                    if (f0.e0.c.n(strC2) != -1) {
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
                                int iF = f0.e0.c.f(str4, ';', i7, length);
                                int iF2 = f0.e0.c.f(str4, c, i7, iF);
                                String strC3 = f0.e0.c.C(str4, i7, iF2);
                                String strC4 = iF2 < iF ? f0.e0.c.C(str4, iF2 + 1, iF) : "";
                                int i8 = size2;
                                if (t.equals(strC3, "expires", true)) {
                                    try {
                                        jC = n_a.c(strC4, 0, strC4.length());
                                        i3 = length;
                                        z4 = true;
                                    } catch (NumberFormatException | IllegalArgumentException unused) {
                                        i3 = length;
                                    }
                                } else if (t.equals(strC3, "max-age", true)) {
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
                                            if (t.startsWith$default(strC4, "-", false, 2, null)) {
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
                                    if (t.equals(strC3, "domain", true)) {
                                        if (!(!t.endsWith$default(strC4, ".", false, 2, null))) {
                                            throw new IllegalArgumentException("Failed requirement.".toString());
                                        }
                                        String strR1 = b.i.a.f.e.o.f.r1(d0.g0.w.removePrefix(strC4, "."));
                                        if (strR1 == null) {
                                            throw new IllegalArgumentException();
                                        }
                                        str5 = strR1;
                                        z5 = false;
                                    } else if (t.equals(strC3, "path", true)) {
                                        str6 = strC4;
                                    } else if (t.equals(strC3, "secure", true)) {
                                        z2 = true;
                                    } else if (t.equals(strC3, "httponly", true)) {
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
                                String str8 = wVar.g;
                                if (str5 == null) {
                                    str5 = str8;
                                } else if (n_a.b(str8, str5)) {
                                }
                                if (str8.length() != str5.length()) {
                                    PublicSuffixDatabase$a publicSuffixDatabase$a = PublicSuffixDatabase.d;
                                    if (PublicSuffixDatabase.c.a(str5) == null) {
                                    }
                                }
                                String strSubstring = AutocompleteViewModel.COMMAND_DISCOVER_TOKEN;
                                if (str6 == null || !t.startsWith$default(str6, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null)) {
                                    String strB = wVar.b();
                                    int iLastIndexOf$default = d0.g0.w.lastIndexOf$default((CharSequence) strB, MentionUtilsKt.SLASH_CHAR, 0, false, 6, (Object) null);
                                    if (iLastIndexOf$default != 0) {
                                        if (strB == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        strSubstring = strB.substring(0, iLastIndexOf$default);
                                        m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                    str2 = strSubstring;
                                } else {
                                    str2 = str6;
                                }
                                nVar = new n(strC, strC2, j, str5, str2, z2, z3, z4, z5, null);
                            }
                        }
                    }
                }
                nVar = null;
            }
            if (nVar != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(nVar);
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
            m.checkExpressionValueIsNotNull(listEmptyList2, "Collections.unmodifiableList(cookies)");
        } else {
            listEmptyList2 = d0.t.n.emptyList();
        }
        if (listEmptyList2.isEmpty()) {
            return;
        }
        pVar.a(wVar, listEmptyList2);
    }

    public static final boolean e(g0.e eVar) throws EOFException {
        boolean z2 = false;
        while (!eVar.w()) {
            byte bQ = eVar.q(0L);
            if (bQ == 9 || bQ == 32) {
                eVar.readByte();
            } else {
                if (bQ != 44) {
                    break;
                }
                eVar.readByte();
                z2 = true;
            }
        }
        return z2;
    }
}
