package com.discord.utilities.intent;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$consumeExternalRoutingIntent$1 extends o implements Function2<Uri, Boolean, Unit> {
    public final /* synthetic */ Intent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntentUtils$consumeExternalRoutingIntent$1(Intent intent) {
        super(2);
        this.$intent = intent;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
        invoke(uri, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Uri uri, boolean z2) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        Map<String, Object> mapBuildTrackingData = NotificationClient.INSTANCE.buildTrackingData(this.$intent);
        Iterator<T> it = mapBuildTrackingData.keySet().iterator();
        while (it.hasNext()) {
            this.$intent.removeExtra((String) it.next());
        }
        AnalyticsTracker.appNotificationClicked(mapBuildTrackingData);
        AppStartAnalyticsTracker.Companion.getInstance().appOpen(uri, z2, !mapBuildTrackingData.isEmpty());
    }
}
