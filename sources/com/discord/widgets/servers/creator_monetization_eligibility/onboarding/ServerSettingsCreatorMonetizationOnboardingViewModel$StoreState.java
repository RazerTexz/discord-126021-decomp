package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState {
    private final Guild guild;
    private final boolean isGuildOwner;

    public ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState(Guild guild, boolean z2) {
        this.guild = guild;
        this.isGuildOwner = z2;
    }

    public static /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState copy$default(ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState serverSettingsCreatorMonetizationOnboardingViewModel$StoreState, Guild guild, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = serverSettingsCreatorMonetizationOnboardingViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            z2 = serverSettingsCreatorMonetizationOnboardingViewModel$StoreState.isGuildOwner;
        }
        return serverSettingsCreatorMonetizationOnboardingViewModel$StoreState.copy(guild, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsGuildOwner() {
        return this.isGuildOwner;
    }

    public final ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState copy(Guild guild, boolean isGuildOwner) {
        return new ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState(guild, isGuildOwner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState)) {
            return false;
        }
        ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState serverSettingsCreatorMonetizationOnboardingViewModel$StoreState = (ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState) other;
        return m.areEqual(this.guild, serverSettingsCreatorMonetizationOnboardingViewModel$StoreState.guild) && this.isGuildOwner == serverSettingsCreatorMonetizationOnboardingViewModel$StoreState.isGuildOwner;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.isGuildOwner;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isGuildOwner() {
        return this.isGuildOwner;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", isGuildOwner=");
        return a.O(sbU, this.isGuildOwner, ")");
    }
}
