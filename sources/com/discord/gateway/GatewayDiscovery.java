package com.discord.gateway;

import android.content.Context;
import com.discord.utilities.networking.Backoff;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewayDiscovery {
    private final Backoff backoff;
    private String gatewayUrl;
    private Subscription gatewayUrlDiscoverySubscription;
    private final Observable<String> gatewayUrlProvider;
    private final Function1<String, Unit> log;
    private final Scheduler scheduler;

    /* JADX WARN: Multi-variable type inference failed */
    public GatewayDiscovery(Context context, Scheduler scheduler, Backoff backoff, Function1<? super String, Unit> function1, Observable<String> observable) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(scheduler, "scheduler");
        m.checkNotNullParameter(backoff, "backoff");
        m.checkNotNullParameter(function1, "log");
        m.checkNotNullParameter(observable, "gatewayUrlProvider");
        this.scheduler = scheduler;
        this.backoff = backoff;
        this.log = function1;
        this.gatewayUrlProvider = observable;
        GatewayDiscovery$Cache gatewayDiscovery$Cache = GatewayDiscovery$Cache.INSTANCE;
        gatewayDiscovery$Cache.init(context);
        this.gatewayUrl = gatewayDiscovery$Cache.getGatewayUrl();
    }

    public static final /* synthetic */ String access$getGatewayUrl$p(GatewayDiscovery gatewayDiscovery) {
        return gatewayDiscovery.gatewayUrl;
    }

    public static final /* synthetic */ Function1 access$getLog$p(GatewayDiscovery gatewayDiscovery) {
        return gatewayDiscovery.log;
    }

    public static final /* synthetic */ void access$setGatewayUrl$p(GatewayDiscovery gatewayDiscovery, String str) {
        gatewayDiscovery.gatewayUrl = str;
    }

    public final void discoverGatewayUrl(Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onFailure) {
        String str;
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFailure, "onFailure");
        if (!this.backoff.hasReachedFailureThreshold() && (str = this.gatewayUrl) != null) {
            this.log.invoke("Using sticky gateway url: " + str);
            onSuccess.invoke(str);
            return;
        }
        this.log.invoke("Discovering gateway url.");
        GatewayDiscovery$discoverGatewayUrl$1 gatewayDiscovery$discoverGatewayUrl$1 = new GatewayDiscovery$discoverGatewayUrl$1(this, onFailure);
        GatewayDiscovery$discoverGatewayUrl$2 gatewayDiscovery$discoverGatewayUrl$2 = new GatewayDiscovery$discoverGatewayUrl$2(this, gatewayDiscovery$discoverGatewayUrl$1, onSuccess);
        Subscription subscription = this.gatewayUrlDiscoverySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.gatewayUrlDiscoverySubscription = this.gatewayUrlProvider.J(this.scheduler).W(new GatewayDiscovery$sam$rx_functions_Action1$0(new GatewayDiscovery$discoverGatewayUrl$3(gatewayDiscovery$discoverGatewayUrl$2)), new GatewayDiscovery$sam$rx_functions_Action1$0(new GatewayDiscovery$discoverGatewayUrl$4(gatewayDiscovery$discoverGatewayUrl$1)));
    }
}
