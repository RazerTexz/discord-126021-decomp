package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsViewModel$ViewState$Loaded extends SettingsViewModel$ViewState {
    private final boolean isStaffOrAlpha;
    private final MeUser meUser;
    private final Presence presence;
    private final int promoCount;
    private final boolean pushNotificationUpsellDismissed;
    private final boolean showRoleSubscriptionsButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$ViewState$Loaded(MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4) {
        super(null);
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(presence, "presence");
        this.meUser = meUser;
        this.isStaffOrAlpha = z2;
        this.presence = presence;
        this.promoCount = i;
        this.pushNotificationUpsellDismissed = z3;
        this.showRoleSubscriptionsButton = z4;
    }

    public static /* synthetic */ SettingsViewModel$ViewState$Loaded copy$default(SettingsViewModel$ViewState$Loaded settingsViewModel$ViewState$Loaded, MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            meUser = settingsViewModel$ViewState$Loaded.meUser;
        }
        if ((i2 & 2) != 0) {
            z2 = settingsViewModel$ViewState$Loaded.isStaffOrAlpha;
        }
        boolean z5 = z2;
        if ((i2 & 4) != 0) {
            presence = settingsViewModel$ViewState$Loaded.presence;
        }
        Presence presence2 = presence;
        if ((i2 & 8) != 0) {
            i = settingsViewModel$ViewState$Loaded.promoCount;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z3 = settingsViewModel$ViewState$Loaded.pushNotificationUpsellDismissed;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            z4 = settingsViewModel$ViewState$Loaded.showRoleSubscriptionsButton;
        }
        return settingsViewModel$ViewState$Loaded.copy(meUser, z5, presence2, i3, z6, z4);
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
    public final boolean getShowRoleSubscriptionsButton() {
        return this.showRoleSubscriptionsButton;
    }

    public final SettingsViewModel$ViewState$Loaded copy(MeUser meUser, boolean isStaffOrAlpha, Presence presence, int promoCount, boolean pushNotificationUpsellDismissed, boolean showRoleSubscriptionsButton) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(presence, "presence");
        return new SettingsViewModel$ViewState$Loaded(meUser, isStaffOrAlpha, presence, promoCount, pushNotificationUpsellDismissed, showRoleSubscriptionsButton);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsViewModel$ViewState$Loaded)) {
            return false;
        }
        SettingsViewModel$ViewState$Loaded settingsViewModel$ViewState$Loaded = (SettingsViewModel$ViewState$Loaded) other;
        return m.areEqual(this.meUser, settingsViewModel$ViewState$Loaded.meUser) && this.isStaffOrAlpha == settingsViewModel$ViewState$Loaded.isStaffOrAlpha && m.areEqual(this.presence, settingsViewModel$ViewState$Loaded.presence) && this.promoCount == settingsViewModel$ViewState$Loaded.promoCount && this.pushNotificationUpsellDismissed == settingsViewModel$ViewState$Loaded.pushNotificationUpsellDismissed && this.showRoleSubscriptionsButton == settingsViewModel$ViewState$Loaded.showRoleSubscriptionsButton;
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

    public final boolean getShowRoleSubscriptionsButton() {
        return this.showRoleSubscriptionsButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
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
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode2 + r1) * 31;
        boolean z4 = this.showRoleSubscriptionsButton;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isStaffOrAlpha() {
        return this.isStaffOrAlpha;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(meUser=");
        sbU.append(this.meUser);
        sbU.append(", isStaffOrAlpha=");
        sbU.append(this.isStaffOrAlpha);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", promoCount=");
        sbU.append(this.promoCount);
        sbU.append(", pushNotificationUpsellDismissed=");
        sbU.append(this.pushNotificationUpsellDismissed);
        sbU.append(", showRoleSubscriptionsButton=");
        return a.O(sbU, this.showRoleSubscriptionsButton, ")");
    }
}
