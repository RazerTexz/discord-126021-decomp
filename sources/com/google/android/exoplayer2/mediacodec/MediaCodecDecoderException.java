package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec$CodecException;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.y2.u;
import com.google.android.exoplayer2.decoder.DecoderException;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {

    @Nullable
    public final u codecInfo;

    @Nullable
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    public MediaCodecDecoderException(Throwable th, @Nullable u uVar) {
        String diagnosticInfo = null;
        String strValueOf = String.valueOf(uVar == null ? null : uVar.a);
        super(strValueOf.length() != 0 ? "Decoder failed: ".concat(strValueOf) : new String("Decoder failed: "), th);
        this.codecInfo = uVar;
        if (e0.a >= 21 && (th instanceof MediaCodec$CodecException)) {
            diagnosticInfo = ((MediaCodec$CodecException) th).getDiagnosticInfo();
        }
        this.diagnosticInfo = diagnosticInfo;
    }
}
