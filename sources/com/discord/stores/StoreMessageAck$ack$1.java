package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$ack$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ boolean $clearLock;
    public final /* synthetic */ boolean $isLockedAck;
    public final /* synthetic */ StoreMessageAck this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$ack$1(StoreMessageAck storeMessageAck, long j, boolean z2, boolean z3) {
        super(0);
        this.this$0 = storeMessageAck;
        this.$channelId = j;
        this.$isLockedAck = z2;
        this.$clearLock = z3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreMessageAck.access$getStream$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            if (channelFindChannelByIdInternal$app_productionGoogleRelease.getType() != 4) {
                StoreMessageAck.access$internalAck(this.this$0, channelFindChannelByIdInternal$app_productionGoogleRelease, this.$isLockedAck, this.$clearLock);
                return;
            }
            Iterator<T> it = StoreMessageAck.access$getStream$p(this.this$0).getChannels().findChannelsByCategoryInternal$app_productionGoogleRelease(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getId()).iterator();
            while (it.hasNext()) {
                StoreMessageAck.access$internalAck(this.this$0, (Channel) it.next(), this.$isLockedAck, this.$clearLock);
            }
        }
    }
}
