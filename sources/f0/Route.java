package f0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: renamed from: f0.c0, reason: use source file name */
/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Route {
    public final Address a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f3603b;
    public final InetSocketAddress c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "socketAddress");
        this.a = address;
        this.f3603b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean a() {
        return this.a.f != null && this.f3603b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (Intrinsics3.areEqual(route.a, this.a) && Intrinsics3.areEqual(route.f3603b, this.f3603b) && Intrinsics3.areEqual(route.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode() + ((this.f3603b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Route{");
        sbU.append(this.c);
        sbU.append('}');
        return sbU.toString();
    }
}
