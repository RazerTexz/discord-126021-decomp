package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActive;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;
import p658rx.functions.Func4;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostReadStateManager {
    public static final ForumPostReadStateManager INSTANCE = new ForumPostReadStateManager();
    private static final BehaviorSubject<StoreMessageAck.Ack> forumChannelAckBeforeChannelSelect;
    private static Subscription forumChannelAckSubscription;
    private static Map<Long, StoreMessageAck.Ack> internalMessageAcks;
    private static final Set<Long> internalThreadSyncedGuilds;
    private static long lastSelectedChannelId;
    private static long lastSyncedGuildId;

    /* JADX INFO: compiled from: ForumPostReadStateManager.kt */
    public static final /* data */ class ManagerInitializeState {
        private final Map<Long, StoreMessageAck.Ack> messageAcks;
        private final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel;
        private final Set<Long> threadSyncedGuilds;

        public ManagerInitializeState(Map<Long, StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> set) {
            C12238m.checkNotNullParameter(map, "messageAcks");
            C12238m.checkNotNullParameter(resolvedSelectedChannel, "resolvedSelectedChannel");
            C12238m.checkNotNullParameter(set, "threadSyncedGuilds");
            this.messageAcks = map;
            this.resolvedSelectedChannel = resolvedSelectedChannel;
            this.threadSyncedGuilds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ManagerInitializeState copy$default(ManagerInitializeState managerInitializeState, Map map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                map = managerInitializeState.messageAcks;
            }
            if ((i & 2) != 0) {
                resolvedSelectedChannel = managerInitializeState.resolvedSelectedChannel;
            }
            if ((i & 4) != 0) {
                set = managerInitializeState.threadSyncedGuilds;
            }
            return managerInitializeState.copy(map, resolvedSelectedChannel, set);
        }

        public final Map<Long, StoreMessageAck.Ack> component1() {
            return this.messageAcks;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreChannelsSelected.ResolvedSelectedChannel getResolvedSelectedChannel() {
            return this.resolvedSelectedChannel;
        }

        public final Set<Long> component3() {
            return this.threadSyncedGuilds;
        }

        public final ManagerInitializeState copy(Map<Long, StoreMessageAck.Ack> messageAcks, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> threadSyncedGuilds) {
            C12238m.checkNotNullParameter(messageAcks, "messageAcks");
            C12238m.checkNotNullParameter(resolvedSelectedChannel, "resolvedSelectedChannel");
            C12238m.checkNotNullParameter(threadSyncedGuilds, "threadSyncedGuilds");
            return new ManagerInitializeState(messageAcks, resolvedSelectedChannel, threadSyncedGuilds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ManagerInitializeState)) {
                return false;
            }
            ManagerInitializeState managerInitializeState = (ManagerInitializeState) other;
            return C12238m.areEqual(this.messageAcks, managerInitializeState.messageAcks) && C12238m.areEqual(this.resolvedSelectedChannel, managerInitializeState.resolvedSelectedChannel) && C12238m.areEqual(this.threadSyncedGuilds, managerInitializeState.threadSyncedGuilds);
        }

        public final Map<Long, StoreMessageAck.Ack> getMessageAcks() {
            return this.messageAcks;
        }

        public final StoreChannelsSelected.ResolvedSelectedChannel getResolvedSelectedChannel() {
            return this.resolvedSelectedChannel;
        }

        public final Set<Long> getThreadSyncedGuilds() {
            return this.threadSyncedGuilds;
        }

        public int hashCode() {
            Map<Long, StoreMessageAck.Ack> map = this.messageAcks;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.resolvedSelectedChannel;
            int iHashCode2 = (iHashCode + (resolvedSelectedChannel != null ? resolvedSelectedChannel.hashCode() : 0)) * 31;
            Set<Long> set = this.threadSyncedGuilds;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ManagerInitializeState(messageAcks=");
            sbM833U.append(this.messageAcks);
            sbM833U.append(", resolvedSelectedChannel=");
            sbM833U.append(this.resolvedSelectedChannel);
            sbM833U.append(", threadSyncedGuilds=");
            return C1643a.m826N(sbM833U, this.threadSyncedGuilds, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$2 */
    /* JADX INFO: compiled from: ForumPostReadStateManager.kt */
    public static final /* synthetic */ class C83312 extends C12236k implements Function1<Subscription, Unit> {
        public C83312(ForumPostReadStateManager forumPostReadStateManager) {
            super(1, forumPostReadStateManager, ForumPostReadStateManager.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "p1");
            ((ForumPostReadStateManager) this.receiver).handleSubscription(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$3 */
    /* JADX INFO: compiled from: ForumPostReadStateManager.kt */
    public static final class C83323 extends AbstractC12240o implements Function1<ManagerInitializeState, Unit> {
        public static final C83323 INSTANCE = new C83323();

        public C83323() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManagerInitializeState managerInitializeState) {
            invoke2(managerInitializeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManagerInitializeState managerInitializeState) {
            Map<Long, StoreMessageAck.Ack> mapComponent1 = managerInitializeState.component1();
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = managerInitializeState.getResolvedSelectedChannel();
            Set<Long> setComponent3 = managerInitializeState.component3();
            Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
            if (maybeChannel == null || !ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, maybeChannel.getGuildId(), null, 2, null)) {
                return;
            }
            boolean z2 = setComponent3.contains(Long.valueOf(maybeChannel.getGuildId())) && maybeChannel.getGuildId() != ForumPostReadStateManager.access$getLastSyncedGuildId$p(ForumPostReadStateManager.INSTANCE);
            boolean z3 = ChannelUtils.m7693q(maybeChannel) && maybeChannel.getId() != ForumPostReadStateManager.access$getLastSelectedChannelId$p(ForumPostReadStateManager.INSTANCE);
            if (z2) {
                ForumPostReadStateManager forumPostReadStateManager = ForumPostReadStateManager.INSTANCE;
                ForumPostReadStateManager.internalMessageAcks = mapComponent1;
                ForumPostReadStateManager.lastSyncedGuildId = maybeChannel.getGuildId();
            }
            if (z3 || z2) {
                ForumPostReadStateManager forumPostReadStateManager2 = ForumPostReadStateManager.INSTANCE;
                ForumPostReadStateManager.access$getForumChannelAckBeforeChannelSelect$p(forumPostReadStateManager2).onNext(ForumPostReadStateManager.access$getInternalMessageAcks$p(forumPostReadStateManager2).get(Long.valueOf(maybeChannel.getId())));
            }
            ForumPostReadStateManager forumPostReadStateManager3 = ForumPostReadStateManager.INSTANCE;
            ForumPostReadStateManager.lastSelectedChannelId = resolvedSelectedChannel.getId();
            ForumPostReadStateManager.internalMessageAcks = mapComponent1;
        }
    }

    static {
        BehaviorSubject<StoreMessageAck.Ack> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11129k0, "BehaviorSubject.create()");
        forumChannelAckBeforeChannelSelect = behaviorSubjectM11129k0;
        internalMessageAcks = C12136h0.emptyMap();
        internalThreadSyncedGuilds = new LinkedHashSet();
    }

    private ForumPostReadStateManager() {
    }

    public static final /* synthetic */ BehaviorSubject access$getForumChannelAckBeforeChannelSelect$p(ForumPostReadStateManager forumPostReadStateManager) {
        return forumChannelAckBeforeChannelSelect;
    }

    public static final /* synthetic */ Map access$getInternalMessageAcks$p(ForumPostReadStateManager forumPostReadStateManager) {
        return internalMessageAcks;
    }

    public static final /* synthetic */ long access$getLastSelectedChannelId$p(ForumPostReadStateManager forumPostReadStateManager) {
        return lastSelectedChannelId;
    }

    public static final /* synthetic */ long access$getLastSyncedGuildId$p(ForumPostReadStateManager forumPostReadStateManager) {
        return lastSyncedGuildId;
    }

    private final int compareChannelIds(Long channelId1, Long channelId2) {
        long jLongValue = channelId1 != null ? channelId1.longValue() : 0L;
        long jLongValue2 = channelId2 != null ? channelId2.longValue() : 0L;
        if (jLongValue == jLongValue2) {
            return 0;
        }
        return jLongValue < jLongValue2 ? -1 : 1;
    }

    private final void handleSubscription(Subscription subscription) {
        forumChannelAckSubscription = subscription;
    }

    public static /* synthetic */ void initialize$default(ForumPostReadStateManager forumPostReadStateManager, StoreMessageAck storeMessageAck, StoreChannelsSelected storeChannelsSelected, StoreThreadsActive storeThreadsActive, int i, Object obj) {
        if ((i & 1) != 0) {
            storeMessageAck = StoreStream.INSTANCE.getMessageAck();
        }
        if ((i & 2) != 0) {
            storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
        }
        if ((i & 4) != 0) {
            storeThreadsActive = StoreStream.INSTANCE.getThreadsActive();
        }
        forumPostReadStateManager.initialize(storeMessageAck, storeChannelsSelected, storeThreadsActive);
    }

    private final BehaviorSubject<StoreMessageAck.Ack> observeForumChannelAckBeforeChannelSelect() {
        return forumChannelAckBeforeChannelSelect;
    }

    public final void initialize(StoreMessageAck storeMessageAck, StoreChannelsSelected storeChannelsSelected, StoreThreadsActive storeThreadsActive) {
        C12238m.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Subscription subscription = forumChannelAckSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable observableM11075i = Observable.m11075i(storeMessageAck.observeAll(), storeChannelsSelected.observeResolvedSelectedChannel(), storeThreadsActive.observeThreadSyncedGuilds(), new Func3<Map<Long, ? extends StoreMessageAck.Ack>, StoreChannelsSelected.ResolvedSelectedChannel, Set<? extends Long>, ManagerInitializeState>() { // from class: com.discord.widgets.forums.ForumPostReadStateManager.initialize.1
            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ ManagerInitializeState call(Map<Long, ? extends StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<? extends Long> set) {
                return call2((Map<Long, StoreMessageAck.Ack>) map, resolvedSelectedChannel, (Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final ManagerInitializeState call2(Map<Long, StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> set) {
                C12238m.checkNotNullExpressionValue(map, "messageAcks");
                C12238m.checkNotNullExpressionValue(resolvedSelectedChannel, "resolvedSelectedChannel");
                C12238m.checkNotNullExpressionValue(set, "threadSyncedGuilds");
                return new ManagerInitializeState(map, resolvedSelectedChannel, set);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…threadSyncedGuilds)\n    }");
        ObservableExtensionsKt.appSubscribe(observableM11075i, (Class<?>) ForumPostReadStateManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C83312(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C83323.INSTANCE);
    }

    public final Observable<Map<Long, ForumPostReadState>> observeForumPostReadStates(long guildId, long channelId, StoreReadStates storeReadStates, StoreThreadsActive storeThreadsActive, StoreForumPostReadStates storeForumPostReadStates) {
        C12238m.checkNotNullParameter(storeReadStates, "storeReadStates");
        C12238m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        C12238m.checkNotNullParameter(storeForumPostReadStates, "storeForumPostReadStates");
        Observable<Map<Long, ForumPostReadState>> observableM11073h = Observable.m11073h(storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), storeForumPostReadStates.observeThreadIdsWithPersistedReadStates(), storeReadStates.getUnreadChannelIds(), observeForumChannelAckBeforeChannelSelect(), new Func4<Map<Long, ? extends Channel>, Set<? extends Long>, Set<? extends Long>, StoreMessageAck.Ack, Map<Long, ? extends ForumPostReadState>>() { // from class: com.discord.widgets.forums.ForumPostReadStateManager.observeForumPostReadStates.1

            /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostReadStateManager$observeForumPostReadStates$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: ForumPostReadStateManager.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Long, ForumPostReadState> {
                public final /* synthetic */ StoreMessageAck.Ack $forumChannelAck;
                public final /* synthetic */ Set $persistedThreadIds;
                public final /* synthetic */ Set $unreadChannelIds;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(StoreMessageAck.Ack ack, Set set, Set set2) {
                    super(1);
                    this.$forumChannelAck = ack;
                    this.$persistedThreadIds = set;
                    this.$unreadChannelIds = set2;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ ForumPostReadState invoke(Long l) {
                    return invoke(l.longValue());
                }

                /* JADX WARN: Code duplicated, block: B:13:0x0035  */
                public final ForumPostReadState invoke(long j) {
                    boolean z2;
                    if (this.$persistedThreadIds.contains(Long.valueOf(j))) {
                        z2 = true;
                    } else {
                        StoreMessageAck.Ack ack = this.$forumChannelAck;
                        if ((ack != null ? Long.valueOf(ack.getMessageId()) : null) == null || ForumPostReadStateManager.INSTANCE.compareChannelIds(Long.valueOf(j), Long.valueOf(this.$forumChannelAck.getMessageId())) <= 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    return new ForumPostReadState(j, z2, this.$unreadChannelIds.contains(Long.valueOf(j)));
                }
            }

            @Override // p658rx.functions.Func4
            public /* bridge */ /* synthetic */ Map<Long, ? extends ForumPostReadState> call(Map<Long, ? extends Channel> map, Set<? extends Long> set, Set<? extends Long> set2, StoreMessageAck.Ack ack) {
                return call2((Map<Long, Channel>) map, (Set<Long>) set, (Set<Long>) set2, ack);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, ForumPostReadState> call2(Map<Long, Channel> map, Set<Long> set, Set<Long> set2, StoreMessageAck.Ack ack) {
                Sequence map2 = C12078q.map(C12163u.asSequence(map.keySet()), new AnonymousClass1(ack, set, set2));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : map2) {
                    linkedHashMap.put(Long.valueOf(((ForumPostReadState) obj).getChannelId()), obj);
                }
                return linkedHashMap;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…By { it.channelId }\n    }");
        return observableM11073h;
    }
}
