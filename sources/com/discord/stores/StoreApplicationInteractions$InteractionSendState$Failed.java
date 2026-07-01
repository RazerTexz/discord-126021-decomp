package com.discord.stores;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$InteractionSendState$Failed extends StoreApplicationInteractions$InteractionSendState {
    private final String errorMessage;

    public StoreApplicationInteractions$InteractionSendState$Failed() {
        this(null, 1, null);
    }

    public StoreApplicationInteractions$InteractionSendState$Failed(String str) {
        super(null);
        this.errorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ StoreApplicationInteractions$InteractionSendState$Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
