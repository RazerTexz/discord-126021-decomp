package p007b.p225i.p226a.p242c.p243a3;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p243a3.C2544h0;
import p007b.p225i.p226a.p242c.p257e3.C2703e;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p265v2.C2955c;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.a3.g0 */
/* JADX INFO: compiled from: SampleDataQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2542g0 {

    /* JADX INFO: renamed from: a */
    public final C2713o f5578a;

    /* JADX INFO: renamed from: b */
    public final int f5579b;

    /* JADX INFO: renamed from: c */
    public final C2757x f5580c;

    /* JADX INFO: renamed from: d */
    public a f5581d;

    /* JADX INFO: renamed from: e */
    public a f5582e;

    /* JADX INFO: renamed from: f */
    public a f5583f;

    /* JADX INFO: renamed from: g */
    public long f5584g;

    /* JADX INFO: renamed from: b.i.a.c.a3.g0$a */
    /* JADX INFO: compiled from: SampleDataQueue.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final long f5585a;

        /* JADX INFO: renamed from: b */
        public final long f5586b;

        /* JADX INFO: renamed from: c */
        public boolean f5587c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public C2703e f5588d;

        /* JADX INFO: renamed from: e */
        @Nullable
        public a f5589e;

        public a(long j, int i) {
            this.f5585a = j;
            this.f5586b = j + ((long) i);
        }

        /* JADX INFO: renamed from: a */
        public int m2521a(long j) {
            return ((int) (j - this.f5585a)) + this.f5588d.f6523b;
        }
    }

    public C2542g0(C2713o c2713o) {
        this.f5578a = c2713o;
        int i = c2713o.f6563b;
        this.f5579b = i;
        this.f5580c = new C2757x(32);
        a aVar = new a(0L, i);
        this.f5581d = aVar;
        this.f5582e = aVar;
        this.f5583f = aVar;
    }

    /* JADX INFO: renamed from: d */
    public static a m2515d(a aVar, long j, ByteBuffer byteBuffer, int i) {
        while (j >= aVar.f5586b) {
            aVar = aVar.f5589e;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVar.f5586b - j));
            byteBuffer.put(aVar.f5588d.f6522a, aVar.m2521a(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == aVar.f5586b) {
                aVar = aVar.f5589e;
            }
        }
        return aVar;
    }

    /* JADX INFO: renamed from: e */
    public static a m2516e(a aVar, long j, byte[] bArr, int i) {
        while (j >= aVar.f5586b) {
            aVar = aVar.f5589e;
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVar.f5586b - j));
            System.arraycopy(aVar.f5588d.f6522a, aVar.m2521a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == aVar.f5586b) {
                aVar = aVar.f5589e;
            }
        }
        return aVar;
    }

    /* JADX INFO: renamed from: f */
    public static a m2517f(a aVar, DecoderInputBuffer decoderInputBuffer, C2544h0.b bVar, C2757x c2757x) {
        if (decoderInputBuffer.m8814t()) {
            long j = bVar.f5623b;
            int iM3105y = 1;
            c2757x.m3075A(1);
            a aVarM2516e = m2516e(aVar, j, c2757x.f6793a, 1);
            long j2 = j + 1;
            byte b2 = c2757x.f6793a[0];
            boolean z2 = (b2 & 128) != 0;
            int i = b2 & 127;
            C2955c c2955c = decoderInputBuffer.f19777k;
            byte[] bArr = c2955c.f7902a;
            if (bArr == null) {
                c2955c.f7902a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            aVar = m2516e(aVarM2516e, j2, c2955c.f7902a, i);
            long j3 = j2 + ((long) i);
            if (z2) {
                c2757x.m3075A(2);
                aVar = m2516e(aVar, j3, c2757x.f6793a, 2);
                j3 += 2;
                iM3105y = c2757x.m3105y();
            }
            int[] iArr = c2955c.f7905d;
            if (iArr == null || iArr.length < iM3105y) {
                iArr = new int[iM3105y];
            }
            int[] iArr2 = c2955c.f7906e;
            if (iArr2 == null || iArr2.length < iM3105y) {
                iArr2 = new int[iM3105y];
            }
            if (z2) {
                int i2 = iM3105y * 6;
                c2757x.m3075A(i2);
                aVar = m2516e(aVar, j3, c2757x.f6793a, i2);
                j3 += (long) i2;
                c2757x.m3079E(0);
                for (int i3 = 0; i3 < iM3105y; i3++) {
                    iArr[i3] = c2757x.m3105y();
                    iArr2[i3] = c2757x.m3103w();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = bVar.f5622a - ((int) (j3 - bVar.f5623b));
            }
            InterfaceC3122w.a aVar2 = bVar.f5624c;
            int i4 = C2738e0.f6708a;
            byte[] bArr2 = aVar2.f9001b;
            byte[] bArr3 = c2955c.f7902a;
            int i5 = aVar2.f9000a;
            int i6 = aVar2.f9002c;
            int i7 = aVar2.f9003d;
            c2955c.f7907f = iM3105y;
            c2955c.f7905d = iArr;
            c2955c.f7906e = iArr2;
            c2955c.f7903b = bArr2;
            c2955c.f7902a = bArr3;
            c2955c.f7904c = i5;
            c2955c.f7908g = i6;
            c2955c.f7909h = i7;
            MediaCodec.CryptoInfo cryptoInfo = c2955c.f7910i;
            cryptoInfo.numSubSamples = iM3105y;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i5;
            if (C2738e0.f6708a >= 24) {
                C2955c.b bVar2 = c2955c.f7911j;
                Objects.requireNonNull(bVar2);
                bVar2.f7913b.set(i6, i7);
                bVar2.f7912a.setPattern(bVar2.f7913b);
            }
            long j4 = bVar.f5623b;
            int i8 = (int) (j3 - j4);
            bVar.f5623b = j4 + ((long) i8);
            bVar.f5622a -= i8;
        }
        if (!decoderInputBuffer.m3553l()) {
            decoderInputBuffer.m8812r(bVar.f5622a);
            return m2515d(aVar, bVar.f5623b, decoderInputBuffer.f19778l, bVar.f5622a);
        }
        c2757x.m3075A(4);
        a aVarM2516e2 = m2516e(aVar, bVar.f5623b, c2757x.f6793a, 4);
        int iM3103w = c2757x.m3103w();
        bVar.f5623b += 4;
        bVar.f5622a -= 4;
        decoderInputBuffer.m8812r(iM3103w);
        a aVarM2515d = m2515d(aVarM2516e2, bVar.f5623b, decoderInputBuffer.f19778l, iM3103w);
        bVar.f5623b += (long) iM3103w;
        int i9 = bVar.f5622a - iM3103w;
        bVar.f5622a = i9;
        ByteBuffer byteBuffer = decoderInputBuffer.f19781o;
        if (byteBuffer == null || byteBuffer.capacity() < i9) {
            decoderInputBuffer.f19781o = ByteBuffer.allocate(i9);
        } else {
            decoderInputBuffer.f19781o.clear();
        }
        return m2515d(aVarM2515d, bVar.f5623b, decoderInputBuffer.f19781o, bVar.f5622a);
    }

    /* JADX INFO: renamed from: a */
    public void m2518a(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.f5581d;
            if (j < aVar.f5586b) {
                break;
            }
            C2713o c2713o = this.f5578a;
            C2703e c2703e = aVar.f5588d;
            synchronized (c2713o) {
                C2703e[] c2703eArr = c2713o.f6564c;
                c2703eArr[0] = c2703e;
                c2713o.m2858a(c2703eArr);
            }
            a aVar2 = this.f5581d;
            aVar2.f5588d = null;
            a aVar3 = aVar2.f5589e;
            aVar2.f5589e = null;
            this.f5581d = aVar3;
        }
        if (this.f5582e.f5585a < aVar.f5585a) {
            this.f5582e = aVar;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2519b(int i) {
        long j = this.f5584g + ((long) i);
        this.f5584g = j;
        a aVar = this.f5583f;
        if (j == aVar.f5586b) {
            this.f5583f = aVar.f5589e;
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m2520c(int i) {
        C2703e c2703e;
        a aVar = this.f5583f;
        if (!aVar.f5587c) {
            C2713o c2713o = this.f5578a;
            synchronized (c2713o) {
                c2713o.f6566e++;
                int i2 = c2713o.f6567f;
                if (i2 > 0) {
                    C2703e[] c2703eArr = c2713o.f6568g;
                    int i3 = i2 - 1;
                    c2713o.f6567f = i3;
                    c2703e = c2703eArr[i3];
                    Objects.requireNonNull(c2703e);
                    c2713o.f6568g[c2713o.f6567f] = null;
                } else {
                    c2703e = new C2703e(new byte[c2713o.f6563b], 0);
                }
            }
            a aVar2 = new a(this.f5583f.f5586b, this.f5579b);
            aVar.f5588d = c2703e;
            aVar.f5589e = aVar2;
            aVar.f5587c = true;
        }
        return Math.min(i, (int) (this.f5583f.f5586b - this.f5584g));
    }
}
