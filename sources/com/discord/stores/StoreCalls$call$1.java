package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreCalls this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCalls$call$1(StoreCalls storeCalls, long j) {
        super(1);
        this.this$0 = storeCalls;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        StoreCalls.access$getStream$p(this.this$0).getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
        if (z2) {
            StoreCalls.ring$default(this.this$0, this.$channelId, null, 2, null);
        }
    }
}
