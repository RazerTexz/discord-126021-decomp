package b.i.a.c.a3;

import android.media.MediaCodec$CryptoInfo;
import b.i.a.c.v2.c$b;
import b.i.a.c.x2.w$a;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: SampleDataQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class g0 {
    public final b.i.a.c.e3.o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f817b;
    public final b.i.a.c.f3.x c;
    public g0$a d;
    public g0$a e;
    public g0$a f;
    public long g;

    public g0(b.i.a.c.e3.o oVar) {
        this.a = oVar;
        int i = oVar.f944b;
        this.f817b = i;
        this.c = new b.i.a.c.f3.x(32);
        g0$a g0_a = new g0$a(0L, i);
        this.d = g0_a;
        this.e = g0_a;
        this.f = g0_a;
    }

    public static g0$a d(g0$a g0_a, long j, ByteBuffer byteBuffer, int i) {
        while (j >= g0_a.f818b) {
            g0_a = g0_a.e;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (g0_a.f818b - j));
            byteBuffer.put(g0_a.d.a, g0_a.a(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == g0_a.f818b) {
                g0_a = g0_a.e;
            }
        }
        return g0_a;
    }

    public static g0$a e(g0$a g0_a, long j, byte[] bArr, int i) {
        while (j >= g0_a.f818b) {
            g0_a = g0_a.e;
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (g0_a.f818b - j));
            System.arraycopy(g0_a.d.a, g0_a.a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == g0_a.f818b) {
                g0_a = g0_a.e;
            }
        }
        return g0_a;
    }

    public static g0$a f(g0$a g0_a, DecoderInputBuffer decoderInputBuffer, h0$b h0_b, b.i.a.c.f3.x xVar) {
        if (decoderInputBuffer.t()) {
            long j = h0_b.f824b;
            int iY = 1;
            xVar.A(1);
            g0$a g0_aE = e(g0_a, j, xVar.a, 1);
            long j2 = j + 1;
            byte b2 = xVar.a[0];
            boolean z2 = (b2 & 128) != 0;
            int i = b2 & 127;
            b.i.a.c.v2.c cVar = decoderInputBuffer.k;
            byte[] bArr = cVar.a;
            if (bArr == null) {
                cVar.a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            g0_a = e(g0_aE, j2, cVar.a, i);
            long j3 = j2 + ((long) i);
            if (z2) {
                xVar.A(2);
                g0_a = e(g0_a, j3, xVar.a, 2);
                j3 += 2;
                iY = xVar.y();
            }
            int[] iArr = cVar.d;
            if (iArr == null || iArr.length < iY) {
                iArr = new int[iY];
            }
            int[] iArr2 = cVar.e;
            if (iArr2 == null || iArr2.length < iY) {
                iArr2 = new int[iY];
            }
            if (z2) {
                int i2 = iY * 6;
                xVar.A(i2);
                g0_a = e(g0_a, j3, xVar.a, i2);
                j3 += (long) i2;
                xVar.E(0);
                for (int i3 = 0; i3 < iY; i3++) {
                    iArr[i3] = xVar.y();
                    iArr2[i3] = xVar.w();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = h0_b.a - ((int) (j3 - h0_b.f824b));
            }
            w$a w_a = h0_b.c;
            int i4 = b.i.a.c.f3.e0.a;
            byte[] bArr2 = w_a.f1299b;
            byte[] bArr3 = cVar.a;
            int i5 = w_a.a;
            int i6 = w_a.c;
            int i7 = w_a.d;
            cVar.f = iY;
            cVar.d = iArr;
            cVar.e = iArr2;
            cVar.f1141b = bArr2;
            cVar.a = bArr3;
            cVar.c = i5;
            cVar.g = i6;
            cVar.h = i7;
            MediaCodec$CryptoInfo mediaCodec$CryptoInfo = cVar.i;
            mediaCodec$CryptoInfo.numSubSamples = iY;
            mediaCodec$CryptoInfo.numBytesOfClearData = iArr;
            mediaCodec$CryptoInfo.numBytesOfEncryptedData = iArr2;
            mediaCodec$CryptoInfo.key = bArr2;
            mediaCodec$CryptoInfo.iv = bArr3;
            mediaCodec$CryptoInfo.mode = i5;
            if (b.i.a.c.f3.e0.a >= 24) {
                c$b c_b = cVar.j;
                Objects.requireNonNull(c_b);
                c_b.f1142b.set(i6, i7);
                c_b.a.setPattern(c_b.f1142b);
            }
            long j4 = h0_b.f824b;
            int i8 = (int) (j3 - j4);
            h0_b.f824b = j4 + ((long) i8);
            h0_b.a -= i8;
        }
        if (!decoderInputBuffer.l()) {
            decoderInputBuffer.r(h0_b.a);
            return d(g0_a, h0_b.f824b, decoderInputBuffer.l, h0_b.a);
        }
        xVar.A(4);
        g0$a g0_aE2 = e(g0_a, h0_b.f824b, xVar.a, 4);
        int iW = xVar.w();
        h0_b.f824b += 4;
        h0_b.a -= 4;
        decoderInputBuffer.r(iW);
        g0$a g0_aD = d(g0_aE2, h0_b.f824b, decoderInputBuffer.l, iW);
        h0_b.f824b += (long) iW;
        int i9 = h0_b.a - iW;
        h0_b.a = i9;
        ByteBuffer byteBuffer = decoderInputBuffer.o;
        if (byteBuffer == null || byteBuffer.capacity() < i9) {
            decoderInputBuffer.o = ByteBuffer.allocate(i9);
        } else {
            decoderInputBuffer.o.clear();
        }
        return d(g0_aD, h0_b.f824b, decoderInputBuffer.o, h0_b.a);
    }

    public void a(long j) {
        g0$a g0_a;
        if (j == -1) {
            return;
        }
        while (true) {
            g0_a = this.d;
            if (j < g0_a.f818b) {
                break;
            }
            b.i.a.c.e3.o oVar = this.a;
            b.i.a.c.e3.e eVar = g0_a.d;
            synchronized (oVar) {
                b.i.a.c.e3.e[] eVarArr = oVar.c;
                eVarArr[0] = eVar;
                oVar.a(eVarArr);
            }
            g0$a g0_a2 = this.d;
            g0_a2.d = null;
            g0$a g0_a3 = g0_a2.e;
            g0_a2.e = null;
            this.d = g0_a3;
        }
        if (this.e.a < g0_a.a) {
            this.e = g0_a;
        }
    }

    public final void b(int i) {
        long j = this.g + ((long) i);
        this.g = j;
        g0$a g0_a = this.f;
        if (j == g0_a.f818b) {
            this.f = g0_a.e;
        }
    }

    public final int c(int i) {
        b.i.a.c.e3.e eVar;
        g0$a g0_a = this.f;
        if (!g0_a.c) {
            b.i.a.c.e3.o oVar = this.a;
            synchronized (oVar) {
                oVar.e++;
                int i2 = oVar.f;
                if (i2 > 0) {
                    b.i.a.c.e3.e[] eVarArr = oVar.g;
                    int i3 = i2 - 1;
                    oVar.f = i3;
                    eVar = eVarArr[i3];
                    Objects.requireNonNull(eVar);
                    oVar.g[oVar.f] = null;
                } else {
                    eVar = new b.i.a.c.e3.e(new byte[oVar.f944b], 0);
                }
            }
            g0$a g0_a2 = new g0$a(this.f.f818b, this.f817b);
            g0_a.d = eVar;
            g0_a.e = g0_a2;
            g0_a.c = true;
        }
        return Math.min(i, (int) (this.f.f818b - this.g));
    }
}
