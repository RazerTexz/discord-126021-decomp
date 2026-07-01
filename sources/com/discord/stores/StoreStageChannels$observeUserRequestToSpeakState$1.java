package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels$observeUserRequestToSpeakState$1 extends o implements Function0<StageRequestToSpeakState> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreStageChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannels$observeUserRequestToSpeakState$1(StoreStageChannels storeStageChannels, long j, long j2) {
        super(0);
        this.this$0 = storeStageChannels;
        this.$channelId = j;
        this.$userId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StageRequestToSpeakState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StageRequestToSpeakState invoke() {
        StageRequestToSpeakState requestToSpeakState;
        Channel channel = StoreStageChannels.access$getChannelsStore$p(this.this$0).getChannel(this.$channelId);
        if (channel == null) {
            return StageRequestToSpeakState.NONE;
        }
        StageChannelRoleContext stageChannelRoleContextRoleContext$default = StoreStageChannels.roleContext$default(this.this$0, channel, null, null, null, 14, null);
        return (stageChannelRoleContextRoleContext$default == null || (requestToSpeakState = stageChannelRoleContextRoleContext$default.getRequestToSpeakState(this.$userId)) == null) ? StageRequestToSpeakState.NONE : requestToSpeakState;
    }
}
