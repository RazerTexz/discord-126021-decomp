package org.webrtc;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class CameraEnumerationAndroid$CaptureFormat$FramerateRange {
    public int max;
    public int min;

    public CameraEnumerationAndroid$CaptureFormat$FramerateRange(int i, int i2) {
        this.min = i;
        this.max = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CameraEnumerationAndroid$CaptureFormat$FramerateRange)) {
            return false;
        }
        CameraEnumerationAndroid$CaptureFormat$FramerateRange cameraEnumerationAndroid$CaptureFormat$FramerateRange = (CameraEnumerationAndroid$CaptureFormat$FramerateRange) obj;
        return this.min == cameraEnumerationAndroid$CaptureFormat$FramerateRange.min && this.max == cameraEnumerationAndroid$CaptureFormat$FramerateRange.max;
    }

    public int hashCode() {
        return (this.min * 65537) + 1 + this.max;
    }

    public String toString() {
        StringBuilder sbU = a.U("[");
        sbU.append(this.min / 1000.0f);
        sbU.append(":");
        sbU.append(this.max / 1000.0f);
        sbU.append("]");
        return sbU.toString();
    }
}
