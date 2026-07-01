package h0.c;

import org.webrtc.CalledByNative;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.PeerConnection$IceConnectionState;
import org.webrtc.PeerConnection$Observer;
import org.webrtc.PeerConnection$PeerConnectionState;
import org.webrtc.RtpTransceiver;

/* JADX INFO: compiled from: PeerConnection.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o0 {
    @CalledByNative("Observer")
    public static void a(PeerConnection$Observer peerConnection$Observer, PeerConnection$PeerConnectionState peerConnection$PeerConnectionState) {
    }

    @CalledByNative("Observer")
    public static void b(PeerConnection$Observer peerConnection$Observer, CandidatePairChangeEvent candidatePairChangeEvent) {
    }

    @CalledByNative("Observer")
    public static void c(PeerConnection$Observer peerConnection$Observer, PeerConnection$IceConnectionState peerConnection$IceConnectionState) {
    }

    @CalledByNative("Observer")
    public static void d(PeerConnection$Observer peerConnection$Observer, RtpTransceiver rtpTransceiver) {
    }
}
