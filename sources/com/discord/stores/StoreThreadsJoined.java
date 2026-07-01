package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadMember;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelPayload;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.search.network.state.SearchState;
import d0.t.h0;
import d0.t.r;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreThreadsJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsJoined extends StoreV2 {
    public static final int ALL_FLAGS = 15;
    public static final StoreThreadsJoined$Companion Companion = new StoreThreadsJoined$Companion(null);
    public static final int NOTIFICATION_FLAGS = 14;
    private final Map<Long, StoreThreadsJoined$JoinedThread> joinedThreads;
    private Map<Long, StoreThreadsJoined$JoinedThread> joinedThreadsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser storeUser;

    public /* synthetic */ StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getAllJoinedThreads(StoreThreadsJoined storeThreadsJoined) {
        return storeThreadsJoined.getAllJoinedThreads();
    }

    private final void deleteThreads(long guildId) {
        if (r.removeAll(this.joinedThreads.values(), new StoreThreadsJoined$deleteThreads$removed$1(guildId))) {
            markChanged();
        }
    }

    private final Map<Long, StoreThreadsJoined$JoinedThread> getAllJoinedThreads() {
        return this.joinedThreadsSnapshot;
    }

    private final void saveThreads(Guild guild) {
        ThreadMember member;
        List<Channel> listN = guild.N();
        if (listN != null) {
            for (Channel channel : listN) {
                if (ChannelUtils.H(channel) && (member = channel.getMember()) != null) {
                    this.joinedThreads.put(Long.valueOf(channel.getId()), new StoreThreadsJoined$JoinedThread(channel.getId(), guild.getId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
                    markChanged();
                }
            }
        }
    }

    @StoreThread
    public final Map<Long, StoreThreadsJoined$JoinedThread> getAllJoinedThreadsInternal$app_productionGoogleRelease() {
        return this.joinedThreads;
    }

    public final StoreThreadsJoined$JoinedThread getJoinedThread(long threadId) {
        return this.joinedThreadsSnapshot.get(Long.valueOf(threadId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.joinedThreads.clear();
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            m.checkNotNullExpressionValue(guild, "guild");
            saveThreads(guild);
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        deleteThreads(guild.getId());
        saveThreads(guild);
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        deleteThreads(guildId);
    }

    @StoreThread
    public final void handleSearchFinish(SearchState searchState) {
        Channel channel;
        m.checkNotNullParameter(searchState, "searchState");
        List<Channel> threads = searchState.getThreads();
        if (threads == null || (channel = threads.get(0)) == null) {
            return;
        }
        long guildId = channel.getGuildId();
        List<ThreadMember> threadMembers = searchState.getThreadMembers();
        if (threadMembers != null) {
            for (ThreadMember threadMember : threadMembers) {
                if (threadMember.getUserId() == this.storeUser.getMeSnapshot().getId()) {
                    this.joinedThreads.put(Long.valueOf(threadMember.getId()), new StoreThreadsJoined$JoinedThread(threadMember.getId(), guildId, threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                }
            }
        }
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        ThreadMember member = channel.getMember();
        if (member == null || member.getUserId() != this.storeUser.getMeSnapshot().getId()) {
            return;
        }
        this.joinedThreads.put(Long.valueOf(channel.getId()), new StoreThreadsJoined$JoinedThread(channel.getId(), channel.getGuildId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
        markChanged();
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (this.joinedThreads.containsKey(Long.valueOf(channel.getId()))) {
            this.joinedThreads.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        m.checkNotNullParameter(payload, "payload");
        List<ThreadMember> members = payload.getMembers();
        if (members != null) {
            for (ThreadMember threadMember : members) {
                this.joinedThreads.put(Long.valueOf(threadMember.getId()), new StoreThreadsJoined$JoinedThread(threadMember.getId(), payload.getGuildId(), threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleThreadMemberUpdate(ThreadMemberUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        if (payload.getUserId() == this.storeUser.getMeSnapshot().getId()) {
            this.joinedThreads.put(Long.valueOf(payload.getId()), new StoreThreadsJoined$JoinedThread(payload.getId(), payload.getGuildId(), payload.getFlags(), payload.getMuted(), new ModelMuteConfig(payload.getMuteConfig()), payload.getJoinTimestamp()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        List<Long> listD;
        m.checkNotNullParameter(payload, "payload");
        long id2 = this.storeUser.getMeSnapshot().getId();
        if (this.joinedThreads.containsKey(Long.valueOf(payload.getId())) && (listD = payload.d()) != null && listD.contains(Long.valueOf(id2))) {
            this.joinedThreads.remove(Long.valueOf(payload.getId()));
            markChanged();
        }
        List<AugmentedThreadMember> listA = payload.a();
        AugmentedThreadMember augmentedThreadMember = null;
        Object obj = null;
        if (listA != null) {
            for (Object obj2 : listA) {
                if (((AugmentedThreadMember) obj2).getUserId() == id2) {
                    obj = obj2;
                    break;
                }
            }
            augmentedThreadMember = (AugmentedThreadMember) obj;
        }
        if (augmentedThreadMember != null) {
            this.joinedThreads.put(Long.valueOf(payload.getId()), new StoreThreadsJoined$JoinedThread(payload.getId(), payload.getGuildId(), augmentedThreadMember.getFlags(), augmentedThreadMember.getMuted(), new ModelMuteConfig(augmentedThreadMember.getMuteConfig()), augmentedThreadMember.getJoinTimestamp()));
            markChanged();
        }
    }

    public final boolean hasJoined(long threadId) {
        return this.joinedThreadsSnapshot.containsKey(Long.valueOf(threadId));
    }

    @StoreThread
    public final boolean hasJoinedInternal(long threadId) {
        return this.joinedThreads.containsKey(Long.valueOf(threadId));
    }

    public final Observable<StoreThreadsJoined$JoinedThread> observeJoinedThread(long threadId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsJoined$observeJoinedThread$1(this, threadId), 14, null);
    }

    public final Observable<Map<Long, StoreThreadsJoined$JoinedThread>> observeJoinedThreads() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsJoined$observeJoinedThreads$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.joinedThreadsSnapshot = new HashMap(this.joinedThreads);
    }

    public StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.joinedThreads = new HashMap();
        this.joinedThreadsSnapshot = h0.emptyMap();
    }
}
