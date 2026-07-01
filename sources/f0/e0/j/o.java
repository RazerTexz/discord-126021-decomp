package f0.e0.j;

import com.discord.api.permission.Permission;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.BufferedSink;

/* JADX INFO: compiled from: Http2Writer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements Closeable {
    public static final Logger j = Logger.getLogger(d.class.getName());
    public final g0.e k;
    public int l;
    public boolean m;
    public final c$b n;
    public final BufferedSink o;
    public final boolean p;

    public o(BufferedSink bufferedSink, boolean z2) {
        d0.z.d.m.checkParameterIsNotNull(bufferedSink, "sink");
        this.o = bufferedSink;
        this.p = z2;
        g0.e eVar = new g0.e();
        this.k = eVar;
        this.l = 16384;
        this.n = new c$b(0, false, eVar, 3);
    }

    public final synchronized void a(s sVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(sVar, "peerSettings");
        if (this.m) {
            throw new IOException("closed");
        }
        int i = this.l;
        int i2 = sVar.a;
        if ((i2 & 32) != 0) {
            i = sVar.f3647b[5];
        }
        this.l = i;
        int i3 = i2 & 2;
        if ((i3 != 0 ? sVar.f3647b[1] : -1) != -1) {
            c$b c_b = this.n;
            int i4 = i3 != 0 ? sVar.f3647b[1] : -1;
            c_b.h = i4;
            int iMin = Math.min(i4, 16384);
            int i5 = c_b.c;
            if (i5 != iMin) {
                if (iMin < i5) {
                    c_b.a = Math.min(c_b.a, iMin);
                }
                c_b.f3636b = true;
                c_b.c = iMin;
                int i6 = c_b.g;
                if (iMin < i6) {
                    if (iMin == 0) {
                        c_b.a();
                    } else {
                        c_b.b(i6 - iMin);
                    }
                }
            }
        }
        c(0, 0, 4, 1);
        this.o.flush();
    }

    public final synchronized void b(boolean z2, int i, g0.e eVar, int i2) throws IOException {
        if (this.m) {
            throw new IOException("closed");
        }
        c(i, i2, 0, z2 ? 1 : 0);
        if (i2 > 0) {
            BufferedSink bufferedSink = this.o;
            if (eVar == null) {
                d0.z.d.m.throwNpe();
            }
            bufferedSink.write(eVar, i2);
        }
    }

    public final void c(int i, int i2, int i3, int i4) throws IOException {
        Logger logger = j;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(d.e.b(false, i, i2, i3, i4));
        }
        if (!(i2 <= this.l)) {
            StringBuilder sbU = b.d.b.a.a.U("FRAME_SIZE_ERROR length > ");
            sbU.append(this.l);
            sbU.append(": ");
            sbU.append(i2);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        if (!((((int) Permission.USE_APPLICATION_COMMANDS) & i) == 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.q("reserved bit set: ", i).toString());
        }
        BufferedSink bufferedSink = this.o;
        byte[] bArr = f0.e0.c.a;
        d0.z.d.m.checkParameterIsNotNull(bufferedSink, "$this$writeMedium");
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
        this.o.writeByte(i3 & 255);
        this.o.writeByte(i4 & 255);
        this.o.writeInt(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.m = true;
        this.o.close();
    }

    public final synchronized void d(int i, a aVar, byte[] bArr) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        d0.z.d.m.checkParameterIsNotNull(bArr, "debugData");
        if (this.m) {
            throw new IOException("closed");
        }
        if (!(aVar.f() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        c(0, bArr.length + 8, 7, 0);
        this.o.writeInt(i);
        this.o.writeInt(aVar.f());
        if (!(bArr.length == 0)) {
            this.o.write(bArr);
        }
        this.o.flush();
    }

    public final synchronized void e(boolean z2, int i, List<b> list) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(list, "headerBlock");
        if (this.m) {
            throw new IOException("closed");
        }
        this.n.e(list);
        long j2 = this.k.k;
        long jMin = Math.min(this.l, j2);
        int i2 = j2 == jMin ? 4 : 0;
        if (z2) {
            i2 |= 1;
        }
        c(i, (int) jMin, 1, i2);
        this.o.write(this.k, jMin);
        if (j2 > jMin) {
            s(i, j2 - jMin);
        }
    }

    public final synchronized void f(boolean z2, int i, int i2) throws IOException {
        if (this.m) {
            throw new IOException("closed");
        }
        c(0, 8, 6, z2 ? 1 : 0);
        this.o.writeInt(i);
        this.o.writeInt(i2);
        this.o.flush();
    }

    public final synchronized void flush() throws IOException {
        if (this.m) {
            throw new IOException("closed");
        }
        this.o.flush();
    }

    public final synchronized void n(int i, a aVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        if (this.m) {
            throw new IOException("closed");
        }
        if (!(aVar.f() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        c(i, 4, 3, 0);
        this.o.writeInt(aVar.f());
        this.o.flush();
    }

    public final synchronized void q(int i, long j2) throws IOException {
        if (this.m) {
            throw new IOException("closed");
        }
        if (!(j2 != 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
        }
        c(i, 4, 8, 0);
        this.o.writeInt((int) j2);
        this.o.flush();
    }

    public final void s(int i, long j2) throws IOException {
        while (j2 > 0) {
            long jMin = Math.min(this.l, j2);
            j2 -= jMin;
            c(i, (int) jMin, 9, j2 == 0 ? 4 : 0);
            this.o.write(this.k, jMin);
        }
    }
}
