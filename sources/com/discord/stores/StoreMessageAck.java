package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.outline;
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
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.error.Error;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.Tuples;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;

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
            int iA = b.a(this.messageId) * 31;
            boolean z2 = this.viewed;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iA + r1) * 31;
            boolean z3 = this.isLockedAck;
            return i + (z3 ? 1 : z3);
        }

        public final boolean isLockedAck() {
            return this.isLockedAck;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Ack(messageId=");
            sbU.append(this.messageId);
            sbU.append(", viewed=");
            sbU.append(this.viewed);
            sbU.append(", isLockedAck=");
            return outline.O(sbU, this.isLockedAck, ")");
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
                    return outline.O(outline.U("Thread(canAckThread="), this.canAckThread, ")");
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
            Intrinsics3.checkNotNullParameter(ack, "ack");
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
            Intrinsics3.checkNotNullParameter(ack, "ack");
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
            return this.channelId == pendingAck.channelId && Intrinsics3.areEqual(this.ack, pendingAck.ack);
        }

        public final Ack getAck() {
            return this.ack;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            Ack ack = this.ack;
            return iA + (ack != null ? ack.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("PendingAck(channelId=");
            sbU.append(this.channelId);
            sbU.append(", ack=");
            sbU.append(this.ack);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$ack$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $clearLock;
        public final /* synthetic */ boolean $isLockedAck;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2, boolean z3) {
            super(0);
            this.$channelId = j;
            this.$isLockedAck = z2;
            this.$clearLock = z3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$getPendingAck$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Ack, Long, Boolean> {
        public final /* synthetic */ boolean $clearLock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreMessageAck.this.threadSyncSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.this.updateThreadAcks(this.$oldThreadIds, this.$newThreadIds);
            }
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2) {
            invoke2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2) {
            Intrinsics3.checkNotNullParameter(tuples2, "<name for destructuring parameter 0>");
            StoreMessageAck.this.dispatcher.schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$markUnread$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$markUnread$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $channelMessages;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$channelMessages = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                List list = this.$channelMessages;
                ArrayList arrayListA0 = outline.a0(list, "channelMessages");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((Message) next).getId() < AnonymousClass3.this.$messageId) {
                        arrayListA0.add(next);
                    }
                }
                Iterator it2 = arrayListA0.iterator();
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
                ArrayList arrayListA1 = outline.a0(list2, "channelMessages");
                for (Object obj2 : list2) {
                    if (((Message) obj2).getId() >= AnonymousClass3.this.$messageId) {
                        arrayListA1.add(obj2);
                    }
                }
                Ack ack = new Ack(message != null ? message.getId() : (((AnonymousClass3.this.$messageId >>> 22) - 1) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, true);
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreMessageAck.this.updateAcks(anonymousClass3.$channelId, ack);
                int iProcessMarkUnread$app_productionGoogleRelease = StoreStream.INSTANCE.getMentions().processMarkUnread$app_productionGoogleRelease(AnonymousClass3.this.$channelId, arrayListA1);
                StoreMessageAck storeMessageAck = StoreMessageAck.this;
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new PendingAck(AnonymousClass3.this.$channelId, ack));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(PendingAck(channelId, ack))");
                storeMessageAck.postPendingAck(scalarSynchronousObservable, iProcessMarkUnread$app_productionGoogleRelease);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j, long j2) {
            super(1);
            this.$messageId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState> tuples2) {
            invoke2((Tuples2<? extends List<Message>, ? extends Companion.ThreadAckState>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<Message>, ? extends Companion.ThreadAckState> tuples2) {
            List<Message> listComponent1 = tuples2.component1();
            if (StoreMessageAck.INSTANCE.isThreadAndUnableToAck(tuples2.component2())) {
                return;
            }
            StoreMessageAck.this.dispatcher.schedule(new AnonymousClass1(listComponent1));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$observeAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Ack>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Ack> invoke() {
            return StoreMessageAck.this.getAll();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$observeForChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Ack> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Ack invoke() {
            return StoreMessageAck.this.getForChannel(this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$observeThreadAckState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Companion.ThreadAckState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<PendingAck, Unit> {
        public final /* synthetic */ int $mentionCount;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class C01521 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Ack $ack;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01521(long j, Ack ack) {
                super(0);
                this.$channelId = j;
                this.$ack = ack;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.this.updateAcks(this.$channelId, this.$ack);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageAck.kt */
        public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$mentionCount = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            Intrinsics3.checkNotNullParameter(pendingAck, "pendingAck");
            final long channelId = pendingAck.getChannelId();
            Ack ack = pendingAck.getAck();
            StoreMessageAck.this.dispatcher.schedule(new C01521(channelId, ack));
            Observable observableU = ObservableExtensionsKt.restSubscribeOn$default(StoreMessageAck.this.restAPI.postChannelMessagesAck(channelId, Long.valueOf(ack.getMessageId()), new RestAPIParams.ChannelMessagesAck(Boolean.valueOf(ack.isLockedAck()), Integer.valueOf(this.$mentionCount))), false, 1, null).u(new Action1<Void>() { // from class: com.discord.stores.StoreMessageAck.postPendingAck.1.2
                @Override // rx.functions.Action1
                public final void call(Void r3) {
                    StoreStream.INSTANCE.getAnalytics().ackMessage(channelId);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableU, "restAPI\n          .postC…).ackMessage(channelId) }");
            ObservableExtensionsKt.appSubscribe(observableU, (117 & 1) != 0 ? null : null, "REST: ack", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), AnonymousClass3.INSTANCE, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageAck$postPendingAck$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageAck.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<PendingAck, Unit> {
        public final /* synthetic */ AnonymousClass1 $postChannelMessagesAck$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(1, null, "postChannelMessagesAck", "invoke(Lcom/discord/stores/StoreMessageAck$PendingAck;)V", 0);
            this.$postChannelMessagesAck$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            Intrinsics3.checkNotNullParameter(pendingAck, "p1");
            this.$postChannelMessagesAck$1.invoke2(pendingAck);
        }
    }

    public StoreMessageAck(StoreStream storeStream, ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
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
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(z3);
        Observable observableY = observable.Y(new Func1<Long, Observable<? extends PendingAck>>() { // from class: com.discord.stores.StoreMessageAck.getPendingAck.2
            @Override // j0.k.Func1
            public final Observable<? extends PendingAck> call(final Long l) {
                if (l.longValue() <= 0) {
                    return new ScalarSynchronousObservable(PendingAck.INSTANCE.getEMPTY());
                }
                StoreMessageAck messageAck = StoreMessageAck.this.stream.getMessageAck();
                Intrinsics3.checkNotNullExpressionValue(l, "channelId");
                return Observable.i(messageAck.observeForChannel(l.longValue()), StoreMessageAck.this.stream.getMessagesMostRecent().observeRecentMessageIds(l.longValue()), StoreMessageAck.this.observeThreadAckState(l.longValue()), new Func3<Ack, Long, Companion.ThreadAckState, PendingAck>() { // from class: com.discord.stores.StoreMessageAck.getPendingAck.2.1
                    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
                    
                        if (r8.invoke(r6, r7.longValue()) != false) goto L14;
                     */
                    @Override // rx.functions.Func3
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final PendingAck call(Ack ack, Long l2, Companion.ThreadAckState threadAckState) {
                        Companion companion = StoreMessageAck.INSTANCE;
                        if (companion.isNonThreadChannel(threadAckState) || companion.isThreadAndAbleToAck(threadAckState)) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (!z2) {
                                AnonymousClass1 anonymousClass3 = anonymousClass1;
                                Intrinsics3.checkNotNullExpressionValue(l2, "mostRecentMessageId");
                            }
                            Long l3 = l;
                            Intrinsics3.checkNotNullExpressionValue(l3, "channelId");
                            long jLongValue = l3.longValue();
                            Intrinsics3.checkNotNullExpressionValue(l2, "mostRecentMessageId");
                            return new PendingAck(jLongValue, new Ack(l2.longValue(), true, z2));
                        }
                        return PendingAck.INSTANCE.getEMPTY();
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "switchMap { channelId ->…gAck.EMPTY)\n      }\n    }");
        return observableY;
    }

    @Store3
    private final Companion.ThreadAckState getThreadAckStateInternal(long channelId, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads, Map<Long, Channel> activeForumThreads, StoreChannels storeChannels) {
        Channel channel = storeChannels.getChannel(channelId);
        if (channel == null) {
            return null;
        }
        if (ChannelUtils.H(channel)) {
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
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Long.valueOf(channel.getId()));
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(channel.id)");
        postPendingAck$default(this, ObservableExtensionsKt.takeSingleUntilTimeout$default(getPendingAck(scalarSynchronousObservable, isLockedAck, clearLock), 0L, false, 1, null), 0, 1, null);
    }

    private final Observable<Tuples2<Set<Long>, Set<Long>>> observeActiveThreadIdsWithPrevious() {
        Observable observableJ = Observable.j(this.stream.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), this.stream.getThreadsActive().observeAllActiveForumThreadsById(), new Func2<Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Map<Long, ? extends Channel>, Set<? extends Long>>() { // from class: com.discord.stores.StoreMessageAck.observeActiveThreadIdsWithPrevious.1
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, ? extends Channel> map2) {
                return call2((Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map, (Map<Long, Channel>) map2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Set<Long> call2(Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, Channel> map2) {
                return _Sets.plus((Set) map.keySet(), (Iterable) map2.keySet());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…veForumThreads.keys\n    }");
        Observable<Tuples2<Set<Long>, Set<Long>>> observableQ = ObservableExtensionsKt.leadingEdgeThrottle(observableJ, 1L, TimeUnit.SECONDS).r().Q(new Tuples2(Sets5.emptySet(), Sets5.emptySet()), new Func2<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Set<? extends Long>, Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>>() { // from class: com.discord.stores.StoreMessageAck.observeActiveThreadIdsWithPrevious.2
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> call(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2, Set<? extends Long> set) {
                return call2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2, (Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<Set<Long>, Set<Long>> call2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2, Set<Long> set) {
                return new Tuples2<>(tuples2.getSecond(), set);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableQ, "Observable.combineLatest…ond, threadIds)\n        }");
        return observableQ;
    }

    private final Observable<Companion.ThreadAckState> observeThreadAckState(long channelId) {
        Observable<Companion.ThreadAckState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getThreadsActiveJoined(), this.stream.getThreadsActive()}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    private final void postPendingAck(Observable<PendingAck> observable, int i) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i);
        Observable<PendingAck> observableY = observable.y(new Func1<PendingAck, Boolean>() { // from class: com.discord.stores.StoreMessageAck.postPendingAck.2
            @Override // j0.k.Func1
            public final Boolean call(PendingAck pendingAck) {
                return Boolean.valueOf(!Intrinsics3.areEqual(pendingAck, PendingAck.INSTANCE.getEMPTY()));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "filter { it != PendingAck.EMPTY }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observableY), (Class<?>) observable.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(anonymousClass1));
    }

    public static /* synthetic */ void postPendingAck$default(StoreMessageAck storeMessageAck, Observable observable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        storeMessageAck.postPendingAck(observable, i);
    }

    @Store3
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

    @Store3
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

    @Store3
    private final void updateThreadAcks(Set<Long> oldThreadIds, Set<Long> newThreadIds) {
        Channel channel;
        UtcDateTime joinTimestamp;
        if (this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            Iterator it = _Sets.minus((Set) oldThreadIds, (Iterable) newThreadIds).iterator();
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
        Iterator it2 = _Sets.minus((Set) newThreadIds, (Iterable) oldThreadIds).iterator();
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
                        this.acks.put(Long.valueOf(jLongValue2), new Ack((ThreadUtils.getThreadAckMessageTimestamp$default(ThreadUtils.INSTANCE, channel2, (Long) outline.c(channel2, guildsJoinedAtInternal$app_productionGoogleRelease), (activeJoinedThread == null || (joinTimestamp = activeJoinedThread.getJoinTimestamp()) == null) ? null : Long.valueOf(joinTimestamp.getDateTimeMillis()), null, 4, null) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, false));
                        markChanged();
                    }
                }
            }
        }
    }

    public final void ack(long channelId, boolean isLockedAck, boolean clearLock) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, isLockedAck, clearLock));
    }

    public final Map<Long, Ack> getAll() {
        return this.acksSnapshot;
    }

    @Store3
    public final Map<Long, Ack> getAllInternal() {
        return this.acks;
    }

    public final Ack getForChannel(long channelId) {
        return getAll().get(Long.valueOf(channelId));
    }

    @Store3
    public final void handleChannelSelected() {
        for (Map.Entry<Long, Ack> entry : this.acks.entrySet()) {
            this.acks.put(Long.valueOf(entry.getKey().longValue()), Ack.copy$default(entry.getValue(), 0L, false, false, 3, null));
        }
        markChanged();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cc  */
    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        long dateTimeMillis;
        Object next;
        UtcDateTime joinedAt;
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.acks.clear();
        }
        Map<Long, Ack> map = this.acks;
        ModelPayload.VersionedReadStates readState2 = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries, "payload.readState.entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(entries, 10)), 16));
        for (ModelReadState modelReadState : entries) {
            Tuples2 tuples2 = Tuples.to(Long.valueOf(modelReadState.getChannelId()), new Ack(modelReadState, false, false));
            linkedHashMap.put(tuples2.getFirst(), tuples2.getSecond());
        }
        map.putAll(linkedHashMap);
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<GuildMember> listV = guild.v();
            if (listV != null) {
                Iterator<T> it = listV.iterator();
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
            List<Channel> listG = guild.g();
            if (listG != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listG) {
                    Channel channel = (Channel) obj;
                    Intrinsics3.checkNotNullParameter(channel, "$this$isTextyOrVoiceChannel");
                    if ((ChannelUtils.v(channel) || ChannelUtils.J(channel)) && !this.acks.containsKey(Long.valueOf(channel.getId()))) {
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observeActiveThreadIdsWithPrevious()), (Class<?>) StoreMessageAck.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
        markChanged();
    }

    @Store3
    public final void handleGuildCreate() {
        pruneAcks();
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        updateAcks(readState.getChannelId(), new Ack(readState, false, false));
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author == null || author.getId() != this.stream.getUsers().getMe().getId()) {
            return;
        }
        updateAcks(message.getChannelId(), new Ack(message.getId(), false, false));
    }

    @Store3
    public final void handlePreLogout() {
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.threadSyncSubscription = null;
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Channel channelFindChannelById;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        boolean z2 = channel.getOwnerId() == this.stream.getUsers().getMe().getId();
        if (ChannelUtils.H(channel) && !ChannelUtils.j(channel) && z2 && (channelFindChannelById = this.stream.getChannels().findChannelById(channel.getParentId())) != null && ChannelUtils.q(channelFindChannelById)) {
            updateAcks(channelFindChannelById.getId(), new Ack(channel.getId(), false, false));
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Observable<R> observableY = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().r().Y(new Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends Long>>() { // from class: com.discord.stores.StoreMessageAck.init.1
            @Override // j0.k.Func1
            public final Observable<? extends Long> call(final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                return Observable.h(StoreMessageAck.this.stream.getMessages().getAllDetached().p(50L, TimeUnit.MILLISECONDS), StoreMessageAck.this.stream.getMessagesLoader().getMessagesLoadedState(resolvedSelectedChannel.getId()).G(new Func1<StoreMessagesLoader.ChannelLoadedState, Boolean>() { // from class: com.discord.stores.StoreMessageAck.init.1.1
                    @Override // j0.k.Func1
                    public final Boolean call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                        return Boolean.valueOf(channelLoadedState.isInitialMessagesLoaded() && !channelLoadedState.isLoadingMessages());
                    }
                }).r(), StoreMessageAck.this.stream.getChat().observeInteractionState().y(new Func1<StoreChat.InteractionState, Boolean>() { // from class: com.discord.stores.StoreMessageAck.init.1.2
                    @Override // j0.k.Func1
                    public final Boolean call(StoreChat.InteractionState interactionState) {
                        return Boolean.valueOf(interactionState.getChannelId() == resolvedSelectedChannel.getId());
                    }
                }), StoreMessageAck.this.stream.getMessageAck().observeForChannel(resolvedSelectedChannel.getId()), new Func4<Set<? extends Long>, Boolean, StoreChat.InteractionState, Ack, Long>() { // from class: com.discord.stores.StoreMessageAck.init.1.3
                    @Override // rx.functions.Func4
                    public /* bridge */ /* synthetic */ Long call(Set<? extends Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                        return call2((Set<Long>) set, bool, interactionState, ack);
                    }

                    /* JADX WARN: Code duplicated, block: B:19:0x003f  */
                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Long call2(Set<Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                        long channelId;
                        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
                        boolean z2 = maybeChannel != null && ChannelUtils.o(maybeChannel);
                        if (interactionState.isAtBottomIgnoringTouch()) {
                            Intrinsics3.checkNotNullExpressionValue(bool, "isLoadingSettled");
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
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get… 0L\n          }\n        }");
        Observable<Long> observableP = ObservableExtensionsKt.computationLatest(observableY).p(500L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "StoreStream\n        .get…0, TimeUnit.MILLISECONDS)");
        postPendingAck$default(this, getPendingAck(observableP, false, false), 0, 1, null);
    }

    public final void markUnread(long channelId, long messageId) {
        Observable observableJ = Observable.j(this.stream.getMessages().observeMessagesForChannel(channelId).y(new Func1<List<? extends Message>, Boolean>() { // from class: com.discord.stores.StoreMessageAck.markUnread.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list) {
                return call2((List<Message>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(List<Message> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                return Boolean.valueOf(!list.isEmpty());
            }
        }), observeThreadAckState(channelId), new Func2<List<? extends Message>, Companion.ThreadAckState, Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState>>() { // from class: com.discord.stores.StoreMessageAck.markUnread.2
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState> call(List<? extends Message> list, Companion.ThreadAckState threadAckState) {
                return call2((List<Message>) list, threadAckState);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<List<Message>, Companion.ThreadAckState> call2(List<Message> list, Companion.ThreadAckState threadAckState) {
                return new Tuples2<>(list, threadAckState);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…lMessages, threadState) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout(observableJ, 10L, false), (Class<?>) StoreMessageAck.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(messageId, channelId));
    }

    public final Observable<Map<Long, Ack>> observeAll() {
        Observable<Map<Long, Ack>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Ack> observeForChannel(long channelId) {
        Observable<Ack> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensions.snapshot$default(this.acks, 0, 0.0f, 3, null);
        this.acksSnapshot = mapSnapshot$default;
        Persister.set$default(this.acksPersister, mapSnapshot$default, false, 2, null);
    }
}
