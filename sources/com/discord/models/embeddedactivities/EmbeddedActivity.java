package com.discord.models.embeddedactivities;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivitySecrets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmbeddedActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbeddedActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long applicationId;
    private final ActivityAssets assets;
    private final Long createdAt;
    private final String details;
    private final long guildId;
    private final String name;
    private final ActivitySecrets secrets;
    private final String state;
    private final ActivityTimestamps timestamps;
    private final ActivityType type;
    private final String url;
    private final List<Long> userIds;

    /* JADX INFO: compiled from: EmbeddedActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public final EmbeddedActivity fromApiEmbeddedActivity(com.discord.api.embeddedactivities.EmbeddedActivity apiEmbeddedActivity, List<Long> userIds, String url, long guildId) {
            Intrinsics3.checkNotNullParameter(apiEmbeddedActivity, "apiEmbeddedActivity");
            Intrinsics3.checkNotNullParameter(userIds, "userIds");
            Intrinsics3.checkNotNullParameter(url, "url");
            long jA = apiEmbeddedActivity.getApplicationId();
            ActivityAssets activityAssetsB = apiEmbeddedActivity.getAssets();
            Long lC = apiEmbeddedActivity.getCreatedAt();
            String strD = apiEmbeddedActivity.getDetails();
            String strE = apiEmbeddedActivity.getName();
            ActivitySecrets activitySecretsF = apiEmbeddedActivity.getSecrets();
            String strG = apiEmbeddedActivity.getState();
            ActivityTimestamps activityTimestampsH = apiEmbeddedActivity.getTimestamps();
            ActivityType activityTypeI = apiEmbeddedActivity.getType();
            if (activityTypeI == null) {
                activityTypeI = ActivityType.UNKNOWN;
            }
            return new EmbeddedActivity(jA, activityAssetsB, lC, strD, strE, activitySecretsF, strG, activityTimestampsH, activityTypeI, userIds, url, guildId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EmbeddedActivity(long j, ActivityAssets activityAssets, Long l, String str, String str2, ActivitySecrets activitySecrets, String str3, ActivityTimestamps activityTimestamps, ActivityType activityType, List<Long> list, String str4, long j2) {
        Intrinsics3.checkNotNullParameter(activityType, "type");
        Intrinsics3.checkNotNullParameter(list, "userIds");
        Intrinsics3.checkNotNullParameter(str4, "url");
        this.applicationId = j;
        this.assets = activityAssets;
        this.createdAt = l;
        this.details = str;
        this.name = str2;
        this.secrets = activitySecrets;
        this.state = str3;
        this.timestamps = activityTimestamps;
        this.type = activityType;
        this.userIds = list;
        this.url = str4;
        this.guildId = j2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    public final List<Long> component10() {
        return this.userIds;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ActivityAssets getAssets() {
        return this.assets;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ActivitySecrets getSecrets() {
        return this.secrets;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ActivityType getType() {
        return this.type;
    }

    public final EmbeddedActivity copy(long applicationId, ActivityAssets assets, Long createdAt, String details, String name, ActivitySecrets secrets, String state, ActivityTimestamps timestamps, ActivityType type, List<Long> userIds, String url, long guildId) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Intrinsics3.checkNotNullParameter(url, "url");
        return new EmbeddedActivity(applicationId, assets, createdAt, details, name, secrets, state, timestamps, type, userIds, url, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivity)) {
            return false;
        }
        EmbeddedActivity embeddedActivity = (EmbeddedActivity) other;
        return this.applicationId == embeddedActivity.applicationId && Intrinsics3.areEqual(this.assets, embeddedActivity.assets) && Intrinsics3.areEqual(this.createdAt, embeddedActivity.createdAt) && Intrinsics3.areEqual(this.details, embeddedActivity.details) && Intrinsics3.areEqual(this.name, embeddedActivity.name) && Intrinsics3.areEqual(this.secrets, embeddedActivity.secrets) && Intrinsics3.areEqual(this.state, embeddedActivity.state) && Intrinsics3.areEqual(this.timestamps, embeddedActivity.timestamps) && Intrinsics3.areEqual(this.type, embeddedActivity.type) && Intrinsics3.areEqual(this.userIds, embeddedActivity.userIds) && Intrinsics3.areEqual(this.url, embeddedActivity.url) && this.guildId == embeddedActivity.guildId;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final ActivityAssets getAssets() {
        return this.assets;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDetails() {
        return this.details;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getName() {
        return this.name;
    }

    public final ActivitySecrets getSecrets() {
        return this.secrets;
    }

    public final String getState() {
        return this.state;
    }

    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    public final ActivityType getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<Long> getUserIds() {
        return this.userIds;
    }

    public int hashCode() {
        int iA = b.a(this.applicationId) * 31;
        ActivityAssets activityAssets = this.assets;
        int iHashCode = (iA + (activityAssets != null ? activityAssets.hashCode() : 0)) * 31;
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
        int iHashCode8 = (iHashCode7 + (activityType != null ? activityType.hashCode() : 0)) * 31;
        List<Long> list = this.userIds;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.url;
        return b.a(this.guildId) + ((iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31);
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
        sbU.append(", userIds=");
        sbU.append(this.userIds);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", guildId=");
        return outline.C(sbU, this.guildId, ")");
    }
}
