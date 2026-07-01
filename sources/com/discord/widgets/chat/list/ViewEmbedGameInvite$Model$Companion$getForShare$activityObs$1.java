package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1<T, R> implements b<Long, Observable<? extends Activity>> {
    public final /* synthetic */ Long $applicationId;
    public final /* synthetic */ String $partyId;

    public ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1(Long l, String str) {
        this.$applicationId = l;
        this.$partyId = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Activity> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Activity> call2(Long l) {
        StoreUserPresence presences = StoreStream.Companion.getPresences();
        m.checkNotNullExpressionValue(l, "authorId");
        return presences.observeApplicationActivity(l.longValue(), this.$applicationId.longValue()).y(new ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1$1(this));
    }
}
