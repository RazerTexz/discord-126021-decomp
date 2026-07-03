package com.discord.utilities.voice;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.PendingIntentExtensionsKt;
import com.discord.utilities.intent.IntentUtils;
import p507d0.p592z.p594d.C12238m;

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
            cls = AppActivity.Main.class;
        }
        return voiceEngineNotificationBuilder.getCallScreenNavigationIntent(context, j, str2, cls);
    }

    private final PendingIntent getServiceActionIntent(Context context, Class<?> cls, String str) {
        return PendingIntent.getService(context, 0, new Intent(context, cls).setAction(str), PendingIntentExtensionsKt.immutablePendingIntentFlag$default(0, 1, null));
    }

    public final Notification buildNotification(Context context, String actionMain, String actionDisconnect, String actionStopStream, String actionToggleMuted, String actionToggleDeafened, Class<?> notificationServiceClass, String notificationChannel, long notificationChannelId, CharSequence notificationTitle, CharSequence notificationSubtitle, Class<?> notificationClass, boolean isStreaming, boolean isMuted, boolean isDeafened) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(actionMain, "actionMain");
        C12238m.checkNotNullParameter(actionDisconnect, "actionDisconnect");
        C12238m.checkNotNullParameter(actionStopStream, "actionStopStream");
        C12238m.checkNotNullParameter(actionToggleDeafened, "actionToggleDeafened");
        C12238m.checkNotNullParameter(notificationServiceClass, "notificationServiceClass");
        C12238m.checkNotNullParameter(notificationChannel, "notificationChannel");
        C12238m.checkNotNullParameter(notificationClass, "notificationClass");
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(context, notificationChannel).setContentTitle(notificationTitle).setContentText(notificationSubtitle).setColor(ColorCompat.getThemedColor(context, C5419R.attr.color_brand)).setColorized(true).setSmallIcon(C5419R.drawable.ic_notification_24dp).setContentIntent(getCallScreenNavigationIntent(context, notificationChannelId, actionMain, notificationClass)).setOngoing(true);
        String string = context.getResources().getString(C5419R.string.disconnect_self);
        VoiceEngineNotificationBuilder voiceEngineNotificationBuilder = INSTANCE;
        ongoing.addAction(new NotificationCompat.Action(C5419R.drawable.ic_call_disconnect_24dp, string, voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionDisconnect)));
        if (isStreaming) {
            ongoing.addAction(new NotificationCompat.Action(C5419R.drawable.ic_mobile_screenshare_end_24dp, context.getResources().getString(C5419R.string.stop_streaming), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionStopStream)));
        } else {
            if (actionToggleMuted != null) {
                ongoing.addAction(new NotificationCompat.Action(isMuted ? C5419R.drawable.ic_mic_white_18dp_muted : C5419R.drawable.ic_mic_white_18dp, isMuted ? context.getResources().getString(C5419R.string.unmute) : context.getResources().getString(C5419R.string.mute), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleMuted)));
            }
            ongoing.addAction(new NotificationCompat.Action(isDeafened ? C5419R.drawable.ic_headset_white_18dp_deafened : C5419R.drawable.ic_headset_white_18dp, isDeafened ? context.getResources().getString(C5419R.string.undeafen) : context.getResources().getString(C5419R.string.deafen), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleDeafened)));
        }
        Notification notificationBuild = ongoing.build();
        C12238m.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…     }\n          .build()");
        return notificationBuild;
    }

    public final PendingIntent getCallScreenNavigationIntent(Context context, long j, String str, Class<?> cls) {
        C12238m.checkNotNullParameter(context, "$this$getCallScreenNavigationIntent");
        C12238m.checkNotNullParameter(str, "action");
        C12238m.checkNotNullParameter(cls, "fullscreenClass");
        PendingIntent activity = PendingIntent.getActivity(context, 0, IntentUtils.RouteBuilders.INSTANCE.connectVoice(j).setClass(context, cls).setAction(str).setFlags(268468224), PendingIntentExtensionsKt.immutablePendingIntentFlag$default(0, 1, null));
        C12238m.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…lePendingIntentFlag()\n  )");
        return activity;
    }
}
