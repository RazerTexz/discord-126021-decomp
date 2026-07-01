package com.discord.utilities.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.StoreGuildBoost;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildBoostUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostUtils$modifyGuildBoostSlot$1<T> implements Action1<ModelGuildBoostSlot> {
    public final /* synthetic */ StoreGuildBoost $storeGuildBoost;

    public GuildBoostUtils$modifyGuildBoostSlot$1(StoreGuildBoost storeGuildBoost) {
        this.$storeGuildBoost = storeGuildBoost;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(ModelGuildBoostSlot modelGuildBoostSlot) {
        call2(modelGuildBoostSlot);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(ModelGuildBoostSlot modelGuildBoostSlot) {
        StoreGuildBoost storeGuildBoost = this.$storeGuildBoost;
        m.checkNotNullExpressionValue(modelGuildBoostSlot, "it");
        storeGuildBoost.updateGuildBoostSlot(modelGuildBoostSlot);
    }
}
