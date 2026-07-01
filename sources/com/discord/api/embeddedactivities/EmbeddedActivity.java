package com.discord.api.embeddedactivities;

import b.d.b.a.outline;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivitySecrets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: EmbeddedActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbeddedActivity {
    private final long applicationId;
    private final ActivityAssets assets;
    private final Long createdAt;
    private final String details;
    private final String name;
    private final ActivitySecrets secrets;
    private final String state;
    private final ActivityTimestamps timestamps;
    private final ActivityType type;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final ActivityAssets getAssets() {
        return this.assets;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivity)) {
            return false;
        }
        EmbeddedActivity embeddedActivity = (EmbeddedActivity) other;
        return this.applicationId == embeddedActivity.applicationId && Intrinsics3.areEqual(this.assets, embeddedActivity.assets) && Intrinsics3.areEqual(this.createdAt, embeddedActivity.createdAt) && Intrinsics3.areEqual(this.details, embeddedActivity.details) && Intrinsics3.areEqual(this.name, embeddedActivity.name) && Intrinsics3.areEqual(this.secrets, embeddedActivity.secrets) && Intrinsics3.areEqual(this.state, embeddedActivity.state) && Intrinsics3.areEqual(this.timestamps, embeddedActivity.timestamps) && Intrinsics3.areEqual(this.type, embeddedActivity.type);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final ActivitySecrets getSecrets() {
        return this.secrets;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    public int hashCode() {
        long j = this.applicationId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        ActivityAssets activityAssets = this.assets;
        int iHashCode = (i + (activityAssets != null ? activityAssets.hashCode() : 0)) * 31;
        Long l = this.createdAt;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.details;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ActivitySecrets activitySecrets = this.secrets;
        int iHashCode5 = (iHashCode4 + (activitySecrets != null ? activitySecrets.hashCode() : 0)) * 31;
        String str3 = this.state;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ActivityTimestamps activityTimestamps = this.timestamps;
        int iHashCode7 = (iHashCode6 + (activityTimestamps != null ? activityTimestamps.hashCode() : 0)) * 31;
        ActivityType activityType = this.type;
        return iHashCode7 + (activityType != null ? activityType.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final ActivityType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbeddedActivity(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", assets=");
        sbU.append(this.assets);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", details=");
        sbU.append(this.details);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", secrets=");
        sbU.append(this.secrets);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", timestamps=");
        sbU.append(this.timestamps);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}
