package f0.e0.g;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.z.d.Intrinsics3;
import f0.OkHttpClient;
import f0.e0.h.RealInterceptorChain;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.connection.RouteException;

/* JADX INFO: renamed from: f0.e0.g.a, reason: use source file name */
/* JADX INFO: compiled from: ConnectInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConnectInterceptor f3612b = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        RealCall realCall = realInterceptorChain.f3628b;
        Objects.requireNonNull(realCall);
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        synchronized (realCall) {
            if (!realCall.u) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!realCall.t)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!realCall.f3616s)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ExchangeFinder exchangeFinder = realCall.o;
        if (exchangeFinder == null) {
            Intrinsics3.throwNpe();
        }
        OkHttpClient okHttpClient = realCall.f3618y;
        Objects.requireNonNull(exchangeFinder);
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        try {
            Exchange exchange = new Exchange(realCall, realCall.k, exchangeFinder, exchangeFinder.a(realInterceptorChain.g, realInterceptorChain.h, realInterceptorChain.i, okHttpClient.M, okHttpClient.r, !Intrinsics3.areEqual(realInterceptorChain.f.method, ShareTarget.METHOD_GET)).k(okHttpClient, realInterceptorChain));
            realCall.r = exchange;
            realCall.w = exchange;
            synchronized (realCall) {
                realCall.f3616s = true;
                realCall.t = true;
            }
            if (realCall.v) {
                throw new IOException("Canceled");
            }
            return RealInterceptorChain.d(realInterceptorChain, 0, exchange, null, 0, 0, 0, 61).a(realInterceptorChain.f);
        } catch (IOException e) {
            exchangeFinder.c(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            exchangeFinder.c(e2.getLastConnectException());
            throw e2;
        }
    }
}
