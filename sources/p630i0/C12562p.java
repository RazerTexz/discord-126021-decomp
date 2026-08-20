package p630i0;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12377u;
import p600f0.C12378v;
import p600f0.C12379w;
import p600f0.EnumC12381y;
import p600f0.InterfaceC12269e;
import p600f0.InterfaceC12361f;
import p600f0.p601e0.p605g.C12283c;
import p615g0.AbstractC12393j;
import p615g0.C12388e;
import p615g0.C12401r;
import p615g0.InterfaceC12390g;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: i0.p */
/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12562p<T> implements InterfaceC12504d<T> {

    /* JADX INFO: renamed from: j */
    public final C12569w f26551j;

    /* JADX INFO: renamed from: k */
    public final Object[] f26552k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC12269e.a f26553l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC12554h<ResponseBody, T> f26554m;

    /* JADX INFO: renamed from: n */
    public volatile boolean f26555n;

    /* JADX INFO: renamed from: o */
    public InterfaceC12269e f26556o;

    /* JADX INFO: renamed from: p */
    public Throwable f26557p;

    /* JADX INFO: renamed from: q */
    public boolean f26558q;

    /* JADX INFO: renamed from: i0.p$a */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public class a implements InterfaceC12361f {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ InterfaceC12527f f26559a;

        public a(InterfaceC12527f interfaceC12527f) {
            this.f26559a = interfaceC12527f;
        }

        @Override // p600f0.InterfaceC12361f
        /* JADX INFO: renamed from: a */
        public void mo10358a(InterfaceC12269e interfaceC12269e, Response response) {
            try {
                try {
                    this.f26559a.mo10709b(C12562p.this, C12562p.this.m10714g(response));
                } catch (Throwable th) {
                    C12503c0.m10695o(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                C12503c0.m10695o(th2);
                try {
                    this.f26559a.mo10708a(C12562p.this, th2);
                } catch (Throwable th3) {
                    C12503c0.m10695o(th3);
                    th3.printStackTrace();
                }
            }
        }

        @Override // p600f0.InterfaceC12361f
        /* JADX INFO: renamed from: b */
        public void mo10359b(InterfaceC12269e interfaceC12269e, IOException iOException) {
            try {
                this.f26559a.mo10708a(C12562p.this, iOException);
            } catch (Throwable th) {
                C12503c0.m10695o(th);
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: i0.p$b */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public static final class b extends ResponseBody {

        /* JADX INFO: renamed from: l */
        public final ResponseBody f26561l;

        /* JADX INFO: renamed from: m */
        public final InterfaceC12390g f26562m;

        /* JADX INFO: renamed from: n */
        public IOException f26563n;

        /* JADX INFO: renamed from: i0.p$b$a */
        /* JADX INFO: compiled from: OkHttpCall.java */
        public class a extends AbstractC12393j {
            public a(InterfaceC12407x interfaceC12407x) {
                super(interfaceC12407x);
            }

            @Override // p615g0.InterfaceC12407x
            /* JADX INFO: renamed from: i0 */
            public long mo10176i0(C12388e c12388e, long j) throws IOException {
                try {
                    C12238m.checkParameterIsNotNull(c12388e, "sink");
                    return this.f26093j.mo10176i0(c12388e, j);
                } catch (IOException e) {
                    b.this.f26563n = e;
                    throw e;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.f26561l = responseBody;
            a aVar = new a(responseBody.mo10105c());
            C12238m.checkParameterIsNotNull(aVar, "$this$buffer");
            this.f26562m = new C12401r(aVar);
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: a */
        public long mo10103a() {
            return this.f26561l.mo10103a();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: b */
        public MediaType mo10104b() {
            return this.f26561l.mo10104b();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: c */
        public InterfaceC12390g mo10105c() {
            return this.f26562m;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f26561l.close();
        }
    }

    /* JADX INFO: renamed from: i0.p$c */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public static final class c extends ResponseBody {

        /* JADX INFO: renamed from: l */
        public final MediaType f26565l;

        /* JADX INFO: renamed from: m */
        public final long f26566m;

        public c(MediaType mediaType, long j) {
            this.f26565l = mediaType;
            this.f26566m = j;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: a */
        public long mo10103a() {
            return this.f26566m;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: b */
        public MediaType mo10104b() {
            return this.f26565l;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: c */
        public InterfaceC12390g mo10105c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public C12562p(C12569w c12569w, Object[] objArr, InterfaceC12269e.a aVar, InterfaceC12554h<ResponseBody, T> interfaceC12554h) {
        this.f26551j = c12569w;
        this.f26552k = objArr;
        this.f26553l = aVar;
        this.f26554m = interfaceC12554h;
    }

    @Override // p630i0.InterfaceC12504d
    /* JADX INFO: renamed from: C */
    public void mo10697C(InterfaceC12527f<T> interfaceC12527f) {
        InterfaceC12269e interfaceC12269e;
        Throwable th;
        synchronized (this) {
            if (this.f26558q) {
                throw new IllegalStateException("Already executed.");
            }
            this.f26558q = true;
            interfaceC12269e = this.f26556o;
            th = this.f26557p;
            if (interfaceC12269e == null && th == null) {
                try {
                    InterfaceC12269e interfaceC12269eM10712b = m10712b();
                    this.f26556o = interfaceC12269eM10712b;
                    interfaceC12269e = interfaceC12269eM10712b;
                } catch (Throwable th2) {
                    th = th2;
                    C12503c0.m10695o(th);
                    this.f26557p = th;
                }
            }
        }
        if (th != null) {
            interfaceC12527f.mo10708a(this, th);
            return;
        }
        if (this.f26555n) {
            interfaceC12269e.cancel();
        }
        interfaceC12269e.mo10113e(new a(interfaceC12527f));
    }

    @Override // p630i0.InterfaceC12504d
    /* JADX INFO: renamed from: L */
    public InterfaceC12504d clone() {
        return new C12562p(this.f26551j, this.f26552k, this.f26553l, this.f26554m);
    }

    /* JADX INFO: renamed from: b */
    public final InterfaceC12269e m10712b() throws IOException {
        C12379w c12379wM10409b;
        InterfaceC12269e.a aVar = this.f26553l;
        C12569w c12569w = this.f26551j;
        Object[] objArr = this.f26552k;
        AbstractC12566t<?>[] abstractC12566tArr = c12569w.f26642j;
        int length = objArr.length;
        if (length != abstractC12566tArr.length) {
            throw new IllegalArgumentException(C1643a.m814B(C1643a.m834V("Argument count (", length, ") doesn't match expected count ("), abstractC12566tArr.length, ")"));
        }
        C12568v c12568v = new C12568v(c12569w.f26635c, c12569w.f26634b, c12569w.f26636d, c12569w.f26637e, c12569w.f26638f, c12569w.f26639g, c12569w.f26640h, c12569w.f26641i);
        if (c12569w.f26643k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            abstractC12566tArr[i].mo10715a(c12568v, objArr[i]);
        }
        C12379w.a aVar2 = c12568v.f26623f;
        if (aVar2 != null) {
            c12379wM10409b = aVar2.m10409b();
        } else {
            C12379w c12379w = c12568v.f26621d;
            String str = c12568v.f26622e;
            Objects.requireNonNull(c12379w);
            C12238m.checkParameterIsNotNull(str, "link");
            C12379w.a aVarM10405g = c12379w.m10405g(str);
            c12379wM10409b = aVarM10405g != null ? aVarM10405g.m10409b() : null;
            if (c12379wM10409b == null) {
                StringBuilder sbM833U = C1643a.m833U("Malformed URL. Base: ");
                sbM833U.append(c12568v.f26621d);
                sbM833U.append(", Relative: ");
                sbM833U.append(c12568v.f26622e);
                throw new IllegalArgumentException(sbM833U.toString());
            }
        }
        RequestBody aVar3 = c12568v.f26630m;
        if (aVar3 == null) {
            C12377u.a aVar4 = c12568v.f26629l;
            if (aVar4 != null) {
                aVar3 = new C12377u(aVar4.f25966a, aVar4.f25967b);
            } else {
                MultipartBody.C12933a c12933a = c12568v.f26628k;
                if (c12933a != null) {
                    aVar3 = c12933a.m10973b();
                } else if (c12568v.f26627j) {
                    aVar3 = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = c12568v.f26626i;
        if (mediaType != null) {
            if (aVar3 != null) {
                aVar3 = new C12568v.a(aVar3, mediaType);
            } else {
                c12568v.f26625h.m10958a("Content-Type", mediaType.mediaType);
            }
        }
        Request.C12935a c12935a = c12568v.f26624g;
        c12935a.m10984g(c12379wM10409b);
        Headers headersM10960c = c12568v.f26625h.m10960c();
        C12238m.checkParameterIsNotNull(headersM10960c, "headers");
        c12935a.f27545c = headersM10960c.m10956e();
        c12935a.m10980c(c12568v.f26620c, aVar3);
        c12935a.m10982e(C12557k.class, new C12557k(c12569w.f26633a, arrayList));
        InterfaceC12269e interfaceC12269eMo10114b = aVar.mo10114b(c12935a.m10978a());
        Objects.requireNonNull(interfaceC12269eMo10114b, "Call.Factory returned null.");
        return interfaceC12269eMo10114b;
    }

    @Override // p630i0.InterfaceC12504d
    /* JADX INFO: renamed from: c */
    public synchronized Request mo10699c() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return m10713f().mo10111c();
    }

    @Override // p630i0.InterfaceC12504d
    public void cancel() {
        InterfaceC12269e interfaceC12269e;
        this.f26555n = true;
        synchronized (this) {
            interfaceC12269e = this.f26556o;
        }
        if (interfaceC12269e != null) {
            interfaceC12269e.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return new C12562p(this.f26551j, this.f26552k, this.f26553l, this.f26554m);
    }

    @Override // p630i0.InterfaceC12504d
    /* JADX INFO: renamed from: d */
    public boolean mo10700d() {
        boolean z2 = true;
        if (this.f26555n) {
            return true;
        }
        synchronized (this) {
            InterfaceC12269e interfaceC12269e = this.f26556o;
            if (interfaceC12269e == null || !interfaceC12269e.mo10112d()) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // p630i0.InterfaceC12504d
    public retrofit2.Response<T> execute() throws IOException {
        InterfaceC12269e interfaceC12269eM10713f;
        synchronized (this) {
            if (this.f26558q) {
                throw new IllegalStateException("Already executed.");
            }
            this.f26558q = true;
            interfaceC12269eM10713f = m10713f();
        }
        if (this.f26555n) {
            interfaceC12269eM10713f.cancel();
        }
        return m10714g(interfaceC12269eM10713f.execute());
    }

    /* JADX INFO: renamed from: f */
    public final InterfaceC12269e m10713f() throws IOException {
        InterfaceC12269e interfaceC12269e = this.f26556o;
        if (interfaceC12269e != null) {
            return interfaceC12269e;
        }
        Throwable th = this.f26557p;
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
            InterfaceC12269e interfaceC12269eM10712b = m10712b();
            this.f26556o = interfaceC12269eM10712b;
            return interfaceC12269eM10712b;
        } catch (IOException | Error | RuntimeException e) {
            C12503c0.m10695o(e);
            this.f26557p = e;
            throw e;
        }
    }

    /* JADX INFO: renamed from: g */
    public retrofit2.Response<T> m10714g(Response response) throws IOException {
        ResponseBody responseBody = response.body;
        C12238m.checkParameterIsNotNull(response, "response");
        Request request = response.request;
        EnumC12381y enumC12381y = response.protocol;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        String str = response.message;
        C12378v c12378v = response.handshake;
        Headers.C12930a c12930aM10956e = response.headers.m10956e();
        Response response2 = response.networkResponse;
        Response response3 = response.cacheResponse;
        Response response4 = response.priorResponse;
        long j = response.sentRequestAtMillis;
        long j2 = response.receivedResponseAtMillis;
        C12283c c12283c = response.exchange;
        c cVar = new c(responseBody.mo10104b(), responseBody.mo10103a());
        if (!(i >= 0)) {
            throw new IllegalStateException(C1643a.m871q("code < 0: ", i).toString());
        }
        if (request == null) {
            throw new IllegalStateException("request == null".toString());
        }
        if (enumC12381y == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        if (str == null) {
            throw new IllegalStateException("message == null".toString());
        }
        Response response5 = new Response(request, enumC12381y, str, i, c12378v, c12930aM10956e.m10960c(), cVar, response2, response3, response4, j, j2, c12283c);
        int i2 = response5.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        if (i2 < 200 || i2 >= 300) {
            try {
                ResponseBody responseBodyM10681a = C12503c0.m10681a(responseBody);
                if (response5.m10990b()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                retrofit2.Response<T> response6 = new retrofit2.Response<>(response5, null, responseBodyM10681a);
                responseBody.close();
                return response6;
            } catch (Throwable th) {
                responseBody.close();
                throw th;
            }
        }
        if (i2 == 204 || i2 == 205) {
            responseBody.close();
            return retrofit2.Response.m11056b(null, response5);
        }
        b bVar = new b(responseBody);
        try {
            return retrofit2.Response.m11056b(this.f26554m.convert(bVar), response5);
        } catch (RuntimeException e) {
            IOException iOException = bVar.f26563n;
            if (iOException == null) {
                throw e;
            }
            throw iOException;
        }
    }
}
