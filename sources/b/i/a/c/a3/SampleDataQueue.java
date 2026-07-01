package b.i.a.c.a3;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import b.i.a.c.a3.SampleQueue;
import b.i.a.c.e3.Allocation;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.v2.CryptoInfo;
import b.i.a.c.x2.TrackOutput2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.g0, reason: use source file name */
/* JADX INFO: compiled from: SampleDataQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class SampleDataQueue {
    public final DefaultAllocator a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f817b;
    public final ParsableByteArray c;
    public a d;
    public a e;
    public a f;
    public long g;

    /* JADX INFO: renamed from: b.i.a.c.a3.g0$a */
    /* JADX INFO: compiled from: SampleDataQueue.java */
    public static final class a {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f818b;
        public boolean c;

        @Nullable
        public Allocation d;

        @Nullable
        public a e;

        public a(long j, int i) {
            this.a = j;
            this.f818b = j + ((long) i);
        }

        public int a(long j) {
            return ((int) (j - this.a)) + this.d.f939b;
        }
    }

    public SampleDataQueue(DefaultAllocator defaultAllocator) {
        this.a = defaultAllocator;
        int i = defaultAllocator.f944b;
        this.f817b = i;
        this.c = new ParsableByteArray(32);
        a aVar = new a(0L, i);
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
    }

    public static a d(a aVar, long j, ByteBuffer byteBuffer, int i) {
        while (j >= aVar.f818b) {
            aVar = aVar.e;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVar.f818b - j));
            byteBuffer.put(aVar.d.a, aVar.a(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == aVar.f818b) {
                aVar = aVar.e;
            }
        }
        return aVar;
    }

    public static a e(a aVar, long j, byte[] bArr, int i) {
        while (j >= aVar.f818b) {
            aVar = aVar.e;
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVar.f818b - j));
            System.arraycopy(aVar.d.a, aVar.a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == aVar.f818b) {
                aVar = aVar.e;
            }
        }
        return aVar;
    }

    public static a f(a aVar, DecoderInputBuffer decoderInputBuffer, SampleQueue.b bVar, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.t()) {
            long j = bVar.f824b;
            int iY = 1;
            parsableByteArray.A(1);
            a aVarE = e(aVar, j, parsableByteArray.a, 1);
            long j2 = j + 1;
            byte b2 = parsableByteArray.a[0];
            boolean z2 = (b2 & 128) != 0;
            int i = b2 & 127;
            CryptoInfo cryptoInfo = decoderInputBuffer.k;
            byte[] bArr = cryptoInfo.a;
            if (bArr == null) {
                cryptoInfo.a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            aVar = e(aVarE, j2, cryptoInfo.a, i);
            long j3 = j2 + ((long) i);
            if (z2) {
                parsableByteArray.A(2);
                aVar = e(aVar, j3, parsableByteArray.a, 2);
                j3 += 2;
                iY = parsableByteArray.y();
            }
            int[] iArr = cryptoInfo.d;
            if (iArr == null || iArr.length < iY) {
                iArr = new int[iY];
            }
            int[] iArr2 = cryptoInfo.e;
            if (iArr2 == null || iArr2.length < iY) {
                iArr2 = new int[iY];
            }
            if (z2) {
                int i2 = iY * 6;
                parsableByteArray.A(i2);
                aVar = e(aVar, j3, parsableByteArray.a, i2);
                j3 += (long) i2;
                parsableByteArray.E(0);
                for (int i3 = 0; i3 < iY; i3++) {
                    iArr[i3] = parsableByteArray.y();
                    iArr2[i3] = parsableByteArray.w();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = bVar.a - ((int) (j3 - bVar.f824b));
            }
            TrackOutput2.a aVar2 = bVar.c;
            int i4 = Util2.a;
            byte[] bArr2 = aVar2.f1299b;
            byte[] bArr3 = cryptoInfo.a;
            int i5 = aVar2.a;
            int i6 = aVar2.c;
            int i7 = aVar2.d;
            cryptoInfo.f = iY;
            cryptoInfo.d = iArr;
            cryptoInfo.e = iArr2;
            cryptoInfo.f1141b = bArr2;
            cryptoInfo.a = bArr3;
            cryptoInfo.c = i5;
            cryptoInfo.g = i6;
            cryptoInfo.h = i7;
            MediaCodec.CryptoInfo cryptoInfo2 = cryptoInfo.i;
            cryptoInfo2.numSubSamples = iY;
            cryptoInfo2.numBytesOfClearData = iArr;
            cryptoInfo2.numBytesOfEncryptedData = iArr2;
            cryptoInfo2.key = bArr2;
            cryptoInfo2.iv = bArr3;
            cryptoInfo2.mode = i5;
            if (Util2.a >= 24) {
                CryptoInfo.b bVar2 = cryptoInfo.j;
                Objects.requireNonNull(bVar2);
                bVar2.f1142b.set(i6, i7);
                bVar2.a.setPattern(bVar2.f1142b);
            }
            long j4 = bVar.f824b;
            int i8 = (int) (j3 - j4);
            bVar.f824b = j4 + ((long) i8);
            bVar.a -= i8;
        }
        if (!decoderInputBuffer.l()) {
            decoderInputBuffer.r(bVar.a);
            return d(aVar, bVar.f824b, decoderInputBuffer.l, bVar.a);
        }
        parsableByteArray.A(4);
        a aVarE2 = e(aVar, bVar.f824b, parsableByteArray.a, 4);
        int iW = parsableByteArray.w();
        bVar.f824b += 4;
        bVar.a -= 4;
        decoderInputBuffer.r(iW);
        a aVarD = d(aVarE2, bVar.f824b, decoderInputBuffer.l, iW);
        bVar.f824b += (long) iW;
        int i9 = bVar.a - iW;
        bVar.a = i9;
        ByteBuffer byteBuffer = decoderInputBuffer.o;
        if (byteBuffer == null || byteBuffer.capacity() < i9) {
            decoderInputBuffer.o = ByteBuffer.allocate(i9);
        } else {
            decoderInputBuffer.o.clear();
        }
        return d(aVarD, bVar.f824b, decoderInputBuffer.o, bVar.a);
    }

    public void a(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.d;
            if (j < aVar.f818b) {
                break;
            }
            DefaultAllocator defaultAllocator = this.a;
            Allocation allocation = aVar.d;
            synchronized (defaultAllocator) {
                Allocation[] allocationArr = defaultAllocator.c;
                allocationArr[0] = allocation;
                defaultAllocator.a(allocationArr);
            }
            a aVar2 = this.d;
            aVar2.d = null;
            a aVar3 = aVar2.e;
            aVar2.e = null;
            this.d = aVar3;
        }
        if (this.e.a < aVar.a) {
            this.e = aVar;
        }
    }

    public final void b(int i) {
        long j = this.g + ((long) i);
        this.g = j;
        a aVar = this.f;
        if (j == aVar.f818b) {
            this.f = aVar.e;
        }
    }

    public final int c(int i) {
        Allocation allocation;
        a aVar = this.f;
        if (!aVar.c) {
            DefaultAllocator defaultAllocator = this.a;
            synchronized (defaultAllocator) {
                defaultAllocator.e++;
                int i2 = defaultAllocator.f;
                if (i2 > 0) {
                    Allocation[] allocationArr = defaultAllocator.g;
                    int i3 = i2 - 1;
                    defaultAllocator.f = i3;
                    allocation = allocationArr[i3];
                    Objects.requireNonNull(allocation);
                    defaultAllocator.g[defaultAllocator.f] = null;
                } else {
                    allocation = new Allocation(new byte[defaultAllocator.f944b], 0);
                }
            }
            a aVar2 = new a(this.f.f818b, this.f817b);
            aVar.d = allocation;
            aVar.e = aVar2;
            aVar.c = true;
        }
        return Math.min(i, (int) (this.f.f818b - this.g));
    }
}
