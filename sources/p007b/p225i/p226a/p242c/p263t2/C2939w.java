package p007b.p225i.p226a.p242c.p263t2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.t2.w */
/* JADX INFO: compiled from: ChannelMappingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2939w extends AbstractC2938v {

    /* JADX INFO: renamed from: i */
    @Nullable
    public int[] f7844i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public int[] f7845j;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: c */
    public void mo3470c(ByteBuffer byteBuffer) {
        int[] iArr = this.f7845j;
        Objects.requireNonNull(iArr);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferM3511j = m3511j(((iLimit - iPosition) / this.f7837b.f19699e) * this.f7838c.f19699e);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferM3511j.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.f7837b.f19699e;
        }
        byteBuffer.position(iLimit);
        byteBufferM3511j.flip();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AbstractC2938v
    /* JADX INFO: renamed from: f */
    public AudioProcessor.C10685a mo3471f(AudioProcessor.C10685a c10685a) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f7844i;
        if (iArr == null) {
            return AudioProcessor.C10685a.f19695a;
        }
        if (c10685a.f19698d != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(c10685a);
        }
        boolean z2 = c10685a.f19697c != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= c10685a.f19697c) {
                throw new AudioProcessor.UnhandledAudioFormatException(c10685a);
            }
            z2 |= i2 != i;
            i++;
        }
        return z2 ? new AudioProcessor.C10685a(c10685a.f19696b, iArr.length, 2) : AudioProcessor.C10685a.f19695a;
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AbstractC2938v
    /* JADX INFO: renamed from: g */
    public void mo3473g() {
        this.f7845j = this.f7844i;
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AbstractC2938v
    /* JADX INFO: renamed from: i */
    public void mo3475i() {
        this.f7845j = null;
        this.f7844i = null;
    }
}
