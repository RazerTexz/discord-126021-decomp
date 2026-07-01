package org.webrtc;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RtpParameters {
    public final List<RtpParameters$Codec> codecs;

    @Nullable
    public RtpParameters$DegradationPreference degradationPreference;
    public final List<RtpParameters$Encoding> encodings;
    private final List<RtpParameters$HeaderExtension> headerExtensions;
    private final RtpParameters$Rtcp rtcp;
    public final String transactionId;

    @CalledByNative
    public RtpParameters(String str, RtpParameters$DegradationPreference rtpParameters$DegradationPreference, RtpParameters$Rtcp rtpParameters$Rtcp, List<RtpParameters$HeaderExtension> list, List<RtpParameters$Encoding> list2, List<RtpParameters$Codec> list3) {
        this.transactionId = str;
        this.degradationPreference = rtpParameters$DegradationPreference;
        this.rtcp = rtpParameters$Rtcp;
        this.headerExtensions = list;
        this.encodings = list2;
        this.codecs = list3;
    }

    @CalledByNative
    public List<RtpParameters$Codec> getCodecs() {
        return this.codecs;
    }

    @CalledByNative
    public RtpParameters$DegradationPreference getDegradationPreference() {
        return this.degradationPreference;
    }

    @CalledByNative
    public List<RtpParameters$Encoding> getEncodings() {
        return this.encodings;
    }

    @CalledByNative
    public List<RtpParameters$HeaderExtension> getHeaderExtensions() {
        return this.headerExtensions;
    }

    @CalledByNative
    public RtpParameters$Rtcp getRtcp() {
        return this.rtcp;
    }

    @CalledByNative
    public String getTransactionId() {
        return this.transactionId;
    }
}
