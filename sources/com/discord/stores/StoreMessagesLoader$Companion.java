package com.discord.stores;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$Companion {
    private StoreMessagesLoader$Companion() {
    }

    public final boolean isScrollToAction(long targetMessageId) {
        return targetMessageId == 0 || targetMessageId == 1;
    }

    public /* synthetic */ StoreMessagesLoader$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
