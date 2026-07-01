package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements$HealthScore;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements$Rejection;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest$State;
import com.google.gson.Gson;
import d0.z.d.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AnalyticsFormattedMonetizationRequirements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsFormattedMonetizationRequirements$Companion {
    private AnalyticsFormattedMonetizationRequirements$Companion() {
    }

    public static final /* synthetic */ Gson access$getGsonInstance$p(AnalyticsFormattedMonetizationRequirements$Companion analyticsFormattedMonetizationRequirements$Companion) {
        return analyticsFormattedMonetizationRequirements$Companion.getGsonInstance();
    }

    private final Gson getGsonInstance() {
        Lazy lazyAccess$getGsonInstance$cp = AnalyticsFormattedMonetizationRequirements.access$getGsonInstance$cp();
        AnalyticsFormattedMonetizationRequirements$Companion analyticsFormattedMonetizationRequirements$Companion = AnalyticsFormattedMonetizationRequirements.Companion;
        return (Gson) lazyAccess$getGsonInstance$cp.getValue();
    }

    public final AnalyticsFormattedMonetizationRequirements toAnalyticsFormat(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        m.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "$this$toAnalyticsFormat");
        boolean sufficient = creatorMonetizationEligibilityRequirements.getSufficient();
        boolean size = creatorMonetizationEligibilityRequirements.getSize();
        boolean age = creatorMonetizationEligibilityRequirements.getAge();
        boolean safeEnvironment = creatorMonetizationEligibilityRequirements.getSafeEnvironment();
        boolean engagementHealthy = creatorMonetizationEligibilityRequirements.getEngagementHealthy();
        boolean retentionHealthy = creatorMonetizationEligibilityRequirements.getRetentionHealthy();
        Map<String, Object> mapI = creatorMonetizationEligibilityRequirements.i();
        boolean z2 = mapI == null || mapI.isEmpty();
        boolean canApply = creatorMonetizationEligibilityRequirements.getCanApply();
        CreatorMonetizationEnableRequest latestRequest = creatorMonetizationEligibilityRequirements.getLatestRequest();
        boolean z3 = (latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest$State.OPEN;
        int minimumAgeInDays = creatorMonetizationEligibilityRequirements.getMinimumAgeInDays();
        int minimumSize = creatorMonetizationEligibilityRequirements.getMinimumSize();
        CreatorMonetizationEnableRequest latestRequest2 = creatorMonetizationEligibilityRequirements.getLatestRequest();
        CreatorMonetizationEligibilityRequirements$Rejection rejection = creatorMonetizationEligibilityRequirements.getRejection();
        CreatorMonetizationEligibilityRequirements$HealthScore healthScore = creatorMonetizationEligibilityRequirements.getHealthScore();
        Integer guildSize = healthScore != null ? healthScore.getGuildSize() : null;
        CreatorMonetizationEligibilityRequirements$HealthScore healthScore2 = creatorMonetizationEligibilityRequirements.getHealthScore();
        Integer communicators = healthScore2 != null ? healthScore2.getCommunicators() : null;
        CreatorMonetizationEligibilityRequirements$HealthScore healthScore3 = creatorMonetizationEligibilityRequirements.getHealthScore();
        return new AnalyticsFormattedMonetizationRequirements(sufficient, size, age, safeEnvironment, engagementHealthy, retentionHealthy, z2, canApply, z3, minimumAgeInDays, minimumSize, latestRequest2, rejection, guildSize, communicators, healthScore3 != null ? healthScore3.getPercRetW1() : null);
    }

    public /* synthetic */ AnalyticsFormattedMonetizationRequirements$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
