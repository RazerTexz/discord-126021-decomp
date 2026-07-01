package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNewsCardEditorViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNewsCardEditorViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence applicationName = null;
    private final Long applicationId = null;
    private final Long messageId = null;
    private final CharSequence newsUrl = null;
    private final CharSequence newsCardEditorStep = null;
    private final transient String analyticsSchemaTypeName = "news_card_editor_viewed";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
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
        if (!(other instanceof TrackNewsCardEditorViewed)) {
            return false;
        }
        TrackNewsCardEditorViewed trackNewsCardEditorViewed = (TrackNewsCardEditorViewed) other;
        return Intrinsics3.areEqual(this.applicationName, trackNewsCardEditorViewed.applicationName) && Intrinsics3.areEqual(this.applicationId, trackNewsCardEditorViewed.applicationId) && Intrinsics3.areEqual(this.messageId, trackNewsCardEditorViewed.messageId) && Intrinsics3.areEqual(this.newsUrl, trackNewsCardEditorViewed.newsUrl) && Intrinsics3.areEqual(this.newsCardEditorStep, trackNewsCardEditorViewed.newsCardEditorStep);
    }

    public int hashCode() {
        CharSequence charSequence = this.applicationName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newsUrl;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.newsCardEditorStep;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNewsCardEditorViewed(applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsCardEditorStep=");
        return outline.E(sbU, this.newsCardEditorStep, ")");
    }
}
