package com.discord.utilities.voice;

import android.app.Application;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager$WifiLock;
import android.os.IBinder;
import android.os.PowerManager$WakeLock;
import androidx.core.view.PointerIconCompat;
import b.a.d.l;
import b.d.b.a.a;
import com.discord.app.AppActivity$Main;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.system.SystemServiceExtensionsKt;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageChannelNotifications;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService extends IntentService implements AppComponent {
    private static final String LOG_TAG = "DiscordVoiceService";
    private static final int NOTIFICATION_ID = 101;
    private static final long WAKELOCK_TIMEOUT = 7200000;
    private final VoiceEngineForegroundService$LocalBinder binder;
    private final CallSoundManager ringManager;
    private ScreenShareManager screenShareManager;
    private final Subject<Void, Void> unsubscribeSignal;
    private PowerManager$WakeLock wakeLockPartial;
    private PowerManager$WakeLock wakeLockProximity;
    private WifiManager$WifiLock wakeLockWifi;
    public static final VoiceEngineForegroundService$Companion Companion = new VoiceEngineForegroundService$Companion(null);
    private static Function0<Unit> onDisconnect = VoiceEngineForegroundService$Companion$onDisconnect$1.INSTANCE;
    private static Function0<Unit> onToggleSelfDeafen = VoiceEngineForegroundService$Companion$onToggleSelfDeafen$1.INSTANCE;
    private static Function0<Unit> onToggleSelfMute = VoiceEngineForegroundService$Companion$onToggleSelfMute$1.INSTANCE;

    public VoiceEngineForegroundService() {
        super("VoiceEngineForegroundService");
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.binder = new VoiceEngineForegroundService$LocalBinder(this);
        this.ringManager = new CallSoundManager(this, null, null, 6, null);
    }

    public static final /* synthetic */ Function0 access$getOnDisconnect$cp() {
        return onDisconnect;
    }

    public static final /* synthetic */ Function0 access$getOnToggleSelfDeafen$cp() {
        return onToggleSelfDeafen;
    }

    public static final /* synthetic */ Function0 access$getOnToggleSelfMute$cp() {
        return onToggleSelfMute;
    }

    public static final /* synthetic */ void access$setOnDisconnect$cp(Function0 function0) {
        onDisconnect = function0;
    }

    public static final /* synthetic */ void access$setOnToggleSelfDeafen$cp(Function0 function0) {
        onToggleSelfDeafen = function0;
    }

    public static final /* synthetic */ void access$setOnToggleSelfMute$cp(Function0 function0) {
        onToggleSelfMute = function0;
    }

    private final void ackStageInvite(Intent intent, boolean accept) {
        long longExtra = intent.getLongExtra("com.discord.utilities.voice.extra.channel_id", 0L);
        Observable<Void> observableAckInvitationToSpeak = StageChannelAPI.INSTANCE.ackInvitationToSpeak(longExtra, accept);
        if (observableAckInvitationToSpeak != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(observableAckInvitationToSpeak, false, 1, null)), VoiceEngineForegroundService.class, (Context) null, (Function1) null, new VoiceEngineForegroundService$ackStageInvite$1(longExtra), (Function0) null, (Function0) null, new VoiceEngineForegroundService$ackStageInvite$2(this, accept, longExtra), 54, (Object) null);
        } else {
            Logger.w$default(AppLog.g, LOG_TAG, a.t("Unable to ack stage invite for unknown channel ", longExtra), null, 4, null);
        }
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        m.checkNotNullParameter(intent, "intent");
        return this.binder;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.v$default(AppLog.g, LOG_TAG, "Service created.", null, 4, null);
        l.c.a(this);
        Application application = getApplication();
        m.checkNotNullExpressionValue(application, "application");
        WifiManager$WifiLock wifiManager$WifiLockCreateWifiLock$default = SystemServiceExtensionsKt.createWifiLock$default(application, false, 0, null, 7, null);
        this.wakeLockWifi = wifiManager$WifiLockCreateWifiLock$default;
        if (wifiManager$WifiLockCreateWifiLock$default != null) {
            wifiManager$WifiLockCreateWifiLock$default.acquire();
        }
        Application application2 = getApplication();
        m.checkNotNullExpressionValue(application2, "application");
        PowerManager$WakeLock powerManager$WakeLockCreatePartialWakeLock$default = SystemServiceExtensionsKt.createPartialWakeLock$default(application2, false, null, 3, null);
        this.wakeLockPartial = powerManager$WakeLockCreatePartialWakeLock$default;
        if (powerManager$WakeLockCreatePartialWakeLock$default != null) {
            powerManager$WakeLockCreatePartialWakeLock$default.acquire(WAKELOCK_TIMEOUT);
        }
        Application application3 = getApplication();
        m.checkNotNullExpressionValue(application3, "application");
        PowerManager$WakeLock powerManager$WakeLockCreateProximityScreenWakeLock$default = SystemServiceExtensionsKt.createProximityScreenWakeLock$default(application3, false, null, 3, null);
        this.wakeLockProximity = powerManager$WakeLockCreateProximityScreenWakeLock$default;
        if (powerManager$WakeLockCreateProximityScreenWakeLock$default != null) {
            powerManager$WakeLockCreateProximityScreenWakeLock$default.acquire(WAKELOCK_TIMEOUT);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.v$default(AppLog.g, LOG_TAG, "Service destroyed.", null, 4, null);
        StageChannelNotifications.Companion.getINSTANCE().onInviteToSpeakRescinded();
        l.c.b(this);
        WifiManager$WifiLock wifiManager$WifiLock = this.wakeLockWifi;
        if (wifiManager$WifiLock != null) {
            wifiManager$WifiLock.release();
        }
        PowerManager$WakeLock powerManager$WakeLock = this.wakeLockPartial;
        if (powerManager$WakeLock != null) {
            powerManager$WakeLock.release();
        }
        PowerManager$WakeLock powerManager$WakeLock2 = this.wakeLockProximity;
        if (powerManager$WakeLock2 != null) {
            powerManager$WakeLock2.release();
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
        m.checkNotNullExpressionValue(action, "intent?.action ?: return");
        Logger.v$default(AppLog.g, LOG_TAG, a.w("Received action: ", action), null, 4, null);
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
                        PowerManager$WakeLock powerManager$WakeLock = this.wakeLockProximity;
                        if (powerManager$WakeLock != null) {
                            powerManager$WakeLock.acquire(WAKELOCK_TIMEOUT);
                        }
                    } else {
                        PowerManager$WakeLock powerManager$WakeLock2 = this.wakeLockProximity;
                        if (powerManager$WakeLock2 != null) {
                            powerManager$WakeLock2.release();
                        }
                    }
                    Long l = (Long) intent.getSerializableExtra("com.discord.utilities.voice.extra.guild_id");
                    Long l2 = (Long) intent.getSerializableExtra("com.discord.utilities.voice.extra.channel_id");
                    if (l2 != null) {
                        this.ringManager.subscribeToStoreState(l2.longValue());
                        ScreenShareManager screenShareManager3 = this.screenShareManager;
                        if (!(!m.areEqual(screenShareManager3 != null ? Long.valueOf(screenShareManager3.getChannelId()) : null, l2))) {
                            ScreenShareManager screenShareManager4 = this.screenShareManager;
                            if (!m.areEqual(screenShareManager4 != null ? screenShareManager4.getGuildId() : null, l)) {
                            }
                        }
                        ScreenShareManager screenShareManager5 = this.screenShareManager;
                        if (screenShareManager5 != null) {
                            screenShareManager5.release();
                        }
                        this.screenShareManager = new ScreenShareManager(this, l2.longValue(), l, null, null, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
                    }
                    startForeground(101, VoiceEngineNotificationBuilder.INSTANCE.buildNotification(this, "com.discord.utilities.voice.action.main", "com.discord.utilities.voice.action.disconnect", "com.discord.utilities.voice.action.stop_stream", intent.getBooleanExtra("com.discord.utilities.voice.extra.item_can_speak", true) ? "com.discord.utilities.voice.action.toggle_muted" : null, "com.discord.utilities.voice.action.toggle_deafened", VoiceEngineForegroundService.class, NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS, l2 != 0 ? l2.longValue() : 0L, intent.getCharSequenceExtra("com.discord.utilities.voice.extra.title"), intent.getCharSequenceExtra("com.discord.utilities.voice.extra.title_subtext"), AppActivity$Main.class, intent.getBooleanExtra("com.discord.utilities.voice.extra.item_streaming", false), intent.getBooleanExtra("com.discord.utilities.voice.extra.item_muted", false), intent.getBooleanExtra("com.discord.utilities.voice.extra.item_deafened", false)));
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
