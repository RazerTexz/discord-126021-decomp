package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.C12261a;
import p600f0.C12266c0;
import p600f0.C12379w;
import p600f0.InterfaceC12269e;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.C12279c;
import p600f0.p601e0.p605g.C12293m;
import p600f0.p601e0.p608j.EnumC12307a;

/* JADX INFO: renamed from: f0.e0.g.d */
/* JADX INFO: compiled from: ExchangeFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12284d {

    /* JADX INFO: renamed from: a */
    public C12293m.a f25454a;

    /* JADX INFO: renamed from: b */
    public C12293m f25455b;

    /* JADX INFO: renamed from: c */
    public int f25456c;

    /* JADX INFO: renamed from: d */
    public int f25457d;

    /* JADX INFO: renamed from: e */
    public int f25458e;

    /* JADX INFO: renamed from: f */
    public C12266c0 f25459f;

    /* JADX INFO: renamed from: g */
    public final C12291k f25460g;

    /* JADX INFO: renamed from: h */
    public final C12261a f25461h;

    /* JADX INFO: renamed from: i */
    public final C12285e f25462i;

    /* JADX INFO: renamed from: j */
    public final AbstractC12376t f25463j;

    public C12284d(C12291k c12291k, C12261a c12261a, C12285e c12285e, AbstractC12376t abstractC12376t) {
        C12238m.checkParameterIsNotNull(c12291k, "connectionPool");
        C12238m.checkParameterIsNotNull(c12261a, "address");
        C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(abstractC12376t, "eventListener");
        this.f25460g = c12291k;
        this.f25461h = c12261a;
        this.f25462i = c12285e;
        this.f25463j = abstractC12376t;
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
    /* JADX INFO: renamed from: a */
    public final C12290j m10177a(int i, int i2, int i3, int i4, boolean z2, boolean z3) throws IOException {
        C12266c0 c12266c0M10212b;
        C12293m.a aVar;
        C12293m c12293m;
        ArrayList arrayList;
        C12293m.a aVar2;
        List<C12266c0> list;
        Proxy proxy;
        String hostName;
        int port;
        boolean zContains;
        C12290j c12290j;
        C12292l c12292l;
        C12266c0 c12266c0;
        C12290j c12290j2;
        Socket socketM10188m;
        while (!this.f25462i.f25477v) {
            C12290j c12290j3 = this.f25462i.f25471p;
            if (c12290j3 != null) {
                synchronized (c12290j3) {
                    socketM10188m = (c12290j3.f25498i || !m10178b(c12290j3.f25506q.f25370a.f25353a)) ? this.f25462i.m10188m() : null;
                }
                if (this.f25462i.f25471p != null) {
                    if (!(socketM10188m == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    if (socketM10188m != null) {
                        C12272c.m10124e(socketM10188m);
                    }
                    AbstractC12376t abstractC12376t = this.f25463j;
                    C12285e c12285e = this.f25462i;
                    Objects.requireNonNull(abstractC12376t);
                    C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
                    C12238m.checkParameterIsNotNull(c12290j3, "connection");
                    this.f25456c = 0;
                    this.f25457d = 0;
                    this.f25458e = 0;
                    if (this.f25460g.m10207a(this.f25461h, this.f25462i, null, false)) {
                        c12290j3 = this.f25462i.f25471p;
                        if (c12290j3 == null) {
                            C12238m.throwNpe();
                        }
                        this.f25463j.m10393a(this.f25462i, c12290j3);
                    } else {
                        c12266c0M10212b = this.f25459f;
                        try {
                            if (c12266c0M10212b != null) {
                                this.f25459f = null;
                            } else {
                                aVar = this.f25454a;
                                if (aVar == null && aVar.m10211a()) {
                                    C12293m.a aVar3 = this.f25454a;
                                    if (aVar3 == null) {
                                        C12238m.throwNpe();
                                    }
                                    c12266c0M10212b = aVar3.m10212b();
                                } else {
                                    c12293m = this.f25455b;
                                    if (c12293m == null) {
                                        C12261a c12261a = this.f25461h;
                                        C12285e c12285e2 = this.f25462i;
                                        c12293m = new C12293m(c12261a, c12285e2.f25480y.f26011O, c12285e2, this.f25463j);
                                        this.f25455b = c12293m;
                                    }
                                    if (c12293m.m10209a()) {
                                        throw new NoSuchElementException();
                                    }
                                    arrayList = new ArrayList();
                                    while (c12293m.m10210b()) {
                                        if (c12293m.m10210b()) {
                                            StringBuilder sbM833U = C1643a.m833U("No route to ");
                                            sbM833U.append(c12293m.f25518e.f25353a.f25979g);
                                            sbM833U.append("; exhausted proxy configurations: ");
                                            sbM833U.append(c12293m.f25514a);
                                            throw new SocketException(sbM833U.toString());
                                        }
                                        List<? extends Proxy> list2 = c12293m.f25514a;
                                        int i5 = c12293m.f25515b;
                                        c12293m.f25515b = i5 + 1;
                                        proxy = list2.get(i5);
                                        ArrayList arrayList2 = new ArrayList();
                                        c12293m.f25516c = arrayList2;
                                        if (proxy.type() != Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            C12379w c12379w = c12293m.f25518e.f25353a;
                                            hostName = c12379w.f25979g;
                                            port = c12379w.f25980h;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                StringBuilder sbM833U2 = C1643a.m833U("Proxy.address() is not an InetSocketAddress: ");
                                                sbM833U2.append(socketAddressAddress.getClass());
                                                throw new IllegalArgumentException(sbM833U2.toString().toString());
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            C12238m.checkParameterIsNotNull(inetSocketAddress, "$this$socketHost");
                                            InetAddress address = inetSocketAddress.getAddress();
                                            if (address != null) {
                                                hostName = address.getHostAddress();
                                                C12238m.checkExpressionValueIsNotNull(hostName, "address.hostAddress");
                                            } else {
                                                hostName = inetSocketAddress.getHostName();
                                                C12238m.checkExpressionValueIsNotNull(hostName, "hostName");
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 <= port || 65535 < port) {
                                            throw new SocketException("No route to " + hostName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
                                        } else {
                                            AbstractC12376t abstractC12376t2 = c12293m.f25521h;
                                            InterfaceC12269e interfaceC12269e = c12293m.f25520g;
                                            Objects.requireNonNull(abstractC12376t2);
                                            C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
                                            C12238m.checkParameterIsNotNull(hostName, "domainName");
                                            List<InetAddress> listMo10392a = c12293m.f25518e.f25356d.mo10392a(hostName);
                                            if (listMo10392a.isEmpty()) {
                                                throw new UnknownHostException(c12293m.f25518e.f25356d + " returned no addresses for " + hostName);
                                            }
                                            AbstractC12376t abstractC12376t3 = c12293m.f25521h;
                                            InterfaceC12269e interfaceC12269e2 = c12293m.f25520g;
                                            Objects.requireNonNull(abstractC12376t3);
                                            C12238m.checkParameterIsNotNull(interfaceC12269e2, NotificationCompat.CATEGORY_CALL);
                                            C12238m.checkParameterIsNotNull(hostName, "domainName");
                                            C12238m.checkParameterIsNotNull(listMo10392a, "inetAddressList");
                                            Iterator<InetAddress> it = listMo10392a.iterator();
                                            while (it.hasNext()) {
                                                arrayList2.add(new InetSocketAddress(it.next(), port));
                                            }
                                        }
                                        Iterator<? extends InetSocketAddress> it2 = c12293m.f25516c.iterator();
                                        while (it2.hasNext()) {
                                            C12266c0 c12266c1 = new C12266c0(c12293m.f25518e, proxy, it2.next());
                                            C12292l c12292l2 = c12293m.f25519f;
                                            synchronized (c12292l2) {
                                                C12238m.checkParameterIsNotNull(c12266c1, "route");
                                                zContains = c12292l2.f25513a.contains(c12266c1);
                                            }
                                            if (zContains) {
                                                c12293m.f25517d.add(c12266c1);
                                            } else {
                                                arrayList.add(c12266c1);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        C12160r.addAll(arrayList, c12293m.f25517d);
                                        c12293m.f25517d.clear();
                                    }
                                    aVar2 = new C12293m.a(arrayList);
                                    this.f25454a = aVar2;
                                    list = aVar2.f25523b;
                                    if (!this.f25462i.f25477v) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, false)) {
                                        c12290j3 = this.f25462i.f25471p;
                                        if (c12290j3 == null) {
                                            C12238m.throwNpe();
                                        }
                                        this.f25463j.m10393a(this.f25462i, c12290j3);
                                    } else {
                                        c12266c0M10212b = aVar2.m10212b();
                                        c12290j = new C12290j(this.f25460g, c12266c0M10212b);
                                        this.f25462i.f25479x = c12290j;
                                        c12290j.m10194c(i, i2, i3, i4, z2, this.f25462i, this.f25463j);
                                        this.f25462i.f25479x = null;
                                        c12292l = this.f25462i.f25480y.f26011O;
                                        c12266c0 = c12290j.f25506q;
                                        synchronized (c12292l) {
                                            C12238m.checkParameterIsNotNull(c12266c0, "route");
                                            c12292l.f25513a.remove(c12266c0);
                                        }
                                        if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, true)) {
                                            c12290j2 = this.f25462i.f25471p;
                                            if (c12290j2 == null) {
                                                C12238m.throwNpe();
                                            }
                                            this.f25459f = c12266c0M10212b;
                                            C12272c.m10124e(c12290j.m10205n());
                                            this.f25463j.m10393a(this.f25462i, c12290j2);
                                            c12290j3 = c12290j2;
                                        } else {
                                            synchronized (c12290j) {
                                                C12291k c12291k = this.f25460g;
                                                Objects.requireNonNull(c12291k);
                                                C12238m.checkParameterIsNotNull(c12290j, "connection");
                                                byte[] bArr = C12272c.f25397a;
                                                c12291k.f25510d.add(c12290j);
                                                C12279c.m10151d(c12291k.f25508b, c12291k.f25509c, 0L, 2);
                                                this.f25462i.m10181f(c12290j);
                                            }
                                            AbstractC12376t abstractC12376t4 = this.f25463j;
                                            C12285e c12285e3 = this.f25462i;
                                            Objects.requireNonNull(abstractC12376t4);
                                            C12238m.checkParameterIsNotNull(c12285e3, NotificationCompat.CATEGORY_CALL);
                                            C12238m.checkParameterIsNotNull(c12290j, "connection");
                                            c12290j3 = c12290j;
                                        }
                                    }
                                }
                            }
                            c12290j.m10194c(i, i2, i3, i4, z2, this.f25462i, this.f25463j);
                            this.f25462i.f25479x = null;
                            c12292l = this.f25462i.f25480y.f26011O;
                            c12266c0 = c12290j.f25506q;
                            synchronized (c12292l) {
                                C12238m.checkParameterIsNotNull(c12266c0, "route");
                                c12292l.f25513a.remove(c12266c0);
                                if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, true)) {
                                    c12290j2 = this.f25462i.f25471p;
                                    if (c12290j2 == null) {
                                        C12238m.throwNpe();
                                    }
                                    this.f25459f = c12266c0M10212b;
                                    C12272c.m10124e(c12290j.m10205n());
                                    this.f25463j.m10393a(this.f25462i, c12290j2);
                                    c12290j3 = c12290j2;
                                } else {
                                    synchronized (c12290j) {
                                        C12291k c12291k2 = this.f25460g;
                                        Objects.requireNonNull(c12291k2);
                                        C12238m.checkParameterIsNotNull(c12290j, "connection");
                                        byte[] bArr2 = C12272c.f25397a;
                                        c12291k2.f25510d.add(c12290j);
                                        C12279c.m10151d(c12291k2.f25508b, c12291k2.f25509c, 0L, 2);
                                        this.f25462i.m10181f(c12290j);
                                        AbstractC12376t abstractC12376t5 = this.f25463j;
                                        C12285e c12285e4 = this.f25462i;
                                        Objects.requireNonNull(abstractC12376t5);
                                        C12238m.checkParameterIsNotNull(c12285e4, NotificationCompat.CATEGORY_CALL);
                                        C12238m.checkParameterIsNotNull(c12290j, "connection");
                                        c12290j3 = c12290j;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            this.f25462i.f25479x = null;
                            throw th;
                        }
                        list = null;
                        c12290j = new C12290j(this.f25460g, c12266c0M10212b);
                        this.f25462i.f25479x = c12290j;
                    }
                }
            } else {
                this.f25456c = 0;
                this.f25457d = 0;
                this.f25458e = 0;
                if (this.f25460g.m10207a(this.f25461h, this.f25462i, null, false)) {
                    c12290j3 = this.f25462i.f25471p;
                    if (c12290j3 == null) {
                        C12238m.throwNpe();
                    }
                    this.f25463j.m10393a(this.f25462i, c12290j3);
                } else {
                    c12266c0M10212b = this.f25459f;
                    if (c12266c0M10212b != null) {
                        this.f25459f = null;
                    } else {
                        aVar = this.f25454a;
                        if (aVar == null) {
                        }
                        c12293m = this.f25455b;
                        if (c12293m == null) {
                            C12261a c12261a2 = this.f25461h;
                            C12285e c12285e5 = this.f25462i;
                            c12293m = new C12293m(c12261a2, c12285e5.f25480y.f26011O, c12285e5, this.f25463j);
                            this.f25455b = c12293m;
                        }
                        if (c12293m.m10209a()) {
                            throw new NoSuchElementException();
                        }
                        arrayList = new ArrayList();
                        while (c12293m.m10210b()) {
                            if (c12293m.m10210b()) {
                                StringBuilder sbM833U3 = C1643a.m833U("No route to ");
                                sbM833U3.append(c12293m.f25518e.f25353a.f25979g);
                                sbM833U3.append("; exhausted proxy configurations: ");
                                sbM833U3.append(c12293m.f25514a);
                                throw new SocketException(sbM833U3.toString());
                            }
                            List<? extends Proxy> list3 = c12293m.f25514a;
                            int i6 = c12293m.f25515b;
                            c12293m.f25515b = i6 + 1;
                            proxy = list3.get(i6);
                            ArrayList arrayList3 = new ArrayList();
                            c12293m.f25516c = arrayList3;
                            if (proxy.type() != Proxy.Type.DIRECT) {
                                C12379w c12379w2 = c12293m.f25518e.f25353a;
                                hostName = c12379w2.f25979g;
                                port = c12379w2.f25980h;
                            } else {
                                C12379w c12379w3 = c12293m.f25518e.f25353a;
                                hostName = c12379w3.f25979g;
                                port = c12379w3.f25980h;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                        }
                        if (arrayList.isEmpty()) {
                            C12160r.addAll(arrayList, c12293m.f25517d);
                            c12293m.f25517d.clear();
                        }
                        aVar2 = new C12293m.a(arrayList);
                        this.f25454a = aVar2;
                        list = aVar2.f25523b;
                        if (!this.f25462i.f25477v) {
                            throw new IOException("Canceled");
                        }
                        if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, false)) {
                            c12290j3 = this.f25462i.f25471p;
                            if (c12290j3 == null) {
                                C12238m.throwNpe();
                            }
                            this.f25463j.m10393a(this.f25462i, c12290j3);
                        } else {
                            c12266c0M10212b = aVar2.m10212b();
                            c12290j = new C12290j(this.f25460g, c12266c0M10212b);
                            this.f25462i.f25479x = c12290j;
                            c12290j.m10194c(i, i2, i3, i4, z2, this.f25462i, this.f25463j);
                            this.f25462i.f25479x = null;
                            c12292l = this.f25462i.f25480y.f26011O;
                            c12266c0 = c12290j.f25506q;
                            synchronized (c12292l) {
                                C12238m.checkParameterIsNotNull(c12266c0, "route");
                                c12292l.f25513a.remove(c12266c0);
                                if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, true)) {
                                    c12290j2 = this.f25462i.f25471p;
                                    if (c12290j2 == null) {
                                        C12238m.throwNpe();
                                    }
                                    this.f25459f = c12266c0M10212b;
                                    C12272c.m10124e(c12290j.m10205n());
                                    this.f25463j.m10393a(this.f25462i, c12290j2);
                                    c12290j3 = c12290j2;
                                } else {
                                    synchronized (c12290j) {
                                        C12291k c12291k3 = this.f25460g;
                                        Objects.requireNonNull(c12291k3);
                                        C12238m.checkParameterIsNotNull(c12290j, "connection");
                                        byte[] bArr3 = C12272c.f25397a;
                                        c12291k3.f25510d.add(c12290j);
                                        C12279c.m10151d(c12291k3.f25508b, c12291k3.f25509c, 0L, 2);
                                        this.f25462i.m10181f(c12290j);
                                        AbstractC12376t abstractC12376t6 = this.f25463j;
                                        C12285e c12285e6 = this.f25462i;
                                        Objects.requireNonNull(abstractC12376t6);
                                        C12238m.checkParameterIsNotNull(c12285e6, NotificationCompat.CATEGORY_CALL);
                                        C12238m.checkParameterIsNotNull(c12290j, "connection");
                                        c12290j3 = c12290j;
                                    }
                                }
                            }
                        }
                    }
                    list = null;
                    c12290j = new C12290j(this.f25460g, c12266c0M10212b);
                    this.f25462i.f25479x = c12290j;
                    c12290j.m10194c(i, i2, i3, i4, z2, this.f25462i, this.f25463j);
                    this.f25462i.f25479x = null;
                    c12292l = this.f25462i.f25480y.f26011O;
                    c12266c0 = c12290j.f25506q;
                    synchronized (c12292l) {
                        C12238m.checkParameterIsNotNull(c12266c0, "route");
                        c12292l.f25513a.remove(c12266c0);
                        if (this.f25460g.m10207a(this.f25461h, this.f25462i, list, true)) {
                            c12290j2 = this.f25462i.f25471p;
                            if (c12290j2 == null) {
                                C12238m.throwNpe();
                            }
                            this.f25459f = c12266c0M10212b;
                            C12272c.m10124e(c12290j.m10205n());
                            this.f25463j.m10393a(this.f25462i, c12290j2);
                            c12290j3 = c12290j2;
                        } else {
                            synchronized (c12290j) {
                                C12291k c12291k4 = this.f25460g;
                                Objects.requireNonNull(c12291k4);
                                C12238m.checkParameterIsNotNull(c12290j, "connection");
                                byte[] bArr4 = C12272c.f25397a;
                                c12291k4.f25510d.add(c12290j);
                                C12279c.m10151d(c12291k4.f25508b, c12291k4.f25509c, 0L, 2);
                                this.f25462i.m10181f(c12290j);
                                AbstractC12376t abstractC12376t7 = this.f25463j;
                                C12285e c12285e7 = this.f25462i;
                                Objects.requireNonNull(abstractC12376t7);
                                C12238m.checkParameterIsNotNull(c12285e7, NotificationCompat.CATEGORY_CALL);
                                C12238m.checkParameterIsNotNull(c12290j, "connection");
                                c12290j3 = c12290j;
                            }
                        }
                    }
                }
            }
            if (c12290j3.m10200i(z3)) {
                return c12290j3;
            }
            c12290j3.m10203l();
            if (this.f25459f == null) {
                C12293m.a aVar4 = this.f25454a;
                if (aVar4 != null ? aVar4.m10211a() : true) {
                    continue;
                } else {
                    C12293m c12293m2 = this.f25455b;
                    if (!(c12293m2 != null ? c12293m2.m10209a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10178b(C12379w c12379w) {
        C12238m.checkParameterIsNotNull(c12379w, "url");
        C12379w c12379w2 = this.f25461h.f25353a;
        return c12379w.f25980h == c12379w2.f25980h && C12238m.areEqual(c12379w.f25979g, c12379w2.f25979g);
    }

    /* JADX INFO: renamed from: c */
    public final void m10179c(IOException iOException) {
        C12238m.checkParameterIsNotNull(iOException, "e");
        this.f25459f = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == EnumC12307a.REFUSED_STREAM) {
            this.f25456c++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.f25457d++;
        } else {
            this.f25458e++;
        }
    }
}
