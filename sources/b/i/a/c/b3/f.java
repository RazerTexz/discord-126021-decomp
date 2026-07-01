package b.i.a.c.b3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends b.i.a.c.v2.h<j, k, SubtitleDecoderException> implements h {
    public f(String str) {
        super(new j[2], new k[2]);
        b.c.a.a0.d.D(this.g == this.e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.e) {
            decoderInputBuffer.r(1024);
        }
    }

    @Override // b.i.a.c.b3.h
    public void a(long j) {
    }

    @Override // b.i.a.c.v2.h
    @Nullable
    public DecoderException e(DecoderInputBuffer decoderInputBuffer, b.i.a.c.v2.f fVar, boolean z2) {
        j jVar = (j) decoderInputBuffer;
        k kVar = (k) fVar;
        try {
            ByteBuffer byteBuffer = jVar.l;
            Objects.requireNonNull(byteBuffer);
            kVar.r(jVar.n, j(byteBuffer.array(), byteBuffer.limit(), z2), jVar.r);
            kVar.j &= Integer.MAX_VALUE;
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    public abstract g j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException;
}
