package com.discord.widgets.chat.list.adapter;

import com.discord.api.guildmember.GuildMember;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRequestedStageChannels;
import com.discord.stores.StoreRequestedStageChannels$StageInstanceState;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.widgets.chat.list.entries.StageInviteEntry;
import com.discord.widgets.stage.StageCardSpeaker;
import com.discord.widgets.stage.StageRoles;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStageInvite$Model$Companion {
    private WidgetChatListAdapterItemStageInvite$Model$Companion() {
    }

    public static final /* synthetic */ List access$speakersFromLocalStore(WidgetChatListAdapterItemStageInvite$Model$Companion widgetChatListAdapterItemStageInvite$Model$Companion, StoreGuilds storeGuilds, StoreUser storeUser, StoreStageChannels storeStageChannels, long j, long j2) {
        return widgetChatListAdapterItemStageInvite$Model$Companion.speakersFromLocalStore(storeGuilds, storeUser, storeStageChannels, j, j2);
    }

    public static final /* synthetic */ List access$speakersFromRequest(WidgetChatListAdapterItemStageInvite$Model$Companion widgetChatListAdapterItemStageInvite$Model$Companion, StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState) {
        return widgetChatListAdapterItemStageInvite$Model$Companion.speakersFromRequest(storeRequestedStageChannels$StageInstanceState);
    }

    public static /* synthetic */ Observable observe$default(WidgetChatListAdapterItemStageInvite$Model$Companion widgetChatListAdapterItemStageInvite$Model$Companion, StageInviteEntry stageInviteEntry, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreAccessibility storeAccessibility, StoreStageInstances storeStageInstances, StoreRequestedStageChannels storeRequestedStageChannels, StoreStageChannels storeStageChannels, ObservationDeck observationDeck, int i, Object obj) {
        return widgetChatListAdapterItemStageInvite$Model$Companion.observe(stageInviteEntry, (i & 2) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.Companion.getAccessibility() : storeAccessibility, (i & 32) != 0 ? StoreStream.Companion.getStageInstances() : storeStageInstances, (i & 64) != 0 ? StoreStream.Companion.getRequestedStageChannels() : storeRequestedStageChannels, (i & 128) != 0 ? StoreStream.Companion.getStageChannels() : storeStageChannels, (i & 256) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final List<StageCardSpeaker> speakersFromLocalStore(StoreGuilds guildStore, StoreUser userStore, StoreStageChannels stageChannelStore, long channelId, long guildId) {
        User user;
        Map<Long, StageRoles> channelRoles = stageChannelStore.getChannelRoles(channelId);
        if (channelRoles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map$Entry<Long, StageRoles> map$Entry : channelRoles.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            StageCardSpeaker stageCardSpeaker = (!StageRoles.m33isSpeakerimpl(map$Entry.getValue().m35unboximpl()) || (user = userStore.getUsers().get(Long.valueOf(jLongValue))) == null) ? null : WidgetChatListAdapterItemStageInvite$Model.Companion.toStageCardSpeaker(user, guildStore.getMember(guildId, jLongValue));
            if (stageCardSpeaker != null) {
                arrayList.add(stageCardSpeaker);
            }
        }
        return arrayList;
    }

    private final List<StageCardSpeaker> speakersFromRequest(StoreRequestedStageChannels$StageInstanceState stageInstanceState) {
        RecommendedStageInstance stageInstance;
        if (stageInstanceState == null || (stageInstance = stageInstanceState.getStageInstance()) == null) {
            return null;
        }
        List<GuildMember> listC = stageInstance.c();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listC, 10));
        for (GuildMember guildMember : listC) {
            arrayList.add(new StageCardSpeaker(new CoreUser(guildMember.getUser()), GuildMember$Companion.from$default(com.discord.models.member.GuildMember.Companion, guildMember, guildMember.getGuildId(), null, StoreStream.Companion.getGuilds(), 4, null)));
        }
        return arrayList;
    }

    private final StageCardSpeaker toStageCardSpeaker(User user, com.discord.models.member.GuildMember guildMember) {
        return new StageCardSpeaker(user, guildMember);
    }

    public final Observable<WidgetChatListAdapterItemStageInvite$Model> observe(StageInviteEntry item, StoreUser userStore, StoreChannels channelStore, StoreGuilds guildStore, StoreAccessibility accessibilityStore, StoreStageInstances stageInstanceStore, StoreRequestedStageChannels requestedInstanceStore, StoreStageChannels stageChannelStore, ObservationDeck observationDeck) {
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(userStore, "userStore");
        m.checkNotNullParameter(channelStore, "channelStore");
        m.checkNotNullParameter(guildStore, "guildStore");
        m.checkNotNullParameter(accessibilityStore, "accessibilityStore");
        m.checkNotNullParameter(stageInstanceStore, "stageInstanceStore");
        m.checkNotNullParameter(requestedInstanceStore, "requestedInstanceStore");
        m.checkNotNullParameter(stageChannelStore, "stageChannelStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{userStore, channelStore, guildStore, accessibilityStore, stageInstanceStore, requestedInstanceStore, stageChannelStore}, false, null, null, new WidgetChatListAdapterItemStageInvite$Model$Companion$observe$1(userStore, item, channelStore, accessibilityStore, stageInstanceStore, requestedInstanceStore, stageChannelStore, guildStore), 14, null);
    }

    public /* synthetic */ WidgetChatListAdapterItemStageInvite$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
