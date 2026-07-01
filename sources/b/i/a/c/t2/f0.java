package b.i.a.c.t2;

import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.AudioProcessor$a;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TrimmingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends v {
    public int i;
    public int j;
    public boolean k;
    public int l;
    public byte[] m = b.i.a.c.f3.e0.f;
    public int n;
    public long o;

    @Override // b.i.a.c.t2.v, com.google.android.exoplayer2.audio.AudioProcessor
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
        int iH = b.i.a.c.f3.e0.h(length, 0, this.n);
        byteBufferJ.put(this.m, 0, iH);
        int iH2 = b.i.a.c.f3.e0.h(length - iH, 0, i2);
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

    @Override // b.i.a.c.t2.v
    public AudioProcessor$a f(AudioProcessor$a audioProcessor$a) throws AudioProcessor$UnhandledAudioFormatException {
        if (audioProcessor$a.d != 2) {
            throw new AudioProcessor$UnhandledAudioFormatException(audioProcessor$a);
        }
        this.k = true;
        return (this.i == 0 && this.j == 0) ? AudioProcessor$a.a : audioProcessor$a;
    }

    @Override // b.i.a.c.t2.v
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

    @Override // b.i.a.c.t2.v, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        if (super.b() && (i = this.n) > 0) {
            j(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.getOutput();
    }

    @Override // b.i.a.c.t2.v
    public void h() {
        if (this.k) {
            int i = this.n;
            if (i > 0) {
                this.o += (long) (i / this.f1135b.e);
            }
            this.n = 0;
        }
    }

    @Override // b.i.a.c.t2.v
    public void i() {
        this.m = b.i.a.c.f3.e0.f;
    }
}
