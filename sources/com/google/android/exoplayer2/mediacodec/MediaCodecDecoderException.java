package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import b.i.a.c.f3.Util2;
import b.i.a.c.y2.MediaCodecInfo;
import com.google.android.exoplayer2.decoder.DecoderException;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {

    @Nullable
    public final MediaCodecInfo codecInfo;

    @Nullable
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    public MediaCodecDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        String diagnosticInfo = null;
        String strValueOf = String.valueOf(mediaCodecInfo == null ? null : mediaCodecInfo.a);
        super(strValueOf.length() != 0 ? "Decoder failed: ".concat(strValueOf) : new String("Decoder failed: "), th);
        this.codecInfo = mediaCodecInfo;
        if (Util2.a >= 21 && (th instanceof MediaCodec.CodecException)) {
            diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.diagnosticInfo = diagnosticInfo;
    }
}
