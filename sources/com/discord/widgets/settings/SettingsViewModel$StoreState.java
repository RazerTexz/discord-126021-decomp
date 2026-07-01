package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsViewModel$StoreState {
    private final boolean isEligibleForMobileWebSubscriptions;
    private final boolean isStaffOrAlpha;
    private final MeUser meUser;
    private final Presence presence;
    private final int promoCount;
    private final boolean pushNotificationUpsellDismissed;
    private final List<ModelSubscription> subscriptions;

    public SettingsViewModel$StoreState(MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, List<ModelSubscription> list) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(presence, "presence");
        this.meUser = meUser;
        this.isStaffOrAlpha = z2;
        this.presence = presence;
        this.promoCount = i;
        this.pushNotificationUpsellDismissed = z3;
        this.isEligibleForMobileWebSubscriptions = z4;
        this.subscriptions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsViewModel$StoreState copy$default(SettingsViewModel$StoreState settingsViewModel$StoreState, MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            meUser = settingsViewModel$StoreState.meUser;
        }
        if ((i2 & 2) != 0) {
            z2 = settingsViewModel$StoreState.isStaffOrAlpha;
        }
        boolean z5 = z2;
        if ((i2 & 4) != 0) {
            presence = settingsViewModel$StoreState.presence;
        }
        Presence presence2 = presence;
        if ((i2 & 8) != 0) {
            i = settingsViewModel$StoreState.promoCount;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z3 = settingsViewModel$StoreState.pushNotificationUpsellDismissed;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            z4 = settingsViewModel$StoreState.isEligibleForMobileWebSubscriptions;
        }
        boolean z7 = z4;
        if ((i2 & 64) != 0) {
            list = settingsViewModel$StoreState.subscriptions;
        }
        return settingsViewModel$StoreState.copy(meUser, z5, presence2, i3, z6, z7, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsStaffOrAlpha() {
        return this.isStaffOrAlpha;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPromoCount() {
        return this.promoCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getPushNotificationUpsellDismissed() {
        return this.pushNotificationUpsellDismissed;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsEligibleForMobileWebSubscriptions() {
        return this.isEligibleForMobileWebSubscriptions;
    }

    public final List<ModelSubscription> component7() {
        return this.subscriptions;
    }

    public final SettingsViewModel$StoreState copy(MeUser meUser, boolean isStaffOrAlpha, Presence presence, int promoCount, boolean pushNotificationUpsellDismissed, boolean isEligibleForMobileWebSubscriptions, List<ModelSubscription> subscriptions) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(presence, "presence");
        return new SettingsViewModel$StoreState(meUser, isStaffOrAlpha, presence, promoCount, pushNotificationUpsellDismissed, isEligibleForMobileWebSubscriptions, subscriptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsViewModel$StoreState)) {
            return false;
        }
        SettingsViewModel$StoreState settingsViewModel$StoreState = (SettingsViewModel$StoreState) other;
        return m.areEqual(this.meUser, settingsViewModel$StoreState.meUser) && this.isStaffOrAlpha == settingsViewModel$StoreState.isStaffOrAlpha && m.areEqual(this.presence, settingsViewModel$StoreState.presence) && this.promoCount == settingsViewModel$StoreState.promoCount && this.pushNotificationUpsellDismissed == settingsViewModel$StoreState.pushNotificationUpsellDismissed && this.isEligibleForMobileWebSubscriptions == settingsViewModel$StoreState.isEligibleForMobileWebSubscriptions && m.areEqual(this.subscriptions, settingsViewModel$StoreState.subscriptions);
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final int getPromoCount() {
        return this.promoCount;
    }

    public final boolean getPushNotificationUpsellDismissed() {
        return this.pushNotificationUpsellDismissed;
    }

    public final List<ModelSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        MeUser meUser = this.meUser;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        boolean z2 = this.isStaffOrAlpha;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        Presence presence = this.presence;
        int iHashCode2 = (((i + (presence != null ? presence.hashCode() : 0)) * 31) + this.promoCount) * 31;
        boolean z3 = this.pushNotificationUpsellDismissed;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode2 + r3) * 31;
        boolean z4 = this.isEligibleForMobileWebSubscriptions;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        List<ModelSubscription> list = this.subscriptions;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isEligibleForMobileWebSubscriptions() {
        return this.isEligibleForMobileWebSubscriptions;
    }

    public final boolean isStaffOrAlpha() {
        return this.isStaffOrAlpha;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(meUser=");
        sbU.append(this.meUser);
        sbU.append(", isStaffOrAlpha=");
        sbU.append(this.isStaffOrAlpha);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", promoCount=");
        sbU.append(this.promoCount);
        sbU.append(", pushNotificationUpsellDismissed=");
        sbU.append(this.pushNotificationUpsellDismissed);
        sbU.append(", isEligibleForMobileWebSubscriptions=");
        sbU.append(this.isEligibleForMobileWebSubscriptions);
        sbU.append(", subscriptions=");
        return a.L(sbU, this.subscriptions, ")");
    }
}
