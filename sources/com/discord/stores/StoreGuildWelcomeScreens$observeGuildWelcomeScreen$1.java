package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1 extends o implements Function0<StoreGuildWelcomeScreens$State> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildWelcomeScreens this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        super(0);
        this.this$0 = storeGuildWelcomeScreens;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGuildWelcomeScreens$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGuildWelcomeScreens$State invoke() {
        return this.this$0.getGuildWelcomeScreen(this.$guildId);
    }
}
