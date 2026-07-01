package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurking$3 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $navigateToGuild;
    public final /* synthetic */ Function0 $onErrorLurking;
    public final /* synthetic */ Function3 $onGuildLurked;
    public final /* synthetic */ StoreLurking this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking$startLurking$3(StoreLurking storeLurking, long j, Long l, boolean z2, Function3 function3, Function0 function0) {
        super(0);
        this.this$0 = storeLurking;
        this.$guildId = j;
        this.$channelId = l;
        this.$navigateToGuild = z2;
        this.$onGuildLurked = function3;
        this.$onErrorLurking = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreLurking.startLurkingInternal$default(this.this$0, this.$guildId, this.$channelId, this.$navigateToGuild, this.$onGuildLurked, this.$onErrorLurking, null, 32, null);
    }
}
