package org.webrtc;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RtpParameters$Codec {
    public Integer clockRate;
    public MediaStreamTrack$MediaType kind;
    public String name;
    public Integer numChannels;
    public Map<String, String> parameters;
    public int payloadType;

    @CalledByNative("Codec")
    public RtpParameters$Codec(int i, String str, MediaStreamTrack$MediaType mediaStreamTrack$MediaType, Integer num, Integer num2, Map<String, String> map) {
        this.payloadType = i;
        this.name = str;
        this.kind = mediaStreamTrack$MediaType;
        this.clockRate = num;
        this.numChannels = num2;
        this.parameters = map;
    }

    @CalledByNative("Codec")
    public Integer getClockRate() {
        return this.clockRate;
    }

    @CalledByNative("Codec")
    public MediaStreamTrack$MediaType getKind() {
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
