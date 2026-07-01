package b.m.a.g.d;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* JADX INFO: renamed from: b.m.a.g.d.a, reason: use source file name */
/* JADX INFO: compiled from: DatagramFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DatagramFactory {
    DatagramPacket a(byte[] bArr);

    DatagramPacket b(byte[] bArr, InetAddress inetAddress, int i);

    DatagramSocket c() throws SocketException;
}
