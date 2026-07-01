package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import d0.z.d.m;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$VoiceStates$get$1<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends ModelApplicationStream>, Map<Long, ? extends VoiceState>, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends List<? extends ChannelListItemVoiceUser>>> {
    public final /* synthetic */ Comparator $voiceUserComparator;

    public WidgetChannelListModel$VoiceStates$get$1(Comparator comparator) {
        this.$voiceUserComparator = comparator;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends ChannelListItemVoiceUser>> call(Map<Long, ? extends ModelApplicationStream> map, Map<Long, ? extends VoiceState> map2, Map<Long, ? extends User> map3, Map<Long, ? extends GuildMember> map4, Map<Long, ? extends Channel> map5, Map<Long, ? extends Long> map6) {
        return call2(map, (Map<Long, VoiceState>) map2, map3, (Map<Long, GuildMember>) map4, (Map<Long, Channel>) map5, (Map<Long, Long>) map6);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, List<ChannelListItemVoiceUser>> call2(Map<Long, ? extends ModelApplicationStream> map, Map<Long, VoiceState> map2, Map<Long, ? extends User> map3, Map<Long, GuildMember> map4, Map<Long, Channel> map5, Map<Long, Long> map6) {
        WidgetChannelListModel$VoiceStates widgetChannelListModel$VoiceStates = WidgetChannelListModel$VoiceStates.INSTANCE;
        m.checkNotNullExpressionValue(map2, "voiceStates");
        m.checkNotNullExpressionValue(map3, "users");
        m.checkNotNullExpressionValue(map4, "guildMembers");
        m.checkNotNullExpressionValue(map5, "guildChannels");
        m.checkNotNullExpressionValue(map, "guildStreams");
        m.checkNotNullExpressionValue(map6, "guildPermissions");
        return WidgetChannelListModel$VoiceStates.access$createVoiceStates(widgetChannelListModel$VoiceStates, map2, map3, map4, map5, map, map6, this.$voiceUserComparator);
    }
}
