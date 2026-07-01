package f0.e0.g;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.r;
import f0.c0;
import f0.t;
import f0.w;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy$Type;
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

/* JADX INFO: compiled from: ExchangeFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public m$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f3615b;
    public int c;
    public int d;
    public int e;
    public c0 f;
    public final k g;
    public final f0.a h;
    public final e i;
    public final t j;

    public d(k kVar, f0.a aVar, e eVar, t tVar) {
        d0.z.d.m.checkParameterIsNotNull(kVar, "connectionPool");
        d0.z.d.m.checkParameterIsNotNull(aVar, "address");
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
        this.g = kVar;
        this.h = aVar;
        this.i = eVar;
        this.j = tVar;
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
    public final j a(int i, int i2, int i3, int i4, boolean z2, boolean z3) throws IOException {
        c0 c0VarB;
        m$a m_a;
        m mVar;
        ArrayList arrayList;
        m$a m_a2;
        List<c0> list;
        Proxy proxy;
        String hostName;
        int port;
        boolean zContains;
        j jVar;
        l lVar;
        c0 c0Var;
        j jVar2;
        Socket socketM;
        while (!this.i.v) {
            j jVar3 = this.i.p;
            if (jVar3 != null) {
                synchronized (jVar3) {
                    socketM = (jVar3.i || !b(jVar3.q.a.a)) ? this.i.m() : null;
                }
                if (this.i.p != null) {
                    if (!(socketM == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    if (socketM != null) {
                        f0.e0.c.e(socketM);
                    }
                    t tVar = this.j;
                    e eVar = this.i;
                    Objects.requireNonNull(tVar);
                    d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                    d0.z.d.m.checkParameterIsNotNull(jVar3, "connection");
                    this.c = 0;
                    this.d = 0;
                    this.e = 0;
                    if (this.g.a(this.h, this.i, null, false)) {
                        jVar3 = this.i.p;
                        if (jVar3 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        this.j.a(this.i, jVar3);
                    } else {
                        c0VarB = this.f;
                        try {
                            if (c0VarB != null) {
                                this.f = null;
                            } else {
                                m_a = this.a;
                                if (m_a == null && m_a.a()) {
                                    m$a m_a3 = this.a;
                                    if (m_a3 == null) {
                                        d0.z.d.m.throwNpe();
                                    }
                                    c0VarB = m_a3.b();
                                } else {
                                    mVar = this.f3615b;
                                    if (mVar == null) {
                                        f0.a aVar = this.h;
                                        e eVar2 = this.i;
                                        mVar = new m(aVar, eVar2.f3618y.O, eVar2, this.j);
                                        this.f3615b = mVar;
                                    }
                                    if (mVar.a()) {
                                        throw new NoSuchElementException();
                                    }
                                    arrayList = new ArrayList();
                                    while (mVar.b()) {
                                        if (mVar.b()) {
                                            StringBuilder sbU = b.d.b.a.a.U("No route to ");
                                            sbU.append(mVar.e.a.g);
                                            sbU.append("; exhausted proxy configurations: ");
                                            sbU.append(mVar.a);
                                            throw new SocketException(sbU.toString());
                                        }
                                        List<? extends Proxy> list2 = mVar.a;
                                        int i5 = mVar.f3622b;
                                        mVar.f3622b = i5 + 1;
                                        proxy = list2.get(i5);
                                        ArrayList arrayList2 = new ArrayList();
                                        mVar.c = arrayList2;
                                        if (proxy.type() != Proxy$Type.DIRECT || proxy.type() == Proxy$Type.SOCKS) {
                                            w wVar = mVar.e.a;
                                            hostName = wVar.g;
                                            port = wVar.h;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                StringBuilder sbU2 = b.d.b.a.a.U("Proxy.address() is not an InetSocketAddress: ");
                                                sbU2.append(socketAddressAddress.getClass());
                                                throw new IllegalArgumentException(sbU2.toString().toString());
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "$this$socketHost");
                                            InetAddress address = inetSocketAddress.getAddress();
                                            if (address != null) {
                                                hostName = address.getHostAddress();
                                                d0.z.d.m.checkExpressionValueIsNotNull(hostName, "address.hostAddress");
                                            } else {
                                                hostName = inetSocketAddress.getHostName();
                                                d0.z.d.m.checkExpressionValueIsNotNull(hostName, "hostName");
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 <= port || 65535 < port) {
                                            throw new SocketException("No route to " + hostName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy$Type.SOCKS) {
                                            arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
                                        } else {
                                            t tVar2 = mVar.h;
                                            f0.e eVar3 = mVar.g;
                                            Objects.requireNonNull(tVar2);
                                            d0.z.d.m.checkParameterIsNotNull(eVar3, NotificationCompat.CATEGORY_CALL);
                                            d0.z.d.m.checkParameterIsNotNull(hostName, "domainName");
                                            List<InetAddress> listA = mVar.e.d.a(hostName);
                                            if (listA.isEmpty()) {
                                                throw new UnknownHostException(mVar.e.d + " returned no addresses for " + hostName);
                                            }
                                            t tVar3 = mVar.h;
                                            f0.e eVar4 = mVar.g;
                                            Objects.requireNonNull(tVar3);
                                            d0.z.d.m.checkParameterIsNotNull(eVar4, NotificationCompat.CATEGORY_CALL);
                                            d0.z.d.m.checkParameterIsNotNull(hostName, "domainName");
                                            d0.z.d.m.checkParameterIsNotNull(listA, "inetAddressList");
                                            Iterator<InetAddress> it = listA.iterator();
                                            while (it.hasNext()) {
                                                arrayList2.add(new InetSocketAddress(it.next(), port));
                                            }
                                        }
                                        Iterator<? extends InetSocketAddress> it2 = mVar.c.iterator();
                                        while (it2.hasNext()) {
                                            c0 c0Var2 = new c0(mVar.e, proxy, it2.next());
                                            l lVar2 = mVar.f;
                                            synchronized (lVar2) {
                                                d0.z.d.m.checkParameterIsNotNull(c0Var2, "route");
                                                zContains = lVar2.a.contains(c0Var2);
                                            }
                                            if (zContains) {
                                                mVar.d.add(c0Var2);
                                            } else {
                                                arrayList.add(c0Var2);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        r.addAll(arrayList, mVar.d);
                                        mVar.d.clear();
                                    }
                                    m_a2 = new m$a(arrayList);
                                    this.a = m_a2;
                                    list = m_a2.f3623b;
                                    if (!this.i.v) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.g.a(this.h, this.i, list, false)) {
                                        jVar3 = this.i.p;
                                        if (jVar3 == null) {
                                            d0.z.d.m.throwNpe();
                                        }
                                        this.j.a(this.i, jVar3);
                                    } else {
                                        c0VarB = m_a2.b();
                                        jVar = new j(this.g, c0VarB);
                                        this.i.f3617x = jVar;
                                        jVar.c(i, i2, i3, i4, z2, this.i, this.j);
                                        this.i.f3617x = null;
                                        lVar = this.i.f3618y.O;
                                        c0Var = jVar.q;
                                        synchronized (lVar) {
                                            d0.z.d.m.checkParameterIsNotNull(c0Var, "route");
                                            lVar.a.remove(c0Var);
                                        }
                                        if (this.g.a(this.h, this.i, list, true)) {
                                            jVar2 = this.i.p;
                                            if (jVar2 == null) {
                                                d0.z.d.m.throwNpe();
                                            }
                                            this.f = c0VarB;
                                            f0.e0.c.e(jVar.n());
                                            this.j.a(this.i, jVar2);
                                            jVar3 = jVar2;
                                        } else {
                                            synchronized (jVar) {
                                                k kVar = this.g;
                                                Objects.requireNonNull(kVar);
                                                d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                                byte[] bArr = f0.e0.c.a;
                                                kVar.d.add(jVar);
                                                f0.e0.f.c.d(kVar.f3621b, kVar.c, 0L, 2);
                                                this.i.f(jVar);
                                            }
                                            t tVar4 = this.j;
                                            e eVar5 = this.i;
                                            Objects.requireNonNull(tVar4);
                                            d0.z.d.m.checkParameterIsNotNull(eVar5, NotificationCompat.CATEGORY_CALL);
                                            d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                            jVar3 = jVar;
                                        }
                                    }
                                }
                            }
                            jVar.c(i, i2, i3, i4, z2, this.i, this.j);
                            this.i.f3617x = null;
                            lVar = this.i.f3618y.O;
                            c0Var = jVar.q;
                            synchronized (lVar) {
                                d0.z.d.m.checkParameterIsNotNull(c0Var, "route");
                                lVar.a.remove(c0Var);
                                if (this.g.a(this.h, this.i, list, true)) {
                                    jVar2 = this.i.p;
                                    if (jVar2 == null) {
                                        d0.z.d.m.throwNpe();
                                    }
                                    this.f = c0VarB;
                                    f0.e0.c.e(jVar.n());
                                    this.j.a(this.i, jVar2);
                                    jVar3 = jVar2;
                                } else {
                                    synchronized (jVar) {
                                        k kVar2 = this.g;
                                        Objects.requireNonNull(kVar2);
                                        d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                        byte[] bArr2 = f0.e0.c.a;
                                        kVar2.d.add(jVar);
                                        f0.e0.f.c.d(kVar2.f3621b, kVar2.c, 0L, 2);
                                        this.i.f(jVar);
                                        t tVar5 = this.j;
                                        e eVar6 = this.i;
                                        Objects.requireNonNull(tVar5);
                                        d0.z.d.m.checkParameterIsNotNull(eVar6, NotificationCompat.CATEGORY_CALL);
                                        d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                        jVar3 = jVar;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            this.i.f3617x = null;
                            throw th;
                        }
                        list = null;
                        jVar = new j(this.g, c0VarB);
                        this.i.f3617x = jVar;
                    }
                }
            } else {
                this.c = 0;
                this.d = 0;
                this.e = 0;
                if (this.g.a(this.h, this.i, null, false)) {
                    jVar3 = this.i.p;
                    if (jVar3 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    this.j.a(this.i, jVar3);
                } else {
                    c0VarB = this.f;
                    if (c0VarB != null) {
                        this.f = null;
                    } else {
                        m_a = this.a;
                        if (m_a == null) {
                        }
                        mVar = this.f3615b;
                        if (mVar == null) {
                            f0.a aVar2 = this.h;
                            e eVar7 = this.i;
                            mVar = new m(aVar2, eVar7.f3618y.O, eVar7, this.j);
                            this.f3615b = mVar;
                        }
                        if (mVar.a()) {
                            throw new NoSuchElementException();
                        }
                        arrayList = new ArrayList();
                        while (mVar.b()) {
                            if (mVar.b()) {
                                StringBuilder sbU3 = b.d.b.a.a.U("No route to ");
                                sbU3.append(mVar.e.a.g);
                                sbU3.append("; exhausted proxy configurations: ");
                                sbU3.append(mVar.a);
                                throw new SocketException(sbU3.toString());
                            }
                            List<? extends Proxy> list3 = mVar.a;
                            int i6 = mVar.f3622b;
                            mVar.f3622b = i6 + 1;
                            proxy = list3.get(i6);
                            ArrayList arrayList3 = new ArrayList();
                            mVar.c = arrayList3;
                            if (proxy.type() != Proxy$Type.DIRECT) {
                                w wVar2 = mVar.e.a;
                                hostName = wVar2.g;
                                port = wVar2.h;
                            } else {
                                w wVar3 = mVar.e.a;
                                hostName = wVar3.g;
                                port = wVar3.h;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                        }
                        if (arrayList.isEmpty()) {
                            r.addAll(arrayList, mVar.d);
                            mVar.d.clear();
                        }
                        m_a2 = new m$a(arrayList);
                        this.a = m_a2;
                        list = m_a2.f3623b;
                        if (!this.i.v) {
                            throw new IOException("Canceled");
                        }
                        if (this.g.a(this.h, this.i, list, false)) {
                            jVar3 = this.i.p;
                            if (jVar3 == null) {
                                d0.z.d.m.throwNpe();
                            }
                            this.j.a(this.i, jVar3);
                        } else {
                            c0VarB = m_a2.b();
                            jVar = new j(this.g, c0VarB);
                            this.i.f3617x = jVar;
                            jVar.c(i, i2, i3, i4, z2, this.i, this.j);
                            this.i.f3617x = null;
                            lVar = this.i.f3618y.O;
                            c0Var = jVar.q;
                            synchronized (lVar) {
                                d0.z.d.m.checkParameterIsNotNull(c0Var, "route");
                                lVar.a.remove(c0Var);
                                if (this.g.a(this.h, this.i, list, true)) {
                                    jVar2 = this.i.p;
                                    if (jVar2 == null) {
                                        d0.z.d.m.throwNpe();
                                    }
                                    this.f = c0VarB;
                                    f0.e0.c.e(jVar.n());
                                    this.j.a(this.i, jVar2);
                                    jVar3 = jVar2;
                                } else {
                                    synchronized (jVar) {
                                        k kVar3 = this.g;
                                        Objects.requireNonNull(kVar3);
                                        d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                        byte[] bArr3 = f0.e0.c.a;
                                        kVar3.d.add(jVar);
                                        f0.e0.f.c.d(kVar3.f3621b, kVar3.c, 0L, 2);
                                        this.i.f(jVar);
                                        t tVar6 = this.j;
                                        e eVar8 = this.i;
                                        Objects.requireNonNull(tVar6);
                                        d0.z.d.m.checkParameterIsNotNull(eVar8, NotificationCompat.CATEGORY_CALL);
                                        d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                        jVar3 = jVar;
                                    }
                                }
                            }
                        }
                    }
                    list = null;
                    jVar = new j(this.g, c0VarB);
                    this.i.f3617x = jVar;
                    jVar.c(i, i2, i3, i4, z2, this.i, this.j);
                    this.i.f3617x = null;
                    lVar = this.i.f3618y.O;
                    c0Var = jVar.q;
                    synchronized (lVar) {
                        d0.z.d.m.checkParameterIsNotNull(c0Var, "route");
                        lVar.a.remove(c0Var);
                        if (this.g.a(this.h, this.i, list, true)) {
                            jVar2 = this.i.p;
                            if (jVar2 == null) {
                                d0.z.d.m.throwNpe();
                            }
                            this.f = c0VarB;
                            f0.e0.c.e(jVar.n());
                            this.j.a(this.i, jVar2);
                            jVar3 = jVar2;
                        } else {
                            synchronized (jVar) {
                                k kVar4 = this.g;
                                Objects.requireNonNull(kVar4);
                                d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                byte[] bArr4 = f0.e0.c.a;
                                kVar4.d.add(jVar);
                                f0.e0.f.c.d(kVar4.f3621b, kVar4.c, 0L, 2);
                                this.i.f(jVar);
                                t tVar7 = this.j;
                                e eVar9 = this.i;
                                Objects.requireNonNull(tVar7);
                                d0.z.d.m.checkParameterIsNotNull(eVar9, NotificationCompat.CATEGORY_CALL);
                                d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
                                jVar3 = jVar;
                            }
                        }
                    }
                }
            }
            if (jVar3.i(z3)) {
                return jVar3;
            }
            jVar3.l();
            if (this.f == null) {
                m$a m_a4 = this.a;
                if (m_a4 != null ? m_a4.a() : true) {
                    continue;
                } else {
                    m mVar2 = this.f3615b;
                    if (!(mVar2 != null ? mVar2.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b(w wVar) {
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        w wVar2 = this.h.a;
        return wVar.h == wVar2.h && d0.z.d.m.areEqual(wVar.g, wVar2.g);
    }

    public final void c(IOException iOException) {
        d0.z.d.m.checkParameterIsNotNull(iOException, "e");
        this.f = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == f0.e0.j.a.REFUSED_STREAM) {
            this.c++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.d++;
        } else {
            this.e++;
        }
    }
}
