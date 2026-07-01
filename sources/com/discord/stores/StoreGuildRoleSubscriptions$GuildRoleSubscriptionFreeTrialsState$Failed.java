package com.discord.stores;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Failed extends StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState {
    private final String errorMessage;

    public StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Failed() {
        this(null, 1, null);
    }

    public StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Failed(String str) {
        super(null);
        this.errorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
