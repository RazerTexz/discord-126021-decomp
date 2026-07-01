package b.g.a.c.g0.u;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: InetSocketAddressSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends p0<InetSocketAddress> {
    public q() {
        super(InetSocketAddress.class);
    }

    @Override // b.g.a.c.n
    public /* bridge */ /* synthetic */ void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        p((InetSocketAddress) obj, dVar);
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        b.g.a.b.s.b bVarD = gVar.d(inetSocketAddress, b.g.a.b.h.VALUE_STRING);
        bVarD.f675b = InetSocketAddress.class;
        b.g.a.b.s.b bVarE = gVar.e(dVar, bVarD);
        p(inetSocketAddress, dVar);
        gVar.f(dVar, bVarE);
    }

    public void p(InetSocketAddress inetSocketAddress, b.g.a.b.d dVar) throws IOException {
        String strSubstring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int iIndexOf = hostName.indexOf(47);
        if (iIndexOf >= 0) {
            if (iIndexOf == 0) {
                if (address instanceof Inet6Address) {
                    StringBuilder sbU = b.d.b.a.a.U("[");
                    sbU.append(hostName.substring(1));
                    sbU.append("]");
                    strSubstring = sbU.toString();
                } else {
                    strSubstring = hostName.substring(1);
                }
                hostName = strSubstring;
            } else {
                hostName = hostName.substring(0, iIndexOf);
            }
        }
        StringBuilder sbX = b.d.b.a.a.X(hostName, ":");
        sbX.append(inetSocketAddress.getPort());
        dVar.j0(sbX.toString());
    }
}
