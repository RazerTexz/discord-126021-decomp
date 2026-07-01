package com.discord.stores;

import com.discord.api.guild.Guild;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingInternal$4$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Guild $it;
    public final /* synthetic */ StoreLurking$startLurkingInternal$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking$startLurkingInternal$4$1(StoreLurking$startLurkingInternal$4 storeLurking$startLurkingInternal$4, Guild guild) {
        super(0);
        this.this$0 = storeLurking$startLurkingInternal$4;
        this.$it = guild;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (!this.this$0.this$0.isLurking$app_productionGoogleRelease(this.$it)) {
            StoreLurking.access$getLurkedGuilds$p(this.this$0.this$0).remove(Long.valueOf(this.this$0.$guildId));
            StoreLurking.access$getLurkedGuildsSubject$p(this.this$0.this$0).onNext(StoreLurking.access$getLurkedGuilds$p(this.this$0.this$0));
        }
        this.this$0.$onGuildLurked.invoke(new com.discord.models.guild.Guild(this.$it), this.this$0.$channelId, Boolean.FALSE);
    }
}
