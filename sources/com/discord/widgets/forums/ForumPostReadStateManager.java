package com.discord.widgets.forums;

import android.content.Context;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreMessageAck$Ack;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActive;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostReadStateManager {
    public static final ForumPostReadStateManager INSTANCE = new ForumPostReadStateManager();
    private static final BehaviorSubject<StoreMessageAck$Ack> forumChannelAckBeforeChannelSelect;
    private static Subscription forumChannelAckSubscription;
    private static Map<Long, StoreMessageAck$Ack> internalMessageAcks;
    private static final Set<Long> internalThreadSyncedGuilds;
    private static long lastSelectedChannelId;
    private static long lastSyncedGuildId;

    static {
        BehaviorSubject<StoreMessageAck$Ack> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        forumChannelAckBeforeChannelSelect = behaviorSubjectK0;
        internalMessageAcks = h0.emptyMap();
        internalThreadSyncedGuilds = new LinkedHashSet();
    }

    private ForumPostReadStateManager() {
    }

    public static final /* synthetic */ int access$compareChannelIds(ForumPostReadStateManager forumPostReadStateManager, Long l, Long l2) {
        return forumPostReadStateManager.compareChannelIds(l, l2);
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

    public static final /* synthetic */ void access$handleSubscription(ForumPostReadStateManager forumPostReadStateManager, Subscription subscription) {
        forumPostReadStateManager.handleSubscription(subscription);
    }

    public static final /* synthetic */ void access$setInternalMessageAcks$p(ForumPostReadStateManager forumPostReadStateManager, Map map) {
        internalMessageAcks = map;
    }

    public static final /* synthetic */ void access$setLastSelectedChannelId$p(ForumPostReadStateManager forumPostReadStateManager, long j) {
        lastSelectedChannelId = j;
    }

    public static final /* synthetic */ void access$setLastSyncedGuildId$p(ForumPostReadStateManager forumPostReadStateManager, long j) {
        lastSyncedGuildId = j;
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
            storeMessageAck = StoreStream.Companion.getMessageAck();
        }
        if ((i & 2) != 0) {
            storeChannelsSelected = StoreStream.Companion.getChannelsSelected();
        }
        if ((i & 4) != 0) {
            storeThreadsActive = StoreStream.Companion.getThreadsActive();
        }
        forumPostReadStateManager.initialize(storeMessageAck, storeChannelsSelected, storeThreadsActive);
    }

    private final BehaviorSubject<StoreMessageAck$Ack> observeForumChannelAckBeforeChannelSelect() {
        return forumChannelAckBeforeChannelSelect;
    }

    public static /* synthetic */ Observable observeForumPostReadStates$default(ForumPostReadStateManager forumPostReadStateManager, long j, long j2, StoreReadStates storeReadStates, StoreThreadsActive storeThreadsActive, StoreForumPostReadStates storeForumPostReadStates, int i, Object obj) {
        return forumPostReadStateManager.observeForumPostReadStates(j, j2, (i & 4) != 0 ? StoreStream.Companion.getReadStates() : storeReadStates, (i & 8) != 0 ? StoreStream.Companion.getThreadsActive() : storeThreadsActive, (i & 16) != 0 ? StoreStream.Companion.getForumPostReadStates() : storeForumPostReadStates);
    }

    public final void initialize(StoreMessageAck storeMessageAck, StoreChannelsSelected storeChannelsSelected, StoreThreadsActive storeThreadsActive) {
        m.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Subscription subscription = forumChannelAckSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable observableI = Observable.i(storeMessageAck.observeAll(), storeChannelsSelected.observeResolvedSelectedChannel(), storeThreadsActive.observeThreadSyncedGuilds(), ForumPostReadStateManager$initialize$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…threadSyncedGuilds)\n    }");
        ObservableExtensionsKt.appSubscribe$default(observableI, ForumPostReadStateManager.class, (Context) null, new ForumPostReadStateManager$initialize$2(this), (Function1) null, (Function0) null, (Function0) null, ForumPostReadStateManager$initialize$3.INSTANCE, 58, (Object) null);
    }

    public final Observable<Map<Long, ForumPostReadState>> observeForumPostReadStates(long guildId, long channelId, StoreReadStates storeReadStates, StoreThreadsActive storeThreadsActive, StoreForumPostReadStates storeForumPostReadStates) {
        m.checkNotNullParameter(storeReadStates, "storeReadStates");
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        m.checkNotNullParameter(storeForumPostReadStates, "storeForumPostReadStates");
        Observable<Map<Long, ForumPostReadState>> observableH = Observable.h(storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), storeForumPostReadStates.observeThreadIdsWithPersistedReadStates(), storeReadStates.getUnreadChannelIds(), observeForumChannelAckBeforeChannelSelect(), ForumPostReadStateManager$observeForumPostReadStates$1.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…By { it.channelId }\n    }");
        return observableH;
    }
}
