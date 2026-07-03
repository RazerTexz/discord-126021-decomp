package com.discord.stores;

import androidx.annotation.VisibleForTesting;
import com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

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

        public static /* synthetic */ List computeRanges$default(RangeComputer rangeComputer, IntRange intRange, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return rangeComputer.computeRanges(intRange, i);
        }

        public final List<IntRange> computeRanges(IntRange range, int chunkSize) {
            C12238m.checkNotNullParameter(range, "range");
            ArrayList arrayList = new ArrayList(3);
            int iInvoke = StoreGuildSubscriptions$RangeComputer$computeRanges$1.INSTANCE.invoke(range.getFirst(), chunkSize);
            if (iInvoke > 0) {
                arrayList.add(C11226f.until(0, chunkSize));
            }
            IntProgression intProgressionStep = C11226f.step(C11226f.until(iInvoke, range.getLast()), chunkSize);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    arrayList.add(C11226f.until(first, first + chunkSize));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeChannelRange$1 */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class C60791 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ IntRange $range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60791(IntRange intRange, long j, long j2) {
            super(0);
            this.$range = intRange;
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.subscriptionsManager.subscribeChannel(this.$guildId, this.$channelId, RangeComputer.computeRanges$default(RangeComputer.INSTANCE, this.$range, 0, 2, null));
            StoreGuildSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeThread$1 */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class C60801 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60801(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.subscriptionsManager.subscribeThread(this.$guildId, this.$channelId);
            StoreGuildSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeUser$1 */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class C60811 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60811(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.handleSubscribeMember(this.$guildId, this.$userId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$unsubscribeUser$1 */
    /* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
    public static final class C60821 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60821(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.handleUnsubscribeMember(this.$guildId, this.$userId);
        }
    }

    public StoreGuildSubscriptions(StoreStream storeStream, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(storeStream, "storeStream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.subscriptionsManager = new GuildSubscriptionsManager(new StoreGuildSubscriptions$subscriptionsManager$1(this));
    }

    @StoreThread
    public final void handleConnectionReady(boolean isConnectionReady) {
        if (!isConnectionReady) {
            this.subscriptionsManager.retainAll(C12147n.listOf((Object[]) new Long[]{Long.valueOf(this.storeStream.getGuildSelected().getSelectedGuildId()), Long.valueOf(this.storeStream.getRtcConnection().getConnectedGuildId())}));
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

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        this.subscriptionsManager.remove(guildId);
        markChanged();
    }

    @StoreThread
    public final void handleGuildSelect(long guildId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeTyping(guildId);
        this.subscriptionsManager.subscribeActivities(guildId);
        this.subscriptionsManager.subscribeThreads(guildId);
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.subscriptionsManager.reset();
        markChanged();
    }

    @StoreThread
    public final void handleSubscribeMember(long guildId, long userId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeMember(guildId, userId);
        markChanged();
    }

    @StoreThread
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

    public final void subscribeChannelRange(long guildId, long channelId, IntRange range) {
        C12238m.checkNotNullParameter(range, "range");
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new C60791(range, guildId, channelId));
    }

    public final void subscribeThread(long guildId, long channelId) {
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new C60801(guildId, channelId));
    }

    public final void subscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new C60811(guildId, userId));
    }

    public final void unsubscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new C60821(guildId, userId));
    }
}
