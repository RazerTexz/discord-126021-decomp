package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels$observeMyRoles$1 extends o implements Function0<StageRoles> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreStageChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannels$observeMyRoles$1(StoreStageChannels storeStageChannels, long j) {
        super(0);
        this.this$0 = storeStageChannels;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StageRoles invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StageRoles invoke() {
        Channel channel = StoreStageChannels.access$getChannelsStore$p(this.this$0).getChannel(this.$channelId);
        if (channel != null) {
            return this.this$0.m15getMyRolesvisDeB4(channel.getId());
        }
        return null;
    }
}
