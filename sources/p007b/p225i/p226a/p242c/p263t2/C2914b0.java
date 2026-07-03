package p007b.p225i.p226a.p242c.p263t2;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.t2.b0 */
/* JADX INFO: compiled from: ResamplingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2914b0 extends AbstractC2938v {
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: c */
    public void mo3470c(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.f7837b.f19698d;
        if (i2 == 3) {
            i *= 2;
        } else if (i2 == 4) {
            i /= 2;
        } else if (i2 != 268435456) {
            if (i2 != 536870912) {
                if (i2 != 805306368) {
                    throw new IllegalStateException();
                }
                i /= 2;
            } else {
                i /= 3;
                i *= 2;
            }
        }
        ByteBuffer byteBufferM3511j = m3511j(i);
        int i3 = this.f7837b.f19698d;
        if (i3 == 3) {
            while (iPosition < iLimit) {
                byteBufferM3511j.put((byte) 0);
                byteBufferM3511j.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i3 == 4) {
            while (iPosition < iLimit) {
                short sM2999g = (short) (C2738e0.m2999g(byteBuffer.getFloat(iPosition), -1.0f, 1.0f) * 32767.0f);
                byteBufferM3511j.put((byte) (sM2999g & 255));
                byteBufferM3511j.put((byte) ((sM2999g >> 8) & 255));
                iPosition += 4;
            }
        } else if (i3 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferM3511j.put(byteBuffer.get(iPosition + 1));
                byteBufferM3511j.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i3 == 536870912) {
            while (iPosition < iLimit) {
                byteBufferM3511j.put(byteBuffer.get(iPosition + 1));
                byteBufferM3511j.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else {
            if (i3 != 805306368) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                byteBufferM3511j.put(byteBuffer.get(iPosition + 2));
                byteBufferM3511j.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferM3511j.flip();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AbstractC2938v
    /* JADX INFO: renamed from: f */
    public AudioProcessor.C10685a mo3471f(AudioProcessor.C10685a c10685a) throws AudioProcessor.UnhandledAudioFormatException {
        int i = c10685a.f19698d;
        if (i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4) {
            return i != 2 ? new AudioProcessor.C10685a(c10685a.f19696b, c10685a.f19697c, 2) : AudioProcessor.C10685a.f19695a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(c10685a);
    }
}
