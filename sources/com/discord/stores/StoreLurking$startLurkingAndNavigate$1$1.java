package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingAndNavigate$1$1 extends o implements Function3<Guild, Long, Boolean, Unit> {
    public final /* synthetic */ StoreLurking$startLurkingAndNavigate$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking$startLurkingAndNavigate$1$1(StoreLurking$startLurkingAndNavigate$1 storeLurking$startLurkingAndNavigate$1) {
        super(3);
        this.this$0 = storeLurking$startLurkingAndNavigate$1;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
        invoke(guild, l, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Guild guild, Long l, boolean z2) {
        m.checkNotNullParameter(guild, "guild");
        StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1 storeLurking$startLurkingAndNavigate$1$1$jumpToDestination$1 = new StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1(this, l);
        if (z2) {
            storeLurking$startLurkingAndNavigate$1$1$jumpToDestination$1.invoke();
            return;
        }
        if (z2) {
            return;
        }
        storeLurking$startLurkingAndNavigate$1$1$jumpToDestination$1.invoke();
        StoreLurking.access$getStream$p(this.this$0.this$0).handleGuildJoined(this.this$0.$guildId, guild.getWelcomeScreen());
        StoreNavigation navigation = StoreStream.Companion.getNavigation();
        StringBuilder sbU = a.U("LURK:");
        sbU.append(this.this$0.$guildId);
        navigation.launchNotice(sbU.toString(), StoreLurking$startLurkingAndNavigate$1$1$1.INSTANCE);
    }
}
