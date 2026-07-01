package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildAutomodFeedback.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildAutomodFeedback implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence content;
    private final CharSequence decisionId;
    private final CharSequence feedbackType;
    private final CharSequence messageContent;
    private final CharSequence messageId;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;

    public TrackGuildAutomodFeedback() {
        this(null, null, null, null, null, 31);
    }

    public TrackGuildAutomodFeedback(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i) {
        charSequence = (i & 1) != 0 ? null : charSequence;
        charSequence2 = (i & 2) != 0 ? null : charSequence2;
        int i2 = i & 4;
        charSequence4 = (i & 8) != 0 ? null : charSequence4;
        charSequence5 = (i & 16) != 0 ? null : charSequence5;
        this.decisionId = charSequence;
        this.messageId = charSequence2;
        this.messageContent = null;
        this.feedbackType = charSequence4;
        this.content = charSequence5;
        this.analyticsSchemaTypeName = "guild_automod_feedback";
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
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
        if (!(other instanceof TrackGuildAutomodFeedback)) {
            return false;
        }
        TrackGuildAutomodFeedback trackGuildAutomodFeedback = (TrackGuildAutomodFeedback) other;
        return m.areEqual(this.decisionId, trackGuildAutomodFeedback.decisionId) && m.areEqual(this.messageId, trackGuildAutomodFeedback.messageId) && m.areEqual(this.messageContent, trackGuildAutomodFeedback.messageContent) && m.areEqual(this.feedbackType, trackGuildAutomodFeedback.feedbackType) && m.areEqual(this.content, trackGuildAutomodFeedback.content);
    }

    public int hashCode() {
        CharSequence charSequence = this.decisionId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.messageId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.messageContent;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.feedbackType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.content;
        return iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildAutomodFeedback(decisionId=");
        sbU.append(this.decisionId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageContent=");
        sbU.append(this.messageContent);
        sbU.append(", feedbackType=");
        sbU.append(this.feedbackType);
        sbU.append(", content=");
        return a.E(sbU, this.content, ")");
    }
}
