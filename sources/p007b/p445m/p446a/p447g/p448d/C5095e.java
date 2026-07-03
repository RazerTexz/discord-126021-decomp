package p007b.p445m.p446a.p447g.p448d;

import com.discord.api.permission.Permission;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p445m.p446a.InterfaceC5083b;

/* JADX INFO: renamed from: b.m.a.g.d.e */
/* JADX INFO: compiled from: SntpClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5095e {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5083b f13649a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5093c f13650b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5091a f13651c;

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

        /* JADX INFO: renamed from: a */
        public final long f13652a;

        /* JADX INFO: renamed from: b */
        public final long f13653b;

        /* JADX INFO: renamed from: c */
        public final long f13654c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC5083b f13655d;

        public b(long j, long j2, long j3, InterfaceC5083b interfaceC5083b) {
            this.f13652a = j;
            this.f13653b = j2;
            this.f13654c = j3;
            this.f13655d = interfaceC5083b;
        }

        /* JADX INFO: renamed from: a */
        public long m7148a() {
            return this.f13652a + this.f13654c + (this.f13655d.mo7129b() - this.f13653b);
        }
    }

    public C5095e(InterfaceC5083b interfaceC5083b, InterfaceC5093c interfaceC5093c, InterfaceC5091a interfaceC5091a) {
        this.f13649a = interfaceC5083b;
        this.f13650b = interfaceC5093c;
        this.f13651c = interfaceC5091a;
    }

    /* JADX INFO: renamed from: a */
    public static void m7144a(byte b2, byte b3, int i, long j) throws a {
        if (b2 == 3) {
            throw new a("unsynchronized server");
        }
        if (b3 != 4 && b3 != 5) {
            throw new a(C1643a.m871q("untrusted mode: ", b3));
        }
        if (i == 0 || i > 15) {
            throw new a(C1643a.m871q("untrusted stratum: ", i));
        }
        if (j == 0) {
            throw new a("zero transmitTime");
        }
    }

    /* JADX INFO: renamed from: b */
    public static long m7145b(byte[] bArr, int i) {
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

    /* JADX INFO: renamed from: c */
    public static long m7146c(byte[] bArr, int i) {
        long jM7145b = m7145b(bArr, i);
        return ((m7145b(bArr, i + 4) * 1000) / Permission.REQUEST_TO_SPEAK) + ((jM7145b - 2208988800L) * 1000);
    }

    /* JADX INFO: renamed from: d */
    public b m7147d(String str, Long l) throws IOException {
        DatagramSocket datagramSocketMo7142c = null;
        try {
            InetAddress inetAddressMo7143a = this.f13650b.mo7143a(str);
            datagramSocketMo7142c = this.f13651c.mo7142c();
            datagramSocketMo7142c.setSoTimeout(l.intValue());
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacketMo7141b = this.f13651c.mo7141b(bArr, inetAddressMo7143a, 123);
            bArr[0] = 27;
            long jMo7128a = this.f13649a.mo7128a();
            long jMo7129b = this.f13649a.mo7129b();
            long j = jMo7128a / 1000;
            Long.signum(j);
            long j2 = jMo7128a - (j * 1000);
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
            datagramSocketMo7142c.send(datagramPacketMo7141b);
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 48);
            datagramSocketMo7142c.receive(this.f13651c.mo7140a(bArrCopyOf));
            long jMo7129b2 = this.f13649a.mo7129b();
            long j5 = (jMo7129b2 - jMo7129b) + jMo7128a;
            byte b2 = (byte) ((bArrCopyOf[0] >> 6) & 3);
            byte b3 = (byte) (bArrCopyOf[0] & 7);
            int i = bArrCopyOf[1] & 255;
            long jM7146c = m7146c(bArrCopyOf, 24);
            long jM7146c2 = m7146c(bArrCopyOf, 32);
            long jM7146c3 = m7146c(bArrCopyOf, 40);
            m7144a(b2, b3, i, jM7146c3);
            b bVar = new b(j5, jMo7129b2, ((jM7146c3 - j5) + (jM7146c2 - jM7146c)) / 2, this.f13649a);
            datagramSocketMo7142c.close();
            return bVar;
        } catch (Throwable th) {
            if (datagramSocketMo7142c != null) {
                datagramSocketMo7142c.close();
            }
            throw th;
        }
    }
}
