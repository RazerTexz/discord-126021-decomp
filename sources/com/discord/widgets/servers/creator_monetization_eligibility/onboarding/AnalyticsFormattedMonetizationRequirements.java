package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.outline;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.google.gson.Gson;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AnalyticsFormattedMonetizationRequirements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AnalyticsFormattedMonetizationRequirements {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy gsonInstance$delegate = LazyJVM.lazy(AnalyticsFormattedMonetizationRequirements2.INSTANCE);
    private final boolean canApply;
    private final Integer communicatorCount;
    private final Integer guildMemberCount;
    private final boolean hasMemberRetention;
    private final boolean hasSufficientMembers;
    private final boolean isApplicationPending;
    private final boolean isEligibleForMonetization;
    private final CreatorMonetizationEnableRequest latestRequest;
    private final boolean meetsServerAgeRequirement;
    private final int minimumAgeInDays;
    private final int minimumSize;
    private final boolean noRecentViolations;
    private final boolean notNSFW;
    private final CreatorMonetizationEligibilityRequirements.Rejection rejection;
    private final Double retentionScore;
    private final boolean weeklyCommunicators;

    /* JADX INFO: compiled from: AnalyticsFormattedMonetizationRequirements.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Gson getGsonInstance() {
            Lazy lazy = AnalyticsFormattedMonetizationRequirements.gsonInstance$delegate;
            Companion companion = AnalyticsFormattedMonetizationRequirements.INSTANCE;
            return (Gson) lazy.getValue();
        }

        public final AnalyticsFormattedMonetizationRequirements toAnalyticsFormat(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            Intrinsics3.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "$this$toAnalyticsFormat");
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
            boolean z3 = (latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest.State.OPEN;
            int minimumAgeInDays = creatorMonetizationEligibilityRequirements.getMinimumAgeInDays();
            int minimumSize = creatorMonetizationEligibilityRequirements.getMinimumSize();
            CreatorMonetizationEnableRequest latestRequest2 = creatorMonetizationEligibilityRequirements.getLatestRequest();
            CreatorMonetizationEligibilityRequirements.Rejection rejection = creatorMonetizationEligibilityRequirements.getRejection();
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore = creatorMonetizationEligibilityRequirements.getHealthScore();
            Integer guildSize = healthScore != null ? healthScore.getGuildSize() : null;
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore2 = creatorMonetizationEligibilityRequirements.getHealthScore();
            Integer communicators = healthScore2 != null ? healthScore2.getCommunicators() : null;
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore3 = creatorMonetizationEligibilityRequirements.getHealthScore();
            return new AnalyticsFormattedMonetizationRequirements(sufficient, size, age, safeEnvironment, engagementHealthy, retentionHealthy, z2, canApply, z3, minimumAgeInDays, minimumSize, latestRequest2, rejection, guildSize, communicators, healthScore3 != null ? healthScore3.getPercRetW1() : null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnalyticsFormattedMonetizationRequirements(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, int i2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer num, Integer num2, Double d) {
        this.isEligibleForMonetization = z2;
        this.hasSufficientMembers = z3;
        this.meetsServerAgeRequirement = z4;
        this.noRecentViolations = z5;
        this.weeklyCommunicators = z6;
        this.hasMemberRetention = z7;
        this.notNSFW = z8;
        this.canApply = z9;
        this.isApplicationPending = z10;
        this.minimumAgeInDays = i;
        this.minimumSize = i2;
        this.latestRequest = creatorMonetizationEnableRequest;
        this.rejection = rejection;
        this.guildMemberCount = num;
        this.communicatorCount = num2;
        this.retentionScore = d;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsEligibleForMonetization() {
        return this.isEligibleForMonetization;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getMinimumSize() {
        return this.minimumSize;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final CreatorMonetizationEligibilityRequirements.Rejection getRejection() {
        return this.rejection;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getGuildMemberCount() {
        return this.guildMemberCount;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getCommunicatorCount() {
        return this.communicatorCount;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Double getRetentionScore() {
        return this.retentionScore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasSufficientMembers() {
        return this.hasSufficientMembers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getMeetsServerAgeRequirement() {
        return this.meetsServerAgeRequirement;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getNoRecentViolations() {
        return this.noRecentViolations;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getWeeklyCommunicators() {
        return this.weeklyCommunicators;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasMemberRetention() {
        return this.hasMemberRetention;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getNotNSFW() {
        return this.notNSFW;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanApply() {
        return this.canApply;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsApplicationPending() {
        return this.isApplicationPending;
    }

    public final AnalyticsFormattedMonetizationRequirements copy(boolean isEligibleForMonetization, boolean hasSufficientMembers, boolean meetsServerAgeRequirement, boolean noRecentViolations, boolean weeklyCommunicators, boolean hasMemberRetention, boolean notNSFW, boolean canApply, boolean isApplicationPending, int minimumAgeInDays, int minimumSize, CreatorMonetizationEnableRequest latestRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer guildMemberCount, Integer communicatorCount, Double retentionScore) {
        return new AnalyticsFormattedMonetizationRequirements(isEligibleForMonetization, hasSufficientMembers, meetsServerAgeRequirement, noRecentViolations, weeklyCommunicators, hasMemberRetention, notNSFW, canApply, isApplicationPending, minimumAgeInDays, minimumSize, latestRequest, rejection, guildMemberCount, communicatorCount, retentionScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyticsFormattedMonetizationRequirements)) {
            return false;
        }
        AnalyticsFormattedMonetizationRequirements analyticsFormattedMonetizationRequirements = (AnalyticsFormattedMonetizationRequirements) other;
        return this.isEligibleForMonetization == analyticsFormattedMonetizationRequirements.isEligibleForMonetization && this.hasSufficientMembers == analyticsFormattedMonetizationRequirements.hasSufficientMembers && this.meetsServerAgeRequirement == analyticsFormattedMonetizationRequirements.meetsServerAgeRequirement && this.noRecentViolations == analyticsFormattedMonetizationRequirements.noRecentViolations && this.weeklyCommunicators == analyticsFormattedMonetizationRequirements.weeklyCommunicators && this.hasMemberRetention == analyticsFormattedMonetizationRequirements.hasMemberRetention && this.notNSFW == analyticsFormattedMonetizationRequirements.notNSFW && this.canApply == analyticsFormattedMonetizationRequirements.canApply && this.isApplicationPending == analyticsFormattedMonetizationRequirements.isApplicationPending && this.minimumAgeInDays == analyticsFormattedMonetizationRequirements.minimumAgeInDays && this.minimumSize == analyticsFormattedMonetizationRequirements.minimumSize && Intrinsics3.areEqual(this.latestRequest, analyticsFormattedMonetizationRequirements.latestRequest) && Intrinsics3.areEqual(this.rejection, analyticsFormattedMonetizationRequirements.rejection) && Intrinsics3.areEqual(this.guildMemberCount, analyticsFormattedMonetizationRequirements.guildMemberCount) && Intrinsics3.areEqual(this.communicatorCount, analyticsFormattedMonetizationRequirements.communicatorCount) && Intrinsics3.areEqual(this.retentionScore, analyticsFormattedMonetizationRequirements.retentionScore);
    }

    public final boolean getCanApply() {
        return this.canApply;
    }

    public final Integer getCommunicatorCount() {
        return this.communicatorCount;
    }

    public final Integer getGuildMemberCount() {
        return this.guildMemberCount;
    }

    public final boolean getHasMemberRetention() {
        return this.hasMemberRetention;
    }

    public final boolean getHasSufficientMembers() {
        return this.hasSufficientMembers;
    }

    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    public final boolean getMeetsServerAgeRequirement() {
        return this.meetsServerAgeRequirement;
    }

    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    public final int getMinimumSize() {
        return this.minimumSize;
    }

    public final boolean getNoRecentViolations() {
        return this.noRecentViolations;
    }

    public final boolean getNotNSFW() {
        return this.notNSFW;
    }

    public final CreatorMonetizationEligibilityRequirements.Rejection getRejection() {
        return this.rejection;
    }

    public final Double getRetentionScore() {
        return this.retentionScore;
    }

    public final boolean getWeeklyCommunicators() {
        return this.weeklyCommunicators;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean z2 = this.isEligibleForMonetization;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.hasSufficientMembers;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.meetsServerAgeRequirement;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.noRecentViolations;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.weeklyCommunicators;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.hasMemberRetention;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.notNSFW;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i7 = (i6 + r7) * 31;
        boolean z9 = this.canApply;
        ?? r8 = z9;
        if (z9) {
            r8 = 1;
        }
        int i8 = (i7 + r8) * 31;
        boolean z10 = this.isApplicationPending;
        int i9 = (((((i8 + (z10 ? 1 : z10)) * 31) + this.minimumAgeInDays) * 31) + this.minimumSize) * 31;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = this.latestRequest;
        int iHashCode = (i9 + (creatorMonetizationEnableRequest != null ? creatorMonetizationEnableRequest.hashCode() : 0)) * 31;
        CreatorMonetizationEligibilityRequirements.Rejection rejection = this.rejection;
        int iHashCode2 = (iHashCode + (rejection != null ? rejection.hashCode() : 0)) * 31;
        Integer num = this.guildMemberCount;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.communicatorCount;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Double d = this.retentionScore;
        return iHashCode4 + (d != null ? d.hashCode() : 0);
    }

    public final boolean isApplicationPending() {
        return this.isApplicationPending;
    }

    public final boolean isEligibleForMonetization() {
        return this.isEligibleForMonetization;
    }

    public final String toJson() {
        String strM = INSTANCE.getGsonInstance().m(this);
        Intrinsics3.checkNotNullExpressionValue(strM, "gsonInstance.toJson(this)");
        return strM;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AnalyticsFormattedMonetizationRequirements(isEligibleForMonetization=");
        sbU.append(this.isEligibleForMonetization);
        sbU.append(", hasSufficientMembers=");
        sbU.append(this.hasSufficientMembers);
        sbU.append(", meetsServerAgeRequirement=");
        sbU.append(this.meetsServerAgeRequirement);
        sbU.append(", noRecentViolations=");
        sbU.append(this.noRecentViolations);
        sbU.append(", weeklyCommunicators=");
        sbU.append(this.weeklyCommunicators);
        sbU.append(", hasMemberRetention=");
        sbU.append(this.hasMemberRetention);
        sbU.append(", notNSFW=");
        sbU.append(this.notNSFW);
        sbU.append(", canApply=");
        sbU.append(this.canApply);
        sbU.append(", isApplicationPending=");
        sbU.append(this.isApplicationPending);
        sbU.append(", minimumAgeInDays=");
        sbU.append(this.minimumAgeInDays);
        sbU.append(", minimumSize=");
        sbU.append(this.minimumSize);
        sbU.append(", latestRequest=");
        sbU.append(this.latestRequest);
        sbU.append(", rejection=");
        sbU.append(this.rejection);
        sbU.append(", guildMemberCount=");
        sbU.append(this.guildMemberCount);
        sbU.append(", communicatorCount=");
        sbU.append(this.communicatorCount);
        sbU.append(", retentionScore=");
        sbU.append(this.retentionScore);
        sbU.append(")");
        return sbU.toString();
    }
}
