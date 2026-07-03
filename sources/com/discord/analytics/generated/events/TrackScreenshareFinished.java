package com.discord.analytics.generated.events;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackScreenshareFinished.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackScreenshareFinished implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.guildId, trackScreenshareFinished.guildId) && C12238m.areEqual(this.channelId, trackScreenshareFinished.channelId) && C12238m.areEqual(this.context, trackScreenshareFinished.context) && C12238m.areEqual(this.screenshareFrames, trackScreenshareFinished.screenshareFrames) && C12238m.areEqual(this.videohookFrames, trackScreenshareFinished.videohookFrames) && C12238m.areEqual(this.hybridDxgiFrames, trackScreenshareFinished.hybridDxgiFrames) && C12238m.areEqual(this.hybridGdiFrames, trackScreenshareFinished.hybridGdiFrames) && C12238m.areEqual(this.hybridVideohookFrames, trackScreenshareFinished.hybridVideohookFrames) && C12238m.areEqual(this.soundshareSession, trackScreenshareFinished.soundshareSession) && C12238m.areEqual(this.shareGameName, trackScreenshareFinished.shareGameName) && C12238m.areEqual(this.shareGameId, trackScreenshareFinished.shareGameId) && C12238m.areEqual(this.desktopCapturerType, trackScreenshareFinished.desktopCapturerType) && C12238m.areEqual(this.screens, trackScreenshareFinished.screens) && C12238m.areEqual(this.windows, trackScreenshareFinished.windows) && C12238m.areEqual(this.cpu, trackScreenshareFinished.cpu) && C12238m.areEqual(this.gpu, trackScreenshareFinished.gpu) && C12238m.areEqual(this.cpuBrand, trackScreenshareFinished.cpuBrand) && C12238m.areEqual(this.cpuVendor, trackScreenshareFinished.cpuVendor) && C12238m.areEqual(this.cpuMemory, trackScreenshareFinished.cpuMemory) && C12238m.areEqual(this.gpuBrand, trackScreenshareFinished.gpuBrand) && C12238m.areEqual(this.gpuCount, trackScreenshareFinished.gpuCount) && C12238m.areEqual(this.gpuMemory, trackScreenshareFinished.gpuMemory) && C12238m.areEqual(this.mediaSessionId, trackScreenshareFinished.mediaSessionId) && C12238m.areEqual(this.rtcConnectionId, trackScreenshareFinished.rtcConnectionId) && C12238m.areEqual(this.quartzFrames, trackScreenshareFinished.quartzFrames) && C12238m.areEqual(this.activity, trackScreenshareFinished.activity);
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
        StringBuilder sbM833U = C1643a.m833U("TrackScreenshareFinished(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", context=");
        sbM833U.append(this.context);
        sbM833U.append(", screenshareFrames=");
        sbM833U.append(this.screenshareFrames);
        sbM833U.append(", videohookFrames=");
        sbM833U.append(this.videohookFrames);
        sbM833U.append(", hybridDxgiFrames=");
        sbM833U.append(this.hybridDxgiFrames);
        sbM833U.append(", hybridGdiFrames=");
        sbM833U.append(this.hybridGdiFrames);
        sbM833U.append(", hybridVideohookFrames=");
        sbM833U.append(this.hybridVideohookFrames);
        sbM833U.append(", soundshareSession=");
        sbM833U.append(this.soundshareSession);
        sbM833U.append(", shareGameName=");
        sbM833U.append(this.shareGameName);
        sbM833U.append(", shareGameId=");
        sbM833U.append(this.shareGameId);
        sbM833U.append(", desktopCapturerType=");
        sbM833U.append(this.desktopCapturerType);
        sbM833U.append(", screens=");
        sbM833U.append(this.screens);
        sbM833U.append(", windows=");
        sbM833U.append(this.windows);
        sbM833U.append(", cpu=");
        sbM833U.append(this.cpu);
        sbM833U.append(", gpu=");
        sbM833U.append(this.gpu);
        sbM833U.append(", cpuBrand=");
        sbM833U.append(this.cpuBrand);
        sbM833U.append(", cpuVendor=");
        sbM833U.append(this.cpuVendor);
        sbM833U.append(", cpuMemory=");
        sbM833U.append(this.cpuMemory);
        sbM833U.append(", gpuBrand=");
        sbM833U.append(this.gpuBrand);
        sbM833U.append(", gpuCount=");
        sbM833U.append(this.gpuCount);
        sbM833U.append(", gpuMemory=");
        sbM833U.append(this.gpuMemory);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", quartzFrames=");
        sbM833U.append(this.quartzFrames);
        sbM833U.append(", activity=");
        sbM833U.append(this.activity);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
