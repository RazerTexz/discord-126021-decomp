package p600f0.p601e0.p608j;

import com.discord.models.domain.ModelAuditLogEntry;
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
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;
import p600f0.C12380x;
import p600f0.EnumC12381y;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p605g.C12290j;
import p600f0.p601e0.p606h.C12299e;
import p600f0.p601e0.p606h.C12301g;
import p600f0.p601e0.p606h.C12304j;
import p600f0.p601e0.p606h.InterfaceC12298d;
import p600f0.p601e0.p608j.C12320n;
import p615g0.InterfaceC12405v;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.j.l */
/* JADX INFO: compiled from: Http2ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12318l implements InterfaceC12298d {

    /* JADX INFO: renamed from: a */
    public static final List<String> f25692a = C12272c.m10132m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: b */
    public static final List<String> f25693b = C12272c.m10132m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: c */
    public volatile C12320n f25694c;

    /* JADX INFO: renamed from: d */
    public final EnumC12381y f25695d;

    /* JADX INFO: renamed from: e */
    public volatile boolean f25696e;

    /* JADX INFO: renamed from: f */
    public final C12290j f25697f;

    /* JADX INFO: renamed from: g */
    public final C12301g f25698g;

    /* JADX INFO: renamed from: h */
    public final C12311e f25699h;

    public C12318l(C12380x c12380x, C12290j c12290j, C12301g c12301g, C12311e c12311e) {
        C12238m.checkParameterIsNotNull(c12380x, "client");
        C12238m.checkParameterIsNotNull(c12290j, "connection");
        C12238m.checkParameterIsNotNull(c12301g, "chain");
        C12238m.checkParameterIsNotNull(c12311e, "http2Connection");
        this.f25697f = c12290j;
        this.f25698g = c12301g;
        this.f25699h = c12311e;
        List<EnumC12381y> list = c12380x.f26001E;
        EnumC12381y enumC12381y = EnumC12381y.H2_PRIOR_KNOWLEDGE;
        this.f25695d = list.contains(enumC12381y) ? enumC12381y : EnumC12381y.HTTP_2;
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: a */
    public void mo10213a() throws IOException {
        C12320n c12320n = this.f25694c;
        if (c12320n == null) {
            C12238m.throwNpe();
        }
        ((C12320n.a) c12320n.m10288g()).close();
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: b */
    public void mo10214b(Request request) throws IOException {
        int i;
        C12320n c12320n;
        boolean z2;
        C12238m.checkParameterIsNotNull(request, "request");
        if (this.f25694c != null) {
            return;
        }
        boolean z3 = request.body != null;
        C12238m.checkParameterIsNotNull(request, "request");
        Headers headers = request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new C12308b(C12308b.f25582c, request.method));
        ByteString byteString = C12308b.f25583d;
        C12379w c12379w = request.url;
        C12238m.checkParameterIsNotNull(c12379w, "url");
        String strM10400b = c12379w.m10400b();
        String strM10402d = c12379w.m10402d();
        if (strM10402d != null) {
            strM10400b = strM10400b + '?' + strM10402d;
        }
        arrayList.add(new C12308b(byteString, strM10400b));
        String strM10977b = request.m10977b("Host");
        if (strM10977b != null) {
            arrayList.add(new C12308b(C12308b.f25585f, strM10977b));
        }
        arrayList.add(new C12308b(C12308b.f25584e, request.url.f25976d));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strM10955d = headers.m10955d(i2);
            Locale locale = Locale.US;
            C12238m.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strM10955d == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strM10955d.toLowerCase(locale);
            C12238m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!f25692a.contains(lowerCase) || (C12238m.areEqual(lowerCase, "te") && C12238m.areEqual(headers.m10957g(i2), "trailers"))) {
                arrayList.add(new C12308b(lowerCase, headers.m10957g(i2)));
            }
        }
        C12311e c12311e = this.f25699h;
        Objects.requireNonNull(c12311e);
        C12238m.checkParameterIsNotNull(arrayList, "requestHeaders");
        boolean z4 = !z3;
        synchronized (c12311e.f25627K) {
            synchronized (c12311e) {
                if (c12311e.f25635q > 1073741823) {
                    c12311e.m10262e(EnumC12307a.REFUSED_STREAM);
                }
                if (c12311e.f25636r) {
                    throw new ConnectionShutdownException();
                }
                i = c12311e.f25635q;
                c12311e.f25635q = i + 2;
                c12320n = new C12320n(i, c12311e, z4, false, null);
                z2 = !z3 || c12311e.f25624H >= c12311e.f25625I || c12320n.f25714c >= c12320n.f25715d;
                if (c12320n.m10290i()) {
                    c12311e.f25632n.put(Integer.valueOf(i), c12320n);
                }
            }
            c12311e.f25627K.m10302e(z4, i, arrayList);
        }
        if (z2) {
            c12311e.f25627K.flush();
        }
        this.f25694c = c12320n;
        if (this.f25696e) {
            C12320n c12320n2 = this.f25694c;
            if (c12320n2 == null) {
                C12238m.throwNpe();
            }
            c12320n2.m10286e(EnumC12307a.CANCEL);
            throw new IOException("Canceled");
        }
        C12320n c12320n3 = this.f25694c;
        if (c12320n3 == null) {
            C12238m.throwNpe();
        }
        C12320n.c cVar = c12320n3.f25720i;
        long j = this.f25698g.f25538h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        cVar.mo10484g(j, timeUnit);
        C12320n c12320n4 = this.f25694c;
        if (c12320n4 == null) {
            C12238m.throwNpe();
        }
        c12320n4.f25721j.mo10484g(this.f25698g.f25539i, timeUnit);
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: c */
    public InterfaceC12407x mo10215c(Response response) {
        C12238m.checkParameterIsNotNull(response, "response");
        C12320n c12320n = this.f25694c;
        if (c12320n == null) {
            C12238m.throwNpe();
        }
        return c12320n.f25718g;
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    public void cancel() {
        this.f25696e = true;
        C12320n c12320n = this.f25694c;
        if (c12320n != null) {
            c12320n.m10286e(EnumC12307a.CANCEL);
        }
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: d */
    public Response.C12937a mo10216d(boolean z2) throws IOException {
        Headers headers;
        C12320n c12320n = this.f25694c;
        if (c12320n == null) {
            C12238m.throwNpe();
        }
        synchronized (c12320n) {
            c12320n.f25720i.m10424i();
            while (c12320n.f25716e.isEmpty() && c12320n.f25722k == null) {
                try {
                    c12320n.m10293l();
                } catch (Throwable th) {
                    c12320n.f25720i.m10297m();
                    throw th;
                }
            }
            c12320n.f25720i.m10297m();
            if (!(!c12320n.f25716e.isEmpty())) {
                IOException iOException = c12320n.f25723l;
                if (iOException != null) {
                    throw iOException;
                }
                EnumC12307a enumC12307a = c12320n.f25722k;
                if (enumC12307a == null) {
                    C12238m.throwNpe();
                }
                throw new StreamResetException(enumC12307a);
            }
            Headers headersRemoveFirst = c12320n.f25716e.removeFirst();
            C12238m.checkExpressionValueIsNotNull(headersRemoveFirst, "headersQueue.removeFirst()");
            headers = headersRemoveFirst;
        }
        EnumC12381y enumC12381y = this.f25695d;
        C12238m.checkParameterIsNotNull(headers, "headerBlock");
        C12238m.checkParameterIsNotNull(enumC12381y, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        C12304j c12304jM10234a = null;
        for (int i = 0; i < size; i++) {
            String strM10955d = headers.m10955d(i);
            String strM10957g = headers.m10957g(i);
            if (C12238m.areEqual(strM10955d, ":status")) {
                c12304jM10234a = C12304j.m10234a("HTTP/1.1 " + strM10957g);
            } else if (!f25693b.contains(strM10955d)) {
                C12238m.checkParameterIsNotNull(strM10955d, ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkParameterIsNotNull(strM10957g, "value");
                arrayList.add(strM10955d);
                arrayList.add(C12106w.trim(strM10957g).toString());
            }
        }
        if (c12304jM10234a == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.C12937a c12937a = new Response.C12937a();
        c12937a.m10996f(enumC12381y);
        c12937a.f27567c = c12304jM10234a.f25545b;
        c12937a.m10995e(c12304jM10234a.f25546c);
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        c12937a.m10994d(new Headers((String[]) array, null));
        if (z2 && c12937a.f27567c == 100) {
            return null;
        }
        return c12937a;
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: e */
    public C12290j mo10217e() {
        return this.f25697f;
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: f */
    public void mo10218f() throws IOException {
        this.f25699h.f25627K.flush();
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: g */
    public long mo10219g(Response response) {
        C12238m.checkParameterIsNotNull(response, "response");
        if (C12299e.m10221a(response)) {
            return C12272c.m10131l(response);
        }
        return 0L;
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: h */
    public InterfaceC12405v mo10220h(Request request, long j) {
        C12238m.checkParameterIsNotNull(request, "request");
        C12320n c12320n = this.f25694c;
        if (c12320n == null) {
            C12238m.throwNpe();
        }
        return c12320n.m10288g();
    }
}
