package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo$CodecCapabilities;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaCodecUtil$d implements MediaCodecUtil$c {
    public MediaCodecUtil$d(MediaCodecUtil$a mediaCodecUtil$a) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public MediaCodecInfo a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public boolean b(String str, String str2, MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public boolean c(String str, String str2, MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public int d() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public boolean e() {
        return false;
    }
}
