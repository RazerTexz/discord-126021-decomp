package b.i.a.c.t2;

import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.i.a.c.t2.f0, reason: use source file name */
/* JADX INFO: compiled from: TrimmingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrimmingAudioProcessor extends BaseAudioProcessor {
    public int i;
    public int j;
    public boolean k;
    public int l;
    public byte[] m = Util2.f;
    public int n;
    public long o;

    @Override // b.i.a.c.t2.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return super.b() && this.n == 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void c(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.l);
        this.o += (long) (iMin / this.f1135b.e);
        this.l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.l > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.n + i2) - this.m.length;
        ByteBuffer byteBufferJ = j(length);
        int iH = Util2.h(length, 0, this.n);
        byteBufferJ.put(this.m, 0, iH);
        int iH2 = Util2.h(length - iH, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iH2);
        byteBufferJ.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iH2;
        int i4 = this.n - iH;
        this.n = i4;
        byte[] bArr = this.m;
        System.arraycopy(bArr, iH, bArr, 0, i4);
        byteBuffer.get(this.m, this.n, i3);
        this.n += i3;
        byteBufferJ.flip();
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public AudioProcessor.a f(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.d != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.k = true;
        return (this.i == 0 && this.j == 0) ? AudioProcessor.a.a : aVar;
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void g() {
        if (this.k) {
            this.k = false;
            int i = this.j;
            int i2 = this.f1135b.e;
            this.m = new byte[i * i2];
            this.l = this.i * i2;
        }
        this.n = 0;
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        if (super.b() && (i = this.n) > 0) {
            j(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.getOutput();
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void h() {
        if (this.k) {
            int i = this.n;
            if (i > 0) {
                this.o += (long) (i / this.f1135b.e);
            }
            this.n = 0;
        }
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void i() {
        this.m = Util2.f;
    }
}
