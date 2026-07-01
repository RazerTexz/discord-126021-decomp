package b.m.a.g.d;

import d0.z.d.Intrinsics3;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* JADX INFO: renamed from: b.m.a.g.d.b, reason: use source file name */
/* JADX INFO: compiled from: DatagramFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DatagramFactory2 implements DatagramFactory {
    @Override // b.m.a.g.d.DatagramFactory
    public DatagramPacket a(byte[] bArr) {
        Intrinsics3.checkParameterIsNotNull(bArr, "buffer");
        return new DatagramPacket(bArr, bArr.length);
    }

    @Override // b.m.a.g.d.DatagramFactory
    public DatagramPacket b(byte[] bArr, InetAddress inetAddress, int i) {
        Intrinsics3.checkParameterIsNotNull(bArr, "buffer");
        Intrinsics3.checkParameterIsNotNull(inetAddress, "address");
        return new DatagramPacket(bArr, bArr.length, inetAddress, i);
    }

    @Override // b.m.a.g.d.DatagramFactory
    public DatagramSocket c() throws SocketException {
        return new DatagramSocket();
    }
}
