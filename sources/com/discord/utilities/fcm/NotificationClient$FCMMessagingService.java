package com.discord.utilities.fcm;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.logging.Logger;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: compiled from: NotificationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationClient$FCMMessagingService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        m.checkNotNullParameter(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.k == null) {
            Bundle bundle = remoteMessage.j;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            remoteMessage.k = arrayMap;
        }
        Map<String, String> map = remoteMessage.k;
        m.checkNotNullExpressionValue(map, "remoteMessage.data");
        AppLog.i("Got notification: " + map);
        NotificationData notificationData = new NotificationData(map);
        NotificationClient$SettingsV2 settings$app_productionGoogleRelease = NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease();
        Iterator<Long> it = notificationData.getAckChannelIds().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            NotificationClient notificationClient = NotificationClient.INSTANCE;
            notificationClient.clear(jLongValue, NotificationClient.access$getContext$p(notificationClient), true);
        }
        NotificationClient notificationClient2 = NotificationClient.INSTANCE;
        Context contextAccess$getContext$p = NotificationClient.access$getContext$p(notificationClient2);
        if (contextAccess$getContext$p == null) {
            Logger.e$default(AppLog.g, "Not showing notification because context was null.", null, null, 6, null);
            return;
        }
        if (!notificationData.isValid() || !settings$app_productionGoogleRelease.getIsAuthed()) {
            if (m.areEqual(notificationData.getType(), NotificationData.TYPE_MESSAGE_CREATE)) {
                Logger.e$default(AppLog.g, "Not showing invalid notification", null, h0.mapOf(o.to("messageId", String.valueOf(notificationData.getMessageId())), o.to("channelId", String.valueOf(notificationData.getChannelId())), o.to("isAuthed", String.valueOf(settings$app_productionGoogleRelease.getIsAuthed())), o.to("type", notificationData.getType())), 2, null);
                return;
            }
            return;
        }
        if (m.areEqual(notificationData.getTrackingType(), NotificationClient.IGNORED_NOTIFICATION_TYPE)) {
            Pair[] pairArr = new Pair[5];
            String trackingType = notificationData.getTrackingType();
            if (trackingType == null) {
                trackingType = notificationData.getType();
            }
            pairArr[0] = o.to("notif_type", trackingType);
            pairArr[1] = o.to("notif_user_id", Long.valueOf(notificationData.getUserId()));
            pairArr[2] = o.to("message_id", Long.valueOf(notificationData.getMessageId()));
            pairArr[3] = o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(notificationData.getGuildId()));
            pairArr[4] = o.to("notification_id", notificationData.getNotificationId());
            AnalyticsTracker.INSTANCE.appNotificationDropped(CollectionExtensionsKt.filterNonNullValues(h0.mapOf(pairArr)));
            return;
        }
        if (notificationData.getChannelId() != -1) {
            NotificationCache.INSTANCE.setIgnoreNextClearForAck(notificationData.getChannelId(), false);
        }
        if (NotificationClient.access$isBackgrounded$p(notificationClient2) && settings$app_productionGoogleRelease.isEnabled()) {
            NotificationRenderer.INSTANCE.display(contextAccess$getContext$p, notificationData, settings$app_productionGoogleRelease);
        } else {
            if (NotificationClient.access$isBackgrounded$p(notificationClient2) || !settings$app_productionGoogleRelease.isEnabledInApp()) {
                return;
            }
            NotificationRenderer.INSTANCE.displayInApp(contextAccess$getContext$p, notificationData);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        m.checkNotNullParameter(token, "token");
        NotificationClient.INSTANCE.onNewToken(token);
    }
}
