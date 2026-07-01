package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGuildRoleMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts extends StoreV2 {
    private static final int CACHE_TIME_MS = 120000;
    public static final StoreGuildRoleMemberCounts$Companion Companion = new StoreGuildRoleMemberCounts$Companion(null);
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Map<Long, ? extends Map<Long, Integer>> guildMemberCountsSnapshot;
    private final HashMap<Long, Long> guildRoleMemberCountFetchTimes;
    private final HashMap<Long, Map<Long, Integer>> guildRoleMemberCounts;
    private final RestAPI restApi;

    public /* synthetic */ StoreGuildRoleMemberCounts(Dispatcher dispatcher, Clock clock, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$fetchGuildRoleMemberCountsIfNecessary(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts, long j) {
        storeGuildRoleMemberCounts.fetchGuildRoleMemberCountsIfNecessary(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildRoleMemberCountFetchTimes$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.guildRoleMemberCountFetchTimes;
    }

    public static final /* synthetic */ HashMap access$getGuildRoleMemberCounts$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.guildRoleMemberCounts;
    }

    @StoreThread
    private final void fetchGuildRoleMemberCountsIfNecessary(long guildId) {
        Long l = this.guildRoleMemberCountFetchTimes.get(Long.valueOf(guildId));
        if (this.guildRoleMemberCounts.get(Long.valueOf(guildId)) == null || l == null || this.clock.currentTimeMillis() - l.longValue() >= CACHE_TIME_MS) {
            this.guildRoleMemberCountFetchTimes.put(Long.valueOf(guildId), Long.valueOf(this.clock.currentTimeMillis()));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getGuildRoleMemberCounts(guildId), false, 1, null), StoreGuildRoleMemberCounts.class, (Context) null, (Function1) null, new StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2(this, guildId), (Function0) null, (Function0) null, new StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1(this, guildId), 54, (Object) null);
        }
    }

    public final void fetchGuildRoleMemberCounts(long guildId) {
        this.dispatcher.schedule(new StoreGuildRoleMemberCounts$fetchGuildRoleMemberCounts$1(this, guildId));
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
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restApi = restAPI;
        this.guildRoleMemberCounts = new HashMap<>();
        this.guildMemberCountsSnapshot = h0.emptyMap();
        this.guildRoleMemberCountFetchTimes = new HashMap<>();
    }
}
