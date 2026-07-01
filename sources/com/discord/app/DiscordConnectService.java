package com.discord.app;

import android.app.Application;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import b.a.d.AppState2;
import b.a.d.AppToast;
import b.a.d.DiscordConnectService2;
import b.a.d.DiscordConnectService4;
import b.a.d.m0.RoutingPatterns;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.DiscordOverlayService;
import d0.g0.StringNumberConversions;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordConnectService extends Service {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.app.DiscordConnectService$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DiscordConnectService.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final void a(Companion companion, String str) {
            AppLog appLog = AppLog.g;
            String simpleName = DiscordConnectService.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
            Logger.i$default(appLog, simpleName, str, null, 4, null);
        }

        public final void b(Context context, long j) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = IntentUtils.RouteBuilders.INSTANCE.connectVoice(j).setPackage(context.getPackageName());
            Intrinsics3.checkNotNullExpressionValue(intent, "IntentUtils.RouteBuilder…kage(context.packageName)");
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    /* JADX INFO: compiled from: DiscordConnectService.kt */
    public static final class b extends Lambda implements Function1<Object, Unit> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: DiscordConnectService.kt */
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(0);
            this.$startId = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Companion companion = DiscordConnectService.INSTANCE;
            StringBuilder sbU = outline.U("Success[");
            sbU.append(this.$startId);
            sbU.append(']');
            Companion.a(companion, sbU.toString());
            DiscordConnectService discordConnectService = DiscordConnectService.this;
            int i = this.$startId;
            discordConnectService.stopForeground(true);
            discordConnectService.stopSelf(i);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: DiscordConnectService.kt */
    public static final class d extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(1);
            this.$startId = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            Error error2 = error;
            Intrinsics3.checkNotNullParameter(error2, "it");
            error2.setShouldLog(false);
            Companion companion = DiscordConnectService.INSTANCE;
            StringBuilder sbU = outline.U("Request timeout[");
            sbU.append(this.$startId);
            sbU.append("]: ");
            sbU.append(error2);
            Companion.a(companion, sbU.toString());
            DiscordConnectService discordConnectService = DiscordConnectService.this;
            int i = this.$startId;
            discordConnectService.stopForeground(true);
            discordConnectService.stopSelf(i);
            return Unit.a;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new IllegalStateException("All my bases are belong to me!");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onCreate", null, 4, null);
        AppState2.c.a(this);
        Notification notificationBuild = new NotificationCompat.Builder(this, NotificationClient.NOTIF_CHANNEL_SOCIAL).setAutoCancel(true).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(R.drawable.ic_notification_24dp).setColor(ColorCompat.getThemedColor(this, R.attr.color_brand_500)).setContentTitle(getString(R.string.connecting)).setContentText(getString(R.string.connection_status_awaiting_endpoint)).build();
        Intrinsics3.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…dpoint))\n        .build()");
        startForeground(100, notificationBuild);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Application application = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application, "application");
        companion.initialize(application);
        AnalyticsUtils analyticsUtils = AnalyticsUtils.INSTANCE;
        Application application2 = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application2, "application");
        analyticsUtils.initAppOpen(application2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onDestroy", null, 4, null);
        AppState2.c.b(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Observable observableX;
        Observable scalarSynchronousObservable;
        List<String> groupValues;
        String str;
        String strQ = outline.q("onStartCommand: ", startId);
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, strQ, null, 4, null);
        Uri data = intent != null ? intent.getData() : null;
        if (data == null || !IntentUtils.INSTANCE.isDiscordAppUri(data)) {
            String simpleName2 = DiscordConnectService.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName2, "DiscordConnectService::class.java.simpleName");
            Logger.i$default(appLog, simpleName2, "Invalid request " + data, null, 4, null);
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (companion.getAuthentication().getAuthState() == null) {
            AppToast.g(this, R.string.overlay_mobile_unauthed, 0, null, 12);
            observableX = Observable.x(new IllegalStateException("UNAUTHED"));
            Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…ateException(\"UNAUTHED\"))");
        } else {
            RoutingPatterns routingPatterns = RoutingPatterns.G;
            Regex regex = RoutingPatterns.f61s;
            String path = data.getPath();
            if (path == null) {
                path = "";
            }
            MatchResult matchResultMatchEntire = regex.matchEntire(path);
            Long longOrNull = (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null || (str = (String) _Collections.getOrNull(groupValues, 1)) == null) ? null : StringNumberConversions.toLongOrNull(str);
            if (matchResultMatchEntire != null) {
                companion.getAnalytics().deepLinkReceived(intent != null ? intent : new Intent(), new RouteHandlers.AnalyticsMetadata("connect", null, longOrNull, 2, null));
            }
            if (longOrNull == null) {
                if (matchResultMatchEntire != null) {
                    DiscordOverlayService.INSTANCE.launchForConnect(this);
                    scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.a);
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Unit)");
                } else {
                    observableX = Observable.x(new IllegalArgumentException("Invalid Request: " + data));
                    Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…\"Invalid Request: $uri\"))");
                }
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(scalarSynchronousObservable, 10000L, false, 2, null), (Class<?>) DiscordConnectService.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new d(startId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : new c(startId)), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), b.j);
                return 2;
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
                AppToast.g(this, R.string.permission_microphone_denied, 0, null, 12);
                observableX = Observable.x(new IllegalStateException("Do not have microphone permissions, go to main app"));
                Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(\n      …to main app\")\n          )");
            } else {
                long jLongValue = longOrNull.longValue();
                String simpleName3 = DiscordConnectService.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName3, "DiscordConnectService::class.java.simpleName");
                Logger.i$default(appLog, simpleName3, "Try joining voice channel", null, 4, null);
                companion.getVoiceChannelSelected().selectVoiceChannel(jLongValue);
                Observable observableY = StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null).y(DiscordConnectService2.j);
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…()\n        .filter { it }");
                observableX = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 10000L, false, 2, null).Y(DiscordConnectService4.j);
                Intrinsics3.checkNotNullExpressionValue(observableX, "isConnectedObs.switchMap…nnected\n          }\n    }");
            }
        }
        scalarSynchronousObservable = observableX;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(scalarSynchronousObservable, 10000L, false, 2, null), (Class<?>) DiscordConnectService.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new d(startId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : new c(startId)), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), b.j);
        return 2;
    }
}
