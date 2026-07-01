package com.discord.utilities.fcm;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes$Builder;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$MessagingStyle;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.app.Person$Builder;
import androidx.core.graphics.drawable.IconCompat;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$attr;
import com.discord.app.AppActivity$Main;
import com.discord.app.AppLog;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.PendingIntentExtensionsKt;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.notice.NoticePopup;
import d0.g0.t;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import j0.l.a.d;
import j0.l.a.d1;
import j0.l.a.f1;
import j0.l.a.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer {
    public static final NotificationRenderer INSTANCE = new NotificationRenderer();
    private static final String NON_ADAPTIVE_NOTIFICATION_ICON = "com.discord.utilities.NON_ADAPTIVE_NOTIFICATION_ICON ";
    private static final long NOTIFICATION_AUTO_DISMISS = 3000;
    private static final long NOTIFICATION_ICON_FETCH_DELAY_MS = 250;
    private static final int NOTIFICATION_LIGHT_PERIOD = 1500;

    private NotificationRenderer() {
    }

    public static final /* synthetic */ void access$displayNotification(NotificationRenderer notificationRenderer, Context context, int i, NotificationCompat$Builder notificationCompat$Builder) {
        notificationRenderer.displayNotification(context, i, notificationCompat$Builder);
    }

    public static final /* synthetic */ NotificationCompat$MessagingStyle access$getMessageStyle(NotificationRenderer notificationRenderer, Context context, NotificationData notificationData, List list, Map map) {
        return notificationRenderer.getMessageStyle(context, notificationData, list, map);
    }

    public static final /* synthetic */ void access$pushShortcut(NotificationRenderer notificationRenderer, Context context, NotificationData notificationData, NotificationCompat$Builder notificationCompat$Builder, IconCompat iconCompat) {
        notificationRenderer.pushShortcut(context, notificationData, notificationCompat$Builder, iconCompat);
    }

    private final void autoDismissNotification(Context context, int notificationId) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, NotificationActions.Companion.cancel(context, notificationId), PendingIntentExtensionsKt.immutablePendingIntentFlag$default(0, 1, null));
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).set(2, SystemClock.elapsedRealtime() + NOTIFICATION_AUTO_DISMISS, broadcast);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void displayAndUpdateCache(Context context, NotificationData notification, NotificationClient$SettingsV2 settings) {
        NotificationCompat$Builder contentIntent = new NotificationCompat$Builder(context, notification.getNotificationChannelId()).setAutoCancel(true).setOnlyAlertOnce(true).setSmallIcon(notification.getSmallIcon()).setColor(ColorCompat.getThemedColor(context, R$attr.color_brand_500)).setCategory(notification.getNotificationCategory()).setContentTitle(notification.getTitle(context)).setContentText(notification.getContent(context)).setDefaults(getNotificationDefaults(settings.isDisableSound(), settings.isDisableVibrate())).setDeleteIntent(notification.getDeleteIntent(context)).setContentIntent(notification.getContentIntent(context));
        m.checkNotNullExpressionValue(contentIntent, "NotificationCompat.Build…etContentIntent(context))");
        contentIntent.setGroup(notification.getGroupKey());
        NotificationData$DisplayPayload andUpdate = NotificationCache.INSTANCE.getAndUpdate(notification);
        List<NotificationData> extras = andUpdate.getExtras();
        PendingIntent fullScreenIntent = notification.getFullScreenIntent(context);
        if (fullScreenIntent != null) {
            contentIntent.setFullScreenIntent(fullScreenIntent, true);
            contentIntent.setVisibility(1);
        }
        if (!extras.isEmpty()) {
            contentIntent.setNumber(extras.size());
            contentIntent.setStyle(getMessageStyle(context, notification, extras, new MGImagesBitmap$CloseableBitmaps(h0.emptyMap(), false, 2, null)));
        }
        if (notification.getShouldUseBigText()) {
            contentIntent.setStyle(new NotificationCompat$BigTextStyle().bigText(notification.getContent(context)));
        }
        int i = Build$VERSION.SDK_INT;
        if (i < 26) {
            contentIntent.setPriority(notification.getNotificationPriority()).setVibrate(new long[]{0});
            if (!settings.isDisableBlink()) {
                contentIntent.setLights(ColorCompat.getThemedColor(context, 2130969062), NOTIFICATION_LIGHT_PERIOD, NOTIFICATION_LIGHT_PERIOD);
            }
            Uri notificationSound = notification.getNotificationSound(context);
            if (notificationSound != null) {
                Uri uri = settings.isDisableSound() ^ true ? notificationSound : null;
                if (uri != null) {
                    contentIntent.setSound(uri).setDefaults(INSTANCE.getNotificationDefaults(settings.isDisableSound(), settings.isDisableVibrate()) & (-2));
                }
            }
        }
        if (i >= 24) {
            for (NotificationCompat$Action notificationCompat$Action : n.listOf((Object[]) new NotificationCompat$Action[]{notification.getMarkAsReadAction(context), notification.getDirectReplyAction(context, settings.getSendBlockedChannels()), notification.getTimedMute(context, ClockFactory.get(), extras.size()), notification.getCallAction(context, false), notification.getCallAction(context, true)})) {
                if (notificationCompat$Action != null) {
                    contentIntent.addAction(notificationCompat$Action);
                }
            }
        }
        NotificationRenderer$NotificationDisplaySubscriptionManager notificationRenderer$NotificationDisplaySubscriptionManager = NotificationRenderer$NotificationDisplaySubscriptionManager.INSTANCE;
        notificationRenderer$NotificationDisplaySubscriptionManager.cancel(andUpdate.getId());
        Pair<Integer, Observable<MGImagesBitmap$CloseableBitmaps>> pairLoadNotificationBitmaps = loadNotificationBitmaps(andUpdate, notification);
        int iIntValue = pairLoadNotificationBitmaps.component1().intValue();
        Observable<MGImagesBitmap$CloseableBitmaps> observableComponent2 = pairLoadNotificationBitmaps.component2();
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        Observable<Long> observableA0 = Observable.d0(NOTIFICATION_ICON_FETCH_DELAY_MS, TimeUnit.MILLISECONDS).a0(Observable.h0(new r(observableComponent2.j, new f1(new d1(d.k)))));
        m.checkNotNullExpressionValue(observableA0, "Observable\n        .time…Next(Observable.never()))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableA0), (Context) null, "Unable to display notification, timeout.", new NotificationRenderer$displayAndUpdateCache$4(compositeSubscription), new NotificationRenderer$displayAndUpdateCache$5(context, andUpdate, contentIntent, notification), (Function1) null, (Function0) null, (Function0) null, 112, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableComponent2), (Context) null, a.r("Unable to display notification multi-fetch ", iIntValue, " bitmaps."), new NotificationRenderer$displayAndUpdateCache$6(compositeSubscription), new NotificationRenderer$displayAndUpdateCache$7(notification, contentIntent, extras, context, andUpdate), (Function1) null, (Function0) null, (Function0) null, 112, (Object) null);
        notificationRenderer$NotificationDisplaySubscriptionManager.add(andUpdate.getId(), compositeSubscription);
    }

    private final void displayNotification(Context context, int payloadId, NotificationCompat$Builder notificationBuilder) {
        try {
            NotificationManagerCompat.from(context).notify(payloadId, notificationBuilder.build());
        } catch (IllegalStateException e) {
            Logger.e$default(AppLog.g, "NotifyError", e, null, 4, null);
        }
    }

    private final NotificationCompat$MessagingStyle getMessageStyle(Context context, NotificationData notification, List<NotificationData> lines, Map<String, Bitmap> bitmapsForIconUris) {
        Person personBuild = new Person$Builder().setName(context.getString(2131892773)).setKey("me").build();
        m.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …ey(\"me\")\n        .build()");
        NotificationCompat$MessagingStyle groupConversation = new NotificationCompat$MessagingStyle(personBuild).setConversationTitle(notification.getConversationTitle(context)).setGroupConversation(notification.getIsGroupConversation());
        m.checkNotNullExpressionValue(groupConversation, "NotificationCompat.Messa…tion.isGroupConversation)");
        for (NotificationData notificationData : lines) {
            Bitmap bitmap = bitmapsForIconUris.get(notificationData.getIconUrlForAvatar());
            IconCompat iconCompatCreateWithAdaptiveBitmap = bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null;
            Person personBuild2 = notificationData.getSender(context).toBuilder().setIcon(iconCompatCreateWithAdaptiveBitmap).build();
            m.checkNotNullExpressionValue(personBuild2, "person.toBuilder()\n     …(icon)\n          .build()");
            groupConversation.addMessage(notificationData.getContent(context), notificationData.getMessageIdTimestamp() + ((long) (iconCompatCreateWithAdaptiveBitmap == null ? 0 : 1)), personBuild2);
        }
        return groupConversation;
    }

    private final int getNotificationDefaults(boolean disableSound, boolean disableVibrate) {
        int i = !disableSound ? 1 : 0;
        return !disableVibrate ? i | 2 : i;
    }

    private final Pair<Integer, Observable<MGImagesBitmap$CloseableBitmaps>> loadNotificationBitmaps(NotificationData$DisplayPayload displayPayload, NotificationData notification) {
        List<NotificationData> extras = displayPayload.getExtras();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = extras.iterator();
        while (it.hasNext()) {
            String iconUrlForAvatar = ((NotificationData) it.next()).getIconUrlForAvatar();
            if (iconUrlForAvatar != null) {
                arrayList.add(iconUrlForAvatar);
            }
        }
        List listPlus = u.plus((Collection<? extends String>) arrayList, notification.getIconUrl());
        return o.to(Integer.valueOf(listPlus.size() + 1), ShareUtils.INSTANCE.loadAdaptiveBitmaps(u.asSequence(listPlus)).A(new NotificationRenderer$loadNotificationBitmaps$1(notification)));
    }

    private final void pushShortcut(Context context, NotificationData notification, NotificationCompat$Builder notificationBuilder, IconCompat icon) {
        ShareUtils shareUtils = ShareUtils.INSTANCE;
        shareUtils.addShortcut(context, ShareUtils.toShortcutInfo$default(shareUtils, context, notification.getChannelId(), notification.getTitle(context), null, icon, null, 0, 104, null), notificationBuilder);
    }

    public static /* synthetic */ void pushShortcut$default(NotificationRenderer notificationRenderer, Context context, NotificationData notificationData, NotificationCompat$Builder notificationCompat$Builder, IconCompat iconCompat, int i, Object obj) {
        if ((i & 8) != 0) {
            iconCompat = null;
        }
        notificationRenderer.pushShortcut(context, notificationData, notificationCompat$Builder, iconCompat);
    }

    public final void clear(Context context, long channelId, boolean isAckRequest) {
        NotificationCache.INSTANCE.remove(channelId, isAckRequest, new NotificationRenderer$clear$1(context));
    }

    public final void display(Context context, NotificationData notificationData, NotificationClient$SettingsV2 settings) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(notificationData, "notificationData");
        m.checkNotNullParameter(settings, "settings");
        try {
            displayAndUpdateCache(context, notificationData, settings);
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Unable to display notification.", e, null, 4, null);
        }
    }

    public final void displayInApp(Context context, NotificationData notificationData) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(notificationData, "notificationData");
        if (notificationData.canDisplayInApp()) {
            CharSequence title = notificationData.getTitle(context);
            CharSequence content = notificationData.getContent(context);
            if (content == null) {
                content = "";
            }
            CharSequence charSequence = content;
            if (t.isBlank(title) && t.isBlank(charSequence)) {
                return;
            }
            NoticePopup noticePopup = NoticePopup.INSTANCE;
            StringBuilder sbU = a.U("InAppNotif#");
            sbU.append(ClockFactory.get().currentTimeMillis());
            NoticePopup.enqueue$default(noticePopup, sbU.toString(), title, null, charSequence, null, null, null, null, notificationData.getIconUrl(), null, null, null, null, null, new NotificationRenderer$displayInApp$1(notificationData, context), 16116, null);
        }
    }

    public final void displaySent(Context context, long channelId, CharSequence channelName, boolean success, int notificationId) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(channelName, "channelName");
        int i = success ? 2131893381 : 2131893380;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, NotificationActions.Companion.delete(context, channelId), PendingIntentExtensionsKt.immutablePendingIntentFlag(134217728));
        Intent intentSelectChannel$default = IntentUtils$RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null);
        intentSelectChannel$default.setClass(context, AppActivity$Main.class);
        Notification notificationBuild = new NotificationCompat$Builder(context, NotificationClient.NOTIF_CHANNEL_MESSAGES).setAutoCancel(true).setSmallIcon(2131231976).setCategory(NotificationCompat.CATEGORY_MESSAGE).setContentText(b.h(context, i, new Object[]{channelName}, null, 4)).setDeleteIntent(broadcast).setContentIntent(PendingIntent.getActivity(context, 0, intentSelectChannel$default, PendingIntentExtensionsKt.immutablePendingIntentFlag(134217728))).build();
        m.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…ent)\n            .build()");
        NotificationManagerCompat.from(context).notify(notificationId, notificationBuild);
        autoDismissNotification(context, notificationId);
    }

    @RequiresApi(26)
    public final void initNotificationChannels(Application context) {
        m.checkNotNullParameter(context, "context");
        NotificationChannel notificationChannel = new NotificationChannel(NotificationClient.NOTIF_CHANNEL_CALLS, context.getString(2131887361), 4);
        NotificationChannel notificationChannel2 = new NotificationChannel(NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS, context.getString(2131897149), 2);
        List<NotificationChannel> listListOf = n.listOf((Object[]) new NotificationChannel[]{notificationChannel, notificationChannel2, new NotificationChannel(NotificationClient.NOTIF_CHANNEL_MESSAGES, context.getString(2131892981), 4), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_MESSAGES_DIRECT, context.getString(2131888442), 4), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_FORUM_POST_CREATE, context.getString(2131889351), 4), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_SOCIAL, context.getString(2131889471), 2), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_GAME_DETECTION, context.getString(2131889538), 1), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_STAGE_START, context.getString(2131895843), 4), new NotificationChannel(NotificationClient.NOTIF_GUILD_SCHEDULED_EVENT_START, context.getString(2131890721), 4), new NotificationChannel(NotificationClient.NOTIF_GENERAL, context.getString(2131893536), 2), new NotificationChannel(NotificationClient.NOTIF_GENERAL_HIGH_PRIO, context.getString(2131893537), 4)});
        for (NotificationChannel notificationChannel3 : listListOf) {
            notificationChannel3.setShowBadge(true);
            notificationChannel3.enableVibration(true);
            notificationChannel3.enableLights(true);
            notificationChannel3.setLightColor(ColorCompat.getThemedColor(context, 2130969062));
        }
        notificationChannel.setDescription(context.getString(2131887361));
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        notificationChannel.setShowBadge(false);
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        sb.append(context.getPackageName() + MentionUtilsKt.SLASH_CHAR + AppSound.Companion.getSOUND_CALL_RINGING().getResId());
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "StringBuilder()\n        …)\n            .toString()");
        notificationChannel.setSound(Uri.parse(string), new AudioAttributes$Builder().setUsage(7).setContentType(2).build());
        notificationChannel2.setShowBadge(false);
        notificationChannel2.enableVibration(false);
        Object systemService = context.getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannels(listListOf);
    }
}
