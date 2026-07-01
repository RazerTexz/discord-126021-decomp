package f0.e0;

import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.w;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import f0.b0;
import f0.x;
import g0.e;
import g0.g;
import g0.o;
import g0.o$a;
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
import okhttp3.RequestBody$Companion;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.ByteString$a;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Headers f3605b = Headers.j.c(new String[0]);
    public static final ResponseBody c;
    public static final o d;
    public static final TimeZone e;
    public static final Regex f;
    public static final String g;

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        m.checkParameterIsNotNull(bArr, "$this$toResponseBody");
        e eVar = new e();
        eVar.R(bArr);
        m.checkParameterIsNotNull(eVar, "$this$asResponseBody");
        c = new b0(eVar, null, 0);
        RequestBody$Companion.d(RequestBody.Companion, bArr, null, 0, 0, 7);
        o$a o_a = o.k;
        ByteString$a byteString$a = ByteString.k;
        d = o_a.c(byteString$a.a("efbbbf"), byteString$a.a("feff"), byteString$a.a("fffe"), byteString$a.a("0000ffff"), byteString$a.a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            m.throwNpe();
        }
        e = timeZone;
        f = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String name = x.class.getName();
        m.checkExpressionValueIsNotNull(name, "OkHttpClient::class.java.name");
        g = w.removeSuffix(w.removePrefix(name, "okhttp3."), "Client");
    }

    public static final <K, V> Map<K, V> A(Map<K, ? extends V> map) {
        m.checkParameterIsNotNull(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return h0.emptyMap();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        m.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    public static final int B(String str, int i) {
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

    public static final String C(String str, int i, int i2) {
        m.checkParameterIsNotNull(str, "$this$trimSubstring");
        int iO = o(str, i, i2);
        String strSubstring = str.substring(iO, p(str, iO, i2));
        m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final Throwable D(Exception exc, List<? extends Exception> list) {
        m.checkParameterIsNotNull(exc, "$this$withSuppressed");
        m.checkParameterIsNotNull(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            exc.addSuppressed(it.next());
        }
        return exc;
    }

    public static final boolean a(f0.w wVar, f0.w wVar2) {
        m.checkParameterIsNotNull(wVar, "$this$canReuseConnectionFor");
        m.checkParameterIsNotNull(wVar2, "other");
        return m.areEqual(wVar.g, wVar2.g) && wVar.h == wVar2.h && m.areEqual(wVar.d, wVar2.d);
    }

    public static final int b(String str, long j, TimeUnit timeUnit) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!(j >= 0)) {
            throw new IllegalStateException(b.d.b.a.a.w(str, " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(b.d.b.a.a.w(str, " too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(b.d.b.a.a.w(str, " too small.").toString());
    }

    public static final void c(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void d(Closeable closeable) {
        m.checkParameterIsNotNull(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket socket) {
        m.checkParameterIsNotNull(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static final int f(String str, char c2, int i, int i2) {
        m.checkParameterIsNotNull(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int g(String str, String str2, int i, int i2) {
        m.checkParameterIsNotNull(str, "$this$delimiterOffset");
        m.checkParameterIsNotNull(str2, "delimiters");
        while (i < i2) {
            if (w.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int h(String str, char c2, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return f(str, c2, i, i2);
    }

    public static final boolean i(g0.x xVar, int i, TimeUnit timeUnit) {
        m.checkParameterIsNotNull(xVar, "$this$discard");
        m.checkParameterIsNotNull(timeUnit, "timeUnit");
        try {
            return v(xVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String j(String str, Object... objArr) {
        m.checkParameterIsNotNull(str, "format");
        m.checkParameterIsNotNull(objArr, "args");
        Locale locale = Locale.US;
        m.checkExpressionValueIsNotNull(locale, "Locale.US");
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(locale, format, *args)");
        return str2;
    }

    public static final boolean k(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        m.checkParameterIsNotNull(strArr, "$this$hasIntersection");
        m.checkParameterIsNotNull(comparator, "comparator");
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

    public static final long l(Response response) {
        m.checkParameterIsNotNull(response, "$this$headersContentLength");
        String strC = response.headers.c("Content-Length");
        if (strC != null) {
            m.checkParameterIsNotNull(strC, "$this$toLongOrDefault");
            try {
                return Long.parseLong(strC);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> m(T... tArr) {
        m.checkParameterIsNotNull(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        m.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int n(String str) {
        m.checkParameterIsNotNull(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static final int o(String str, int i, int i2) {
        m.checkParameterIsNotNull(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int p(String str, int i, int i2) {
        m.checkParameterIsNotNull(str, "$this$indexOfLastNonAsciiWhitespace");
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

    public static final String[] q(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        m.checkParameterIsNotNull(strArr, "$this$intersect");
        m.checkParameterIsNotNull(strArr2, "other");
        m.checkParameterIsNotNull(comparator, "comparator");
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

    public static final int r(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static final Charset s(g gVar, Charset charset) throws IOException {
        m.checkParameterIsNotNull(gVar, "$this$readBomAsCharset");
        m.checkParameterIsNotNull(charset, "default");
        int iV0 = gVar.v0(d);
        if (iV0 == -1) {
            return charset;
        }
        if (iV0 == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            m.checkExpressionValueIsNotNull(charset2, "UTF_8");
            return charset2;
        }
        if (iV0 == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            m.checkExpressionValueIsNotNull(charset3, "UTF_16BE");
            return charset3;
        }
        if (iV0 == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            m.checkExpressionValueIsNotNull(charset4, "UTF_16LE");
            return charset4;
        }
        if (iV0 == 3) {
            return d0.g0.c.d.UTF32_BE();
        }
        if (iV0 == 4) {
            return d0.g0.c.d.UTF32_LE();
        }
        throw new AssertionError();
    }

    public static final int t(g gVar) throws IOException {
        m.checkParameterIsNotNull(gVar, "$this$readMedium");
        return (gVar.readByte() & 255) | ((gVar.readByte() & 255) << 16) | ((gVar.readByte() & 255) << 8);
    }

    public static final int u(e eVar, byte b2) throws EOFException {
        m.checkParameterIsNotNull(eVar, "$this$skipAll");
        int i = 0;
        while (!eVar.w() && eVar.q(0L) == b2) {
            i++;
            eVar.readByte();
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
    public static final boolean v(g0.x xVar, int i, TimeUnit timeUnit) throws IOException {
        boolean z2;
        m.checkParameterIsNotNull(xVar, "$this$skipAll");
        m.checkParameterIsNotNull(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = xVar.timeout().e() ? xVar.timeout().c() - jNanoTime : Long.MAX_VALUE;
        xVar.timeout().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            e eVar = new e();
            while (xVar.i0(eVar, Permission.MANAGE_MESSAGES) != -1) {
                eVar.skip(eVar.k);
            }
            z2 = true;
            if (jC == RecyclerView.FOREVER_NS) {
                xVar.timeout().a();
            } else {
                xVar.timeout().d(jNanoTime + jC);
            }
        } catch (InterruptedIOException unused) {
            z2 = false;
            if (jC != RecyclerView.FOREVER_NS) {
                xVar.timeout().d(jNanoTime + jC);
            }
        } catch (Throwable th) {
            if (jC == RecyclerView.FOREVER_NS) {
                xVar.timeout().a();
            } else {
                xVar.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
        return z2;
    }

    public static final Headers w(List<f0.e0.j.b> list) {
        m.checkParameterIsNotNull(list, "$this$toHeaders");
        ArrayList arrayList = new ArrayList(20);
        for (f0.e0.j.b bVar : list) {
            ByteString byteString = bVar.h;
            ByteString byteString2 = bVar.i;
            String strQ = byteString.q();
            String strQ2 = byteString2.q();
            m.checkParameterIsNotNull(strQ, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkParameterIsNotNull(strQ2, "value");
            arrayList.add(strQ);
            arrayList.add(w.trim(strQ2).toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final String x(int i) {
        String hexString = Integer.toHexString(i);
        m.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    public static final String y(f0.w wVar, boolean z2) {
        int i;
        m.checkParameterIsNotNull(wVar, "$this$toHostHeader");
        String strH = w.contains$default((CharSequence) wVar.g, (CharSequence) ":", false, 2, (Object) null) ? b.d.b.a.a.H(b.d.b.a.a.Q('['), wVar.g, ']') : wVar.g;
        if (!z2) {
            int i2 = wVar.h;
            String str = wVar.d;
            m.checkParameterIsNotNull(str, "scheme");
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
                return strH;
            }
        }
        return strH + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + wVar.h;
    }

    public static final <T> List<T> z(List<? extends T> list) {
        m.checkParameterIsNotNull(list, "$this$toImmutableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(u.toMutableList((Collection) list));
        m.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }
}
