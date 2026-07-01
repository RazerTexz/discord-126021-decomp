package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.a;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms extends ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState {
    private final Guild guild;
    private final boolean hasAcceptedTerms;
    private final boolean isGuildOwner;
    private final boolean isSubmitting;
    private final CreatorMonetizationEnableRequest latestRequest;

    public /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms(Guild guild, boolean z2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guild, z2, creatorMonetizationEnableRequest, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
    }

    public static /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms copy$default(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms, Guild guild, boolean z2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.guild;
        }
        if ((i & 2) != 0) {
            z2 = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.isGuildOwner;
        }
        boolean z5 = z2;
        if ((i & 4) != 0) {
            creatorMonetizationEnableRequest = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.latestRequest;
        }
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest2 = creatorMonetizationEnableRequest;
        if ((i & 8) != 0) {
            z3 = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.hasAcceptedTerms;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.isSubmitting;
        }
        return serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.copy(guild, z5, creatorMonetizationEnableRequest2, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsGuildOwner() {
        return this.isGuildOwner;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasAcceptedTerms() {
        return this.hasAcceptedTerms;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    public final ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms copy(Guild guild, boolean isGuildOwner, CreatorMonetizationEnableRequest latestRequest, boolean hasAcceptedTerms, boolean isSubmitting) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(latestRequest, "latestRequest");
        return new ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms(guild, isGuildOwner, latestRequest, hasAcceptedTerms, isSubmitting);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms)) {
            return false;
        }
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms = (ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) other;
        return m.areEqual(this.guild, serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.guild) && this.isGuildOwner == serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.isGuildOwner && m.areEqual(this.latestRequest, serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.latestRequest) && this.hasAcceptedTerms == serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.hasAcceptedTerms && this.isSubmitting == serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.isSubmitting;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean getHasAcceptedTerms() {
        return this.hasAcceptedTerms;
    }

    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.isGuildOwner;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = this.latestRequest;
        int iHashCode2 = (i + (creatorMonetizationEnableRequest != null ? creatorMonetizationEnableRequest.hashCode() : 0)) * 31;
        boolean z3 = this.hasAcceptedTerms;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode2 + r1) * 31;
        boolean z4 = this.isSubmitting;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isGuildOwner() {
        return this.isGuildOwner;
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        StringBuilder sbU = a.U("AcceptTerms(guild=");
        sbU.append(this.guild);
        sbU.append(", isGuildOwner=");
        sbU.append(this.isGuildOwner);
        sbU.append(", latestRequest=");
        sbU.append(this.latestRequest);
        sbU.append(", hasAcceptedTerms=");
        sbU.append(this.hasAcceptedTerms);
        sbU.append(", isSubmitting=");
        return a.O(sbU, this.isSubmitting, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms(Guild guild, boolean z2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z3, boolean z4) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(creatorMonetizationEnableRequest, "latestRequest");
        this.guild = guild;
        this.isGuildOwner = z2;
        this.latestRequest = creatorMonetizationEnableRequest;
        this.hasAcceptedTerms = z3;
        this.isSubmitting = z4;
    }
}
