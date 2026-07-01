package com.discord.widgets.guild_role_subscriptions.setup;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionPlanSetupViewModel$ViewState {
    private final boolean canProceedToNextStep;
    private final String coverImage;
    private final int currentStep;
    private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private final Boolean isFullServerGating;
    private final boolean isSubmitting;
    private final String planDescription;

    public GuildRoleSubscriptionPlanSetupViewModel$ViewState() {
        this(0, false, false, null, null, null, null, Opcodes.LAND, null);
    }

    public GuildRoleSubscriptionPlanSetupViewModel$ViewState(int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.currentStep = i;
        this.isSubmitting = z2;
        this.canProceedToNextStep = z3;
        this.coverImage = str;
        this.planDescription = str2;
        this.isFullServerGating = bool;
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
    }

    public static /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel$ViewState copy$default(GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState, int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildRoleSubscriptionPlanSetupViewModel$ViewState.currentStep;
        }
        if ((i2 & 2) != 0) {
            z2 = guildRoleSubscriptionPlanSetupViewModel$ViewState.isSubmitting;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = guildRoleSubscriptionPlanSetupViewModel$ViewState.canProceedToNextStep;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            str = guildRoleSubscriptionPlanSetupViewModel$ViewState.coverImage;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = guildRoleSubscriptionPlanSetupViewModel$ViewState.planDescription;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            bool = guildRoleSubscriptionPlanSetupViewModel$ViewState.isFullServerGating;
        }
        Boolean bool2 = bool;
        if ((i2 & 64) != 0) {
            guildRoleSubscriptionTier = guildRoleSubscriptionPlanSetupViewModel$ViewState.guildRoleSubscriptionTier;
        }
        return guildRoleSubscriptionPlanSetupViewModel$ViewState.copy(i, z4, z5, str3, str4, bool2, guildRoleSubscriptionTier);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentStep() {
        return this.currentStep;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanProceedToNextStep() {
        return this.canProceedToNextStep;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPlanDescription() {
        return this.planDescription;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsFullServerGating() {
        return this.isFullServerGating;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    public final GuildRoleSubscriptionPlanSetupViewModel$ViewState copy(int currentStep, boolean isSubmitting, boolean canProceedToNextStep, String coverImage, String planDescription, Boolean isFullServerGating, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        return new GuildRoleSubscriptionPlanSetupViewModel$ViewState(currentStep, isSubmitting, canProceedToNextStep, coverImage, planDescription, isFullServerGating, guildRoleSubscriptionTier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionPlanSetupViewModel$ViewState)) {
            return false;
        }
        GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState = (GuildRoleSubscriptionPlanSetupViewModel$ViewState) other;
        return this.currentStep == guildRoleSubscriptionPlanSetupViewModel$ViewState.currentStep && this.isSubmitting == guildRoleSubscriptionPlanSetupViewModel$ViewState.isSubmitting && this.canProceedToNextStep == guildRoleSubscriptionPlanSetupViewModel$ViewState.canProceedToNextStep && m.areEqual(this.coverImage, guildRoleSubscriptionPlanSetupViewModel$ViewState.coverImage) && m.areEqual(this.planDescription, guildRoleSubscriptionPlanSetupViewModel$ViewState.planDescription) && m.areEqual(this.isFullServerGating, guildRoleSubscriptionPlanSetupViewModel$ViewState.isFullServerGating) && m.areEqual(this.guildRoleSubscriptionTier, guildRoleSubscriptionPlanSetupViewModel$ViewState.guildRoleSubscriptionTier);
    }

    public final boolean getCanProceedToNextStep() {
        return this.canProceedToNextStep;
    }

    public final String getCoverImage() {
        return this.coverImage;
    }

    public final int getCurrentStep() {
        return this.currentStep;
    }

    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    public final String getPlanDescription() {
        return this.planDescription;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        int i = this.currentStep * 31;
        boolean z2 = this.isSubmitting;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z3 = this.canProceedToNextStep;
        int i3 = (i2 + (z3 ? 1 : z3)) * 31;
        String str = this.coverImage;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.planDescription;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.isFullServerGating;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
        return iHashCode3 + (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0);
    }

    public final Boolean isFullServerGating() {
        return this.isFullServerGating;
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(currentStep=");
        sbU.append(this.currentStep);
        sbU.append(", isSubmitting=");
        sbU.append(this.isSubmitting);
        sbU.append(", canProceedToNextStep=");
        sbU.append(this.canProceedToNextStep);
        sbU.append(", coverImage=");
        sbU.append(this.coverImage);
        sbU.append(", planDescription=");
        sbU.append(this.planDescription);
        sbU.append(", isFullServerGating=");
        sbU.append(this.isFullServerGating);
        sbU.append(", guildRoleSubscriptionTier=");
        sbU.append(this.guildRoleSubscriptionTier);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel$ViewState(int i, boolean z2, boolean z3, String str, String str2, Boolean bool, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? z3 : false, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2, (i2 & 32) == 0 ? bool : null, (i2 & 64) != 0 ? new GuildRoleSubscriptionTier(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : guildRoleSubscriptionTier);
    }
}
