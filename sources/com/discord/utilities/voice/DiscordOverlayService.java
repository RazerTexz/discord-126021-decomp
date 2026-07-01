package com.discord.utilities.voice;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import b.a.d.AppToast;
import b.a.n.OverlayManager4;
import b.a.n.OverlayManager5;
import b.a.y.OverlayVoiceBubble2;
import b.a.y.OverlayVoiceSelectorBubbleDialog3;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.OverlayService;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.overlay.views.OverlayDialog;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.OverlayMenuBubbleDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService extends OverlayService {
    private static final String ACTION_CLOSE = "com.discord.actions.OVERLAY_CLOSE";
    private static final String ACTION_OPEN = "com.discord.actions.OVERLAY_OPEN";
    private static final String ACTION_SELECTOR = "com.discord.actions.OVERLAY_SELECTOR";
    private static final String ACTION_VOICE = "com.discord.actions.OVERLAY_VOICE";
    private static final int CLOSE_INTENT_REQ_CODE = 1010;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOG_TAG = "OverlayService";

    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Intent createOverlayIntent(Context context, String action) {
            return new Intent(action, null, context, DiscordOverlayService.class);
        }

        private final void tryStartOverlayService(Context context, String action, boolean checkEnabled) {
            if (StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled() || !checkEnabled) {
                try {
                    context.startService(createOverlayIntent(context, action));
                } catch (Exception e) {
                    AppLog.g.v(DiscordOverlayService.LOG_TAG, "Overlay request failed.", e);
                }
            }
        }

        public static /* synthetic */ void tryStartOverlayService$default(Companion companion, Context context, String str, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = true;
            }
            companion.tryStartOverlayService(context, str, z2);
        }

        public final void launchForClose(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            tryStartOverlayService(context, DiscordOverlayService.ACTION_CLOSE, false);
        }

        public final void launchForConnect(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            if (!companion.getUserSettings().getIsMobileOverlayEnabled()) {
                AppToast.g(context, R.string.overlay_mobile_required, 1, null, 8);
                return;
            }
            WeakReference weakReference = new WeakReference(context);
            Observable observableG = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getRtcConnection().getConnectionState(), 1000L, false, 2, null).G(new Func1<RtcConnection.StateChange, String>() { // from class: com.discord.utilities.voice.DiscordOverlayService$Companion$launchForConnect$1
                @Override // j0.k.Func1
                public final String call(RtcConnection.StateChange stateChange) {
                    RtcConnection.State state = stateChange.state;
                    return (!(state instanceof RtcConnection.State.d) || ((RtcConnection.State.d) state).a) ? "com.discord.actions.OVERLAY_OPEN" : "com.discord.actions.OVERLAY_SELECTOR";
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n            …          }\n            }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableG), (Class<?>) DiscordOverlayService.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new DiscordOverlayService3(weakReference));
        }

        public final void launchForVoice(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            tryStartOverlayService$default(this, context, DiscordOverlayService.ACTION_VOICE, false, 4, null);
        }

        public final void launchForVoiceChannelSelect(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            tryStartOverlayService$default(this, context, DiscordOverlayService.ACTION_SELECTOR, false, 4, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$createMenu$1, reason: invalid class name */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<OverlayDialog, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlayDialog overlayDialog) {
            invoke2(overlayDialog);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlayDialog overlayDialog) {
            Intrinsics3.checkNotNullParameter(overlayDialog, "it");
            DiscordOverlayService.this.getOverlayManager().d(overlayDialog);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$createVoiceBubble$1, reason: invalid class name */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<OverlayBubbleWrap, OverlayBubbleWrap> {
        public final /* synthetic */ String $anchorTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$anchorTag = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final OverlayBubbleWrap invoke(OverlayBubbleWrap overlayBubbleWrap) {
            Rect rect;
            SimpleDraweeView imageView$app_productionGoogleRelease;
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "srcBubble");
            OverlayMenuBubbleDialog overlayMenuBubbleDialogCreateMenu = DiscordOverlayService.this.createMenu();
            OverlayVoiceBubble2 overlayVoiceBubble2 = (OverlayVoiceBubble2) (!(overlayBubbleWrap instanceof OverlayVoiceBubble2) ? null : overlayBubbleWrap);
            if (overlayVoiceBubble2 == null || (imageView$app_productionGoogleRelease = overlayVoiceBubble2.getImageView$app_productionGoogleRelease()) == null) {
                rect = new Rect();
            } else {
                ViewGroup.LayoutParams layoutParams = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                int i = marginLayoutParams == null ? 0 : marginLayoutParams.leftMargin;
                ViewGroup.LayoutParams layoutParams2 = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                int i2 = marginLayoutParams2 == null ? 0 : marginLayoutParams2.topMargin;
                ViewGroup.LayoutParams layoutParams3 = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
                int i3 = marginLayoutParams3 == null ? 0 : marginLayoutParams3.rightMargin;
                ViewGroup.LayoutParams layoutParams4 = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
                rect = new Rect(i, i2, i3, marginLayoutParams4 != null ? marginLayoutParams4.bottomMargin : 0);
            }
            ViewGroup.LayoutParams layoutParams5 = overlayMenuBubbleDialogCreateMenu.getLinkedAnchorView().getLayoutParams();
            layoutParams5.width = (overlayBubbleWrap.getWidth() - rect.left) - rect.right;
            layoutParams5.height = overlayBubbleWrap.getHeight();
            overlayMenuBubbleDialogCreateMenu.getLinkedAnchorView().requestLayout();
            overlayMenuBubbleDialogCreateMenu.getLinkedAnchorView().setTag(this.$anchorTag);
            return overlayMenuBubbleDialogCreateMenu;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$createVoiceSelector$1, reason: invalid class name */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<OverlayDialog, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlayDialog overlayDialog) {
            invoke2(overlayDialog);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlayDialog overlayDialog) {
            Intrinsics3.checkNotNullParameter(overlayDialog, "it");
            DiscordOverlayService.this.getOverlayManager().d(overlayDialog);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (view instanceof OverlayVoiceBubble2) {
                StoreStream.INSTANCE.getAnalytics().onOverlayVoiceEvent(true);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Logger.v$default(AppLog.g, DiscordOverlayService.LOG_TAG, "removeView: " + view, null, 4, null);
            if (view instanceof OverlayVoiceBubble2) {
                StoreStream.INSTANCE.getAnalytics().onOverlayVoiceEvent(false);
            }
            if (DiscordOverlayService.this.getOverlayManager().activeBubbles.isEmpty()) {
                Companion.tryStartOverlayService$default(DiscordOverlayService.INSTANCE, DiscordOverlayService.this, DiscordOverlayService.ACTION_CLOSE, false, 4, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$onStartCommand$2, reason: invalid class name */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ Intent $intent;
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, Intent intent) {
            super(1);
            this.$startId = i;
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (!StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                DiscordOverlayService.this.stopForeground(true);
                DiscordOverlayService.this.stopSelf(this.$startId);
                return;
            }
            try {
                DiscordOverlayService.super.handleStart(this.$intent);
            } catch (Exception e) {
                Logger.e$default(AppLog.g, DiscordOverlayService.LOG_TAG, "Overlay failed to handle a request.", e, null, 8, null);
                Companion.tryStartOverlayService$default(DiscordOverlayService.INSTANCE, DiscordOverlayService.this, DiscordOverlayService.ACTION_CLOSE, false, 4, null);
            }
        }
    }

    private final OverlayMenuBubbleDialog createMenu() {
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayMenuBubbleDialog overlayMenuBubbleDialog = new OverlayMenuBubbleDialog(applicationContext);
        overlayMenuBubbleDialog.getInsetMargins().top = overlayMenuBubbleDialog.getResources().getDimensionPixelOffset(R.dimen.vertical_safe_margin);
        overlayMenuBubbleDialog.setOnDialogClosed(new AnonymousClass1());
        return overlayMenuBubbleDialog;
    }

    private final OverlayBubbleWrap createVoiceBubble() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.overlay_safe_margin);
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayVoiceBubble2 overlayVoiceBubble2 = new OverlayVoiceBubble2(applicationContext);
        int i = -dimensionPixelOffset;
        overlayVoiceBubble2.getInsetMargins().set(i, dimensionPixelOffset, i, dimensionPixelOffset);
        OverlayManager overlayManager = getOverlayManager();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("Active Voice Bubble");
        Objects.requireNonNull(overlayManager);
        Intrinsics3.checkNotNullParameter(overlayVoiceBubble2, "srcBubble");
        Intrinsics3.checkNotNullParameter("Active Voice Bubble", "anchorViewTag");
        Intrinsics3.checkNotNullParameter(anonymousClass1, "menuBubbleProvider");
        overlayVoiceBubble2.setOnClickListener(new OverlayManager5(overlayManager, anonymousClass1, overlayVoiceBubble2, "Active Voice Bubble"));
        OverlayManager overlayManager2 = getOverlayManager();
        Objects.requireNonNull(overlayManager2);
        Intrinsics3.checkNotNullParameter(overlayVoiceBubble2, "bubble");
        overlayVoiceBubble2.setOnTouchListener(overlayManager2.bubbleOnTouchListener);
        overlayVoiceBubble2.setOnMovingStateChanged(new OverlayManager4(overlayManager2, overlayVoiceBubble2));
        return overlayVoiceBubble2;
    }

    private final OverlayBubbleWrap createVoiceSelector() {
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayVoiceSelectorBubbleDialog3 overlayVoiceSelectorBubbleDialog3 = new OverlayVoiceSelectorBubbleDialog3(applicationContext);
        overlayVoiceSelectorBubbleDialog3.setOnDialogClosed(new AnonymousClass1());
        return overlayVoiceSelectorBubbleDialog3;
    }

    @Override // com.discord.overlay.OverlayService
    public Notification createNotification(Intent intent) {
        PendingIntent service = PendingIntent.getService(this, 1010, INSTANCE.createOverlayIntent(this, ACTION_CLOSE), PendingIntentExtensions.immutablePendingIntentFlag(134217728));
        Notification notificationBuild = new NotificationCompat.Builder(this, NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS).setCategory(NotificationCompat.CATEGORY_SERVICE).setPriority(-2).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(R.drawable.ic_notification_24dp).setColor(ColorCompat.getColor(this, R.color.status_green_600)).setContentTitle(getString(R.string.overlay)).setContentText(getString(R.string.overlay_mobile_toggle_desc)).setOngoing(true).addAction(R.drawable.ic_close_grey_24dp, getString(R.string.close), service).addAction(R.drawable.ic_settings_grey_a60_24dp, getString(R.string.settings), PendingIntent.getActivity(this, 1010, new Intent("android.intent.action.VIEW", IntentUtils.RouteBuilders.Uris.INSTANCE.getSelectSettingsVoice()).setPackage(getPackageName()), PendingIntentExtensions.immutablePendingIntentFlag(134217728))).build();
        Intrinsics3.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…       )\n        .build()");
        return notificationBuild;
    }

    @Override // com.discord.overlay.OverlayService
    public OverlayBubbleWrap createOverlayBubble(Intent intent) {
        Object next;
        Object next2;
        Intrinsics3.checkNotNullParameter(intent, "intent");
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
            } while (!(((OverlayBubbleWrap) next) instanceof OverlayVoiceBubble2));
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
        } while (!(((OverlayBubbleWrap) next2) instanceof OverlayVoiceBubble2));
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
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Application application = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application, "application");
        companion.initialize(application);
        OverlayManager overlayManager = getOverlayManager();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Objects.requireNonNull(overlayManager);
        Intrinsics3.checkNotNullParameter(anonymousClass1, "<set-?>");
        overlayManager.onOverlayBubbleAdded = anonymousClass1;
        OverlayManager overlayManager2 = getOverlayManager();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        Objects.requireNonNull(overlayManager2);
        Intrinsics3.checkNotNullParameter(anonymousClass2, "<set-?>");
        overlayManager2.onOverlayBubbleRemoved = anonymousClass2;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppLog appLog = AppLog.g;
        StringBuilder sbU = outline.U("onStartCommand: ");
        sbU.append(intent != null ? intent.getAction() : null);
        Logger.v$default(appLog, LOG_TAG, sbU.toString(), null, 4, null);
        if (Intrinsics3.areEqual(intent != null ? intent.getAction() : null, ACTION_CLOSE) || !DeviceUtils.INSTANCE.canDrawOverlays(this)) {
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        Observable<Boolean> observableZ = StoreStream.INSTANCE.isInitializedObservable().y(new Func1<Boolean, Boolean>() { // from class: com.discord.utilities.voice.DiscordOverlayService.onStartCommand.1
            @Override // j0.k.Func1
            public final Boolean call(Boolean bool) {
                return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.TRUE));
            }
        }).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.isInitialize….takeFirst { it == true }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableZ), (Class<?>) DiscordOverlayService.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(startId, intent));
        return 3;
    }
}
