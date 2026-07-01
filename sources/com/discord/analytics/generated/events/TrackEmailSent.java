package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmail2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackEmailSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmailSent implements AnalyticsSchema, TrackBase2, TrackEmail2 {
    private TrackBase trackBase;
    private TrackEmail trackEmail;
    private final CharSequence email = null;
    private final CharSequence emailDomain = null;
    private final Long mmNumGuildsMissed = null;
    private final Long mmNumChannelsMissed = null;
    private final Long mmNumDmsMissed = null;
    private final Long mmNumMessagesMissed = null;
    private final Long userLastActive = null;
    private final Float clickProbability = null;
    private final transient String analyticsSchemaTypeName = "email_sent";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmailSent)) {
            return false;
        }
        TrackEmailSent trackEmailSent = (TrackEmailSent) other;
        return Intrinsics3.areEqual(this.email, trackEmailSent.email) && Intrinsics3.areEqual(this.emailDomain, trackEmailSent.emailDomain) && Intrinsics3.areEqual(this.mmNumGuildsMissed, trackEmailSent.mmNumGuildsMissed) && Intrinsics3.areEqual(this.mmNumChannelsMissed, trackEmailSent.mmNumChannelsMissed) && Intrinsics3.areEqual(this.mmNumDmsMissed, trackEmailSent.mmNumDmsMissed) && Intrinsics3.areEqual(this.mmNumMessagesMissed, trackEmailSent.mmNumMessagesMissed) && Intrinsics3.areEqual(this.userLastActive, trackEmailSent.userLastActive) && Intrinsics3.areEqual(this.clickProbability, trackEmailSent.clickProbability);
    }

    public int hashCode() {
        CharSequence charSequence = this.email;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.emailDomain;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.mmNumGuildsMissed;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.mmNumChannelsMissed;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.mmNumDmsMissed;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.mmNumMessagesMissed;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.userLastActive;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Float f = this.clickProbability;
        return iHashCode7 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEmailSent(email=");
        sbU.append(this.email);
        sbU.append(", emailDomain=");
        sbU.append(this.emailDomain);
        sbU.append(", mmNumGuildsMissed=");
        sbU.append(this.mmNumGuildsMissed);
        sbU.append(", mmNumChannelsMissed=");
        sbU.append(this.mmNumChannelsMissed);
        sbU.append(", mmNumDmsMissed=");
        sbU.append(this.mmNumDmsMissed);
        sbU.append(", mmNumMessagesMissed=");
        sbU.append(this.mmNumMessagesMissed);
        sbU.append(", userLastActive=");
        sbU.append(this.userLastActive);
        sbU.append(", clickProbability=");
        sbU.append(this.clickProbability);
        sbU.append(")");
        return sbU.toString();
    }
}
