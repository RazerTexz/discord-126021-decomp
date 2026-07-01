package com.discord.utilities.analytics;

import com.discord.api.activity.Activity;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.PresenceUtils;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$getGameProperties$1<T1, T2, R> implements Func2<Presence, Presence, Activity> {
    public static final AnalyticsTracker$getGameProperties$1 INSTANCE = new AnalyticsTracker$getGameProperties$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Activity call(Presence presence, Presence presence2) {
        return invoke(presence, presence2);
    }

    public final Activity invoke(Presence presence, Presence presence2) {
        PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
        m.checkNotNullExpressionValue(presence, "localPresence");
        Activity playingActivity = presenceUtils.getPlayingActivity(presence);
        if (playingActivity != null) {
            return playingActivity;
        }
        m.checkNotNullExpressionValue(presence2, "externalPresence");
        return presenceUtils.getPlayingActivity(presence2);
    }
}
