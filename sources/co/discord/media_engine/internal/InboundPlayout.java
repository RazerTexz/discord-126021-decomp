package co.discord.media_engine.internal;

import b.d.b.a.outline;
import co.discord.media_engine.PlayoutMetric;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundPlayout {
    private final PlayoutMetric audioCaptureOverruns;
    private final PlayoutMetric audioJitterBuffer;
    private final PlayoutMetric audioJitterDelay;
    private final PlayoutMetric audioJitterTarget;
    private final PlayoutMetric audioPlayoutUnderruns;
    private final PlayoutMetric relativePlayoutDelay;
    private final PlayoutMetric relativeReceptionDelay;
    private final PlayoutMetric videoJitterBuffer;
    private final PlayoutMetric videoJitterDelay;
    private final PlayoutMetric videoJitterTarget;

    public InboundPlayout(PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, PlayoutMetric playoutMetric6, PlayoutMetric playoutMetric7, PlayoutMetric playoutMetric8, PlayoutMetric playoutMetric9, PlayoutMetric playoutMetric10) {
        Intrinsics3.checkNotNullParameter(playoutMetric, "audioJitterBuffer");
        Intrinsics3.checkNotNullParameter(playoutMetric2, "audioJitterDelay");
        Intrinsics3.checkNotNullParameter(playoutMetric3, "audioJitterTarget");
        Intrinsics3.checkNotNullParameter(playoutMetric4, "audioPlayoutUnderruns");
        Intrinsics3.checkNotNullParameter(playoutMetric5, "audioCaptureOverruns");
        Intrinsics3.checkNotNullParameter(playoutMetric6, "videoJitterBuffer");
        Intrinsics3.checkNotNullParameter(playoutMetric7, "videoJitterDelay");
        Intrinsics3.checkNotNullParameter(playoutMetric8, "videoJitterTarget");
        Intrinsics3.checkNotNullParameter(playoutMetric9, "relativeReceptionDelay");
        Intrinsics3.checkNotNullParameter(playoutMetric10, "relativePlayoutDelay");
        this.audioJitterBuffer = playoutMetric;
        this.audioJitterDelay = playoutMetric2;
        this.audioJitterTarget = playoutMetric3;
        this.audioPlayoutUnderruns = playoutMetric4;
        this.audioCaptureOverruns = playoutMetric5;
        this.videoJitterBuffer = playoutMetric6;
        this.videoJitterDelay = playoutMetric7;
        this.videoJitterTarget = playoutMetric8;
        this.relativeReceptionDelay = playoutMetric9;
        this.relativePlayoutDelay = playoutMetric10;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PlayoutMetric getAudioCaptureOverruns() {
        return this.audioCaptureOverruns;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PlayoutMetric getVideoJitterBuffer() {
        return this.videoJitterBuffer;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PlayoutMetric getVideoJitterDelay() {
        return this.videoJitterDelay;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final PlayoutMetric getVideoJitterTarget() {
        return this.videoJitterTarget;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    public final InboundPlayout copy(PlayoutMetric audioJitterBuffer, PlayoutMetric audioJitterDelay, PlayoutMetric audioJitterTarget, PlayoutMetric audioPlayoutUnderruns, PlayoutMetric audioCaptureOverruns, PlayoutMetric videoJitterBuffer, PlayoutMetric videoJitterDelay, PlayoutMetric videoJitterTarget, PlayoutMetric relativeReceptionDelay, PlayoutMetric relativePlayoutDelay) {
        Intrinsics3.checkNotNullParameter(audioJitterBuffer, "audioJitterBuffer");
        Intrinsics3.checkNotNullParameter(audioJitterDelay, "audioJitterDelay");
        Intrinsics3.checkNotNullParameter(audioJitterTarget, "audioJitterTarget");
        Intrinsics3.checkNotNullParameter(audioPlayoutUnderruns, "audioPlayoutUnderruns");
        Intrinsics3.checkNotNullParameter(audioCaptureOverruns, "audioCaptureOverruns");
        Intrinsics3.checkNotNullParameter(videoJitterBuffer, "videoJitterBuffer");
        Intrinsics3.checkNotNullParameter(videoJitterDelay, "videoJitterDelay");
        Intrinsics3.checkNotNullParameter(videoJitterTarget, "videoJitterTarget");
        Intrinsics3.checkNotNullParameter(relativeReceptionDelay, "relativeReceptionDelay");
        Intrinsics3.checkNotNullParameter(relativePlayoutDelay, "relativePlayoutDelay");
        return new InboundPlayout(audioJitterBuffer, audioJitterDelay, audioJitterTarget, audioPlayoutUnderruns, audioCaptureOverruns, videoJitterBuffer, videoJitterDelay, videoJitterTarget, relativeReceptionDelay, relativePlayoutDelay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundPlayout)) {
            return false;
        }
        InboundPlayout inboundPlayout = (InboundPlayout) other;
        return Intrinsics3.areEqual(this.audioJitterBuffer, inboundPlayout.audioJitterBuffer) && Intrinsics3.areEqual(this.audioJitterDelay, inboundPlayout.audioJitterDelay) && Intrinsics3.areEqual(this.audioJitterTarget, inboundPlayout.audioJitterTarget) && Intrinsics3.areEqual(this.audioPlayoutUnderruns, inboundPlayout.audioPlayoutUnderruns) && Intrinsics3.areEqual(this.audioCaptureOverruns, inboundPlayout.audioCaptureOverruns) && Intrinsics3.areEqual(this.videoJitterBuffer, inboundPlayout.videoJitterBuffer) && Intrinsics3.areEqual(this.videoJitterDelay, inboundPlayout.videoJitterDelay) && Intrinsics3.areEqual(this.videoJitterTarget, inboundPlayout.videoJitterTarget) && Intrinsics3.areEqual(this.relativeReceptionDelay, inboundPlayout.relativeReceptionDelay) && Intrinsics3.areEqual(this.relativePlayoutDelay, inboundPlayout.relativePlayoutDelay);
    }

    public final PlayoutMetric getAudioCaptureOverruns() {
        return this.audioCaptureOverruns;
    }

    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    public final PlayoutMetric getVideoJitterBuffer() {
        return this.videoJitterBuffer;
    }

    public final PlayoutMetric getVideoJitterDelay() {
        return this.videoJitterDelay;
    }

    public final PlayoutMetric getVideoJitterTarget() {
        return this.videoJitterTarget;
    }

    public int hashCode() {
        PlayoutMetric playoutMetric = this.audioJitterBuffer;
        int iHashCode = (playoutMetric != null ? playoutMetric.hashCode() : 0) * 31;
        PlayoutMetric playoutMetric2 = this.audioJitterDelay;
        int iHashCode2 = (iHashCode + (playoutMetric2 != null ? playoutMetric2.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric3 = this.audioJitterTarget;
        int iHashCode3 = (iHashCode2 + (playoutMetric3 != null ? playoutMetric3.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric4 = this.audioPlayoutUnderruns;
        int iHashCode4 = (iHashCode3 + (playoutMetric4 != null ? playoutMetric4.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric5 = this.audioCaptureOverruns;
        int iHashCode5 = (iHashCode4 + (playoutMetric5 != null ? playoutMetric5.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric6 = this.videoJitterBuffer;
        int iHashCode6 = (iHashCode5 + (playoutMetric6 != null ? playoutMetric6.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric7 = this.videoJitterDelay;
        int iHashCode7 = (iHashCode6 + (playoutMetric7 != null ? playoutMetric7.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric8 = this.videoJitterTarget;
        int iHashCode8 = (iHashCode7 + (playoutMetric8 != null ? playoutMetric8.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric9 = this.relativeReceptionDelay;
        int iHashCode9 = (iHashCode8 + (playoutMetric9 != null ? playoutMetric9.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric10 = this.relativePlayoutDelay;
        return iHashCode9 + (playoutMetric10 != null ? playoutMetric10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundPlayout(audioJitterBuffer=");
        sbU.append(this.audioJitterBuffer);
        sbU.append(", audioJitterDelay=");
        sbU.append(this.audioJitterDelay);
        sbU.append(", audioJitterTarget=");
        sbU.append(this.audioJitterTarget);
        sbU.append(", audioPlayoutUnderruns=");
        sbU.append(this.audioPlayoutUnderruns);
        sbU.append(", audioCaptureOverruns=");
        sbU.append(this.audioCaptureOverruns);
        sbU.append(", videoJitterBuffer=");
        sbU.append(this.videoJitterBuffer);
        sbU.append(", videoJitterDelay=");
        sbU.append(this.videoJitterDelay);
        sbU.append(", videoJitterTarget=");
        sbU.append(this.videoJitterTarget);
        sbU.append(", relativeReceptionDelay=");
        sbU.append(this.relativeReceptionDelay);
        sbU.append(", relativePlayoutDelay=");
        sbU.append(this.relativePlayoutDelay);
        sbU.append(")");
        return sbU.toString();
    }
}
