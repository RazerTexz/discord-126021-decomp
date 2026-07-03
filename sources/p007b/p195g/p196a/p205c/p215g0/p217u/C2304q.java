package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;

/* JADX INFO: renamed from: b.g.a.c.g0.u.q */
/* JADX INFO: compiled from: InetSocketAddressSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2304q extends AbstractC2303p0<InetSocketAddress> {
    public C2304q() {
        super(InetSocketAddress.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        m2071p((InetSocketAddress) obj, abstractC2108d);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2303p0, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        C2138b c2138bM1958d = abstractC2215g.m1958d(inetSocketAddress, EnumC2112h.VALUE_STRING);
        c2138bM1958d.f4585b = InetSocketAddress.class;
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, c2138bM1958d);
        m2071p(inetSocketAddress, abstractC2108d);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    /* JADX INFO: renamed from: p */
    public void m2071p(InetSocketAddress inetSocketAddress, AbstractC2108d abstractC2108d) throws IOException {
        String strSubstring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int iIndexOf = hostName.indexOf(47);
        if (iIndexOf >= 0) {
            if (iIndexOf == 0) {
                if (address instanceof Inet6Address) {
                    StringBuilder sbM833U = C1643a.m833U("[");
                    sbM833U.append(hostName.substring(1));
                    sbM833U.append("]");
                    strSubstring = sbM833U.toString();
                } else {
                    strSubstring = hostName.substring(1);
                }
                hostName = strSubstring;
            } else {
                hostName = hostName.substring(0, iIndexOf);
            }
        }
        StringBuilder sbM836X = C1643a.m836X(hostName, ":");
        sbM836X.append(inetSocketAddress.getPort());
        abstractC2108d.mo1658j0(sbM836X.toString());
    }
}
