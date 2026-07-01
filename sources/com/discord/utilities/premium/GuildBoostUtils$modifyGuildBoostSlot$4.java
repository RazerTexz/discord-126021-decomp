package com.discord.utilities.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelSubscription;
import com.discord.restapi.RestAPIParams$UpdateSubscription;
import com.discord.utilities.rest.RestAPI;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: GuildBoostUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostUtils$modifyGuildBoostSlot$4<T, R> implements b<Boolean, Observable<? extends GuildBoostUtils$ModifyGuildBoostSlotResult>> {
    public final /* synthetic */ RestAPI $api;
    public final /* synthetic */ boolean $cancel;
    public final /* synthetic */ ModelSubscription $subscription;

    public GuildBoostUtils$modifyGuildBoostSlot$4(RestAPI restAPI, ModelSubscription modelSubscription, boolean z2) {
        this.$api = restAPI;
        this.$subscription = modelSubscription;
        this.$cancel = z2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildBoostUtils$ModifyGuildBoostSlotResult> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildBoostUtils$ModifyGuildBoostSlotResult> call2(Boolean bool) {
        if (bool.booleanValue()) {
            return this.$api.updateSubscription(this.$subscription.getId(), new RestAPIParams$UpdateSubscription(null, null, null, GuildBoostUtils.INSTANCE.calculateAdditionalPlansWithGuildBoostAdjustment(this.$subscription, this.$cancel ? -1 : 1), 7, null)).G(GuildBoostUtils$modifyGuildBoostSlot$4$1.INSTANCE).M(GuildBoostUtils$modifyGuildBoostSlot$4$2.INSTANCE);
        }
        return new k(GuildBoostUtils$ModifyGuildBoostSlotResult.FAILURE_MODIFYING_SLOT);
    }
}
