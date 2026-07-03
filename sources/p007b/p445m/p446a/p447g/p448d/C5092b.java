package p007b.p445m.p446a.p447g.p448d;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.m.a.g.d.b */
/* JADX INFO: compiled from: DatagramFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5092b implements InterfaceC5091a {
    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5091a
    /* JADX INFO: renamed from: a */
    public DatagramPacket mo7140a(byte[] bArr) {
        C12238m.checkParameterIsNotNull(bArr, "buffer");
        return new DatagramPacket(bArr, bArr.length);
    }

    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5091a
    /* JADX INFO: renamed from: b */
    public DatagramPacket mo7141b(byte[] bArr, InetAddress inetAddress, int i) {
        C12238m.checkParameterIsNotNull(bArr, "buffer");
        C12238m.checkParameterIsNotNull(inetAddress, "address");
        return new DatagramPacket(bArr, bArr.length, inetAddress, i);
    }

    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5091a
    /* JADX INFO: renamed from: c */
    public DatagramSocket mo7142c() throws SocketException {
        return new DatagramSocket();
    }
}
