package f0.e0.j;

import com.discord.models.domain.ModelAuditLogEntry;
import f0.w;
import f0.x;
import f0.y;
import g0.v;
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
import okhttp3.Response$a;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.ByteString;

/* JADX INFO: compiled from: Http2ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements f0.e0.h.d {
    public static final List<String> a = f0.e0.c.m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f3643b = f0.e0.c.m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public volatile n c;
    public final y d;
    public volatile boolean e;
    public final f0.e0.g.j f;
    public final f0.e0.h.g g;
    public final e h;

    public l(x xVar, f0.e0.g.j jVar, f0.e0.h.g gVar, e eVar) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
        d0.z.d.m.checkParameterIsNotNull(gVar, "chain");
        d0.z.d.m.checkParameterIsNotNull(eVar, "http2Connection");
        this.f = jVar;
        this.g = gVar;
        this.h = eVar;
        List<y> list = xVar.E;
        y yVar = y.H2_PRIOR_KNOWLEDGE;
        this.d = list.contains(yVar) ? yVar : y.HTTP_2;
    }

    @Override // f0.e0.h.d
    public void a() throws IOException {
        n nVar = this.c;
        if (nVar == null) {
            d0.z.d.m.throwNpe();
        }
        ((n$a) nVar.g()).close();
    }

    @Override // f0.e0.h.d
    public void b(Request request) throws IOException {
        int i;
        n nVar;
        boolean z2;
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        if (this.c != null) {
            return;
        }
        boolean z3 = request.body != null;
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        Headers headers = request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new b(b.c, request.method));
        ByteString byteString = b.d;
        w wVar = request.url;
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        String strB = wVar.b();
        String strD = wVar.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new b(byteString, strB));
        String strB2 = request.b("Host");
        if (strB2 != null) {
            arrayList.add(new b(b.f, strB2));
        }
        arrayList.add(new b(b.e, request.url.d));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strD2 = headers.d(i2);
            Locale locale = Locale.US;
            d0.z.d.m.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strD2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strD2.toLowerCase(locale);
            d0.z.d.m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!a.contains(lowerCase) || (d0.z.d.m.areEqual(lowerCase, "te") && d0.z.d.m.areEqual(headers.g(i2), "trailers"))) {
                arrayList.add(new b(lowerCase, headers.g(i2)));
            }
        }
        e eVar = this.h;
        Objects.requireNonNull(eVar);
        d0.z.d.m.checkParameterIsNotNull(arrayList, "requestHeaders");
        boolean z4 = !z3;
        synchronized (eVar.K) {
            synchronized (eVar) {
                if (eVar.q > 1073741823) {
                    eVar.e(a.REFUSED_STREAM);
                }
                if (eVar.r) {
                    throw new ConnectionShutdownException();
                }
                i = eVar.q;
                eVar.q = i + 2;
                nVar = new n(i, eVar, z4, false, null);
                z2 = !z3 || eVar.H >= eVar.I || nVar.c >= nVar.d;
                if (nVar.i()) {
                    eVar.n.put(Integer.valueOf(i), nVar);
                }
            }
            eVar.K.e(z4, i, arrayList);
        }
        if (z2) {
            eVar.K.flush();
        }
        this.c = nVar;
        if (this.e) {
            n nVar2 = this.c;
            if (nVar2 == null) {
                d0.z.d.m.throwNpe();
            }
            nVar2.e(a.CANCEL);
            throw new IOException("Canceled");
        }
        n nVar3 = this.c;
        if (nVar3 == null) {
            d0.z.d.m.throwNpe();
        }
        n$c n_c = nVar3.i;
        long j = this.g.h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        n_c.g(j, timeUnit);
        n nVar4 = this.c;
        if (nVar4 == null) {
            d0.z.d.m.throwNpe();
        }
        nVar4.j.g(this.g.i, timeUnit);
    }

    @Override // f0.e0.h.d
    public g0.x c(Response response) {
        d0.z.d.m.checkParameterIsNotNull(response, "response");
        n nVar = this.c;
        if (nVar == null) {
            d0.z.d.m.throwNpe();
        }
        return nVar.g;
    }

    @Override // f0.e0.h.d
    public void cancel() {
        this.e = true;
        n nVar = this.c;
        if (nVar != null) {
            nVar.e(a.CANCEL);
        }
    }

    @Override // f0.e0.h.d
    public Response$a d(boolean z2) throws IOException {
        Headers headers;
        n nVar = this.c;
        if (nVar == null) {
            d0.z.d.m.throwNpe();
        }
        synchronized (nVar) {
            nVar.i.i();
            while (nVar.e.isEmpty() && nVar.k == null) {
                try {
                    nVar.l();
                } catch (Throwable th) {
                    nVar.i.m();
                    throw th;
                }
            }
            nVar.i.m();
            if (!(!nVar.e.isEmpty())) {
                IOException iOException = nVar.l;
                if (iOException != null) {
                    throw iOException;
                }
                a aVar = nVar.k;
                if (aVar == null) {
                    d0.z.d.m.throwNpe();
                }
                throw new StreamResetException(aVar);
            }
            Headers headersRemoveFirst = nVar.e.removeFirst();
            d0.z.d.m.checkExpressionValueIsNotNull(headersRemoveFirst, "headersQueue.removeFirst()");
            headers = headersRemoveFirst;
        }
        y yVar = this.d;
        d0.z.d.m.checkParameterIsNotNull(headers, "headerBlock");
        d0.z.d.m.checkParameterIsNotNull(yVar, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        f0.e0.h.j jVarA = null;
        for (int i = 0; i < size; i++) {
            String strD = headers.d(i);
            String strG = headers.g(i);
            if (d0.z.d.m.areEqual(strD, ":status")) {
                jVarA = f0.e0.h.j.a("HTTP/1.1 " + strG);
            } else if (!f3643b.contains(strD)) {
                d0.z.d.m.checkParameterIsNotNull(strD, ModelAuditLogEntry.CHANGE_KEY_NAME);
                d0.z.d.m.checkParameterIsNotNull(strG, "value");
                arrayList.add(strD);
                arrayList.add(d0.g0.w.trim(strG).toString());
            }
        }
        if (jVarA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response$a response$a = new Response$a();
        response$a.f(yVar);
        response$a.c = jVarA.f3630b;
        response$a.e(jVarA.c);
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        response$a.d(new Headers((String[]) array, null));
        if (z2 && response$a.c == 100) {
            return null;
        }
        return response$a;
    }

    @Override // f0.e0.h.d
    public f0.e0.g.j e() {
        return this.f;
    }

    @Override // f0.e0.h.d
    public void f() throws IOException {
        this.h.K.flush();
    }

    @Override // f0.e0.h.d
    public long g(Response response) {
        d0.z.d.m.checkParameterIsNotNull(response, "response");
        if (f0.e0.h.e.a(response)) {
            return f0.e0.c.l(response);
        }
        return 0L;
    }

    @Override // f0.e0.h.d
    public v h(Request request, long j) {
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        n nVar = this.c;
        if (nVar == null) {
            d0.z.d.m.throwNpe();
        }
        return nVar.g();
    }
}
