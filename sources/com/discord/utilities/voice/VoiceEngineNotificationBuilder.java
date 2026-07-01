package com.discord.utilities.voice;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.intent.IntentUtils;
import d0.z.d.Intrinsics3;

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
        return PendingIntent.getService(context, 0, new Intent(context, cls).setAction(str), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null));
    }

    public final Notification buildNotification(Context context, String actionMain, String actionDisconnect, String actionStopStream, String actionToggleMuted, String actionToggleDeafened, Class<?> notificationServiceClass, String notificationChannel, long notificationChannelId, CharSequence notificationTitle, CharSequence notificationSubtitle, Class<?> notificationClass, boolean isStreaming, boolean isMuted, boolean isDeafened) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(actionMain, "actionMain");
        Intrinsics3.checkNotNullParameter(actionDisconnect, "actionDisconnect");
        Intrinsics3.checkNotNullParameter(actionStopStream, "actionStopStream");
        Intrinsics3.checkNotNullParameter(actionToggleDeafened, "actionToggleDeafened");
        Intrinsics3.checkNotNullParameter(notificationServiceClass, "notificationServiceClass");
        Intrinsics3.checkNotNullParameter(notificationChannel, "notificationChannel");
        Intrinsics3.checkNotNullParameter(notificationClass, "notificationClass");
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(context, notificationChannel).setContentTitle(notificationTitle).setContentText(notificationSubtitle).setColor(ColorCompat.getThemedColor(context, R.attr.color_brand)).setColorized(true).setSmallIcon(R.drawable.ic_notification_24dp).setContentIntent(getCallScreenNavigationIntent(context, notificationChannelId, actionMain, notificationClass)).setOngoing(true);
        String string = context.getResources().getString(R.string.disconnect_self);
        VoiceEngineNotificationBuilder voiceEngineNotificationBuilder = INSTANCE;
        ongoing.addAction(new NotificationCompat.Action(R.drawable.ic_call_disconnect_24dp, string, voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionDisconnect)));
        if (isStreaming) {
            ongoing.addAction(new NotificationCompat.Action(R.drawable.ic_mobile_screenshare_end_24dp, context.getResources().getString(R.string.stop_streaming), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionStopStream)));
        } else {
            if (actionToggleMuted != null) {
                ongoing.addAction(new NotificationCompat.Action(isMuted ? R.drawable.ic_mic_white_18dp_muted : R.drawable.ic_mic_white_18dp, isMuted ? context.getResources().getString(R.string.unmute) : context.getResources().getString(R.string.mute), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleMuted)));
            }
            ongoing.addAction(new NotificationCompat.Action(isDeafened ? R.drawable.ic_headset_white_18dp_deafened : R.drawable.ic_headset_white_18dp, isDeafened ? context.getResources().getString(R.string.undeafen) : context.getResources().getString(R.string.deafen), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleDeafened)));
        }
        Notification notificationBuild = ongoing.build();
        Intrinsics3.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…     }\n          .build()");
        return notificationBuild;
    }

    public final PendingIntent getCallScreenNavigationIntent(Context context, long j, String str, Class<?> cls) {
        Intrinsics3.checkNotNullParameter(context, "$this$getCallScreenNavigationIntent");
        Intrinsics3.checkNotNullParameter(str, "action");
        Intrinsics3.checkNotNullParameter(cls, "fullscreenClass");
        PendingIntent activity = PendingIntent.getActivity(context, 0, IntentUtils.RouteBuilders.INSTANCE.connectVoice(j).setClass(context, cls).setAction(str).setFlags(268468224), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null));
        Intrinsics3.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…lePendingIntentFlag()\n  )");
        return activity;
    }
}
