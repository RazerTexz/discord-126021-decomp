package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo$CodecCapabilities;
import android.media.MediaCodecList;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class MediaCodecUtil$e implements MediaCodecUtil$c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public MediaCodecInfo[] f2949b;

    public MediaCodecUtil$e(boolean z2, boolean z3) {
        this.a = (z2 || z3) ? 1 : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public MediaCodecInfo a(int i) {
        if (this.f2949b == null) {
            this.f2949b = new MediaCodecList(this.a).getCodecInfos();
        }
        return this.f2949b[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public boolean b(String str, String str2, MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return mediaCodecInfo$CodecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public boolean c(String str, String str2, MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return mediaCodecInfo$CodecCapabilities.isFeatureRequired(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public int d() {
        if (this.f2949b == null) {
            this.f2949b = new MediaCodecList(this.a).getCodecInfos();
        }
        return this.f2949b.length;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
    public boolean e() {
        return true;
    }
}
