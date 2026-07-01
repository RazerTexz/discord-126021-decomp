package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackHubWaitlistSubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHubWaitlistSubmitted implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.email, trackHubWaitlistSubmitted.email) && Intrinsics3.areEqual(this.emailDomain, trackHubWaitlistSubmitted.emailDomain);
    }

    public int hashCode() {
        CharSequence charSequence = this.email;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.emailDomain;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackHubWaitlistSubmitted(email=");
        sbU.append(this.email);
        sbU.append(", emailDomain=");
        return outline.E(sbU, this.emailDomain, ")");
    }
}
