package com.discord.stores;

import com.discord.api.guild.welcome.GuildWelcomeScreen;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens$fetchIfNonexisting$1$1 extends o implements Function1<GuildWelcomeScreen, Unit> {
    public final /* synthetic */ StoreGuildWelcomeScreens$fetchIfNonexisting$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildWelcomeScreens$fetchIfNonexisting$1$1(StoreGuildWelcomeScreens$fetchIfNonexisting$1 storeGuildWelcomeScreens$fetchIfNonexisting$1) {
        super(1);
        this.this$0 = storeGuildWelcomeScreens$fetchIfNonexisting$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildWelcomeScreen guildWelcomeScreen) {
        invoke2(guildWelcomeScreen);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildWelcomeScreen guildWelcomeScreen) {
        m.checkNotNullParameter(guildWelcomeScreen, "guildWelcomeScreen");
        StoreGuildWelcomeScreens.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1(this, guildWelcomeScreen));
    }
}
