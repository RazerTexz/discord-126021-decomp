package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.hasEMail, trackDownloadApp.hasEMail) && C12238m.areEqual(this.platform, trackDownloadApp.platform) && C12238m.areEqual(this.ptb, trackDownloadApp.ptb) && C12238m.areEqual(this.referringLocation, trackDownloadApp.referringLocation) && C12238m.areEqual(this.released, trackDownloadApp.released) && C12238m.areEqual(this.pageName, trackDownloadApp.pageName) && C12238m.areEqual(this.staticExperimentUuid, trackDownloadApp.staticExperimentUuid) && C12238m.areEqual(this.qrCode, trackDownloadApp.qrCode);
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
        StringBuilder sbM833U = C1643a.m833U("TrackDownloadApp(hasEMail=");
        sbM833U.append(this.hasEMail);
        sbM833U.append(", platform=");
        sbM833U.append(this.platform);
        sbM833U.append(", ptb=");
        sbM833U.append(this.ptb);
        sbM833U.append(", referringLocation=");
        sbM833U.append(this.referringLocation);
        sbM833U.append(", released=");
        sbM833U.append(this.released);
        sbM833U.append(", pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", staticExperimentUuid=");
        sbM833U.append(this.staticExperimentUuid);
        sbM833U.append(", qrCode=");
        return C1643a.m816D(sbM833U, this.qrCode, ")");
    }
}
