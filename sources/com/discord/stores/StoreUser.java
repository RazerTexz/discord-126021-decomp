package com.discord.stores;

import android.content.Context;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.message.Message;
import com.discord.api.premium.PremiumTier;
import com.discord.api.presence.Presence;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.user.UserRequestManager;
import com.discord.utilities.user.UserUtils;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser extends StoreV2 {
    private final Dispatcher dispatcher;
    private MeUser me;
    private final Persister<MeUser> meCache;
    private MeUser meSnapshot;
    private final Function1<User, Unit> notifyUserUpdated;
    private final ObservationDeck observationDeck;
    private final UserRequestManager userRequestManager;
    private final SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> users;
    private Map<Long, ? extends com.discord.models.user.User> usersSnapshot;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource MeUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreUser$Companion$MeUpdate$1
    };
    private static final ObservationDeck.UpdateSource UsersUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreUser$Companion$UsersUpdate$1
    };
    private static final MeUser EMPTY_ME_USER = new MeUser(0, "EMPTY_USERNAME", null, null, false, false, 0, PremiumTier.NONE, null, false, false, null, 0, 0, null, NsfwAllowance.UNKNOWN, null, null, 204800, null);

    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ObservationDeck.UpdateSource getMeUpdate() {
            return StoreUser.MeUpdate;
        }

        public final ObservationDeck.UpdateSource getUsersUpdate() {
            return StoreUser.UsersUpdate;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$fetchUsers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$users = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser storeUser = StoreUser.this;
            storeUser.fetchMissing(this.$users, storeUser.getUsers().keySet());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeAllUsers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends com.discord.models.user.User>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends com.discord.models.user.User> invoke() {
            return StoreUser.this.getUsers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeMe$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<MeUser> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MeUser invoke() {
            return StoreUser.this.me;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeMeId$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreUser.this.me.getId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeUsernames$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<com.discord.models.user.User, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(com.discord.models.user.User user) {
            Intrinsics3.checkNotNull(user);
            return user.getUsername();
        }
    }

    public /* synthetic */ StoreUser(Function1 function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? new Persister("STORE_USERS_ME_V13", EMPTY_ME_USER) : persister);
    }

    @Store3
    private final void fetchMissing(Collection<Long> totalUserIds, Set<Long> existingUserIds) {
        HashSet hashSet = new HashSet();
        Iterator<Long> it = totalUserIds.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!existingUserIds.contains(Long.valueOf(jLongValue))) {
                hashSet.add(Long.valueOf(jLongValue));
            }
        }
        this.userRequestManager.requestUsers(hashSet);
    }

    public static /* synthetic */ Observable observeMe$default(StoreUser storeUser, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return storeUser.observeMe(z2);
    }

    @Store3
    private final void updateUser(User user) {
        CoreUser coreUser = new CoreUser(user);
        if (!Intrinsics3.areEqual(coreUser, this.users.get(Long.valueOf(user.getId())))) {
            this.users.put(Long.valueOf(user.getId()), coreUser);
            markChanged(UsersUpdate);
        }
    }

    public final void fetchUsers(List<Long> users) {
        Intrinsics3.checkNotNullParameter(users, "users");
        this.dispatcher.schedule(new AnonymousClass1(users));
    }

    /* JADX INFO: renamed from: getMe, reason: from getter */
    public final MeUser getMeSnapshot() {
        return this.meSnapshot;
    }

    @Store3
    /* JADX INFO: renamed from: getMeInternal$app_productionGoogleRelease, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final Map<Long, com.discord.models.user.User> getUsers() {
        return this.usersSnapshot;
    }

    @Store3
    public final Map<Long, com.discord.models.user.User> getUsersInternal$app_productionGoogleRelease() {
        return this.users;
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            markChanged(MeUpdate);
            this.me = EMPTY_ME_USER;
        }
    }

    @Store3
    public final void handleChannelCreated(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        List<User> listZ = channel.z();
        if (listZ != null) {
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.users.clear();
        User me2 = payload.getMe();
        Intrinsics3.checkNotNullExpressionValue(me2, "payload.me");
        MeUser meUser = new MeUser(me2);
        this.me = meUser;
        this.users.put(Long.valueOf(meUser.getId()), meUser);
        for (Channel channel : payload.getPrivateChannels()) {
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            for (com.discord.models.user.User user : ChannelUtils.g(channel)) {
                this.users.put(Long.valueOf(user.getId()), user);
            }
        }
        for (ModelUserRelationship modelUserRelationship : payload.getRelationships()) {
            Intrinsics3.checkNotNullExpressionValue(modelUserRelationship, "relationship");
            if (modelUserRelationship.getUser() != null) {
                SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> copiablePartitionMap = this.users;
                Long lValueOf = Long.valueOf(modelUserRelationship.getUser().getId());
                User user2 = modelUserRelationship.getUser();
                Intrinsics3.checkNotNullExpressionValue(user2, "relationship.user");
                copiablePartitionMap.put(lValueOf, new CoreUser(user2));
            }
        }
        Iterator<Guild> it = payload.getGuilds().iterator();
        while (it.hasNext()) {
            List<GuildMember> listV = it.next().v();
            if (listV != null) {
                for (GuildMember guildMember : listV) {
                    this.users.put(Long.valueOf(guildMember.getUser().getId()), new CoreUser(guildMember.getUser()));
                }
            }
        }
        StringBuilder sbU = outline.U("Discovered ");
        sbU.append(this.users.size());
        sbU.append(" initial users.");
        AppLog.i(sbU.toString());
        AppLog.g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(meUser));
        markChanged(MeUpdate, UsersUpdate);
    }

    @Store3
    public final void handleFriendSuggestionCreate(FriendSuggestion suggestion) {
        Intrinsics3.checkNotNullParameter(suggestion, "suggestion");
        updateUser(suggestion.getSuggestedUser());
    }

    @Store3
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> loadedSuggestions) {
        Intrinsics3.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
        Iterator<T> it = loadedSuggestions.iterator();
        while (it.hasNext()) {
            updateUser(((FriendSuggestion) it.next()).getSuggestedUser());
        }
    }

    @Store3
    public final void handleGuildAddOrSync(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildMember> listV = guild.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            while (it.hasNext()) {
                updateUser(((GuildMember) it.next()).getUser());
            }
        }
    }

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        updateUser(member.getUser());
    }

    @Store3
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        Iterator<GuildMember> it = chunk.b().iterator();
        while (it.hasNext()) {
            updateUser(it.next().getUser());
        }
    }

    @Store3
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers) {
        Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            User userC = ((ApiGuildScheduledEventUser) it.next()).getUser();
            if (userC != null) {
                updateUser(userC);
            }
        }
    }

    @Store3
    public final void handleMessageCreateOrUpdate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        List<User> listT = message.t();
        if (listT != null) {
            Iterator<T> it = listT.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
        Long l = message.getFlags();
        if (((l != null ? l.longValue() : 0L) & 16) != 0) {
            int flags = this.me.getFlags() | 8192;
            MeUser meUser = this.me;
            this.me = meUser.copy((258047 & 1) != 0 ? meUser.getId() : 0L, (258047 & 2) != 0 ? meUser.getUsername() : null, (258047 & 4) != 0 ? meUser.getAvatar() : null, (258047 & 8) != 0 ? meUser.getBanner() : null, (258047 & 16) != 0 ? meUser.getIsBot() : false, (258047 & 32) != 0 ? meUser.getIsSystemUser() : false, (258047 & 64) != 0 ? meUser.getDiscriminator() : 0, (258047 & 128) != 0 ? meUser.getPremiumTier() : null, (258047 & 256) != 0 ? meUser.email : null, (258047 & 512) != 0 ? meUser.mfaEnabled : false, (258047 & 1024) != 0 ? meUser.isVerified : false, (258047 & 2048) != 0 ? meUser.token : null, (258047 & 4096) != 0 ? meUser.getFlags() : flags, (258047 & 8192) != 0 ? meUser.getPublicFlags() : 0, (258047 & 16384) != 0 ? meUser.phoneNumber : null, (258047 & 32768) != 0 ? meUser.nsfwAllowance : null, (258047 & 65536) != 0 ? meUser.getBio() : null, (258047 & 131072) != 0 ? meUser.getBannerColor() : null);
            markChanged(MeUpdate);
        }
    }

    @Store3
    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        for (com.discord.models.message.Message message : chunk.getMessages()) {
            User author = message.getAuthor();
            if (author != null) {
                updateUser(author);
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    updateUser((User) it.next());
                }
            }
        }
    }

    @Store3
    public final void handlePresenceUpdate(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        User user = presence.getUser();
        if ((user != null ? user.getDiscriminator() : null) != null) {
            updateUser(user);
        }
    }

    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            for (ThreadListMember threadListMember : listB) {
                GuildMember guildMemberA = threadListMember.getMember();
                if (guildMemberA != null) {
                    updateUser(guildMemberA.getUser());
                }
                Presence presenceB = threadListMember.getPresence();
                User user = presenceB != null ? presenceB.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            for (AugmentedThreadMember augmentedThreadMember : listA) {
                GuildMember member = augmentedThreadMember.getMember();
                if (member != null) {
                    updateUser(member.getUser());
                }
                Presence presence = augmentedThreadMember.getPresence();
                User user = presence != null ? presence.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @Store3
    public final void handleUserRelationshipAdd(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        User user = relationship.getUser();
        Intrinsics3.checkNotNullExpressionValue(user, "relationship.user");
        updateUser(user);
    }

    @Store3
    public final void handleUserUpdated(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        updateUser(user);
        if (this.me.getId() == user.getId()) {
            this.me = MeUser.INSTANCE.merge(this.me, user);
            markChanged(MeUpdate);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.me = this.meCache.get();
        markChanged(MeUpdate);
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeAllUsers() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<MeUser> observeMe() {
        return observeMe$default(this, false, 1, null);
    }

    public final Observable<MeUser> observeMe(final boolean emitEmpty) {
        Observable<MeUser> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new AnonymousClass1(), 14, null).y(new Func1<MeUser, Boolean>() { // from class: com.discord.stores.StoreUser.observeMe.2
            @Override // j0.k.Func1
            public final Boolean call(MeUser meUser) {
                return Boolean.valueOf(meUser != StoreUser.EMPTY_ME_USER || emitEmpty);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeMeId() {
        Observable<Long> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.user.User> observeUser(final long userId) {
        Observable<com.discord.models.user.User> observableR = observeAllUsers().G(new Func1<Map<Long, ? extends com.discord.models.user.User>, com.discord.models.user.User>() { // from class: com.discord.stores.StoreUser.observeUser.1
            @Override // j0.k.Func1
            public final com.discord.models.user.User call(Map<Long, ? extends com.discord.models.user.User> map) {
                Intrinsics3.checkNotNullParameter(map, "user");
                return map.get(Long.valueOf(userId));
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeAllUsers()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, String>> observeUsernames(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable observableK = observeAllUsers().k(o.b(userIds, AnonymousClass1.INSTANCE));
        Intrinsics3.checkNotNullExpressionValue(observableK, "observeAllUsers()\n      …er!!.username }\n        )");
        return observableK;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        return observeUsers(userIds, false);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        if (getUpdateSources().contains(UsersUpdate)) {
            this.usersSnapshot = this.users.fastCopy();
        }
        if (getUpdateSources().contains(MeUpdate)) {
            MeUser meUser = this.me;
            this.meSnapshot = meUser;
            Persister.set$default(this.meCache, meUser, false, 2, null);
        }
    }

    public final Map<Long, com.discord.models.user.User> getUsers(Collection<Long> userIds, boolean fetchUserIfMissing) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Map<Long, ? extends com.discord.models.user.User> map = this.usersSnapshot;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            com.discord.models.user.User user = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList.add(user);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((com.discord.models.user.User) obj).getId()), obj);
        }
        if (fetchUserIfMissing) {
            fetchMissing(userIds, linkedHashMap.keySet());
        }
        return linkedHashMap;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(final Collection<Long> userIds, final boolean fetchUserIfMissing) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, com.discord.models.user.User>> observableU = observeAllUsers().k(o.a(userIds)).u(new Action1<Map<Long, ? extends com.discord.models.user.User>>() { // from class: com.discord.stores.StoreUser.observeUsers.1
            @Override // rx.functions.Action1
            public final void call(Map<Long, ? extends com.discord.models.user.User> map) {
                if (fetchUserIfMissing) {
                    StoreUser.this.fetchMissing(userIds, map.keySet());
                }
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "observeAllUsers()\n      …ys)\n          }\n        }");
        return observableU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUser(Function1<? super User, Unit> function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister<MeUser> persister) {
        Intrinsics3.checkNotNullParameter(function1, "notifyUserUpdated");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(persister, "meCache");
        this.notifyUserUpdated = function1;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.meCache = persister;
        MeUser meUser = EMPTY_ME_USER;
        this.me = meUser;
        this.users = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.meSnapshot = meUser;
        this.usersSnapshot = Maps6.emptyMap();
        this.userRequestManager = new UserRequestManager(new StoreUser4(this));
    }
}
