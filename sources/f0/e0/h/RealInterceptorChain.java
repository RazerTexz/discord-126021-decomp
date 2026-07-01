package f0.e0.h;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import f0.Connection2;
import f0.e0.g.Exchange;
import f0.e0.g.RealCall;
import java.io.IOException;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: f0.e0.h.g, reason: use source file name */
/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RealCall f3628b;
    public final List<Interceptor> c;
    public final int d;
    public final Exchange e;
    public final Request f;
    public final int g;
    public final int h;
    public final int i;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i, Exchange exchange, Request request, int i2, int i3, int i4) {
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(list, "interceptors");
        Intrinsics3.checkParameterIsNotNull(request, "request");
        this.f3628b = realCall;
        this.c = list;
        this.d = i;
        this.e = exchange;
        this.f = request;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public static RealInterceptorChain d(RealInterceptorChain realInterceptorChain, int i, Exchange exchange, Request request, int i2, int i3, int i4, int i5) {
        int i6 = (i5 & 1) != 0 ? realInterceptorChain.d : i;
        Exchange exchange2 = (i5 & 2) != 0 ? realInterceptorChain.e : exchange;
        Request request2 = (i5 & 4) != 0 ? realInterceptorChain.f : request;
        int i7 = (i5 & 8) != 0 ? realInterceptorChain.g : i2;
        int i8 = (i5 & 16) != 0 ? realInterceptorChain.h : i3;
        int i9 = (i5 & 32) != 0 ? realInterceptorChain.i : i4;
        Intrinsics3.checkParameterIsNotNull(request2, "request");
        return new RealInterceptorChain(realInterceptorChain.f3628b, realInterceptorChain.c, i6, exchange2, request2, i7, i8, i9);
    }

    @Override // okhttp3.Interceptor.Chain
    public Response a(Request request) throws IOException {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        if (!(this.d < this.c.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.a++;
        Exchange exchange = this.e;
        if (exchange != null) {
            if (!exchange.e.b(request.url)) {
                StringBuilder sbU = outline.U("network interceptor ");
                sbU.append(this.c.get(this.d - 1));
                sbU.append(" must retain the same host and port");
                throw new IllegalStateException(sbU.toString().toString());
            }
            if (!(this.a == 1)) {
                StringBuilder sbU2 = outline.U("network interceptor ");
                sbU2.append(this.c.get(this.d - 1));
                sbU2.append(" must call proceed() exactly once");
                throw new IllegalStateException(sbU2.toString().toString());
            }
        }
        RealInterceptorChain realInterceptorChainD = d(this, this.d + 1, null, request, 0, 0, 0, 58);
        Interceptor interceptor = this.c.get(this.d);
        Response responseIntercept = interceptor.intercept(realInterceptorChainD);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.e != null) {
            if (!(this.d + 1 >= this.c.size() || realInterceptorChainD.a == 1)) {
                throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
            }
        }
        if (responseIntercept.body != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    public Connection2 b() {
        Exchange exchange = this.e;
        if (exchange != null) {
            return exchange.f3614b;
        }
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request c() {
        return this.f;
    }
}
