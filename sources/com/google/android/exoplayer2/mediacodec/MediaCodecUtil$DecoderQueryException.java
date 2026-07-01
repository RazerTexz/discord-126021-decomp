package com.google.android.exoplayer2.mediacodec;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecUtil$DecoderQueryException extends Exception {
    public MediaCodecUtil$DecoderQueryException(Throwable th, MediaCodecUtil$a mediaCodecUtil$a) {
        super("Failed to query underlying media codecs", th);
    }
}
