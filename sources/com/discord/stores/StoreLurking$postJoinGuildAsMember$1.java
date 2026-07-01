package com.discord.stores;

import com.discord.api.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$postJoinGuildAsMember$1 extends o implements Function1<Guild, Unit> {
    public static final StoreLurking$postJoinGuildAsMember$1 INSTANCE = new StoreLurking$postJoinGuildAsMember$1();

    public StoreLurking$postJoinGuildAsMember$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
    }
}
