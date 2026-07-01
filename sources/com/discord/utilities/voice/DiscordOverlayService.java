package com.discord.utilities.voice;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Builder;
import b.a.n.c;
import b.a.n.d;
import b.a.y.w;
import b.a.y.z;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.OverlayService;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.extensions.PendingIntentExtensionsKt;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils$RouteBuilders$Uris;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.OverlayMenuBubbleDialog;
import d0.z.d.m;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService extends OverlayService {
    private static final String ACTION_CLOSE = "com.discord.actions.OVERLAY_CLOSE";
    private static final String ACTION_OPEN = "com.discord.actions.OVERLAY_OPEN";
    private static final String ACTION_SELECTOR = "com.discord.actions.OVERLAY_SELECTOR";
    private static final String ACTION_VOICE = "com.discord.actions.OVERLAY_VOICE";
    private static final int CLOSE_INTENT_REQ_CODE = 1010;
    public static final DiscordOverlayService$Companion Companion = new DiscordOverlayService$Companion(null);
    private static final String LOG_TAG = "OverlayService";

    public static final /* synthetic */ OverlayMenuBubbleDialog access$createMenu(DiscordOverlayService discordOverlayService) {
        return discordOverlayService.createMenu();
    }

    public static final /* synthetic */ OverlayManager access$getOverlayManager$p(DiscordOverlayService discordOverlayService) {
        return discordOverlayService.getOverlayManager();
    }

    public static final /* synthetic */ void access$handleStart$s1927314545(DiscordOverlayService discordOverlayService, Intent intent) {
        super.handleStart(intent);
    }

    public static final /* synthetic */ void access$setOverlayManager$p(DiscordOverlayService discordOverlayService, OverlayManager overlayManager) {
        discordOverlayService.setOverlayManager(overlayManager);
    }

    private final OverlayMenuBubbleDialog createMenu() {
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayMenuBubbleDialog overlayMenuBubbleDialog = new OverlayMenuBubbleDialog(applicationContext);
        overlayMenuBubbleDialog.getInsetMargins().top = overlayMenuBubbleDialog.getResources().getDimensionPixelOffset(2131165801);
        overlayMenuBubbleDialog.setOnDialogClosed(new DiscordOverlayService$createMenu$1(this));
        return overlayMenuBubbleDialog;
    }

    private final OverlayBubbleWrap createVoiceBubble() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131165723);
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        w wVar = new w(applicationContext);
        int i = -dimensionPixelOffset;
        wVar.getInsetMargins().set(i, dimensionPixelOffset, i, dimensionPixelOffset);
        OverlayManager overlayManager = getOverlayManager();
        DiscordOverlayService$createVoiceBubble$1 discordOverlayService$createVoiceBubble$1 = new DiscordOverlayService$createVoiceBubble$1(this, "Active Voice Bubble");
        Objects.requireNonNull(overlayManager);
        m.checkNotNullParameter(wVar, "srcBubble");
        m.checkNotNullParameter("Active Voice Bubble", "anchorViewTag");
        m.checkNotNullParameter(discordOverlayService$createVoiceBubble$1, "menuBubbleProvider");
        wVar.setOnClickListener(new d(overlayManager, discordOverlayService$createVoiceBubble$1, wVar, "Active Voice Bubble"));
        OverlayManager overlayManager2 = getOverlayManager();
        Objects.requireNonNull(overlayManager2);
        m.checkNotNullParameter(wVar, "bubble");
        wVar.setOnTouchListener(overlayManager2.bubbleOnTouchListener);
        wVar.setOnMovingStateChanged(new c(overlayManager2, wVar));
        return wVar;
    }

    private final OverlayBubbleWrap createVoiceSelector() {
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        z zVar = new z(applicationContext);
        zVar.setOnDialogClosed(new DiscordOverlayService$createVoiceSelector$1(this));
        return zVar;
    }

    @Override // com.discord.overlay.OverlayService
    public Notification createNotification(Intent intent) {
        PendingIntent service = PendingIntent.getService(this, 1010, DiscordOverlayService$Companion.access$createOverlayIntent(Companion, this, ACTION_CLOSE), PendingIntentExtensionsKt.immutablePendingIntentFlag(134217728));
        Notification notificationBuild = new NotificationCompat$Builder(this, NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS).setCategory(NotificationCompat.CATEGORY_SERVICE).setPriority(-2).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(2131231973).setColor(ColorCompat.getColor(this, 2131100304)).setContentTitle(getString(2131893556)).setContentText(getString(2131893575)).setOngoing(true).addAction(2131231681, getString(2131887680), service).addAction(2131232110, getString(2131895608), PendingIntent.getActivity(this, 1010, new Intent("android.intent.action.VIEW", IntentUtils$RouteBuilders$Uris.INSTANCE.getSelectSettingsVoice()).setPackage(getPackageName()), PendingIntentExtensionsKt.immutablePendingIntentFlag(134217728))).build();
        m.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…       )\n        .build()");
        return notificationBuild;
    }

    @Override // com.discord.overlay.OverlayService
    public OverlayBubbleWrap createOverlayBubble(Intent intent) {
        Object next;
        Object next2;
        m.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            return null;
        }
        int iHashCode = action.hashCode();
        if (iHashCode == -753952221) {
            if (!action.equals(ACTION_VOICE)) {
                return null;
            }
            Iterator<T> it = getOverlayManager().activeBubbles.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((OverlayBubbleWrap) next) instanceof w));
            if (((OverlayBubbleWrap) next) != null) {
                return null;
            }
            return createVoiceBubble();
        }
        if (iHashCode != -440170727) {
            if (iHashCode == 557534510 && action.equals(ACTION_SELECTOR)) {
                return createVoiceSelector();
            }
            return null;
        }
        if (!action.equals(ACTION_OPEN)) {
            return null;
        }
        Iterator<T> it2 = getOverlayManager().activeBubbles.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!(((OverlayBubbleWrap) next2) instanceof w));
        OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) next2;
        if (overlayBubbleWrap == null) {
            return createVoiceBubble();
        }
        overlayBubbleWrap.performClick();
        return null;
    }

    @Override // com.discord.overlay.OverlayService, android.app.Service
    public void onCreate() {
        super.onCreate();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Application application = getApplication();
        m.checkNotNullExpressionValue(application, "application");
        storeStream$Companion.initialize(application);
        OverlayManager overlayManager = getOverlayManager();
        DiscordOverlayService$onCreate$1 discordOverlayService$onCreate$1 = DiscordOverlayService$onCreate$1.INSTANCE;
        Objects.requireNonNull(overlayManager);
        m.checkNotNullParameter(discordOverlayService$onCreate$1, "<set-?>");
        overlayManager.onOverlayBubbleAdded = discordOverlayService$onCreate$1;
        OverlayManager overlayManager2 = getOverlayManager();
        DiscordOverlayService$onCreate$2 discordOverlayService$onCreate$2 = new DiscordOverlayService$onCreate$2(this);
        Objects.requireNonNull(overlayManager2);
        m.checkNotNullParameter(discordOverlayService$onCreate$2, "<set-?>");
        overlayManager2.onOverlayBubbleRemoved = discordOverlayService$onCreate$2;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("onStartCommand: ");
        sbU.append(intent != null ? intent.getAction() : null);
        Logger.v$default(appLog, LOG_TAG, sbU.toString(), null, 4, null);
        if (m.areEqual(intent != null ? intent.getAction() : null, ACTION_CLOSE) || !DeviceUtils.INSTANCE.canDrawOverlays(this)) {
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        Observable<Boolean> observableZ = StoreStream.Companion.isInitializedObservable().y(DiscordOverlayService$onStartCommand$1.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "StoreStream.isInitialize….takeFirst { it == true }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableZ), DiscordOverlayService.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new DiscordOverlayService$onStartCommand$2(this, startId, intent), 62, (Object) null);
        return 3;
    }
}
