package org.webrtc;

import android.media.MediaRecorder;

/* JADX INFO: loaded from: classes3.dex */
public interface CameraVideoCapturer extends VideoCapturer {
    @Deprecated
    void addMediaRecorderToCamera(MediaRecorder mediaRecorder, CameraVideoCapturer$MediaRecorderHandler cameraVideoCapturer$MediaRecorderHandler);

    @Deprecated
    void removeMediaRecorderFromCamera(CameraVideoCapturer$MediaRecorderHandler cameraVideoCapturer$MediaRecorderHandler);

    void switchCamera(CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler);

    void switchCamera(CameraVideoCapturer$CameraSwitchHandler cameraVideoCapturer$CameraSwitchHandler, String str);
}
