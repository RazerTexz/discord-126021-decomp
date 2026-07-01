package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackMailingListContactUpdateFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMailingListContactUpdateFailed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long erroredUserId = null;
    private final CharSequence provider = null;
    private final CharSequence listName = null;
    private final transient String analyticsSchemaTypeName = "mailing_list_contact_update_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMailingListContactUpdateFailed)) {
            return false;
        }
        TrackMailingListContactUpdateFailed trackMailingListContactUpdateFailed = (TrackMailingListContactUpdateFailed) other;
        return m.areEqual(this.erroredUserId, trackMailingListContactUpdateFailed.erroredUserId) && m.areEqual(this.provider, trackMailingListContactUpdateFailed.provider) && m.areEqual(this.listName, trackMailingListContactUpdateFailed.listName);
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
        StringBuilder sbU = a.U("TrackMailingListContactUpdateFailed(erroredUserId=");
        sbU.append(this.erroredUserId);
        sbU.append(", provider=");
        sbU.append(this.provider);
        sbU.append(", listName=");
        return a.E(sbU, this.listName, ")");
    }
}
