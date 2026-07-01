package com.discord.api.creatormonetization;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: CreatorMonetizationEligibilityRequirements.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEligibilityRequirements {
    private final boolean age;
    private final boolean canApply;
    private final boolean engagementHealthy;
    private final long guildId;
    private final CreatorMonetizationEligibilityRequirements$HealthScore healthScore;
    private final boolean healthScorePending;
    private final CreatorMonetizationEnableRequest latestRequest;
    private final int minimumAgeInDays;
    private final int minimumSize;
    private final Map<String, Object> nsfwProperties;
    private final CreatorMonetizationEligibilityRequirements$Rejection rejection;
    private final boolean retentionHealthy;
    private final boolean safeEnvironment;
    private final boolean size;
    private final boolean sufficient;

    public CreatorMonetizationEligibilityRequirements(long j, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z2, boolean z3, boolean z4, boolean z5, Map<String, ? extends Object> map, boolean z6, boolean z7, boolean z8, CreatorMonetizationEligibilityRequirements$HealthScore creatorMonetizationEligibilityRequirements$HealthScore, boolean z9, CreatorMonetizationEligibilityRequirements$Rejection creatorMonetizationEligibilityRequirements$Rejection, int i, int i2) {
        m.checkNotNullParameter(map, "nsfwProperties");
        this.guildId = j;
        this.latestRequest = creatorMonetizationEnableRequest;
        this.canApply = z2;
        this.sufficient = z3;
        this.age = z4;
        this.engagementHealthy = z5;
        this.nsfwProperties = map;
        this.retentionHealthy = z6;
        this.safeEnvironment = z7;
        this.size = z8;
        this.healthScore = creatorMonetizationEligibilityRequirements$HealthScore;
        this.healthScorePending = z9;
        this.rejection = creatorMonetizationEligibilityRequirements$Rejection;
        this.minimumAgeInDays = i;
        this.minimumSize = i2;
    }

    public static CreatorMonetizationEligibilityRequirements a(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, long j, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z2, boolean z3, boolean z4, boolean z5, Map map, boolean z6, boolean z7, boolean z8, CreatorMonetizationEligibilityRequirements$HealthScore creatorMonetizationEligibilityRequirements$HealthScore, boolean z9, CreatorMonetizationEligibilityRequirements$Rejection creatorMonetizationEligibilityRequirements$Rejection, int i, int i2, int i3) {
        long j2 = (i3 & 1) != 0 ? creatorMonetizationEligibilityRequirements.guildId : j;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest2 = (i3 & 2) != 0 ? creatorMonetizationEligibilityRequirements.latestRequest : creatorMonetizationEnableRequest;
        boolean z10 = (i3 & 4) != 0 ? creatorMonetizationEligibilityRequirements.canApply : z2;
        boolean z11 = (i3 & 8) != 0 ? creatorMonetizationEligibilityRequirements.sufficient : z3;
        boolean z12 = (i3 & 16) != 0 ? creatorMonetizationEligibilityRequirements.age : z4;
        boolean z13 = (i3 & 32) != 0 ? creatorMonetizationEligibilityRequirements.engagementHealthy : z5;
        Map<String, Object> map2 = (i3 & 64) != 0 ? creatorMonetizationEligibilityRequirements.nsfwProperties : null;
        boolean z14 = (i3 & 128) != 0 ? creatorMonetizationEligibilityRequirements.retentionHealthy : z6;
        boolean z15 = (i3 & 256) != 0 ? creatorMonetizationEligibilityRequirements.safeEnvironment : z7;
        boolean z16 = (i3 & 512) != 0 ? creatorMonetizationEligibilityRequirements.size : z8;
        CreatorMonetizationEligibilityRequirements$HealthScore creatorMonetizationEligibilityRequirements$HealthScore2 = (i3 & 1024) != 0 ? creatorMonetizationEligibilityRequirements.healthScore : null;
        boolean z17 = (i3 & 2048) != 0 ? creatorMonetizationEligibilityRequirements.healthScorePending : z9;
        CreatorMonetizationEligibilityRequirements$Rejection creatorMonetizationEligibilityRequirements$Rejection2 = (i3 & 4096) != 0 ? creatorMonetizationEligibilityRequirements.rejection : null;
        int i4 = (i3 & 8192) != 0 ? creatorMonetizationEligibilityRequirements.minimumAgeInDays : i;
        int i5 = (i3 & 16384) != 0 ? creatorMonetizationEligibilityRequirements.minimumSize : i2;
        Objects.requireNonNull(creatorMonetizationEligibilityRequirements);
        m.checkNotNullParameter(map2, "nsfwProperties");
        return new CreatorMonetizationEligibilityRequirements(j2, creatorMonetizationEnableRequest2, z10, z11, z12, z13, map2, z14, z15, z16, creatorMonetizationEligibilityRequirements$HealthScore2, z17, creatorMonetizationEligibilityRequirements$Rejection2, i4, i5);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getAge() {
        return this.age;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getCanApply() {
        return this.canApply;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getEngagementHealthy() {
        return this.engagementHealthy;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final CreatorMonetizationEligibilityRequirements$HealthScore getHealthScore() {
        return this.healthScore;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatorMonetizationEligibilityRequirements)) {
            return false;
        }
        CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements = (CreatorMonetizationEligibilityRequirements) other;
        return this.guildId == creatorMonetizationEligibilityRequirements.guildId && m.areEqual(this.latestRequest, creatorMonetizationEligibilityRequirements.latestRequest) && this.canApply == creatorMonetizationEligibilityRequirements.canApply && this.sufficient == creatorMonetizationEligibilityRequirements.sufficient && this.age == creatorMonetizationEligibilityRequirements.age && this.engagementHealthy == creatorMonetizationEligibilityRequirements.engagementHealthy && m.areEqual(this.nsfwProperties, creatorMonetizationEligibilityRequirements.nsfwProperties) && this.retentionHealthy == creatorMonetizationEligibilityRequirements.retentionHealthy && this.safeEnvironment == creatorMonetizationEligibilityRequirements.safeEnvironment && this.size == creatorMonetizationEligibilityRequirements.size && m.areEqual(this.healthScore, creatorMonetizationEligibilityRequirements.healthScore) && this.healthScorePending == creatorMonetizationEligibilityRequirements.healthScorePending && m.areEqual(this.rejection, creatorMonetizationEligibilityRequirements.rejection) && this.minimumAgeInDays == creatorMonetizationEligibilityRequirements.minimumAgeInDays && this.minimumSize == creatorMonetizationEligibilityRequirements.minimumSize;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final int getMinimumSize() {
        return this.minimumSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = this.latestRequest;
        int iHashCode = (i + (creatorMonetizationEnableRequest != null ? creatorMonetizationEnableRequest.hashCode() : 0)) * 31;
        boolean z2 = this.canApply;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (iHashCode + r0) * 31;
        boolean z3 = this.sufficient;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i3 = (i2 + r1) * 31;
        boolean z4 = this.age;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i4 = (i3 + r2) * 31;
        boolean z5 = this.engagementHealthy;
        ?? r3 = z5;
        if (z5) {
            r3 = 1;
        }
        int i5 = (i4 + r3) * 31;
        Map<String, Object> map = this.nsfwProperties;
        int iHashCode2 = (i5 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z6 = this.retentionHealthy;
        ?? r4 = z6;
        if (z6) {
            r4 = 1;
        }
        int i6 = (iHashCode2 + r4) * 31;
        boolean z7 = this.safeEnvironment;
        ?? r5 = z7;
        if (z7) {
            r5 = 1;
        }
        int i7 = (i6 + r5) * 31;
        boolean z8 = this.size;
        ?? r6 = z8;
        if (z8) {
            r6 = 1;
        }
        int i8 = (i7 + r6) * 31;
        CreatorMonetizationEligibilityRequirements$HealthScore creatorMonetizationEligibilityRequirements$HealthScore = this.healthScore;
        int iHashCode3 = (i8 + (creatorMonetizationEligibilityRequirements$HealthScore != null ? creatorMonetizationEligibilityRequirements$HealthScore.hashCode() : 0)) * 31;
        boolean z9 = this.healthScorePending;
        int i9 = (iHashCode3 + (z9 ? 1 : z9)) * 31;
        CreatorMonetizationEligibilityRequirements$Rejection creatorMonetizationEligibilityRequirements$Rejection = this.rejection;
        return ((((i9 + (creatorMonetizationEligibilityRequirements$Rejection != null ? creatorMonetizationEligibilityRequirements$Rejection.hashCode() : 0)) * 31) + this.minimumAgeInDays) * 31) + this.minimumSize;
    }

    public final Map<String, Object> i() {
        return this.nsfwProperties;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final CreatorMonetizationEligibilityRequirements$Rejection getRejection() {
        return this.rejection;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getRetentionHealthy() {
        return this.retentionHealthy;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final boolean getSafeEnvironment() {
        return this.safeEnvironment;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final boolean getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final boolean getSufficient() {
        return this.sufficient;
    }

    public String toString() {
        StringBuilder sbU = a.U("CreatorMonetizationEligibilityRequirements(guildId=");
        sbU.append(this.guildId);
        sbU.append(", latestRequest=");
        sbU.append(this.latestRequest);
        sbU.append(", canApply=");
        sbU.append(this.canApply);
        sbU.append(", sufficient=");
        sbU.append(this.sufficient);
        sbU.append(", age=");
        sbU.append(this.age);
        sbU.append(", engagementHealthy=");
        sbU.append(this.engagementHealthy);
        sbU.append(", nsfwProperties=");
        sbU.append(this.nsfwProperties);
        sbU.append(", retentionHealthy=");
        sbU.append(this.retentionHealthy);
        sbU.append(", safeEnvironment=");
        sbU.append(this.safeEnvironment);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(", healthScore=");
        sbU.append(this.healthScore);
        sbU.append(", healthScorePending=");
        sbU.append(this.healthScorePending);
        sbU.append(", rejection=");
        sbU.append(this.rejection);
        sbU.append(", minimumAgeInDays=");
        sbU.append(this.minimumAgeInDays);
        sbU.append(", minimumSize=");
        return a.B(sbU, this.minimumSize, ")");
    }
}
