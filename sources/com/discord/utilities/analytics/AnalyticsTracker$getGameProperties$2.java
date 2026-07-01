package com.discord.utilities.analytics;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.presence.ActivityUtilsKt;
import d0.o;
import d0.t.h0;
import j0.k.b;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$getGameProperties$2<T, R> implements b<Activity, Map<String, Object>> {
    public static final AnalyticsTracker$getGameProperties$2 INSTANCE = new AnalyticsTracker$getGameProperties$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<String, Object> call(Activity activity) {
        return call2(activity);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<String, Object> call2(Activity activity) {
        Pair[] pairArr = new Pair[3];
        pairArr[0] = o.to("game_platform", activity != null ? ActivityUtilsKt.getGamePlatform(activity) : null);
        pairArr[1] = o.to("game_name", activity != null ? activity.getName() : null);
        pairArr[2] = o.to("game_id", activity != null ? activity.getApplicationId() : null);
        return CollectionExtensionsKt.filterNonNullValues(h0.mapOf(pairArr));
    }
}
