package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1$1<T, R> implements b<Activity, Boolean> {
    public final /* synthetic */ ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1 this$0;

    public ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1$1(ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1 viewEmbedGameInvite$Model$Companion$getForShare$activityObs$1) {
        this.this$0 = viewEmbedGameInvite$Model$Companion$getForShare$activityObs$1;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Activity activity) {
        return call2(activity);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Activity activity) {
        boolean z2;
        if (activity == null) {
            z2 = false;
        } else {
            ActivityParty party = activity.getParty();
            if (m.areEqual(party != null ? party.getId() : null, this.this$0.$partyId)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return Boolean.valueOf(z2);
    }
}
