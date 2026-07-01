package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDevPortalAuthUrlCopied.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalAuthUrlCopied implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence applicationName = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_auth_url_copied";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalAuthUrlCopied)) {
            return false;
        }
        TrackDevPortalAuthUrlCopied trackDevPortalAuthUrlCopied = (TrackDevPortalAuthUrlCopied) other;
        return m.areEqual(this.applicationId, trackDevPortalAuthUrlCopied.applicationId) && m.areEqual(this.botId, trackDevPortalAuthUrlCopied.botId) && m.areEqual(this.applicationName, trackDevPortalAuthUrlCopied.applicationName) && m.areEqual(this.hasBot, trackDevPortalAuthUrlCopied.hasBot) && m.areEqual(this.hasRedirectUri, trackDevPortalAuthUrlCopied.hasRedirectUri);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.botId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasBot;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasRedirectUri;
        return iHashCode4 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackDevPortalAuthUrlCopied(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", hasBot=");
        sbU.append(this.hasBot);
        sbU.append(", hasRedirectUri=");
        return a.D(sbU, this.hasRedirectUri, ")");
    }
}
