package com.discord.stores;

import com.discord.api.guild.welcome.GuildWelcomeScreen;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ GuildWelcomeScreen $guildWelcomeScreen;
    public final /* synthetic */ StoreGuildWelcomeScreens$fetchIfNonexisting$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1(StoreGuildWelcomeScreens$fetchIfNonexisting$1$1 storeGuildWelcomeScreens$fetchIfNonexisting$1$1, GuildWelcomeScreen guildWelcomeScreen) {
        super(0);
        this.this$0 = storeGuildWelcomeScreens$fetchIfNonexisting$1$1;
        this.$guildWelcomeScreen = guildWelcomeScreen;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildWelcomeScreens$fetchIfNonexisting$1 storeGuildWelcomeScreens$fetchIfNonexisting$1 = this.this$0.this$0;
        StoreGuildWelcomeScreens.access$handleGuildWelcomeScreen(storeGuildWelcomeScreens$fetchIfNonexisting$1.this$0, storeGuildWelcomeScreens$fetchIfNonexisting$1.$guildId, this.$guildWelcomeScreen);
    }
}
