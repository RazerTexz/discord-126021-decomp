package p600f0.p601e0.p605g;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.connection.RouteException;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p600f0.p601e0.p606h.C12301g;

/* JADX INFO: renamed from: f0.e0.g.a */
/* JADX INFO: compiled from: ConnectInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12281a implements Interceptor {

    /* JADX INFO: renamed from: b */
    public static final C12281a f25432b = new C12281a();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        C12238m.checkParameterIsNotNull(chain, "chain");
        C12301g c12301g = (C12301g) chain;
        C12285e c12285e = c12301g.f25532b;
        Objects.requireNonNull(c12285e);
        C12238m.checkParameterIsNotNull(c12301g, "chain");
        synchronized (c12285e) {
            if (!c12285e.f25476u) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!c12285e.f25475t)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!c12285e.f25474s)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        C12284d c12284d = c12285e.f25470o;
        if (c12284d == null) {
            C12238m.throwNpe();
        }
        C12380x c12380x = c12285e.f25480y;
        Objects.requireNonNull(c12284d);
        C12238m.checkParameterIsNotNull(c12380x, "client");
        C12238m.checkParameterIsNotNull(c12301g, "chain");
        try {
            C12283c c12283c = new C12283c(c12285e, c12285e.f25466k, c12284d, c12284d.m10177a(c12301g.f25537g, c12301g.f25538h, c12301g.f25539i, c12380x.f26009M, c12380x.f26017r, !C12238m.areEqual(c12301g.f25536f.method, ShareTarget.METHOD_GET)).m10202k(c12380x, c12301g));
            c12285e.f25473r = c12283c;
            c12285e.f25478w = c12283c;
            synchronized (c12285e) {
                c12285e.f25474s = true;
                c12285e.f25475t = true;
            }
            if (c12285e.f25477v) {
                throw new IOException("Canceled");
            }
            return C12301g.m10227d(c12301g, 0, c12283c, null, 0, 0, 0, 61).mo10228a(c12301g.f25536f);
        } catch (IOException e) {
            c12284d.m10179c(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            c12284d.m10179c(e2.getLastConnectException());
            throw e2;
        }
    }
}
