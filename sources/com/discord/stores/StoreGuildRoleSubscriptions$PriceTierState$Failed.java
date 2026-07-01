package com.discord.stores;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions$PriceTierState$Failed extends StoreGuildRoleSubscriptions$PriceTierState {
    private final String errorMessage;

    public StoreGuildRoleSubscriptions$PriceTierState$Failed() {
        this(null, 1, null);
    }

    public StoreGuildRoleSubscriptions$PriceTierState$Failed(String str) {
        super(null);
        this.errorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ StoreGuildRoleSubscriptions$PriceTierState$Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
