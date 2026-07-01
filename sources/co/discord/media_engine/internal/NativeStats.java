package co.discord.media_engine.internal;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class NativeStats {
    private final Inbound[] inbound;
    private final Outbound outbound;
    private final Screenshare screenshare;
    private final Transport transport;

    public NativeStats(Transport transport, Outbound outbound, Screenshare screenshare, Inbound[] inboundArr) {
        this.transport = transport;
        this.outbound = outbound;
        this.screenshare = screenshare;
        this.inbound = inboundArr;
    }

    public static /* synthetic */ NativeStats copy$default(NativeStats nativeStats, Transport transport, Outbound outbound, Screenshare screenshare, Inbound[] inboundArr, int i, Object obj) {
        if ((i & 1) != 0) {
            transport = nativeStats.transport;
        }
        if ((i & 2) != 0) {
            outbound = nativeStats.outbound;
        }
        if ((i & 4) != 0) {
            screenshare = nativeStats.screenshare;
        }
        if ((i & 8) != 0) {
            inboundArr = nativeStats.inbound;
        }
        return nativeStats.copy(transport, outbound, screenshare, inboundArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Transport getTransport() {
        return this.transport;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Outbound getOutbound() {
        return this.outbound;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Screenshare getScreenshare() {
        return this.screenshare;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Inbound[] getInbound() {
        return this.inbound;
    }

    public final NativeStats copy(Transport transport, Outbound outbound, Screenshare screenshare, Inbound[] inbound) {
        return new NativeStats(transport, outbound, screenshare, inbound);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeStats)) {
            return false;
        }
        NativeStats nativeStats = (NativeStats) other;
        return Intrinsics3.areEqual(this.transport, nativeStats.transport) && Intrinsics3.areEqual(this.outbound, nativeStats.outbound) && Intrinsics3.areEqual(this.screenshare, nativeStats.screenshare) && Intrinsics3.areEqual(this.inbound, nativeStats.inbound);
    }

    public final Inbound[] getInbound() {
        return this.inbound;
    }

    public final Outbound getOutbound() {
        return this.outbound;
    }

    public final Screenshare getScreenshare() {
        return this.screenshare;
    }

    public final Transport getTransport() {
        return this.transport;
    }

    public int hashCode() {
        Transport transport = this.transport;
        int iHashCode = (transport != null ? transport.hashCode() : 0) * 31;
        Outbound outbound = this.outbound;
        int iHashCode2 = (iHashCode + (outbound != null ? outbound.hashCode() : 0)) * 31;
        Screenshare screenshare = this.screenshare;
        int iHashCode3 = (iHashCode2 + (screenshare != null ? screenshare.hashCode() : 0)) * 31;
        Inbound[] inboundArr = this.inbound;
        return iHashCode3 + (inboundArr != null ? Arrays.hashCode(inboundArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("NativeStats(transport=");
        sbU.append(this.transport);
        sbU.append(", outbound=");
        sbU.append(this.outbound);
        sbU.append(", screenshare=");
        sbU.append(this.screenshare);
        sbU.append(", inbound=");
        sbU.append(Arrays.toString(this.inbound));
        sbU.append(")");
        return sbU.toString();
    }
}
