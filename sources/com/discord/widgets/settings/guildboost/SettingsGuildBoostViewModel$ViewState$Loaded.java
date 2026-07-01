package com.discord.widgets.settings.guildboost;

import b.d.b.a.a;
import com.discord.api.premium.PremiumTier;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGuildBoostViewModel$ViewState$Loaded extends SettingsGuildBoostViewModel$ViewState {
    private final boolean canCancelBoosts;
    private final boolean canUncancelBoosts;
    private final List<WidgetSettingsGuildBoostSubscriptionAdapter$Item> guildBoostItems;
    private final SettingsGuildBoostViewModel$PendingAction pendingAction;
    private final List<SettingsGuildBoostSampleGuildAdapter$Item> sampleGuildItems;
    private final PremiumTier userPremiumTier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsGuildBoostViewModel$ViewState$Loaded(boolean z2, boolean z3, List<? extends WidgetSettingsGuildBoostSubscriptionAdapter$Item> list, List<SettingsGuildBoostSampleGuildAdapter$Item> list2, SettingsGuildBoostViewModel$PendingAction settingsGuildBoostViewModel$PendingAction, PremiumTier premiumTier) {
        super(null);
        m.checkNotNullParameter(list, "guildBoostItems");
        m.checkNotNullParameter(list2, "sampleGuildItems");
        m.checkNotNullParameter(premiumTier, "userPremiumTier");
        this.canCancelBoosts = z2;
        this.canUncancelBoosts = z3;
        this.guildBoostItems = list;
        this.sampleGuildItems = list2;
        this.pendingAction = settingsGuildBoostViewModel$PendingAction;
        this.userPremiumTier = premiumTier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsGuildBoostViewModel$ViewState$Loaded copy$default(SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded, boolean z2, boolean z3, List list, List list2, SettingsGuildBoostViewModel$PendingAction settingsGuildBoostViewModel$PendingAction, PremiumTier premiumTier, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = settingsGuildBoostViewModel$ViewState$Loaded.canCancelBoosts;
        }
        if ((i & 2) != 0) {
            z3 = settingsGuildBoostViewModel$ViewState$Loaded.canUncancelBoosts;
        }
        boolean z4 = z3;
        if ((i & 4) != 0) {
            list = settingsGuildBoostViewModel$ViewState$Loaded.guildBoostItems;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = settingsGuildBoostViewModel$ViewState$Loaded.sampleGuildItems;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            settingsGuildBoostViewModel$PendingAction = settingsGuildBoostViewModel$ViewState$Loaded.pendingAction;
        }
        SettingsGuildBoostViewModel$PendingAction settingsGuildBoostViewModel$PendingAction2 = settingsGuildBoostViewModel$PendingAction;
        if ((i & 32) != 0) {
            premiumTier = settingsGuildBoostViewModel$ViewState$Loaded.userPremiumTier;
        }
        return settingsGuildBoostViewModel$ViewState$Loaded.copy(z2, z4, list3, list4, settingsGuildBoostViewModel$PendingAction2, premiumTier);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanCancelBoosts() {
        return this.canCancelBoosts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanUncancelBoosts() {
        return this.canUncancelBoosts;
    }

    public final List<WidgetSettingsGuildBoostSubscriptionAdapter$Item> component3() {
        return this.guildBoostItems;
    }

    public final List<SettingsGuildBoostSampleGuildAdapter$Item> component4() {
        return this.sampleGuildItems;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SettingsGuildBoostViewModel$PendingAction getPendingAction() {
        return this.pendingAction;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PremiumTier getUserPremiumTier() {
        return this.userPremiumTier;
    }

    public final SettingsGuildBoostViewModel$ViewState$Loaded copy(boolean canCancelBoosts, boolean canUncancelBoosts, List<? extends WidgetSettingsGuildBoostSubscriptionAdapter$Item> guildBoostItems, List<SettingsGuildBoostSampleGuildAdapter$Item> sampleGuildItems, SettingsGuildBoostViewModel$PendingAction pendingAction, PremiumTier userPremiumTier) {
        m.checkNotNullParameter(guildBoostItems, "guildBoostItems");
        m.checkNotNullParameter(sampleGuildItems, "sampleGuildItems");
        m.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        return new SettingsGuildBoostViewModel$ViewState$Loaded(canCancelBoosts, canUncancelBoosts, guildBoostItems, sampleGuildItems, pendingAction, userPremiumTier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGuildBoostViewModel$ViewState$Loaded)) {
            return false;
        }
        SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded = (SettingsGuildBoostViewModel$ViewState$Loaded) other;
        return this.canCancelBoosts == settingsGuildBoostViewModel$ViewState$Loaded.canCancelBoosts && this.canUncancelBoosts == settingsGuildBoostViewModel$ViewState$Loaded.canUncancelBoosts && m.areEqual(this.guildBoostItems, settingsGuildBoostViewModel$ViewState$Loaded.guildBoostItems) && m.areEqual(this.sampleGuildItems, settingsGuildBoostViewModel$ViewState$Loaded.sampleGuildItems) && m.areEqual(this.pendingAction, settingsGuildBoostViewModel$ViewState$Loaded.pendingAction) && m.areEqual(this.userPremiumTier, settingsGuildBoostViewModel$ViewState$Loaded.userPremiumTier);
    }

    public final boolean getCanCancelBoosts() {
        return this.canCancelBoosts;
    }

    public final boolean getCanUncancelBoosts() {
        return this.canUncancelBoosts;
    }

    public final List<WidgetSettingsGuildBoostSubscriptionAdapter$Item> getGuildBoostItems() {
        return this.guildBoostItems;
    }

    public final SettingsGuildBoostViewModel$PendingAction getPendingAction() {
        return this.pendingAction;
    }

    public final List<SettingsGuildBoostSampleGuildAdapter$Item> getSampleGuildItems() {
        return this.sampleGuildItems;
    }

    public final PremiumTier getUserPremiumTier() {
        return this.userPremiumTier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        boolean z2 = this.canCancelBoosts;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.canUncancelBoosts;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        List<WidgetSettingsGuildBoostSubscriptionAdapter$Item> list = this.guildBoostItems;
        int iHashCode = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        List<SettingsGuildBoostSampleGuildAdapter$Item> list2 = this.sampleGuildItems;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        SettingsGuildBoostViewModel$PendingAction settingsGuildBoostViewModel$PendingAction = this.pendingAction;
        int iHashCode3 = (iHashCode2 + (settingsGuildBoostViewModel$PendingAction != null ? settingsGuildBoostViewModel$PendingAction.hashCode() : 0)) * 31;
        PremiumTier premiumTier = this.userPremiumTier;
        return iHashCode3 + (premiumTier != null ? premiumTier.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(canCancelBoosts=");
        sbU.append(this.canCancelBoosts);
        sbU.append(", canUncancelBoosts=");
        sbU.append(this.canUncancelBoosts);
        sbU.append(", guildBoostItems=");
        sbU.append(this.guildBoostItems);
        sbU.append(", sampleGuildItems=");
        sbU.append(this.sampleGuildItems);
        sbU.append(", pendingAction=");
        sbU.append(this.pendingAction);
        sbU.append(", userPremiumTier=");
        sbU.append(this.userPremiumTier);
        sbU.append(")");
        return sbU.toString();
    }
}
