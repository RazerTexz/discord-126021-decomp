package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmailReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackEmailSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmailSent implements AnalyticsSchema, TrackBaseReceiver, TrackEmailReceiver {
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
        return C12238m.areEqual(this.email, trackEmailSent.email) && C12238m.areEqual(this.emailDomain, trackEmailSent.emailDomain) && C12238m.areEqual(this.mmNumGuildsMissed, trackEmailSent.mmNumGuildsMissed) && C12238m.areEqual(this.mmNumChannelsMissed, trackEmailSent.mmNumChannelsMissed) && C12238m.areEqual(this.mmNumDmsMissed, trackEmailSent.mmNumDmsMissed) && C12238m.areEqual(this.mmNumMessagesMissed, trackEmailSent.mmNumMessagesMissed) && C12238m.areEqual(this.userLastActive, trackEmailSent.userLastActive) && C12238m.areEqual(this.clickProbability, trackEmailSent.clickProbability);
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
        StringBuilder sbM833U = C1643a.m833U("TrackEmailSent(email=");
        sbM833U.append(this.email);
        sbM833U.append(", emailDomain=");
        sbM833U.append(this.emailDomain);
        sbM833U.append(", mmNumGuildsMissed=");
        sbM833U.append(this.mmNumGuildsMissed);
        sbM833U.append(", mmNumChannelsMissed=");
        sbM833U.append(this.mmNumChannelsMissed);
        sbM833U.append(", mmNumDmsMissed=");
        sbM833U.append(this.mmNumDmsMissed);
        sbM833U.append(", mmNumMessagesMissed=");
        sbM833U.append(this.mmNumMessagesMissed);
        sbM833U.append(", userLastActive=");
        sbM833U.append(this.userLastActive);
        sbM833U.append(", clickProbability=");
        sbM833U.append(this.clickProbability);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
