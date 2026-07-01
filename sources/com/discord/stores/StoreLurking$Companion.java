package com.discord.stores;

import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$Companion {
    private StoreLurking$Companion() {
    }

    public static final /* synthetic */ boolean access$isLurking(StoreLurking$Companion storeLurking$Companion, boolean z2, long j, Set set) {
        return storeLurking$Companion.isLurking(z2, j, set);
    }

    private final boolean isLurking(boolean isJoined, long guildId, Set<Long> lurkingGuildIds) {
        return !isJoined && lurkingGuildIds.contains(Long.valueOf(guildId));
    }

    public /* synthetic */ StoreLurking$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
