package com.discord.utilities.voice;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import com.discord.app.AppActivity$Main;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.PendingIntentExtensionsKt;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;
import d0.z.d.m;

/* JADX INFO: compiled from: VoiceEngineNotificationBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineNotificationBuilder {
    public static final VoiceEngineNotificationBuilder INSTANCE = new VoiceEngineNotificationBuilder();

    private VoiceEngineNotificationBuilder() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingIntent getCallScreenNavigationIntent$default(VoiceEngineNotificationBuilder voiceEngineNotificationBuilder, Context context, long j, String str, Class cls, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "com.discord.utilities.voice.action.main";
        }
        String str2 = str;
        if ((i & 4) != 0) {
            cls = AppActivity$Main.class;
        }
        return voiceEngineNotificationBuilder.getCallScreenNavigationIntent(context, j, str2, cls);
    }

    private final PendingIntent getServiceActionIntent(Context context, Class<?> cls, String str) {
        return PendingIntent.getService(context, 0, new Intent(context, cls).setAction(str), PendingIntentExtensionsKt.immutablePendingIntentFlag$default(0, 1, null));
    }

    public final Notification buildNotification(Context context, String actionMain, String actionDisconnect, String actionStopStream, String actionToggleMuted, String actionToggleDeafened, Class<?> notificationServiceClass, String notificationChannel, long notificationChannelId, CharSequence notificationTitle, CharSequence notificationSubtitle, Class<?> notificationClass, boolean isStreaming, boolean isMuted, boolean isDeafened) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(actionMain, "actionMain");
        m.checkNotNullParameter(actionDisconnect, "actionDisconnect");
        m.checkNotNullParameter(actionStopStream, "actionStopStream");
        m.checkNotNullParameter(actionToggleDeafened, "actionToggleDeafened");
        m.checkNotNullParameter(notificationServiceClass, "notificationServiceClass");
        m.checkNotNullParameter(notificationChannel, "notificationChannel");
        m.checkNotNullParameter(notificationClass, "notificationClass");
        NotificationCompat$Builder ongoing = new NotificationCompat$Builder(context, notificationChannel).setContentTitle(notificationTitle).setContentText(notificationSubtitle).setColor(ColorCompat.getThemedColor(context, 2130969062)).setColorized(true).setSmallIcon(2131231973).setContentIntent(getCallScreenNavigationIntent(context, notificationChannelId, actionMain, notificationClass)).setOngoing(true);
        String string = context.getResources().getString(2131888498);
        VoiceEngineNotificationBuilder voiceEngineNotificationBuilder = INSTANCE;
        ongoing.addAction(new NotificationCompat$Action(2131231590, string, voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionDisconnect)));
        if (isStreaming) {
            ongoing.addAction(new NotificationCompat$Action(2131231938, context.getResources().getString(2131896004), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionStopStream)));
        } else {
            if (actionToggleMuted != null) {
                ongoing.addAction(new NotificationCompat$Action(isMuted ? 2131231933 : 2131231932, isMuted ? context.getResources().getString(2131896587) : context.getResources().getString(2131893137), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleMuted)));
            }
            ongoing.addAction(new NotificationCompat$Action(isDeafened ? 2131231864 : 2131231863, isDeafened ? context.getResources().getString(2131896574) : context.getResources().getString(2131888355), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleDeafened)));
        }
        Notification notificationBuild = ongoing.build();
        m.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…     }\n          .build()");
        return notificationBuild;
    }

    public final PendingIntent getCallScreenNavigationIntent(Context context, long j, String str, Class<?> cls) {
        m.checkNotNullParameter(context, "$this$getCallScreenNavigationIntent");
        m.checkNotNullParameter(str, "action");
        m.checkNotNullParameter(cls, "fullscreenClass");
        PendingIntent activity = PendingIntent.getActivity(context, 0, IntentUtils$RouteBuilders.INSTANCE.connectVoice(j).setClass(context, cls).setAction(str).setFlags(268468224), PendingIntentExtensionsKt.immutablePendingIntentFlag$default(0, 1, null));
        m.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…lePendingIntentFlag()\n  )");
        return activity;
    }
}
