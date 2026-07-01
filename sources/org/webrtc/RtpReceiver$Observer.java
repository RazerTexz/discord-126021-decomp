package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface RtpReceiver$Observer {
    @CalledByNative("Observer")
    void onFirstPacketReceived(MediaStreamTrack$MediaType mediaStreamTrack$MediaType);
}
