package b.m.a.g.d;

import d0.z.d.m;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* JADX INFO: compiled from: DatagramFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    @Override // b.m.a.g.d.a
    public DatagramPacket a(byte[] bArr) {
        m.checkParameterIsNotNull(bArr, "buffer");
        return new DatagramPacket(bArr, bArr.length);
    }

    @Override // b.m.a.g.d.a
    public DatagramPacket b(byte[] bArr, InetAddress inetAddress, int i) {
        m.checkParameterIsNotNull(bArr, "buffer");
        m.checkParameterIsNotNull(inetAddress, "address");
        return new DatagramPacket(bArr, bArr.length, inetAddress, i);
    }

    @Override // b.m.a.g.d.a
    public DatagramSocket c() throws SocketException {
        return new DatagramSocket();
    }
}
