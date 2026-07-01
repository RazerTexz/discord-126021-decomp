package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CreateGuildRoleSubscriptionTierViewModel$ViewState {
    private final boolean canProceed;
    private final int currentStep;
    private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private final boolean isSubmitting;

    public CreateGuildRoleSubscriptionTierViewModel$ViewState() {
        this(0, false, false, null, 15, null);
    }

    public CreateGuildRoleSubscriptionTierViewModel$ViewState(int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        this.currentStep = i;
        this.canProceed = z2;
        this.isSubmitting = z3;
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
    }

    public static /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$ViewState copy$default(CreateGuildRoleSubscriptionTierViewModel$ViewState createGuildRoleSubscriptionTierViewModel$ViewState, int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = createGuildRoleSubscriptionTierViewModel$ViewState.currentStep;
        }
        if ((i2 & 2) != 0) {
            z2 = createGuildRoleSubscriptionTierViewModel$ViewState.canProceed;
        }
        if ((i2 & 4) != 0) {
            z3 = createGuildRoleSubscriptionTierViewModel$ViewState.isSubmitting;
        }
        if ((i2 & 8) != 0) {
            guildRoleSubscriptionTier = createGuildRoleSubscriptionTierViewModel$ViewState.guildRoleSubscriptionTier;
        }
        return createGuildRoleSubscriptionTierViewModel$ViewState.copy(i, z2, z3, guildRoleSubscriptionTier);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentStep() {
        return this.currentStep;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanProceed() {
        return this.canProceed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    public final CreateGuildRoleSubscriptionTierViewModel$ViewState copy(int currentStep, boolean canProceed, boolean isSubmitting, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        return new CreateGuildRoleSubscriptionTierViewModel$ViewState(currentStep, canProceed, isSubmitting, guildRoleSubscriptionTier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateGuildRoleSubscriptionTierViewModel$ViewState)) {
            return false;
        }
        CreateGuildRoleSubscriptionTierViewModel$ViewState createGuildRoleSubscriptionTierViewModel$ViewState = (CreateGuildRoleSubscriptionTierViewModel$ViewState) other;
        return this.currentStep == createGuildRoleSubscriptionTierViewModel$ViewState.currentStep && this.canProceed == createGuildRoleSubscriptionTierViewModel$ViewState.canProceed && this.isSubmitting == createGuildRoleSubscriptionTierViewModel$ViewState.isSubmitting && m.areEqual(this.guildRoleSubscriptionTier, createGuildRoleSubscriptionTierViewModel$ViewState.guildRoleSubscriptionTier);
    }

    public final boolean getCanProceed() {
        return this.canProceed;
    }

    public final int getCurrentStep() {
        return this.currentStep;
    }

    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int i = this.currentStep * 31;
        boolean z2 = this.canProceed;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z3 = this.isSubmitting;
        int i3 = (i2 + (z3 ? 1 : z3)) * 31;
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
        return i3 + (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0);
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(currentStep=");
        sbU.append(this.currentStep);
        sbU.append(", canProceed=");
        sbU.append(this.canProceed);
        sbU.append(", isSubmitting=");
        sbU.append(this.isSubmitting);
        sbU.append(", guildRoleSubscriptionTier=");
        sbU.append(this.guildRoleSubscriptionTier);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$ViewState(int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? null : guildRoleSubscriptionTier);
    }
}
