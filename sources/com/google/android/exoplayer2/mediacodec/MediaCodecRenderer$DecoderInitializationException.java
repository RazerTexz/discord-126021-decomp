package com.google.android.exoplayer2.mediacodec;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.y2.u;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecRenderer$DecoderInitializationException extends Exception {

    @Nullable
    public final u codecInfo;

    @Nullable
    public final String diagnosticInfo;

    @Nullable
    public final MediaCodecRenderer$DecoderInitializationException fallbackDecoderInitializationException;
    public final String mimeType;
    public final boolean secureDecoderRequired;

    public MediaCodecRenderer$DecoderInitializationException(j1 j1Var, @Nullable Throwable th, boolean z2, int i) {
        String strValueOf = String.valueOf(j1Var);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(strValueOf);
        String string = sb.toString();
        String str = j1Var.w;
        String str2 = i < 0 ? "neg_" : "";
        int iAbs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(str2.length() + 71);
        sb2.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
        sb2.append(str2);
        sb2.append(iAbs);
        this(string, th, str, z2, null, sb2.toString(), null);
    }

    public MediaCodecRenderer$DecoderInitializationException(String str, @Nullable Throwable th, String str2, boolean z2, @Nullable u uVar, @Nullable String str3, @Nullable MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException) {
        super(str, th);
        this.mimeType = str2;
        this.secureDecoderRequired = z2;
        this.codecInfo = uVar;
        this.diagnosticInfo = str3;
        this.fallbackDecoderInitializationException = mediaCodecRenderer$DecoderInitializationException;
    }
}
