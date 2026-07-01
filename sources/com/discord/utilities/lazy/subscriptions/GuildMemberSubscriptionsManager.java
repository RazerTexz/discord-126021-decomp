package com.discord.utilities.lazy.subscriptions;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n0;
import d0.z.d.m;
import j0.p.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;

/* JADX INFO: compiled from: GuildMemberSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberSubscriptionsManager {
    private final Scheduler delayScheduler;
    private Subscription delayedFlushSubscription;
    private final Function3<Long, Set<Long>, Boolean, Unit> onChange;
    private final HashMap<Long, Map<Long, Integer>> pendingUnsubscriptions;
    private final Function1<Function0<Unit>, Unit> requestFlushUnsubscriptions;
    private final HashMap<Long, Map<Long, Integer>> subscriptions;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberSubscriptionsManager(Function3<? super Long, ? super Set<Long>, ? super Boolean, Unit> function3, Function1<? super Function0<Unit>, Unit> function1, Scheduler scheduler) {
        m.checkNotNullParameter(function3, "onChange");
        m.checkNotNullParameter(function1, "requestFlushUnsubscriptions");
        m.checkNotNullParameter(scheduler, "delayScheduler");
        this.onChange = function3;
        this.requestFlushUnsubscriptions = function1;
        this.delayScheduler = scheduler;
        this.subscriptions = new HashMap<>();
        this.pendingUnsubscriptions = new HashMap<>();
    }

    public static final /* synthetic */ void access$flushUnsubscriptions(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        guildMemberSubscriptionsManager.flushUnsubscriptions();
    }

    public static final /* synthetic */ Subscription access$getDelayedFlushSubscription$p(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        return guildMemberSubscriptionsManager.delayedFlushSubscription;
    }

    public static final /* synthetic */ Function1 access$getRequestFlushUnsubscriptions$p(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        return guildMemberSubscriptionsManager.requestFlushUnsubscriptions;
    }

    public static final /* synthetic */ void access$setDelayedFlushSubscription$p(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager, Subscription subscription) {
        guildMemberSubscriptionsManager.delayedFlushSubscription = subscription;
    }

    private final void flushUnsubscriptions() {
        if (this.pendingUnsubscriptions.isEmpty()) {
            return;
        }
        for (Map$Entry<Long, Map<Long, Integer>> map$Entry : this.pendingUnsubscriptions.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            Map<Long, Integer> value = map$Entry.getValue();
            Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(jLongValue));
            if (map != null) {
                m.checkNotNullExpressionValue(map, "subscriptions[guildId] ?: continue");
                boolean z2 = false;
                for (Map$Entry<Long, Integer> map$Entry2 : value.entrySet()) {
                    long jLongValue2 = map$Entry2.getKey().longValue();
                    int iIntValue = map$Entry2.getValue().intValue();
                    Integer num = map.get(Long.valueOf(jLongValue2));
                    if (num != null) {
                        int iIntValue2 = num.intValue() - iIntValue;
                        if (iIntValue2 > 0) {
                            map.put(Long.valueOf(jLongValue2), Integer.valueOf(iIntValue2));
                        } else {
                            map.remove(Long.valueOf(jLongValue2));
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    if (map.isEmpty()) {
                        this.subscriptions.remove(Long.valueOf(jLongValue));
                    }
                    this.onChange.invoke(Long.valueOf(jLongValue), get(jLongValue), Boolean.TRUE);
                }
            }
        }
        this.delayedFlushSubscription = null;
        this.pendingUnsubscriptions.clear();
    }

    private final void triggerUnsubscribe() {
        if (this.delayedFlushSubscription == null) {
            Observable<Long> observableE0 = Observable.e0(20L, TimeUnit.SECONDS, this.delayScheduler);
            m.checkNotNullExpressionValue(observableE0, "Observable\n          .ti….SECONDS, delayScheduler)");
            ObservableExtensionsKt.appSubscribe$default(observableE0, GuildMemberSubscriptionsManager.class, (Context) null, new GuildMemberSubscriptionsManager$triggerUnsubscribe$1(this), (Function1) null, (Function0) null, (Function0) null, new GuildMemberSubscriptionsManager$triggerUnsubscribe$2(this), 58, (Object) null);
        }
    }

    public final Set<Long> get(long guildId) {
        Set<Long> setKeySet;
        Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(guildId));
        return (map == null || (setKeySet = map.keySet()) == null) ? n0.emptySet() : setKeySet;
    }

    public final void remove(long guildId) {
        this.subscriptions.remove(Long.valueOf(guildId));
        this.pendingUnsubscriptions.remove(Long.valueOf(guildId));
    }

    public final void reset() {
        this.subscriptions.clear();
        this.pendingUnsubscriptions.clear();
        Subscription subscription = this.delayedFlushSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.delayedFlushSubscription = null;
    }

    public final void retainAll(List<Long> guildIds) {
        m.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map$Entry<Long, Map<Long, Integer>>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
    }

    public final void subscribe(long guildId, long userId) {
        Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(guildId));
        if (map == null) {
            map = new HashMap<>();
        }
        Long lValueOf = Long.valueOf(userId);
        Integer num = map.get(Long.valueOf(userId));
        map.put(lValueOf, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.subscriptions.put(Long.valueOf(guildId), map);
        Integer num2 = map.get(Long.valueOf(userId));
        if (num2 != null && num2.intValue() == 1) {
            this.onChange.invoke(Long.valueOf(guildId), map.keySet(), Boolean.FALSE);
        }
    }

    public final void unsubscribe(long guildId, long userId) {
        Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(guildId));
        if ((map != null ? map.get(Long.valueOf(userId)) : null) == null) {
            return;
        }
        Map<Long, Integer> map2 = this.pendingUnsubscriptions.get(Long.valueOf(guildId));
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        Long lValueOf = Long.valueOf(userId);
        Integer num = map2.get(Long.valueOf(userId));
        map2.put(lValueOf, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.pendingUnsubscriptions.put(Long.valueOf(guildId), map2);
        Integer num2 = map2.get(Long.valueOf(userId));
        if (num2 != null && num2.intValue() == 1) {
            triggerUnsubscribe();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildMemberSubscriptionsManager(Function3 function3, Function1 function1, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            scheduler = a.a();
            m.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
        }
        this(function3, function1, scheduler);
    }
}
