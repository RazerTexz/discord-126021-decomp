package p007b.p225i.p226a.p242c.p263t2;

import androidx.annotation.CallSuper;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: b.i.a.c.t2.v */
/* JADX INFO: compiled from: BaseAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2938v implements AudioProcessor {

    /* JADX INFO: renamed from: b */
    public AudioProcessor.C10685a f7837b;

    /* JADX INFO: renamed from: c */
    public AudioProcessor.C10685a f7838c;

    /* JADX INFO: renamed from: d */
    public AudioProcessor.C10685a f7839d;

    /* JADX INFO: renamed from: e */
    public AudioProcessor.C10685a f7840e;

    /* JADX INFO: renamed from: f */
    public ByteBuffer f7841f;

    /* JADX INFO: renamed from: g */
    public ByteBuffer f7842g;

    /* JADX INFO: renamed from: h */
    public boolean f7843h;

    public AbstractC2938v() {
        ByteBuffer byteBuffer = AudioProcessor.f19694a;
        this.f7841f = byteBuffer;
        this.f7842g = byteBuffer;
        AudioProcessor.C10685a c10685a = AudioProcessor.C10685a.f19695a;
        this.f7839d = c10685a;
        this.f7840e = c10685a;
        this.f7837b = c10685a;
        this.f7838c = c10685a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: a */
    public boolean mo3472a() {
        return this.f7840e != AudioProcessor.C10685a.f19695a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    /* JADX INFO: renamed from: b */
    public boolean mo3485b() {
        return this.f7843h && this.f7842g == AudioProcessor.f19694a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: d */
    public final AudioProcessor.C10685a mo3486d(AudioProcessor.C10685a c10685a) throws AudioProcessor.UnhandledAudioFormatException {
        this.f7839d = c10685a;
        this.f7840e = mo3471f(c10685a);
        return mo3472a() ? this.f7840e : AudioProcessor.C10685a.f19695a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: e */
    public final void mo3487e() {
        this.f7843h = true;
        mo3474h();
    }

    /* JADX INFO: renamed from: f */
    public abstract AudioProcessor.C10685a mo3471f(AudioProcessor.C10685a c10685a) throws AudioProcessor.UnhandledAudioFormatException;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.f7842g = AudioProcessor.f19694a;
        this.f7843h = false;
        this.f7837b = this.f7839d;
        this.f7838c = this.f7840e;
        mo3473g();
    }

    /* JADX INFO: renamed from: g */
    public void mo3473g() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f7842g;
        this.f7842g = AudioProcessor.f19694a;
        return byteBuffer;
    }

    /* JADX INFO: renamed from: h */
    public void mo3474h() {
    }

    /* JADX INFO: renamed from: i */
    public void mo3475i() {
    }

    /* JADX INFO: renamed from: j */
    public final ByteBuffer m3511j(int i) {
        if (this.f7841f.capacity() < i) {
            this.f7841f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f7841f.clear();
        }
        ByteBuffer byteBuffer = this.f7841f;
        this.f7842g = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f7841f = AudioProcessor.f19694a;
        AudioProcessor.C10685a c10685a = AudioProcessor.C10685a.f19695a;
        this.f7839d = c10685a;
        this.f7840e = c10685a;
        this.f7837b = c10685a;
        this.f7838c = c10685a;
        mo3475i();
    }
}
