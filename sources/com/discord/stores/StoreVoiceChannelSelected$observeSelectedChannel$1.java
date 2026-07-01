package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceChannelSelected$observeSelectedChannel$1 extends o implements Function0<Channel> {
    public final /* synthetic */ StoreVoiceChannelSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVoiceChannelSelected$observeSelectedChannel$1(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        super(0);
        this.this$0 = storeVoiceChannelSelected;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Channel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Channel invoke() {
        return StoreVoiceChannelSelected.access$getStream$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreVoiceChannelSelected.access$getSelectedVoiceChannelId$p(this.this$0));
    }
}
