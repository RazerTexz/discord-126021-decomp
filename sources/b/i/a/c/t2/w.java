package b.i.a.c.t2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.AudioProcessor$a;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: ChannelMappingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends v {

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

    @Override // b.i.a.c.t2.v
    public AudioProcessor$a f(AudioProcessor$a audioProcessor$a) throws AudioProcessor$UnhandledAudioFormatException {
        int[] iArr = this.i;
        if (iArr == null) {
            return AudioProcessor$a.a;
        }
        if (audioProcessor$a.d != 2) {
            throw new AudioProcessor$UnhandledAudioFormatException(audioProcessor$a);
        }
        boolean z2 = audioProcessor$a.c != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= audioProcessor$a.c) {
                throw new AudioProcessor$UnhandledAudioFormatException(audioProcessor$a);
            }
            z2 |= i2 != i;
            i++;
        }
        return z2 ? new AudioProcessor$a(audioProcessor$a.f2914b, iArr.length, 2) : AudioProcessor$a.a;
    }

    @Override // b.i.a.c.t2.v
    public void g() {
        this.j = this.i;
    }

    @Override // b.i.a.c.t2.v
    public void i() {
        this.j = null;
        this.i = null;
    }
}
