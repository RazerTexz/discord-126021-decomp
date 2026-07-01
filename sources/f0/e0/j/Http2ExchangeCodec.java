package f0.e0.j;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.Protocol2;
import f0.e0.Util7;
import f0.e0.g.RealConnection4;
import f0.e0.h.ExchangeCodec;
import f0.e0.h.HttpHeaders;
import f0.e0.h.RealInterceptorChain;
import f0.e0.h.StatusLine;
import f0.e0.j.Http2Stream;
import g0.Sink;
import g0.Source2;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.ByteString;

/* JADX INFO: renamed from: f0.e0.j.l, reason: use source file name */
/* JADX INFO: compiled from: Http2ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    public static final List<String> a = Util7.m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f3643b = Util7.m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public volatile Http2Stream c;
    public final Protocol2 d;
    public volatile boolean e;
    public final RealConnection4 f;
    public final RealInterceptorChain g;
    public final Http2Connection h;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection4 realConnection4, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        Intrinsics3.checkParameterIsNotNull(http2Connection, "http2Connection");
        this.f = realConnection4;
        this.g = realInterceptorChain;
        this.h = http2Connection;
        List<Protocol2> list = okHttpClient.E;
        Protocol2 protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
        this.d = list.contains(protocol2) ? protocol2 : Protocol2.HTTP_2;
    }

    @Override // f0.e0.h.ExchangeCodec
    public void a() throws IOException {
        Http2Stream http2Stream = this.c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        ((Http2Stream.a) http2Stream.g()).close();
    }

    @Override // f0.e0.h.ExchangeCodec
    public void b(Request request) throws IOException {
        int i;
        Http2Stream http2Stream;
        boolean z2;
        Intrinsics3.checkParameterIsNotNull(request, "request");
        if (this.c != null) {
            return;
        }
        boolean z3 = request.body != null;
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Headers headers = request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header2(Header2.c, request.method));
        ByteString byteString = Header2.d;
        HttpUrl httpUrl = request.url;
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        String strB = httpUrl.b();
        String strD = httpUrl.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new Header2(byteString, strB));
        String strB2 = request.b("Host");
        if (strB2 != null) {
            arrayList.add(new Header2(Header2.f, strB2));
        }
        arrayList.add(new Header2(Header2.e, request.url.d));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strD2 = headers.d(i2);
            Locale locale = Locale.US;
            Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strD2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strD2.toLowerCase(locale);
            Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!a.contains(lowerCase) || (Intrinsics3.areEqual(lowerCase, "te") && Intrinsics3.areEqual(headers.g(i2), "trailers"))) {
                arrayList.add(new Header2(lowerCase, headers.g(i2)));
            }
        }
        Http2Connection http2Connection = this.h;
        Objects.requireNonNull(http2Connection);
        Intrinsics3.checkParameterIsNotNull(arrayList, "requestHeaders");
        boolean z4 = !z3;
        synchronized (http2Connection.K) {
            synchronized (http2Connection) {
                if (http2Connection.q > 1073741823) {
                    http2Connection.e(ErrorCode2.REFUSED_STREAM);
                }
                if (http2Connection.r) {
                    throw new ConnectionShutdownException();
                }
                i = http2Connection.q;
                http2Connection.q = i + 2;
                http2Stream = new Http2Stream(i, http2Connection, z4, false, null);
                z2 = !z3 || http2Connection.H >= http2Connection.I || http2Stream.c >= http2Stream.d;
                if (http2Stream.i()) {
                    http2Connection.n.put(Integer.valueOf(i), http2Stream);
                }
            }
            http2Connection.K.e(z4, i, arrayList);
        }
        if (z2) {
            http2Connection.K.flush();
        }
        this.c = http2Stream;
        if (this.e) {
            Http2Stream http2Stream2 = this.c;
            if (http2Stream2 == null) {
                Intrinsics3.throwNpe();
            }
            http2Stream2.e(ErrorCode2.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream3 = this.c;
        if (http2Stream3 == null) {
            Intrinsics3.throwNpe();
        }
        Http2Stream.c cVar = http2Stream3.i;
        long j = this.g.h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        cVar.g(j, timeUnit);
        Http2Stream http2Stream4 = this.c;
        if (http2Stream4 == null) {
            Intrinsics3.throwNpe();
        }
        http2Stream4.j.g(this.g.i, timeUnit);
    }

    @Override // f0.e0.h.ExchangeCodec
    public Source2 c(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Http2Stream http2Stream = this.c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        return http2Stream.g;
    }

    @Override // f0.e0.h.ExchangeCodec
    public void cancel() {
        this.e = true;
        Http2Stream http2Stream = this.c;
        if (http2Stream != null) {
            http2Stream.e(ErrorCode2.CANCEL);
        }
    }

    @Override // f0.e0.h.ExchangeCodec
    public Response.a d(boolean z2) throws IOException {
        Headers headers;
        Http2Stream http2Stream = this.c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        synchronized (http2Stream) {
            http2Stream.i.i();
            while (http2Stream.e.isEmpty() && http2Stream.k == null) {
                try {
                    http2Stream.l();
                } catch (Throwable th) {
                    http2Stream.i.m();
                    throw th;
                }
            }
            http2Stream.i.m();
            if (!(!http2Stream.e.isEmpty())) {
                IOException iOException = http2Stream.l;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode2 errorCode2 = http2Stream.k;
                if (errorCode2 == null) {
                    Intrinsics3.throwNpe();
                }
                throw new StreamResetException(errorCode2);
            }
            Headers headersRemoveFirst = http2Stream.e.removeFirst();
            Intrinsics3.checkExpressionValueIsNotNull(headersRemoveFirst, "headersQueue.removeFirst()");
            headers = headersRemoveFirst;
        }
        Protocol2 protocol2 = this.d;
        Intrinsics3.checkParameterIsNotNull(headers, "headerBlock");
        Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        StatusLine statusLineA = null;
        for (int i = 0; i < size; i++) {
            String strD = headers.d(i);
            String strG = headers.g(i);
            if (Intrinsics3.areEqual(strD, ":status")) {
                statusLineA = StatusLine.a("HTTP/1.1 " + strG);
            } else if (!f3643b.contains(strD)) {
                Intrinsics3.checkParameterIsNotNull(strD, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkParameterIsNotNull(strG, "value");
                arrayList.add(strD);
                arrayList.add(Strings4.trim(strG).toString());
            }
        }
        if (statusLineA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.a aVar = new Response.a();
        aVar.f(protocol2);
        aVar.c = statusLineA.f3630b;
        aVar.e(statusLineA.c);
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        aVar.d(new Headers((String[]) array, null));
        if (z2 && aVar.c == 100) {
            return null;
        }
        return aVar;
    }

    @Override // f0.e0.h.ExchangeCodec
    public RealConnection4 e() {
        return this.f;
    }

    @Override // f0.e0.h.ExchangeCodec
    public void f() throws IOException {
        this.h.K.flush();
    }

    @Override // f0.e0.h.ExchangeCodec
    public long g(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (HttpHeaders.a(response)) {
            return Util7.l(response);
        }
        return 0L;
    }

    @Override // f0.e0.h.ExchangeCodec
    public Sink h(Request request, long j) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Http2Stream http2Stream = this.c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        return http2Stream.g();
    }
}
