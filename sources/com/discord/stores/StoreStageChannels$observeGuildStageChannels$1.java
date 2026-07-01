package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.user.User;
import com.discord.widgets.stage.model.StageChannel;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels$observeGuildStageChannels$1 extends o implements Function0<Map<Long, ? extends StageChannel>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreStageChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannels$observeGuildStageChannels$1(StoreStageChannels storeStageChannels, long j) {
        super(0);
        this.this$0 = storeStageChannels;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StageChannel> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StageChannel> invoke2() {
        StoreStageChannels storeStageChannels = this.this$0;
        long j = this.$guildId;
        Map<Long, Channel> channelsForGuild = StoreStageChannels.access$getChannelsStore$p(storeStageChannels).getChannelsForGuild(this.$guildId);
        long id2 = StoreStageChannels.access$getUserStore$p(this.this$0).getMeSnapshot().getId();
        Map<Long, User> users = StoreStageChannels.access$getUserStore$p(this.this$0).getUsers();
        Map<Long, VoiceState> mapEmptyMap = StoreStageChannels.access$getVoiceStatesStore$p(this.this$0).get().get(Long.valueOf(this.$guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        return storeStageChannels.getStageChannelsInGuild(j, channelsForGuild, id2, users, mapEmptyMap);
    }
}
