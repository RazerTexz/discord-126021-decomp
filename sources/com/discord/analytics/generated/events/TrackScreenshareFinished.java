package com.discord.analytics.generated.events;

import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackScreenshareFinished.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackScreenshareFinished implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence context = null;
    private final Long screenshareFrames = null;
    private final Long videohookFrames = null;
    private final Long hybridDxgiFrames = null;
    private final Long hybridGdiFrames = null;
    private final Long hybridVideohookFrames = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final CharSequence desktopCapturerType = null;
    private final Long screens = null;
    private final Long windows = null;
    private final CharSequence cpu = null;
    private final CharSequence gpu = null;
    private final CharSequence cpuBrand = null;
    private final CharSequence cpuVendor = null;
    private final Long cpuMemory = null;
    private final CharSequence gpuBrand = null;
    private final Long gpuCount = null;
    private final Long gpuMemory = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long quartzFrames = null;
    private final Float activity = null;
    private final transient String analyticsSchemaTypeName = "screenshare_finished";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackScreenshareFinished)) {
            return false;
        }
        TrackScreenshareFinished trackScreenshareFinished = (TrackScreenshareFinished) other;
        return Intrinsics3.areEqual(this.guildId, trackScreenshareFinished.guildId) && Intrinsics3.areEqual(this.channelId, trackScreenshareFinished.channelId) && Intrinsics3.areEqual(this.context, trackScreenshareFinished.context) && Intrinsics3.areEqual(this.screenshareFrames, trackScreenshareFinished.screenshareFrames) && Intrinsics3.areEqual(this.videohookFrames, trackScreenshareFinished.videohookFrames) && Intrinsics3.areEqual(this.hybridDxgiFrames, trackScreenshareFinished.hybridDxgiFrames) && Intrinsics3.areEqual(this.hybridGdiFrames, trackScreenshareFinished.hybridGdiFrames) && Intrinsics3.areEqual(this.hybridVideohookFrames, trackScreenshareFinished.hybridVideohookFrames) && Intrinsics3.areEqual(this.soundshareSession, trackScreenshareFinished.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackScreenshareFinished.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackScreenshareFinished.shareGameId) && Intrinsics3.areEqual(this.desktopCapturerType, trackScreenshareFinished.desktopCapturerType) && Intrinsics3.areEqual(this.screens, trackScreenshareFinished.screens) && Intrinsics3.areEqual(this.windows, trackScreenshareFinished.windows) && Intrinsics3.areEqual(this.cpu, trackScreenshareFinished.cpu) && Intrinsics3.areEqual(this.gpu, trackScreenshareFinished.gpu) && Intrinsics3.areEqual(this.cpuBrand, trackScreenshareFinished.cpuBrand) && Intrinsics3.areEqual(this.cpuVendor, trackScreenshareFinished.cpuVendor) && Intrinsics3.areEqual(this.cpuMemory, trackScreenshareFinished.cpuMemory) && Intrinsics3.areEqual(this.gpuBrand, trackScreenshareFinished.gpuBrand) && Intrinsics3.areEqual(this.gpuCount, trackScreenshareFinished.gpuCount) && Intrinsics3.areEqual(this.gpuMemory, trackScreenshareFinished.gpuMemory) && Intrinsics3.areEqual(this.mediaSessionId, trackScreenshareFinished.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnectionId, trackScreenshareFinished.rtcConnectionId) && Intrinsics3.areEqual(this.quartzFrames, trackScreenshareFinished.quartzFrames) && Intrinsics3.areEqual(this.activity, trackScreenshareFinished.activity);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.context;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.screenshareFrames;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.videohookFrames;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.hybridDxgiFrames;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.hybridGdiFrames;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.hybridVideohookFrames;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.soundshareSession;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.shareGameName;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l8 = this.shareGameId;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.desktopCapturerType;
        int iHashCode12 = (iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l9 = this.screens;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.windows;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.cpu;
        int iHashCode15 = (iHashCode14 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.gpu;
        int iHashCode16 = (iHashCode15 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.cpuBrand;
        int iHashCode17 = (iHashCode16 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.cpuVendor;
        int iHashCode18 = (iHashCode17 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Long l11 = this.cpuMemory;
        int iHashCode19 = (iHashCode18 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.gpuBrand;
        int iHashCode20 = (iHashCode19 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        Long l12 = this.gpuCount;
        int iHashCode21 = (iHashCode20 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.gpuMemory;
        int iHashCode22 = (iHashCode21 + (l13 != null ? l13.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.mediaSessionId;
        int iHashCode23 = (iHashCode22 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.rtcConnectionId;
        int iHashCode24 = (iHashCode23 + (charSequence11 != null ? charSequence11.hashCode() : 0)) * 31;
        Long l14 = this.quartzFrames;
        int iHashCode25 = (iHashCode24 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Float f = this.activity;
        return iHashCode25 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackScreenshareFinished(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", screenshareFrames=");
        sbU.append(this.screenshareFrames);
        sbU.append(", videohookFrames=");
        sbU.append(this.videohookFrames);
        sbU.append(", hybridDxgiFrames=");
        sbU.append(this.hybridDxgiFrames);
        sbU.append(", hybridGdiFrames=");
        sbU.append(this.hybridGdiFrames);
        sbU.append(", hybridVideohookFrames=");
        sbU.append(this.hybridVideohookFrames);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        sbU.append(this.shareGameId);
        sbU.append(", desktopCapturerType=");
        sbU.append(this.desktopCapturerType);
        sbU.append(", screens=");
        sbU.append(this.screens);
        sbU.append(", windows=");
        sbU.append(this.windows);
        sbU.append(", cpu=");
        sbU.append(this.cpu);
        sbU.append(", gpu=");
        sbU.append(this.gpu);
        sbU.append(", cpuBrand=");
        sbU.append(this.cpuBrand);
        sbU.append(", cpuVendor=");
        sbU.append(this.cpuVendor);
        sbU.append(", cpuMemory=");
        sbU.append(this.cpuMemory);
        sbU.append(", gpuBrand=");
        sbU.append(this.gpuBrand);
        sbU.append(", gpuCount=");
        sbU.append(this.gpuCount);
        sbU.append(", gpuMemory=");
        sbU.append(this.gpuMemory);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", quartzFrames=");
        sbU.append(this.quartzFrames);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }
}
