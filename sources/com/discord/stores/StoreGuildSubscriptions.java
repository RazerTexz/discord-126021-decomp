package com.discord.stores;

import androidx.annotation.VisibleForTesting;
import com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.Progressions2;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final StoreStream storeStream;
    private final GuildSubscriptionsManager subscriptionsManager;

    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    @VisibleForTesting
    public static final class RangeComputer {
        private static final int DEFAULT_CHUNK_SIZE = 100;
        public static final RangeComputer INSTANCE = new RangeComputer();

        private RangeComputer() {
        }

        public static /* synthetic */ List computeRanges$default(RangeComputer rangeComputer, Ranges2 ranges2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return rangeComputer.computeRanges(ranges2, i);
        }

        public final List<Ranges2> computeRanges(Ranges2 range, int chunkSize) {
            Intrinsics3.checkNotNullParameter(range, "range");
            ArrayList arrayList = new ArrayList(3);
            int iInvoke = StoreGuildSubscriptions2.INSTANCE.invoke(range.getFirst(), chunkSize);
            if (iInvoke > 0) {
                arrayList.add(_Ranges.until(0, chunkSize));
            }
            Progressions2 progressions2Step = _Ranges.step(_Ranges.until(iInvoke, range.getLast()), chunkSize);
            int first = progressions2Step.getFirst();
            int last = progressions2Step.getLast();
            int step = progressions2Step.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    arrayList.add(_Ranges.until(first, first + chunkSize));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeChannelRange$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Ranges2 $range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ranges2 ranges2, long j, long j2) {
            super(0);
            this.$range = ranges2;
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.subscriptionsManager.subscribeChannel(this.$guildId, this.$channelId, RangeComputer.computeRanges$default(RangeComputer.INSTANCE, this.$range, 0, 2, null));
            StoreGuildSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.subscriptionsManager.subscribeThread(this.$guildId, this.$channelId);
            StoreGuildSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.handleSubscribeMember(this.$guildId, this.$userId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$unsubscribeUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.handleUnsubscribeMember(this.$guildId, this.$userId);
        }
    }

    public StoreGuildSubscriptions(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.subscriptionsManager = new GuildSubscriptionsManager(new StoreGuildSubscriptions3(this));
    }

    @Store3
    public final void handleConnectionReady(boolean isConnectionReady) {
        if (!isConnectionReady) {
            this.subscriptionsManager.retainAll(Collections2.listOf((Object[]) new Long[]{Long.valueOf(this.storeStream.getGuildSelected().getSelectedGuildId()), Long.valueOf(this.storeStream.getRtcConnection().getConnectedGuildId())}));
            markChanged();
            return;
        }
        long selectedGuildId = this.storeStream.getGuildSelected().getSelectedGuildId();
        if (selectedGuildId > 0) {
            handleGuildSelect(selectedGuildId);
        }
        this.subscriptionsManager.queueExistingSubscriptions();
        markChanged();
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        this.subscriptionsManager.remove(guildId);
        markChanged();
    }

    @Store3
    public final void handleGuildSelect(long guildId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeTyping(guildId);
        this.subscriptionsManager.subscribeActivities(guildId);
        this.subscriptionsManager.subscribeThreads(guildId);
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        this.subscriptionsManager.reset();
        markChanged();
    }

    @Store3
    public final void handleSubscribeMember(long guildId, long userId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeMember(guildId, userId);
        markChanged();
    }

    @Store3
    public final void handleUnsubscribeMember(long guildId, long userId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.unsubscribeMember(guildId, userId);
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.subscriptionsManager.flush();
    }

    public final void subscribeChannelRange(long guildId, long channelId, Ranges2 range) {
        Intrinsics3.checkNotNullParameter(range, "range");
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(range, guildId, channelId));
    }

    public final void subscribeThread(long guildId, long channelId) {
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId));
    }

    public final void subscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, userId));
    }

    public final void unsubscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, userId));
    }
}
