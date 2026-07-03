package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p278y2.C3149u;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {

    @Nullable
    public final C3149u codecInfo;

    @Nullable
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    public MediaCodecDecoderException(Throwable th, @Nullable C3149u c3149u) {
        String diagnosticInfo = null;
        String strValueOf = String.valueOf(c3149u == null ? null : c3149u.f9112a);
        super(strValueOf.length() != 0 ? "Decoder failed: ".concat(strValueOf) : new String("Decoder failed: "), th);
        this.codecInfo = c3149u;
        if (C2738e0.f6708a >= 21 && (th instanceof MediaCodec.CodecException)) {
            diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.diagnosticInfo = diagnosticInfo;
    }
}
