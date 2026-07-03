package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.core.app.FrameMetricsAggregator;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p406w.C4871i;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

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
    private static final Persister<SettingsV2> settings = new Persister<>("NOTIFICATION_CLIENT_SETTINGS_V3", new SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    private static Function1<? super String, Unit> tokenCallback = NotificationClient$tokenCallback$1.INSTANCE;
    private static boolean isBackgrounded = true;

    /* JADX INFO: compiled from: NotificationClient.kt */
    public static final class FCMMessagingService extends FirebaseMessagingService {
        @Override // com.google.firebase.messaging.FirebaseMessagingService
        public void onMessageReceived(RemoteMessage remoteMessage) {
            C12238m.checkNotNullParameter(remoteMessage, "remoteMessage");
            super.onMessageReceived(remoteMessage);
            if (remoteMessage.f21461k == null) {
                Bundle bundle = remoteMessage.f21460j;
                ArrayMap arrayMap = new ArrayMap();
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                            arrayMap.put(str, str2);
                        }
                    }
                }
                remoteMessage.f21461k = arrayMap;
            }
            Map<String, String> map = remoteMessage.f21461k;
            C12238m.checkNotNullExpressionValue(map, "remoteMessage.data");
            AppLog.m8358i("Got notification: " + map);
            NotificationData notificationData = new NotificationData(map);
            SettingsV2 settings$app_productionGoogleRelease = NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease();
            Iterator<Long> it = notificationData.getAckChannelIds().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                NotificationClient notificationClient = NotificationClient.INSTANCE;
                notificationClient.clear(jLongValue, NotificationClient.access$getContext$p(notificationClient), true);
            }
            NotificationClient notificationClient2 = NotificationClient.INSTANCE;
            Context contextAccess$getContext$p = NotificationClient.access$getContext$p(notificationClient2);
            if (contextAccess$getContext$p == null) {
                Logger.e$default(AppLog.f14950g, "Not showing notification because context was null.", null, null, 6, null);
                return;
            }
            if (!notificationData.isValid() || !settings$app_productionGoogleRelease.getIsAuthed()) {
                if (C12238m.areEqual(notificationData.getType(), NotificationData.TYPE_MESSAGE_CREATE)) {
                    Logger.e$default(AppLog.f14950g, "Not showing invalid notification", null, C12136h0.mapOf(C12116o.m10073to("messageId", String.valueOf(notificationData.getMessageId())), C12116o.m10073to("channelId", String.valueOf(notificationData.getChannelId())), C12116o.m10073to("isAuthed", String.valueOf(settings$app_productionGoogleRelease.getIsAuthed())), C12116o.m10073to("type", notificationData.getType())), 2, null);
                    return;
                }
                return;
            }
            if (C12238m.areEqual(notificationData.getTrackingType(), NotificationClient.IGNORED_NOTIFICATION_TYPE)) {
                Pair[] pairArr = new Pair[5];
                String trackingType = notificationData.getTrackingType();
                if (trackingType == null) {
                    trackingType = notificationData.getType();
                }
                pairArr[0] = C12116o.m10073to("notif_type", trackingType);
                pairArr[1] = C12116o.m10073to("notif_user_id", Long.valueOf(notificationData.getUserId()));
                pairArr[2] = C12116o.m10073to("message_id", Long.valueOf(notificationData.getMessageId()));
                pairArr[3] = C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(notificationData.getGuildId()));
                pairArr[4] = C12116o.m10073to("notification_id", notificationData.getNotificationId());
                AnalyticsTracker.INSTANCE.appNotificationDropped(CollectionExtensionsKt.filterNonNullValues(C12136h0.mapOf(pairArr)));
                return;
            }
            if (notificationData.getChannelId() != -1) {
                NotificationCache.INSTANCE.setIgnoreNextClearForAck(notificationData.getChannelId(), false);
            }
            if (NotificationClient.access$isBackgrounded$p(notificationClient2) && settings$app_productionGoogleRelease.isEnabled()) {
                NotificationRenderer.INSTANCE.display(contextAccess$getContext$p, notificationData, settings$app_productionGoogleRelease);
            } else {
                if (NotificationClient.access$isBackgrounded$p(notificationClient2) || !settings$app_productionGoogleRelease.isEnabledInApp()) {
                    return;
                }
                NotificationRenderer.INSTANCE.displayInApp(contextAccess$getContext$p, notificationData);
            }
        }

        @Override // com.google.firebase.messaging.FirebaseMessagingService
        public void onNewToken(String token) {
            C12238m.checkNotNullParameter(token, "token");
            NotificationClient.INSTANCE.onNewToken(token);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationClient$init$1 */
    /* JADX INFO: compiled from: NotificationClient.kt */
    public static final class C67451 extends AbstractC12240o implements Function0<String> {
        public static final C67451 INSTANCE = new C67451();

        public C67451() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease().getToken();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationClient$init$2 */
    /* JADX INFO: compiled from: NotificationClient.kt */
    public static final class C67462 extends AbstractC12240o implements Function0<String> {
        public static final C67462 INSTANCE = new C67462();

        public C67462() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease().getLocale();
        }
    }

    private NotificationClient() {
    }

    public static final /* synthetic */ Context access$getContext$p(NotificationClient notificationClient) {
        return context;
    }

    public static final /* synthetic */ boolean access$isBackgrounded$p(NotificationClient notificationClient) {
        return isBackgrounded;
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
        return NotificationData.INSTANCE.buildTrackingData(intent);
    }

    public final void clear(long channelId, Context context2, boolean isAckRequest) {
        NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
        if (context2 == null) {
            context2 = context;
        }
        notificationRenderer.clear(context2, channelId, isAckRequest);
    }

    public final synchronized SettingsV2 getSettings$app_productionGoogleRelease() {
        return settings.get();
    }

    @TargetApi(26)
    public final void init(Application application) {
        FirebaseMessaging firebaseMessaging;
        C12238m.checkNotNullParameter(application, "application");
        context = application;
        if (isOsLevelNotificationEnabled()) {
            NotificationRenderer.INSTANCE.initNotificationChannels(application);
        }
        RestAPI.AppHeadersProvider.authTokenProvider = C67451.INSTANCE;
        RestAPI.AppHeadersProvider.localeProvider = C67462.INSTANCE;
        try {
            synchronized (FirebaseMessaging.class) {
                firebaseMessaging = FirebaseMessaging.getInstance(C4542c.m6327b());
            }
            C12238m.checkNotNullExpressionValue(firebaseMessaging, "FirebaseMessaging.getInstance()");
            C12238m.checkNotNullExpressionValue(firebaseMessaging.f21451d.m9183f().mo6013h(C4871i.f13026a).mo6007b(new InterfaceC4357c<String>() { // from class: com.discord.utilities.fcm.NotificationClient.init.3
                @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
                public final void onComplete(Task<String> task) {
                    C12238m.checkNotNullExpressionValue(task, "task");
                    if (task.mo6021p()) {
                        NotificationClient.INSTANCE.onNewToken(task.mo6017l());
                    } else {
                        AppLog.f14950g.mo8370w("Fetching FCM registration token failed", task.mo6016k());
                    }
                }
            }), "FirebaseMessaging.getIns…eption)\n        }\n      }");
        } catch (IllegalStateException e) {
            AppLog.f14950g.mo8370w("FCM service start error", e);
        }
    }

    public final synchronized boolean isAuthed() {
        return settings.get().getIsAuthed();
    }

    public final boolean isOsLevelNotificationEnabled() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final synchronized void onNewToken(String token2) {
        AppLog appLog = AppLog.f14950g;
        StringBuilder sb = new StringBuilder();
        sb.append("FCM token received. hash=");
        sb.append(token2 != null ? Integer.valueOf(token2.hashCode()) : null);
        Logger.d$default(appLog, sb.toString(), null, 2, null);
        token = token2;
        tokenCallback.invoke(token2);
    }

    public final synchronized void setRegistrationIdReceived(Function1<? super String, Unit> onDeviceRegistrationIdReceived) {
        C12238m.checkNotNullParameter(onDeviceRegistrationIdReceived, "onDeviceRegistrationIdReceived");
        tokenCallback = onDeviceRegistrationIdReceived;
        onDeviceRegistrationIdReceived.invoke(token);
    }

    public final synchronized void updateSettings$app_productionGoogleRelease(SettingsV2 settings2, boolean isBackgrounded2) {
        C12238m.checkNotNullParameter(settings2, "settings");
        settings.set(settings2, isBackgrounded2);
        isBackgrounded = isBackgrounded2;
    }

    /* JADX INFO: compiled from: NotificationClient.kt */
    public static final /* data */ class SettingsV2 {
        private final boolean isAuthed;
        private final boolean isDisableBlink;
        private final boolean isDisableSound;
        private final boolean isDisableVibrate;
        private final boolean isEnabled;
        private final boolean isEnabledInApp;
        private final boolean isWake;
        private final String locale;
        private final Set<Long> sendBlockedChannels;
        private final String token;

        public SettingsV2() {
            this(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set<Long> set) {
            C12238m.checkNotNullParameter(str2, "locale");
            C12238m.checkNotNullParameter(set, "sendBlockedChannels");
            this.isEnabled = z2;
            this.isEnabledInApp = z3;
            this.isWake = z4;
            this.isDisableBlink = z5;
            this.isDisableSound = z6;
            this.isDisableVibrate = z7;
            this.token = str;
            this.locale = str2;
            this.sendBlockedChannels = set;
            this.isAuthed = str != null;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsEnabledInApp() {
            return this.isEnabledInApp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsWake() {
            return this.isWake;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsDisableBlink() {
            return this.isDisableBlink;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsDisableSound() {
            return this.isDisableSound;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsDisableVibrate() {
            return this.isDisableVibrate;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        public final Set<Long> component9() {
            return this.sendBlockedChannels;
        }

        public final SettingsV2 copy(boolean isEnabled, boolean isEnabledInApp, boolean isWake, boolean isDisableBlink, boolean isDisableSound, boolean isDisableVibrate, String token, String locale, Set<Long> sendBlockedChannels) {
            C12238m.checkNotNullParameter(locale, "locale");
            C12238m.checkNotNullParameter(sendBlockedChannels, "sendBlockedChannels");
            return new SettingsV2(isEnabled, isEnabledInApp, isWake, isDisableBlink, isDisableSound, isDisableVibrate, token, locale, sendBlockedChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingsV2)) {
                return false;
            }
            SettingsV2 settingsV2 = (SettingsV2) other;
            return this.isEnabled == settingsV2.isEnabled && this.isEnabledInApp == settingsV2.isEnabledInApp && this.isWake == settingsV2.isWake && this.isDisableBlink == settingsV2.isDisableBlink && this.isDisableSound == settingsV2.isDisableSound && this.isDisableVibrate == settingsV2.isDisableVibrate && C12238m.areEqual(this.token, settingsV2.token) && C12238m.areEqual(this.locale, settingsV2.locale) && C12238m.areEqual(this.sendBlockedChannels, settingsV2.sendBlockedChannels);
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Set<Long> getSendBlockedChannels() {
            return this.sendBlockedChannels;
        }

        public final String getToken() {
            return this.token;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        public int hashCode() {
            boolean z2 = this.isEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isEnabledInApp;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.isWake;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.isDisableBlink;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.isDisableSound;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (i4 + r5) * 31;
            boolean z7 = this.isDisableVibrate;
            int i6 = (i5 + (z7 ? 1 : z7)) * 31;
            String str = this.token;
            int iHashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.locale;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Set<Long> set = this.sendBlockedChannels;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        /* JADX INFO: renamed from: isAuthed, reason: from getter */
        public final boolean getIsAuthed() {
            return this.isAuthed;
        }

        public final boolean isDisableBlink() {
            return this.isDisableBlink;
        }

        public final boolean isDisableSound() {
            return this.isDisableSound;
        }

        public final boolean isDisableVibrate() {
            return this.isDisableVibrate;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final boolean isEnabledInApp() {
            return this.isEnabledInApp;
        }

        public final boolean isWake() {
            return this.isWake;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SettingsV2(isEnabled=");
            sbM833U.append(this.isEnabled);
            sbM833U.append(", isEnabledInApp=");
            sbM833U.append(this.isEnabledInApp);
            sbM833U.append(", isWake=");
            sbM833U.append(this.isWake);
            sbM833U.append(", isDisableBlink=");
            sbM833U.append(this.isDisableBlink);
            sbM833U.append(", isDisableSound=");
            sbM833U.append(this.isDisableSound);
            sbM833U.append(", isDisableVibrate=");
            sbM833U.append(this.isDisableVibrate);
            sbM833U.append(", token=");
            sbM833U.append(this.token);
            sbM833U.append(", locale=");
            sbM833U.append(this.locale);
            sbM833U.append(", sendBlockedChannels=");
            return C1643a.m826N(sbM833U, this.sendBlockedChannels, ")");
        }

        public /* synthetic */ SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z2, (i & 2) == 0 ? z3 : true, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? null : str, (i & 128) != 0 ? "" : str2, (i & 256) != 0 ? new HashSet(0) : set);
        }
    }
}
