package p600f0.p601e0;

import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12086c;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12264b0;
import p600f0.C12379w;
import p600f0.C12380x;
import p600f0.p601e0.p608j.C12308b;
import p615g0.C12388e;
import p615g0.C12398o;
import p615g0.InterfaceC12390g;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.c */
/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12272c {

    /* JADX INFO: renamed from: a */
    public static final byte[] f25397a;

    /* JADX INFO: renamed from: b */
    public static final Headers f25398b = Headers.INSTANCE.m10964c(new String[0]);

    /* JADX INFO: renamed from: c */
    public static final ResponseBody f25399c;

    /* JADX INFO: renamed from: d */
    public static final C12398o f25400d;

    /* JADX INFO: renamed from: e */
    public static final TimeZone f25401e;

    /* JADX INFO: renamed from: f */
    public static final Regex f25402f;

    /* JADX INFO: renamed from: g */
    public static final String f25403g;

    static {
        byte[] bArr = new byte[0];
        f25397a = bArr;
        C12238m.checkParameterIsNotNull(bArr, "$this$toResponseBody");
        C12388e c12388e = new C12388e();
        c12388e.m10442R(bArr);
        C12238m.checkParameterIsNotNull(c12388e, "$this$asResponseBody");
        f25399c = new C12264b0(c12388e, null, 0);
        RequestBody.Companion.m10986d(RequestBody.INSTANCE, bArr, null, 0, 0, 7);
        C12398o.a aVar = C12398o.f26106k;
        ByteString.Companion companion = ByteString.INSTANCE;
        f25400d = aVar.m10491c(companion.m11010a("efbbbf"), companion.m11010a("feff"), companion.m11010a("fffe"), companion.m11010a("0000ffff"), companion.m11010a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            C12238m.throwNpe();
        }
        f25401e = timeZone;
        f25402f = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String name = C12380x.class.getName();
        C12238m.checkExpressionValueIsNotNull(name, "OkHttpClient::class.java.name");
        f25403g = C12106w.removeSuffix(C12106w.removePrefix(name, "okhttp3."), "Client");
    }

    /* JADX INFO: renamed from: A */
    public static final <K, V> Map<K, V> m10116A(Map<K, ? extends V> map) {
        C12238m.checkParameterIsNotNull(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return C12136h0.emptyMap();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        C12238m.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    /* JADX INFO: renamed from: B */
    public static final int m10117B(String str, int i) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: C */
    public static final String m10118C(String str, int i, int i2) {
        C12238m.checkParameterIsNotNull(str, "$this$trimSubstring");
        int iM10134o = m10134o(str, i, i2);
        String strSubstring = str.substring(iM10134o, m10135p(str, iM10134o, i2));
        C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX INFO: renamed from: D */
    public static final Throwable m10119D(Exception exc, List<? extends Exception> list) {
        C12238m.checkParameterIsNotNull(exc, "$this$withSuppressed");
        C12238m.checkParameterIsNotNull(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            exc.addSuppressed(it.next());
        }
        return exc;
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m10120a(C12379w c12379w, C12379w c12379w2) {
        C12238m.checkParameterIsNotNull(c12379w, "$this$canReuseConnectionFor");
        C12238m.checkParameterIsNotNull(c12379w2, "other");
        return C12238m.areEqual(c12379w.f25979g, c12379w2.f25979g) && c12379w.f25980h == c12379w2.f25980h && C12238m.areEqual(c12379w.f25976d, c12379w2.f25976d);
    }

    /* JADX INFO: renamed from: b */
    public static final int m10121b(String str, long j, TimeUnit timeUnit) {
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!(j >= 0)) {
            throw new IllegalStateException(C1643a.m883w(str, " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(C1643a.m883w(str, " too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(C1643a.m883w(str, " too small.").toString());
    }

    /* JADX INFO: renamed from: c */
    public static final void m10122c(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* JADX INFO: renamed from: d */
    public static final void m10123d(Closeable closeable) {
        C12238m.checkParameterIsNotNull(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: e */
    public static final void m10124e(Socket socket) {
        C12238m.checkParameterIsNotNull(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: f */
    public static final int m10125f(String str, char c, int i, int i2) {
        C12238m.checkParameterIsNotNull(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: g */
    public static final int m10126g(String str, String str2, int i, int i2) {
        C12238m.checkParameterIsNotNull(str, "$this$delimiterOffset");
        C12238m.checkParameterIsNotNull(str2, "delimiters");
        while (i < i2) {
            if (C12106w.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ int m10127h(String str, char c, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return m10125f(str, c, i, i2);
    }

    /* JADX INFO: renamed from: i */
    public static final boolean m10128i(InterfaceC12407x interfaceC12407x, int i, TimeUnit timeUnit) {
        C12238m.checkParameterIsNotNull(interfaceC12407x, "$this$discard");
        C12238m.checkParameterIsNotNull(timeUnit, "timeUnit");
        try {
            return m10141v(interfaceC12407x, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: j */
    public static final String m10129j(String str, Object... objArr) {
        C12238m.checkParameterIsNotNull(str, "format");
        C12238m.checkParameterIsNotNull(objArr, "args");
        Locale locale = Locale.US;
        C12238m.checkExpressionValueIsNotNull(locale, "Locale.US");
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        C12238m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(locale, format, *args)");
        return str2;
    }

    /* JADX INFO: renamed from: k */
    public static final boolean m10130k(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        C12238m.checkParameterIsNotNull(strArr, "$this$hasIntersection");
        C12238m.checkParameterIsNotNull(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: l */
    public static final long m10131l(Response response) {
        C12238m.checkParameterIsNotNull(response, "$this$headersContentLength");
        String strM10954c = response.headers.m10954c("Content-Length");
        if (strM10954c != null) {
            C12238m.checkParameterIsNotNull(strM10954c, "$this$toLongOrDefault");
            try {
                return Long.parseLong(strM10954c);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    @SafeVarargs
    /* JADX INFO: renamed from: m */
    public static final <T> List<T> m10132m(T... tArr) {
        C12238m.checkParameterIsNotNull(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        C12238m.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return listUnmodifiableList;
    }

    /* JADX INFO: renamed from: n */
    public static final int m10133n(String str) {
        C12238m.checkParameterIsNotNull(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: o */
    public static final int m10134o(String str, int i, int i2) {
        C12238m.checkParameterIsNotNull(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: p */
    public static final int m10135p(String str, int i, int i2) {
        C12238m.checkParameterIsNotNull(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: q */
    public static final String[] m10136q(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        C12238m.checkParameterIsNotNull(strArr, "$this$intersect");
        C12238m.checkParameterIsNotNull(strArr2, "other");
        C12238m.checkParameterIsNotNull(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX INFO: renamed from: r */
    public static final int m10137r(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* JADX INFO: renamed from: s */
    public static final Charset m10138s(InterfaceC12390g interfaceC12390g, Charset charset) throws IOException {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "$this$readBomAsCharset");
        C12238m.checkParameterIsNotNull(charset, "default");
        int iMo10471v0 = interfaceC12390g.mo10471v0(f25400d);
        if (iMo10471v0 == -1) {
            return charset;
        }
        if (iMo10471v0 == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            C12238m.checkExpressionValueIsNotNull(charset2, "UTF_8");
            return charset2;
        }
        if (iMo10471v0 == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            C12238m.checkExpressionValueIsNotNull(charset3, "UTF_16BE");
            return charset3;
        }
        if (iMo10471v0 == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            C12238m.checkExpressionValueIsNotNull(charset4, "UTF_16LE");
            return charset4;
        }
        if (iMo10471v0 == 3) {
            return C12086c.f25139d.UTF32_BE();
        }
        if (iMo10471v0 == 4) {
            return C12086c.f25139d.UTF32_LE();
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: t */
    public static final int m10139t(InterfaceC12390g interfaceC12390g) throws IOException {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "$this$readMedium");
        return (interfaceC12390g.readByte() & 255) | ((interfaceC12390g.readByte() & 255) << 16) | ((interfaceC12390g.readByte() & 255) << 8);
    }

    /* JADX INFO: renamed from: u */
    public static final int m10140u(C12388e c12388e, byte b2) throws EOFException {
        C12238m.checkParameterIsNotNull(c12388e, "$this$skipAll");
        int i = 0;
        while (!c12388e.mo10472w() && c12388e.m10464q(0L) == b2) {
            i++;
            c12388e.readByte();
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005d A[PHI: r12
      0x005d: PHI (r12v6 boolean) = (r12v5 boolean), (r12v10 boolean) binds: [B:23:0x0080, B:13:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:577)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:603)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    /* JADX INFO: renamed from: v */
    public static final boolean m10141v(InterfaceC12407x interfaceC12407x, int i, TimeUnit timeUnit) throws IOException {
        boolean z2;
        C12238m.checkParameterIsNotNull(interfaceC12407x, "$this$skipAll");
        C12238m.checkParameterIsNotNull(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jMo10480c = interfaceC12407x.timeout().mo10482e() ? interfaceC12407x.timeout().mo10480c() - jNanoTime : Long.MAX_VALUE;
        interfaceC12407x.timeout().mo10481d(Math.min(jMo10480c, timeUnit.toNanos(i)) + jNanoTime);
        try {
            C12388e c12388e = new C12388e();
            while (interfaceC12407x.mo10176i0(c12388e, Permission.MANAGE_MESSAGES) != -1) {
                c12388e.skip(c12388e.f26080k);
            }
            z2 = true;
            if (jMo10480c == RecyclerView.FOREVER_NS) {
                interfaceC12407x.timeout().mo10478a();
            } else {
                interfaceC12407x.timeout().mo10481d(jNanoTime + jMo10480c);
            }
        } catch (InterruptedIOException unused) {
            z2 = false;
            if (jMo10480c != RecyclerView.FOREVER_NS) {
                interfaceC12407x.timeout().mo10481d(jNanoTime + jMo10480c);
            }
        } catch (Throwable th) {
            if (jMo10480c == RecyclerView.FOREVER_NS) {
                interfaceC12407x.timeout().mo10478a();
            } else {
                interfaceC12407x.timeout().mo10481d(jNanoTime + jMo10480c);
            }
            throw th;
        }
        return z2;
    }

    /* JADX INFO: renamed from: w */
    public static final Headers m10142w(List<C12308b> list) {
        C12238m.checkParameterIsNotNull(list, "$this$toHeaders");
        ArrayList arrayList = new ArrayList(20);
        for (C12308b c12308b : list) {
            ByteString byteString = c12308b.f25587h;
            ByteString byteString2 = c12308b.f25588i;
            String strM11008q = byteString.m11008q();
            String strM11008q2 = byteString2.m11008q();
            C12238m.checkParameterIsNotNull(strM11008q, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(strM11008q2, "value");
            arrayList.add(strM11008q);
            arrayList.add(C12106w.trim(strM11008q2).toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX INFO: renamed from: x */
    public static final String m10143x(int i) {
        String hexString = Integer.toHexString(i);
        C12238m.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    /* JADX INFO: renamed from: y */
    public static final String m10144y(C12379w c12379w, boolean z2) {
        int i;
        C12238m.checkParameterIsNotNull(c12379w, "$this$toHostHeader");
        String strM820H = C12106w.contains$default((CharSequence) c12379w.f25979g, (CharSequence) ":", false, 2, (Object) null) ? C1643a.m820H(C1643a.m829Q('['), c12379w.f25979g, ']') : c12379w.f25979g;
        if (!z2) {
            int i2 = c12379w.f25980h;
            String str = c12379w.f25976d;
            C12238m.checkParameterIsNotNull(str, "scheme");
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
            if (i2 == i) {
                return strM820H;
            }
        }
        return strM820H + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + c12379w.f25980h;
    }

    /* JADX INFO: renamed from: z */
    public static final <T> List<T> m10145z(List<? extends T> list) {
        C12238m.checkParameterIsNotNull(list, "$this$toImmutableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(C12163u.toMutableList((Collection) list));
        C12238m.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }
}
