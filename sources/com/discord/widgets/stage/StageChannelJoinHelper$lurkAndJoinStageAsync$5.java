package com.discord.widgets.stage;

import com.discord.stores.StoreLurking;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$lurkAndJoinStageAsync$5 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreLurking $lurkingStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$lurkAndJoinStageAsync$5(StoreLurking storeLurking, long j) {
        super(0);
        this.$lurkingStore = storeLurking;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$lurkingStore.removeOldLurkingGuilds(this.$guildId);
    }
}
