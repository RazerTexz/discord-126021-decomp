package com.discord.gateway;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.discord.utilities.networking.Backoff;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewayDiscovery {
    private final Backoff backoff;
    private String gatewayUrl;
    private Subscription gatewayUrlDiscoverySubscription;
    private final Observable<String> gatewayUrlProvider;
    private final Function1<String, Unit> log;
    private final Scheduler scheduler;

    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final class Cache {
        private static final String GATEWAY_URL_CACHE_KEY = "GATEWAY_URL_CACHE_KEY";
        public static final Cache INSTANCE = new Cache();
        private static SharedPreferences sharedPreferences;

        private Cache() {
        }

        public final String getGatewayUrl() {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                C12238m.throwUninitializedPropertyAccessException("sharedPreferences");
            }
            return sharedPreferences2.getString(GATEWAY_URL_CACHE_KEY, null);
        }

        public final void init(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            C12238m.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
            sharedPreferences = defaultSharedPreferences;
        }

        public final void setGatewayUrl(String gatewayUrl) {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                C12238m.throwUninitializedPropertyAccessException("sharedPreferences");
            }
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            C12238m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putString(GATEWAY_URL_CACHE_KEY, gatewayUrl);
            editorEdit.apply();
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$1 */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final class C54821 extends AbstractC12240o implements Function1<Throwable, Unit> {
        public final /* synthetic */ Function1 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C54821(Function1 function1) {
            super(1);
            this.$onFailure = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            C12238m.checkNotNullParameter(th, "throwable");
            GatewayDiscovery.this.gatewayUrl = null;
            Cache.INSTANCE.setGatewayUrl(null);
            this.$onFailure.invoke(th);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$2 */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final class C54832 extends AbstractC12240o implements Function1<String, Unit> {
        public final /* synthetic */ C54821 $handleFailure$1;
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C54832(C54821 c54821, Function1 function1) {
            super(1);
            this.$handleFailure$1 = c54821;
            this.$onSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            if (str == null) {
                this.$handleFailure$1.invoke2(new Throwable("Malformed gateway url."));
                return;
            }
            GatewayDiscovery.this.gatewayUrl = str;
            Cache.INSTANCE.setGatewayUrl(str);
            GatewayDiscovery.this.log.invoke("Discovered gateway url: " + str);
            this.$onSuccess.invoke(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$3 */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final /* synthetic */ class C54843 extends C12236k implements Function1<String, Unit> {
        public final /* synthetic */ C54832 $handleSuccess$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C54843(C54832 c54832) {
            super(1, null, "handleSuccess", "invoke(Ljava/lang/String;)V", 0);
            this.$handleSuccess$2 = c54832;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            this.$handleSuccess$2.invoke2(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$4 */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final /* synthetic */ class C54854 extends C12236k implements Function1<Throwable, Unit> {
        public final /* synthetic */ C54821 $handleFailure$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C54854(C54821 c54821) {
            super(1, null, "handleFailure", "invoke(Ljava/lang/Throwable;)V", 0);
            this.$handleFailure$1 = c54821;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            C12238m.checkNotNullParameter(th, "p1");
            this.$handleFailure$1.invoke2(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewayDiscovery(Context context, Scheduler scheduler, Backoff backoff, Function1<? super String, Unit> function1, Observable<String> observable) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(scheduler, "scheduler");
        C12238m.checkNotNullParameter(backoff, "backoff");
        C12238m.checkNotNullParameter(function1, "log");
        C12238m.checkNotNullParameter(observable, "gatewayUrlProvider");
        this.scheduler = scheduler;
        this.backoff = backoff;
        this.log = function1;
        this.gatewayUrlProvider = observable;
        Cache cache = Cache.INSTANCE;
        cache.init(context);
        this.gatewayUrl = cache.getGatewayUrl();
    }

    public final void discoverGatewayUrl(Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onFailure) {
        String str;
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        C12238m.checkNotNullParameter(onFailure, "onFailure");
        if (!this.backoff.hasReachedFailureThreshold() && (str = this.gatewayUrl) != null) {
            this.log.invoke("Using sticky gateway url: " + str);
            onSuccess.invoke(str);
            return;
        }
        this.log.invoke("Discovering gateway url.");
        C54821 c54821 = new C54821(onFailure);
        C54832 c54832 = new C54832(c54821, onSuccess);
        Subscription subscription = this.gatewayUrlDiscoverySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<String> observableM11084J = this.gatewayUrlProvider.m11084J(this.scheduler);
        final C54843 c54843 = new C54843(c54832);
        Action1<? super String> action1 = new Action1() { // from class: com.discord.gateway.GatewayDiscovery$sam$rx_functions_Action1$0
            @Override // p658rx.functions.Action1
            public final /* synthetic */ void call(Object obj) {
                C12238m.checkNotNullExpressionValue(c54843.invoke(obj), "invoke(...)");
            }
        };
        final C54854 c54854 = new C54854(c54821);
        this.gatewayUrlDiscoverySubscription = observableM11084J.m11097W(action1, new Action1() { // from class: com.discord.gateway.GatewayDiscovery$sam$rx_functions_Action1$0
            @Override // p658rx.functions.Action1
            public final /* synthetic */ void call(Object obj) {
                C12238m.checkNotNullExpressionValue(c54854.invoke(obj), "invoke(...)");
            }
        });
    }
}
