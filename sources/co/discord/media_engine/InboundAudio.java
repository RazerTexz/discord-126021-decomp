package co.discord.media_engine;

import a0.a.a.a;
import a0.a.a.b;
import d0.z.d.m;
import java.util.Arrays;

/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundAudio {
    private final InboundBufferStats bufferStats;
    private final InboundFrameOpStats frameOpStats;
    private final double mos;
    private final Integer[] mosBuckets;
    private final int mosCount;
    private final double mosSum;
    private final long packetsLost;
    private final long packetsReceived;

    public InboundAudio(long j, long j2, double d, double d2, int i, Integer[] numArr, InboundBufferStats inboundBufferStats, InboundFrameOpStats inboundFrameOpStats) {
        m.checkNotNullParameter(numArr, "mosBuckets");
        m.checkNotNullParameter(inboundBufferStats, "bufferStats");
        m.checkNotNullParameter(inboundFrameOpStats, "frameOpStats");
        this.packetsReceived = j;
        this.packetsLost = j2;
        this.mos = d;
        this.mosSum = d2;
        this.mosCount = i;
        this.mosBuckets = numArr;
        this.bufferStats = inboundBufferStats;
        this.frameOpStats = inboundFrameOpStats;
    }

    public static /* synthetic */ InboundAudio copy$default(InboundAudio inboundAudio, long j, long j2, double d, double d2, int i, Integer[] numArr, InboundBufferStats inboundBufferStats, InboundFrameOpStats inboundFrameOpStats, int i2, Object obj) {
        return inboundAudio.copy((i2 & 1) != 0 ? inboundAudio.packetsReceived : j, (i2 & 2) != 0 ? inboundAudio.packetsLost : j2, (i2 & 4) != 0 ? inboundAudio.mos : d, (i2 & 8) != 0 ? inboundAudio.mosSum : d2, (i2 & 16) != 0 ? inboundAudio.mosCount : i, (i2 & 32) != 0 ? inboundAudio.mosBuckets : numArr, (i2 & 64) != 0 ? inboundAudio.bufferStats : inboundBufferStats, (i2 & 128) != 0 ? inboundAudio.frameOpStats : inboundFrameOpStats);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getMos() {
        return this.mos;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getMosSum() {
        return this.mosSum;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMosCount() {
        return this.mosCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer[] getMosBuckets() {
        return this.mosBuckets;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final InboundBufferStats getBufferStats() {
        return this.bufferStats;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final InboundFrameOpStats getFrameOpStats() {
        return this.frameOpStats;
    }

    public final InboundAudio copy(long packetsReceived, long packetsLost, double mos, double mosSum, int mosCount, Integer[] mosBuckets, InboundBufferStats bufferStats, InboundFrameOpStats frameOpStats) {
        m.checkNotNullParameter(mosBuckets, "mosBuckets");
        m.checkNotNullParameter(bufferStats, "bufferStats");
        m.checkNotNullParameter(frameOpStats, "frameOpStats");
        return new InboundAudio(packetsReceived, packetsLost, mos, mosSum, mosCount, mosBuckets, bufferStats, frameOpStats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundAudio)) {
            return false;
        }
        InboundAudio inboundAudio = (InboundAudio) other;
        return this.packetsReceived == inboundAudio.packetsReceived && this.packetsLost == inboundAudio.packetsLost && Double.compare(this.mos, inboundAudio.mos) == 0 && Double.compare(this.mosSum, inboundAudio.mosSum) == 0 && this.mosCount == inboundAudio.mosCount && m.areEqual(this.mosBuckets, inboundAudio.mosBuckets) && m.areEqual(this.bufferStats, inboundAudio.bufferStats) && m.areEqual(this.frameOpStats, inboundAudio.frameOpStats);
    }

    public final InboundBufferStats getBufferStats() {
        return this.bufferStats;
    }

    public final InboundFrameOpStats getFrameOpStats() {
        return this.frameOpStats;
    }

    public final double getMos() {
        return this.mos;
    }

    public final Integer[] getMosBuckets() {
        return this.mosBuckets;
    }

    public final int getMosCount() {
        return this.mosCount;
    }

    public final double getMosSum() {
        return this.mosSum;
    }

    public final long getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    public int hashCode() {
        int iA = (((a.a(this.mosSum) + ((a.a(this.mos) + ((b.a(this.packetsLost) + (b.a(this.packetsReceived) * 31)) * 31)) * 31)) * 31) + this.mosCount) * 31;
        Integer[] numArr = this.mosBuckets;
        int iHashCode = (iA + (numArr != null ? Arrays.hashCode(numArr) : 0)) * 31;
        InboundBufferStats inboundBufferStats = this.bufferStats;
        int iHashCode2 = (iHashCode + (inboundBufferStats != null ? inboundBufferStats.hashCode() : 0)) * 31;
        InboundFrameOpStats inboundFrameOpStats = this.frameOpStats;
        return iHashCode2 + (inboundFrameOpStats != null ? inboundFrameOpStats.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("InboundAudio(packetsReceived=");
        sbU.append(this.packetsReceived);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", mos=");
        sbU.append(this.mos);
        sbU.append(", mosSum=");
        sbU.append(this.mosSum);
        sbU.append(", mosCount=");
        sbU.append(this.mosCount);
        sbU.append(", mosBuckets=");
        sbU.append(Arrays.toString(this.mosBuckets));
        sbU.append(", bufferStats=");
        sbU.append(this.bufferStats);
        sbU.append(", frameOpStats=");
        sbU.append(this.frameOpStats);
        sbU.append(")");
        return sbU.toString();
    }
}
