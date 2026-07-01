package org.webrtc;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface CameraEnumerator {
    CameraVideoCapturer createCapturer(String str, CameraVideoCapturer$CameraEventsHandler cameraVideoCapturer$CameraEventsHandler);

    String[] getDeviceNames();

    List<CameraEnumerationAndroid$CaptureFormat> getSupportedFormats(String str);

    boolean isBackFacing(String str);

    boolean isFrontFacing(String str);
}
