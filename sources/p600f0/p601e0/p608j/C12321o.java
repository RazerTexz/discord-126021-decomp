package p600f0.p601e0.p608j;

import com.discord.api.permission.Permission;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.BufferedSink;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p608j.C12309c;
import p615g0.C12388e;

/* JADX INFO: renamed from: f0.e0.j.o */
/* JADX INFO: compiled from: Http2Writer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12321o implements Closeable {

    /* JADX INFO: renamed from: j */
    public static final Logger f25737j = Logger.getLogger(C12310d.class.getName());

    /* JADX INFO: renamed from: k */
    public final C12388e f25738k;

    /* JADX INFO: renamed from: l */
    public int f25739l;

    /* JADX INFO: renamed from: m */
    public boolean f25740m;

    /* JADX INFO: renamed from: n */
    public final C12309c.b f25741n;

    /* JADX INFO: renamed from: o */
    public final BufferedSink f25742o;

    /* JADX INFO: renamed from: p */
    public final boolean f25743p;

    public C12321o(BufferedSink bufferedSink, boolean z2) {
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        this.f25742o = bufferedSink;
        this.f25743p = z2;
        C12388e c12388e = new C12388e();
        this.f25738k = c12388e;
        this.f25739l = 16384;
        this.f25741n = new C12309c.b(0, false, c12388e, 3);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m10298a(C12325s c12325s) throws IOException {
        C12238m.checkParameterIsNotNull(c12325s, "peerSettings");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        int i = this.f25739l;
        int i2 = c12325s.f25752a;
        if ((i2 & 32) != 0) {
            i = c12325s.f25753b[5];
        }
        this.f25739l = i;
        int i3 = i2 & 2;
        if ((i3 != 0 ? c12325s.f25753b[1] : -1) != -1) {
            C12309c.b bVar = this.f25741n;
            int i4 = i3 != 0 ? c12325s.f25753b[1] : -1;
            bVar.f25607h = i4;
            int iMin = Math.min(i4, 16384);
            int i5 = bVar.f25602c;
            if (i5 != iMin) {
                if (iMin < i5) {
                    bVar.f25600a = Math.min(bVar.f25600a, iMin);
                }
                bVar.f25601b = true;
                bVar.f25602c = iMin;
                int i6 = bVar.f25606g;
                if (iMin < i6) {
                    if (iMin == 0) {
                        bVar.m10250a();
                    } else {
                        bVar.m10251b(i6 - iMin);
                    }
                }
            }
        }
        m10300c(0, 0, 4, 1);
        this.f25742o.flush();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m10299b(boolean z2, int i, C12388e c12388e, int i2) throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        m10300c(i, i2, 0, z2 ? 1 : 0);
        if (i2 > 0) {
            BufferedSink bufferedSink = this.f25742o;
            if (c12388e == null) {
                C12238m.throwNpe();
            }
            bufferedSink.write(c12388e, i2);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m10300c(int i, int i2, int i3, int i4) throws IOException {
        Logger logger = f25737j;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C12310d.f25614e.m10257b(false, i, i2, i3, i4));
        }
        if (!(i2 <= this.f25739l)) {
            StringBuilder sbM833U = C1643a.m833U("FRAME_SIZE_ERROR length > ");
            sbM833U.append(this.f25739l);
            sbM833U.append(": ");
            sbM833U.append(i2);
            throw new IllegalArgumentException(sbM833U.toString().toString());
        }
        if (!((((int) Permission.USE_APPLICATION_COMMANDS) & i) == 0)) {
            throw new IllegalArgumentException(C1643a.m871q("reserved bit set: ", i).toString());
        }
        BufferedSink bufferedSink = this.f25742o;
        byte[] bArr = C12272c.f25397a;
        C12238m.checkParameterIsNotNull(bufferedSink, "$this$writeMedium");
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
        this.f25742o.writeByte(i3 & 255);
        this.f25742o.writeByte(i4 & 255);
        this.f25742o.writeInt(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f25740m = true;
        this.f25742o.close();
    }

    /* JADX INFO: renamed from: d */
    public final synchronized void m10301d(int i, EnumC12307a enumC12307a, byte[] bArr) throws IOException {
        C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
        C12238m.checkParameterIsNotNull(bArr, "debugData");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        if (!(enumC12307a.m10241f() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        m10300c(0, bArr.length + 8, 7, 0);
        this.f25742o.writeInt(i);
        this.f25742o.writeInt(enumC12307a.m10241f());
        if (!(bArr.length == 0)) {
            this.f25742o.write(bArr);
        }
        this.f25742o.flush();
    }

    /* JADX INFO: renamed from: e */
    public final synchronized void m10302e(boolean z2, int i, List<C12308b> list) throws IOException {
        C12238m.checkParameterIsNotNull(list, "headerBlock");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        this.f25741n.m10254e(list);
        long j = this.f25738k.f26080k;
        long jMin = Math.min(this.f25739l, j);
        int i2 = j == jMin ? 4 : 0;
        if (z2) {
            i2 |= 1;
        }
        m10300c(i, (int) jMin, 1, i2);
        this.f25742o.write(this.f25738k, jMin);
        if (j > jMin) {
            m10306s(i, j - jMin);
        }
    }

    /* JADX INFO: renamed from: f */
    public final synchronized void m10303f(boolean z2, int i, int i2) throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        m10300c(0, 8, 6, z2 ? 1 : 0);
        this.f25742o.writeInt(i);
        this.f25742o.writeInt(i2);
        this.f25742o.flush();
    }

    public final synchronized void flush() throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        this.f25742o.flush();
    }

    /* JADX INFO: renamed from: n */
    public final synchronized void m10304n(int i, EnumC12307a enumC12307a) throws IOException {
        C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        if (!(enumC12307a.m10241f() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        m10300c(i, 4, 3, 0);
        this.f25742o.writeInt(enumC12307a.m10241f());
        this.f25742o.flush();
    }

    /* JADX INFO: renamed from: q */
    public final synchronized void m10305q(int i, long j) throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        if (!(j != 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        m10300c(i, 4, 8, 0);
        this.f25742o.writeInt((int) j);
        this.f25742o.flush();
    }

    /* JADX INFO: renamed from: s */
    public final void m10306s(int i, long j) throws IOException {
        while (j > 0) {
            long jMin = Math.min(this.f25739l, j);
            j -= jMin;
            m10300c(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.f25742o.write(this.f25738k, jMin);
        }
    }
}
