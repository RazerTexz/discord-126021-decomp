package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class RendererCommon$1 {
    public static final /* synthetic */ int[] $SwitchMap$org$webrtc$RendererCommon$ScalingType;

    static {
        RendererCommon$ScalingType.values();
        int[] iArr = new int[3];
        $SwitchMap$org$webrtc$RendererCommon$ScalingType = iArr;
        try {
            iArr[RendererCommon$ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$org$webrtc$RendererCommon$ScalingType[RendererCommon$ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$org$webrtc$RendererCommon$ScalingType[RendererCommon$ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
