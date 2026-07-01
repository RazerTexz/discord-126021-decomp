package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraEnumerationAndroid$1 extends CameraEnumerationAndroid$ClosestComparator<CameraEnumerationAndroid$CaptureFormat$FramerateRange> {
    private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
    private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
    private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
    private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
    private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
    private static final int MIN_FPS_THRESHOLD = 8000;
    public final /* synthetic */ int val$requestedFps;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraEnumerationAndroid$1(int i) {
        super(null);
        this.val$requestedFps = i;
    }

    private int progressivePenalty(int i, int i2, int i3, int i4) {
        if (i < i2) {
            return i * i3;
        }
        return ((i - i2) * i4) + (i3 * i2);
    }

    @Override // org.webrtc.CameraEnumerationAndroid$ClosestComparator
    public /* bridge */ /* synthetic */ int diff(CameraEnumerationAndroid$CaptureFormat$FramerateRange cameraEnumerationAndroid$CaptureFormat$FramerateRange) {
        return diff2(cameraEnumerationAndroid$CaptureFormat$FramerateRange);
    }

    /* JADX INFO: renamed from: diff, reason: avoid collision after fix types in other method */
    public int diff2(CameraEnumerationAndroid$CaptureFormat$FramerateRange cameraEnumerationAndroid$CaptureFormat$FramerateRange) {
        return progressivePenalty(cameraEnumerationAndroid$CaptureFormat$FramerateRange.min, MIN_FPS_THRESHOLD, 1, 4) + progressivePenalty(Math.abs((this.val$requestedFps * 1000) - cameraEnumerationAndroid$CaptureFormat$FramerateRange.max), MAX_FPS_DIFF_THRESHOLD, 1, 3);
    }
}
