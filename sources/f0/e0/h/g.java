package f0.e0.h;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import f0.k;
import java.io.IOException;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.Interceptor$Chain;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Interceptor$Chain {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0.e0.g.e f3628b;
    public final List<Interceptor> c;
    public final int d;
    public final f0.e0.g.c e;
    public final Request f;
    public final int g;
    public final int h;
    public final int i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(f0.e0.g.e eVar, List<? extends Interceptor> list, int i, f0.e0.g.c cVar, Request request, int i2, int i3, int i4) {
        m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        m.checkParameterIsNotNull(list, "interceptors");
        m.checkParameterIsNotNull(request, "request");
        this.f3628b = eVar;
        this.c = list;
        this.d = i;
        this.e = cVar;
        this.f = request;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public static g d(g gVar, int i, f0.e0.g.c cVar, Request request, int i2, int i3, int i4, int i5) {
        int i6 = (i5 & 1) != 0 ? gVar.d : i;
        f0.e0.g.c cVar2 = (i5 & 2) != 0 ? gVar.e : cVar;
        Request request2 = (i5 & 4) != 0 ? gVar.f : request;
        int i7 = (i5 & 8) != 0 ? gVar.g : i2;
        int i8 = (i5 & 16) != 0 ? gVar.h : i3;
        int i9 = (i5 & 32) != 0 ? gVar.i : i4;
        m.checkParameterIsNotNull(request2, "request");
        return new g(gVar.f3628b, gVar.c, i6, cVar2, request2, i7, i8, i9);
    }

    @Override // okhttp3.Interceptor$Chain
    public Response a(Request request) throws IOException {
        m.checkParameterIsNotNull(request, "request");
        if (!(this.d < this.c.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.a++;
        f0.e0.g.c cVar = this.e;
        if (cVar != null) {
            if (!cVar.e.b(request.url)) {
                StringBuilder sbU = b.d.b.a.a.U("network interceptor ");
                sbU.append(this.c.get(this.d - 1));
                sbU.append(" must retain the same host and port");
                throw new IllegalStateException(sbU.toString().toString());
            }
            if (!(this.a == 1)) {
                StringBuilder sbU2 = b.d.b.a.a.U("network interceptor ");
                sbU2.append(this.c.get(this.d - 1));
                sbU2.append(" must call proceed() exactly once");
                throw new IllegalStateException(sbU2.toString().toString());
            }
        }
        g gVarD = d(this, this.d + 1, null, request, 0, 0, 0, 58);
        Interceptor interceptor = this.c.get(this.d);
        Response responseIntercept = interceptor.intercept(gVarD);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.e != null) {
            if (!(this.d + 1 >= this.c.size() || gVarD.a == 1)) {
                throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
            }
        }
        if (responseIntercept.body != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    public k b() {
        f0.e0.g.c cVar = this.e;
        if (cVar != null) {
            return cVar.f3614b;
        }
        return null;
    }

    @Override // okhttp3.Interceptor$Chain
    public Request c() {
        return this.f;
    }
}
