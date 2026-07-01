package com.discord.views.calls;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoCallParticipantView$ParticipantData$a {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoCallParticipantView$StreamResolution f2841b;
    public final VideoCallParticipantView$StreamFps c;
    public final boolean d;

    public VideoCallParticipantView$ParticipantData$a(boolean z2, VideoCallParticipantView$StreamResolution videoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps videoCallParticipantView$StreamFps, boolean z3) {
        m.checkNotNullParameter(videoCallParticipantView$StreamResolution, "resolution");
        this.a = z2;
        this.f2841b = videoCallParticipantView$StreamResolution;
        this.c = videoCallParticipantView$StreamFps;
        this.d = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoCallParticipantView$ParticipantData$a)) {
            return false;
        }
        VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a = (VideoCallParticipantView$ParticipantData$a) obj;
        return this.a == videoCallParticipantView$ParticipantData$a.a && m.areEqual(this.f2841b, videoCallParticipantView$ParticipantData$a.f2841b) && m.areEqual(this.c, videoCallParticipantView$ParticipantData$a.c) && this.d == videoCallParticipantView$ParticipantData$a.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        VideoCallParticipantView$StreamResolution videoCallParticipantView$StreamResolution = this.f2841b;
        int iHashCode = (i + (videoCallParticipantView$StreamResolution != null ? videoCallParticipantView$StreamResolution.hashCode() : 0)) * 31;
        VideoCallParticipantView$StreamFps videoCallParticipantView$StreamFps = this.c;
        int fps = (iHashCode + (videoCallParticipantView$StreamFps != null ? videoCallParticipantView$StreamFps.getFps() : 0)) * 31;
        boolean z3 = this.d;
        return fps + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("StreamQualityIndicatorData(showPremiumIcon=");
        sbU.append(this.a);
        sbU.append(", resolution=");
        sbU.append(this.f2841b);
        sbU.append(", fps=");
        sbU.append(this.c);
        sbU.append(", isBadQuality=");
        return a.O(sbU, this.d, ")");
    }
}
