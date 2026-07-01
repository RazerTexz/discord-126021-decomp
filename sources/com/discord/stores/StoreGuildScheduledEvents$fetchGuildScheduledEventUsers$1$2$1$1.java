package com.discord.stores;

import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1$1 extends o implements Function1<ApiGuildScheduledEventUser, GuildScheduledEventUser> {
    public final /* synthetic */ StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1$1(StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1 storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1) {
        super(1);
        this.this$0 = storeGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildScheduledEventUser invoke(ApiGuildScheduledEventUser apiGuildScheduledEventUser) {
        return invoke2(apiGuildScheduledEventUser);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildScheduledEventUser invoke2(ApiGuildScheduledEventUser apiGuildScheduledEventUser) {
        m.checkNotNullParameter(apiGuildScheduledEventUser, "apiEventUser");
        return GuildScheduledEventUser.Companion.from(apiGuildScheduledEventUser, this.this$0.this$0.this$0.$guildId);
    }
}
