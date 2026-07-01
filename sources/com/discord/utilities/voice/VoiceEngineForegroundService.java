package com.discord.utilities.voice;

import android.app.Application;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import b.a.d.AppState2;
import b.d.b.a.outline;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.system.SystemServiceExtensions;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageChannelNotifications;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService extends IntentService implements AppComponent {
    private static final String LOG_TAG = "DiscordVoiceService";
    private static final int NOTIFICATION_ID = 101;
    private static final long WAKELOCK_TIMEOUT = 7200000;
    private final LocalBinder binder;
    private final CallSoundManager ringManager;
    private ScreenShareManager screenShareManager;
    private final Subject<Void, Void> unsubscribeSignal;
    private PowerManager.WakeLock wakeLockPartial;
    private PowerManager.WakeLock wakeLockProximity;
    private WifiManager.WifiLock wakeLockWifi;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function0<Unit> onDisconnect = VoiceEngineForegroundService2.INSTANCE;
    private static Function0<Unit> onToggleSelfDeafen = VoiceEngineForegroundService3.INSTANCE;
    private static Function0<Unit> onToggleSelfMute = VoiceEngineForegroundService4.INSTANCE;

    /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
        public interface ACTION {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = Companion.$$INSTANCE;
            public static final String DISCONNECT = "com.discord.utilities.voice.action.disconnect";
            public static final String MAIN_ACTION = "com.discord.utilities.voice.action.main";
            public static final String STAGE_INVITE_ACCEPT = "com.discord.utilities.voice.action.stage_invite_accept";
            public static final String STAGE_INVITE_DECLINE = "com.discord.utilities.voice.action.stage_invite_decline";
            public static final String START_FOREGROUND = "com.discord.utilities.voice.action.start_foreground";
            public static final String START_STREAM = "com.discord.utilities.voice.action.start_stream";
            public static final String STOP_SERVICE = "com.discord.utilities.voice.action.stop";
            public static final String STOP_STREAM = "com.discord.utilities.voice.action.stop_stream";
            public static final String TOGGLE_DEAFENED = "com.discord.utilities.voice.action.toggle_deafened";
            public static final String TOGGLE_MUTED = "com.discord.utilities.voice.action.toggle_muted";

            /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
            public static final class Companion {
                public static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String DISCONNECT = "com.discord.utilities.voice.action.disconnect";
                public static final String MAIN_ACTION = "com.discord.utilities.voice.action.main";
                public static final String STAGE_INVITE_ACCEPT = "com.discord.utilities.voice.action.stage_invite_accept";
                public static final String STAGE_INVITE_DECLINE = "com.discord.utilities.voice.action.stage_invite_decline";
                public static final String START_FOREGROUND = "com.discord.utilities.voice.action.start_foreground";
                public static final String START_STREAM = "com.discord.utilities.voice.action.start_stream";
                public static final String STOP_SERVICE = "com.discord.utilities.voice.action.stop";
                public static final String STOP_STREAM = "com.discord.utilities.voice.action.stop_stream";
                public static final String TOGGLE_DEAFENED = "com.discord.utilities.voice.action.toggle_deafened";
                public static final String TOGGLE_MUTED = "com.discord.utilities.voice.action.toggle_muted";

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
        public interface EXTRA {
            public static final String CHANNEL_ID = "com.discord.utilities.voice.extra.channel_id";

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = Companion.$$INSTANCE;
            public static final String GUILD_ID = "com.discord.utilities.voice.extra.guild_id";
            public static final String ITEM_CAN_SPEAK = "com.discord.utilities.voice.extra.item_can_speak";
            public static final String ITEM_DEAFENED = "com.discord.utilities.voice.extra.item_deafened";
            public static final String ITEM_MUTED = "com.discord.utilities.voice.extra.item_muted";
            public static final String ITEM_STREAMING = "com.discord.utilities.voice.extra.item_streaming";
            public static final String PROXIMITY_LOCK_ENABLED = "com.discord.utilities.voice.extra.proximity_lock_enabled";
            public static final String TITLE = "com.discord.utilities.voice.extra.title";
            public static final String TITLE_SUBTEXT = "com.discord.utilities.voice.extra.title_subtext";

            /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
            public static final class Companion {
                public static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String CHANNEL_ID = "com.discord.utilities.voice.extra.channel_id";
                public static final String GUILD_ID = "com.discord.utilities.voice.extra.guild_id";
                public static final String ITEM_CAN_SPEAK = "com.discord.utilities.voice.extra.item_can_speak";
                public static final String ITEM_DEAFENED = "com.discord.utilities.voice.extra.item_deafened";
                public static final String ITEM_MUTED = "com.discord.utilities.voice.extra.item_muted";
                public static final String ITEM_STREAMING = "com.discord.utilities.voice.extra.item_streaming";
                public static final String PROXIMITY_LOCK_ENABLED = "com.discord.utilities.voice.extra.proximity_lock_enabled";
                public static final String TITLE = "com.discord.utilities.voice.extra.title";
                public static final String TITLE_SUBTEXT = "com.discord.utilities.voice.extra.title_subtext";

                private Companion() {
                }
            }
        }

        private Companion() {
        }

        public final Function0<Unit> getOnDisconnect() {
            return VoiceEngineForegroundService.onDisconnect;
        }

        public final Function0<Unit> getOnToggleSelfDeafen() {
            return VoiceEngineForegroundService.onToggleSelfDeafen;
        }

        public final Function0<Unit> getOnToggleSelfMute() {
            return VoiceEngineForegroundService.onToggleSelfMute;
        }

        public final void setOnDisconnect(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            VoiceEngineForegroundService.onDisconnect = function0;
        }

        public final void setOnToggleSelfDeafen(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            VoiceEngineForegroundService.onToggleSelfDeafen = function0;
        }

        public final void setOnToggleSelfMute(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            VoiceEngineForegroundService.onToggleSelfMute = function0;
        }

        public final Intent stageInviteAckIntent(Context context, long channelId, boolean accept) {
            Intrinsics3.checkNotNullParameter(context, "context");
            boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
            if (accept && !z2) {
                Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
                return intent;
            }
            Intent intent2 = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
            intent2.setAction(accept ? "com.discord.utilities.voice.action.stage_invite_accept" : "com.discord.utilities.voice.action.stage_invite_decline");
            intent2.putExtra("com.discord.utilities.voice.extra.channel_id", channelId);
            return intent2;
        }

        public final PendingIntent stageInviteAckPendingIntent(Context context, long channelId, boolean accept) {
            Intrinsics3.checkNotNullParameter(context, "context");
            PendingIntent service = PendingIntent.getService(context, 0, stageInviteAckIntent(context, channelId, accept), PendingIntentExtensions.immutablePendingIntentFlag(1207959552));
            Intrinsics3.checkNotNullExpressionValue(service, "PendingIntent.getService…AG_UPDATE_CURRENT),\n    )");
            return service;
        }

        public final void startForegroundAndBind(Connection connection, CharSequence title, CharSequence subtitle, boolean selfMute, boolean selfDeafen, boolean selfStream, long channelId, Long guildId, boolean isProximityLockEnabled, boolean canSpeak) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            try {
                Logger.v$default(AppLog.g, VoiceEngineForegroundService.LOG_TAG, "Bind service connection.", null, 4, null);
                Context context = connection.getContext();
                Intent intent = new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class);
                intent.setAction("com.discord.utilities.voice.action.start_foreground");
                intent.putExtra("com.discord.utilities.voice.extra.title", title);
                intent.putExtra("com.discord.utilities.voice.extra.title_subtext", subtitle);
                intent.putExtra("com.discord.utilities.voice.extra.item_muted", selfMute);
                intent.putExtra("com.discord.utilities.voice.extra.item_deafened", selfDeafen);
                intent.putExtra("com.discord.utilities.voice.extra.item_streaming", selfStream);
                intent.putExtra("com.discord.utilities.voice.extra.item_can_speak", canSpeak);
                intent.putExtra("com.discord.utilities.voice.extra.proximity_lock_enabled", isProximityLockEnabled);
                intent.putExtra("com.discord.utilities.voice.extra.channel_id", channelId);
                intent.putExtra("com.discord.utilities.voice.extra.guild_id", guildId);
                context.startService(intent);
                connection.getContext().bindService(new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class), connection.getConnection(), 1);
            } catch (Exception e) {
                AppLog.g.v(VoiceEngineForegroundService.LOG_TAG, "Unable to bind service connection.", e);
            }
        }

        public final void startStream(Connection connection, Intent permissionIntent) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Intrinsics3.checkNotNullParameter(permissionIntent, "permissionIntent");
            Context context = connection.getContext();
            Intent intent = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
            intent.setAction("com.discord.utilities.voice.action.start_stream");
            intent.putExtra("android.intent.extra.INTENT", permissionIntent);
            context.startService(intent);
        }

        public final void stopForegroundAndUnbind(Connection connection) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            try {
                if (connection.getService() == null || connection.isUnbinding()) {
                    return;
                }
                Logger.v$default(AppLog.g, VoiceEngineForegroundService.LOG_TAG, "Unbind service connection.", null, 4, null);
                connection.setUnbinding(true);
                Context context = connection.getContext();
                Intent intent = new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class);
                intent.setAction("com.discord.utilities.voice.action.stop");
                context.startService(intent);
                connection.getContext().unbindService(connection.getConnection());
            } catch (Exception e) {
                AppLog.g.v(VoiceEngineForegroundService.LOG_TAG, "Unable to unbind service connection.", e);
            }
        }

        public final void stopStream(Connection connection) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Context context = connection.getContext();
            Intent intent = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
            intent.setAction("com.discord.utilities.voice.action.stop_stream");
            context.startService(intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
    public static final class Connection {
        private final ServiceConnection connection;
        private final Context context;
        private boolean isUnbinding;
        private VoiceEngineForegroundService service;

        public Connection(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            this.context = context;
            this.connection = new ServiceConnection() { // from class: com.discord.utilities.voice.VoiceEngineForegroundService$Connection$connection$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName className, IBinder binder) {
                    Intrinsics3.checkNotNullParameter(className, "className");
                    Intrinsics3.checkNotNullParameter(binder, "binder");
                    this.this$0.service = ((VoiceEngineForegroundService.LocalBinder) binder).getService();
                    this.this$0.setUnbinding(false);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName className) {
                    Intrinsics3.checkNotNullParameter(className, "className");
                    this.this$0.setUnbinding(false);
                    this.this$0.service = null;
                }
            };
        }

        public final ServiceConnection getConnection() {
            return this.connection;
        }

        public final Context getContext() {
            return this.context;
        }

        public final VoiceEngineForegroundService getService() {
            return this.service;
        }

        public final synchronized boolean isUnbinding() {
            return this.isUnbinding;
        }

        public final synchronized void setUnbinding(boolean z2) {
            this.isUnbinding = z2;
        }
    }

    /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
    public static final class LocalBinder extends Binder {
        private final VoiceEngineForegroundService service;

        public LocalBinder(VoiceEngineForegroundService voiceEngineForegroundService) {
            this.service = voiceEngineForegroundService;
        }

        public final VoiceEngineForegroundService getService() {
            return this.service;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineForegroundService$ackStageInvite$1, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StageChannelNotifications.INSTANCE.getINSTANCE().onInvitedToSpeakAckFailed(this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineForegroundService$ackStageInvite$2, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ boolean $accept;
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, long j) {
            super(1);
            this.$accept = z2;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            if (this.$accept) {
                AnalyticsTracker.INSTANCE.promotedToSpeaker(this.$channelId);
            }
            StageChannelNotifications.Notifications.InvitedToSpeak.INSTANCE.cancel(VoiceEngineForegroundService.this);
        }
    }

    public VoiceEngineForegroundService() {
        super("VoiceEngineForegroundService");
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.binder = new LocalBinder(this);
        this.ringManager = new CallSoundManager(this, null, null, 6, null);
    }

    private final void ackStageInvite(Intent intent, boolean accept) {
        long longExtra = intent.getLongExtra("com.discord.utilities.voice.extra.channel_id", 0L);
        Observable<Void> observableAckInvitationToSpeak = StageChannelAPI.INSTANCE.ackInvitationToSpeak(longExtra, accept);
        if (observableAckInvitationToSpeak == null) {
            Logger.w$default(AppLog.g, LOG_TAG, outline.t("Unable to ack stage invite for unknown channel ", longExtra), null, 4, null);
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(observableAckInvitationToSpeak, false, 1, null)), (Class<?>) VoiceEngineForegroundService.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(longExtra)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(accept, longExtra));
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        return this.binder;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.v$default(AppLog.g, LOG_TAG, "Service created.", null, 4, null);
        AppState2.c.a(this);
        Application application = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application, "application");
        WifiManager.WifiLock wifiLockCreateWifiLock$default = SystemServiceExtensions.createWifiLock$default(application, false, 0, null, 7, null);
        this.wakeLockWifi = wifiLockCreateWifiLock$default;
        if (wifiLockCreateWifiLock$default != null) {
            wifiLockCreateWifiLock$default.acquire();
        }
        Application application2 = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application2, "application");
        PowerManager.WakeLock wakeLockCreatePartialWakeLock$default = SystemServiceExtensions.createPartialWakeLock$default(application2, false, null, 3, null);
        this.wakeLockPartial = wakeLockCreatePartialWakeLock$default;
        if (wakeLockCreatePartialWakeLock$default != null) {
            wakeLockCreatePartialWakeLock$default.acquire(WAKELOCK_TIMEOUT);
        }
        Application application3 = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application3, "application");
        PowerManager.WakeLock wakeLockCreateProximityScreenWakeLock$default = SystemServiceExtensions.createProximityScreenWakeLock$default(application3, false, null, 3, null);
        this.wakeLockProximity = wakeLockCreateProximityScreenWakeLock$default;
        if (wakeLockCreateProximityScreenWakeLock$default != null) {
            wakeLockCreateProximityScreenWakeLock$default.acquire(WAKELOCK_TIMEOUT);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.v$default(AppLog.g, LOG_TAG, "Service destroyed.", null, 4, null);
        StageChannelNotifications.INSTANCE.getINSTANCE().onInviteToSpeakRescinded();
        AppState2.c.b(this);
        WifiManager.WifiLock wifiLock = this.wakeLockWifi;
        if (wifiLock != null) {
            wifiLock.release();
        }
        PowerManager.WakeLock wakeLock = this.wakeLockPartial;
        if (wakeLock != null) {
            wakeLock.release();
        }
        PowerManager.WakeLock wakeLock2 = this.wakeLockProximity;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e1  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        String action;
        ScreenShareManager screenShareManager;
        Intent intent2;
        ScreenShareManager screenShareManager2;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(action, "intent?.action ?: return");
        Logger.v$default(AppLog.g, LOG_TAG, outline.w("Received action: ", action), null, 4, null);
        switch (action.hashCode()) {
            case -2024885008:
                if (action.equals("com.discord.utilities.voice.action.toggle_deafened")) {
                    onToggleSelfDeafen.invoke();
                    return;
                }
                return;
            case -1497102229:
                if (action.equals("com.discord.utilities.voice.action.stop")) {
                    stopForeground(true);
                    stopSelf();
                    return;
                }
                return;
            case -1440499724:
                if (action.equals("com.discord.utilities.voice.action.stage_invite_accept")) {
                    ackStageInvite(intent, true);
                    return;
                }
                return;
            case -712636972:
                if (!action.equals("com.discord.utilities.voice.action.stop_stream") || (screenShareManager = this.screenShareManager) == null) {
                    return;
                }
                screenShareManager.stopStream();
                return;
            case -702962107:
                if (action.equals("com.discord.utilities.voice.action.disconnect")) {
                    onDisconnect.invoke();
                    return;
                }
                return;
            case 162053478:
                if (!action.equals("com.discord.utilities.voice.action.start_stream") || (intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT")) == null || (screenShareManager2 = this.screenShareManager) == null) {
                    return;
                }
                screenShareManager2.startStream(intent2);
                return;
            case 541488169:
                if (action.equals("com.discord.utilities.voice.action.start_foreground")) {
                    if (intent.getBooleanExtra("com.discord.utilities.voice.extra.proximity_lock_enabled", false)) {
                        PowerManager.WakeLock wakeLock = this.wakeLockProximity;
                        if (wakeLock != null) {
                            wakeLock.acquire(WAKELOCK_TIMEOUT);
                        }
                    } else {
                        PowerManager.WakeLock wakeLock2 = this.wakeLockProximity;
                        if (wakeLock2 != null) {
                            wakeLock2.release();
                        }
                    }
                    Long l = (Long) intent.getSerializableExtra("com.discord.utilities.voice.extra.guild_id");
                    Long l2 = (Long) intent.getSerializableExtra("com.discord.utilities.voice.extra.channel_id");
                    if (l2 != null) {
                        this.ringManager.subscribeToStoreState(l2.longValue());
                        ScreenShareManager screenShareManager3 = this.screenShareManager;
                        if (!(!Intrinsics3.areEqual(screenShareManager3 != null ? Long.valueOf(screenShareManager3.getChannelId()) : null, l2))) {
                            ScreenShareManager screenShareManager4 = this.screenShareManager;
                            if (!Intrinsics3.areEqual(screenShareManager4 != null ? screenShareManager4.getGuildId() : null, l)) {
                            }
                        }
                        ScreenShareManager screenShareManager5 = this.screenShareManager;
                        if (screenShareManager5 != null) {
                            screenShareManager5.release();
                        }
                        this.screenShareManager = new ScreenShareManager(this, l2.longValue(), l, null, null, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
                    }
                    startForeground(101, VoiceEngineNotificationBuilder.INSTANCE.buildNotification(this, "com.discord.utilities.voice.action.main", "com.discord.utilities.voice.action.disconnect", "com.discord.utilities.voice.action.stop_stream", intent.getBooleanExtra("com.discord.utilities.voice.extra.item_can_speak", true) ? "com.discord.utilities.voice.action.toggle_muted" : null, "com.discord.utilities.voice.action.toggle_deafened", VoiceEngineForegroundService.class, NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS, l2 != 0 ? l2.longValue() : 0L, intent.getCharSequenceExtra("com.discord.utilities.voice.extra.title"), intent.getCharSequenceExtra("com.discord.utilities.voice.extra.title_subtext"), AppActivity.Main.class, intent.getBooleanExtra("com.discord.utilities.voice.extra.item_streaming", false), intent.getBooleanExtra("com.discord.utilities.voice.extra.item_muted", false), intent.getBooleanExtra("com.discord.utilities.voice.extra.item_deafened", false)));
                    return;
                }
                break;
            case 1014152586:
                if (action.equals("com.discord.utilities.voice.action.stage_invite_decline")) {
                    ackStageInvite(intent, false);
                }
                break;
            case 1602537513:
                if (action.equals("com.discord.utilities.voice.action.toggle_muted")) {
                    onToggleSelfMute.invoke();
                }
                break;
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        getUnsubscribeSignal().onNext(null);
        return super.onUnbind(intent);
    }
}
