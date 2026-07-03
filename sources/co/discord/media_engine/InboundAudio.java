package co.discord.media_engine;

import java.util.Arrays;
import p001a0.p002a.p003a.C0001a;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(numArr, "mosBuckets");
        C12238m.checkNotNullParameter(inboundBufferStats, "bufferStats");
        C12238m.checkNotNullParameter(inboundFrameOpStats, "frameOpStats");
        this.packetsReceived = j;
        this.packetsLost = j2;
        this.mos = d;
        this.mosSum = d2;
        this.mosCount = i;
        this.mosBuckets = numArr;
        this.bufferStats = inboundBufferStats;
        this.frameOpStats = inboundFrameOpStats;
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
        C12238m.checkNotNullParameter(mosBuckets, "mosBuckets");
        C12238m.checkNotNullParameter(bufferStats, "bufferStats");
        C12238m.checkNotNullParameter(frameOpStats, "frameOpStats");
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
        return this.packetsReceived == inboundAudio.packetsReceived && this.packetsLost == inboundAudio.packetsLost && Double.compare(this.mos, inboundAudio.mos) == 0 && Double.compare(this.mosSum, inboundAudio.mosSum) == 0 && this.mosCount == inboundAudio.mosCount && C12238m.areEqual(this.mosBuckets, inboundAudio.mosBuckets) && C12238m.areEqual(this.bufferStats, inboundAudio.bufferStats) && C12238m.areEqual(this.frameOpStats, inboundAudio.frameOpStats);
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
        int iM2a = (((C0001a.m2a(this.mosSum) + ((C0001a.m2a(this.mos) + ((C0002b.m3a(this.packetsLost) + (C0002b.m3a(this.packetsReceived) * 31)) * 31)) * 31)) * 31) + this.mosCount) * 31;
        Integer[] numArr = this.mosBuckets;
        int iHashCode = (iM2a + (numArr != null ? Arrays.hashCode(numArr) : 0)) * 31;
        InboundBufferStats inboundBufferStats = this.bufferStats;
        int iHashCode2 = (iHashCode + (inboundBufferStats != null ? inboundBufferStats.hashCode() : 0)) * 31;
        InboundFrameOpStats inboundFrameOpStats = this.frameOpStats;
        return iHashCode2 + (inboundFrameOpStats != null ? inboundFrameOpStats.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InboundAudio(packetsReceived=");
        sbM833U.append(this.packetsReceived);
        sbM833U.append(", packetsLost=");
        sbM833U.append(this.packetsLost);
        sbM833U.append(", mos=");
        sbM833U.append(this.mos);
        sbM833U.append(", mosSum=");
        sbM833U.append(this.mosSum);
        sbM833U.append(", mosCount=");
        sbM833U.append(this.mosCount);
        sbM833U.append(", mosBuckets=");
        sbM833U.append(Arrays.toString(this.mosBuckets));
        sbM833U.append(", bufferStats=");
        sbM833U.append(this.bufferStats);
        sbM833U.append(", frameOpStats=");
        sbM833U.append(this.frameOpStats);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
