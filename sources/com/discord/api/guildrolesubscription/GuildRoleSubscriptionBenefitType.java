package com.discord.api.guildrolesubscription;

import com.discord.widgets.chat.AutocompleteSelectionTypes;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum GuildRoleSubscriptionBenefitType {
    UNKNOWN(0),
    CHANNEL(1),
    INTANGIBLE(2);

    public static final GuildRoleSubscriptionBenefitType$Companion Companion = new GuildRoleSubscriptionBenefitType$Companion(null);
    private final int apiValue;

    GuildRoleSubscriptionBenefitType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
