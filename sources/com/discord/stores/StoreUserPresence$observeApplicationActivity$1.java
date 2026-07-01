package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.models.presence.Presence;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreUserPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserPresence$observeApplicationActivity$1<T, R> implements b<Presence, Activity> {
    public final /* synthetic */ long $applicationId;

    public StoreUserPresence$observeApplicationActivity$1(long j) {
        this.$applicationId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Activity call(Presence presence) {
        return call2(presence);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Activity call2(Presence presence) {
        List<Activity> activities;
        Activity activity = null;
        if (presence == null || (activities = presence.getActivities()) == null) {
            return null;
        }
        for (T t : activities) {
            Long applicationId = ((Activity) t).getApplicationId();
            if (applicationId != null && applicationId.longValue() == this.$applicationId) {
                activity = t;
                break;
            }
        }
        return activity;
    }
}
