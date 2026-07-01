package com.discord.stores;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class LoadState {
    private LoadState() {
    }

    public final boolean isLoading() {
        return (this instanceof LoadState$Loading) || (this instanceof LoadState$LoadingUp) || (this instanceof LoadState$LoadingDown);
    }

    public /* synthetic */ LoadState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
