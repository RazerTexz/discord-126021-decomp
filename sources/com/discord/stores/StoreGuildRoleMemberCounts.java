package com.discord.stores;

import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts extends StoreV2 {
    private static final int CACHE_TIME_MS = 120000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Map<Long, ? extends Map<Long, Integer>> guildMemberCountsSnapshot;
    private final HashMap<Long, Long> guildRoleMemberCountFetchTimes;
    private final HashMap<Long, Map<Long, Integer>> guildRoleMemberCounts;
    private final RestAPI restApi;

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCounts$1 */
    /* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
    public static final class C60401 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60401(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleMemberCounts.this.fetchGuildRoleMemberCountsIfNecessary(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1 */
    /* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
    public static final class C60411 extends AbstractC12240o implements Function1<Map<Long, ? extends Integer>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60411(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Integer> map) {
            invoke2((Map<Long, Integer>) map);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Integer> map) {
            if (map != null) {
                StoreGuildRoleMemberCounts.this.dispatcher.schedule(new C6042xf0df2a1b(map, this));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2 */
    /* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
    public static final class C60432 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleMemberCounts.this.guildRoleMemberCountFetchTimes.remove(Long.valueOf(C60432.this.$guildId));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60432(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGuildRoleMemberCounts.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    public /* synthetic */ StoreGuildRoleMemberCounts(Dispatcher dispatcher, Clock clock, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    @StoreThread
    private final void fetchGuildRoleMemberCountsIfNecessary(long guildId) {
        Long l = this.guildRoleMemberCountFetchTimes.get(Long.valueOf(guildId));
        if (this.guildRoleMemberCounts.get(Long.valueOf(guildId)) == null || l == null || this.clock.currentTimeMillis() - l.longValue() >= CACHE_TIME_MS) {
            this.guildRoleMemberCountFetchTimes.put(Long.valueOf(guildId), Long.valueOf(this.clock.currentTimeMillis()));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getGuildRoleMemberCounts(guildId), false, 1, null), (Class<?>) StoreGuildRoleMemberCounts.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C60432(guildId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60411(guildId));
        }
    }

    public final void fetchGuildRoleMemberCounts(long guildId) {
        this.dispatcher.schedule(new C60401(guildId));
    }

    public final Map<Long, Integer> getGuildRoleMemberCounts(long guildId) {
        return this.guildMemberCountsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        this.guildRoleMemberCounts.remove(Long.valueOf(guildId));
        this.guildRoleMemberCountFetchTimes.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.guildMemberCountsSnapshot = new HashMap(this.guildRoleMemberCounts);
    }

    public StoreGuildRoleMemberCounts(Dispatcher dispatcher, Clock clock, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restApi = restAPI;
        this.guildRoleMemberCounts = new HashMap<>();
        this.guildMemberCountsSnapshot = C12136h0.emptyMap();
        this.guildRoleMemberCountFetchTimes = new HashMap<>();
    }
}
