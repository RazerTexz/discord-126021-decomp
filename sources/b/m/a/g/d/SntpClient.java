package b.m.a.g.d;

import b.d.b.a.outline;
import b.m.a.Clock5;
import com.discord.api.permission.Permission;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.m.a.g.d.e, reason: use source file name */
/* JADX INFO: compiled from: SntpClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class SntpClient {
    public final Clock5 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DnsResolver f1906b;
    public final DatagramFactory c;

    /* JADX INFO: renamed from: b.m.a.g.d.e$a */
    /* JADX INFO: compiled from: SntpClient.java */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: b.m.a.g.d.e$b */
    /* JADX INFO: compiled from: SntpClient.java */
    public static final class b {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1907b;
        public final long c;
        public final Clock5 d;

        public b(long j, long j2, long j3, Clock5 clock5) {
            this.a = j;
            this.f1907b = j2;
            this.c = j3;
            this.d = clock5;
        }

        public long a() {
            return this.a + this.c + (this.d.b() - this.f1907b);
        }
    }

    public SntpClient(Clock5 clock5, DnsResolver dnsResolver, DatagramFactory datagramFactory) {
        this.a = clock5;
        this.f1906b = dnsResolver;
        this.c = datagramFactory;
    }

    public static void a(byte b2, byte b3, int i, long j) throws a {
        if (b2 == 3) {
            throw new a("unsynchronized server");
        }
        if (b3 != 4 && b3 != 5) {
            throw new a(outline.q("untrusted mode: ", b3));
        }
        if (i == 0 || i > 15) {
            throw new a(outline.q("untrusted stratum: ", i));
        }
        if (j == 0) {
            throw new a("zero transmitTime");
        }
    }

    public static long b(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & Opcodes.LAND) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & Opcodes.LAND) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & Opcodes.LAND) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & Opcodes.LAND) + 128;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    public static long c(byte[] bArr, int i) {
        long jB = b(bArr, i);
        return ((b(bArr, i + 4) * 1000) / Permission.REQUEST_TO_SPEAK) + ((jB - 2208988800L) * 1000);
    }

    public b d(String str, Long l) throws IOException {
        DatagramSocket datagramSocketC = null;
        try {
            InetAddress inetAddressA = this.f1906b.a(str);
            datagramSocketC = this.c.c();
            datagramSocketC.setSoTimeout(l.intValue());
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacketB = this.c.b(bArr, inetAddressA, 123);
            bArr[0] = 27;
            long jA = this.a.a();
            long jB = this.a.b();
            long j = jA / 1000;
            Long.signum(j);
            long j2 = jA - (j * 1000);
            long j3 = j + 2208988800L;
            bArr[40] = (byte) (j3 >> 24);
            bArr[41] = (byte) (j3 >> 16);
            bArr[42] = (byte) (j3 >> 8);
            bArr[43] = (byte) (j3 >> 0);
            long j4 = (j2 * Permission.REQUEST_TO_SPEAK) / 1000;
            bArr[44] = (byte) (j4 >> 24);
            bArr[45] = (byte) (j4 >> 16);
            bArr[46] = (byte) (j4 >> 8);
            bArr[47] = (byte) (Math.random() * 255.0d);
            datagramSocketC.send(datagramPacketB);
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 48);
            datagramSocketC.receive(this.c.a(bArrCopyOf));
            long jB2 = this.a.b();
            long j5 = (jB2 - jB) + jA;
            byte b2 = (byte) ((bArrCopyOf[0] >> 6) & 3);
            byte b3 = (byte) (bArrCopyOf[0] & 7);
            int i = bArrCopyOf[1] & 255;
            long jC = c(bArrCopyOf, 24);
            long jC2 = c(bArrCopyOf, 32);
            long jC3 = c(bArrCopyOf, 40);
            a(b2, b3, i, jC3);
            b bVar = new b(j5, jB2, ((jC3 - j5) + (jC2 - jC)) / 2, this.a);
            datagramSocketC.close();
            return bVar;
        } catch (Throwable th) {
            if (datagramSocketC != null) {
                datagramSocketC.close();
            }
            throw th;
        }
    }
}
