package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.applicationId, trackDevPortalAuthUrlCopied.applicationId) && C12238m.areEqual(this.botId, trackDevPortalAuthUrlCopied.botId) && C12238m.areEqual(this.applicationName, trackDevPortalAuthUrlCopied.applicationName) && C12238m.areEqual(this.hasBot, trackDevPortalAuthUrlCopied.hasBot) && C12238m.areEqual(this.hasRedirectUri, trackDevPortalAuthUrlCopied.hasRedirectUri);
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
        StringBuilder sbM833U = C1643a.m833U("TrackDevPortalAuthUrlCopied(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", hasBot=");
        sbM833U.append(this.hasBot);
        sbM833U.append(", hasRedirectUri=");
        return C1643a.m816D(sbM833U, this.hasRedirectUri, ")");
    }
}
