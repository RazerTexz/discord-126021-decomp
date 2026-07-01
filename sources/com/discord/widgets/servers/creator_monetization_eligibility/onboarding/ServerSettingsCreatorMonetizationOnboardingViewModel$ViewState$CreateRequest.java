package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.a;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest$State;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest extends ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState {
    private final boolean isGuildOwner;
    private final boolean isSubmitting;
    private final CreatorMonetizationEligibilityRequirements requirements;

    public /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(creatorMonetizationEligibilityRequirements, z2, (i & 4) != 0 ? false : z3);
    }

    public static /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest copy$default(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest, CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            creatorMonetizationEligibilityRequirements = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.requirements;
        }
        if ((i & 2) != 0) {
            z2 = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.isGuildOwner;
        }
        if ((i & 4) != 0) {
            z3 = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.isSubmitting;
        }
        return serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.copy(creatorMonetizationEligibilityRequirements, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CreatorMonetizationEligibilityRequirements getRequirements() {
        return this.requirements;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsGuildOwner() {
        return this.isGuildOwner;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    public final ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest copy(CreatorMonetizationEligibilityRequirements requirements, boolean isGuildOwner, boolean isSubmitting) {
        m.checkNotNullParameter(requirements, "requirements");
        return new ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest(requirements, isGuildOwner, isSubmitting);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest)) {
            return false;
        }
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest = (ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) other;
        return m.areEqual(this.requirements, serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.requirements) && this.isGuildOwner == serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.isGuildOwner && this.isSubmitting == serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.isSubmitting;
    }

    public final CreatorMonetizationEligibilityRequirements getRequirements() {
        return this.requirements;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements = this.requirements;
        int iHashCode = (creatorMonetizationEligibilityRequirements != null ? creatorMonetizationEligibilityRequirements.hashCode() : 0) * 31;
        boolean z2 = this.isGuildOwner;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isSubmitting;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isApplicationPending() {
        CreatorMonetizationEnableRequest latestRequest = this.requirements.getLatestRequest();
        return (latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest$State.OPEN;
    }

    public final boolean isGuildOwner() {
        return this.isGuildOwner;
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        StringBuilder sbU = a.U("CreateRequest(requirements=");
        sbU.append(this.requirements);
        sbU.append(", isGuildOwner=");
        sbU.append(this.isGuildOwner);
        sbU.append(", isSubmitting=");
        return a.O(sbU, this.isSubmitting, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "requirements");
        this.requirements = creatorMonetizationEligibilityRequirements;
        this.isGuildOwner = z2;
        this.isSubmitting = z3;
    }
}
