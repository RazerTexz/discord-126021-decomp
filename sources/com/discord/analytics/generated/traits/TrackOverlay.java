package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.gameName, trackOverlay.gameName) && C12238m.areEqual(this.gameId, trackOverlay.gameId) && C12238m.areEqual(this.error, trackOverlay.error) && C12238m.areEqual(this.rendererStarted, trackOverlay.rendererStarted) && C12238m.areEqual(this.rendererStartedAfter, trackOverlay.rendererStartedAfter) && C12238m.areEqual(this.rendererReadyAfter, trackOverlay.rendererReadyAfter) && C12238m.areEqual(this.rendererLoadSucceededAfter, trackOverlay.rendererLoadSucceededAfter) && C12238m.areEqual(this.rendererCrashCount, trackOverlay.rendererCrashCount) && C12238m.areEqual(this.rendererLoadFailures, trackOverlay.rendererLoadFailures) && C12238m.areEqual(this.rendererIgnoredPaints, trackOverlay.rendererIgnoredPaints) && C12238m.areEqual(this.hostCrashCount, trackOverlay.hostCrashCount) && C12238m.areEqual(this.framebufferSource, trackOverlay.framebufferSource) && C12238m.areEqual(this.firstFramebufferAfter, trackOverlay.firstFramebufferAfter) && C12238m.areEqual(this.graphicsWidth, trackOverlay.graphicsWidth) && C12238m.areEqual(this.graphicsHeight, trackOverlay.graphicsHeight) && C12238m.areEqual(this.graphicsApi, trackOverlay.graphicsApi) && C12238m.areEqual(this.graphicsInfoAfter, trackOverlay.graphicsInfoAfter) && C12238m.areEqual(this.cpu, trackOverlay.cpu) && C12238m.areEqual(this.gpu, trackOverlay.gpu);
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
        StringBuilder sbM833U = C1643a.m833U("TrackOverlay(gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", error=");
        sbM833U.append(this.error);
        sbM833U.append(", rendererStarted=");
        sbM833U.append(this.rendererStarted);
        sbM833U.append(", rendererStartedAfter=");
        sbM833U.append(this.rendererStartedAfter);
        sbM833U.append(", rendererReadyAfter=");
        sbM833U.append(this.rendererReadyAfter);
        sbM833U.append(", rendererLoadSucceededAfter=");
        sbM833U.append(this.rendererLoadSucceededAfter);
        sbM833U.append(", rendererCrashCount=");
        sbM833U.append(this.rendererCrashCount);
        sbM833U.append(", rendererLoadFailures=");
        sbM833U.append(this.rendererLoadFailures);
        sbM833U.append(", rendererIgnoredPaints=");
        sbM833U.append(this.rendererIgnoredPaints);
        sbM833U.append(", hostCrashCount=");
        sbM833U.append(this.hostCrashCount);
        sbM833U.append(", framebufferSource=");
        sbM833U.append(this.framebufferSource);
        sbM833U.append(", firstFramebufferAfter=");
        sbM833U.append(this.firstFramebufferAfter);
        sbM833U.append(", graphicsWidth=");
        sbM833U.append(this.graphicsWidth);
        sbM833U.append(", graphicsHeight=");
        sbM833U.append(this.graphicsHeight);
        sbM833U.append(", graphicsApi=");
        sbM833U.append(this.graphicsApi);
        sbM833U.append(", graphicsInfoAfter=");
        sbM833U.append(this.graphicsInfoAfter);
        sbM833U.append(", cpu=");
        sbM833U.append(this.cpu);
        sbM833U.append(", gpu=");
        return C1643a.m817E(sbM833U, this.gpu, ")");
    }
}
