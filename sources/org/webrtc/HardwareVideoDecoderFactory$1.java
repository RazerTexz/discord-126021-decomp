package org.webrtc;

import android.media.MediaCodecInfo;

/* JADX INFO: loaded from: classes3.dex */
public class HardwareVideoDecoderFactory$1 implements Predicate<MediaCodecInfo> {
    @Override // org.webrtc.Predicate
    public /* synthetic */ Predicate<MediaCodecInfo> and(Predicate<? super MediaCodecInfo> predicate) {
        return Predicate$CC.a(this, predicate);
    }

    @Override // org.webrtc.Predicate
    public /* synthetic */ Predicate<MediaCodecInfo> negate() {
        return Predicate$CC.b(this);
    }

    @Override // org.webrtc.Predicate
    public /* synthetic */ Predicate<MediaCodecInfo> or(Predicate<? super MediaCodecInfo> predicate) {
        return Predicate$CC.c(this, predicate);
    }

    @Override // org.webrtc.Predicate
    public /* bridge */ /* synthetic */ boolean test(MediaCodecInfo mediaCodecInfo) {
        return test2(mediaCodecInfo);
    }

    /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
    public boolean test2(MediaCodecInfo mediaCodecInfo) {
        return MediaCodecUtils.isHardwareAccelerated(mediaCodecInfo);
    }
}
