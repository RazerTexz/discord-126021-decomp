package b.i.a.c.b3;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.v2.DecoderOutputBuffer;
import b.i.a.c.v2.SimpleDecoder;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.b3.f, reason: use source file name */
/* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleSubtitleDecoder2 extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    public SimpleSubtitleDecoder2(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        AnimatableValueParser.D(this.g == this.e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.e) {
            decoderInputBuffer.r(1024);
        }
    }

    @Override // b.i.a.c.b3.SubtitleDecoder
    public void a(long j) {
    }

    @Override // b.i.a.c.v2.SimpleDecoder
    @Nullable
    public DecoderException e(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z2) {
        SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) decoderInputBuffer;
        SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) decoderOutputBuffer;
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.l;
            Objects.requireNonNull(byteBuffer);
            subtitleOutputBuffer.r(subtitleInputBuffer.n, j(byteBuffer.array(), byteBuffer.limit(), z2), subtitleInputBuffer.r);
            subtitleOutputBuffer.j &= Integer.MAX_VALUE;
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    public abstract Subtitle j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException;
}
