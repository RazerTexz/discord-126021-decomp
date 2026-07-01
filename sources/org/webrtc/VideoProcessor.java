package org.webrtc;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface VideoProcessor extends CapturerObserver {
    void onFrameCaptured(VideoFrame videoFrame, VideoProcessor$FrameAdaptationParameters videoProcessor$FrameAdaptationParameters);

    void setSink(@Nullable VideoSink videoSink);
}
