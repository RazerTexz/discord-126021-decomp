package h0.c;

import org.webrtc.CalledByNative;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.PeerConnection;
import org.webrtc.RtpTransceiver;

/* JADX INFO: renamed from: h0.c.o0, reason: use source file name */
/* JADX INFO: compiled from: PeerConnection.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class PeerConnection2 {
    @CalledByNative("Observer")
    public static void a(PeerConnection.Observer observer, PeerConnection.PeerConnectionState peerConnectionState) {
    }

    @CalledByNative("Observer")
    public static void b(PeerConnection.Observer observer, CandidatePairChangeEvent candidatePairChangeEvent) {
    }

    @CalledByNative("Observer")
    public static void c(PeerConnection.Observer observer, PeerConnection.IceConnectionState iceConnectionState) {
    }

    @CalledByNative("Observer")
    public static void d(PeerConnection.Observer observer, RtpTransceiver rtpTransceiver) {
    }
}
