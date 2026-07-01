package com.discord.models.embeddedactivities;

import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivitySecrets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmbeddedActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmbeddedActivity$Companion {
    private EmbeddedActivity$Companion() {
    }

    public final EmbeddedActivity fromApiEmbeddedActivity(com.discord.api.embeddedactivities.EmbeddedActivity apiEmbeddedActivity, List<Long> userIds, String url, long guildId) {
        m.checkNotNullParameter(apiEmbeddedActivity, "apiEmbeddedActivity");
        m.checkNotNullParameter(userIds, "userIds");
        m.checkNotNullParameter(url, "url");
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

    public /* synthetic */ EmbeddedActivity$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
