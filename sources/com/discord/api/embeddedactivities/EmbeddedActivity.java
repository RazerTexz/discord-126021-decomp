package com.discord.api.embeddedactivities;

import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivitySecrets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.applicationId == embeddedActivity.applicationId && C12238m.areEqual(this.assets, embeddedActivity.assets) && C12238m.areEqual(this.createdAt, embeddedActivity.createdAt) && C12238m.areEqual(this.details, embeddedActivity.details) && C12238m.areEqual(this.name, embeddedActivity.name) && C12238m.areEqual(this.secrets, embeddedActivity.secrets) && C12238m.areEqual(this.state, embeddedActivity.state) && C12238m.areEqual(this.timestamps, embeddedActivity.timestamps) && C12238m.areEqual(this.type, embeddedActivity.type);
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
        StringBuilder sbM833U = C1643a.m833U("EmbeddedActivity(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", assets=");
        sbM833U.append(this.assets);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", details=");
        sbM833U.append(this.details);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", secrets=");
        sbM833U.append(this.secrets);
        sbM833U.append(", state=");
        sbM833U.append(this.state);
        sbM833U.append(", timestamps=");
        sbM833U.append(this.timestamps);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
