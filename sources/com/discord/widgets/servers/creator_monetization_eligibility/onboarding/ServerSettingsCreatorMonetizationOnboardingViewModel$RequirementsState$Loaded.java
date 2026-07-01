package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.a;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState {
    private final CreatorMonetizationEligibilityRequirements requirements;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        super(null);
        m.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "requirements");
        this.requirements = creatorMonetizationEligibilityRequirements;
    }

    public static /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded copy$default(ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded, CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, int i, Object obj) {
        if ((i & 1) != 0) {
            creatorMonetizationEligibilityRequirements = serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded.requirements;
        }
        return serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded.copy(creatorMonetizationEligibilityRequirements);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CreatorMonetizationEligibilityRequirements getRequirements() {
        return this.requirements;
    }

    public final ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded copy(CreatorMonetizationEligibilityRequirements requirements) {
        m.checkNotNullParameter(requirements, "requirements");
        return new ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded(requirements);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded) && m.areEqual(this.requirements, ((ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded) other).requirements);
        }
        return true;
    }

    public final CreatorMonetizationEligibilityRequirements getRequirements() {
        return this.requirements;
    }

    public int hashCode() {
        CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements = this.requirements;
        if (creatorMonetizationEligibilityRequirements != null) {
            return creatorMonetizationEligibilityRequirements.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(requirements=");
        sbU.append(this.requirements);
        sbU.append(")");
        return sbU.toString();
    }
}
