package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackSmiteActionClassification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSmiteActionClassification implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.actionName, trackSmiteActionClassification.actionName) && Intrinsics3.areEqual(this.actionId, trackSmiteActionClassification.actionId) && Intrinsics3.areEqual(this.rulesGitSha, trackSmiteActionClassification.rulesGitSha) && Intrinsics3.areEqual(this.rulesSourceSha, trackSmiteActionClassification.rulesSourceSha) && Intrinsics3.areEqual(this.labels, trackSmiteActionClassification.labels) && Intrinsics3.areEqual(this.labelStatuses, trackSmiteActionClassification.labelStatuses) && Intrinsics3.areEqual(this.labelReasons, trackSmiteActionClassification.labelReasons) && Intrinsics3.areEqual(this.labelReasonsShas, trackSmiteActionClassification.labelReasonsShas) && Intrinsics3.areEqual(this.guildId, trackSmiteActionClassification.guildId) && Intrinsics3.areEqual(this.channelId, trackSmiteActionClassification.channelId) && Intrinsics3.areEqual(this.locationGuildId, trackSmiteActionClassification.locationGuildId) && Intrinsics3.areEqual(this.locationChannelId, trackSmiteActionClassification.locationChannelId) && Intrinsics3.areEqual(this.locationChannelType, trackSmiteActionClassification.locationChannelType) && Intrinsics3.areEqual(this.locationMessageId, trackSmiteActionClassification.locationMessageId);
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
        StringBuilder sbU = outline.U("TrackSmiteActionClassification(actionName=");
        sbU.append(this.actionName);
        sbU.append(", actionId=");
        sbU.append(this.actionId);
        sbU.append(", rulesGitSha=");
        sbU.append(this.rulesGitSha);
        sbU.append(", rulesSourceSha=");
        sbU.append(this.rulesSourceSha);
        sbU.append(", labels=");
        sbU.append(this.labels);
        sbU.append(", labelStatuses=");
        sbU.append(this.labelStatuses);
        sbU.append(", labelReasons=");
        sbU.append(this.labelReasons);
        sbU.append(", labelReasonsShas=");
        sbU.append(this.labelReasonsShas);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", locationGuildId=");
        sbU.append(this.locationGuildId);
        sbU.append(", locationChannelId=");
        sbU.append(this.locationChannelId);
        sbU.append(", locationChannelType=");
        sbU.append(this.locationChannelType);
        sbU.append(", locationMessageId=");
        return outline.G(sbU, this.locationMessageId, ")");
    }
}
