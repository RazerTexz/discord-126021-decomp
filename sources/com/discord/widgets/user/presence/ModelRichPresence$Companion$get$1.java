package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.utilities.presence.PresenceUtils;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: ModelRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelRichPresence$Companion$get$1<T, R> implements b<Presence, Observable<? extends ModelRichPresence>> {
    public static final ModelRichPresence$Companion$get$1 INSTANCE = new ModelRichPresence$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ModelRichPresence> call(Presence presence) {
        return call2(presence);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModelRichPresence> call2(Presence presence) {
        Long applicationId;
        if (presence == null) {
            return new k(null);
        }
        Activity primaryActivity = PresenceUtils.INSTANCE.getPrimaryActivity(presence);
        return (primaryActivity == null || (applicationId = primaryActivity.getApplicationId()) == null) ? new k(new ModelRichPresence(presence, null, 2, null)) : StoreStream.Companion.getApplication().observeApplication(Long.valueOf(applicationId.longValue())).G(new ModelRichPresence$Companion$get$1$$special$$inlined$let$lambda$1(presence));
    }
}
