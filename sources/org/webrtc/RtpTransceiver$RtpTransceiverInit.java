package org.webrtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class RtpTransceiver$RtpTransceiverInit {
    private final RtpTransceiver$RtpTransceiverDirection direction;
    private final List<RtpParameters$Encoding> sendEncodings;
    private final List<String> streamIds;

    public RtpTransceiver$RtpTransceiverInit() {
        this(RtpTransceiver$RtpTransceiverDirection.SEND_RECV);
    }

    @CalledByNative("RtpTransceiverInit")
    public int getDirectionNativeIndex() {
        return this.direction.getNativeIndex();
    }

    @CalledByNative("RtpTransceiverInit")
    public List<RtpParameters$Encoding> getSendEncodings() {
        return new ArrayList(this.sendEncodings);
    }

    @CalledByNative("RtpTransceiverInit")
    public List<String> getStreamIds() {
        return new ArrayList(this.streamIds);
    }

    public RtpTransceiver$RtpTransceiverInit(RtpTransceiver$RtpTransceiverDirection rtpTransceiver$RtpTransceiverDirection) {
        this(rtpTransceiver$RtpTransceiverDirection, Collections.emptyList(), Collections.emptyList());
    }

    public RtpTransceiver$RtpTransceiverInit(RtpTransceiver$RtpTransceiverDirection rtpTransceiver$RtpTransceiverDirection, List<String> list) {
        this(rtpTransceiver$RtpTransceiverDirection, list, Collections.emptyList());
    }

    public RtpTransceiver$RtpTransceiverInit(RtpTransceiver$RtpTransceiverDirection rtpTransceiver$RtpTransceiverDirection, List<String> list, List<RtpParameters$Encoding> list2) {
        this.direction = rtpTransceiver$RtpTransceiverDirection;
        this.streamIds = new ArrayList(list);
        this.sendEncodings = new ArrayList(list2);
    }
}
