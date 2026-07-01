package com.discord.utilities.analytics;

import android.app.Application;
import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.device.RtcCameraConfig;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils {
    public static final AnalyticsUtils INSTANCE = new AnalyticsUtils();
    private static FirebaseAnalytics fireBaseInstance;

    private AnalyticsUtils() {
    }

    public static final /* synthetic */ FirebaseAnalytics access$getFireBaseInstance$p(AnalyticsUtils analyticsUtils) {
        return fireBaseInstance;
    }

    public static final /* synthetic */ void access$setFireBaseInstance$p(AnalyticsUtils analyticsUtils, FirebaseAnalytics firebaseAnalytics) {
        fireBaseInstance = firebaseAnalytics;
    }

    public final Map<String, Object> getProperties$app_productionGoogleRelease(Channel channel) {
        m.checkNotNullParameter(channel, "$this$properties");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        pairArr[1] = o.to("channel_type", Integer.valueOf(channel.getType()));
        List<User> listZ = channel.z();
        pairArr[2] = o.to("channel_size_total", Integer.valueOf(listZ != null ? listZ.size() : 0));
        return h0.mapOf(pairArr);
    }

    @MainThread
    public final void initAppOpen(Application context) {
        m.checkNotNullParameter(context, "context");
        if (fireBaseInstance != null) {
            return;
        }
        fireBaseInstance = FirebaseAnalytics.getInstance(context);
        ObservableExtensionsKt.appSubscribe$default(StoreStream.Companion.getUsers().observeMe(true), AnalyticsUtils.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnalyticsUtils$initAppOpen$1.INSTANCE, 62, (Object) null);
        RtcCameraConfig.INSTANCE.init();
    }

    public final Map<String, String> getProperties$app_productionGoogleRelease(RtcConnection rtcConnection) {
        m.checkNotNullParameter(rtcConnection, "$this$properties");
        return g0.mapOf(o.to("rtc_connection_id", rtcConnection.id));
    }
}
