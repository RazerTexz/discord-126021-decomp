package com.discord.api.guildrolesubscription;

import com.discord.widgets.chat.AutocompleteUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum GuildRoleSubscriptionBenefitType {
    UNKNOWN(0),
    CHANNEL(1),
    INTANGIBLE(2);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitType.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    GuildRoleSubscriptionBenefitType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
