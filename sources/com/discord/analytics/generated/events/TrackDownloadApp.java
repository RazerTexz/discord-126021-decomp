package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDownloadApp.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDownloadApp implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final Boolean hasEMail = null;
    private final CharSequence platform = null;
    private final Boolean ptb = null;
    private final CharSequence referringLocation = null;
    private final Boolean released = null;
    private final CharSequence pageName = null;
    private final CharSequence staticExperimentUuid = null;
    private final Boolean qrCode = null;
    private final transient String analyticsSchemaTypeName = "download_app";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDownloadApp)) {
            return false;
        }
        TrackDownloadApp trackDownloadApp = (TrackDownloadApp) other;
        return m.areEqual(this.hasEMail, trackDownloadApp.hasEMail) && m.areEqual(this.platform, trackDownloadApp.platform) && m.areEqual(this.ptb, trackDownloadApp.ptb) && m.areEqual(this.referringLocation, trackDownloadApp.referringLocation) && m.areEqual(this.released, trackDownloadApp.released) && m.areEqual(this.pageName, trackDownloadApp.pageName) && m.areEqual(this.staticExperimentUuid, trackDownloadApp.staticExperimentUuid) && m.areEqual(this.qrCode, trackDownloadApp.qrCode);
    }

    public int hashCode() {
        Boolean bool = this.hasEMail;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.platform;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool2 = this.ptb;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.referringLocation;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool3 = this.released;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.pageName;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.staticExperimentUuid;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool4 = this.qrCode;
        return iHashCode7 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackDownloadApp(hasEMail=");
        sbU.append(this.hasEMail);
        sbU.append(", platform=");
        sbU.append(this.platform);
        sbU.append(", ptb=");
        sbU.append(this.ptb);
        sbU.append(", referringLocation=");
        sbU.append(this.referringLocation);
        sbU.append(", released=");
        sbU.append(this.released);
        sbU.append(", pageName=");
        sbU.append(this.pageName);
        sbU.append(", staticExperimentUuid=");
        sbU.append(this.staticExperimentUuid);
        sbU.append(", qrCode=");
        return a.D(sbU, this.qrCode, ")");
    }
}
