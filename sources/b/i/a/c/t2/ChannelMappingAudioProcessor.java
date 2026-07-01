package b.i.a.c.t2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.t2.w, reason: use source file name */
/* JADX INFO: compiled from: ChannelMappingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ChannelMappingAudioProcessor extends BaseAudioProcessor {

    @Nullable
    public int[] i;

    @Nullable
    public int[] j;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void c(ByteBuffer byteBuffer) {
        int[] iArr = this.j;
        Objects.requireNonNull(iArr);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferJ = j(((iLimit - iPosition) / this.f1135b.e) * this.c.e);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferJ.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.f1135b.e;
        }
        byteBuffer.position(iLimit);
        byteBufferJ.flip();
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public AudioProcessor.a f(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.i;
        if (iArr == null) {
            return AudioProcessor.a.a;
        }
        if (aVar.d != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z2 = aVar.c != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= aVar.c) {
                throw new AudioProcessor.UnhandledAudioFormatException(aVar);
            }
            z2 |= i2 != i;
            i++;
        }
        return z2 ? new AudioProcessor.a(aVar.f2914b, iArr.length, 2) : AudioProcessor.a.a;
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void g() {
        this.j = this.i;
    }

    @Override // b.i.a.c.t2.BaseAudioProcessor
    public void i() {
        this.j = null;
        this.i = null;
    }
}
