package b.i.a.c.t2;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.i.a.c.t2.c0, reason: use source file name */
/* JADX INFO: compiled from: SilenceSkippingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {
    public final long i;
    public final long j;
    public final short k;
    public int l;
    public boolean m;
    public byte[] n;
    public byte[] o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1117s;
    public long t;

    public SilenceSkippingAudioProcessor() {
        AnimatableValueParser.j(true);
        this.i = 150000L;
        this.j = 20000L;
        this.k = (short) 1024;
        byte[] bArr = Util2.f;
        this.n = bArr;
        this.o = bArr;
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean a() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void c(ByteBuffer byteBuffer) {
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.g.hasRemaining()) {
            int i = this.p;
            if (i == 0) {
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.n.length));
                int iLimit2 = byteBuffer.limit();
                while (true) {
                    iLimit2 -= 2;
                    if (iLimit2 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    } else if (Math.abs((int) byteBuffer.getShort(iLimit2)) > this.k) {
                        int i2 = this.l;
                        iPosition = ((iLimit2 / i2) * i2) + i2;
                        break;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.p = 1;
                } else {
                    byteBuffer.limit(iPosition);
                    int iRemaining = byteBuffer.remaining();
                    j(iRemaining).put(byteBuffer).flip();
                    if (iRemaining > 0) {
                        this.f1117s = true;
                    }
                }
                byteBuffer.limit(iLimit);
            } else if (i == 1) {
                int iLimit3 = byteBuffer.limit();
                int iK = k(byteBuffer);
                int iPosition2 = iK - byteBuffer.position();
                byte[] bArr = this.n;
                int length = bArr.length;
                int i3 = this.q;
                int i4 = length - i3;
                if (iK >= iLimit3 || iPosition2 >= i4) {
                    int iMin = Math.min(iPosition2, i4);
                    byteBuffer.limit(byteBuffer.position() + iMin);
                    byteBuffer.get(this.n, this.q, iMin);
                    int i5 = this.q + iMin;
                    this.q = i5;
                    byte[] bArr2 = this.n;
                    if (i5 == bArr2.length) {
                        if (this.f1117s) {
                            l(bArr2, this.r);
                            this.t += (long) ((this.q - (this.r * 2)) / this.l);
                        } else {
                            this.t += (long) ((i5 - this.r) / this.l);
                        }
                        m(byteBuffer, this.n, this.q);
                        this.q = 0;
                        this.p = 2;
                    }
                    byteBuffer.limit(iLimit3);
                } else {
                    l(bArr, i3);
                    this.q = 0;
                    this.p = 0;
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                int iLimit4 = byteBuffer.limit();
                int iK2 = k(byteBuffer);
                byteBuffer.limit(iK2);
                this.t += (long) (byteBuffer.remaining() / this.l);
                m(byteBuffer, this.o, this.r);
                if (iK2 < iLimit4) {
                    l(this.o, this.r);
                    this.p = 0;
                    byteBuffer.limit(iLimit4);
                }
            }
        }
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public AudioProcessor.a f(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.d == 2) {
            return this.m ? aVar : AudioProcessor.a.a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void g() {
        if (this.m) {
            AudioProcessor.a aVar = this.f1135b;
            int i = aVar.e;
            this.l = i;
            long j = this.i;
            long j2 = aVar.f2914b;
            int i2 = ((int) ((j * j2) / 1000000)) * i;
            if (this.n.length != i2) {
                this.n = new byte[i2];
            }
            int i3 = ((int) ((this.j * j2) / 1000000)) * i;
            this.r = i3;
            if (this.o.length != i3) {
                this.o = new byte[i3];
            }
        }
        this.p = 0;
        this.t = 0L;
        this.q = 0;
        this.f1117s = false;
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void h() {
        int i = this.q;
        if (i > 0) {
            l(this.n, i);
        }
        if (this.f1117s) {
            return;
        }
        this.t += (long) (this.r / this.l);
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void i() {
        this.m = false;
        this.r = 0;
        byte[] bArr = Util2.f;
        this.n = bArr;
        this.o = bArr;
    }

    public final int k(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.k) {
                int i = this.l;
                return (iPosition / i) * i;
            }
        }
        return byteBuffer.limit();
    }

    public final void l(byte[] bArr, int i) {
        j(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.f1117s = true;
        }
    }

    public final void m(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.r);
        int i2 = this.r - iMin;
        System.arraycopy(bArr, i - i2, this.o, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.o, i2, iMin);
    }
}
