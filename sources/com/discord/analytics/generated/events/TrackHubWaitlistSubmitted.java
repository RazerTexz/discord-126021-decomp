package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackHubWaitlistSubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHubWaitlistSubmitted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence email = null;
    private final CharSequence emailDomain = null;
    private final transient String analyticsSchemaTypeName = "hub_waitlist_submitted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackHubWaitlistSubmitted)) {
            return false;
        }
        TrackHubWaitlistSubmitted trackHubWaitlistSubmitted = (TrackHubWaitlistSubmitted) other;
        return C12238m.areEqual(this.email, trackHubWaitlistSubmitted.email) && C12238m.areEqual(this.emailDomain, trackHubWaitlistSubmitted.emailDomain);
    }

    public int hashCode() {
        CharSequence charSequence = this.email;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.emailDomain;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackHubWaitlistSubmitted(email=");
        sbM833U.append(this.email);
        sbM833U.append(", emailDomain=");
        return C1643a.m817E(sbM833U, this.emailDomain, ")");
    }
}
