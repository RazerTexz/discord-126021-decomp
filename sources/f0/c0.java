package f0;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy$Type;

/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f3603b;
    public final InetSocketAddress c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "address");
        d0.z.d.m.checkParameterIsNotNull(proxy, "proxy");
        d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "socketAddress");
        this.a = aVar;
        this.f3603b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean a() {
        return this.a.f != null && this.f3603b.type() == Proxy$Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (d0.z.d.m.areEqual(c0Var.a, this.a) && d0.z.d.m.areEqual(c0Var.f3603b, this.f3603b) && d0.z.d.m.areEqual(c0Var.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode() + ((this.f3603b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Route{");
        sbU.append(this.c);
        sbU.append('}');
        return sbU.toString();
    }
}
