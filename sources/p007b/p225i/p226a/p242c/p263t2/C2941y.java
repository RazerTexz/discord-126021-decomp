package p007b.p225i.p226a.p242c.p263t2;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.t2.y */
/* JADX INFO: compiled from: FloatResamplingAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2941y extends AbstractC2938v {

    /* JADX INFO: renamed from: i */
    public static final int f7849i = Float.floatToIntBits(Float.NaN);

    /* JADX INFO: renamed from: k */
    public static void m3512k(int i, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (iFloatToIntBits == f7849i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: c */
    public void mo3470c(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferM3511j;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.f7837b.f19698d;
        if (i2 == 536870912) {
            byteBufferM3511j = m3511j((i / 3) * 4);
            while (iPosition < iLimit) {
                m3512k(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferM3511j);
                iPosition += 3;
            }
        } else {
            if (i2 != 805306368) {
                throw new IllegalStateException();
            }
            byteBufferM3511j = m3511j(i);
            while (iPosition < iLimit) {
                m3512k((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferM3511j);
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
        if (C2738e0.m3017y(i)) {
            return i != 4 ? new AudioProcessor.C10685a(c10685a.f19696b, c10685a.f19697c, 4) : AudioProcessor.C10685a.f19695a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(c10685a);
    }
}
