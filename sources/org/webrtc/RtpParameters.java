package org.webrtc;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: loaded from: classes3.dex */
public class RtpParameters {
    public final List<Codec> codecs;

    @Nullable
    public DegradationPreference degradationPreference;
    public final List<Encoding> encodings;
    private final List<HeaderExtension> headerExtensions;
    private final Rtcp rtcp;
    public final String transactionId;

    public static class Codec {
        public Integer clockRate;
        public MediaStreamTrack.MediaType kind;
        public String name;
        public Integer numChannels;
        public Map<String, String> parameters;
        public int payloadType;

        @CalledByNative("Codec")
        public Codec(int i, String str, MediaStreamTrack.MediaType mediaType, Integer num, Integer num2, Map<String, String> map) {
            this.payloadType = i;
            this.name = str;
            this.kind = mediaType;
            this.clockRate = num;
            this.numChannels = num2;
            this.parameters = map;
        }

        @CalledByNative("Codec")
        public Integer getClockRate() {
            return this.clockRate;
        }

        @CalledByNative("Codec")
        public MediaStreamTrack.MediaType getKind() {
            return this.kind;
        }

        @CalledByNative("Codec")
        public String getName() {
            return this.name;
        }

        @CalledByNative("Codec")
        public Integer getNumChannels() {
            return this.numChannels;
        }

        @CalledByNative("Codec")
        public Map getParameters() {
            return this.parameters;
        }

        @CalledByNative("Codec")
        public int getPayloadType() {
            return this.payloadType;
        }
    }

    public enum DegradationPreference {
        DISABLED,
        MAINTAIN_FRAMERATE,
        MAINTAIN_RESOLUTION,
        BALANCED;

        @CalledByNative("DegradationPreference")
        public static DegradationPreference fromNativeIndex(int i) {
            return values()[i];
        }
    }

    public static class HeaderExtension {
        private final boolean encrypted;

        /* JADX INFO: renamed from: id */
        private final int f27615id;
        private final String uri;

        @CalledByNative("HeaderExtension")
        public HeaderExtension(String str, int i, boolean z2) {
            this.uri = str;
            this.f27615id = i;
            this.encrypted = z2;
        }

        @CalledByNative("HeaderExtension")
        public boolean getEncrypted() {
            return this.encrypted;
        }

        @CalledByNative("HeaderExtension")
        public int getId() {
            return this.f27615id;
        }

        @CalledByNative("HeaderExtension")
        public String getUri() {
            return this.uri;
        }
    }

    public static class Rtcp {
        private final String cname;
        private final boolean reducedSize;

        @CalledByNative("Rtcp")
        public Rtcp(String str, boolean z2) {
            this.cname = str;
            this.reducedSize = z2;
        }

        @CalledByNative("Rtcp")
        public String getCname() {
            return this.cname;
        }

        @CalledByNative("Rtcp")
        public boolean getReducedSize() {
            return this.reducedSize;
        }
    }

    @CalledByNative
    public RtpParameters(String str, DegradationPreference degradationPreference, Rtcp rtcp, List<HeaderExtension> list, List<Encoding> list2, List<Codec> list3) {
        this.transactionId = str;
        this.degradationPreference = degradationPreference;
        this.rtcp = rtcp;
        this.headerExtensions = list;
        this.encodings = list2;
        this.codecs = list3;
    }

    @CalledByNative
    public List<Codec> getCodecs() {
        return this.codecs;
    }

    @CalledByNative
    public DegradationPreference getDegradationPreference() {
        return this.degradationPreference;
    }

    @CalledByNative
    public List<Encoding> getEncodings() {
        return this.encodings;
    }

    @CalledByNative
    public List<HeaderExtension> getHeaderExtensions() {
        return this.headerExtensions;
    }

    @CalledByNative
    public Rtcp getRtcp() {
        return this.rtcp;
    }

    @CalledByNative
    public String getTransactionId() {
        return this.transactionId;
    }

    public static class Encoding {
        public boolean active;
        public double bitratePriority;

        @Nullable
        public Integer maxBitrateBps;

        @Nullable
        public Integer maxFramerate;

        @Nullable
        public Integer minBitrateBps;
        public int networkPriority;

        @Nullable
        public Integer numTemporalLayers;

        @Nullable
        public String rid;

        @Nullable
        public Double scaleResolutionDownBy;
        public Long ssrc;

        public Encoding(String str, boolean z2, Double d) {
            this.active = true;
            this.bitratePriority = 1.0d;
            this.networkPriority = 1;
            this.rid = str;
            this.active = z2;
            this.scaleResolutionDownBy = d;
        }

        @CalledByNative("Encoding")
        public boolean getActive() {
            return this.active;
        }

        @CalledByNative("Encoding")
        public double getBitratePriority() {
            return this.bitratePriority;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getMaxBitrateBps() {
            return this.maxBitrateBps;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getMaxFramerate() {
            return this.maxFramerate;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getMinBitrateBps() {
            return this.minBitrateBps;
        }

        @CalledByNative("Encoding")
        public int getNetworkPriority() {
            return this.networkPriority;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getNumTemporalLayers() {
            return this.numTemporalLayers;
        }

        @Nullable
        @CalledByNative("Encoding")
        public String getRid() {
            return this.rid;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Double getScaleResolutionDownBy() {
            return this.scaleResolutionDownBy;
        }

        @CalledByNative("Encoding")
        public Long getSsrc() {
            return this.ssrc;
        }

        @CalledByNative("Encoding")
        public Encoding(String str, boolean z2, double d, int i, Integer num, Integer num2, Integer num3, Integer num4, Double d2, Long l) {
            this.active = true;
            this.bitratePriority = 1.0d;
            this.networkPriority = 1;
            this.rid = str;
            this.active = z2;
            this.bitratePriority = d;
            this.networkPriority = i;
            this.maxBitrateBps = num;
            this.minBitrateBps = num2;
            this.maxFramerate = num3;
            this.numTemporalLayers = num4;
            this.scaleResolutionDownBy = d2;
            this.ssrc = l;
        }
    }
}
