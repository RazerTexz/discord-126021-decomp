package com.discord.stores;

import android.content.Context;
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
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.user.UserRequestManager;
import com.discord.utilities.user.UserUtils;
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
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.functions.Action1;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$fetchUsers$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65491 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65491(List list) {
            super(0);
            this.$users = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser storeUser = StoreUser.this;
            storeUser.fetchMissing(this.$users, storeUser.getUsers().keySet());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeAllUsers$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65501 extends AbstractC12240o implements Function0<Map<Long, ? extends com.discord.models.user.User>> {
        public C65501() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends com.discord.models.user.User> invoke() {
            return StoreUser.this.getUsers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeMe$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65511 extends AbstractC12240o implements Function0<MeUser> {
        public C65511() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MeUser invoke() {
            return StoreUser.this.me;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeMeId$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65531 extends AbstractC12240o implements Function0<Long> {
        public C65531() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeUsernames$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65551 extends AbstractC12240o implements Function1<com.discord.models.user.User, String> {
        public static final C65551 INSTANCE = new C65551();

        public C65551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(com.discord.models.user.User user) {
            C12238m.checkNotNull(user);
            return user.getUsername();
        }
    }

    public /* synthetic */ StoreUser(Function1 function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? new Persister("STORE_USERS_ME_V13", EMPTY_ME_USER) : persister);
    }

    @StoreThread
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

    @StoreThread
    private final void updateUser(User user) {
        CoreUser coreUser = new CoreUser(user);
        if (!C12238m.areEqual(coreUser, this.users.get(Long.valueOf(user.getId())))) {
            this.users.put(Long.valueOf(user.getId()), coreUser);
            markChanged(UsersUpdate);
        }
    }

    public final void fetchUsers(List<Long> users) {
        C12238m.checkNotNullParameter(users, "users");
        this.dispatcher.schedule(new C65491(users));
    }

    /* JADX INFO: renamed from: getMe, reason: from getter */
    public final MeUser getMeSnapshot() {
        return this.meSnapshot;
    }

    @StoreThread
    /* JADX INFO: renamed from: getMeInternal$app_productionGoogleRelease, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final Map<Long, com.discord.models.user.User> getUsers() {
        return this.usersSnapshot;
    }

    @StoreThread
    public final Map<Long, com.discord.models.user.User> getUsersInternal$app_productionGoogleRelease() {
        return this.users;
    }

    @StoreThread
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            markChanged(MeUpdate);
            this.me = EMPTY_ME_USER;
        }
    }

    @StoreThread
    public final void handleChannelCreated(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        List<User> listM7659z = channel.m7659z();
        if (listM7659z != null) {
            Iterator<T> it = listM7659z.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.users.clear();
        User me2 = payload.getMe();
        C12238m.checkNotNullExpressionValue(me2, "payload.me");
        MeUser meUser = new MeUser(me2);
        this.me = meUser;
        this.users.put(Long.valueOf(meUser.getId()), meUser);
        for (Channel channel : payload.getPrivateChannels()) {
            C12238m.checkNotNullExpressionValue(channel, "channel");
            for (com.discord.models.user.User user : ChannelUtils.m7683g(channel)) {
                this.users.put(Long.valueOf(user.getId()), user);
            }
        }
        for (ModelUserRelationship modelUserRelationship : payload.getRelationships()) {
            C12238m.checkNotNullExpressionValue(modelUserRelationship, "relationship");
            if (modelUserRelationship.getUser() != null) {
                SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> copiablePartitionMap = this.users;
                Long lValueOf = Long.valueOf(modelUserRelationship.getUser().getId());
                User user2 = modelUserRelationship.getUser();
                C12238m.checkNotNullExpressionValue(user2, "relationship.user");
                copiablePartitionMap.put(lValueOf, new CoreUser(user2));
            }
        }
        Iterator<Guild> it = payload.getGuilds().iterator();
        while (it.hasNext()) {
            List<GuildMember> listM7875v = it.next().m7875v();
            if (listM7875v != null) {
                for (GuildMember guildMember : listM7875v) {
                    this.users.put(Long.valueOf(guildMember.getUser().getId()), new CoreUser(guildMember.getUser()));
                }
            }
        }
        StringBuilder sbM833U = C1643a.m833U("Discovered ");
        sbM833U.append(this.users.size());
        sbM833U.append(" initial users.");
        AppLog.m8358i(sbM833U.toString());
        AppLog.m8357g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(meUser));
        markChanged(MeUpdate, UsersUpdate);
    }

    @StoreThread
    public final void handleFriendSuggestionCreate(FriendSuggestion suggestion) {
        C12238m.checkNotNullParameter(suggestion, "suggestion");
        updateUser(suggestion.getSuggestedUser());
    }

    @StoreThread
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> loadedSuggestions) {
        C12238m.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
        Iterator<T> it = loadedSuggestions.iterator();
        while (it.hasNext()) {
            updateUser(((FriendSuggestion) it.next()).getSuggestedUser());
        }
    }

    @StoreThread
    public final void handleGuildAddOrSync(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        List<GuildMember> listM7875v = guild.m7875v();
        if (listM7875v != null) {
            Iterator<T> it = listM7875v.iterator();
            while (it.hasNext()) {
                updateUser(((GuildMember) it.next()).getUser());
            }
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(GuildMember member) {
        C12238m.checkNotNullParameter(member, "member");
        updateUser(member.getUser());
    }

    @StoreThread
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        C12238m.checkNotNullParameter(chunk, "chunk");
        Iterator<GuildMember> it = chunk.m7932b().iterator();
        while (it.hasNext()) {
            updateUser(it.next().getUser());
        }
    }

    @StoreThread
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers) {
        C12238m.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            User userM7969c = ((ApiGuildScheduledEventUser) it.next()).getUser();
            if (userM7969c != null) {
                updateUser(userM7969c);
            }
        }
    }

    @StoreThread
    public final void handleMessageCreateOrUpdate(Message message) {
        C12238m.checkNotNullParameter(message, "message");
        List<User> listM8047t = message.m8047t();
        if (listM8047t != null) {
            Iterator<T> it = listM8047t.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
        Long lM8039l = message.getFlags();
        if (((lM8039l != null ? lM8039l.longValue() : 0L) & 16) != 0) {
            int flags = this.me.getFlags() | 8192;
            MeUser meUser = this.me;
            this.me = meUser.copy((258047 & 1) != 0 ? meUser.getId() : 0L, (258047 & 2) != 0 ? meUser.getUsername() : null, (258047 & 4) != 0 ? meUser.getAvatar() : null, (258047 & 8) != 0 ? meUser.getBanner() : null, (258047 & 16) != 0 ? meUser.getIsBot() : false, (258047 & 32) != 0 ? meUser.getIsSystemUser() : false, (258047 & 64) != 0 ? meUser.getDiscriminator() : 0, (258047 & 128) != 0 ? meUser.getPremiumTier() : null, (258047 & 256) != 0 ? meUser.email : null, (258047 & 512) != 0 ? meUser.mfaEnabled : false, (258047 & 1024) != 0 ? meUser.isVerified : false, (258047 & 2048) != 0 ? meUser.token : null, (258047 & 4096) != 0 ? meUser.getFlags() : flags, (258047 & 8192) != 0 ? meUser.getPublicFlags() : 0, (258047 & 16384) != 0 ? meUser.phoneNumber : null, (258047 & 32768) != 0 ? meUser.nsfwAllowance : null, (258047 & 65536) != 0 ? meUser.getBio() : null, (258047 & 131072) != 0 ? meUser.getBannerColor() : null);
            markChanged(MeUpdate);
        }
    }

    @StoreThread
    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        C12238m.checkNotNullParameter(chunk, "chunk");
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

    @StoreThread
    public final void handlePresenceUpdate(Presence presence) {
        C12238m.checkNotNullParameter(presence, "presence");
        User user = presence.getUser();
        if ((user != null ? user.getDiscriminator() : null) != null) {
            updateUser(user);
        }
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        C12238m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listM8266b = threadMemberListUpdate.m8266b();
        if (listM8266b != null) {
            for (ThreadListMember threadListMember : listM8266b) {
                GuildMember guildMemberM8253a = threadListMember.getMember();
                if (guildMemberM8253a != null) {
                    updateUser(guildMemberM8253a.getUser());
                }
                Presence presenceM8254b = threadListMember.getPresence();
                User user = presenceM8254b != null ? presenceM8254b.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        C12238m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listM8275a = threadMembersUpdate.m8275a();
        if (listM8275a != null) {
            for (AugmentedThreadMember augmentedThreadMember : listM8275a) {
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

    @StoreThread
    public final void handleUserRelationshipAdd(ModelUserRelationship relationship) {
        C12238m.checkNotNullParameter(relationship, "relationship");
        User user = relationship.getUser();
        C12238m.checkNotNullExpressionValue(user, "relationship.user");
        updateUser(user);
    }

    @StoreThread
    public final void handleUserUpdated(User user) {
        C12238m.checkNotNullParameter(user, "user");
        updateUser(user);
        if (this.me.getId() == user.getId()) {
            this.me = MeUser.INSTANCE.merge(this.me, user);
            markChanged(MeUpdate);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        this.me = this.meCache.get();
        markChanged(MeUpdate);
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeAllUsers() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65501(), 14, null);
    }

    public final Observable<MeUser> observeMe() {
        return observeMe$default(this, false, 1, null);
    }

    public final Observable<MeUser> observeMe(final boolean emitEmpty) {
        Observable<MeUser> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new C65511(), 14, null).m11118y(new InterfaceC12589b<MeUser, Boolean>() { // from class: com.discord.stores.StoreUser.observeMe.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(MeUser meUser) {
                return Boolean.valueOf(meUser != StoreUser.EMPTY_ME_USER || emitEmpty);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Long> observeMeId() {
        Observable<Long> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new C65531(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<com.discord.models.user.User> observeUser(final long userId) {
        Observable<com.discord.models.user.User> observableM11112r = observeAllUsers().m11083G(new InterfaceC12589b<Map<Long, ? extends com.discord.models.user.User>, com.discord.models.user.User>() { // from class: com.discord.stores.StoreUser.observeUser.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final com.discord.models.user.User call(Map<Long, ? extends com.discord.models.user.User> map) {
                C12238m.checkNotNullParameter(map, "user");
                return map.get(Long.valueOf(userId));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeAllUsers()\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, String>> observeUsernames(Collection<Long> userIds) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        Observable observableM11108k = observeAllUsers().m11108k(C0879o.m176b(userIds, C65551.INSTANCE));
        C12238m.checkNotNullExpressionValue(observableM11108k, "observeAllUsers()\n      …er!!.username }\n        )");
        return observableM11108k;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        return observeUsers(userIds, false);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
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
        C12238m.checkNotNullParameter(userIds, "userIds");
        Map<Long, ? extends com.discord.models.user.User> map = this.usersSnapshot;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            com.discord.models.user.User user = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList.add(user);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((com.discord.models.user.User) obj).getId()), obj);
        }
        if (fetchUserIfMissing) {
            fetchMissing(userIds, linkedHashMap.keySet());
        }
        return linkedHashMap;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(final Collection<Long> userIds, final boolean fetchUserIfMissing) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, com.discord.models.user.User>> observableM11115u = observeAllUsers().m11108k(C0879o.m175a(userIds)).m11115u(new Action1<Map<Long, ? extends com.discord.models.user.User>>() { // from class: com.discord.stores.StoreUser.observeUsers.1
            @Override // p658rx.functions.Action1
            public final void call(Map<Long, ? extends com.discord.models.user.User> map) {
                if (fetchUserIfMissing) {
                    StoreUser.this.fetchMissing(userIds, map.keySet());
                }
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "observeAllUsers()\n      …ys)\n          }\n        }");
        return observableM11115u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUser(Function1<? super User, Unit> function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister<MeUser> persister) {
        C12238m.checkNotNullParameter(function1, "notifyUserUpdated");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(persister, "meCache");
        this.notifyUserUpdated = function1;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.meCache = persister;
        MeUser meUser = EMPTY_ME_USER;
        this.me = meUser;
        this.users = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.meSnapshot = meUser;
        this.usersSnapshot = C12136h0.emptyMap();
        this.userRequestManager = new UserRequestManager(new StoreUser$userRequestManager$1(this));
    }
}
