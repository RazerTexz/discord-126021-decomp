package co.discord.media_engine;

import a0.a.a.a;
import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;

/* JADX INFO: renamed from: co.discord.media_engine.InboundAudio, reason: use source file name */
/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VoiceQuality3 {
    private final VoiceQuality4 bufferStats;
    private final VoiceQuality5 frameOpStats;
    private final double mos;
    private final Integer[] mosBuckets;
    private final int mosCount;
    private final double mosSum;
    private final long packetsLost;
    private final long packetsReceived;

    public VoiceQuality3(long j, long j2, double d, double d2, int i, Integer[] numArr, VoiceQuality4 voiceQuality4, VoiceQuality5 voiceQuality5) {
        Intrinsics3.checkNotNullParameter(numArr, "mosBuckets");
        Intrinsics3.checkNotNullParameter(voiceQuality4, "bufferStats");
        Intrinsics3.checkNotNullParameter(voiceQuality5, "frameOpStats");
        this.packetsReceived = j;
        this.packetsLost = j2;
        this.mos = d;
        this.mosSum = d2;
        this.mosCount = i;
        this.mosBuckets = numArr;
        this.bufferStats = voiceQuality4;
        this.frameOpStats = voiceQuality5;
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
    public final VoiceQuality4 getBufferStats() {
        return this.bufferStats;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final VoiceQuality5 getFrameOpStats() {
        return this.frameOpStats;
    }

    public final VoiceQuality3 copy(long packetsReceived, long packetsLost, double mos, double mosSum, int mosCount, Integer[] mosBuckets, VoiceQuality4 bufferStats, VoiceQuality5 frameOpStats) {
        Intrinsics3.checkNotNullParameter(mosBuckets, "mosBuckets");
        Intrinsics3.checkNotNullParameter(bufferStats, "bufferStats");
        Intrinsics3.checkNotNullParameter(frameOpStats, "frameOpStats");
        return new VoiceQuality3(packetsReceived, packetsLost, mos, mosSum, mosCount, mosBuckets, bufferStats, frameOpStats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality3)) {
            return false;
        }
        VoiceQuality3 voiceQuality3 = (VoiceQuality3) other;
        return this.packetsReceived == voiceQuality3.packetsReceived && this.packetsLost == voiceQuality3.packetsLost && Double.compare(this.mos, voiceQuality3.mos) == 0 && Double.compare(this.mosSum, voiceQuality3.mosSum) == 0 && this.mosCount == voiceQuality3.mosCount && Intrinsics3.areEqual(this.mosBuckets, voiceQuality3.mosBuckets) && Intrinsics3.areEqual(this.bufferStats, voiceQuality3.bufferStats) && Intrinsics3.areEqual(this.frameOpStats, voiceQuality3.frameOpStats);
    }

    public final VoiceQuality4 getBufferStats() {
        return this.bufferStats;
    }

    public final VoiceQuality5 getFrameOpStats() {
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
        VoiceQuality4 voiceQuality4 = this.bufferStats;
        int iHashCode2 = (iHashCode + (voiceQuality4 != null ? voiceQuality4.hashCode() : 0)) * 31;
        VoiceQuality5 voiceQuality5 = this.frameOpStats;
        return iHashCode2 + (voiceQuality5 != null ? voiceQuality5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundAudio(packetsReceived=");
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
