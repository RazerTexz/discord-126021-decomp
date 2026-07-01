package com.discord.api.creatormonetization;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: CreatorMonetizationEligibilityRequirements.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEligibilityRequirements$HealthScore {
    private final Integer avgNonnewCommunicators;
    private final Integer avgNonnewParticipators;
    private final Integer communicators;
    private final Integer guildSize;
    private final Integer numIntentfulJoiners;
    private final Double percRetW1;
    private final Double percRetW1Intentful;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getCommunicators() {
        return this.communicators;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getGuildSize() {
        return this.guildSize;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Double getPercRetW1() {
        return this.percRetW1;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatorMonetizationEligibilityRequirements$HealthScore)) {
            return false;
        }
        CreatorMonetizationEligibilityRequirements$HealthScore creatorMonetizationEligibilityRequirements$HealthScore = (CreatorMonetizationEligibilityRequirements$HealthScore) other;
        return m.areEqual(this.avgNonnewParticipators, creatorMonetizationEligibilityRequirements$HealthScore.avgNonnewParticipators) && m.areEqual(this.avgNonnewCommunicators, creatorMonetizationEligibilityRequirements$HealthScore.avgNonnewCommunicators) && m.areEqual(this.numIntentfulJoiners, creatorMonetizationEligibilityRequirements$HealthScore.numIntentfulJoiners) && m.areEqual(this.percRetW1Intentful, creatorMonetizationEligibilityRequirements$HealthScore.percRetW1Intentful) && m.areEqual(this.guildSize, creatorMonetizationEligibilityRequirements$HealthScore.guildSize) && m.areEqual(this.communicators, creatorMonetizationEligibilityRequirements$HealthScore.communicators) && m.areEqual(this.percRetW1, creatorMonetizationEligibilityRequirements$HealthScore.percRetW1);
    }

    public int hashCode() {
        Integer num = this.avgNonnewParticipators;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.avgNonnewCommunicators;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.numIntentfulJoiners;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Double d = this.percRetW1Intentful;
        int iHashCode4 = (iHashCode3 + (d != null ? d.hashCode() : 0)) * 31;
        Integer num4 = this.guildSize;
        int iHashCode5 = (iHashCode4 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.communicators;
        int iHashCode6 = (iHashCode5 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Double d2 = this.percRetW1;
        return iHashCode6 + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HealthScore(avgNonnewParticipators=");
        sbU.append(this.avgNonnewParticipators);
        sbU.append(", avgNonnewCommunicators=");
        sbU.append(this.avgNonnewCommunicators);
        sbU.append(", numIntentfulJoiners=");
        sbU.append(this.numIntentfulJoiners);
        sbU.append(", percRetW1Intentful=");
        sbU.append(this.percRetW1Intentful);
        sbU.append(", guildSize=");
        sbU.append(this.guildSize);
        sbU.append(", communicators=");
        sbU.append(this.communicators);
        sbU.append(", percRetW1=");
        sbU.append(this.percRetW1);
        sbU.append(")");
        return sbU.toString();
    }
}
