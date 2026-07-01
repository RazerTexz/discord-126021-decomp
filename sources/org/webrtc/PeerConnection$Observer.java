package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface PeerConnection$Observer {
    @CalledByNative("Observer")
    void onAddStream(MediaStream mediaStream);

    @CalledByNative("Observer")
    void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr);

    @CalledByNative("Observer")
    void onConnectionChange(PeerConnection$PeerConnectionState peerConnection$PeerConnectionState);

    @CalledByNative("Observer")
    void onDataChannel(DataChannel dataChannel);

    @CalledByNative("Observer")
    void onIceCandidate(IceCandidate iceCandidate);

    @CalledByNative("Observer")
    void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);

    @CalledByNative("Observer")
    void onIceConnectionChange(PeerConnection$IceConnectionState peerConnection$IceConnectionState);

    @CalledByNative("Observer")
    void onIceConnectionReceivingChange(boolean z2);

    @CalledByNative("Observer")
    void onIceGatheringChange(PeerConnection$IceGatheringState peerConnection$IceGatheringState);

    @CalledByNative("Observer")
    void onRemoveStream(MediaStream mediaStream);

    @CalledByNative("Observer")
    void onRenegotiationNeeded();

    @CalledByNative("Observer")
    void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent);

    @CalledByNative("Observer")
    void onSignalingChange(PeerConnection$SignalingState peerConnection$SignalingState);

    @CalledByNative("Observer")
    void onStandardizedIceConnectionChange(PeerConnection$IceConnectionState peerConnection$IceConnectionState);

    @CalledByNative("Observer")
    void onTrack(RtpTransceiver rtpTransceiver);
}
