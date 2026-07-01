package f0.e0.g;

import androidx.browser.trusted.sharing.ShareTarget;
import f0.x;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Interceptor$Chain;
import okhttp3.Response;
import okhttp3.internal.connection.RouteException;

/* JADX INFO: compiled from: ConnectInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3612b = new a();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor$Chain interceptor$Chain) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(interceptor$Chain, "chain");
        f0.e0.h.g gVar = (f0.e0.h.g) interceptor$Chain;
        e eVar = gVar.f3628b;
        Objects.requireNonNull(eVar);
        d0.z.d.m.checkParameterIsNotNull(gVar, "chain");
        synchronized (eVar) {
            if (!eVar.u) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!eVar.t)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!eVar.f3616s)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        d dVar = eVar.o;
        if (dVar == null) {
            d0.z.d.m.throwNpe();
        }
        x xVar = eVar.f3618y;
        Objects.requireNonNull(dVar);
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(gVar, "chain");
        try {
            c cVar = new c(eVar, eVar.k, dVar, dVar.a(gVar.g, gVar.h, gVar.i, xVar.M, xVar.r, !d0.z.d.m.areEqual(gVar.f.method, ShareTarget.METHOD_GET)).k(xVar, gVar));
            eVar.r = cVar;
            eVar.w = cVar;
            synchronized (eVar) {
                eVar.f3616s = true;
                eVar.t = true;
            }
            if (eVar.v) {
                throw new IOException("Canceled");
            }
            return f0.e0.h.g.d(gVar, 0, cVar, null, 0, 0, 0, 61).a(gVar.f);
        } catch (IOException e) {
            dVar.c(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            dVar.c(e2.getLastConnectException());
            throw e2;
        }
    }
}
