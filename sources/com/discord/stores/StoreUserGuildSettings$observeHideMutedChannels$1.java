package com.discord.stores;

import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$observeHideMutedChannels$1 extends o implements Function0<Set<? extends Long>> {
    public final /* synthetic */ StoreUserGuildSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserGuildSettings$observeHideMutedChannels$1(StoreUserGuildSettings storeUserGuildSettings) {
        super(0);
        this.this$0 = storeUserGuildSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends Long> invoke2() {
        return this.this$0.getGuildsToHideMutedChannelsIn();
    }
}
