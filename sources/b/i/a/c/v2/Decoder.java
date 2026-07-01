package b.i.a.c.v2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

/* JADX INFO: renamed from: b.i.a.c.v2.d, reason: use source file name */
/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Decoder<I, O, E extends DecoderException> {
    @Nullable
    O b() throws DecoderException;

    @Nullable
    I c() throws DecoderException;

    void d(I i) throws DecoderException;

    void flush();

    void release();
}
