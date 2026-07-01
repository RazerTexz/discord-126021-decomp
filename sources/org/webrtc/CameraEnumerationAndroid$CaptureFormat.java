package org.webrtc;

import android.graphics.ImageFormat;

/* JADX INFO: loaded from: classes3.dex */
public class CameraEnumerationAndroid$CaptureFormat {
    public final CameraEnumerationAndroid$CaptureFormat$FramerateRange framerate;
    public final int height;
    public final int imageFormat = 17;
    public final int width;

    public CameraEnumerationAndroid$CaptureFormat(int i, int i2, int i3, int i4) {
        this.width = i;
        this.height = i2;
        this.framerate = new CameraEnumerationAndroid$CaptureFormat$FramerateRange(i3, i4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CameraEnumerationAndroid$CaptureFormat)) {
            return false;
        }
        CameraEnumerationAndroid$CaptureFormat cameraEnumerationAndroid$CaptureFormat = (CameraEnumerationAndroid$CaptureFormat) obj;
        return this.width == cameraEnumerationAndroid$CaptureFormat.width && this.height == cameraEnumerationAndroid$CaptureFormat.height && this.framerate.equals(cameraEnumerationAndroid$CaptureFormat.framerate);
    }

    public int frameSize() {
        return frameSize(this.width, this.height, 17);
    }

    public int hashCode() {
        return this.framerate.hashCode() + (((this.width * 65497) + this.height) * 251) + 1;
    }

    public String toString() {
        return this.width + "x" + this.height + "@" + this.framerate;
    }

    public static int frameSize(int i, int i2, int i3) {
        if (i3 != 17) {
            throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
        }
        return (ImageFormat.getBitsPerPixel(i3) * (i * i2)) / 8;
    }

    public CameraEnumerationAndroid$CaptureFormat(int i, int i2, CameraEnumerationAndroid$CaptureFormat$FramerateRange cameraEnumerationAndroid$CaptureFormat$FramerateRange) {
        this.width = i;
        this.height = i2;
        this.framerate = cameraEnumerationAndroid$CaptureFormat$FramerateRange;
    }
}
