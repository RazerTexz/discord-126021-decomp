package com.discord.gateway;

import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.networking.Backoff$Scheduler;
import d0.z.d.m;
import j0.p.a;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$Timer implements Backoff$Scheduler {
    private final Scheduler scheduler;
    private Subscription subscription;

    public GatewaySocket$Timer(Scheduler scheduler) {
        m.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(GatewaySocket$Timer gatewaySocket$Timer) {
        return gatewaySocket$Timer.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(GatewaySocket$Timer gatewaySocket$Timer, Subscription subscription) {
        gatewaySocket$Timer.subscription = subscription;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void cancel$default(GatewaySocket$Timer gatewaySocket$Timer, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        gatewaySocket$Timer.cancel(function0);
    }

    @Override // com.discord.utilities.networking.Backoff$Scheduler
    public void cancel() {
        cancel(null);
    }

    public final boolean getPending() {
        return this.subscription != null;
    }

    public final void postInterval(Function0<Unit> callback, long delayMillis) {
        m.checkNotNullParameter(callback, "callback");
        cancel();
        this.subscription = Observable.F(delayMillis, delayMillis, TimeUnit.MILLISECONDS, a.a()).J(this.scheduler).W(new GatewaySocket$Timer$postInterval$1(callback), GatewaySocket$Timer$postInterval$2.INSTANCE);
    }

    @Override // com.discord.utilities.networking.Backoff$Scheduler
    public void schedule(Function0<Unit> action, long delayMs) {
        m.checkNotNullParameter(action, "action");
        cancel();
        this.subscription = Observable.d0(delayMs, TimeUnit.MILLISECONDS).J(this.scheduler).W(new GatewaySocket$Timer$schedule$1(this, action), GatewaySocket$Timer$schedule$2.INSTANCE);
    }

    public final void cancel(Function0<Unit> callback) {
        Subscription subscription = this.subscription;
        if (subscription != null) {
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.subscription = null;
            if (callback != null) {
                callback.invoke();
            }
        }
    }
}
