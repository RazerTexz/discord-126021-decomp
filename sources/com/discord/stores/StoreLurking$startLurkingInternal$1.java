package com.discord.stores;

import com.discord.models.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingInternal$1 extends o implements Function3<Guild, Long, Boolean, Unit> {
    public static final StoreLurking$startLurkingInternal$1 INSTANCE = new StoreLurking$startLurkingInternal$1();

    public StoreLurking$startLurkingInternal$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
        invoke(guild, l, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Guild guild, Long l, boolean z2) {
        m.checkNotNullParameter(guild, "<anonymous parameter 0>");
    }
}
