package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadMember;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelPayload;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.search.network.state.SearchState;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreThreadsJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsJoined extends StoreV2 {
    public static final int ALL_FLAGS = 15;
    public static final int NOTIFICATION_FLAGS = 14;
    private final Map<Long, JoinedThread> joinedThreads;
    private Map<Long, JoinedThread> joinedThreadsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser storeUser;

    /* JADX INFO: compiled from: StoreThreadsJoined.kt */
    public static final /* data */ class JoinedThread {
        private final int flags;
        private final long guildId;
        private final UtcDateTime joinTimestamp;
        private final ModelMuteConfig muteConfig;
        private final boolean muted;
        private final long threadId;

        public JoinedThread(long j, long j2, int i, boolean z2, ModelMuteConfig modelMuteConfig, UtcDateTime utcDateTime) {
            Intrinsics3.checkNotNullParameter(modelMuteConfig, "muteConfig");
            Intrinsics3.checkNotNullParameter(utcDateTime, "joinTimestamp");
            this.threadId = j;
            this.guildId = j2;
            this.flags = i;
            this.muted = z2;
            this.muteConfig = modelMuteConfig;
            this.joinTimestamp = utcDateTime;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getThreadId() {
            return this.threadId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFlags() {
            return this.flags;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getMuted() {
            return this.muted;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final JoinedThread copy(long threadId, long guildId, int flags, boolean muted, ModelMuteConfig muteConfig, UtcDateTime joinTimestamp) {
            Intrinsics3.checkNotNullParameter(muteConfig, "muteConfig");
            Intrinsics3.checkNotNullParameter(joinTimestamp, "joinTimestamp");
            return new JoinedThread(threadId, guildId, flags, muted, muteConfig, joinTimestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JoinedThread)) {
                return false;
            }
            JoinedThread joinedThread = (JoinedThread) other;
            return this.threadId == joinedThread.threadId && this.guildId == joinedThread.guildId && this.flags == joinedThread.flags && this.muted == joinedThread.muted && Intrinsics3.areEqual(this.muteConfig, joinedThread.muteConfig) && Intrinsics3.areEqual(this.joinTimestamp, joinedThread.joinTimestamp);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public final long getThreadId() {
            return this.threadId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        public int hashCode() {
            int iA = (((b.a(this.guildId) + (b.a(this.threadId) * 31)) * 31) + this.flags) * 31;
            boolean z2 = this.muted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iA + r0) * 31;
            ModelMuteConfig modelMuteConfig = this.muteConfig;
            int iHashCode = (i + (modelMuteConfig != null ? modelMuteConfig.hashCode() : 0)) * 31;
            UtcDateTime utcDateTime = this.joinTimestamp;
            return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("JoinedThread(threadId=");
            sbU.append(this.threadId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", flags=");
            sbU.append(this.flags);
            sbU.append(", muted=");
            sbU.append(this.muted);
            sbU.append(", muteConfig=");
            sbU.append(this.muteConfig);
            sbU.append(", joinTimestamp=");
            sbU.append(this.joinTimestamp);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsJoined$observeJoinedThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsJoined.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<JoinedThread> {
        public final /* synthetic */ long $threadId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$threadId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final JoinedThread invoke() {
            return StoreThreadsJoined.this.getJoinedThread(this.$threadId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsJoined$observeJoinedThreads$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsJoined.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends JoinedThread>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends JoinedThread> invoke() {
            return StoreThreadsJoined.this.getAllJoinedThreads();
        }
    }

    public /* synthetic */ StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final void deleteThreads(long guildId) {
        if (MutableCollections.removeAll(this.joinedThreads.values(), new StoreThreadsJoined2(guildId))) {
            markChanged();
        }
    }

    private final Map<Long, JoinedThread> getAllJoinedThreads() {
        return this.joinedThreadsSnapshot;
    }

    private final void saveThreads(Guild guild) {
        ThreadMember member;
        List<Channel> listN = guild.N();
        if (listN != null) {
            for (Channel channel : listN) {
                if (ChannelUtils.H(channel) && (member = channel.getMember()) != null) {
                    this.joinedThreads.put(Long.valueOf(channel.getId()), new JoinedThread(channel.getId(), guild.getId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final Map<Long, JoinedThread> getAllJoinedThreadsInternal$app_productionGoogleRelease() {
        return this.joinedThreads;
    }

    public final JoinedThread getJoinedThread(long threadId) {
        return this.joinedThreadsSnapshot.get(Long.valueOf(threadId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.joinedThreads.clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            saveThreads(guild);
        }
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        deleteThreads(guild.getId());
        saveThreads(guild);
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        deleteThreads(guildId);
    }

    @Store3
    public final void handleSearchFinish(SearchState searchState) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(searchState, "searchState");
        List<Channel> threads = searchState.getThreads();
        if (threads == null || (channel = threads.get(0)) == null) {
            return;
        }
        long guildId = channel.getGuildId();
        List<ThreadMember> threadMembers = searchState.getThreadMembers();
        if (threadMembers != null) {
            for (ThreadMember threadMember : threadMembers) {
                if (threadMember.getUserId() == this.storeUser.getMeSnapshot().getId()) {
                    this.joinedThreads.put(Long.valueOf(threadMember.getId()), new JoinedThread(threadMember.getId(), guildId, threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                }
            }
        }
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        ThreadMember member = channel.getMember();
        if (member == null || member.getUserId() != this.storeUser.getMeSnapshot().getId()) {
            return;
        }
        this.joinedThreads.put(Long.valueOf(channel.getId()), new JoinedThread(channel.getId(), channel.getGuildId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
        markChanged();
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.joinedThreads.containsKey(Long.valueOf(channel.getId()))) {
            this.joinedThreads.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<ThreadMember> members = payload.getMembers();
        if (members != null) {
            for (ThreadMember threadMember : members) {
                this.joinedThreads.put(Long.valueOf(threadMember.getId()), new JoinedThread(threadMember.getId(), payload.getGuildId(), threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                markChanged();
            }
        }
    }

    @Store3
    public final void handleThreadMemberUpdate(ThreadMemberUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        if (payload.getUserId() == this.storeUser.getMeSnapshot().getId()) {
            this.joinedThreads.put(Long.valueOf(payload.getId()), new JoinedThread(payload.getId(), payload.getGuildId(), payload.getFlags(), payload.getMuted(), new ModelMuteConfig(payload.getMuteConfig()), payload.getJoinTimestamp()));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        List<Long> listD;
        Intrinsics3.checkNotNullParameter(payload, "payload");
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
            this.joinedThreads.put(Long.valueOf(payload.getId()), new JoinedThread(payload.getId(), payload.getGuildId(), augmentedThreadMember.getFlags(), augmentedThreadMember.getMuted(), new ModelMuteConfig(augmentedThreadMember.getMuteConfig()), augmentedThreadMember.getJoinTimestamp()));
            markChanged();
        }
    }

    public final boolean hasJoined(long threadId) {
        return this.joinedThreadsSnapshot.containsKey(Long.valueOf(threadId));
    }

    @Store3
    public final boolean hasJoinedInternal(long threadId) {
        return this.joinedThreads.containsKey(Long.valueOf(threadId));
    }

    public final Observable<JoinedThread> observeJoinedThread(long threadId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(threadId), 14, null);
    }

    public final Observable<Map<Long, JoinedThread>> observeJoinedThreads() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.joinedThreadsSnapshot = new HashMap(this.joinedThreads);
    }

    public StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.joinedThreads = new HashMap();
        this.joinedThreadsSnapshot = Maps6.emptyMap();
    }
}
