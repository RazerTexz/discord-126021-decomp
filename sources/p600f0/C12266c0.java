package p600f0;

import java.net.InetSocketAddress;
import java.net.Proxy;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.c0 */
/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12266c0 {

    /* JADX INFO: renamed from: a */
    public final C12261a f25370a;

    /* JADX INFO: renamed from: b */
    public final Proxy f25371b;

    /* JADX INFO: renamed from: c */
    public final InetSocketAddress f25372c;

    public C12266c0(C12261a c12261a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        C12238m.checkParameterIsNotNull(c12261a, "address");
        C12238m.checkParameterIsNotNull(proxy, "proxy");
        C12238m.checkParameterIsNotNull(inetSocketAddress, "socketAddress");
        this.f25370a = c12261a;
        this.f25371b = proxy;
        this.f25372c = inetSocketAddress;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10106a() {
        return this.f25370a.f25358f != null && this.f25371b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12266c0) {
            C12266c0 c12266c0 = (C12266c0) obj;
            if (C12238m.areEqual(c12266c0.f25370a, this.f25370a) && C12238m.areEqual(c12266c0.f25371b, this.f25371b) && C12238m.areEqual(c12266c0.f25372c, this.f25372c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f25372c.hashCode() + ((this.f25371b.hashCode() + ((this.f25370a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Route{");
        sbM833U.append(this.f25372c);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
