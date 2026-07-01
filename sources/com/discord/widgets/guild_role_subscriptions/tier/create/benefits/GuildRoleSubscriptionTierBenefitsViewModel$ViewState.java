package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierBenefitsViewModel$ViewState {
    private final List<Integer> activeTrialUserLimitOptions;
    private final Boolean canAccessAllChannels;
    private final boolean canChangeChannelSettings;
    private final List<GuildRoleSubscriptionBenefitAdapterItem> items;
    private final List<SubscriptionTrialInterval> trialIntervalOptions;

    public GuildRoleSubscriptionTierBenefitsViewModel$ViewState() {
        this(false, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildRoleSubscriptionTierBenefitsViewModel$ViewState(boolean z2, List<? extends GuildRoleSubscriptionBenefitAdapterItem> list, Boolean bool, List<Integer> list2, List<SubscriptionTrialInterval> list3) {
        m.checkNotNullParameter(list, "items");
        m.checkNotNullParameter(list2, "activeTrialUserLimitOptions");
        m.checkNotNullParameter(list3, "trialIntervalOptions");
        this.canChangeChannelSettings = z2;
        this.items = list;
        this.canAccessAllChannels = bool;
        this.activeTrialUserLimitOptions = list2;
        this.trialIntervalOptions = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel$ViewState copy$default(GuildRoleSubscriptionTierBenefitsViewModel$ViewState guildRoleSubscriptionTierBenefitsViewModel$ViewState, boolean z2, List list, Boolean bool, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildRoleSubscriptionTierBenefitsViewModel$ViewState.canChangeChannelSettings;
        }
        if ((i & 2) != 0) {
            list = guildRoleSubscriptionTierBenefitsViewModel$ViewState.items;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            bool = guildRoleSubscriptionTierBenefitsViewModel$ViewState.canAccessAllChannels;
        }
        Boolean bool2 = bool;
        if ((i & 8) != 0) {
            list2 = guildRoleSubscriptionTierBenefitsViewModel$ViewState.activeTrialUserLimitOptions;
        }
        List list5 = list2;
        if ((i & 16) != 0) {
            list3 = guildRoleSubscriptionTierBenefitsViewModel$ViewState.trialIntervalOptions;
        }
        return guildRoleSubscriptionTierBenefitsViewModel$ViewState.copy(z2, list4, bool2, list5, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanChangeChannelSettings() {
        return this.canChangeChannelSettings;
    }

    public final List<GuildRoleSubscriptionBenefitAdapterItem> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getCanAccessAllChannels() {
        return this.canAccessAllChannels;
    }

    public final List<Integer> component4() {
        return this.activeTrialUserLimitOptions;
    }

    public final List<SubscriptionTrialInterval> component5() {
        return this.trialIntervalOptions;
    }

    public final GuildRoleSubscriptionTierBenefitsViewModel$ViewState copy(boolean canChangeChannelSettings, List<? extends GuildRoleSubscriptionBenefitAdapterItem> items, Boolean canAccessAllChannels, List<Integer> activeTrialUserLimitOptions, List<SubscriptionTrialInterval> trialIntervalOptions) {
        m.checkNotNullParameter(items, "items");
        m.checkNotNullParameter(activeTrialUserLimitOptions, "activeTrialUserLimitOptions");
        m.checkNotNullParameter(trialIntervalOptions, "trialIntervalOptions");
        return new GuildRoleSubscriptionTierBenefitsViewModel$ViewState(canChangeChannelSettings, items, canAccessAllChannels, activeTrialUserLimitOptions, trialIntervalOptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierBenefitsViewModel$ViewState)) {
            return false;
        }
        GuildRoleSubscriptionTierBenefitsViewModel$ViewState guildRoleSubscriptionTierBenefitsViewModel$ViewState = (GuildRoleSubscriptionTierBenefitsViewModel$ViewState) other;
        return this.canChangeChannelSettings == guildRoleSubscriptionTierBenefitsViewModel$ViewState.canChangeChannelSettings && m.areEqual(this.items, guildRoleSubscriptionTierBenefitsViewModel$ViewState.items) && m.areEqual(this.canAccessAllChannels, guildRoleSubscriptionTierBenefitsViewModel$ViewState.canAccessAllChannels) && m.areEqual(this.activeTrialUserLimitOptions, guildRoleSubscriptionTierBenefitsViewModel$ViewState.activeTrialUserLimitOptions) && m.areEqual(this.trialIntervalOptions, guildRoleSubscriptionTierBenefitsViewModel$ViewState.trialIntervalOptions);
    }

    public final List<Integer> getActiveTrialUserLimitOptions() {
        return this.activeTrialUserLimitOptions;
    }

    public final Boolean getCanAccessAllChannels() {
        return this.canAccessAllChannels;
    }

    public final boolean getCanChangeChannelSettings() {
        return this.canChangeChannelSettings;
    }

    public final List<GuildRoleSubscriptionBenefitAdapterItem> getItems() {
        return this.items;
    }

    public final List<SubscriptionTrialInterval> getTrialIntervalOptions() {
        return this.trialIntervalOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z2 = this.canChangeChannelSettings;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<GuildRoleSubscriptionBenefitAdapterItem> list = this.items;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.canAccessAllChannels;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        List<Integer> list2 = this.activeTrialUserLimitOptions;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<SubscriptionTrialInterval> list3 = this.trialIntervalOptions;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(canChangeChannelSettings=");
        sbU.append(this.canChangeChannelSettings);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", canAccessAllChannels=");
        sbU.append(this.canAccessAllChannels);
        sbU.append(", activeTrialUserLimitOptions=");
        sbU.append(this.activeTrialUserLimitOptions);
        sbU.append(", trialIntervalOptions=");
        return a.L(sbU, this.trialIntervalOptions, ")");
    }

    public /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel$ViewState(boolean z2, List list, Boolean bool, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? n.emptyList() : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? n.emptyList() : list2, (i & 16) != 0 ? n.emptyList() : list3);
    }
}
