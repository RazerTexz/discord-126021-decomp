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
import com.discord.C5419R;
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
import com.discord.utilities.extensions.PendingIntentExtensionsKt;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.OverlayMenuBubbleDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p036n.C1168c;
import p007b.p008a.p036n.ViewOnClickListenerC1169d;
import p007b.p008a.p062y.C1387w;
import p007b.p008a.p062y.C1390z;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

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
                    AppLog.f14950g.m8517v(DiscordOverlayService.LOG_TAG, "Overlay request failed.", e);
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
            C12238m.checkNotNullParameter(context, "context");
            tryStartOverlayService(context, DiscordOverlayService.ACTION_CLOSE, false);
        }

        public final void launchForConnect(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            if (!companion.getUserSettings().getIsMobileOverlayEnabled()) {
                C0876m.m169g(context, C5419R.string.overlay_mobile_required, 1, null, 8);
                return;
            }
            WeakReference weakReference = new WeakReference(context);
            Observable observableM11083G = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getRtcConnection().getConnectionState(), 1000L, false, 2, null).m11083G(new InterfaceC12589b<RtcConnection.StateChange, String>() { // from class: com.discord.utilities.voice.DiscordOverlayService$Companion$launchForConnect$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final String call(RtcConnection.StateChange stateChange) {
                    RtcConnection.State state = stateChange.state;
                    return (!(state instanceof RtcConnection.State.C5610d) || ((RtcConnection.State.C5610d) state).f18812a) ? "com.discord.actions.OVERLAY_OPEN" : "com.discord.actions.OVERLAY_SELECTOR";
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "StoreStream\n            …          }\n            }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11083G), (Class<?>) DiscordOverlayService.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new DiscordOverlayService$Companion$launchForConnect$2(weakReference));
        }

        public final void launchForVoice(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            tryStartOverlayService$default(this, context, DiscordOverlayService.ACTION_VOICE, false, 4, null);
        }

        public final void launchForVoiceChannelSelect(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            tryStartOverlayService$default(this, context, DiscordOverlayService.ACTION_SELECTOR, false, 4, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$createMenu$1 */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class C70311 extends AbstractC12240o implements Function1<OverlayDialog, Unit> {
        public C70311() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlayDialog overlayDialog) {
            invoke2(overlayDialog);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlayDialog overlayDialog) {
            C12238m.checkNotNullParameter(overlayDialog, "it");
            DiscordOverlayService.this.getOverlayManager().m8433d(overlayDialog);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$createVoiceBubble$1 */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class C70321 extends AbstractC12240o implements Function1<OverlayBubbleWrap, OverlayBubbleWrap> {
        public final /* synthetic */ String $anchorTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70321(String str) {
            super(1);
            this.$anchorTag = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final OverlayBubbleWrap invoke(OverlayBubbleWrap overlayBubbleWrap) {
            Rect rect;
            SimpleDraweeView imageView$app_productionGoogleRelease;
            C12238m.checkNotNullParameter(overlayBubbleWrap, "srcBubble");
            OverlayMenuBubbleDialog overlayMenuBubbleDialogCreateMenu = DiscordOverlayService.this.createMenu();
            C1387w c1387w = (C1387w) (!(overlayBubbleWrap instanceof C1387w) ? null : overlayBubbleWrap);
            if (c1387w == null || (imageView$app_productionGoogleRelease = c1387w.getImageView$app_productionGoogleRelease()) == null) {
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

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$createVoiceSelector$1 */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class C70331 extends AbstractC12240o implements Function1<OverlayDialog, Unit> {
        public C70331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlayDialog overlayDialog) {
            invoke2(overlayDialog);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlayDialog overlayDialog) {
            C12238m.checkNotNullParameter(overlayDialog, "it");
            DiscordOverlayService.this.getOverlayManager().m8433d(overlayDialog);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$onCreate$1 */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class C70341 extends AbstractC12240o implements Function1<View, Unit> {
        public static final C70341 INSTANCE = new C70341();

        public C70341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            if (view instanceof C1387w) {
                StoreStream.INSTANCE.getAnalytics().onOverlayVoiceEvent(true);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$onCreate$2 */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class C70352 extends AbstractC12240o implements Function1<View, Unit> {
        public C70352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            Logger.v$default(AppLog.f14950g, DiscordOverlayService.LOG_TAG, "removeView: " + view, null, 4, null);
            if (view instanceof C1387w) {
                StoreStream.INSTANCE.getAnalytics().onOverlayVoiceEvent(false);
            }
            if (DiscordOverlayService.this.getOverlayManager().activeBubbles.isEmpty()) {
                Companion.tryStartOverlayService$default(DiscordOverlayService.INSTANCE, DiscordOverlayService.this, DiscordOverlayService.ACTION_CLOSE, false, 4, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.DiscordOverlayService$onStartCommand$2 */
    /* JADX INFO: compiled from: DiscordOverlayService.kt */
    public static final class C70372 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ Intent $intent;
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70372(int i, Intent intent) {
            super(1);
            this.$startId = i;
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
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
                Logger.e$default(AppLog.f14950g, DiscordOverlayService.LOG_TAG, "Overlay failed to handle a request.", e, null, 8, null);
                Companion.tryStartOverlayService$default(DiscordOverlayService.INSTANCE, DiscordOverlayService.this, DiscordOverlayService.ACTION_CLOSE, false, 4, null);
            }
        }
    }

    private final OverlayMenuBubbleDialog createMenu() {
        Context applicationContext = getApplicationContext();
        C12238m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayMenuBubbleDialog overlayMenuBubbleDialog = new OverlayMenuBubbleDialog(applicationContext);
        overlayMenuBubbleDialog.getInsetMargins().top = overlayMenuBubbleDialog.getResources().getDimensionPixelOffset(C5419R.dimen.vertical_safe_margin);
        overlayMenuBubbleDialog.setOnDialogClosed(new C70311());
        return overlayMenuBubbleDialog;
    }

    private final OverlayBubbleWrap createVoiceBubble() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(C5419R.dimen.overlay_safe_margin);
        Context applicationContext = getApplicationContext();
        C12238m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        C1387w c1387w = new C1387w(applicationContext);
        int i = -dimensionPixelOffset;
        c1387w.getInsetMargins().set(i, dimensionPixelOffset, i, dimensionPixelOffset);
        OverlayManager overlayManager = getOverlayManager();
        C70321 c70321 = new C70321("Active Voice Bubble");
        Objects.requireNonNull(overlayManager);
        C12238m.checkNotNullParameter(c1387w, "srcBubble");
        C12238m.checkNotNullParameter("Active Voice Bubble", "anchorViewTag");
        C12238m.checkNotNullParameter(c70321, "menuBubbleProvider");
        c1387w.setOnClickListener(new ViewOnClickListenerC1169d(overlayManager, c70321, c1387w, "Active Voice Bubble"));
        OverlayManager overlayManager2 = getOverlayManager();
        Objects.requireNonNull(overlayManager2);
        C12238m.checkNotNullParameter(c1387w, "bubble");
        c1387w.setOnTouchListener(overlayManager2.bubbleOnTouchListener);
        c1387w.setOnMovingStateChanged(new C1168c(overlayManager2, c1387w));
        return c1387w;
    }

    private final OverlayBubbleWrap createVoiceSelector() {
        Context applicationContext = getApplicationContext();
        C12238m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        C1390z c1390z = new C1390z(applicationContext);
        c1390z.setOnDialogClosed(new C70331());
        return c1390z;
    }

    @Override // com.discord.overlay.OverlayService
    public Notification createNotification(Intent intent) {
        PendingIntent service = PendingIntent.getService(this, 1010, INSTANCE.createOverlayIntent(this, ACTION_CLOSE), PendingIntentExtensionsKt.immutablePendingIntentFlag(134217728));
        Notification notificationBuild = new NotificationCompat.Builder(this, NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS).setCategory(NotificationCompat.CATEGORY_SERVICE).setPriority(-2).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(C5419R.drawable.ic_notification_24dp).setColor(ColorCompat.getColor(this, C5419R.color.status_green_600)).setContentTitle(getString(C5419R.string.overlay)).setContentText(getString(C5419R.string.overlay_mobile_toggle_desc)).setOngoing(true).addAction(C5419R.drawable.ic_close_grey_24dp, getString(C5419R.string.close), service).addAction(C5419R.drawable.ic_settings_grey_a60_24dp, getString(C5419R.string.settings), PendingIntent.getActivity(this, 1010, new Intent("android.intent.action.VIEW", IntentUtils.RouteBuilders.Uris.INSTANCE.getSelectSettingsVoice()).setPackage(getPackageName()), PendingIntentExtensionsKt.immutablePendingIntentFlag(134217728))).build();
        C12238m.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…       )\n        .build()");
        return notificationBuild;
    }

    @Override // com.discord.overlay.OverlayService
    public OverlayBubbleWrap createOverlayBubble(Intent intent) {
        Object next;
        Object next2;
        C12238m.checkNotNullParameter(intent, "intent");
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
            } while (!(((OverlayBubbleWrap) next) instanceof C1387w));
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
        } while (!(((OverlayBubbleWrap) next2) instanceof C1387w));
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
        C12238m.checkNotNullExpressionValue(application, "application");
        companion.initialize(application);
        OverlayManager overlayManager = getOverlayManager();
        C70341 c70341 = C70341.INSTANCE;
        Objects.requireNonNull(overlayManager);
        C12238m.checkNotNullParameter(c70341, "<set-?>");
        overlayManager.onOverlayBubbleAdded = c70341;
        OverlayManager overlayManager2 = getOverlayManager();
        C70352 c70352 = new C70352();
        Objects.requireNonNull(overlayManager2);
        C12238m.checkNotNullParameter(c70352, "<set-?>");
        overlayManager2.onOverlayBubbleRemoved = c70352;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppLog appLog = AppLog.f14950g;
        StringBuilder sbM833U = C1643a.m833U("onStartCommand: ");
        sbM833U.append(intent != null ? intent.getAction() : null);
        Logger.v$default(appLog, LOG_TAG, sbM833U.toString(), null, 4, null);
        if (C12238m.areEqual(intent != null ? intent.getAction() : null, ACTION_CLOSE) || !DeviceUtils.INSTANCE.canDrawOverlays(this)) {
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        Observable<Boolean> observableM11100Z = StoreStream.INSTANCE.isInitializedObservable().m11118y(new InterfaceC12589b<Boolean, Boolean>() { // from class: com.discord.utilities.voice.DiscordOverlayService.onStartCommand.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Boolean bool) {
                return Boolean.valueOf(C12238m.areEqual(bool, Boolean.TRUE));
            }
        }).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "StoreStream.isInitialize….takeFirst { it == true }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11100Z), (Class<?>) DiscordOverlayService.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C70372(startId, intent));
        return 3;
    }
}
