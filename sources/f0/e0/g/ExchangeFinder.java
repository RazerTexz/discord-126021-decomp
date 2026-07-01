package f0.e0.g;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.Call2;
import f0.EventListener;
import f0.HttpUrl;
import f0.Route;
import f0.e0.Util7;
import f0.e0.f.TaskQueue2;
import f0.e0.g.RouteSelector;
import f0.e0.j.ErrorCode2;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: renamed from: f0.e0.g.d, reason: use source file name */
/* JADX INFO: compiled from: ExchangeFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExchangeFinder {
    public RouteSelector.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RouteSelector f3615b;
    public int c;
    public int d;
    public int e;
    public Route f;
    public final RealConnectionPool g;
    public final Address h;
    public final RealCall i;
    public final EventListener j;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        Intrinsics3.checkParameterIsNotNull(realConnectionPool, "connectionPool");
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        this.g = realConnectionPool;
        this.h = address;
        this.i = realCall;
        this.j = eventListener;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x024d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0266  */
    /* JADX WARN: Code duplicated, block: B:115:0x0272  */
    /* JADX WARN: Code duplicated, block: B:117:0x0278  */
    /* JADX WARN: Code duplicated, block: B:119:0x0284  */
    /* JADX WARN: Code duplicated, block: B:128:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:130:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:132:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:170:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x02e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0361 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0226 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x0083  */
    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    /* JADX WARN: Code duplicated, block: B:40:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x013e  */
    public final RealConnection4 a(int i, int i2, int i3, int i4, boolean z2, boolean z3) throws IOException {
        Route routeB;
        RouteSelector.a aVar;
        RouteSelector routeSelector;
        ArrayList arrayList;
        RouteSelector.a aVar2;
        List<Route> list;
        Proxy proxy;
        String hostName;
        int port;
        boolean zContains;
        RealConnection4 realConnection4;
        RouteDatabase routeDatabase;
        Route route;
        RealConnection4 realConnection5;
        Socket socketM;
        while (!this.i.v) {
            RealConnection4 realConnection6 = this.i.p;
            if (realConnection6 != null) {
                synchronized (realConnection6) {
                    socketM = (realConnection6.i || !b(realConnection6.q.a.a)) ? this.i.m() : null;
                }
                if (this.i.p != null) {
                    if (!(socketM == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    if (socketM != null) {
                        Util7.e(socketM);
                    }
                    EventListener eventListener = this.j;
                    RealCall realCall = this.i;
                    Objects.requireNonNull(eventListener);
                    Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(realConnection6, "connection");
                    this.c = 0;
                    this.d = 0;
                    this.e = 0;
                    if (this.g.a(this.h, this.i, null, false)) {
                        realConnection6 = this.i.p;
                        if (realConnection6 == null) {
                            Intrinsics3.throwNpe();
                        }
                        this.j.a(this.i, realConnection6);
                    } else {
                        routeB = this.f;
                        try {
                            if (routeB != null) {
                                this.f = null;
                            } else {
                                aVar = this.a;
                                if (aVar == null && aVar.a()) {
                                    RouteSelector.a aVar3 = this.a;
                                    if (aVar3 == null) {
                                        Intrinsics3.throwNpe();
                                    }
                                    routeB = aVar3.b();
                                } else {
                                    routeSelector = this.f3615b;
                                    if (routeSelector == null) {
                                        Address address = this.h;
                                        RealCall realCall2 = this.i;
                                        routeSelector = new RouteSelector(address, realCall2.f3618y.O, realCall2, this.j);
                                        this.f3615b = routeSelector;
                                    }
                                    if (routeSelector.a()) {
                                        throw new NoSuchElementException();
                                    }
                                    arrayList = new ArrayList();
                                    while (routeSelector.b()) {
                                        if (routeSelector.b()) {
                                            StringBuilder sbU = outline.U("No route to ");
                                            sbU.append(routeSelector.e.a.g);
                                            sbU.append("; exhausted proxy configurations: ");
                                            sbU.append(routeSelector.a);
                                            throw new SocketException(sbU.toString());
                                        }
                                        List<? extends Proxy> list2 = routeSelector.a;
                                        int i5 = routeSelector.f3622b;
                                        routeSelector.f3622b = i5 + 1;
                                        proxy = list2.get(i5);
                                        ArrayList arrayList2 = new ArrayList();
                                        routeSelector.c = arrayList2;
                                        if (proxy.type() != Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            HttpUrl httpUrl = routeSelector.e.a;
                                            hostName = httpUrl.g;
                                            port = httpUrl.h;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                StringBuilder sbU2 = outline.U("Proxy.address() is not an InetSocketAddress: ");
                                                sbU2.append(socketAddressAddress.getClass());
                                                throw new IllegalArgumentException(sbU2.toString().toString());
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "$this$socketHost");
                                            InetAddress address2 = inetSocketAddress.getAddress();
                                            if (address2 != null) {
                                                hostName = address2.getHostAddress();
                                                Intrinsics3.checkExpressionValueIsNotNull(hostName, "address.hostAddress");
                                            } else {
                                                hostName = inetSocketAddress.getHostName();
                                                Intrinsics3.checkExpressionValueIsNotNull(hostName, "hostName");
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 <= port || 65535 < port) {
                                            throw new SocketException("No route to " + hostName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
                                        } else {
                                            EventListener eventListener2 = routeSelector.h;
                                            Call2 call2 = routeSelector.g;
                                            Objects.requireNonNull(eventListener2);
                                            Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(hostName, "domainName");
                                            List<InetAddress> listA = routeSelector.e.d.a(hostName);
                                            if (listA.isEmpty()) {
                                                throw new UnknownHostException(routeSelector.e.d + " returned no addresses for " + hostName);
                                            }
                                            EventListener eventListener3 = routeSelector.h;
                                            Call2 call3 = routeSelector.g;
                                            Objects.requireNonNull(eventListener3);
                                            Intrinsics3.checkParameterIsNotNull(call3, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(hostName, "domainName");
                                            Intrinsics3.checkParameterIsNotNull(listA, "inetAddressList");
                                            Iterator<InetAddress> it = listA.iterator();
                                            while (it.hasNext()) {
                                                arrayList2.add(new InetSocketAddress(it.next(), port));
                                            }
                                        }
                                        Iterator<? extends InetSocketAddress> it2 = routeSelector.c.iterator();
                                        while (it2.hasNext()) {
                                            Route route2 = new Route(routeSelector.e, proxy, it2.next());
                                            RouteDatabase routeDatabase2 = routeSelector.f;
                                            synchronized (routeDatabase2) {
                                                Intrinsics3.checkParameterIsNotNull(route2, "route");
                                                zContains = routeDatabase2.a.contains(route2);
                                            }
                                            if (zContains) {
                                                routeSelector.d.add(route2);
                                            } else {
                                                arrayList.add(route2);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        MutableCollections.addAll(arrayList, routeSelector.d);
                                        routeSelector.d.clear();
                                    }
                                    aVar2 = new RouteSelector.a(arrayList);
                                    this.a = aVar2;
                                    list = aVar2.f3623b;
                                    if (!this.i.v) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.g.a(this.h, this.i, list, false)) {
                                        realConnection6 = this.i.p;
                                        if (realConnection6 == null) {
                                            Intrinsics3.throwNpe();
                                        }
                                        this.j.a(this.i, realConnection6);
                                    } else {
                                        routeB = aVar2.b();
                                        realConnection4 = new RealConnection4(this.g, routeB);
                                        this.i.f3617x = realConnection4;
                                        realConnection4.c(i, i2, i3, i4, z2, this.i, this.j);
                                        this.i.f3617x = null;
                                        routeDatabase = this.i.f3618y.O;
                                        route = realConnection4.q;
                                        synchronized (routeDatabase) {
                                            Intrinsics3.checkParameterIsNotNull(route, "route");
                                            routeDatabase.a.remove(route);
                                        }
                                        if (this.g.a(this.h, this.i, list, true)) {
                                            realConnection5 = this.i.p;
                                            if (realConnection5 == null) {
                                                Intrinsics3.throwNpe();
                                            }
                                            this.f = routeB;
                                            Util7.e(realConnection4.n());
                                            this.j.a(this.i, realConnection5);
                                            realConnection6 = realConnection5;
                                        } else {
                                            synchronized (realConnection4) {
                                                RealConnectionPool realConnectionPool = this.g;
                                                Objects.requireNonNull(realConnectionPool);
                                                Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                                byte[] bArr = Util7.a;
                                                realConnectionPool.d.add(realConnection4);
                                                TaskQueue2.d(realConnectionPool.f3621b, realConnectionPool.c, 0L, 2);
                                                this.i.f(realConnection4);
                                            }
                                            EventListener eventListener4 = this.j;
                                            RealCall realCall3 = this.i;
                                            Objects.requireNonNull(eventListener4);
                                            Intrinsics3.checkParameterIsNotNull(realCall3, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                            realConnection6 = realConnection4;
                                        }
                                    }
                                }
                            }
                            realConnection4.c(i, i2, i3, i4, z2, this.i, this.j);
                            this.i.f3617x = null;
                            routeDatabase = this.i.f3618y.O;
                            route = realConnection4.q;
                            synchronized (routeDatabase) {
                                Intrinsics3.checkParameterIsNotNull(route, "route");
                                routeDatabase.a.remove(route);
                                if (this.g.a(this.h, this.i, list, true)) {
                                    realConnection5 = this.i.p;
                                    if (realConnection5 == null) {
                                        Intrinsics3.throwNpe();
                                    }
                                    this.f = routeB;
                                    Util7.e(realConnection4.n());
                                    this.j.a(this.i, realConnection5);
                                    realConnection6 = realConnection5;
                                } else {
                                    synchronized (realConnection4) {
                                        RealConnectionPool realConnectionPool2 = this.g;
                                        Objects.requireNonNull(realConnectionPool2);
                                        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                        byte[] bArr2 = Util7.a;
                                        realConnectionPool2.d.add(realConnection4);
                                        TaskQueue2.d(realConnectionPool2.f3621b, realConnectionPool2.c, 0L, 2);
                                        this.i.f(realConnection4);
                                        EventListener eventListener5 = this.j;
                                        RealCall realCall4 = this.i;
                                        Objects.requireNonNull(eventListener5);
                                        Intrinsics3.checkParameterIsNotNull(realCall4, NotificationCompat.CATEGORY_CALL);
                                        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                        realConnection6 = realConnection4;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            this.i.f3617x = null;
                            throw th;
                        }
                        list = null;
                        realConnection4 = new RealConnection4(this.g, routeB);
                        this.i.f3617x = realConnection4;
                    }
                }
            } else {
                this.c = 0;
                this.d = 0;
                this.e = 0;
                if (this.g.a(this.h, this.i, null, false)) {
                    realConnection6 = this.i.p;
                    if (realConnection6 == null) {
                        Intrinsics3.throwNpe();
                    }
                    this.j.a(this.i, realConnection6);
                } else {
                    routeB = this.f;
                    if (routeB != null) {
                        this.f = null;
                    } else {
                        aVar = this.a;
                        if (aVar == null) {
                        }
                        routeSelector = this.f3615b;
                        if (routeSelector == null) {
                            Address address3 = this.h;
                            RealCall realCall5 = this.i;
                            routeSelector = new RouteSelector(address3, realCall5.f3618y.O, realCall5, this.j);
                            this.f3615b = routeSelector;
                        }
                        if (routeSelector.a()) {
                            throw new NoSuchElementException();
                        }
                        arrayList = new ArrayList();
                        while (routeSelector.b()) {
                            if (routeSelector.b()) {
                                StringBuilder sbU3 = outline.U("No route to ");
                                sbU3.append(routeSelector.e.a.g);
                                sbU3.append("; exhausted proxy configurations: ");
                                sbU3.append(routeSelector.a);
                                throw new SocketException(sbU3.toString());
                            }
                            List<? extends Proxy> list3 = routeSelector.a;
                            int i6 = routeSelector.f3622b;
                            routeSelector.f3622b = i6 + 1;
                            proxy = list3.get(i6);
                            ArrayList arrayList3 = new ArrayList();
                            routeSelector.c = arrayList3;
                            if (proxy.type() != Proxy.Type.DIRECT) {
                                HttpUrl httpUrl2 = routeSelector.e.a;
                                hostName = httpUrl2.g;
                                port = httpUrl2.h;
                            } else {
                                HttpUrl httpUrl3 = routeSelector.e.a;
                                hostName = httpUrl3.g;
                                port = httpUrl3.h;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                        }
                        if (arrayList.isEmpty()) {
                            MutableCollections.addAll(arrayList, routeSelector.d);
                            routeSelector.d.clear();
                        }
                        aVar2 = new RouteSelector.a(arrayList);
                        this.a = aVar2;
                        list = aVar2.f3623b;
                        if (!this.i.v) {
                            throw new IOException("Canceled");
                        }
                        if (this.g.a(this.h, this.i, list, false)) {
                            realConnection6 = this.i.p;
                            if (realConnection6 == null) {
                                Intrinsics3.throwNpe();
                            }
                            this.j.a(this.i, realConnection6);
                        } else {
                            routeB = aVar2.b();
                            realConnection4 = new RealConnection4(this.g, routeB);
                            this.i.f3617x = realConnection4;
                            realConnection4.c(i, i2, i3, i4, z2, this.i, this.j);
                            this.i.f3617x = null;
                            routeDatabase = this.i.f3618y.O;
                            route = realConnection4.q;
                            synchronized (routeDatabase) {
                                Intrinsics3.checkParameterIsNotNull(route, "route");
                                routeDatabase.a.remove(route);
                                if (this.g.a(this.h, this.i, list, true)) {
                                    realConnection5 = this.i.p;
                                    if (realConnection5 == null) {
                                        Intrinsics3.throwNpe();
                                    }
                                    this.f = routeB;
                                    Util7.e(realConnection4.n());
                                    this.j.a(this.i, realConnection5);
                                    realConnection6 = realConnection5;
                                } else {
                                    synchronized (realConnection4) {
                                        RealConnectionPool realConnectionPool3 = this.g;
                                        Objects.requireNonNull(realConnectionPool3);
                                        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                        byte[] bArr3 = Util7.a;
                                        realConnectionPool3.d.add(realConnection4);
                                        TaskQueue2.d(realConnectionPool3.f3621b, realConnectionPool3.c, 0L, 2);
                                        this.i.f(realConnection4);
                                        EventListener eventListener6 = this.j;
                                        RealCall realCall6 = this.i;
                                        Objects.requireNonNull(eventListener6);
                                        Intrinsics3.checkParameterIsNotNull(realCall6, NotificationCompat.CATEGORY_CALL);
                                        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                        realConnection6 = realConnection4;
                                    }
                                }
                            }
                        }
                    }
                    list = null;
                    realConnection4 = new RealConnection4(this.g, routeB);
                    this.i.f3617x = realConnection4;
                    realConnection4.c(i, i2, i3, i4, z2, this.i, this.j);
                    this.i.f3617x = null;
                    routeDatabase = this.i.f3618y.O;
                    route = realConnection4.q;
                    synchronized (routeDatabase) {
                        Intrinsics3.checkParameterIsNotNull(route, "route");
                        routeDatabase.a.remove(route);
                        if (this.g.a(this.h, this.i, list, true)) {
                            realConnection5 = this.i.p;
                            if (realConnection5 == null) {
                                Intrinsics3.throwNpe();
                            }
                            this.f = routeB;
                            Util7.e(realConnection4.n());
                            this.j.a(this.i, realConnection5);
                            realConnection6 = realConnection5;
                        } else {
                            synchronized (realConnection4) {
                                RealConnectionPool realConnectionPool4 = this.g;
                                Objects.requireNonNull(realConnectionPool4);
                                Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                byte[] bArr4 = Util7.a;
                                realConnectionPool4.d.add(realConnection4);
                                TaskQueue2.d(realConnectionPool4.f3621b, realConnectionPool4.c, 0L, 2);
                                this.i.f(realConnection4);
                                EventListener eventListener7 = this.j;
                                RealCall realCall7 = this.i;
                                Objects.requireNonNull(eventListener7);
                                Intrinsics3.checkParameterIsNotNull(realCall7, NotificationCompat.CATEGORY_CALL);
                                Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                                realConnection6 = realConnection4;
                            }
                        }
                    }
                }
            }
            if (realConnection6.i(z3)) {
                return realConnection6;
            }
            realConnection6.l();
            if (this.f == null) {
                RouteSelector.a aVar4 = this.a;
                if (aVar4 != null ? aVar4.a() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector2 = this.f3615b;
                    if (!(routeSelector2 != null ? routeSelector2.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b(HttpUrl httpUrl) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        HttpUrl httpUrl2 = this.h.a;
        return httpUrl.h == httpUrl2.h && Intrinsics3.areEqual(httpUrl.g, httpUrl2.g);
    }

    public final void c(IOException iOException) {
        Intrinsics3.checkParameterIsNotNull(iOException, "e");
        this.f = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode2.REFUSED_STREAM) {
            this.c++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.d++;
        } else {
            this.e++;
        }
    }
}
