package co.discord.media_engine;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Stats {
    private final Map<String, InboundRtpAudio> inboundRtpAudio;
    private final Map<String, InboundRtpVideo> inboundRtpVideo;
    private final OutboundRtpAudio outboundRtpAudio;
    private final OutboundRtpVideo outboundRtpVideo;
    private final Transport transport;

    public Stats(Transport transport, OutboundRtpAudio outboundRtpAudio, OutboundRtpVideo outboundRtpVideo, Map<String, InboundRtpAudio> map, Map<String, InboundRtpVideo> map2) {
        Intrinsics3.checkNotNullParameter(map, "inboundRtpAudio");
        Intrinsics3.checkNotNullParameter(map2, "inboundRtpVideo");
        this.transport = transport;
        this.outboundRtpAudio = outboundRtpAudio;
        this.outboundRtpVideo = outboundRtpVideo;
        this.inboundRtpAudio = map;
        this.inboundRtpVideo = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Stats copy$default(Stats stats, Transport transport, OutboundRtpAudio outboundRtpAudio, OutboundRtpVideo outboundRtpVideo, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            transport = stats.transport;
        }
        if ((i & 2) != 0) {
            outboundRtpAudio = stats.outboundRtpAudio;
        }
        OutboundRtpAudio outboundRtpAudio2 = outboundRtpAudio;
        if ((i & 4) != 0) {
            outboundRtpVideo = stats.outboundRtpVideo;
        }
        OutboundRtpVideo outboundRtpVideo2 = outboundRtpVideo;
        if ((i & 8) != 0) {
            map = stats.inboundRtpAudio;
        }
        Map map3 = map;
        if ((i & 16) != 0) {
            map2 = stats.inboundRtpVideo;
        }
        return stats.copy(transport, outboundRtpAudio2, outboundRtpVideo2, map3, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Transport getTransport() {
        return this.transport;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OutboundRtpAudio getOutboundRtpAudio() {
        return this.outboundRtpAudio;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OutboundRtpVideo getOutboundRtpVideo() {
        return this.outboundRtpVideo;
    }

    public final Map<String, InboundRtpAudio> component4() {
        return this.inboundRtpAudio;
    }

    public final Map<String, InboundRtpVideo> component5() {
        return this.inboundRtpVideo;
    }

    public final Stats copy(Transport transport, OutboundRtpAudio outboundRtpAudio, OutboundRtpVideo outboundRtpVideo, Map<String, InboundRtpAudio> inboundRtpAudio, Map<String, InboundRtpVideo> inboundRtpVideo) {
        Intrinsics3.checkNotNullParameter(inboundRtpAudio, "inboundRtpAudio");
        Intrinsics3.checkNotNullParameter(inboundRtpVideo, "inboundRtpVideo");
        return new Stats(transport, outboundRtpAudio, outboundRtpVideo, inboundRtpAudio, inboundRtpVideo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stats)) {
            return false;
        }
        Stats stats = (Stats) other;
        return Intrinsics3.areEqual(this.transport, stats.transport) && Intrinsics3.areEqual(this.outboundRtpAudio, stats.outboundRtpAudio) && Intrinsics3.areEqual(this.outboundRtpVideo, stats.outboundRtpVideo) && Intrinsics3.areEqual(this.inboundRtpAudio, stats.inboundRtpAudio) && Intrinsics3.areEqual(this.inboundRtpVideo, stats.inboundRtpVideo);
    }

    public final Map<String, InboundRtpAudio> getInboundRtpAudio() {
        return this.inboundRtpAudio;
    }

    public final Map<String, InboundRtpVideo> getInboundRtpVideo() {
        return this.inboundRtpVideo;
    }

    public final OutboundRtpAudio getOutboundRtpAudio() {
        return this.outboundRtpAudio;
    }

    public final OutboundRtpVideo getOutboundRtpVideo() {
        return this.outboundRtpVideo;
    }

    public final Transport getTransport() {
        return this.transport;
    }

    public int hashCode() {
        Transport transport = this.transport;
        int iHashCode = (transport != null ? transport.hashCode() : 0) * 31;
        OutboundRtpAudio outboundRtpAudio = this.outboundRtpAudio;
        int iHashCode2 = (iHashCode + (outboundRtpAudio != null ? outboundRtpAudio.hashCode() : 0)) * 31;
        OutboundRtpVideo outboundRtpVideo = this.outboundRtpVideo;
        int iHashCode3 = (iHashCode2 + (outboundRtpVideo != null ? outboundRtpVideo.hashCode() : 0)) * 31;
        Map<String, InboundRtpAudio> map = this.inboundRtpAudio;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, InboundRtpVideo> map2 = this.inboundRtpVideo;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Stats(transport=");
        sbU.append(this.transport);
        sbU.append(", outboundRtpAudio=");
        sbU.append(this.outboundRtpAudio);
        sbU.append(", outboundRtpVideo=");
        sbU.append(this.outboundRtpVideo);
        sbU.append(", inboundRtpAudio=");
        sbU.append(this.inboundRtpAudio);
        sbU.append(", inboundRtpVideo=");
        return outline.M(sbU, this.inboundRtpVideo, ")");
    }
}
