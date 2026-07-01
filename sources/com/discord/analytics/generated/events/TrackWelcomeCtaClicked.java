package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackWelcomeCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackWelcomeCtaClicked implements AnalyticsSchema, TrackBaseReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Boolean isReply;
    private final Long sender;
    private final CharSequence stickerId;
    private final Long targetUser;
    private TrackBase trackBase;

    public TrackWelcomeCtaClicked() {
        this.isReply = null;
        this.stickerId = null;
        this.targetUser = null;
        this.sender = null;
        this.analyticsSchemaTypeName = "welcome_cta_clicked";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackWelcomeCtaClicked)) {
            return false;
        }
        TrackWelcomeCtaClicked trackWelcomeCtaClicked = (TrackWelcomeCtaClicked) other;
        return m.areEqual(this.isReply, trackWelcomeCtaClicked.isReply) && m.areEqual(this.stickerId, trackWelcomeCtaClicked.stickerId) && m.areEqual(this.targetUser, trackWelcomeCtaClicked.targetUser) && m.areEqual(this.sender, trackWelcomeCtaClicked.sender);
    }

    public int hashCode() {
        Boolean bool = this.isReply;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.stickerId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.targetUser;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.sender;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackWelcomeCtaClicked(isReply=");
        sbU.append(this.isReply);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", targetUser=");
        sbU.append(this.targetUser);
        sbU.append(", sender=");
        return a.G(sbU, this.sender, ")");
    }

    public TrackWelcomeCtaClicked(Boolean bool, CharSequence charSequence, Long l, Long l2) {
        this.isReply = bool;
        this.stickerId = charSequence;
        this.targetUser = l;
        this.sender = l2;
        this.analyticsSchemaTypeName = "welcome_cta_clicked";
    }
}
