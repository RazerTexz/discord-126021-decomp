package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build$VERSION;
import androidx.core.app.FrameMetricsAggregator;
import b.i.c.c;
import b.i.c.w.i;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI$AppHeadersProvider;
import com.google.firebase.messaging.FirebaseMessaging;
import d0.z.d.m;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public final class NotificationClient {
    public static final String IGNORED_NOTIFICATION_TYPE = "top_messages_push";
    public static final String NOTIF_CHANNEL_CALLS = "Calls";
    public static final String NOTIF_CHANNEL_FORUM_POST_CREATE = "Forum Post Create";
    public static final String NOTIF_CHANNEL_GAME_DETECTION = "Game Detection";
    public static final String NOTIF_CHANNEL_MEDIA_CONNECTIONS = "Media Connections";
    public static final String NOTIF_CHANNEL_MESSAGES = "Messages";
    public static final String NOTIF_CHANNEL_MESSAGES_DIRECT = "DirectMessages";
    public static final String NOTIF_CHANNEL_SOCIAL = "Social";
    public static final String NOTIF_CHANNEL_STAGE_START = "Stage Live";
    public static final String NOTIF_GENERAL = "General";
    public static final String NOTIF_GENERAL_HIGH_PRIO = "GeneralHigh";
    public static final String NOTIF_GUILD_SCHEDULED_EVENT_START = "Guild Event Live";
    private static Context context;
    private static String token;
    public static final NotificationClient INSTANCE = new NotificationClient();
    private static final Persister<NotificationClient$SettingsV2> settings = new Persister<>("NOTIFICATION_CLIENT_SETTINGS_V3", new NotificationClient$SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    private static Function1<? super String, Unit> tokenCallback = NotificationClient$tokenCallback$1.INSTANCE;
    private static boolean isBackgrounded = true;

    private NotificationClient() {
    }

    public static final /* synthetic */ Context access$getContext$p(NotificationClient notificationClient) {
        return context;
    }

    public static final /* synthetic */ boolean access$isBackgrounded$p(NotificationClient notificationClient) {
        return isBackgrounded;
    }

    public static final /* synthetic */ void access$setBackgrounded$p(NotificationClient notificationClient, boolean z2) {
        isBackgrounded = z2;
    }

    public static final /* synthetic */ void access$setContext$p(NotificationClient notificationClient, Context context2) {
        context = context2;
    }

    public static /* synthetic */ void clear$default(NotificationClient notificationClient, long j, Context context2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            context2 = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        notificationClient.clear(j, context2, z2);
    }

    public final Map<String, Object> buildTrackingData(Intent intent) {
        return NotificationData.Companion.buildTrackingData(intent);
    }

    public final void clear(long channelId, Context context2, boolean isAckRequest) {
        NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
        if (context2 == null) {
            context2 = context;
        }
        notificationRenderer.clear(context2, channelId, isAckRequest);
    }

    public final synchronized NotificationClient$SettingsV2 getSettings$app_productionGoogleRelease() {
        return settings.get();
    }

    @TargetApi(26)
    public final void init(Application application) {
        FirebaseMessaging firebaseMessaging;
        m.checkNotNullParameter(application, "application");
        context = application;
        if (isOsLevelNotificationEnabled()) {
            NotificationRenderer.INSTANCE.initNotificationChannels(application);
        }
        RestAPI$AppHeadersProvider.authTokenProvider = NotificationClient$init$1.INSTANCE;
        RestAPI$AppHeadersProvider.localeProvider = NotificationClient$init$2.INSTANCE;
        try {
            synchronized (FirebaseMessaging.class) {
                firebaseMessaging = FirebaseMessaging.getInstance(c.b());
            }
            m.checkNotNullExpressionValue(firebaseMessaging, "FirebaseMessaging.getInstance()");
            m.checkNotNullExpressionValue(firebaseMessaging.d.f().h(i.a).b(NotificationClient$init$3.INSTANCE), "FirebaseMessaging.getIns…eption)\n        }\n      }");
        } catch (IllegalStateException e) {
            AppLog.g.w("FCM service start error", e);
        }
    }

    public final synchronized boolean isAuthed() {
        return settings.get().getIsAuthed();
    }

    public final boolean isOsLevelNotificationEnabled() {
        return Build$VERSION.SDK_INT >= 26;
    }

    public final synchronized void onNewToken(String token2) {
        AppLog appLog = AppLog.g;
        StringBuilder sb = new StringBuilder();
        sb.append("FCM token received. hash=");
        sb.append(token2 != null ? Integer.valueOf(token2.hashCode()) : null);
        Logger.d$default(appLog, sb.toString(), null, 2, null);
        token = token2;
        tokenCallback.invoke(token2);
    }

    public final synchronized void setRegistrationIdReceived(Function1<? super String, Unit> onDeviceRegistrationIdReceived) {
        m.checkNotNullParameter(onDeviceRegistrationIdReceived, "onDeviceRegistrationIdReceived");
        tokenCallback = onDeviceRegistrationIdReceived;
        onDeviceRegistrationIdReceived.invoke(token);
    }

    public final synchronized void updateSettings$app_productionGoogleRelease(NotificationClient$SettingsV2 settings2, boolean isBackgrounded2) {
        m.checkNotNullParameter(settings2, "settings");
        settings.set(settings2, isBackgrounded2);
        isBackgrounded = isBackgrounded2;
    }
}
