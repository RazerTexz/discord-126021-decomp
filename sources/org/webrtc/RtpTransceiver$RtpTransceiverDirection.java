package org.webrtc;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public enum RtpTransceiver$RtpTransceiverDirection {
    SEND_RECV(0),
    SEND_ONLY(1),
    RECV_ONLY(2),
    INACTIVE(3);

    private final int nativeIndex;

    RtpTransceiver$RtpTransceiverDirection(int i) {
        this.nativeIndex = i;
    }

    @CalledByNative("RtpTransceiverDirection")
    public static RtpTransceiver$RtpTransceiverDirection fromNativeIndex(int i) {
        RtpTransceiver$RtpTransceiverDirection[] rtpTransceiver$RtpTransceiverDirectionArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            RtpTransceiver$RtpTransceiverDirection rtpTransceiver$RtpTransceiverDirection = rtpTransceiver$RtpTransceiverDirectionArrValues[i2];
            if (rtpTransceiver$RtpTransceiverDirection.getNativeIndex() == i) {
                return rtpTransceiver$RtpTransceiverDirection;
            }
        }
        throw new IllegalArgumentException(a.q("Uknown native RtpTransceiverDirection type", i));
    }

    @CalledByNative("RtpTransceiverDirection")
    public int getNativeIndex() {
        return this.nativeIndex;
    }
}
