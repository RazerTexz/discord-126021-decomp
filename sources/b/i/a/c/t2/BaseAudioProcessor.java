package b.i.a.c.t2;

import androidx.annotation.CallSuper;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: b.i.a.c.t2.v, reason: use source file name */
/* JADX INFO: compiled from: BaseAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioProcessor.a f1135b;
    public AudioProcessor.a c;
    public AudioProcessor.a d;
    public AudioProcessor.a e;
    public ByteBuffer f;
    public ByteBuffer g;
    public boolean h;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.f = byteBuffer;
        this.g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.d = aVar;
        this.e = aVar;
        this.f1135b = aVar;
        this.c = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean a() {
        return this.e != AudioProcessor.a.a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public boolean b() {
        return this.h && this.g == AudioProcessor.a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.a d(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        this.d = aVar;
        this.e = f(aVar);
        return a() ? this.e : AudioProcessor.a.a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void e() {
        this.h = true;
        h();
    }

    public abstract AudioProcessor.a f(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.g = AudioProcessor.a;
        this.h = false;
        this.f1135b = this.d;
        this.c = this.e;
        g();
    }

    public void g() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.g;
        this.g = AudioProcessor.a;
        return byteBuffer;
    }

    public void h() {
    }

    public void i() {
    }

    public final ByteBuffer j(int i) {
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        ByteBuffer byteBuffer = this.f;
        this.g = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f = AudioProcessor.a;
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.d = aVar;
        this.e = aVar;
        this.f1135b = aVar;
        this.c = aVar;
        i();
    }
}
