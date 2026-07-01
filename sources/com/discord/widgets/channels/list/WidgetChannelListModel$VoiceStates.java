package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import d0.t.q;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$VoiceStates {
    public static final WidgetChannelListModel$VoiceStates INSTANCE = new WidgetChannelListModel$VoiceStates();

    private WidgetChannelListModel$VoiceStates() {
    }

    public static final /* synthetic */ Map access$createVoiceStates(WidgetChannelListModel$VoiceStates widgetChannelListModel$VoiceStates, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Comparator comparator) {
        return widgetChannelListModel$VoiceStates.createVoiceStates(map, map2, map3, map4, map5, map6, comparator);
    }

    private final Map<Long, List<ChannelListItemVoiceUser>> createVoiceStates(Map<Long, VoiceState> voiceStates, Map<Long, ? extends User> users, Map<Long, GuildMember> computed, Map<Long, Channel> channels, Map<Long, ? extends ModelApplicationStream> guildStreams, Map<Long, Long> guildPermissions, Comparator<ChannelListItemVoiceUser> voiceUserComparator) {
        Long channelId;
        Channel channel;
        HashMap map = new HashMap();
        for (VoiceState voiceState : voiceStates.values()) {
            long userId = voiceState.getUserId();
            User user = users.get(Long.valueOf(userId));
            if (user != null && (channelId = voiceState.getChannelId()) != null) {
                long jLongValue = channelId.longValue();
                boolean zCan = PermissionUtils.can(Permission.CONNECT, guildPermissions.get(Long.valueOf(jLongValue)));
                Long lValueOf = Long.valueOf(jLongValue);
                Object arrayList = map.get(lValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(lValueOf, arrayList);
                }
                List list = (List) arrayList;
                GuildMember guildMember = computed.get(Long.valueOf(userId));
                if (guildMember != null && (channel = channels.get(Long.valueOf(jLongValue))) != null) {
                    list.add(new ChannelListItemVoiceUser(channel, voiceState, user, guildMember, guildStreams.containsKey(Long.valueOf(userId)), zCan));
                }
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            q.sortWith((List) ((Map$Entry) it.next()).getValue(), voiceUserComparator);
        }
        return map;
    }

    private final Comparator<ChannelListItemVoiceUser> createVoiceUserComparator() {
        return WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable get$default(WidgetChannelListModel$VoiceStates widgetChannelListModel$VoiceStates, long j, Comparator comparator, int i, Object obj) {
        if ((i & 2) != 0) {
            comparator = widgetChannelListModel$VoiceStates.createVoiceUserComparator();
        }
        return widgetChannelListModel$VoiceStates.get(j, comparator);
    }

    public final Observable<Map<Long, List<ChannelListItemVoiceUser>>> get(long guildId, Comparator<ChannelListItemVoiceUser> voiceUserComparator) {
        m.checkNotNullParameter(voiceUserComparator, "voiceUserComparator");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableF = Observable.f(storeStream$Companion.getApplicationStreaming().observeStreamsForGuild(guildId), ObservableExtensionsKt.leadingEdgeThrottle(storeStream$Companion.getVoiceStates().observe(guildId), 200L, TimeUnit.MILLISECONDS), storeStream$Companion.getUsers().observeAllUsers(), storeStream$Companion.getGuilds().observeComputed(guildId), StoreChannels.observeChannelsForGuild$default(storeStream$Companion.getChannels(), guildId, null, 2, null), storeStream$Companion.getPermissions().observeChannelPermissionsForGuild(guildId), new WidgetChannelListModel$VoiceStates$get$1(voiceUserComparator));
        m.checkNotNullExpressionValue(observableF, "Observable\n          .co…            )\n          }");
        Observable<Map<Long, List<ChannelListItemVoiceUser>>> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }
}
