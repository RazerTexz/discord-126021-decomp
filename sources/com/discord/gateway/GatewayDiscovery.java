package com.discord.gateway;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.discord.utilities.networking.Backoff;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;

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
                Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
            }
            return sharedPreferences2.getString(GATEWAY_URL_CACHE_KEY, null);
        }

        public final void init(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Intrinsics3.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
            sharedPreferences = defaultSharedPreferences;
        }

        public final void setGatewayUrl(String gatewayUrl) {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
            }
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putString(GATEWAY_URL_CACHE_KEY, gatewayUrl);
            editorEdit.apply();
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ Function1 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$onFailure = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "throwable");
            GatewayDiscovery.this.gatewayUrl = null;
            Cache.INSTANCE.setGatewayUrl(null);
            this.$onFailure.invoke(th);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$2, reason: invalid class name */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleFailure$1;
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnonymousClass1 anonymousClass1, Function1 function1) {
            super(1);
            this.$handleFailure$1 = anonymousClass1;
            this.$onSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$3, reason: invalid class name */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public final /* synthetic */ AnonymousClass2 $handleSuccess$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass2 anonymousClass2) {
            super(1, null, "handleSuccess", "invoke(Ljava/lang/String;)V", 0);
            this.$handleSuccess$2 = anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            this.$handleSuccess$2.invoke2(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$4, reason: invalid class name */
    /* JADX INFO: compiled from: GatewayDiscovery.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleFailure$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnonymousClass1 anonymousClass1) {
            super(1, null, "handleFailure", "invoke(Ljava/lang/Throwable;)V", 0);
            this.$handleFailure$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "p1");
            this.$handleFailure$1.invoke2(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewayDiscovery(Context context, Scheduler scheduler, Backoff backoff, Function1<? super String, Unit> function1, Observable<String> observable) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics3.checkNotNullParameter(backoff, "backoff");
        Intrinsics3.checkNotNullParameter(function1, "log");
        Intrinsics3.checkNotNullParameter(observable, "gatewayUrlProvider");
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
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        if (!this.backoff.hasReachedFailureThreshold() && (str = this.gatewayUrl) != null) {
            this.log.invoke("Using sticky gateway url: " + str);
            onSuccess.invoke(str);
            return;
        }
        this.log.invoke("Discovering gateway url.");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(onFailure);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(anonymousClass1, onSuccess);
        Subscription subscription = this.gatewayUrlDiscoverySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<String> observableJ = this.gatewayUrlProvider.J(this.scheduler);
        final AnonymousClass3 anonymousClass3 = new AnonymousClass3(anonymousClass2);
        Action1<? super String> action1 = new Action1() { // from class: com.discord.gateway.GatewayDiscovery$sam$rx_functions_Action1$0
            @Override // rx.functions.Action1
            public final /* synthetic */ void call(Object obj) {
                Intrinsics3.checkNotNullExpressionValue(anonymousClass3.invoke(obj), "invoke(...)");
            }
        };
        final AnonymousClass4 anonymousClass4 = new AnonymousClass4(anonymousClass1);
        this.gatewayUrlDiscoverySubscription = observableJ.W(action1, new Action1() { // from class: com.discord.gateway.GatewayDiscovery$sam$rx_functions_Action1$0
            @Override // rx.functions.Action1
            public final /* synthetic */ void call(Object obj) {
                Intrinsics3.checkNotNullExpressionValue(anonymousClass4.invoke(obj), "invoke(...)");
            }
        });
    }
}
