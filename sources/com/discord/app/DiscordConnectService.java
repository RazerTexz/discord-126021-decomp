package com.discord.app;

import android.app.Application;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import b.a.d.j0;
import b.a.d.l;
import b.a.d.l0;
import b.d.b.a.a;
import com.discord.R$attr;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.RouteHandlers$AnalyticsMetadata;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.DiscordOverlayService;
import d0.g0.s;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Observable;

/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordConnectService extends Service {
    public static final DiscordConnectService$a j = new DiscordConnectService$a(null);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new IllegalStateException("All my bases are belong to me!");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onCreate", null, 4, null);
        l.c.a(this);
        Notification notificationBuild = new NotificationCompat$Builder(this, NotificationClient.NOTIF_CHANNEL_SOCIAL).setAutoCancel(true).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(2131231973).setColor(ColorCompat.getThemedColor(this, R$attr.color_brand_500)).setContentTitle(getString(2131887853)).setContentText(getString(2131887860)).build();
        m.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…dpoint))\n        .build()");
        startForeground(100, notificationBuild);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Application application = getApplication();
        m.checkNotNullExpressionValue(application, "application");
        storeStream$Companion.initialize(application);
        AnalyticsUtils analyticsUtils = AnalyticsUtils.INSTANCE;
        Application application2 = getApplication();
        m.checkNotNullExpressionValue(application2, "application");
        analyticsUtils.initAppOpen(application2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onDestroy", null, 4, null);
        l.c.b(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Observable observableX;
        Observable kVar;
        List<String> groupValues;
        String str;
        String strQ = a.q("onStartCommand: ", startId);
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, strQ, null, 4, null);
        Uri data = intent != null ? intent.getData() : null;
        if (data == null || !IntentUtils.INSTANCE.isDiscordAppUri(data)) {
            String simpleName2 = DiscordConnectService.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName2, "DiscordConnectService::class.java.simpleName");
            Logger.i$default(appLog, simpleName2, "Invalid request " + data, null, 4, null);
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        if (storeStream$Companion.getAuthentication().getAuthState() == null) {
            b.a.d.m.g(this, 2131893577, 0, null, 12);
            observableX = Observable.x(new IllegalStateException("UNAUTHED"));
            m.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…ateException(\"UNAUTHED\"))");
        } else {
            b.a.d.m0.a aVar = b.a.d.m0.a.G;
            Regex regex = b.a.d.m0.a.f61s;
            String path = data.getPath();
            if (path == null) {
                path = "";
            }
            MatchResult matchResultMatchEntire = regex.matchEntire(path);
            Long longOrNull = (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null || (str = (String) u.getOrNull(groupValues, 1)) == null) ? null : s.toLongOrNull(str);
            if (matchResultMatchEntire != null) {
                storeStream$Companion.getAnalytics().deepLinkReceived(intent != null ? intent : new Intent(), new RouteHandlers$AnalyticsMetadata("connect", null, longOrNull, 2, null));
            }
            if (longOrNull == null) {
                if (matchResultMatchEntire != null) {
                    DiscordOverlayService.Companion.launchForConnect(this);
                    kVar = new k(Unit.a);
                    m.checkNotNullExpressionValue(kVar, "Observable.just(Unit)");
                } else {
                    observableX = Observable.x(new IllegalArgumentException("Invalid Request: " + data));
                    m.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…\"Invalid Request: $uri\"))");
                }
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(kVar, 10000L, false, 2, null), DiscordConnectService.class, (Context) null, (Function1) null, new DiscordConnectService$d(this, startId), new DiscordConnectService$c(this, startId), (Function0) null, DiscordConnectService$b.j, 38, (Object) null);
                return 2;
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
                b.a.d.m.g(this, 2131893768, 0, null, 12);
                observableX = Observable.x(new IllegalStateException("Do not have microphone permissions, go to main app"));
                m.checkNotNullExpressionValue(observableX, "Observable.error(\n      …to main app\")\n          )");
            } else {
                long jLongValue = longOrNull.longValue();
                String simpleName3 = DiscordConnectService.class.getSimpleName();
                m.checkNotNullExpressionValue(simpleName3, "DiscordConnectService::class.java.simpleName");
                Logger.i$default(appLog, simpleName3, "Try joining voice channel", null, 4, null);
                storeStream$Companion.getVoiceChannelSelected().selectVoiceChannel(jLongValue);
                Observable observableY = StoreConnectionOpen.observeConnectionOpen$default(storeStream$Companion.getConnectionOpen(), false, 1, null).y(j0.j);
                m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…()\n        .filter { it }");
                observableX = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 10000L, false, 2, null).Y(l0.j);
                m.checkNotNullExpressionValue(observableX, "isConnectedObs.switchMap…nnected\n          }\n    }");
            }
        }
        kVar = observableX;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(kVar, 10000L, false, 2, null), DiscordConnectService.class, (Context) null, (Function1) null, new DiscordConnectService$d(this, startId), new DiscordConnectService$c(this, startId), (Function0) null, DiscordConnectService$b.j, 38, (Object) null);
        return 2;
    }
}
