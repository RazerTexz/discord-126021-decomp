package com.discord.widgets.stage.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import rx.functions.Func7;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel$Companion$observeStageCallModel$1$1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Guild, Map<Long, ? extends Integer>, StageInstance, Boolean, StageCallModel> {
    public final /* synthetic */ Channel $channel;

    public StageCallModel$Companion$observeStageCallModel$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ StageCallModel call(Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends GuildRole> map3, Guild guild, Map<Long, ? extends Integer> map4, StageInstance stageInstance, Boolean bool) {
        return call2((Map<Long, StoreVoiceParticipants$VoiceUser>) map, (Map<Long, GuildMember>) map2, (Map<Long, GuildRole>) map3, guild, (Map<Long, Integer>) map4, stageInstance, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StageCallModel call2(Map<Long, StoreVoiceParticipants$VoiceUser> map, Map<Long, GuildMember> map2, Map<Long, GuildRole> map3, Guild guild, Map<Long, Integer> map4, StageInstance stageInstance, Boolean bool) {
        StageCallModel$Companion stageCallModel$Companion = StageCallModel.Companion;
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(map2, "guildMembers");
        m.checkNotNullExpressionValue(map3, "guildRoles");
        m.checkNotNullExpressionValue(map, "participants");
        Set<Long> setKeySet = map4.keySet();
        m.checkNotNullExpressionValue(bool, "isLurking");
        return StageCallModel$Companion.create$default(stageCallModel$Companion, channel, map2, map3, guild, map, setKeySet, stageInstance, bool.booleanValue(), null, 256, null);
    }
}
