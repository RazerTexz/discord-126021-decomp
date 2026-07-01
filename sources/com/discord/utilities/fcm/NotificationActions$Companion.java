package com.discord.utilities.fcm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationActions$Companion {
    private NotificationActions$Companion() {
    }

    public final Intent callAction(Context context, long channelId, long messageId, boolean isAcceptingCall) {
        m.checkNotNullParameter(context, "context");
        return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/channel/call/" + (isAcceptingCall ? "accept" : "decline") + "?channelId=" + channelId + "&messageId=" + messageId), context, NotificationActions.class);
    }

    public final Intent cancel(Context context, int notificationId) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent("com.discord.intent.action.NOTIFICATION_CANCEL", Uri.parse("discord://action/notif/cancel?id=" + notificationId), context, NotificationActions.class).putExtra("com.discord.NOTIFICATION_ID", notificationId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent(\n          Intent…ATION_ID, notificationId)");
        return intentPutExtra;
    }

    public final Intent delete(Context context, long channelId) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent("com.discord.intent.action.NOTIFICATION_DELETED", Uri.parse("discord://action/notif/delete?channelId=" + channelId), context, NotificationActions.class).putExtra("com.discord.NOTIFICATION_DELETED_CHANNEL_ID", channelId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent(\n          Intent…ON_CHANNEL_ID, channelId)");
        return intentPutExtra;
    }

    public final Intent directReply(Context context, long channelId, CharSequence channelName) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/message/reply?channelId=" + channelId), context, NotificationActions.class);
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_NAME", channelName);
        return intent;
    }

    public final Intent markAsRead(Context context, long channelId, long messageId) {
        m.checkNotNullParameter(context, "context");
        return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/message/ack?channelId=" + channelId + "&messageId=" + messageId), context, NotificationActions.class);
    }

    public final Intent timedMute(Context context, long guildId, long channelId, long untilTimestamp) {
        m.checkNotNullParameter(context, "context");
        return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/channel/mute").buildUpon().appendQueryParameter("guildId", String.valueOf(guildId)).appendQueryParameter("channelId", String.valueOf(channelId)).appendQueryParameter("until", String.valueOf(untilTimestamp)).build(), context, NotificationActions.class);
    }

    public /* synthetic */ NotificationActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
