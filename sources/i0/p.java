package i0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Headers$a;
import okhttp3.MediaType;
import okhttp3.MultipartBody$a;
import okhttp3.Request;
import okhttp3.Request$a;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p<T> implements d<T> {
    public final w j;
    public final Object[] k;
    public final f0.e$a l;
    public final h<ResponseBody, T> m;
    public volatile boolean n;
    public f0.e o;
    public Throwable p;
    public boolean q;

    public p(w wVar, Object[] objArr, f0.e$a e_a, h<ResponseBody, T> hVar) {
        this.j = wVar;
        this.k = objArr;
        this.l = e_a;
        this.m = hVar;
    }

    @Override // i0.d
    public void C(f<T> fVar) {
        f0.e eVar;
        Throwable th;
        synchronized (this) {
            if (this.q) {
                throw new IllegalStateException("Already executed.");
            }
            this.q = true;
            eVar = this.o;
            th = this.p;
            if (eVar == null && th == null) {
                try {
                    f0.e eVarB = b();
                    this.o = eVarB;
                    eVar = eVarB;
                } catch (Throwable th2) {
                    th = th2;
                    c0.o(th);
                    this.p = th;
                }
            }
        }
        if (th != null) {
            fVar.a(this, th);
            return;
        }
        if (this.n) {
            eVar.cancel();
        }
        eVar.e(new p$a(this, fVar));
    }

    @Override // i0.d
    public d L() {
        return new p(this.j, this.k, this.l, this.m);
    }

    public final f0.e b() throws IOException {
        f0.w wVarB;
        f0.e$a e_a = this.l;
        w wVar = this.j;
        Object[] objArr = this.k;
        t<?>[] tVarArr = wVar.j;
        int length = objArr.length;
        if (length != tVarArr.length) {
            throw new IllegalArgumentException(b.d.b.a.a.B(b.d.b.a.a.V("Argument count (", length, ") doesn't match expected count ("), tVarArr.length, ")"));
        }
        v vVar = new v(wVar.c, wVar.f3761b, wVar.d, wVar.e, wVar.f, wVar.g, wVar.h, wVar.i);
        if (wVar.k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            tVarArr[i].a(vVar, objArr[i]);
        }
        f0.w$a w_a = vVar.f;
        if (w_a != null) {
            wVarB = w_a.b();
        } else {
            f0.w wVar2 = vVar.d;
            String str = vVar.e;
            Objects.requireNonNull(wVar2);
            d0.z.d.m.checkParameterIsNotNull(str, "link");
            f0.w$a w_aG = wVar2.g(str);
            wVarB = w_aG != null ? w_aG.b() : null;
            if (wVarB == null) {
                StringBuilder sbU = b.d.b.a.a.U("Malformed URL. Base: ");
                sbU.append(vVar.d);
                sbU.append(", Relative: ");
                sbU.append(vVar.e);
                throw new IllegalArgumentException(sbU.toString());
            }
        }
        RequestBody v_a = vVar.m;
        if (v_a == null) {
            f0.u$a u_a = vVar.l;
            if (u_a != null) {
                v_a = new f0.u(u_a.a, u_a.f3679b);
            } else {
                MultipartBody$a multipartBody$a = vVar.k;
                if (multipartBody$a != null) {
                    v_a = multipartBody$a.b();
                } else if (vVar.j) {
                    v_a = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = vVar.i;
        if (mediaType != null) {
            if (v_a != null) {
                v_a = new v$a(v_a, mediaType);
            } else {
                vVar.h.a("Content-Type", mediaType.mediaType);
            }
        }
        Request$a request$a = vVar.g;
        request$a.g(wVarB);
        Headers headersC = vVar.h.c();
        d0.z.d.m.checkParameterIsNotNull(headersC, "headers");
        request$a.c = headersC.e();
        request$a.c(vVar.c, v_a);
        request$a.e(k.class, new k(wVar.a, arrayList));
        f0.e eVarB = e_a.b(request$a.a());
        Objects.requireNonNull(eVarB, "Call.Factory returned null.");
        return eVarB;
    }

    @Override // i0.d
    public synchronized Request c() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return f().c();
    }

    @Override // i0.d
    public void cancel() {
        f0.e eVar;
        this.n = true;
        synchronized (this) {
            eVar = this.o;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return new p(this.j, this.k, this.l, this.m);
    }

    @Override // i0.d
    public boolean d() {
        boolean z2 = true;
        if (this.n) {
            return true;
        }
        synchronized (this) {
            f0.e eVar = this.o;
            if (eVar == null || !eVar.d()) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // i0.d
    public Response<T> execute() throws IOException {
        f0.e eVarF;
        synchronized (this) {
            if (this.q) {
                throw new IllegalStateException("Already executed.");
            }
            this.q = true;
            eVarF = f();
        }
        if (this.n) {
            eVarF.cancel();
        }
        return g(eVarF.execute());
    }

    public final f0.e f() throws IOException {
        f0.e eVar = this.o;
        if (eVar != null) {
            return eVar;
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
            f0.e eVarB = b();
            this.o = eVarB;
            return eVarB;
        } catch (IOException | Error | RuntimeException e) {
            c0.o(e);
            this.p = e;
            throw e;
        }
    }

    public Response<T> g(okhttp3.Response response) throws IOException {
        ResponseBody responseBody = response.body;
        d0.z.d.m.checkParameterIsNotNull(response, "response");
        Request request = response.request;
        f0.y yVar = response.protocol;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        String str = response.message;
        f0.v vVar = response.handshake;
        Headers$a headers$aE = response.headers.e();
        okhttp3.Response response2 = response.networkResponse;
        okhttp3.Response response3 = response.cacheResponse;
        okhttp3.Response response4 = response.priorResponse;
        long j = response.sentRequestAtMillis;
        long j2 = response.receivedResponseAtMillis;
        f0.e0.g.c cVar = response.exchange;
        p$c p_c = new p$c(responseBody.b(), responseBody.a());
        if (!(i >= 0)) {
            throw new IllegalStateException(b.d.b.a.a.q("code < 0: ", i).toString());
        }
        if (request == null) {
            throw new IllegalStateException("request == null".toString());
        }
        if (yVar == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        if (str == null) {
            throw new IllegalStateException("message == null".toString());
        }
        okhttp3.Response response5 = new okhttp3.Response(request, yVar, str, i, vVar, headers$aE.c(), p_c, response2, response3, response4, j, j2, cVar);
        int i2 = response5.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        if (i2 < 200 || i2 >= 300) {
            try {
                ResponseBody responseBodyA = c0.a(responseBody);
                if (response5.b()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                Response<T> response6 = new Response<>(response5, null, responseBodyA);
                responseBody.close();
                return response6;
            } catch (Throwable th) {
                responseBody.close();
                throw th;
            }
        }
        if (i2 == 204 || i2 == 205) {
            responseBody.close();
            return Response.b(null, response5);
        }
        p$b p_b = new p$b(responseBody);
        try {
            return Response.b(this.m.convert(p_b), response5);
        } catch (RuntimeException e) {
            IOException iOException = p_b.n;
            if (iOException == null) {
                throw e;
            }
            throw iOException;
        }
    }
}
