package f0.e0.g;

import androidx.core.app.NotificationCompat;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.Call2;
import f0.EventListener;
import f0.HttpUrl;
import f0.Route;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: renamed from: f0.e0.g.m, reason: use source file name */
/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RouteSelector {
    public List<? extends Proxy> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3622b;
    public List<? extends InetSocketAddress> c;
    public final List<Route> d;
    public final Address e;
    public final RouteDatabase f;
    public final Call2 g;
    public final EventListener h;

    /* JADX INFO: renamed from: f0.e0.g.m$a */
    /* JADX INFO: compiled from: RouteSelector.kt */
    public static final class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Route> f3623b;

        public a(List<Route> list) {
            Intrinsics3.checkParameterIsNotNull(list, "routes");
            this.f3623b = list;
        }

        public final boolean a() {
            return this.a < this.f3623b.size();
        }

        public final Route b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<Route> list = this.f3623b;
            int i = this.a;
            this.a = i + 1;
            return list.get(i);
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call2 call2, EventListener eventListener) {
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(routeDatabase, "routeDatabase");
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        this.e = address;
        this.f = routeDatabase;
        this.g = call2;
        this.h = eventListener;
        this.a = Collections2.emptyList();
        this.c = Collections2.emptyList();
        this.d = new ArrayList();
        HttpUrl httpUrl = address.a;
        RouteSelector2 routeSelector2 = new RouteSelector2(this, address.j, httpUrl);
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        List<? extends Proxy> listInvoke = routeSelector2.invoke();
        this.a = listInvoke;
        this.f3622b = 0;
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(listInvoke, "proxies");
    }

    public final boolean a() {
        return b() || (this.d.isEmpty() ^ true);
    }

    public final boolean b() {
        return this.f3622b < this.a.size();
    }
}
