package com.discord.api.activity;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: Activity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Activity {
    private final Long applicationId;
    private final ActivityAssets assets;
    private final List<String> buttons;
    private final long createdAt;
    private final String details;
    private final ActivityEmoji emoji;
    private final Integer flags;
    private final ActivityMetadata metadata;
    private final String name;
    private final ActivityParty party;
    private final ActivityPlatform platform;
    private final String sessionId;
    private final String state;
    private final List<ActivityPlatform> supportedPlatforms;
    private final String syncId;
    private final ActivityTimestamps timestamps;
    private final ActivityType type;
    private final String url;

    public Activity(String str, ActivityType activityType, String str2, long j, ActivityTimestamps activityTimestamps, Long l, String str3, String str4, ActivityEmoji activityEmoji, ActivityParty activityParty, ActivityAssets activityAssets, Integer num, String str5, String str6, ActivityMetadata activityMetadata, ActivityPlatform activityPlatform, List<? extends ActivityPlatform> list, List<String> list2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(activityType, "type");
        this.name = str;
        this.type = activityType;
        this.url = null;
        this.createdAt = j;
        this.timestamps = activityTimestamps;
        this.applicationId = l;
        this.details = str3;
        this.state = str4;
        this.emoji = activityEmoji;
        this.party = activityParty;
        this.assets = activityAssets;
        this.flags = num;
        this.syncId = str5;
        this.sessionId = null;
        this.metadata = null;
        this.platform = activityPlatform;
        this.supportedPlatforms = null;
        this.buttons = null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final ActivityAssets getAssets() {
        return this.assets;
    }

    public final List<String> c() {
        return this.buttons;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) other;
        return Intrinsics3.areEqual(this.name, activity.name) && Intrinsics3.areEqual(this.type, activity.type) && Intrinsics3.areEqual(this.url, activity.url) && this.createdAt == activity.createdAt && Intrinsics3.areEqual(this.timestamps, activity.timestamps) && Intrinsics3.areEqual(this.applicationId, activity.applicationId) && Intrinsics3.areEqual(this.details, activity.details) && Intrinsics3.areEqual(this.state, activity.state) && Intrinsics3.areEqual(this.emoji, activity.emoji) && Intrinsics3.areEqual(this.party, activity.party) && Intrinsics3.areEqual(this.assets, activity.assets) && Intrinsics3.areEqual(this.flags, activity.flags) && Intrinsics3.areEqual(this.syncId, activity.syncId) && Intrinsics3.areEqual(this.sessionId, activity.sessionId) && Intrinsics3.areEqual(this.metadata, activity.metadata) && Intrinsics3.areEqual(this.platform, activity.platform) && Intrinsics3.areEqual(this.supportedPlatforms, activity.supportedPlatforms) && Intrinsics3.areEqual(this.buttons, activity.buttons);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final ActivityEmoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Integer getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ActivityType activityType = this.type;
        int iHashCode2 = (iHashCode + (activityType != null ? activityType.hashCode() : 0)) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.createdAt;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        ActivityTimestamps activityTimestamps = this.timestamps;
        int iHashCode4 = (i + (activityTimestamps != null ? activityTimestamps.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.details;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.state;
        int iHashCode7 = (iHashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ActivityEmoji activityEmoji = this.emoji;
        int iHashCode8 = (iHashCode7 + (activityEmoji != null ? activityEmoji.hashCode() : 0)) * 31;
        ActivityParty activityParty = this.party;
        int iHashCode9 = (iHashCode8 + (activityParty != null ? activityParty.hashCode() : 0)) * 31;
        ActivityAssets activityAssets = this.assets;
        int iHashCode10 = (iHashCode9 + (activityAssets != null ? activityAssets.hashCode() : 0)) * 31;
        Integer num = this.flags;
        int iHashCode11 = (iHashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.syncId;
        int iHashCode12 = (iHashCode11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.sessionId;
        int iHashCode13 = (iHashCode12 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ActivityMetadata activityMetadata = this.metadata;
        int iHashCode14 = (iHashCode13 + (activityMetadata != null ? activityMetadata.hashCode() : 0)) * 31;
        ActivityPlatform activityPlatform = this.platform;
        int iHashCode15 = (iHashCode14 + (activityPlatform != null ? activityPlatform.hashCode() : 0)) * 31;
        List<ActivityPlatform> list = this.supportedPlatforms;
        int iHashCode16 = (iHashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.buttons;
        return iHashCode16 + (list2 != null ? list2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final ActivityParty getParty() {
        return this.party;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final ActivityPlatform getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getState() {
        return this.state;
    }

    public final List<ActivityPlatform> m() {
        return this.supportedPlatforms;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getSyncId() {
        return this.syncId;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final ActivityType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Activity(name=");
        sbU.append(this.name);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", timestamps=");
        sbU.append(this.timestamps);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", details=");
        sbU.append(this.details);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", party=");
        sbU.append(this.party);
        sbU.append(", assets=");
        sbU.append(this.assets);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", syncId=");
        sbU.append(this.syncId);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", metadata=");
        sbU.append(this.metadata);
        sbU.append(", platform=");
        sbU.append(this.platform);
        sbU.append(", supportedPlatforms=");
        sbU.append(this.supportedPlatforms);
        sbU.append(", buttons=");
        return outline.L(sbU, this.buttons, ")");
    }
}
