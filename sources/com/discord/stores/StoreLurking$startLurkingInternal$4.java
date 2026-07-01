package com.discord.stores;

import com.discord.api.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingInternal$4 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Function3 $onGuildLurked;
    public final /* synthetic */ StoreLurking this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking$startLurkingInternal$4(StoreLurking storeLurking, long j, Function3 function3, Long l) {
        super(1);
        this.this$0 = storeLurking;
        this.$guildId = j;
        this.$onGuildLurked = function3;
        this.$channelId = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
        StoreLurking.access$getDispatcher$p(this.this$0).schedule(new StoreLurking$startLurkingInternal$4$1(this, guild));
    }
}
