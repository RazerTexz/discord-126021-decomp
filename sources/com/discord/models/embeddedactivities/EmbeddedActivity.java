package com.discord.models.embeddedactivities;

import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivitySecrets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(apiEmbeddedActivity, "apiEmbeddedActivity");
            C12238m.checkNotNullParameter(userIds, "userIds");
            C12238m.checkNotNullParameter(url, "url");
            long jM7793a = apiEmbeddedActivity.getApplicationId();
            ActivityAssets activityAssetsM7794b = apiEmbeddedActivity.getAssets();
            Long lM7795c = apiEmbeddedActivity.getCreatedAt();
            String strM7796d = apiEmbeddedActivity.getDetails();
            String strM7797e = apiEmbeddedActivity.getName();
            ActivitySecrets activitySecretsM7798f = apiEmbeddedActivity.getSecrets();
            String strM7799g = apiEmbeddedActivity.getState();
            ActivityTimestamps activityTimestampsM7800h = apiEmbeddedActivity.getTimestamps();
            ActivityType activityTypeM7801i = apiEmbeddedActivity.getType();
            if (activityTypeM7801i == null) {
                activityTypeM7801i = ActivityType.UNKNOWN;
            }
            return new EmbeddedActivity(jM7793a, activityAssetsM7794b, lM7795c, strM7796d, strM7797e, activitySecretsM7798f, strM7799g, activityTimestampsM7800h, activityTypeM7801i, userIds, url, guildId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EmbeddedActivity(long j, ActivityAssets activityAssets, Long l, String str, String str2, ActivitySecrets activitySecrets, String str3, ActivityTimestamps activityTimestamps, ActivityType activityType, List<Long> list, String str4, long j2) {
        C12238m.checkNotNullParameter(activityType, "type");
        C12238m.checkNotNullParameter(list, "userIds");
        C12238m.checkNotNullParameter(str4, "url");
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
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(userIds, "userIds");
        C12238m.checkNotNullParameter(url, "url");
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
        return this.applicationId == embeddedActivity.applicationId && C12238m.areEqual(this.assets, embeddedActivity.assets) && C12238m.areEqual(this.createdAt, embeddedActivity.createdAt) && C12238m.areEqual(this.details, embeddedActivity.details) && C12238m.areEqual(this.name, embeddedActivity.name) && C12238m.areEqual(this.secrets, embeddedActivity.secrets) && C12238m.areEqual(this.state, embeddedActivity.state) && C12238m.areEqual(this.timestamps, embeddedActivity.timestamps) && C12238m.areEqual(this.type, embeddedActivity.type) && C12238m.areEqual(this.userIds, embeddedActivity.userIds) && C12238m.areEqual(this.url, embeddedActivity.url) && this.guildId == embeddedActivity.guildId;
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
        int iM3a = C0002b.m3a(this.applicationId) * 31;
        ActivityAssets activityAssets = this.assets;
        int iHashCode = (iM3a + (activityAssets != null ? activityAssets.hashCode() : 0)) * 31;
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
        return C0002b.m3a(this.guildId) + ((iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31);
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
        sbM833U.append(", userIds=");
        sbM833U.append(this.userIds);
        sbM833U.append(", url=");
        sbM833U.append(this.url);
        sbM833U.append(", guildId=");
        return C1643a.m815C(sbM833U, this.guildId, ")");
    }
}
