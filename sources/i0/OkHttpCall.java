package i0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import f0.Call2;
import f0.Callback2;
import f0.FormBody;
import f0.Handshake;
import f0.HttpUrl;
import f0.Protocol2;
import f0.e0.g.Exchange;
import g0.Buffer3;
import g0.BufferedSource;
import g0.ForwardingSource;
import g0.RealBufferedSource;
import g0.Source2;
import i0.RequestBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.p, reason: use source file name */
/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OkHttpCall<T> implements Call3<T> {
    public final RequestFactory j;
    public final Object[] k;
    public final Call2.a l;
    public final Converter2<ResponseBody, T> m;
    public volatile boolean n;
    public Call2 o;
    public Throwable p;
    public boolean q;

    /* JADX INFO: renamed from: i0.p$a */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public class a implements Callback2 {
        public final /* synthetic */ Callback3 a;

        public a(Callback3 callback3) {
            this.a = callback3;
        }

        @Override // f0.Callback2
        public void a(Call2 call2, Response response) {
            try {
                try {
                    this.a.b(OkHttpCall.this, OkHttpCall.this.g(response));
                } catch (Throwable th) {
                    Utils8.o(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                Utils8.o(th2);
                try {
                    this.a.a(OkHttpCall.this, th2);
                } catch (Throwable th3) {
                    Utils8.o(th3);
                    th3.printStackTrace();
                }
            }
        }

        @Override // f0.Callback2
        public void b(Call2 call2, IOException iOException) {
            try {
                this.a.a(OkHttpCall.this, iOException);
            } catch (Throwable th) {
                Utils8.o(th);
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: i0.p$b */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public static final class b extends ResponseBody {
        public final ResponseBody l;
        public final BufferedSource m;
        public IOException n;

        /* JADX INFO: renamed from: i0.p$b$a */
        /* JADX INFO: compiled from: OkHttpCall.java */
        public class a extends ForwardingSource {
            public a(Source2 source2) {
                super(source2);
            }

            @Override // g0.Source2
            public long i0(Buffer3 buffer3, long j) throws IOException {
                try {
                    Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
                    return this.j.i0(buffer3, j);
                } catch (IOException e) {
                    b.this.n = e;
                    throw e;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.l = responseBody;
            a aVar = new a(responseBody.c());
            Intrinsics3.checkParameterIsNotNull(aVar, "$this$buffer");
            this.m = new RealBufferedSource(aVar);
        }

        @Override // okhttp3.ResponseBody
        public long a() {
            return this.l.a();
        }

        @Override // okhttp3.ResponseBody
        public MediaType b() {
            return this.l.b();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource c() {
            return this.m;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.l.close();
        }
    }

    /* JADX INFO: renamed from: i0.p$c */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public static final class c extends ResponseBody {
        public final MediaType l;
        public final long m;

        public c(MediaType mediaType, long j) {
            this.l = mediaType;
            this.m = j;
        }

        @Override // okhttp3.ResponseBody
        public long a() {
            return this.m;
        }

        @Override // okhttp3.ResponseBody
        public MediaType b() {
            return this.l;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call2.a aVar, Converter2<ResponseBody, T> converter2) {
        this.j = requestFactory;
        this.k = objArr;
        this.l = aVar;
        this.m = converter2;
    }

    @Override // i0.Call3
    public void C(Callback3<T> callback3) {
        Call2 call2;
        Throwable th;
        synchronized (this) {
            if (this.q) {
                throw new IllegalStateException("Already executed.");
            }
            this.q = true;
            call2 = this.o;
            th = this.p;
            if (call2 == null && th == null) {
                try {
                    Call2 call2B = b();
                    this.o = call2B;
                    call2 = call2B;
                } catch (Throwable th2) {
                    th = th2;
                    Utils8.o(th);
                    this.p = th;
                }
            }
        }
        if (th != null) {
            callback3.a(this, th);
            return;
        }
        if (this.n) {
            call2.cancel();
        }
        call2.e(new a(callback3));
    }

    @Override // i0.Call3
    /* JADX INFO: renamed from: L */
    public Call3 clone() {
        return new OkHttpCall(this.j, this.k, this.l, this.m);
    }

    public final Call2 b() throws IOException {
        HttpUrl httpUrlB;
        Call2.a aVar = this.l;
        RequestFactory requestFactory = this.j;
        Object[] objArr = this.k;
        ParameterHandler3<?>[] parameterHandler3Arr = requestFactory.j;
        int length = objArr.length;
        if (length != parameterHandler3Arr.length) {
            throw new IllegalArgumentException(outline.B(outline.V("Argument count (", length, ") doesn't match expected count ("), parameterHandler3Arr.length, ")"));
        }
        RequestBuilder requestBuilder = new RequestBuilder(requestFactory.c, requestFactory.f3761b, requestFactory.d, requestFactory.e, requestFactory.f, requestFactory.g, requestFactory.h, requestFactory.i);
        if (requestFactory.k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            parameterHandler3Arr[i].a(requestBuilder, objArr[i]);
        }
        HttpUrl.a aVar2 = requestBuilder.f;
        if (aVar2 != null) {
            httpUrlB = aVar2.b();
        } else {
            HttpUrl httpUrl = requestBuilder.d;
            String str = requestBuilder.e;
            Objects.requireNonNull(httpUrl);
            Intrinsics3.checkParameterIsNotNull(str, "link");
            HttpUrl.a aVarG = httpUrl.g(str);
            httpUrlB = aVarG != null ? aVarG.b() : null;
            if (httpUrlB == null) {
                StringBuilder sbU = outline.U("Malformed URL. Base: ");
                sbU.append(requestBuilder.d);
                sbU.append(", Relative: ");
                sbU.append(requestBuilder.e);
                throw new IllegalArgumentException(sbU.toString());
            }
        }
        RequestBody aVar3 = requestBuilder.m;
        if (aVar3 == null) {
            FormBody.a aVar4 = requestBuilder.l;
            if (aVar4 != null) {
                aVar3 = new FormBody(aVar4.a, aVar4.f3679b);
            } else {
                MultipartBody.a aVar5 = requestBuilder.k;
                if (aVar5 != null) {
                    aVar3 = aVar5.b();
                } else if (requestBuilder.j) {
                    aVar3 = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = requestBuilder.i;
        if (mediaType != null) {
            if (aVar3 != null) {
                aVar3 = new RequestBuilder.a(aVar3, mediaType);
            } else {
                requestBuilder.h.a("Content-Type", mediaType.mediaType);
            }
        }
        Request.a aVar6 = requestBuilder.g;
        aVar6.g(httpUrlB);
        Headers headersC = requestBuilder.h.c();
        Intrinsics3.checkParameterIsNotNull(headersC, "headers");
        aVar6.c = headersC.e();
        aVar6.c(requestBuilder.c, aVar3);
        aVar6.e(Invocation.class, new Invocation(requestFactory.a, arrayList));
        Call2 call2B = aVar.b(aVar6.a());
        Objects.requireNonNull(call2B, "Call.Factory returned null.");
        return call2B;
    }

    @Override // i0.Call3
    public synchronized Request c() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return f().c();
    }

    @Override // i0.Call3
    public void cancel() {
        Call2 call2;
        this.n = true;
        synchronized (this) {
            call2 = this.o;
        }
        if (call2 != null) {
            call2.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return new OkHttpCall(this.j, this.k, this.l, this.m);
    }

    @Override // i0.Call3
    public boolean d() {
        boolean z2 = true;
        if (this.n) {
            return true;
        }
        synchronized (this) {
            Call2 call2 = this.o;
            if (call2 == null || !call2.d()) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // i0.Call3
    public retrofit2.Response<T> execute() throws IOException {
        Call2 call2F;
        synchronized (this) {
            if (this.q) {
                throw new IllegalStateException("Already executed.");
            }
            this.q = true;
            call2F = f();
        }
        if (this.n) {
            call2F.cancel();
        }
        return g(call2F.execute());
    }

    public final Call2 f() throws IOException {
        Call2 call2 = this.o;
        if (call2 != null) {
            return call2;
        }
        Throwable th = this.p;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            Call2 call2B = b();
            this.o = call2B;
            return call2B;
        } catch (IOException | Error | RuntimeException e) {
            Utils8.o(e);
            this.p = e;
            throw e;
        }
    }

    public retrofit2.Response<T> g(Response response) throws IOException {
        ResponseBody responseBody = response.body;
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Request request = response.request;
        Protocol2 protocol2 = response.protocol;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        String str = response.message;
        Handshake handshake = response.handshake;
        Headers.a aVarE = response.headers.e();
        Response response2 = response.networkResponse;
        Response response3 = response.cacheResponse;
        Response response4 = response.priorResponse;
        long j = response.sentRequestAtMillis;
        long j2 = response.receivedResponseAtMillis;
        Exchange exchange = response.exchange;
        c cVar = new c(responseBody.b(), responseBody.a());
        if (!(i >= 0)) {
            throw new IllegalStateException(outline.q("code < 0: ", i).toString());
        }
        if (request == null) {
            throw new IllegalStateException("request == null".toString());
        }
        if (protocol2 == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        if (str == null) {
            throw new IllegalStateException("message == null".toString());
        }
        Response response5 = new Response(request, protocol2, str, i, handshake, aVarE.c(), cVar, response2, response3, response4, j, j2, exchange);
        int i2 = response5.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        if (i2 < 200 || i2 >= 300) {
            try {
                ResponseBody responseBodyA = Utils8.a(responseBody);
                if (response5.b()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                retrofit2.Response<T> response6 = new retrofit2.Response<>(response5, null, responseBodyA);
                responseBody.close();
                return response6;
            } catch (Throwable th) {
                responseBody.close();
                throw th;
            }
        }
        if (i2 == 204 || i2 == 205) {
            responseBody.close();
            return retrofit2.Response.b(null, response5);
        }
        b bVar = new b(responseBody);
        try {
            return retrofit2.Response.b(this.m.convert(bVar), response5);
        } catch (RuntimeException e) {
            IOException iOException = bVar.n;
            if (iOException == null) {
                throw e;
            }
            throw iOException;
        }
    }
}
