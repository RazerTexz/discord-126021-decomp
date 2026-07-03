package com.discord.utilities.fcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.discord.app.AppLog;
import com.discord.app.DiscordConnectService;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.workers.CallActionWorker;
import com.discord.workers.MessageAckWorker;
import com.discord.workers.MessageSendWorker;
import com.discord.workers.TimedMuteWorker;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NotificationActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationActions extends BroadcastReceiver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NOTIFICATION_CHANNEL_ID = "com.discord.NOTIFICATION_DELETED_CHANNEL_ID";
    private static final String NOTIFICATION_ID = "com.discord.NOTIFICATION_ID";

    /* JADX INFO: compiled from: NotificationActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Intent callAction(Context context, long channelId, long messageId, boolean isAcceptingCall) {
            C12238m.checkNotNullParameter(context, "context");
            return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/channel/call/" + (isAcceptingCall ? "accept" : "decline") + "?channelId=" + channelId + "&messageId=" + messageId), context, NotificationActions.class);
        }

        public final Intent cancel(Context context, int notificationId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("com.discord.intent.action.NOTIFICATION_CANCEL", Uri.parse("discord://action/notif/cancel?id=" + notificationId), context, NotificationActions.class).putExtra(NotificationActions.NOTIFICATION_ID, notificationId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent(\n          Intent…ATION_ID, notificationId)");
            return intentPutExtra;
        }

        public final Intent delete(Context context, long channelId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("com.discord.intent.action.NOTIFICATION_DELETED", Uri.parse("discord://action/notif/delete?channelId=" + channelId), context, NotificationActions.class).putExtra(NotificationActions.NOTIFICATION_CHANNEL_ID, channelId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent(\n          Intent…ON_CHANNEL_ID, channelId)");
            return intentPutExtra;
        }

        public final Intent directReply(Context context, long channelId, CharSequence channelName) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/message/reply?channelId=" + channelId), context, NotificationActions.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_NAME", channelName);
            return intent;
        }

        public final Intent markAsRead(Context context, long channelId, long messageId) {
            C12238m.checkNotNullParameter(context, "context");
            return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/message/ack?channelId=" + channelId + "&messageId=" + messageId), context, NotificationActions.class);
        }

        public final Intent timedMute(Context context, long guildId, long channelId, long untilTimestamp) {
            C12238m.checkNotNullParameter(context, "context");
            return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/channel/mute").buildUpon().appendQueryParameter("guildId", String.valueOf(guildId)).appendQueryParameter("channelId", String.valueOf(channelId)).appendQueryParameter("until", String.valueOf(untilTimestamp)).build(), context, NotificationActions.class);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void enqueueAckMessage(Context context, Intent intent) throws Throwable {
        Long longOrNull;
        Long longOrNull2;
        Uri data = intent.getData();
        if (data != null) {
            C12238m.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("channelId");
            if (queryParameter == null || (longOrNull = C12102s.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("messageId");
            if (queryParameter2 == null || (longOrNull2 = C12102s.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            C12238m.checkNotNullParameter(context, "context");
            Data dataBuild = new Data.Builder().putAll(C12136h0.mapOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue)), C12116o.m10073to("com.discord.intent.extra.EXTRA_MESSAGE_ID", Long.valueOf(jLongValue2)))).build();
            C12238m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(MessageAckWorker.class).setInputData(dataBuild).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.SECONDS).addTag("message").addTag("ack").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            C12238m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
            NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue, context, false, 4, null);
        }
    }

    private final void enqueueDirectReply(Context context, Intent intent) throws Throwable {
        String queryParameter;
        Long longOrNull;
        CharSequence charSequence;
        String string;
        Uri data = intent.getData();
        if (data == null || (queryParameter = data.getQueryParameter("channelId")) == null || (longOrNull = C12102s.toLongOrNull(queryParameter)) == null) {
            return;
        }
        long jLongValue = longOrNull.longValue();
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("com.discord.intent.extra.EXTRA_CHANNEL_NAME");
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null && (charSequence = resultsFromIntent.getCharSequence("discord_notif_text_input")) != null) {
            C12238m.checkNotNullExpressionValue(charSequence, "it");
            if (!(!C12103t.isBlank(charSequence))) {
                charSequence = null;
            }
            if (charSequence != null && (string = charSequence.toString()) != null) {
                NotificationCache.INSTANCE.setIgnoreNextClearForAck(jLongValue, true);
                C12238m.checkNotNullParameter(context, "context");
                C12238m.checkNotNullParameter(string, "message");
                Data.Builder builder = new Data.Builder();
                Pair[] pairArr = new Pair[5];
                pairArr[0] = C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue));
                pairArr[1] = C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_NAME", charSequenceExtra != null ? charSequenceExtra.toString() : null);
                pairArr[2] = C12116o.m10073to("com.discord.intent.extra.EXTRA_MESSAGE_ID", null);
                pairArr[3] = C12116o.m10073to("MESSAGE_CONTENT", string);
                pairArr[4] = C12116o.m10073to("com.discord.intent.extra.EXTRA_STICKER_ID", null);
                Data dataBuild = builder.putAll(C12136h0.mapOf(pairArr)).build();
                C12238m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
                OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(MessageSendWorker.class).setInputData(dataBuild).addTag("message").addTag("send").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
                C12238m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
                WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
                return;
            }
        }
        NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue, context, false, 4, null);
    }

    private final void enqueueTimedMute(Context context, Intent intent) throws Throwable {
        Long longOrNull;
        Long longOrNull2;
        Long longOrNull3;
        Uri data = intent.getData();
        if (data != null) {
            C12238m.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("guildId");
            if (queryParameter == null || (longOrNull = C12102s.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("channelId");
            if (queryParameter2 == null || (longOrNull2 = C12102s.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            String queryParameter3 = data.getQueryParameter("until");
            if (queryParameter3 == null || (longOrNull3 = C12102s.toLongOrNull(queryParameter3)) == null) {
                return;
            }
            long jLongValue3 = longOrNull3.longValue();
            C12238m.checkNotNullParameter(context, "context");
            Data dataBuild = new Data.Builder().putAll(C12136h0.mapOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(jLongValue)), C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue2)), C12116o.m10073to("com.discord.intent.extra.EXTRA_UNTIL_TIMESTAMP_MS", Long.valueOf(jLongValue3)))).build();
            C12238m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(TimedMuteWorker.class).setInputData(dataBuild).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.SECONDS).addTag("channel").addTag(ModelAuditLogEntry.CHANGE_KEY_MUTE).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            C12238m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
            NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue2, context, false, 4, null);
        }
    }

    @RequiresApi(24)
    private final void executeCallAction(Context context, Intent intent, boolean isAcceptingCall) throws Throwable {
        Long longOrNull;
        Long longOrNull2;
        Uri data = intent.getData();
        if (data != null) {
            C12238m.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("channelId");
            if (queryParameter == null || (longOrNull = C12102s.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("messageId");
            if (queryParameter2 == null || (longOrNull2 = C12102s.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            if (isAcceptingCall) {
                DiscordConnectService.INSTANCE.m8375b(context, jLongValue);
            } else {
                C12238m.checkNotNullParameter(context, "context");
                Data dataBuild = new Data.Builder().putAll(C12136h0.mapOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue)), C12116o.m10073to("com.discord.intent.extra.EXTRA_MESSAGE_ID", Long.valueOf(jLongValue2)))).build();
                C12238m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
                OneTimeWorkRequest.Builder inputData = new OneTimeWorkRequest.Builder(CallActionWorker.class).setInputData(dataBuild);
                BackoffPolicy backoffPolicy = BackoffPolicy.LINEAR;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                OneTimeWorkRequest oneTimeWorkRequestBuild = inputData.setBackoffCriteria(backoffPolicy, 1L, timeUnit).addTag(NotificationCompat.CATEGORY_CALL).addTag("decline").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setTriggerContentMaxDelay(10L, timeUnit).build()).build();
                C12238m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
                WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
            }
            NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue, context, false, 4, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @RequiresApi(24)
    public final void enqueue(Context context, Intent intent) throws Throwable {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(intent, "intent");
        Uri data = intent.getData();
        if (!C12238m.areEqual(data != null ? data.getAuthority() : null, "action")) {
            data = null;
        }
        if (data != null) {
            C12238m.checkNotNullExpressionValue(data, "intent.data.takeIf { it?…y == \"action\" } ?: return");
            String path = data.getPath();
            if (path != null) {
                switch (path.hashCode()) {
                    case -1030684332:
                        if (path.equals("/channel/mute")) {
                            enqueueTimedMute(context, intent);
                            return;
                        }
                        break;
                    case -581403885:
                        if (path.equals("/message/reply")) {
                            enqueueDirectReply(context, intent);
                            return;
                        }
                        break;
                    case 254025278:
                        if (path.equals("/channel/call/accept")) {
                            executeCallAction(context, intent, true);
                            return;
                        }
                        break;
                    case 897701618:
                        if (path.equals("/message/ack")) {
                            enqueueAckMessage(context, intent);
                            return;
                        }
                        break;
                    case 2004820096:
                        if (path.equals("/channel/call/decline")) {
                            executeCallAction(context, intent, false);
                            return;
                        }
                        break;
                }
            }
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("Unknown work action ");
            sbM833U.append(data.getPath());
            Logger.w$default(appLog, sbM833U.toString(), null, 2, null);
        }
    }

    @Override // android.content.BroadcastReceiver
    @RequiresApi(24)
    public void onReceive(Context context, Intent intent) throws Throwable {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(intent, "intent");
        AppLog.m8358i("Got notification action: " + intent);
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode == -1599864135) {
            if (action.equals("com.discord.intent.action.NOTIFICATION_CANCEL")) {
                AppLog.m8358i("Got notification cancel: " + intent);
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    NotificationManagerCompat.from(context).cancel(extras.getInt(NOTIFICATION_ID));
                    return;
                }
                return;
            }
            return;
        }
        if (iHashCode != -1350900838) {
            if (iHashCode == -26919171 && action.equals("com.discord.intent.action.ENQUEUE_WORK")) {
                enqueue(context, intent);
                return;
            }
            return;
        }
        if (action.equals("com.discord.intent.action.NOTIFICATION_DELETED")) {
            AppLog.m8358i("Got notification deleted: " + intent);
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                NotificationClient.clear$default(NotificationClient.INSTANCE, extras2.getLong(NOTIFICATION_CHANNEL_ID), context, false, 4, null);
            }
        }
    }
}
