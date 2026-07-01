package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOverlay.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlay {
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final CharSequence error = null;
    private final Boolean rendererStarted = null;
    private final Long rendererStartedAfter = null;
    private final Long rendererReadyAfter = null;
    private final Long rendererLoadSucceededAfter = null;
    private final Long rendererCrashCount = null;
    private final Long rendererLoadFailures = null;
    private final Long rendererIgnoredPaints = null;
    private final Long hostCrashCount = null;
    private final CharSequence framebufferSource = null;
    private final Long firstFramebufferAfter = null;
    private final Long graphicsWidth = null;
    private final Long graphicsHeight = null;
    private final CharSequence graphicsApi = null;
    private final Long graphicsInfoAfter = null;
    private final CharSequence cpu = null;
    private final CharSequence gpu = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlay)) {
            return false;
        }
        TrackOverlay trackOverlay = (TrackOverlay) other;
        return m.areEqual(this.gameName, trackOverlay.gameName) && m.areEqual(this.gameId, trackOverlay.gameId) && m.areEqual(this.error, trackOverlay.error) && m.areEqual(this.rendererStarted, trackOverlay.rendererStarted) && m.areEqual(this.rendererStartedAfter, trackOverlay.rendererStartedAfter) && m.areEqual(this.rendererReadyAfter, trackOverlay.rendererReadyAfter) && m.areEqual(this.rendererLoadSucceededAfter, trackOverlay.rendererLoadSucceededAfter) && m.areEqual(this.rendererCrashCount, trackOverlay.rendererCrashCount) && m.areEqual(this.rendererLoadFailures, trackOverlay.rendererLoadFailures) && m.areEqual(this.rendererIgnoredPaints, trackOverlay.rendererIgnoredPaints) && m.areEqual(this.hostCrashCount, trackOverlay.hostCrashCount) && m.areEqual(this.framebufferSource, trackOverlay.framebufferSource) && m.areEqual(this.firstFramebufferAfter, trackOverlay.firstFramebufferAfter) && m.areEqual(this.graphicsWidth, trackOverlay.graphicsWidth) && m.areEqual(this.graphicsHeight, trackOverlay.graphicsHeight) && m.areEqual(this.graphicsApi, trackOverlay.graphicsApi) && m.areEqual(this.graphicsInfoAfter, trackOverlay.graphicsInfoAfter) && m.areEqual(this.cpu, trackOverlay.cpu) && m.areEqual(this.gpu, trackOverlay.gpu);
    }

    public int hashCode() {
        CharSequence charSequence = this.gameName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.gameId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.error;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.rendererStarted;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.rendererStartedAfter;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.rendererReadyAfter;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.rendererLoadSucceededAfter;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.rendererCrashCount;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.rendererLoadFailures;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.rendererIgnoredPaints;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.hostCrashCount;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.framebufferSource;
        int iHashCode12 = (iHashCode11 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l9 = this.firstFramebufferAfter;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.graphicsWidth;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.graphicsHeight;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.graphicsApi;
        int iHashCode16 = (iHashCode15 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l12 = this.graphicsInfoAfter;
        int iHashCode17 = (iHashCode16 + (l12 != null ? l12.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.cpu;
        int iHashCode18 = (iHashCode17 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.gpu;
        return iHashCode18 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackOverlay(gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", error=");
        sbU.append(this.error);
        sbU.append(", rendererStarted=");
        sbU.append(this.rendererStarted);
        sbU.append(", rendererStartedAfter=");
        sbU.append(this.rendererStartedAfter);
        sbU.append(", rendererReadyAfter=");
        sbU.append(this.rendererReadyAfter);
        sbU.append(", rendererLoadSucceededAfter=");
        sbU.append(this.rendererLoadSucceededAfter);
        sbU.append(", rendererCrashCount=");
        sbU.append(this.rendererCrashCount);
        sbU.append(", rendererLoadFailures=");
        sbU.append(this.rendererLoadFailures);
        sbU.append(", rendererIgnoredPaints=");
        sbU.append(this.rendererIgnoredPaints);
        sbU.append(", hostCrashCount=");
        sbU.append(this.hostCrashCount);
        sbU.append(", framebufferSource=");
        sbU.append(this.framebufferSource);
        sbU.append(", firstFramebufferAfter=");
        sbU.append(this.firstFramebufferAfter);
        sbU.append(", graphicsWidth=");
        sbU.append(this.graphicsWidth);
        sbU.append(", graphicsHeight=");
        sbU.append(this.graphicsHeight);
        sbU.append(", graphicsApi=");
        sbU.append(this.graphicsApi);
        sbU.append(", graphicsInfoAfter=");
        sbU.append(this.graphicsInfoAfter);
        sbU.append(", cpu=");
        sbU.append(this.cpu);
        sbU.append(", gpu=");
        return a.E(sbU, this.gpu, ")");
    }
}
