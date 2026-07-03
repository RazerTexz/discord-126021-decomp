package p600f0.p601e0.p606h;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.InterfaceC12367k;
import p600f0.p601e0.p605g.C12283c;
import p600f0.p601e0.p605g.C12285e;

/* JADX INFO: renamed from: f0.e0.h.g */
/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12301g implements Interceptor.Chain {

    /* JADX INFO: renamed from: a */
    public int f25531a;

    /* JADX INFO: renamed from: b */
    public final C12285e f25532b;

    /* JADX INFO: renamed from: c */
    public final List<Interceptor> f25533c;

    /* JADX INFO: renamed from: d */
    public final int f25534d;

    /* JADX INFO: renamed from: e */
    public final C12283c f25535e;

    /* JADX INFO: renamed from: f */
    public final Request f25536f;

    /* JADX INFO: renamed from: g */
    public final int f25537g;

    /* JADX INFO: renamed from: h */
    public final int f25538h;

    /* JADX INFO: renamed from: i */
    public final int f25539i;

    /* JADX WARN: Multi-variable type inference failed */
    public C12301g(C12285e c12285e, List<? extends Interceptor> list, int i, C12283c c12283c, Request request, int i2, int i3, int i4) {
        C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(list, "interceptors");
        C12238m.checkParameterIsNotNull(request, "request");
        this.f25532b = c12285e;
        this.f25533c = list;
        this.f25534d = i;
        this.f25535e = c12283c;
        this.f25536f = request;
        this.f25537g = i2;
        this.f25538h = i3;
        this.f25539i = i4;
    }

    /* JADX INFO: renamed from: d */
    public static C12301g m10227d(C12301g c12301g, int i, C12283c c12283c, Request request, int i2, int i3, int i4, int i5) {
        int i6 = (i5 & 1) != 0 ? c12301g.f25534d : i;
        C12283c c12283c2 = (i5 & 2) != 0 ? c12301g.f25535e : c12283c;
        Request request2 = (i5 & 4) != 0 ? c12301g.f25536f : request;
        int i7 = (i5 & 8) != 0 ? c12301g.f25537g : i2;
        int i8 = (i5 & 16) != 0 ? c12301g.f25538h : i3;
        int i9 = (i5 & 32) != 0 ? c12301g.f25539i : i4;
        C12238m.checkParameterIsNotNull(request2, "request");
        return new C12301g(c12301g.f25532b, c12301g.f25533c, i6, c12283c2, request2, i7, i8, i9);
    }

    @Override // okhttp3.Interceptor.Chain
    /* JADX INFO: renamed from: a */
    public Response mo10228a(Request request) throws IOException {
        C12238m.checkParameterIsNotNull(request, "request");
        if (!(this.f25534d < this.f25533c.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f25531a++;
        C12283c c12283c = this.f25535e;
        if (c12283c != null) {
            if (!c12283c.f25441e.m10178b(request.url)) {
                StringBuilder sbM833U = C1643a.m833U("network interceptor ");
                sbM833U.append(this.f25533c.get(this.f25534d - 1));
                sbM833U.append(" must retain the same host and port");
                throw new IllegalStateException(sbM833U.toString().toString());
            }
            if (!(this.f25531a == 1)) {
                StringBuilder sbM833U2 = C1643a.m833U("network interceptor ");
                sbM833U2.append(this.f25533c.get(this.f25534d - 1));
                sbM833U2.append(" must call proceed() exactly once");
                throw new IllegalStateException(sbM833U2.toString().toString());
            }
        }
        C12301g c12301gM10227d = m10227d(this, this.f25534d + 1, null, request, 0, 0, 0, 58);
        Interceptor interceptor = this.f25533c.get(this.f25534d);
        Response responseIntercept = interceptor.intercept(c12301gM10227d);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.f25535e != null) {
            if (!(this.f25534d + 1 >= this.f25533c.size() || c12301gM10227d.f25531a == 1)) {
                throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
            }
        }
        if (responseIntercept.body != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    /* JADX INFO: renamed from: b */
    public InterfaceC12367k m10229b() {
        C12283c c12283c = this.f25535e;
        if (c12283c != null) {
            return c12283c.f25438b;
        }
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    /* JADX INFO: renamed from: c */
    public Request mo10230c() {
        return this.f25536f;
    }
}
