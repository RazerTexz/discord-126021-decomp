package co.discord.media_engine.internal;

import co.discord.media_engine.PlayoutMetric;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(playoutMetric, "audioJitterBuffer");
        C12238m.checkNotNullParameter(playoutMetric2, "audioJitterDelay");
        C12238m.checkNotNullParameter(playoutMetric3, "audioJitterTarget");
        C12238m.checkNotNullParameter(playoutMetric4, "audioPlayoutUnderruns");
        C12238m.checkNotNullParameter(playoutMetric5, "audioCaptureOverruns");
        C12238m.checkNotNullParameter(playoutMetric6, "videoJitterBuffer");
        C12238m.checkNotNullParameter(playoutMetric7, "videoJitterDelay");
        C12238m.checkNotNullParameter(playoutMetric8, "videoJitterTarget");
        C12238m.checkNotNullParameter(playoutMetric9, "relativeReceptionDelay");
        C12238m.checkNotNullParameter(playoutMetric10, "relativePlayoutDelay");
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
        C12238m.checkNotNullParameter(audioJitterBuffer, "audioJitterBuffer");
        C12238m.checkNotNullParameter(audioJitterDelay, "audioJitterDelay");
        C12238m.checkNotNullParameter(audioJitterTarget, "audioJitterTarget");
        C12238m.checkNotNullParameter(audioPlayoutUnderruns, "audioPlayoutUnderruns");
        C12238m.checkNotNullParameter(audioCaptureOverruns, "audioCaptureOverruns");
        C12238m.checkNotNullParameter(videoJitterBuffer, "videoJitterBuffer");
        C12238m.checkNotNullParameter(videoJitterDelay, "videoJitterDelay");
        C12238m.checkNotNullParameter(videoJitterTarget, "videoJitterTarget");
        C12238m.checkNotNullParameter(relativeReceptionDelay, "relativeReceptionDelay");
        C12238m.checkNotNullParameter(relativePlayoutDelay, "relativePlayoutDelay");
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
        return C12238m.areEqual(this.audioJitterBuffer, inboundPlayout.audioJitterBuffer) && C12238m.areEqual(this.audioJitterDelay, inboundPlayout.audioJitterDelay) && C12238m.areEqual(this.audioJitterTarget, inboundPlayout.audioJitterTarget) && C12238m.areEqual(this.audioPlayoutUnderruns, inboundPlayout.audioPlayoutUnderruns) && C12238m.areEqual(this.audioCaptureOverruns, inboundPlayout.audioCaptureOverruns) && C12238m.areEqual(this.videoJitterBuffer, inboundPlayout.videoJitterBuffer) && C12238m.areEqual(this.videoJitterDelay, inboundPlayout.videoJitterDelay) && C12238m.areEqual(this.videoJitterTarget, inboundPlayout.videoJitterTarget) && C12238m.areEqual(this.relativeReceptionDelay, inboundPlayout.relativeReceptionDelay) && C12238m.areEqual(this.relativePlayoutDelay, inboundPlayout.relativePlayoutDelay);
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
        StringBuilder sbM833U = C1643a.m833U("InboundPlayout(audioJitterBuffer=");
        sbM833U.append(this.audioJitterBuffer);
        sbM833U.append(", audioJitterDelay=");
        sbM833U.append(this.audioJitterDelay);
        sbM833U.append(", audioJitterTarget=");
        sbM833U.append(this.audioJitterTarget);
        sbM833U.append(", audioPlayoutUnderruns=");
        sbM833U.append(this.audioPlayoutUnderruns);
        sbM833U.append(", audioCaptureOverruns=");
        sbM833U.append(this.audioCaptureOverruns);
        sbM833U.append(", videoJitterBuffer=");
        sbM833U.append(this.videoJitterBuffer);
        sbM833U.append(", videoJitterDelay=");
        sbM833U.append(this.videoJitterDelay);
        sbM833U.append(", videoJitterTarget=");
        sbM833U.append(this.videoJitterTarget);
        sbM833U.append(", relativeReceptionDelay=");
        sbM833U.append(this.relativeReceptionDelay);
        sbM833U.append(", relativePlayoutDelay=");
        sbM833U.append(this.relativePlayoutDelay);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
