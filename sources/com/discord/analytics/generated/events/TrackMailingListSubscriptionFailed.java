package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMailingListSubscriptionFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMailingListSubscriptionFailed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long erroredUserId = null;
    private final CharSequence provider = null;
    private final CharSequence listName = null;
    private final transient String analyticsSchemaTypeName = "mailing_list_subscription_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMailingListSubscriptionFailed)) {
            return false;
        }
        TrackMailingListSubscriptionFailed trackMailingListSubscriptionFailed = (TrackMailingListSubscriptionFailed) other;
        return C12238m.areEqual(this.erroredUserId, trackMailingListSubscriptionFailed.erroredUserId) && C12238m.areEqual(this.provider, trackMailingListSubscriptionFailed.provider) && C12238m.areEqual(this.listName, trackMailingListSubscriptionFailed.listName);
    }

    public int hashCode() {
        Long l = this.erroredUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.provider;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.listName;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMailingListSubscriptionFailed(erroredUserId=");
        sbM833U.append(this.erroredUserId);
        sbM833U.append(", provider=");
        sbM833U.append(this.provider);
        sbM833U.append(", listName=");
        return C1643a.m817E(sbM833U, this.listName, ")");
    }
}
