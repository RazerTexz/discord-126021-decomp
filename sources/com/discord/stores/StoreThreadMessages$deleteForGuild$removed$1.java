package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreThreadMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMessages$deleteForGuild$removed$1 extends o implements Function1<StoreThreadMessages$ThreadState, Boolean> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadMessages$deleteForGuild$removed$1(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadMessages$ThreadState storeThreadMessages$ThreadState) {
        return Boolean.valueOf(invoke2(storeThreadMessages$ThreadState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadMessages$ThreadState storeThreadMessages$ThreadState) {
        m.checkNotNullParameter(storeThreadMessages$ThreadState, "thread");
        return storeThreadMessages$ThreadState.getGuildId() == this.$guildId;
    }
}
