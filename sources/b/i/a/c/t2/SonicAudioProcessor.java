package b.i.a.c.t2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.t2.e0, reason: use source file name */
/* JADX INFO: compiled from: SonicAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SonicAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1120b;
    public float c = 1.0f;
    public float d = 1.0f;
    public AudioProcessor.a e;
    public AudioProcessor.a f;
    public AudioProcessor.a g;
    public AudioProcessor.a h;
    public boolean i;

    @Nullable
    public Sonic j;
    public ByteBuffer k;
    public ShortBuffer l;
    public ByteBuffer m;
    public long n;
    public long o;
    public boolean p;

    public SonicAudioProcessor() {
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.f1120b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean a() {
        return this.f.f2914b != -1 && (Math.abs(this.c - 1.0f) >= 1.0E-4f || Math.abs(this.d - 1.0f) >= 1.0E-4f || this.f.f2914b != this.e.f2914b);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        Sonic sonic;
        return this.p && ((sonic = this.j) == null || (sonic.m * sonic.f1118b) * 2 == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            Sonic sonic = this.j;
            Objects.requireNonNull(sonic);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.n += (long) iRemaining;
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i = sonic.f1118b;
            int i2 = iRemaining2 / i;
            short[] sArrC = sonic.c(sonic.j, sonic.k, i2);
            sonic.j = sArrC;
            shortBufferAsShortBuffer.get(sArrC, sonic.k * sonic.f1118b, ((i * i2) * 2) / 2);
            sonic.k += i2;
            sonic.f();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a d(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.d != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i = this.f1120b;
        if (i == -1) {
            i = aVar.f2914b;
        }
        this.e = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i, aVar.c, 2);
        this.f = aVar2;
        this.i = true;
        return aVar2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        int i;
        Sonic sonic = this.j;
        if (sonic != null) {
            int i2 = sonic.k;
            float f = sonic.c;
            float f2 = sonic.d;
            int i3 = sonic.m + ((int) ((((i2 / (f / f2)) + sonic.o) / (sonic.e * f2)) + 0.5f));
            sonic.j = sonic.c(sonic.j, i2, (sonic.h * 2) + i2);
            int i4 = 0;
            while (true) {
                i = sonic.h * 2;
                int i5 = sonic.f1118b;
                if (i4 >= i * i5) {
                    break;
                }
                sonic.j[(i5 * i2) + i4] = 0;
                i4++;
            }
            sonic.k = i + sonic.k;
            sonic.f();
            if (sonic.m > i3) {
                sonic.m = i3;
            }
            sonic.k = 0;
            sonic.r = 0;
            sonic.o = 0;
        }
        this.p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (a()) {
            AudioProcessor.a aVar = this.e;
            this.g = aVar;
            AudioProcessor.a aVar2 = this.f;
            this.h = aVar2;
            if (this.i) {
                this.j = new Sonic(aVar.f2914b, aVar.c, this.c, this.d, aVar2.f2914b);
            } else {
                Sonic sonic = this.j;
                if (sonic != null) {
                    sonic.k = 0;
                    sonic.m = 0;
                    sonic.o = 0;
                    sonic.p = 0;
                    sonic.q = 0;
                    sonic.r = 0;
                    sonic.f1119s = 0;
                    sonic.t = 0;
                    sonic.u = 0;
                    sonic.v = 0;
                }
            }
        }
        this.m = AudioProcessor.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        Sonic sonic = this.j;
        if (sonic != null && (i = sonic.m * sonic.f1118b * 2) > 0) {
            if (this.k.capacity() < i) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                this.k = byteBufferOrder;
                this.l = byteBufferOrder.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            ShortBuffer shortBuffer = this.l;
            int iMin = Math.min(shortBuffer.remaining() / sonic.f1118b, sonic.m);
            shortBuffer.put(sonic.l, 0, sonic.f1118b * iMin);
            int i2 = sonic.m - iMin;
            sonic.m = i2;
            short[] sArr = sonic.l;
            int i3 = sonic.f1118b;
            System.arraycopy(sArr, iMin * i3, sArr, 0, i2 * i3);
            this.o += (long) i;
            this.k.limit(i);
            this.m = this.k;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = AudioProcessor.a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.f1120b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}
