package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.threads.ThreadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12150o0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Long, Ack> acks;
    private final Persister<Map<Long, Ack>> acksPersister;
    private Map<Long, Ack> acksSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreStream stream;
    private Subscription threadSyncSubscription;

    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final /* data */ class Ack {
        private final boolean isLockedAck;
        private final long messageId;
        private final boolean viewed;

        public Ack(long j, boolean z2, boolean z3) {
            this.messageId = j;
            this.viewed = z2;
            this.isLockedAck = z3;
        }

        public static /* synthetic */ Ack copy$default(Ack ack, long j, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = ack.messageId;
            }
            if ((i & 2) != 0) {
                z2 = ack.viewed;
            }
            if ((i & 4) != 0) {
                z3 = ack.isLockedAck;
            }
            return ack.copy(j, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getViewed() {
            return this.viewed;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsLockedAck() {
            return this.isLockedAck;
        }

        public final Ack copy(long messageId, boolean viewed, boolean isLockedAck) {
            return new Ack(messageId, viewed, isLockedAck);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ack)) {
                return false;
            }
            Ack ack = (Ack) other;
            return this.messageId == ack.messageId && this.viewed == ack.viewed && this.isLockedAck == ack.isLockedAck;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public final boolean getViewed() {
            return this.viewed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.messageId) * 31;
            boolean z2 = this.viewed;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iM3a + r1) * 31;
            boolean z3 = this.isLockedAck;
            return i + (z3 ? 1 : z3);
        }

        public final boolean isLockedAck() {
            return this.isLockedAck;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Ack(messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", viewed=");
            sbM833U.append(this.viewed);
            sbM833U.append(", isLockedAck=");
            return C1643a.m827O(sbM833U, this.isLockedAck, ")");
        }

        public Ack(ModelReadState modelReadState, boolean z2, boolean z3) {
            this(modelReadState != null ? modelReadState.getLastMessageId() : 0L, z2, z3);
        }
    }

    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static abstract class ThreadAckState {

            /* JADX INFO: compiled from: StoreMessageAck.kt */
            public static final class NotThread extends ThreadAckState {
                public static final NotThread INSTANCE = new NotThread();

                private NotThread() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: StoreMessageAck.kt */
            public static final /* data */ class Thread extends ThreadAckState {
                private final boolean canAckThread;

                public Thread(boolean z2) {
                    super(null);
                    this.canAckThread = z2;
                }

                public static /* synthetic */ Thread copy$default(Thread thread, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = thread.canAckThread;
                    }
                    return thread.copy(z2);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final boolean getCanAckThread() {
                    return this.canAckThread;
                }

                public final Thread copy(boolean canAckThread) {
                    return new Thread(canAckThread);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof Thread) && this.canAckThread == ((Thread) other).canAckThread;
                    }
                    return true;
                }

                public final boolean getCanAckThread() {
                    return this.canAckThread;
                }

                public int hashCode() {
                    boolean z2 = this.canAckThread;
                    if (z2) {
                        return 1;
                    }
                    return z2 ? 1 : 0;
                }

                public String toString() {
                    return C1643a.m827O(C1643a.m833U("Thread(canAckThread="), this.canAckThread, ")");
                }
            }

            private ThreadAckState() {
            }

            public /* synthetic */ ThreadAckState(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public final boolean isNonThreadChannel(ThreadAckState threadAckState) {
            return threadAckState instanceof ThreadAckState.NotThread;
        }

        public final boolean isThreadAndAbleToAck(ThreadAckState threadAckState) {
            return (threadAckState instanceof ThreadAckState.Thread) && ((ThreadAckState.Thread) threadAckState).getCanAckThread();
        }

        public final boolean isThreadAndUnableToAck(ThreadAckState threadAckState) {
            return (threadAckState instanceof ThreadAckState.Thread) && !((ThreadAckState.Thread) threadAckState).getCanAckThread();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final /* data */ class PendingAck {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final PendingAck EMPTY = new PendingAck(0, new Ack(0L, false, false));
        private final Ack ack;
        private final long channelId;

        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class Companion {
            private Companion() {
            }

            public final PendingAck getEMPTY() {
                return PendingAck.EMPTY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public PendingAck(long j, Ack ack) {
            C12238m.checkNotNullParameter(ack, "ack");
            this.channelId = j;
            this.ack = ack;
        }

        public static /* synthetic */ PendingAck copy$default(PendingAck pendingAck, long j, Ack ack, int i, Object obj) {
            if ((i & 1) != 0) {
                j = pendingAck.channelId;
            }
            if ((i & 2) != 0) {
                ack = pendingAck.ack;
            }
            return pendingAck.copy(j, ack);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Ack getAck() {
            return this.ack;
        }

        public final PendingAck copy(long channelId, Ack ack) {
            C12238m.checkNotNullParameter(ack, "ack");
            return new PendingAck(channelId, ack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingAck)) {
                return false;
            }
            PendingAck pendingAck = (PendingAck) other;
            return this.channelId == pendingAck.channelId && C12238m.areEqual(this.ack, pendingAck.ack);
        }

        public final Ack getAck() {
            return this.ack;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.channelId) * 31;
            Ack ack = this.ack;
            return iM3a + (ack != null ? ack.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PendingAck(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", ack=");
            sbM833U.append(this.ack);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$ack$1 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C61971 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $clearLock;
        public final /* synthetic */ boolean $isLockedAck;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61971(long j, boolean z2, boolean z3) {
            super(0);
            this.$channelId = j;
            this.$isLockedAck = z2;
            this.$clearLock = z3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreMessageAck.this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                if (channelFindChannelByIdInternal$app_productionGoogleRelease.getType() != 4) {
                    StoreMessageAck.this.internalAck(channelFindChannelByIdInternal$app_productionGoogleRelease, this.$isLockedAck, this.$clearLock);
                    return;
                }
                Iterator<T> it = StoreMessageAck.this.stream.getChannels().findChannelsByCategoryInternal$app_productionGoogleRelease(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getId()).iterator();
                while (it.hasNext()) {
                    StoreMessageAck.this.internalAck((Channel) it.next(), this.$isLockedAck, this.$clearLock);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$getPendingAck$1 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C61981 extends AbstractC12240o implements Function2<Ack, Long, Boolean> {
        public final /* synthetic */ boolean $clearLock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61981(boolean z2) {
            super(2);
            this.$clearLock = z2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(Ack ack, Long l) {
            return Boolean.valueOf(invoke(ack, l.longValue()));
        }

        public final boolean invoke(Ack ack, long j) {
            boolean zIsNewer = MessageUtils.isNewer(ack != null ? Long.valueOf(ack.getMessageId()) : null, Long.valueOf(j));
            boolean z2 = ack == null || !ack.isLockedAck();
            if (zIsNewer) {
                return this.$clearLock || z2;
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$3 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C62003 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C62003() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            StoreMessageAck.this.threadSyncSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C62014 extends AbstractC12240o implements Function1<Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Set $newThreadIds;
            public final /* synthetic */ Set $oldThreadIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Set set, Set set2) {
                super(0);
                this.$oldThreadIds = set;
                this.$newThreadIds = set2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.this.updateThreadAcks(this.$oldThreadIds, this.$newThreadIds);
            }
        }

        public C62014() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> pair) {
            invoke2((Pair<? extends Set<Long>, ? extends Set<Long>>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends Set<Long>, ? extends Set<Long>> pair) {
            C12238m.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            StoreMessageAck.this.dispatcher.schedule(new AnonymousClass1(pair.component1(), pair.component2()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$markUnread$3 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C62053 extends AbstractC12240o implements Function1<Pair<? extends List<? extends Message>, ? extends Companion.ThreadAckState>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$markUnread$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $channelMessages;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$channelMessages = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                List list = this.$channelMessages;
                ArrayList arrayListM840a0 = C1643a.m840a0(list, "channelMessages");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((Message) next).getId() < C62053.this.$messageId) {
                        arrayListM840a0.add(next);
                    }
                }
                Iterator it2 = arrayListM840a0.iterator();
                if (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (it2.hasNext()) {
                        long id2 = ((Message) next2).getId();
                        do {
                            Object next3 = it2.next();
                            long id3 = ((Message) next3).getId();
                            if (id2 < id3) {
                                next2 = next3;
                                id2 = id3;
                            }
                        } while (it2.hasNext());
                    }
                    obj = next2;
                } else {
                    obj = null;
                }
                Message message = (Message) obj;
                List list2 = this.$channelMessages;
                ArrayList arrayListM840a1 = C1643a.m840a0(list2, "channelMessages");
                for (Object obj2 : list2) {
                    if (((Message) obj2).getId() >= C62053.this.$messageId) {
                        arrayListM840a1.add(obj2);
                    }
                }
                Ack ack = new Ack(message != null ? message.getId() : (((C62053.this.$messageId >>> 22) - 1) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, true);
                C62053 c62053 = C62053.this;
                StoreMessageAck.this.updateAcks(c62053.$channelId, ack);
                int iProcessMarkUnread$app_productionGoogleRelease = StoreStream.INSTANCE.getMentions().processMarkUnread$app_productionGoogleRelease(C62053.this.$channelId, arrayListM840a1);
                StoreMessageAck storeMessageAck = StoreMessageAck.this;
                C12721k c12721k = new C12721k(new PendingAck(C62053.this.$channelId, ack));
                C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(PendingAck(channelId, ack))");
                storeMessageAck.postPendingAck(c12721k, iProcessMarkUnread$app_productionGoogleRelease);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62053(long j, long j2) {
            super(1);
            this.$messageId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends Message>, ? extends Companion.ThreadAckState> pair) {
            invoke2((Pair<? extends List<Message>, ? extends Companion.ThreadAckState>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends List<Message>, ? extends Companion.ThreadAckState> pair) {
            List<Message> listComponent1 = pair.component1();
            if (StoreMessageAck.INSTANCE.isThreadAndUnableToAck(pair.component2())) {
                return;
            }
            StoreMessageAck.this.dispatcher.schedule(new AnonymousClass1(listComponent1));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$observeAll$1 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C62081 extends AbstractC12240o implements Function0<Map<Long, ? extends Ack>> {
        public C62081() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Ack> invoke() {
            return StoreMessageAck.this.getAll();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$observeForChannel$1 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C62091 extends AbstractC12240o implements Function0<Ack> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62091(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Ack invoke() {
            return StoreMessageAck.this.getForChannel(this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$observeThreadAckState$1 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C62101 extends AbstractC12240o implements Function0<Companion.ThreadAckState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62101(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Companion.ThreadAckState invoke() {
            StoreMessageAck storeMessageAck = StoreMessageAck.this;
            return StoreMessageAck.getThreadAckStateInternal$default(storeMessageAck, this.$channelId, storeMessageAck.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease(), StoreMessageAck.this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease(), null, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class C62111 extends AbstractC12240o implements Function1<PendingAck, Unit> {
        public final /* synthetic */ int $mentionCount;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Ack $ack;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, Ack ack) {
                super(0);
                this.$channelId = j;
                this.$ack = ack;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.this.updateAcks(this.$channelId, this.$ack);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Void, Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62111(int i) {
            super(1);
            this.$mentionCount = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            C12238m.checkNotNullParameter(pendingAck, "pendingAck");
            final long channelId = pendingAck.getChannelId();
            Ack ack = pendingAck.getAck();
            StoreMessageAck.this.dispatcher.schedule(new AnonymousClass1(channelId, ack));
            Observable observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(StoreMessageAck.this.restAPI.postChannelMessagesAck(channelId, Long.valueOf(ack.getMessageId()), new RestAPIParams.ChannelMessagesAck(Boolean.valueOf(ack.isLockedAck()), Integer.valueOf(this.$mentionCount))), false, 1, null).m11115u(new Action1<Void>() { // from class: com.discord.stores.StoreMessageAck.postPendingAck.1.2
                @Override // p658rx.functions.Action1
                public final void call(Void r3) {
                    StoreStream.INSTANCE.getAnalytics().ackMessage(channelId);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11115u, "restAPI\n          .postC…).ackMessage(channelId) }");
            ObservableExtensionsKt.appSubscribe(observableM11115u, (117 & 1) != 0 ? null : null, "REST: ack", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), AnonymousClass3.INSTANCE, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$3 */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final /* synthetic */ class C62133 extends C12236k implements Function1<PendingAck, Unit> {
        public final /* synthetic */ C62111 $postChannelMessagesAck$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62133(C62111 c62111) {
            super(1, null, "postChannelMessagesAck", "invoke(Lcom/discord/stores/StoreMessageAck$PendingAck;)V", 0);
            this.$postChannelMessagesAck$1 = c62111;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            C12238m.checkNotNullParameter(pendingAck, "p1");
            this.$postChannelMessagesAck$1.invoke2(pendingAck);
        }
    }

    public StoreMessageAck(StoreStream storeStream, ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        Persister<Map<Long, Ack>> persister = new Persister<>("MOST_RECENT_ACKS_V3", new HashMap());
        this.acksPersister = persister;
        this.acksSnapshot = persister.get();
        this.acks = new HashMap(this.acksSnapshot);
    }

    public static /* synthetic */ void ack$default(StoreMessageAck storeMessageAck, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = false;
        }
        storeMessageAck.ack(j, z2, z3);
    }

    private final Observable<PendingAck> getPendingAck(Observable<Long> observable, final boolean z2, boolean z3) {
        final C61981 c61981 = new C61981(z3);
        Observable observableM11099Y = observable.m11099Y(new InterfaceC12589b<Long, Observable<? extends PendingAck>>() { // from class: com.discord.stores.StoreMessageAck.getPendingAck.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends PendingAck> call(final Long l) {
                if (l.longValue() <= 0) {
                    return new C12721k(PendingAck.INSTANCE.getEMPTY());
                }
                StoreMessageAck messageAck = StoreMessageAck.this.stream.getMessageAck();
                C12238m.checkNotNullExpressionValue(l, "channelId");
                return Observable.m11075i(messageAck.observeForChannel(l.longValue()), StoreMessageAck.this.stream.getMessagesMostRecent().observeRecentMessageIds(l.longValue()), StoreMessageAck.this.observeThreadAckState(l.longValue()), new Func3<Ack, Long, Companion.ThreadAckState, PendingAck>() { // from class: com.discord.stores.StoreMessageAck.getPendingAck.2.1
                    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
                    
                        if (r8.invoke(r6, r7.longValue()) != false) goto L14;
                     */
                    @Override // p658rx.functions.Func3
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final PendingAck call(Ack ack, Long l2, Companion.ThreadAckState threadAckState) {
                        Companion companion = StoreMessageAck.INSTANCE;
                        if (companion.isNonThreadChannel(threadAckState) || companion.isThreadAndAbleToAck(threadAckState)) {
                            C61992 c61992 = C61992.this;
                            if (!z2) {
                                C61981 c61982 = c61981;
                                C12238m.checkNotNullExpressionValue(l2, "mostRecentMessageId");
                            }
                            Long l3 = l;
                            C12238m.checkNotNullExpressionValue(l3, "channelId");
                            long jLongValue = l3.longValue();
                            C12238m.checkNotNullExpressionValue(l2, "mostRecentMessageId");
                            return new PendingAck(jLongValue, new Ack(l2.longValue(), true, z2));
                        }
                        return PendingAck.INSTANCE.getEMPTY();
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "switchMap { channelId ->…gAck.EMPTY)\n      }\n    }");
        return observableM11099Y;
    }

    @StoreThread
    private final Companion.ThreadAckState getThreadAckStateInternal(long channelId, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads, Map<Long, Channel> activeForumThreads, StoreChannels storeChannels) {
        Channel channel = storeChannels.getChannel(channelId);
        if (channel == null) {
            return null;
        }
        if (ChannelUtils.m7673H(channel)) {
            return (activeAndJoinedThreads.containsKey(Long.valueOf(channelId)) || activeForumThreads.containsKey(Long.valueOf(channelId))) ? new Companion.ThreadAckState.Thread(true) : new Companion.ThreadAckState.Thread(false);
        }
        return Companion.ThreadAckState.NotThread.INSTANCE;
    }

    public static /* synthetic */ Companion.ThreadAckState getThreadAckStateInternal$default(StoreMessageAck storeMessageAck, long j, Map map, Map map2, StoreChannels storeChannels, int i, Object obj) {
        if ((i & 8) != 0) {
            storeChannels = storeMessageAck.stream.getChannels();
        }
        return storeMessageAck.getThreadAckStateInternal(j, map, map2, storeChannels);
    }

    private final void internalAck(Channel channel, boolean isLockedAck, boolean clearLock) {
        C12721k c12721k = new C12721k(Long.valueOf(channel.getId()));
        C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(channel.id)");
        postPendingAck$default(this, ObservableExtensionsKt.takeSingleUntilTimeout$default(getPendingAck(c12721k, isLockedAck, clearLock), 0L, false, 1, null), 0, 1, null);
    }

    private final Observable<Pair<Set<Long>, Set<Long>>> observeActiveThreadIdsWithPrevious() {
        Observable observableM11076j = Observable.m11076j(this.stream.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), this.stream.getThreadsActive().observeAllActiveForumThreadsById(), new Func2<Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Map<Long, ? extends Channel>, Set<? extends Long>>() { // from class: com.discord.stores.StoreMessageAck.observeActiveThreadIdsWithPrevious.1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, ? extends Channel> map2) {
                return call2((Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map, (Map<Long, Channel>) map2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Set<Long> call2(Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, Channel> map2) {
                return C12150o0.plus((Set) map.keySet(), (Iterable) map2.keySet());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…veForumThreads.keys\n    }");
        Observable<Pair<Set<Long>, Set<Long>>> observableM11091Q = ObservableExtensionsKt.leadingEdgeThrottle(observableM11076j, 1L, TimeUnit.SECONDS).m11112r().m11091Q(new Pair(C12148n0.emptySet(), C12148n0.emptySet()), new Func2<Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Set<? extends Long>, Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>>() { // from class: com.discord.stores.StoreMessageAck.observeActiveThreadIdsWithPrevious.2
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> call(Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> pair, Set<? extends Long> set) {
                return call2((Pair<? extends Set<Long>, ? extends Set<Long>>) pair, (Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<Set<Long>, Set<Long>> call2(Pair<? extends Set<Long>, ? extends Set<Long>> pair, Set<Long> set) {
                return new Pair<>(pair.getSecond(), set);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11091Q, "Observable.combineLatest…ond, threadIds)\n        }");
        return observableM11091Q;
    }

    private final Observable<Companion.ThreadAckState> observeThreadAckState(long channelId) {
        Observable<Companion.ThreadAckState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getThreadsActiveJoined(), this.stream.getThreadsActive()}, false, null, null, new C62101(channelId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    private final void postPendingAck(Observable<PendingAck> observable, int i) {
        C62111 c62111 = new C62111(i);
        Observable<PendingAck> observableM11118y = observable.m11118y(new InterfaceC12589b<PendingAck, Boolean>() { // from class: com.discord.stores.StoreMessageAck.postPendingAck.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(PendingAck pendingAck) {
                return Boolean.valueOf(!C12238m.areEqual(pendingAck, PendingAck.INSTANCE.getEMPTY()));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "filter { it != PendingAck.EMPTY }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observableM11118y), (Class<?>) observable.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C62133(c62111));
    }

    public static /* synthetic */ void postPendingAck$default(StoreMessageAck storeMessageAck, Observable observable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        storeMessageAck.postPendingAck(observable, i);
    }

    @StoreThread
    private final void pruneAcks() {
        if (!this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            return;
        }
        Map<Long, Channel> channelsByIdInternal$app_productionGoogleRelease = this.stream.getChannels().getChannelsByIdInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator<Long> it = this.acks.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!channelsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !activeJoinedThreadsInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !allForumThreadsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue))) {
                it.remove();
                markChanged();
            }
        }
    }

    @StoreThread
    private final void updateAcks(long channelId, Ack ackNewer) {
        if (INSTANCE.isThreadAndUnableToAck(getThreadAckStateInternal$default(this, channelId, this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease(), null, 8, null))) {
            return;
        }
        Ack ack = this.acks.get(Long.valueOf(channelId));
        if (ack == null || MessageUtils.compareMessages(Long.valueOf(ack.getMessageId()), Long.valueOf(ackNewer.getMessageId())) != 0 || (ackNewer.isLockedAck() && !ack.isLockedAck())) {
            this.acks.put(Long.valueOf(channelId), ackNewer);
            markChanged();
        }
    }

    @StoreThread
    private final void updateThreadAcks(Set<Long> oldThreadIds, Set<Long> newThreadIds) {
        Channel channel;
        UtcDateTime joinTimestamp;
        if (this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            Iterator it = C12150o0.minus((Set) oldThreadIds, (Iterable) newThreadIds).iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                if (this.acks.containsKey(Long.valueOf(jLongValue)) && this.acks.remove(Long.valueOf(jLongValue)) != null) {
                    markChanged();
                }
            }
        }
        Map<Long, Long> guildsJoinedAtInternal$app_productionGoogleRelease = this.stream.getGuilds().getGuildsJoinedAtInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator it2 = C12150o0.minus((Set) newThreadIds, (Iterable) oldThreadIds).iterator();
        while (it2.hasNext()) {
            long jLongValue2 = ((Number) it2.next()).longValue();
            if (!this.acks.containsKey(Long.valueOf(jLongValue2))) {
                if (INSTANCE.isThreadAndAbleToAck(getThreadAckStateInternal$default(this, jLongValue2, activeJoinedThreadsInternal$app_productionGoogleRelease, allForumThreadsByIdInternal$app_productionGoogleRelease, null, 8, null))) {
                    StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread = activeJoinedThreadsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    if (activeJoinedThread == null || (channel = activeJoinedThread.getChannel()) == null) {
                        channel = allForumThreadsByIdInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    }
                    Channel channel2 = channel;
                    if (channel2 != null) {
                        this.acks.put(Long.valueOf(jLongValue2), new Ack((ThreadUtils.getThreadAckMessageTimestamp$default(ThreadUtils.INSTANCE, channel2, (Long) C1643a.m843c(channel2, guildsJoinedAtInternal$app_productionGoogleRelease), (activeJoinedThread == null || (joinTimestamp = activeJoinedThread.getJoinTimestamp()) == null) ? null : Long.valueOf(joinTimestamp.getDateTimeMillis()), null, 4, null) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, false));
                        markChanged();
                    }
                }
            }
        }
    }

    public final void ack(long channelId, boolean isLockedAck, boolean clearLock) {
        this.dispatcher.schedule(new C61971(channelId, isLockedAck, clearLock));
    }

    public final Map<Long, Ack> getAll() {
        return this.acksSnapshot;
    }

    @StoreThread
    public final Map<Long, Ack> getAllInternal() {
        return this.acks;
    }

    public final Ack getForChannel(long channelId) {
        return getAll().get(Long.valueOf(channelId));
    }

    @StoreThread
    public final void handleChannelSelected() {
        for (Map.Entry<Long, Ack> entry : this.acks.entrySet()) {
            this.acks.put(Long.valueOf(entry.getKey().longValue()), Ack.copy$default(entry.getValue(), 0L, false, false, 3, null));
        }
        markChanged();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cc  */
    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        long dateTimeMillis;
        Object next;
        UtcDateTime joinedAt;
        C12238m.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        C12238m.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.acks.clear();
        }
        Map<Long, Ack> map = this.acks;
        ModelPayload.VersionedReadStates readState2 = payload.getReadState();
        C12238m.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        C12238m.checkNotNullExpressionValue(entries, "payload.readState.entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(entries, 10)), 16));
        for (ModelReadState modelReadState : entries) {
            Pair pairM10073to = C12116o.m10073to(Long.valueOf(modelReadState.getChannelId()), new Ack(modelReadState, false, false));
            linkedHashMap.put(pairM10073to.getFirst(), pairM10073to.getSecond());
        }
        map.putAll(linkedHashMap);
        List<Guild> guilds = payload.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<GuildMember> listM7875v = guild.m7875v();
            if (listM7875v != null) {
                Iterator<T> it = listM7875v.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!(((GuildMember) next).getUser().getId() == payload.getMe().getId()));
                GuildMember guildMember = (GuildMember) next;
                if (guildMember == null || (joinedAt = guildMember.getJoinedAt()) == null) {
                    dateTimeMillis = 0;
                } else {
                    dateTimeMillis = joinedAt.getDateTimeMillis();
                }
            } else {
                dateTimeMillis = 0;
            }
            List<Channel> listM7860g = guild.m7860g();
            if (listM7860g != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listM7860g) {
                    Channel channel = (Channel) obj;
                    C12238m.checkNotNullParameter(channel, "$this$isTextyOrVoiceChannel");
                    if ((ChannelUtils.m7698v(channel) || ChannelUtils.m7675J(channel)) && !this.acks.containsKey(Long.valueOf(channel.getId()))) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<Channel> arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if ((((Channel) obj2).getLastMessageId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < dateTimeMillis) {
                        arrayList2.add(obj2);
                    }
                }
                for (Channel channel2 : arrayList2) {
                    this.acks.put(Long.valueOf(channel2.getId()), new Ack(channel2.getLastMessageId(), false, false));
                }
            }
        }
        pruneAcks();
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observeActiveThreadIdsWithPrevious()), (Class<?>) StoreMessageAck.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C62003()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C62014());
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate() {
        pruneAcks();
    }

    @StoreThread
    public final void handleMessageAck(ModelReadState readState) {
        C12238m.checkNotNullParameter(readState, "readState");
        updateAcks(readState.getChannelId(), new Ack(readState, false, false));
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author == null || author.getId() != this.stream.getUsers().getMe().getId()) {
            return;
        }
        updateAcks(message.getChannelId(), new Ack(message.getId(), false, false));
    }

    @StoreThread
    public final void handlePreLogout() {
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.threadSyncSubscription = null;
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Channel channelFindChannelById;
        C12238m.checkNotNullParameter(channel, "channel");
        boolean z2 = channel.getOwnerId() == this.stream.getUsers().getMe().getId();
        if (ChannelUtils.m7673H(channel) && !ChannelUtils.m7686j(channel) && z2 && (channelFindChannelById = this.stream.getChannels().findChannelById(channel.getParentId())) != null && ChannelUtils.m7693q(channelFindChannelById)) {
            updateAcks(channelFindChannelById.getId(), new Ack(channel.getId(), false, false));
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().m11112r().m11099Y(new InterfaceC12589b<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends Long>>() { // from class: com.discord.stores.StoreMessageAck.init.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Long> call(final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                return Observable.m11073h(StoreMessageAck.this.stream.getMessages().getAllDetached().m11110p(50L, TimeUnit.MILLISECONDS), StoreMessageAck.this.stream.getMessagesLoader().getMessagesLoadedState(resolvedSelectedChannel.getId()).m11083G(new InterfaceC12589b<StoreMessagesLoader.ChannelLoadedState, Boolean>() { // from class: com.discord.stores.StoreMessageAck.init.1.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Boolean call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                        return Boolean.valueOf(channelLoadedState.isInitialMessagesLoaded() && !channelLoadedState.isLoadingMessages());
                    }
                }).m11112r(), StoreMessageAck.this.stream.getChat().observeInteractionState().m11118y(new InterfaceC12589b<StoreChat.InteractionState, Boolean>() { // from class: com.discord.stores.StoreMessageAck.init.1.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Boolean call(StoreChat.InteractionState interactionState) {
                        return Boolean.valueOf(interactionState.getChannelId() == resolvedSelectedChannel.getId());
                    }
                }), StoreMessageAck.this.stream.getMessageAck().observeForChannel(resolvedSelectedChannel.getId()), new Func4<Set<? extends Long>, Boolean, StoreChat.InteractionState, Ack, Long>() { // from class: com.discord.stores.StoreMessageAck.init.1.3
                    @Override // p658rx.functions.Func4
                    public /* bridge */ /* synthetic */ Long call(Set<? extends Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                        return call2((Set<Long>) set, bool, interactionState, ack);
                    }

                    /* JADX WARN: Code duplicated, block: B:19:0x003f  */
                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Long call2(Set<Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                        long channelId;
                        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
                        boolean z2 = maybeChannel != null && ChannelUtils.m7691o(maybeChannel);
                        if (interactionState.isAtBottomIgnoringTouch()) {
                            C12238m.checkNotNullExpressionValue(bool, "isLoadingSettled");
                            if (!bool.booleanValue() || set.contains(Long.valueOf(interactionState.getChannelId())) || z2 || (ack != null && ack.isLockedAck())) {
                                channelId = 0;
                            } else {
                                channelId = interactionState.getChannelId();
                            }
                        } else {
                            channelId = 0;
                        }
                        return Long.valueOf(channelId);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get… 0L\n          }\n        }");
        Observable<Long> observableM11110p = ObservableExtensionsKt.computationLatest(observableM11099Y).m11110p(500L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "StoreStream\n        .get…0, TimeUnit.MILLISECONDS)");
        postPendingAck$default(this, getPendingAck(observableM11110p, false, false), 0, 1, null);
    }

    public final void markUnread(long channelId, long messageId) {
        Observable observableM11076j = Observable.m11076j(this.stream.getMessages().observeMessagesForChannel(channelId).m11118y(new InterfaceC12589b<List<? extends Message>, Boolean>() { // from class: com.discord.stores.StoreMessageAck.markUnread.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list) {
                return call2((List<Message>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(List<Message> list) {
                C12238m.checkNotNullExpressionValue(list, "it");
                return Boolean.valueOf(!list.isEmpty());
            }
        }), observeThreadAckState(channelId), new Func2<List<? extends Message>, Companion.ThreadAckState, Pair<? extends List<? extends Message>, ? extends Companion.ThreadAckState>>() { // from class: com.discord.stores.StoreMessageAck.markUnread.2
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Pair<? extends List<? extends Message>, ? extends Companion.ThreadAckState> call(List<? extends Message> list, Companion.ThreadAckState threadAckState) {
                return call2((List<Message>) list, threadAckState);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<List<Message>, Companion.ThreadAckState> call2(List<Message> list, Companion.ThreadAckState threadAckState) {
                return new Pair<>(list, threadAckState);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…lMessages, threadState) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout(observableM11076j, 10L, false), (Class<?>) StoreMessageAck.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C62053(messageId, channelId));
    }

    public final Observable<Map<Long, Ack>> observeAll() {
        Observable<Map<Long, Ack>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C62081(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Ack> observeForChannel(long channelId) {
        Observable<Ack> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C62091(channelId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensionsKt.snapshot$default(this.acks, 0, 0.0f, 3, null);
        this.acksSnapshot = mapSnapshot$default;
        Persister.set$default(this.acksPersister, mapSnapshot$default, false, 2, null);
    }
}
