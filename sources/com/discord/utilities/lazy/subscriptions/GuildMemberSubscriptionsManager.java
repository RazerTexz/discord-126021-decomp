package com.discord.utilities.lazy.subscriptions;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscription;

/* JADX INFO: compiled from: GuildMemberSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberSubscriptionsManager {
    private final Scheduler delayScheduler;
    private Subscription delayedFlushSubscription;
    private final Function3<Long, Set<Long>, Boolean, Unit> onChange;
    private final HashMap<Long, Map<Long, Integer>> pendingUnsubscriptions;
    private final Function1<Function0<Unit>, Unit> requestFlushUnsubscriptions;
    private final HashMap<Long, Map<Long, Integer>> subscriptions;

    /* JADX INFO: renamed from: com.discord.utilities.lazy.subscriptions.GuildMemberSubscriptionsManager$triggerUnsubscribe$1 */
    /* JADX INFO: compiled from: GuildMemberSubscriptionsManager.kt */
    public static final class C67911 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C67911() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            GuildMemberSubscriptionsManager.this.delayedFlushSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.lazy.subscriptions.GuildMemberSubscriptionsManager$triggerUnsubscribe$2 */
    /* JADX INFO: compiled from: GuildMemberSubscriptionsManager.kt */
    public static final class C67922 extends AbstractC12240o implements Function1<Long, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.lazy.subscriptions.GuildMemberSubscriptionsManager$triggerUnsubscribe$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: GuildMemberSubscriptionsManager.kt */
        public static final /* synthetic */ class AnonymousClass1 extends C12236k implements Function0<Unit> {
            public AnonymousClass1(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
                super(0, guildMemberSubscriptionsManager, GuildMemberSubscriptionsManager.class, "flushUnsubscriptions", "flushUnsubscriptions()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((GuildMemberSubscriptionsManager) this.receiver).flushUnsubscriptions();
            }
        }

        public C67922() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            GuildMemberSubscriptionsManager.this.requestFlushUnsubscriptions.invoke(new AnonymousClass1(GuildMemberSubscriptionsManager.this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberSubscriptionsManager(Function3<? super Long, ? super Set<Long>, ? super Boolean, Unit> function3, Function1<? super Function0<Unit>, Unit> function1, Scheduler scheduler) {
        C12238m.checkNotNullParameter(function3, "onChange");
        C12238m.checkNotNullParameter(function1, "requestFlushUnsubscriptions");
        C12238m.checkNotNullParameter(scheduler, "delayScheduler");
        this.onChange = function3;
        this.requestFlushUnsubscriptions = function1;
        this.delayScheduler = scheduler;
        this.subscriptions = new HashMap<>();
        this.pendingUnsubscriptions = new HashMap<>();
    }

    private final void flushUnsubscriptions() {
        if (this.pendingUnsubscriptions.isEmpty()) {
            return;
        }
        for (Map.Entry<Long, Map<Long, Integer>> entry : this.pendingUnsubscriptions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Map<Long, Integer> value = entry.getValue();
            Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(jLongValue));
            if (map != null) {
                C12238m.checkNotNullExpressionValue(map, "subscriptions[guildId] ?: continue");
                boolean z2 = false;
                for (Map.Entry<Long, Integer> entry2 : value.entrySet()) {
                    long jLongValue2 = entry2.getKey().longValue();
                    int iIntValue = entry2.getValue().intValue();
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
            Observable<Long> observableM11070e0 = Observable.m11070e0(20L, TimeUnit.SECONDS, this.delayScheduler);
            C12238m.checkNotNullExpressionValue(observableM11070e0, "Observable\n          .ti….SECONDS, delayScheduler)");
            ObservableExtensionsKt.appSubscribe(observableM11070e0, (Class<?>) GuildMemberSubscriptionsManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C67911()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67922());
        }
    }

    public final Set<Long> get(long guildId) {
        Set<Long> setKeySet;
        Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(guildId));
        return (map == null || (setKeySet = map.keySet()) == null) ? C12148n0.emptySet() : setKeySet;
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
        C12238m.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map.Entry<Long, Map<Long, Integer>>> it = this.subscriptions.entrySet().iterator();
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
            scheduler = C12781a.m10873a();
            C12238m.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
        }
        this(function3, function1, scheduler);
    }
}
