package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDevPortalRpApprovalFormStateChange.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalRpApprovalFormStateChange implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence name = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final Long state = null;
    private final Boolean joinRequest = null;
    private final Boolean spectate = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_rp_approval_form_state_change";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalRpApprovalFormStateChange)) {
            return false;
        }
        TrackDevPortalRpApprovalFormStateChange trackDevPortalRpApprovalFormStateChange = (TrackDevPortalRpApprovalFormStateChange) other;
        return C12238m.areEqual(this.applicationId, trackDevPortalRpApprovalFormStateChange.applicationId) && C12238m.areEqual(this.botId, trackDevPortalRpApprovalFormStateChange.botId) && C12238m.areEqual(this.name, trackDevPortalRpApprovalFormStateChange.name) && C12238m.areEqual(this.hasBot, trackDevPortalRpApprovalFormStateChange.hasBot) && C12238m.areEqual(this.hasRedirectUri, trackDevPortalRpApprovalFormStateChange.hasRedirectUri) && C12238m.areEqual(this.state, trackDevPortalRpApprovalFormStateChange.state) && C12238m.areEqual(this.joinRequest, trackDevPortalRpApprovalFormStateChange.joinRequest) && C12238m.areEqual(this.spectate, trackDevPortalRpApprovalFormStateChange.spectate);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.botId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.name;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasBot;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasRedirectUri;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l3 = this.state;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool3 = this.joinRequest;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.spectate;
        return iHashCode7 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDevPortalRpApprovalFormStateChange(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", hasBot=");
        sbM833U.append(this.hasBot);
        sbM833U.append(", hasRedirectUri=");
        sbM833U.append(this.hasRedirectUri);
        sbM833U.append(", state=");
        sbM833U.append(this.state);
        sbM833U.append(", joinRequest=");
        sbM833U.append(this.joinRequest);
        sbM833U.append(", spectate=");
        return C1643a.m816D(sbM833U, this.spectate, ")");
    }
}
