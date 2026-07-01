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
import androidx.work.Constraints$Builder;
import androidx.work.Data;
import androidx.work.Data$Builder;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OneTimeWorkRequest$Builder;
import androidx.work.WorkManager;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.app.DiscordConnectService;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.workers.CallActionWorker;
import com.discord.workers.MessageAckWorker;
import com.discord.workers.MessageSendWorker;
import com.discord.workers.TimedMuteWorker;
import d0.g0.s;
import d0.g0.t;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;

/* JADX INFO: compiled from: NotificationActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationActions extends BroadcastReceiver {
    public static final NotificationActions$Companion Companion = new NotificationActions$Companion(null);
    private static final String NOTIFICATION_CHANNEL_ID = "com.discord.NOTIFICATION_DELETED_CHANNEL_ID";
    private static final String NOTIFICATION_ID = "com.discord.NOTIFICATION_ID";

    private final void enqueueAckMessage(Context context, Intent intent) throws Throwable {
        Long longOrNull;
        Long longOrNull2;
        Uri data = intent.getData();
        if (data != null) {
            m.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("channelId");
            if (queryParameter == null || (longOrNull = s.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("messageId");
            if (queryParameter2 == null || (longOrNull2 = s.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            m.checkNotNullParameter(context, "context");
            Data dataBuild = new Data$Builder().putAll(h0.mapOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue)), o.to("com.discord.intent.extra.EXTRA_MESSAGE_ID", Long.valueOf(jLongValue2)))).build();
            m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest$Builder(MessageAckWorker.class).setInputData(dataBuild).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.SECONDS).addTag("message").addTag("ack").setConstraints(new Constraints$Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
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
        if (data == null || (queryParameter = data.getQueryParameter("channelId")) == null || (longOrNull = s.toLongOrNull(queryParameter)) == null) {
            return;
        }
        long jLongValue = longOrNull.longValue();
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("com.discord.intent.extra.EXTRA_CHANNEL_NAME");
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null && (charSequence = resultsFromIntent.getCharSequence("discord_notif_text_input")) != null) {
            m.checkNotNullExpressionValue(charSequence, "it");
            if (!(!t.isBlank(charSequence))) {
                charSequence = null;
            }
            if (charSequence != null && (string = charSequence.toString()) != null) {
                NotificationCache.INSTANCE.setIgnoreNextClearForAck(jLongValue, true);
                m.checkNotNullParameter(context, "context");
                m.checkNotNullParameter(string, "message");
                Data$Builder data$Builder = new Data$Builder();
                Pair[] pairArr = new Pair[5];
                pairArr[0] = o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue));
                pairArr[1] = o.to("com.discord.intent.extra.EXTRA_CHANNEL_NAME", charSequenceExtra != null ? charSequenceExtra.toString() : null);
                pairArr[2] = o.to("com.discord.intent.extra.EXTRA_MESSAGE_ID", null);
                pairArr[3] = o.to("MESSAGE_CONTENT", string);
                pairArr[4] = o.to("com.discord.intent.extra.EXTRA_STICKER_ID", null);
                Data dataBuild = data$Builder.putAll(h0.mapOf(pairArr)).build();
                m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
                OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest$Builder(MessageSendWorker.class).setInputData(dataBuild).addTag("message").addTag("send").setConstraints(new Constraints$Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
                m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
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
            m.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("guildId");
            if (queryParameter == null || (longOrNull = s.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("channelId");
            if (queryParameter2 == null || (longOrNull2 = s.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            String queryParameter3 = data.getQueryParameter("until");
            if (queryParameter3 == null || (longOrNull3 = s.toLongOrNull(queryParameter3)) == null) {
                return;
            }
            long jLongValue3 = longOrNull3.longValue();
            m.checkNotNullParameter(context, "context");
            Data dataBuild = new Data$Builder().putAll(h0.mapOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(jLongValue)), o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue2)), o.to("com.discord.intent.extra.EXTRA_UNTIL_TIMESTAMP_MS", Long.valueOf(jLongValue3)))).build();
            m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest$Builder(TimedMuteWorker.class).setInputData(dataBuild).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.SECONDS).addTag("channel").addTag(ModelAuditLogEntry.CHANGE_KEY_MUTE).setConstraints(new Constraints$Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
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
            m.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("channelId");
            if (queryParameter == null || (longOrNull = s.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("messageId");
            if (queryParameter2 == null || (longOrNull2 = s.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            if (isAcceptingCall) {
                DiscordConnectService.j.b(context, jLongValue);
            } else {
                m.checkNotNullParameter(context, "context");
                Data dataBuild = new Data$Builder().putAll(h0.mapOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue)), o.to("com.discord.intent.extra.EXTRA_MESSAGE_ID", Long.valueOf(jLongValue2)))).build();
                m.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
                OneTimeWorkRequest$Builder inputData = new OneTimeWorkRequest$Builder(CallActionWorker.class).setInputData(dataBuild);
                BackoffPolicy backoffPolicy = BackoffPolicy.LINEAR;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                OneTimeWorkRequest oneTimeWorkRequestBuild = inputData.setBackoffCriteria(backoffPolicy, 1L, timeUnit).addTag(NotificationCompat.CATEGORY_CALL).addTag("decline").setConstraints(new Constraints$Builder().setRequiredNetworkType(NetworkType.CONNECTED).setTriggerContentMaxDelay(10L, timeUnit).build()).build();
                m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
                WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
            }
            NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue, context, false, 4, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @RequiresApi(24)
    public final void enqueue(Context context, Intent intent) throws Throwable {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(intent, "intent");
        Uri data = intent.getData();
        if (!m.areEqual(data != null ? data.getAuthority() : null, "action")) {
            data = null;
        }
        if (data != null) {
            m.checkNotNullExpressionValue(data, "intent.data.takeIf { it?…y == \"action\" } ?: return");
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
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("Unknown work action ");
            sbU.append(data.getPath());
            Logger.w$default(appLog, sbU.toString(), null, 2, null);
        }
    }

    @Override // android.content.BroadcastReceiver
    @RequiresApi(24)
    public void onReceive(Context context, Intent intent) throws Throwable {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(intent, "intent");
        AppLog.i("Got notification action: " + intent);
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode == -1599864135) {
            if (action.equals("com.discord.intent.action.NOTIFICATION_CANCEL")) {
                AppLog.i("Got notification cancel: " + intent);
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
            AppLog.i("Got notification deleted: " + intent);
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                NotificationClient.clear$default(NotificationClient.INSTANCE, extras2.getLong(NOTIFICATION_CHANNEL_ID), context, false, 4, null);
            }
        }
    }
}
