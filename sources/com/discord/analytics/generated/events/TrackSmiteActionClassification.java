package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSmiteActionClassification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSmiteActionClassification implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence actionId = null;
    private final CharSequence rulesGitSha = null;
    private final CharSequence rulesSourceSha = null;
    private final List<CharSequence> labels = null;
    private final List<CharSequence> labelStatuses = null;
    private final List<CharSequence> labelReasons = null;
    private final List<CharSequence> labelReasonsShas = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final transient String analyticsSchemaTypeName = "smite_action_classification";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSmiteActionClassification)) {
            return false;
        }
        TrackSmiteActionClassification trackSmiteActionClassification = (TrackSmiteActionClassification) other;
        return C12238m.areEqual(this.actionName, trackSmiteActionClassification.actionName) && C12238m.areEqual(this.actionId, trackSmiteActionClassification.actionId) && C12238m.areEqual(this.rulesGitSha, trackSmiteActionClassification.rulesGitSha) && C12238m.areEqual(this.rulesSourceSha, trackSmiteActionClassification.rulesSourceSha) && C12238m.areEqual(this.labels, trackSmiteActionClassification.labels) && C12238m.areEqual(this.labelStatuses, trackSmiteActionClassification.labelStatuses) && C12238m.areEqual(this.labelReasons, trackSmiteActionClassification.labelReasons) && C12238m.areEqual(this.labelReasonsShas, trackSmiteActionClassification.labelReasonsShas) && C12238m.areEqual(this.guildId, trackSmiteActionClassification.guildId) && C12238m.areEqual(this.channelId, trackSmiteActionClassification.channelId) && C12238m.areEqual(this.locationGuildId, trackSmiteActionClassification.locationGuildId) && C12238m.areEqual(this.locationChannelId, trackSmiteActionClassification.locationChannelId) && C12238m.areEqual(this.locationChannelType, trackSmiteActionClassification.locationChannelType) && C12238m.areEqual(this.locationMessageId, trackSmiteActionClassification.locationMessageId);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.actionId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.rulesGitSha;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.rulesSourceSha;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        List<CharSequence> list = this.labels;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.labelStatuses;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<CharSequence> list3 = this.labelReasons;
        int iHashCode7 = (iHashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<CharSequence> list4 = this.labelReasonsShas;
        int iHashCode8 = (iHashCode7 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode10 = (iHashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.locationGuildId;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.locationChannelId;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.locationChannelType;
        int iHashCode13 = (iHashCode12 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.locationMessageId;
        return iHashCode13 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSmiteActionClassification(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", actionId=");
        sbM833U.append(this.actionId);
        sbM833U.append(", rulesGitSha=");
        sbM833U.append(this.rulesGitSha);
        sbM833U.append(", rulesSourceSha=");
        sbM833U.append(this.rulesSourceSha);
        sbM833U.append(", labels=");
        sbM833U.append(this.labels);
        sbM833U.append(", labelStatuses=");
        sbM833U.append(this.labelStatuses);
        sbM833U.append(", labelReasons=");
        sbM833U.append(this.labelReasons);
        sbM833U.append(", labelReasonsShas=");
        sbM833U.append(this.labelReasonsShas);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", locationGuildId=");
        sbM833U.append(this.locationGuildId);
        sbM833U.append(", locationChannelId=");
        sbM833U.append(this.locationChannelId);
        sbM833U.append(", locationChannelType=");
        sbM833U.append(this.locationChannelType);
        sbM833U.append(", locationMessageId=");
        return C1643a.m819G(sbM833U, this.locationMessageId, ")");
    }
}
